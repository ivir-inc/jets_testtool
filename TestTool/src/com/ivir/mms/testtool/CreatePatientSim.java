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

import devstudio.generatedcode.HlaCreatePatient;
import devstudio.generatedcode.HlaCreatePatientAttributes;
import devstudio.generatedcode.HlaCreatePatientListener;
import devstudio.generatedcode.HlaCreatePatientManager;
import devstudio.generatedcode.HlaCreatePatientUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class CreatePatientSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(CreatePatientSim.class);
    private final HashMap<String,CreatePatient> createPatientMap = new HashMap<>();
    private HlaCreatePatientManager createPatientManager = null;
    
    public CreatePatientSim(){
       logger.info("Starting CreatePatientSim");
       createPatientManager = MmsFederate.getHlaWorld().getHlaCreatePatientManager();
       createPatientManager.addHlaCreatePatientDefaultInstanceListener(new CreatePatientSim.CreatePatientUpdateListener());
    }
    
    
    public void createCreatePatient(CreatePatient cPatient){
        try{
            HlaCreatePatient hlaCp = createPatientManager.createLocalHlaCreatePatient();
            HlaCreatePatientUpdater updater = hlaCp.getHlaCreatePatientUpdater();
            
            if(cPatient.getPatientId() != null){
                updater.setPatientId( cPatient.getPatientId());
            }
            
            if(cPatient.getTarget() != null){
                updater.setTarget(cPatient.getTarget());
            }
            updater.sendUpdate();
        }catch(Exception ex){
            java.util.logging.Logger.getLogger(CreatePatientSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CreatePatient getCreatePatient(String patientId){
        return this.createPatientMap.get(patientId);
    }
    
    private class CreatePatientUpdateListener implements HlaCreatePatientListener{

        @Override
        public void attributesUpdated(HlaCreatePatient hlaCreatePatient, Set<HlaCreatePatientAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            CreatePatient cpatient = createPatientMap.get(hlaCreatePatient.getPatientId("unknown"));
            boolean newCPatient = false;
            if(cpatient == null){
                cpatient = new CreatePatient();
                cpatient.setInstanceName(hlaCreatePatient.getHlaInstanceName());
                cpatient.setGhosted(!hlaCreatePatient.isLocal());
                cpatient.setPatientId(hlaCreatePatient.getPatientId("unknown"));
                newCPatient = true;
            }
            
            for(HlaCreatePatientAttributes.Attribute attribute : attributes){
                switch(attribute){
                    case PATIENT_ID: /** already added above **/ ;
                        break;
                    case TARGET: cpatient.setTarget(hlaCreatePatient.getTarget());
                        break;
                }
            }
            
            createPatientMap.put(cpatient.getPatientId(), cpatient);
            if(newCPatient){
                UiUpdateHandler.getUiUpdateHandler().addToCreatePatientList(cpatient);
            }
        }
    
    } 

    @Override    
    public void hlaDisconnected(){
	createPatientMap.clear();
	UiUpdateHandler.getUiUpdateHandler().clearCreatePatientList();
    }
}
