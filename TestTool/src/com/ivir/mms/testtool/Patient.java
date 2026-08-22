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

/**
 *
 */
public class Patient {
    private String instanceName = null;
    private boolean ghosted = false;
    private OwnershipState ownershipState = OwnershipState.UNKNOWN;
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    private String id = null;
    
    @CsvBindByName(column = "heartRate (Integer32BE)")
    private Integer heartRate = null;
    
    @CsvBindByName(column = "diastolicBloodPressure (Integer32BE)")
    private Integer diastolicBloodPressure = null;
    
    @CsvBindByName(column = "systolicBloodPressure (Integer32BE)")
    private Integer systolicBloodPressure = null;
    
    @CsvBindByName(column = "peripheralOxygenSaturation (FloatType32BE)")
    private Float oxygenSaturation = null;
    
    @CsvBindByName(column = "temperatureFahrenheit (FloatType32BE)")
    private Float temperatureFahrenheit = null;
    
    @CsvBindByName(column = "respirationEndTidalCarbonDioxide (FloatType32BE)")
    private Float respirationETco2 = null;
    
    @CsvBindByName(column = "respirationRate (FloatType32BE)")
    private Float respirationRate = null;
    
    private Integer lungTidalVolume = null;
    private Integer lungDeadSpace = null;
    private Integer lungTotalCapacity = null;
    private Integer lungExpiratoryReserve = null;
    private Integer lungInspiratoryReserve = null;
    private Integer lungResidualVolume = null;
    
    @CsvBindByName(column = "simTime (HLAinteger64Time)")
    private Long timeStamp = null;
    
    private boolean isRespiratoryPatient = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }

    public Integer getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public Integer getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(Integer systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public Float getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(Float oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Float getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }

    public void setTemperatureFahrenheit(Float temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public Float getRespirationETco2() {
        return respirationETco2;
    }

    public void setRespirationETco2(Float respirationETco2) {
        this.respirationETco2 = respirationETco2;
    }

    public Float getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(Float respirationRate) {
        this.respirationRate = respirationRate;
    }

    public Integer getLungTidalVolume() {
        return lungTidalVolume;
    }

    public void setLungTidalVolume(Integer lungTidalVolume) {
        this.lungTidalVolume = lungTidalVolume;
    }

    public Integer getLungDeadSpace() {
        return lungDeadSpace;
    }

    public void setLungDeadSpace(Integer lungDeadSpace) {
        this.lungDeadSpace = lungDeadSpace;
    }

    public Integer getLungTotalCapacity() {
        return lungTotalCapacity;
    }

    public void setLungTotalCapacity(Integer lungTotalCapacity) {
        this.lungTotalCapacity = lungTotalCapacity;
    }

    public Integer getLungExpiratoryReserve() {
        return lungExpiratoryReserve;
    }

    public void setLungExpiratoryReserve(Integer lungExpiratoryReserve) {
        this.lungExpiratoryReserve = lungExpiratoryReserve;
    }

    public Integer getLungInspiratoryReserve() {
        return lungInspiratoryReserve;
    }

    public void setLungInspiratoryReserve(Integer lungInspiratoryReserve) {
        this.lungInspiratoryReserve = lungInspiratoryReserve;
    }

    public Integer getLungResidualVolume() {
        return lungResidualVolume;
    }

    public void setLungResidualVolume(Integer lungResidualVolume) {
        this.lungResidualVolume = lungResidualVolume;
    }
    
    public void setTimeStamp(Long timeStamp){
        this.timeStamp = timeStamp;
    }
    
    public Long getTimeStamp(){
        return timeStamp;
    }

    public boolean isIsRespiratoryPatient() {
        return isRespiratoryPatient;
    }

    public void setIsRespiratoryPatient(boolean isRespiratoryPatient) {
        this.isRespiratoryPatient = isRespiratoryPatient;
    }

    public OwnershipState getOwnershipState() {
        return ownershipState;
    }

    public Patient setOwnershipState(OwnershipState ownershipState) {
        this.ownershipState = ownershipState;
        return this;
    }

    @Override
    public String toString() {
        return "Patient{" + "instanceName=" + instanceName + ", ghosted=" + ghosted + ", id=" + id + ", heartRate=" + heartRate + ", diastolicBloodPressure=" + diastolicBloodPressure + ", systolicBloodPressure=" + systolicBloodPressure + ", oxygenSaturation=" + oxygenSaturation + ", temperatureFahrenheit=" + temperatureFahrenheit + ", respirationETco2=" + respirationETco2 + ", respirationRate=" + respirationRate + ", lungTidalVolume=" + lungTidalVolume + ", lungDeadSpace=" + lungDeadSpace + ", lungTotalCapacity=" + lungTotalCapacity + ", lungExpiratoryReserve=" + lungExpiratoryReserve + ", lungInspiratoryReserve=" + lungInspiratoryReserve + ", lungResidualVolume=" + lungResidualVolume + '}';
    }
    
    public String csvString(){
        return "PatientPhysiology"
                + "," + instanceName
                + "," + ghosted
                + "," + id
                + "," + heartRate
                + "," + diastolicBloodPressure
                + "," + systolicBloodPressure
                + "," + oxygenSaturation
                + "," + temperatureFahrenheit
                + "," + respirationETco2
                + "," + respirationRate
                + "," + lungTidalVolume
                + "," + lungDeadSpace
                + "," + lungTotalCapacity
                + "," + lungExpiratoryReserve
                + "," + lungInspiratoryReserve
                + "," + lungResidualVolume;
    }
   
    public static String getCsvHeaders(){
        return "PatientPhysiology"
                + "," + "instanceName"
                + "," + "ghosted"
                + "," + "id"
                + "," + "heartRate"
                + "," + "diastolicBloodPressure"
                + "," + "systolicBloodPressure"
                + "," + "oxygenSaturation"
                + "," + "temperatureFahrenheit"
                + "," + "respirationETco2"
                + "," + "respirationRate"
                + "," + "lungTidalVolume"
                + "," + "lungDeadSpace"
                + "," + "lungTotalCapacity"
                + "," + "lungExpiratoryReserve"
                + "," + "lungInspiratoryReserve"
                + "," + "lungResidualVolume";
    }
   
}
