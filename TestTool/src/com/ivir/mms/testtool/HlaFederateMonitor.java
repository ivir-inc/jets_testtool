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

import devstudio.generatedcode.HlaHLAfederate;
import devstudio.generatedcode.HlaHLAfederateManager;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * Currently with Portico, we cannot used the federation listener or the federate listener
 * For right now, this monitor periodically polls the HlaFederateManager instead
 */
public class HlaFederateMonitor {
    private static final Logger logger = LogManager.getLogger(HlaFederateMonitor.class);
    private HlaHLAfederateManager federateManager = null;
    private Timer updateTimer = null;
    
    public HlaFederateMonitor(HlaHLAfederateManager hlaFederateManager){
        this.federateManager = hlaFederateManager;
    }
    
    public void start(){
        if(this.updateTimer == null){
            this.updateTimer = new Timer("Federation List Check");
            this.updateTimer.schedule(new FederationListTimerTask(), 0, 1000);
        }
    }
    
    public void stop(){
        if(this.updateTimer != null){
            this.updateTimer.cancel();
            this.updateTimer.purge();
            this.updateTimer = null;
        }
    }
    
    private class FederationListTimerTask extends TimerTask{

        @Override
        public void run() {
            //Portico causes an exception if the the getNames is called while
            //a federate is joining.
            //devstudio.generatedcode.exceptions.HlaValueNotSetException: Attribute 
            //'hLAfederateName' not set for instance MOM.Federate(MMSControl)
            //The try/catch addresses this issue by skipping this attempt
            try{
                String fedList = "";
                for(HlaHLAfederate federate : federateManager.getAllHlaHLAfederates()){   
                    fedList += federate.getHLAfederateName() + "\n";
                }
                UiUpdateHandler.getUiUpdateHandler().updateFederateList(fedList);
            }catch(Exception e){
                logger.warn("Failed to get fedearate list.  Will try again later.");
            }
        }
    
    }
}
