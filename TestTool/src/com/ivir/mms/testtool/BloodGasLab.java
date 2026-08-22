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
import java.util.Objects;

/**
 *
 */
public class BloodGasLab {
    
    @CsvBindByName(column= "patientId (HLAASCIIstring)")
    String patientId = null;
    
    @CsvBindByName(column = "time (HLAinteger64Time)")
    Long time = null;
    
    @CsvBindByName(column = "partialPressureCarbonDioxide (FloatType32BE)")
    Float partialPressureCarbonDioxide = null;
    
    @CsvBindByName(column = "partialPressureOxygen (FloatType32BE)")
    Float partialPressureOxygen = null;
    
    @CsvBindByName(column = "sulfurDioxide (FloatType32BE)")
    Float sulfurDioxide = null;
    
    @CsvBindByName(column = "totalCarbonDioxide (FloatType32BE)")
    Float totalCarbonDioxide = null;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Float getPartialPressureCarbonDioxide() {
        return partialPressureCarbonDioxide;
    }

    public void setPartialPressureCarbonDioxide(Float partialPressureCarbonDioxide) {
        this.partialPressureCarbonDioxide = partialPressureCarbonDioxide;
    }

    public Float getPartialPressureOxygen() {
        return partialPressureOxygen;
    }

    public void setPartialPressureOxygen(Float partialPressureOxygen) {
        this.partialPressureOxygen = partialPressureOxygen;
    }

    public Float getSulfurDioxide() {
        return sulfurDioxide;
    }

    public void setSulfurDioxide(Float sulfurDioxide) {
        this.sulfurDioxide = sulfurDioxide;
    }

    public Float getTotalCarbonDioxide() {
        return totalCarbonDioxide;
    }

    public void setTotalCarbonDioxide(Float totalCarbonDioxide) {
        this.totalCarbonDioxide = totalCarbonDioxide;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.patientId);
        hash = 73 * hash + Objects.hashCode(this.time);
        hash = 73 * hash + Objects.hashCode(this.partialPressureCarbonDioxide);
        hash = 73 * hash + Objects.hashCode(this.partialPressureOxygen);
        hash = 73 * hash + Objects.hashCode(this.sulfurDioxide);
        hash = 73 * hash + Objects.hashCode(this.totalCarbonDioxide);
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
        final BloodGasLab other = (BloodGasLab) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.partialPressureCarbonDioxide, other.partialPressureCarbonDioxide)) {
            return false;
        }
        if (!Objects.equals(this.partialPressureOxygen, other.partialPressureOxygen)) {
            return false;
        }
        if (!Objects.equals(this.sulfurDioxide, other.sulfurDioxide)) {
            return false;
        }
        return Objects.equals(this.totalCarbonDioxide, other.totalCarbonDioxide);
    }
    
    
}
