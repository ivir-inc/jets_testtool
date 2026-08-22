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

import devstudio.generatedcode.HlaBloodGasLab;
import devstudio.generatedcode.HlaBloodLab;
import devstudio.generatedcode.HlaUrineLab;

public class LabDataContainer {
    public static int BLOOD_GAS = 0;
    public static int BLOOD = 1;
    public static int URINE = 2;
    
    private int type = -1;
    private HlaBloodGasLab bloodGasLab;
    private HlaBloodLab bloodLab;
    private HlaUrineLab urineLab;
    
    public LabDataContainer(HlaBloodGasLab hlaObj){
        this.bloodGasLab = hlaObj;
        this.type = BLOOD_GAS;
    }

     public LabDataContainer(HlaBloodLab hlaObj){
        this.bloodLab = hlaObj;
        this.type = BLOOD;
    }

     public LabDataContainer(HlaUrineLab hlaObj){
        this.urineLab = hlaObj;
        this.type = URINE;
    }
     
    public String getInstanceKey(){
        switch(this.type){
            case 0: return createBloodGasKey(bloodGasLab.getHlaInstanceName());
            case 1: return createBloodKey(bloodLab.getHlaInstanceName());
            case 2: return createUrineKey(urineLab.getHlaInstanceName());
            default: return null;
        }
    }
    
    public String getTypeStr(){
        switch(this.type){
            case 0: return "Blood Gas";
            case 1: return "Blood";
            case 2: return "Urine";
            default: return null;
        }
    }
    
    public String getInstanceName(){
        switch(this.type){
            case 0: return bloodGasLab.getHlaInstanceName();
            case 1: return bloodLab.getHlaInstanceName();
            case 2: return urineLab.getHlaInstanceName();
            default: return null;
        }
    }
    
    public boolean isLocal(){
        switch(this.type){
            case 0: return bloodGasLab.isLocal();
            case 1: return bloodLab.isLocal();
            case 2: return urineLab.isLocal();
            default: return true;
        }
    }

    public String getPatientId(){
        switch(this.type){
            case 0: return bloodGasLab.getPatientId("empty");
            case 1: return bloodLab.getPatientId("empty");
            case 2: return urineLab.getPatientId("empty");
            default: return "empty";
        }
    }
    
    public String getTime(){
        switch(this.type){
            case 0: return String.valueOf(bloodGasLab.getTime(0));
            case 1: return String.valueOf(bloodLab.getTime(0));
            case 2: return String.valueOf(urineLab.getTime(0));
            default: return "empty";
        }
    }
   
    public String getLabData(){
        switch(this.type){
            case 0: return getBloodGasLabData();
            case 1: return getBloodLabData();
            case 2: return getUrineLabData();
            default: return "empty";
        }
    }
    
    private String getBloodGasLabData(){
        //   * <tr><td>PARTIAL_PRESSURE_CARBON_DIOXIDE</td><td> partialPressureCarbonDioxide</td><td> <code>partialPressureCarbonDioxide</code></td></tr>
        //   * <tr><td>PARTIAL_PRESSURE_OXYGEN</td><td> partialPressureOxygen</td><td> <code>partialPressureOxygen</code></td></tr>
        //   * <tr><td>TOTAL_CARBON_DIOXIDE</td><td> totalCarbonDioxide</td><td> <code>totalCarbonDioxide</code></td></tr>
        //   * <tr><td>SULFUR_DIOXIDE</td><td> sulfurDioxide</td><td> <code>sulfurDioxide</code></td></tr>
        HlaBloodGasLab hlaLab = this.bloodGasLab;
        StringBuilder dataBuilder = new StringBuilder();
        if(hlaLab.hasPartialPressureCarbonDioxide()){
            dataBuilder.append("PCO2:").append(hlaLab.getPartialPressureCarbonDioxide()).append(",");
        }
        if(hlaLab.hasPartialPressureOxygen()){
            dataBuilder.append("PO2:").append(hlaLab.getPartialPressureOxygen()).append(",");
        }
        if(hlaLab.hasTotalCarbonDioxide()){
            dataBuilder.append("TCO2:").append(hlaLab.getTotalCarbonDioxide()).append(",");
        }
        if(hlaLab.hasSulfurDioxide()){
            dataBuilder.append("SO2:").append(hlaLab.getSulfurDioxide()).append(",");
        }
        
        return dataBuilder.toString();
    }
    
