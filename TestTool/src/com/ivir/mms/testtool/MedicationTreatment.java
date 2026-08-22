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
import devstudio.generatedcode.datatypes.MedicationEnum;
import java.util.Objects;

/**
 *
 */
public class MedicationTreatment extends Treatment {
    
    @CsvBindByName(column = "medicationName (MedicationEnum)")
    MedicationEnum medicationName = null;
    
    @CsvBindByName(column = "administrationRoute (MedicationAdministrationRouteEnum)")
    String route = null;
    
    @CsvBindByName(column = "dosageValue (FloatType32BE)")
    Float dosage = null;
    
    @CsvBindByName(column = "dosageTimePeriod (Integer32BE)")
    Integer period = null;
    
    @CsvBindByName(column = "dosageActive (HLAboolean)")
    Boolean dosageActive = null;
    

    public MedicationEnum getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(MedicationEnum medication) {
        this.medicationName = medication;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Boolean getDosageActive() {
        return dosageActive;
    }

    public void setDosageActive(Boolean dosageActive) {
        this.dosageActive = dosageActive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.medicationName);
        hash = 23 * hash + Objects.hashCode(this.route);
        hash = 23 * hash + Objects.hashCode(this.dosage);
        hash = 23 * hash + Objects.hashCode(this.period);
        hash = 23 * hash + Objects.hashCode(this.dosageActive);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicationTreatment other = (MedicationTreatment) obj;
        if (!Objects.equals(this.medicationName, other.medicationName)) {
            return false;
        }
        return Objects.equals(this.route, other.route);
    }
    

    @Override
    public String toString() {
        return "MedicationTreatment{" +
                "medicationName='" + medicationName + '\'' +
                ", route='" + route + '\'' +
                ", dosage=" + dosage +
                ", period=" + period +
                ", dosageActive=" + dosageActive +
//                ", patientId='" + patientId + '\'' +
//                ", injuryId='" + injuryId + '\'' +
//                ", treatmentId='" + treatmentId + '\'' +
//                ", treatmentLocation='" + treatmentLocation + '\'' +
//                ", treatmentTime=" + treatmentTime +
                '}';
    }
   
}
