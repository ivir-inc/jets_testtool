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
import devstudio.generatedcode.datatypes.InjuryDescriptionEnum;
import devstudio.generatedcode.datatypes.InjuryTypeEnum;
import devstudio.generatedcode.datatypes.MechanismOfInjuryRecord;

public class Injury {
    private String instanceName;
    private String patientId;
    private String injuryId;
    private Long time;
    private boolean ghosted = false;
    private InjuryDescriptionEnum description;
    private InjuryTypeEnum injuryType;
    private Integer severity;
    private BodyLocationRecord bodyLocationRecord;
    private MechanismOfInjuryRecord mechanismOfInjuryRecord;
    private String injuryDetail;
    private Float hemorrhageRate;
    private Float totalBodySurfaceArea;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getInjuryId() {
        return injuryId;
    }

    public void setInjuryId(String injuryId) {
        this.injuryId = injuryId;
    }

    public BodyLocationRecord getBodyLocationRecord() {
        return bodyLocationRecord;
    }

    public void setBodyLocationRecord(BodyLocationRecord bodyLocationRecord) {
        this.bodyLocationRecord = bodyLocationRecord;
    }
    

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }

    public InjuryDescriptionEnum getDescription() {
        return description;
    }

    public void setDescription(InjuryDescriptionEnum description) {
        this.description = description;
    }

    public InjuryTypeEnum getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(InjuryTypeEnum injuryType) {
        this.injuryType = injuryType;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer serverity) {
        this.severity = serverity;
    }

    public MechanismOfInjuryRecord getMechanismOfInjuryRecord() {
        return mechanismOfInjuryRecord;
    }

    public void setMechanismOfInjuryRecord(MechanismOfInjuryRecord mechanismOfInjuryRecord) {
        this.mechanismOfInjuryRecord = mechanismOfInjuryRecord;
    }

    public String getInjuryDetail() {
        return injuryDetail;
    }

    public void setInjuryDetail(String injuryDetail) {
        this.injuryDetail = injuryDetail;
    }

    public Float getHemorrhageRate() {
        return hemorrhageRate;
    }

    public void setHemorrhageRate(Float hemorrhageRate) {
        this.hemorrhageRate = hemorrhageRate;
    }

    public Float getTotalBodySurfaceArea() {
        return totalBodySurfaceArea;
    }

    public void setTotalBodySurfaceArea(Float totalBodySurfaceArea) {
        this.totalBodySurfaceArea = totalBodySurfaceArea;
    }

    @Override
    public String toString() {
        return "Injury{" + "instanceName=" + instanceName + ", patientId=" + patientId + ", injuryId=" + injuryId + 
                ", time=" + time + ", ghosted=" + ghosted + ", description=" + description + ", injuryType=" + injuryType + 
                ", severity=" + severity + ", bodyLocationRecord=" + bodyLocationRecord + ", mechanismOfInjuryRecord=" + mechanismOfInjuryRecord + 
                ", injuryDetail=" + injuryDetail + ", hemorrhageRate=" + hemorrhageRate + ", totalBodySurfaceArea=" + totalBodySurfaceArea + '}';
    }
    
    
    
    
}
