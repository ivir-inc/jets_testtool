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

import devstudio.generatedcode.HlaFederateData;
import devstudio.generatedcode.HlaFederateDataAttributes;
import devstudio.generatedcode.HlaFederateDataListener;
import devstudio.generatedcode.HlaFederateDataManager;
import devstudio.generatedcode.HlaFederateDataUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FederateDataSim implements HlaFederateDataListener, ConsoleCommand{
    HlaFederateDataManager manager = null;

    public FederateDataSim(){
        this.manager = MmsFederate.getHlaWorld().getHlaFederateDataManager();
        this.manager.addHlaFederateDataDefaultInstanceListener(this);
    }

    @Override
    public void attributesUpdated(HlaFederateData federateData, Set<HlaFederateDataAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            //nothing to do yet
    }

    @Override
    public String getCommand() {
        return "federateData";
    }

    @Override
    public String executeCommand(String command, List<String> parameters) {
        if(parameters.size()==1){
            switch(parameters.get(0).toUpperCase()){
                case "CREATE":{
                    return createObject();
                }
                case "LIST":{
                    return listObjects();
                }
                default: return "include create or list as the command action";
            }
        }else{
            return "include create or list as the command action";
        }
    }
    
    private String listObjects(){
        StringBuilder stringBuilder = new StringBuilder();
        manager.getAllHlaFederateDatas().forEach((data)->{
            stringBuilder.append("instanceName: ").append(data.getHlaInstanceName()).append("\n");
            stringBuilder.append("id: ").append(data.getId("n/a")).append("\n");
            stringBuilder.append("type: ").append(data.getType("n/a")).append("\n");
            stringBuilder.append("payload: ").append(data.getPayload("n/a")).append("\n");
            stringBuilder.append(data).append("\n");
            stringBuilder.append("------------------------------------------").append("\n");
        });
        return stringBuilder.toString();
    }
    
    private String createObject(){
            HlaFederateData data;
        try {
            data = manager.createLocalHlaFederateData();
            HlaFederateDataUpdater dataUpdater = data.getHlaFederateDataUpdater();
            Random random = new Random();
            dataUpdater.setId("ID#" + String.valueOf(random.nextInt(100)));
            dataUpdater.setType("Type#" + String.valueOf(random.nextInt(100)));
            dataUpdater.setPayload("Payload#" + String.valueOf(random.nextInt(100)));
            dataUpdater.sendUpdate();
            return "Created: " + dataUpdater.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
