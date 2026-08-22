/*
 * Copyright 2026 IVIR Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ivir.mms.testtool;

import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaNeurologicalScales;
import devstudio.generatedcode.HlaNeurologicalScalesAttributes;
import devstudio.generatedcode.HlaNeurologicalScalesListener;
import devstudio.generatedcode.HlaNeurologicalScalesManager;
import devstudio.generatedcode.HlaNeurologicalScalesUpdater;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.GlasgowComaScaleRecord;
import devstudio.generatedcode.datatypes.LevelOfConsciousnessEnum;
import devstudio.generatedcode.datatypes.LevelOfResponseEnum;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NeuroScalesSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(NeuroScalesSim.class);
    private final HlaNeurologicalScalesManager hlaManager;
    private final ConcurrentHashMap<String,HlaNeurologicalScales> patientIdToHlaObjectMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String,HlaNeurologicalScales> instanceToHlaObjectMap = new ConcurrentHashMap<>();
    
    public NeuroScalesSim(){
        hlaManager = MmsFederate.getHlaWorld().getHlaNeurologicalScalesManager();
        hlaManager.addHlaNeurologicalScalesDefaultInstanceListener(new NeurologicalScalesListener());
    }
    
    public void updateNeuroScales(String instanceId, String patientId, 
            Integer eyesScale, Integer verbalScale, Integer motorScale, 
            String levelOfResponse, String levelOfConsciousness){
        HlaNeurologicalScales objToUpdate = this.instanceToHlaObjectMap.get(instanceId);
        updateNeuroScales(objToUpdate, patientId, eyesScale, verbalScale, 
                motorScale, levelOfResponse, levelOfConsciousness);
    }
    
    public void updateNeuroScales(HlaNeurologicalScales objToUpdate, String patientId, 
            Integer eyesScale, Integer verbalScale, Integer motorScale, 
            String levelOfResponse, String levelOfConsciousness){
        HlaNeurologicalScalesUpdater  updater = objToUpdate.getHlaNeurologicalScalesUpdater();
      
        toGlasgowComaScaleRecord(eyesScale, verbalScale, motorScale).ifPresent((record)->{
            updater.setGlasgowComaScale(record);
        });

        if(levelOfResponse != null){
            updater.setLevelOfResponse(LevelOfResponseEnum.valueOf(levelOfResponse));
        }
        
        if(levelOfConsciousness != null){
            updater.setLevelOfConsciousness(LevelOfConsciousnessEnum.valueOf(levelOfConsciousness));
        }
        
        if(patientId != null){
            updater.setPatientId(patientId);
        }
        
        try {
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error("failed to update neurological scales object", ex);
        }
        
    }
    
    private Optional<GlasgowComaScaleRecord> toGlasgowComaScaleRecord(
            Integer eyesScale, Integer verbalScale, Integer motorScale){
        if(eyesScale == null){
            logger.error("Eyes scale cannot be null");
            return Optional.empty();
        }
        
        if(verbalScale == null){
            logger.error("Verbal scale cannot be null");
            return Optional.empty();
        }
        
        if(motorScale == null){
            logger.error("Motor scale cannot be null");
            return Optional.empty();
        }
        return Optional.ofNullable(GlasgowComaScaleRecord
                .create(eyesScale, verbalScale, motorScale));        
    }

    public void createNeuroScales(String patientId, Integer eyesScale, 
            Integer verbalScale, Integer motorScale, String levelOfResponse, 
            String levelOfConsciousness){
        try {
            HlaNeurologicalScales neuroScales = hlaManager.createLocalHlaNeurologicalScales();
            updateNeuroScales(neuroScales, patientId, eyesScale, verbalScale, 
                    motorScale, levelOfResponse, levelOfConsciousness);
        } catch (HlaNotConnectedException | HlaInternalException 
                | HlaRtiException | HlaSaveInProgressException 
                | HlaRestoreInProgressException ex) {
            logger.error("can't create new neuro sclaes obj", ex);
        }
    }
    
        public void createNeuroScales(NeurologicalScales neuroScales){
        try {
            HlaNeurologicalScales hlaNeuroScales = hlaManager.createLocalHlaNeurologicalScales();
            updateNeuroScales(hlaNeuroScales, neuroScales.getPatientId(), 
                    neuroScales.getEyesScale(), neuroScales.getVerbalScale(), 
                    neuroScales.getMotorScale(), neuroScales.getLevelofResponse(), 
                    neuroScales.getLevelOfConsciousness());
        } catch (HlaNotConnectedException | HlaInternalException 
                | HlaRtiException | HlaSaveInProgressException 
                | HlaRestoreInProgressException ex) {
            logger.error("can't create new neuro sclaes obj", ex);
        }
    }
    
    private class NeurologicalScalesListener implements HlaNeurologicalScalesListener{

        @Override
        public void attributesUpdated(HlaNeurologicalScales neurologicalScales, 
                Set<HlaNeurologicalScalesAttributes.Attribute> attributes, 
                HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            System.out.println("neuro got it");
            System.out.println(neurologicalScales);
            String instanceName = neurologicalScales.getHlaInstanceName();
            if(instanceToHlaObjectMap.get(instanceName) == null){
                //first time we have seen this object
                UiUpdateHandler.getUiUpdateHandler().newNeuroScales(neurologicalScales);
            }
            instanceToHlaObjectMap.put(instanceName, neurologicalScales);
            if(neurologicalScales.hasPatientId()){
                patientIdToHlaObjectMap.put(neurologicalScales.getPatientId(), 
                        neurologicalScales);
            }
            UiUpdateHandler.getUiUpdateHandler().neuroScalesDataChanged();
        }
    }

    @Override    
    public void hlaDisconnected(){
    	patientIdToHlaObjectMap.clear();
    	instanceToHlaObjectMap.clear();
        UiUpdateHandler.getUiUpdateHandler().clearNeuroScales();
        UiUpdateHandler.getUiUpdateHandler().neuroScalesDataChanged();
    }
}
