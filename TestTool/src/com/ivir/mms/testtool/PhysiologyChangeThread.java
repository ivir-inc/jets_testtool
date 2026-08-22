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

import devstudio.generatedcode.HlaVitalSigns;
import devstudio.generatedcode.HlaVitalSignsManager;
import devstudio.generatedcode.HlaVitalSignsUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class PhysiologyChangeThread implements Runnable{
    private String instanceName;
    private PatientChangeAttributes changeAttribute; 
    private Object changeValue = null;
    private HlaVitalSignsManager patientVitalSignsManager = null;
    private boolean runThread = true;
    private int duration = 0;
    
    public PhysiologyChangeThread(HlaVitalSignsManager patientVitalSignsManager, String instanceName, PatientChangeAttributes changeAttribute, Object unitChange, int duration){
        this.patientVitalSignsManager = patientVitalSignsManager;
        this.instanceName = instanceName;
        this.changeAttribute = changeAttribute;
        this.changeValue = unitChange;
        this.duration = duration;
    }    
    
    
    public void updateUnit() {
        HlaVitalSigns hlaPatient = this.patientVitalSignsManager.getVitalSignsByHlaInstanceName(instanceName);
        HlaVitalSignsUpdater updater = hlaPatient.getHlaVitalSignsUpdater();
        switch(changeAttribute){
            case BLOOD_PRESSURE_DIASTOLIC: updateDiastolicBloodPressure(hlaPatient, updater);
                             break;
            case BLOOD_PRESSURE_SYSTOLIC: updateSystolicBloodPressure(hlaPatient, updater);
                             break;
            case HEART_RATE: updateHeartRate(hlaPatient, updater);
                             break;
            case RESPIRATION_RATE: updateRespirationRate(hlaPatient, updater);
                             break;
            case SPO2: updatePeripheralOxygenSaturation(hlaPatient, updater);
                             break;
            case TEMPERATURE: updateTemperature(hlaPatient, updater);
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
                    Logger.getLogger(PhysiologyChangeThread.class.getName()).log(Level.SEVERE, null, ex);
                    runThread = false;
                }
            }
        }
    }    

    public void stopUpdater(){
        this.runThread = false;
    }
    
    private void updateHeartRate(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
        int currentRate = hlaPatient.getHeartRate(0);
        int hrChange = (Integer)changeValue;
        updater.setHeartRate(currentRate + hrChange);
    }
    
    private void updateTemperature(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
       float currentRate = hlaPatient.getTemperatureFahrenheit(0);
       float tempRate = (Float)changeValue;
       updater.setTemperatureFahrenheit(currentRate + tempRate);
    }
    
    private void updatePeripheralOxygenSaturation(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
        float currentO2 = hlaPatient.getPeripheralOxygenSaturation(0);
        float o2Change = (Float)changeValue;
        updater.setPeripheralOxygenSaturation(currentO2 + o2Change);
    }
    
    private void updateRespirationRate(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
        float currentResp = hlaPatient.getRespirationRate(0);
        float respChange = (Float)changeValue;
        updater.setRespirationRate(currentResp + respChange);
    }
    
    private void updateDiastolicBloodPressure(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
        int currentBP = hlaPatient.getDiastolicBloodPressure(0);
        int bpChange = (Integer)changeValue;
        updater.setDiastolicBloodPressure(currentBP + bpChange);
    }
            
    private void updateSystolicBloodPressure(HlaVitalSigns hlaPatient, HlaVitalSignsUpdater updater){
        int currentBP = hlaPatient.getSystolicBloodPressure(0);
        int bpChange = (Integer)changeValue;
        updater.setSystolicBloodPressure(currentBP + bpChange);
    }

}
