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

import devstudio.generatedcode.HlaInjury;
import devstudio.generatedcode.HlaInjuryAttributes;
import devstudio.generatedcode.HlaInjuryListener;
import devstudio.generatedcode.HlaInjuryManager;
import devstudio.generatedcode.HlaInjuryUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.InjuryDescriptionEnum;
import devstudio.generatedcode.datatypes.InjuryTypeEnum;
import devstudio.generatedcode.datatypes.MechanismOfInjuryRecord;
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
public class InjuryDataSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(InjuryDataSim.class);
    private HlaInjuryManager injuryManager;
    private ConcurrentHashMap<String,InjuryDataContainer> instanceToContainerMap = new ConcurrentHashMap<>();
    
    public InjuryDataSim(){
        this.injuryManager = MmsFederate.getHlaWorld().getHlaInjuryManager();
        HlaInjuryListener listener = new InjuryListener();
        this.injuryManager.addHlaInjuryDefaultInstanceListener(listener);
    }

    
    public void createInjury(String patientId, String injuryId, Long time,
            BodyLocationRecord bodyLocationRecord, InjuryTypeEnum injuryType, InjuryDescriptionEnum description, 
            String injuryDetail, Integer severity, MechanismOfInjuryRecord mechanismOfInjury, Float hemorrhageRate, Float totalBodySurfaceArea) {
        try{
            HlaInjury injury = injuryManager.createLocalHlaInjury();
            HlaInjuryUpdater updater = injury.getHlaInjuryUpdater();
                    
            if(patientId != null){
                updater.setPatientId(patientId);
            }
            if(injuryId != null){
                updater.setInjuryId(injuryId);
            }
            if(time != null){
                updater.setTime(time);
            }
            if(bodyLocationRecord != null){
                updater.setInjuryLocation(bodyLocationRecord );
            }
            if(description != null){
                updater.setInjuryDescription(description);
            }
            if(injuryType != null){
                updater.setInjuryType(injuryType);
            }
            if(injuryDetail != null) {
                updater.setInjuryDetail(injuryDetail);
            }
            if(severity != null){
                updater.setInjurySeverity(severity);
            }
            if(mechanismOfInjury != null){
                updater.setMechanismOfInjury(mechanismOfInjury);
            }
            if(hemorrhageRate != null){
                updater.setHemorrhageRate(hemorrhageRate);
            }
            if(totalBodySurfaceArea != null){
                updater.setTotalBodySurfaceArea(totalBodySurfaceArea);
            }
            
            updater.sendUpdate();
            logger.info("HlaInjury created");
            
        } catch (HlaNotConnectedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException | HlaAttributeNotOwnedException ex) {
            logger.error(ex);
        }
    }
        
    private class InjuryListener implements HlaInjuryListener {

        @Override
        public void attributesUpdated(HlaInjury injury, Set<HlaInjuryAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            logger.info("HlaInjury update received");
            InjuryDataContainer container = new InjuryDataContainer(injury);
            instanceToContainerMap.put(container.getInstanceKey(), container);
            UiUpdateHandler.getUiUpdateHandler().newInjuryData(container);
        }
        
    }

    @Override
    public void hlaDisconnected(){
	instanceToContainerMap.clear();
        UiUpdateHandler.getUiUpdateHandler().clearInjuryData();
    }
    
}
