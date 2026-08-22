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

/**
 *
 */
public enum PatientChangeAttributes {
        BLOOD_PRESSURE_DIASTOLIC("BP Diastolic",0),
        BLOOD_PRESSURE_SYSTOLIC("BP Systolic",0),
        HEART_RATE("Heart Rate",0),
        RESPIRATION_RATE("Resp Rate",1),
        SPO2("SPO2",1),
        TEMPERATURE("Temp",1);
    
    //0 = int, 1 = float
    private int dataType = 0;
    private String listName = null;
    
    PatientChangeAttributes (String listName, int dataType){
        this.listName = listName;
        this.dataType = dataType;
    }
    
    public Object parseData(String data){
        if(dataType == 0){
            return Integer.parseInt(data);
        }else if(dataType == 1){
            return Float.parseFloat(data);
        }
        throw new RuntimeException("Type is not correct");
    }
    
    public String getListName(){
        return this.listName;
    }
    
    public static PatientChangeAttributes fromListName(String name){
        for(PatientChangeAttributes currentAtt : PatientChangeAttributes.values()){
            if(currentAtt.getListName().equalsIgnoreCase(name)){
                return currentAtt;
            }
        }
        throw new RuntimeException("Could not get PatientChangeAttributes");
    }
}