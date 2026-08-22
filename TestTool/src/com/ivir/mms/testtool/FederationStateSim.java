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
import devstudio.generatedcode.HlaFederationState;
import devstudio.generatedcode.HlaFederationStateAttributes;
import devstudio.generatedcode.HlaFederationStateListener;
import devstudio.generatedcode.HlaFederationStateManager;
import devstudio.generatedcode.HlaFederationStateUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.FederationStateEnum;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 */
public class FederationStateSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(FederationStateSim.class);
    private final HashMap<String,FederationState> fedStateMap = new HashMap<>();
    private HlaFederationStateManager fedStateManager = null;
    private String currentInstance = null;    
    
    public FederationStateSim(){
       logger.info("Starting FederationStateSim");
       fedStateManager = MmsFederate.getHlaWorld().getHlaFederationStateManager();
       fedStateManager.addHlaFederationStateDefaultInstanceListener(new FederationStateSim.FederationStateUpdateListener());
    }
    
    public void updateState(String state){
        HlaFederationState hlaFedState = null;
        
        if(this.currentInstance != null){
            hlaFedState = fedStateManager.getFederationStateByHlaInstanceName(this.currentInstance);
        }else{
            try {
                hlaFedState = fedStateManager.createLocalHlaFederationState();
            } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
                java.util.logging.Logger.getLogger(FederationStateSim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(hlaFedState == null){
            logger.warn("Could not get or create a FederationState");
            return;
        }
        
        try {
            HlaFederationStateUpdater updater = hlaFedState.getHlaFederationStateUpdater();
            
            if(state != null){
                updater.setState(FederationStateEnum.valueOf(state));
            }
            
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaObjectInstanceIsRemovedException ex) {
            logger.error("Failed to create new FederationState",ex);
        }

    }
    
    public class FederationStateUpdateListener implements HlaFederationStateListener{

        @Override
        public void attributesUpdated(HlaFederationState hlaFedState, Set<HlaFederationStateAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            boolean isNewEvent = false;
            FederationState fedState = fedStateMap.get(hlaFedState.getHlaInstanceName());
            if(fedState == null){
                //first instance
                fedState = new FederationState();
                fedState.setInstanceName(hlaFedState.getHlaInstanceName());
                fedState.setGhosted(!hlaFedState.isLocal());
                isNewEvent = true;
            }
        
            for(HlaFederationStateAttributes.Attribute attribute : attributes){
                switch(attribute){
                    case STATE: fedState.setState(hlaFedState.getState().toString());
                        break;
                }
            }
            currentInstance = fedState.getInstanceName();
            if(isNewEvent){
                fedStateMap.put(fedState.getInstanceName(), fedState);
            }
            UiUpdateHandler.getUiUpdateHandler().updateFederationState(fedState.getState());
        }
    }

    @Override
    public void hlaDisconnected(){
	fedStateMap.clear();
	currentInstance = null;
        UiUpdateHandler.getUiUpdateHandler().updateFederationState("");
    }
}
