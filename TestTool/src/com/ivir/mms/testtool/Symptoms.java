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

import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.VisionDisturbanceEnum;

/**
 *
 */
public class Symptoms {
    
    private String patientId;
    private BodyLocationRecord symptomLocation;
    private Boolean dizziness;
    private Boolean nausea;
    private Boolean fatigue;
    private Boolean numbness;
    private int levelOfPain;
    private VisionDisturbanceEnum visionDisturbance;
    
    private boolean ghosted = false;
    private String instanceName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public BodyLocationRecord getSymptomLocation() {
        return symptomLocation;
    }

    public void setSymptomLocation(BodyLocationRecord symptomLocation) {
        this.symptomLocation = symptomLocation;
    }

    public Boolean getDizziness() {
        return dizziness;
    }

    public void setDizziness(Boolean dizziness) {
        this.dizziness = dizziness;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getFatigue() {
        return fatigue;
    }

    public void setFatigue(Boolean fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean getNumbness() {
        return numbness;
    }

    public void setNumbness(Boolean numbness) {
        this.numbness = numbness;
    }

    public int getLevelOfPain() {
        return levelOfPain;
    }

    public void setLevelOfPain(int levelOfPain) {
        this.levelOfPain = levelOfPain;
    }

    public VisionDisturbanceEnum getVisionDisturbance() {
        return visionDisturbance;
    }

    public void setVisionDisturbance(VisionDisturbanceEnum visionDisturbance) {
        this.visionDisturbance = visionDisturbance;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public String toString() {
        return "Symptoms{" + "patientId=" + patientId + ", symptomLocation=" + symptomLocation + ", dizziness=" + dizziness + ", nausea=" + nausea + ", fatigue=" + fatigue + ", numbness=" + numbness + ", levelOfPain=" + levelOfPain + ", visionDisturbance=" + visionDisturbance + ", ghosted=" + ghosted + ", instanceName=" + instanceName + '}';
    }
    
    
    
}
