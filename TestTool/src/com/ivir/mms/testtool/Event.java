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
import devstudio.generatedcode.datatypes.LearnerActionEnum;

/**
 *
 */
public class Event {
    private Long time = null;
    
    @CsvBindByName(column = "simTime (HLAinteger64Time)")
    private Long simTime = null;
    
    @CsvBindByName(column = "type (EventTypeEnum)")
    private EventType type = null;
    
    @CsvBindByName(column = "source (HLAASCIIstring)")
    private String source = null;
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    private String patientId = null;
    
    @CsvBindByName(column = "instructorId (HLAASCIIstring)")
    private String instructorId = null;
    
    @CsvBindByName(column = "instructorId (HLAASCIIstring)")
    private String learnerId = null;
    
    @CsvBindByName(column = "teamId (HLAASCIIstring)")
    private String teamId = null;
    
    @CsvBindByName(column = "notes (HLAASCIIstring))")
    private String notes = null;
    
    
    private String instanceName = null;
    
    @CsvBindByName(column = "description (HLAASCIIstring)")
    private String description = null;
    
    @CsvBindByName(column = "trainingFacilityId (HLAASCIIstring)")
    private String facilityId = null;
    
    @CsvBindByName(column = "learnerAction (LearnerActionEnum)")
    private LearnerActionEnum learnerActionEnum = null;
    
    private boolean ghosted;

    public Long getTime() {
        return time;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Long getSimTime() {
        return simTime;
    }

    public Event setSimTime(long simTime) {
        this.simTime = simTime;
        return this;
    }

    public EventType getType() {
        return type;
    }

    public Event setType(EventType type) {
        this.type = type;
        return this;
    }

    public String getSource() {
        return source;
    }

    public Event setSource(String source) {
        this.source = source;
        return this;
    }

    public String getPatientId() {
        return patientId;
    }

    public Event setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public Event setInstructorId(String instructorId) {
        this.instructorId = instructorId;
        return this;
    }
    
    public String getLearnerId() {
        return learnerId;
    }

    public Event setLearnerId(String learnerId) {
        this.learnerId = learnerId;
        return this;
    }

    public String getTeamId() {
        return teamId;
    }

    public Event setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Event setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public Event setInstanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }
    
    public String getDescription(){
       return this.description;
    }
    
    public Event setDescription(String description){
        this.description = description;
        return this;
    }

    public boolean getGhosted() {
        return ghosted;
    }

    public Event setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
        return this;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public LearnerActionEnum getLearnerActionEnum() {
        return learnerActionEnum;
    }

    public void setLearnerActionEnum(LearnerActionEnum learnerActionEnum) {
        this.learnerActionEnum = learnerActionEnum;
    }

    @Override
    public String toString() {
        return "Event{" + "time=" + time + ", simTime=" + simTime + ", type=" + type + ", source=" + source + 
                ", patientId=" + patientId + ", instructorId=" + instructorId + ", learnerId=" + learnerId + 
                ", teamId=" + teamId + ", notes=" + notes + ", instanceName=" + instanceName + ", description=" + description + 
                ", facilityId=" + facilityId + ", learnerActionEnum=" + learnerActionEnum + ", ghosted=" + ghosted + '}';
    }
    
    

    
    
    
    
}
