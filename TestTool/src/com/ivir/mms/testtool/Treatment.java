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

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;

/**
 *
 */
public class Treatment {
    private String instanceName;
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    private String patientId;
    
    @CsvBindByName(column = "injuryId (HLAASCIIstring)")
    private String injuryId;
    
    @CsvBindByName(column = "treatmentId (HLAASCIIstring)")
    private String treatmentId;
    
    @CsvBindByName(column = "treatmentTime (HLAinteger64Time)")
    private Long treatmentTime;
   
    
    // BodyLocationRecord Attributes Below
    private BodyLocationRecord treatmentLocation;
    
    @CsvBindByName(column = "generalRegion")
    public GeneralRegionEnum generalRegion;
   
    @CsvBindByName(column = "regionTissueType")
    public RegionTissueTypeEnum regionTissueType;
   
    @CsvBindByName(column = "internalAnatomy")
    public InternalAnatomyEnum internalAnatomy;
   
    @CsvBindByName(column = "sagittalPlane")
    public SagittalPlaneEnum sagittalPlane;
   
    @CsvBindByName(column = "transversePlane")
    public TransversePlaneEnum transversePlane;
   
    @CsvBindByName(column = "coronalPlane")
    public CoronalPlaneEnum coronalPlane;
    
    @CsvBindByName(column = "skeletalSystem")
    public SkeletalSystemEnum skeletalSystem;
    
    @CsvBindByName(column = "detailedAnatomy")
    public DetailedAnatomyEnum detailedAnatomy;
   
    @CsvBindByName(column = "fmaid")
    public String fmaid;
    
    
    private boolean ghosted;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }

    public String getInjuryId() {
        return injuryId;
    }

    public void setInjuryId(String injuryId) {
        this.injuryId = injuryId;
    }

    public BodyLocationRecord getTreatmentLocation() {
        return treatmentLocation;
    }

    public void setTreatmentLocation(BodyLocationRecord bodyLocationRecord) {
        this.treatmentLocation = bodyLocationRecord;
    }
    public void buildBodyLocation() {
        BodyLocationRecord builtLocation =BodyLocationRecord.create(
                this.generalRegion, 
                this.regionTissueType, 
                this.internalAnatomy, 
                this.sagittalPlane, 
                this.transversePlane, 
                this.coronalPlane, 
                this.skeletalSystem, 
                this.detailedAnatomy, 
                0);
        
        this.treatmentLocation = builtLocation;
    }

    public Long getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(Long treatmentTime) {
        this.treatmentTime = treatmentTime;
    }
    
    public String csvString(){
        return "Treatment"
                + "," + patientId
                + "," + injuryId 
                + "," + treatmentId 
                + "," + instanceName 
                + "," + treatmentLocation 
                + "," + treatmentTime 
                + "," + ghosted;
    }
    
    public static String getCsvHeaders(){
        return "Treatment"
                + "," + "patientId"
                + "," + "injuryId" 
                + "," + "treatmentId" 
                + "," + "instanceName" 
                + "," + "treatmentLocation" 
                + "," + "treatmentTime" 
                + "," + "ghosted";
    }    

}
