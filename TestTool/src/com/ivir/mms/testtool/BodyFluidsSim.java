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

import devstudio.generatedcode.HlaBodyFluids;
import devstudio.generatedcode.HlaBodyFluidsAttributes;
import devstudio.generatedcode.HlaBodyFluidsListener;
import devstudio.generatedcode.HlaBodyFluidsManager;
import devstudio.generatedcode.HlaBodyFluidsUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class BodyFluidsSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(BodyFluidsSim.class);
    private final HlaBodyFluidsManager hlaManager;
    private final ConcurrentHashMap<String,HlaBodyFluids> patientIdToHlaObjectMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,HlaBodyFluids> instanceToHlaObjectMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,BodyFluidsChangeThread> updaterMap = new ConcurrentHashMap<>();
    
    public BodyFluidsSim(){
        hlaManager = MmsFederate.getHlaWorld().getHlaBodyFluidsManager();
        hlaManager.addHlaBodyFluidsDefaultInstanceListener(new BodyFluidsListener());
    }
        
    public void updateBodyFluids(String instanceId, String patientId, 
            Float bloodLossRate, Float bloodVolume, 
            Float sweatRate, Float urineOutput){
        HlaBodyFluids objToUpdate = this.instanceToHlaObjectMap.get(instanceId);
        updateBodyFluids(objToUpdate, patientId, bloodLossRate, bloodVolume, sweatRate, urineOutput);
    }
    
    public void updateBodyFluids(HlaBodyFluids objToUpdate, String patientId, 
            Float bloodLossRate, Float bloodVolume, 
            Float sweatRate, Float urineOutput){
        HlaBodyFluidsUpdater  updater = objToUpdate.getHlaBodyFluidsUpdater();
        if(bloodLossRate != null){
            updater.setBloodLossRate(bloodLossRate);
        }
        if(bloodVolume != null){
            updater.setBloodVolume(bloodVolume);
        }
        if(patientId != null){
            updater.setPatientId(patientId);
        }
        if(sweatRate != null){
            updater.setSweatRate(sweatRate);
        }
        if(urineOutput != null){
         updater.setUrineOutputRate(urineOutput);
        }
        try {
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error("failed to update fluids object", ex);
        }
        
    }
    
    public void createBodyFluids(String patientId, Float bloodLossRate, Float bloodVolume, 
            Float sweatRate, Float urineOutput){
        try {
            HlaBodyFluids bodyFluids = hlaManager.createLocalHlaBodyFluids();
            updateBodyFluids(bodyFluids,patientId, bloodLossRate, bloodVolume, sweatRate, urineOutput);      
        } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error("can't create new body fluids obj", ex);
        }
    }
    
        public void createBodyFluids(BodyFluids bodyFluids){
        try {
            HlaBodyFluids hlaBodyFluids = hlaManager.createLocalHlaBodyFluids();
            updateBodyFluids(hlaBodyFluids,bodyFluids.getPatientId(), 
                    bodyFluids.getBloodFloss(), bodyFluids.getBloodVolume(), 
                    bodyFluids.getSweatOutput(), bodyFluids.getUrineOutput());      
        } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error("can't create new body fluids obj", ex);
        }
    }
    
    private class BodyFluidsListener implements HlaBodyFluidsListener{

        @Override
        public void attributesUpdated(HlaBodyFluids bodyFluids, Set<HlaBodyFluidsAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            System.out.println("got body fluids");
            System.out.println(bodyFluids);
            
            String instanceName = bodyFluids.getHlaInstanceName();
            if(instanceToHlaObjectMap.get(instanceName) == null){
                //first time we have seen this object
                UiUpdateHandler.getUiUpdateHandler().newBodyFluids(bodyFluids);
            }
            instanceToHlaObjectMap.put(instanceName, bodyFluids);
            if(bodyFluids.hasPatientId()){
                patientIdToHlaObjectMap.put(bodyFluids.getPatientId(), bodyFluids);
            }
            UiUpdateHandler.getUiUpdateHandler().bodyFluidsDataChanged();
        }
    }

    public void modifyUpdater(boolean start, String instanceId, 
            BodyFluidsChangeAttribute attributeEnum, Float unitIncrement, Integer duration){
        BodyFluidsChangeThread changeThread = updaterMap.get(instanceId + attributeEnum.toString());
        if(changeThread != null){
            changeThread.stopUpdater();
        }
        if(start){
            changeThread = new BodyFluidsChangeThread(this.instanceToHlaObjectMap, instanceId, attributeEnum, unitIncrement, duration);
            this.updaterMap.put(instanceId + attributeEnum.toString(), changeThread);
            new Thread(changeThread).start();
        }
    }

    @Override
    public void hlaDisconnected(){
	    logger.debug("Stopping all update threads");
	    updaterMap.forEach((key,updater)->{
	    	updater.stopUpdater();
		});
	    patientIdToHlaObjectMap.clear();
    	    instanceToHlaObjectMap.clear();
    	    updaterMap.clear();
	    UiUpdateHandler.getUiUpdateHandler().clearBodyFluids();
	    UiUpdateHandler.getUiUpdateHandler().bodyFluidsDataChanged();
    }

}
