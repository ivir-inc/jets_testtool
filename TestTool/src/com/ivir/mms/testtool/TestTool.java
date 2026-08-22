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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 */
public class TestTool {
     private static final Logger logger = LogManager.getLogger(TestTool.class);
     private MmsFederate federate = null;
     
    public static void main(String args[]){
        new TestTool().setupFederate().startUi();
    }
    
    public TestTool setupFederate(){
        federate = new MmsFederate();
        UiCommandHandler.getUiCommandHandler().setMmsFederate(federate);
        return this;
    }
        
    public void startUi(){
        logger.info("Starting UI");
        TestToolUI testToolUI = new TestToolUI();

        UiUpdateHandler guiUpdates = UiUpdateHandler.getUiUpdateHandler();
        guiUpdates.setTestToolUI(testToolUI);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               testToolUI.setVisible(true);
               logger.info("UI started");
            }
        });

    }

    public MmsFederate getFederate() {
        return federate;
    }

    public void setFederate(MmsFederate federate) {
        this.federate = federate;
    }
    
    
}
