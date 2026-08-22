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
public class BodyFluids {
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    String patientId = null;
    
    @CsvBindByName(column = "bloodFloss (FloatType32BE)")
    Float bloodFloss = null;
    
    @CsvBindByName(column = "bloodVolume (FloatType32BE)")
    Float bloodVolume = null;
    
    @CsvBindByName(column = "sweatOutput (FloatType32BE)")
    Float sweatOutput = null;
    
    @CsvBindByName(column = "urineOutput (FloatType32BE)")
    Float urineOutput = null;
    
    @CsvBindByName(column = "time (HLAinteger64Time)")
    Long time = null;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Float getBloodFloss() {
        return bloodFloss;
    }

    public void setBloodFloss(Float bloodFloss) {
        this.bloodFloss = bloodFloss;
    }

    public Float getBloodVolume() {
        return bloodVolume;
    }

    public void setBloodVolume(Float bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public Float getSweatOutput() {
        return sweatOutput;
    }

    public void setSweatOutput(Float sweatOutput) {
        this.sweatOutput = sweatOutput;
    }

    public Float getUrineOutput() {
        return urineOutput;
    }

    public void setUrineOutput(Float urineOutput) {
        this.urineOutput = urineOutput;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.patientId);
        hash = 41 * hash + Objects.hashCode(this.bloodFloss);
        hash = 41 * hash + Objects.hashCode(this.bloodVolume);
        hash = 41 * hash + Objects.hashCode(this.sweatOutput);
        hash = 41 * hash + Objects.hashCode(this.urineOutput);
        hash = 41 * hash + Objects.hashCode(this.time);
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
        final BodyFluids other = (BodyFluids) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.bloodFloss, other.bloodFloss)) {
            return false;
        }
        if (!Objects.equals(this.bloodVolume, other.bloodVolume)) {
            return false;
        }
        if (!Objects.equals(this.sweatOutput, other.sweatOutput)) {
            return false;
        }
        if (!Objects.equals(this.urineOutput, other.urineOutput)) {
            return false;
        }
        return Objects.equals(this.time, other.time);
    }

    
    
    
    
}
