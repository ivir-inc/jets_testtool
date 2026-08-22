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
public class NeurologicalScales {
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    String patientId = null;
    
    @CsvBindByName(column = "eyesScale (Integer32BE)")
    Integer eyesScale = null;
    
    @CsvBindByName(column = "verbalScale (Integer32BE)")
    Integer verbalScale = null;
    
    @CsvBindByName(column = "motorScale (Integer32BE)")
    Integer motorScale = null;
    
    @CsvBindByName(column = "levelOfResponse (HLAASCIIstring)")
    String levelofResponse = null;
    
    @CsvBindByName(column = "levelOfConsciousness (HLAASCIIstring)")
    String levelOfConsciousness = null;
    
    @CsvBindByName(column = "time (HLAinteger64Time)")
    Long time = null;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Integer getEyesScale() {
        return eyesScale;
    }

    public void setEyesScale(Integer eyesScale) {
        this.eyesScale = eyesScale;
    }

    public Integer getVerbalScale() {
        return verbalScale;
    }

    public void setVerbalScale(Integer verbalScale) {
        this.verbalScale = verbalScale;
    }

    public Integer getMotorScale() {
        return motorScale;
    }

    public void setMotorScale(Integer motorScale) {
        this.motorScale = motorScale;
    }

    public String getLevelofResponse() {
        return levelofResponse;
    }

    public void setLevelofResponse(String levelofResponse) {
        this.levelofResponse = levelofResponse;
    }

    public String getLevelOfConsciousness() {
        return levelOfConsciousness;
    }

    public void setLevelOfConsciousness(String levelOfConsciousness) {
        this.levelOfConsciousness = levelOfConsciousness;
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
        hash = 97 * hash + Objects.hashCode(this.patientId);
        hash = 97 * hash + Objects.hashCode(this.eyesScale);
        hash = 97 * hash + Objects.hashCode(this.verbalScale);
        hash = 97 * hash + Objects.hashCode(this.motorScale);
        hash = 97 * hash + Objects.hashCode(this.levelofResponse);
        hash = 97 * hash + Objects.hashCode(this.levelOfConsciousness);
        hash = 97 * hash + Objects.hashCode(this.time);
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
        final NeurologicalScales other = (NeurologicalScales) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.levelofResponse, other.levelofResponse)) {
            return false;
        }
        if (!Objects.equals(this.levelOfConsciousness, other.levelOfConsciousness)) {
            return false;
        }
        if (!Objects.equals(this.eyesScale, other.eyesScale)) {
            return false;
        }
        if (!Objects.equals(this.verbalScale, other.verbalScale)) {
            return false;
        }
        if (!Objects.equals(this.motorScale, other.motorScale)) {
            return false;
        }
        return Objects.equals(this.time, other.time);
    }
    
    

    
    
}
