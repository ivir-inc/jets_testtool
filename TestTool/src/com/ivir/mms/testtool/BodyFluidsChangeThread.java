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
import devstudio.generatedcode.HlaBodyFluidsUpdater;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BodyFluidsChangeThread implements Runnable{
    private final String instanceName;
    private final BodyFluidsChangeAttribute changeAttribute; 
    private Float changeValue = null;
    private final ConcurrentHashMap<String,HlaBodyFluids> instanceToHlaObjectMap;
    private boolean runThread = true;
    private int duration = 0;
    
    public BodyFluidsChangeThread(ConcurrentHashMap<String,HlaBodyFluids> instanceToHlaObjectMap, String instanceName, BodyFluidsChangeAttribute changeAttribute, Float unitChange, int duration){
        this.instanceToHlaObjectMap = instanceToHlaObjectMap;
        this.instanceName = instanceName;
        this.changeAttribute = changeAttribute;
        this.changeValue = unitChange;
        this.duration = duration;
    }    
    
    public void updateUnit() {
        HlaBodyFluids bodyFluids = this.instanceToHlaObjectMap.get(instanceName);
        HlaBodyFluidsUpdater updater = bodyFluids.getHlaBodyFluidsUpdater();
        switch(changeAttribute){
            case BLOOD_LOSS: 
                updater.setBloodLossRate(bodyFluids.getBloodLossRate(0) + changeValue);
                break;
            case BLOOD_VOLUME: 
                updater.setBloodVolume(bodyFluids.getBloodVolume(0) + changeValue);
                break;
            case SWEAT_OUTPUT: 
                updater.setSweatRate(bodyFluids.getSweatRate(0) + changeValue);
                break;
            case URINE_OUTPUT: 
                updater.setUrineOutputRate(bodyFluids.getUrineOutputRate(0) + changeValue);
                break;
        }
        try {
            updater.sendUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        while(runThread){
            duration --;
            if(duration < 0){
                runThread = false;
            }else{
                try {
                    updateUnit();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BodyFluidsChangeThread.class.getName()).log(Level.SEVERE, null, ex);
                    runThread = false;
                }
            }
        }
    }    

    public void stopUpdater(){
        this.runThread = false;
    }
    
}