    private String getBloodLabData(){
        //   * <tr><td>BLOOD_SODIUM</td><td> bloodSodium</td><td> <code>bloodSodium</code></td></tr>
        //   * <tr><td>POTASSIUM</td><td> potassium</td><td> <code>potassium</code></td></tr>
        //   * <tr><td>BLOOD_CHLORIDE</td><td> bloodChloride</td><td> <code>bloodChloride</code></td></tr>
        //   * <tr><td>LACTATE</td><td> lactate</td><td> <code>lactate</code></td></tr>
        //   * <tr><td>BLOOD_KETONES</td><td> bloodKetones</td><td> <code>bloodKetones</code></td></tr>
        //   * <tr><td>FATTY_ACIDS</td><td> fattyAcids</td><td> <code>fattyAcids</code></td></tr>
        //   * <tr><td>TRIGLYCERIDES</td><td> triglycerides</td><td> <code>triglycerides</code></td></tr>
        //   * <tr><td>BLOOD_CREATININE</td><td> bloodCreatinine</td><td> <code>bloodCreatinine</code></td></tr>
        //   * <tr><td>BLOOD_UREA_NITROGEN</td><td> bloodUreaNitrogen</td><td> <code>bloodUreaNitrogen</code></td></tr>
        //   * <tr><td>BLOOD_PHOSPHATE</td><td> bloodPhosphate</td><td> <code>bloodPhosphate</code></td></tr>
        //   * <tr><td>IONIZED_CALCIUM</td><td> ionizedCalcium</td><td> <code>ionizedCalcium</code></td></tr>
        //   * <tr><td>BLOOD_GLUCOSE</td><td> bloodGlucose</td><td> <code>bloodGlucose</code></td></tr>
        //   * <tr><td>HEMATOCRIT</td><td> hematocrit</td><td> <code>hematocrit</code></td></tr>
        //   * <tr><td>HEMOGLOBIN</td><td> hemoglobin</td><td> <code>hemoglobin</code></td></tr>
        //   * <tr><td>BLOOD_PH</td><td> bloodPh</td><td> <code>bloodPh</code></td></tr>
        //   * <tr><td>BLOOD_BICARBONATE</td><td> bloodBicarbonate</td><td> <code>bloodBicarbonate</code></td></tr>
        //   * <tr><td>BASE_EXCESS</td><td> baseExcess</td><td> <code>baseExcess</code></td></tr>
        HlaBloodLab hlaLab = this.bloodLab;
        StringBuilder dataBuilder = new StringBuilder();
        if(hlaLab.hasBloodSodium()){
            dataBuilder.append("NA:").append(hlaLab.getBloodSodium()).append(",");
        }
        if(hlaLab.hasPotassium()){
            dataBuilder.append("K:").append(hlaLab.getPotassium()).append(",");            
        }
        if(hlaLab.hasBloodChloride()){
            dataBuilder.append("Cl:").append(hlaLab.getBloodChloride()).append(",");            
        }
        if(hlaLab.hasLactate()){
            dataBuilder.append("LD:").append(hlaLab.getLactate()).append(",");            
        }
        if(hlaLab.hasBloodKetones()){
            dataBuilder.append("KA:").append(hlaLab.getBloodKetones()).append(",");            
        }
        if(hlaLab.hasBloodBicarbonate()){
            dataBuilder.append("HCO3:").append(hlaLab.getBloodBicarbonate()).append(",");
        }
        if(hlaLab.hasBloodGlucose()){
            dataBuilder.append("BGL:").append(hlaLab.getBloodGlucose()).append(",");
        }
        if(hlaLab.hasFattyAcids()){
            dataBuilder.append("FA:").append(hlaLab.getFattyAcids()).append(",");
        }
        if(hlaLab.hasTriglycerides()){
            dataBuilder.append("TG:").append(hlaLab.getTriglycerides()).append(",");
        }
        if(hlaLab.hasBloodCreatinine()){
            dataBuilder.append("Cr:").append(hlaLab.getBloodCreatinine()).append(",");
        }
        if(hlaLab.hasBloodUreaNitrogen()){
            dataBuilder.append("BUN:").append(hlaLab.getBloodUreaNitrogen()).append(",");
        }
        if(hlaLab.hasBloodPh()){
            dataBuilder.append("pH:").append(hlaLab.getBloodPh()).append(",");
        }
        if(hlaLab.hasIonizedCalcium()){
            dataBuilder.append("iCa:").append(hlaLab.getIonizedCalcium()).append(",");
        }
        if(hlaLab.hasBloodPhosphate()){
            dataBuilder.append("PO4:").append(hlaLab.getBloodPhosphate()).append(",");
        }
        if(hlaLab.hasHematocrit()){
            dataBuilder.append("Hct:").append(hlaLab.getHematocrit()).append(",");
        }
        if(hlaLab.hasHemoglobin()){
            dataBuilder.append("Hgb:").append(hlaLab.getHemoglobin()).append(",");
        }
        return dataBuilder.toString();
    }
    
    private String getUrineLabData(){
        HlaUrineLab hlaLab = this.urineLab;
        StringBuilder dataBuilder = new StringBuilder();
        if(hlaLab.hasUrineSodium()){
            dataBuilder.append("NA:").append(hlaLab.getUrineSodium()).append(",");
        }
        if(hlaLab.hasUrineChloride()){
            dataBuilder.append("Cl:").append(hlaLab.getUrineChloride()).append(",");            
        }
        if(hlaLab.hasUrineCreatinine()){
            dataBuilder.append("Cr:").append(hlaLab.getUrineCreatinine()).append(",");
        }
        if(hlaLab.hasUrineKetones()){
            dataBuilder.append("KA:").append(hlaLab.getUrineKetones()).append(",");            
        }
        if(hlaLab.hasUrineBicarbonate()){
            dataBuilder.append("HCO3:").append(hlaLab.getUrineBicarbonate()).append(",");
        }
        if(hlaLab.hasUrineGlucose()){
            dataBuilder.append("UGL:").append(hlaLab.getUrineGlucose()).append(",");
        }
        if(hlaLab.hasAmmonia()){
            dataBuilder.append("NH3:").append(hlaLab.getAmmonia()).append(",");
        }
        if(hlaLab.hasUrineUreaNitrogen()){
            dataBuilder.append("UUN:").append(hlaLab.getUrineUreaNitrogen()).append(",");
        }
        if(hlaLab.hasUrinePhosphate()){
            dataBuilder.append("PO4:").append(hlaLab.getUrinePhosphate()).append(",");
        }
        if(hlaLab.hasProtein()){
            dataBuilder.append("Pr:").append(hlaLab.getProtein()).append(",");
        }
        return dataBuilder.toString();
    }
    
    public static String createBloodGasKey(String instanceName){
        return "BG_" + instanceName;
    }
    
    public static String createBloodKey(String instanceName){
        return "BL_" + instanceName;
    }

    public static String createUrineKey(String instanceName){
        return "UR_" + instanceName;
    }
    
    
}
