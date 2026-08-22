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
public class PhysicalTreatment extends Treatment{
    // Below is how the attributes should be set up if we utilize the enums
//    @CsvBindByName(column = "treatmentType (PhysicalTreatmentTypeEnum)")
//    private PhysicalTreatmentTypeEnum treatment;
//    
//    @CsvBindByName(column = "deviceUsed (TreatmentDeviceEnum)")
//    private TreatmentDeviceEnum deviceUsed;
//    
//    @CsvBindByName(column = "treatmentActive (HLAboolean)")
//    private Boolean teatmentActive;
    
    
    
    private String treatment;
    private String deviceUsed;
    private Boolean teatmentActive;

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDeviceUsed() {
        return deviceUsed;
    }

    public void setDeviceUsed(String deviceUsed) {
        this.deviceUsed = deviceUsed;
    }

    public Boolean getTeatmentActive() {
        return teatmentActive;
    }

    public void setTeatmentActive(Boolean teatmentActive) {
        this.teatmentActive = teatmentActive;
    }

    @Override
    public String toString() {
        return super.toString() + "PhysicalTreatment{" + "treatment=" + treatment + ", deviceUsed=" + deviceUsed + ", teatmentActive=" + teatmentActive + '}';
    }
}
