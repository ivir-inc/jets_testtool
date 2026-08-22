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

import devstudio.generatedcode.HlaDataLog;
import devstudio.generatedcode.HlaDataLogAttributes;
import devstudio.generatedcode.HlaDataLogManager;
import devstudio.generatedcode.HlaDataLogListener;
import devstudio.generatedcode.HlaDataLogUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class DataLogSim implements DisconnectListener{
    private HlaDataLogManager dataLogManager = null;
    private static final Logger logger = LogManager.getLogger(DataLogSim.class);
    private String focusedInstanceName = null;
    private HashMap<String,DataLog> dataLogMap = new HashMap<>();
    
    public DataLogSim(){
       logger.info("Starting EventSim");
       dataLogManager = MmsFederate.getHlaWorld().getHlaDataLogManager();
       dataLogManager.addHlaDataLogDefaultInstanceListener(new DataLogSim.DataLogUpdateListener());
    }
    
    public void createDataLog(DataLog newLog){
        try{
            HlaDataLog dataLog = dataLogManager.createLocalHlaDataLog();
            HlaDataLogUpdater updater = dataLog.getHlaDataLogUpdater();

            if(newLog.getSource() != null){
                updater.setSource(newLog.getSource());
            }

            if(newLog.getData() != null){
                updater.setData(newLog.getData());
            }
            
            updater.setTime(new Date().getTime());
            
            updater.sendUpdate();
        }catch(Exception e){
            logger.error(e);
        }
    }

    public void focusEvent(String instanceName){
        this.focusedInstanceName = instanceName;
        
        HlaDataLog dataLog = this.dataLogManager.getDataLogByHlaInstanceName(instanceName);
        UiUpdateHandler.getUiUpdateHandler().updateDataLogText(dataLog.getData());
    }
    
    public class DataLogUpdateListener implements HlaDataLogListener{

        @Override
        public void attributesUpdated(HlaDataLog hlaDataLog, Set<HlaDataLogAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            DataLog dataLog = dataLogMap.get(hlaDataLog.getHlaInstanceName());
            boolean newItem = false;
                    
            if(dataLog == null){
                //first time we have seen this object
                dataLog = new DataLog()
                        .setInstanceName(hlaDataLog.getHlaInstanceName())
                        .setGhosted(!hlaDataLog.isLocal());
                newItem = true;
                dataLogMap.put(dataLog.getInstanceName(), dataLog);
            }
            for(HlaDataLogAttributes.Attribute attribute : attributes){
                switch(attribute){
                    case DATA : dataLog.setData(hlaDataLog.getData());
                        break;
                    case SOURCE : dataLog.setSource(hlaDataLog.getSource());
                        break;
                    case TIME : dataLog.setTime(hlaDataLog.getTime());
                        break;
                }
            }
            
            if(newItem){
                UiUpdateHandler.getUiUpdateHandler().addToDataLogList(dataLog);            
            }
        }
    }

    @Override
    public void hlaDisconnected(){
	dataLogMap.clear();
	focusedInstanceName = null;
        UiUpdateHandler.getUiUpdateHandler().clearDataLogList();
        UiUpdateHandler.getUiUpdateHandler().updateDataLogText("");
    }
}
