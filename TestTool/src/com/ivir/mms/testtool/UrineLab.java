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
public class UrineLab {
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    String patientId = null;
    
    @CsvBindByName(column = "time (HLAinteger64Time)")
    Long time = null;
    
    @CsvBindByName(column = "sodium (FloatType32BE)")
    Float sodium = null;
    
    @CsvBindByName(column = "chloride (FloatType32BE)")
    Float chloride = null;
    
    @CsvBindByName(column = "amonia (FloatType32BE)")
    Float ammonia = null;
    
    @CsvBindByName(column = "ketones (FloatType32BE)")
    Float ketones = null;
    
    @CsvBindByName(column = "bicarbonate (FloatType32BE)")
    Float bicarbonate = null;
    
    @CsvBindByName(column = "glucose (FloatType32BE)")
    Float glucose = null;
    
    @CsvBindByName(column = "protein (FloatType32BE)")
    Float protein = null;
    
    @CsvBindByName(column = "creatinine (FloatType32BE)")
    Float creatinine = null;
    
    @CsvBindByName(column = "ureaNitrogen (FloatType32BE)")
    Float ureaNitrogen = null;
    
    @CsvBindByName(column = "ionizedCalcium (FloatType32BE)")
    Float ionizedCalcium = null;
    
    @CsvBindByName(column = "phosphate (FloatType32BE)")
    Float phosphate = null;

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

    public Float getSodium() {
        return sodium;
    }

    public void setSodium(Float sodium) {
        this.sodium = sodium;
    }

    public Float getChloride() {
        return chloride;
    }

    public void setChloride(Float chloride) {
        this.chloride = chloride;
    }

    public Float getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(Float ammonia) {
        this.ammonia = ammonia;
    }

    public Float getKetones() {
        return ketones;
    }

    public void setKetones(Float ketones) {
        this.ketones = ketones;
    }

    public Float getBicarbonate() {
        return bicarbonate;
    }

    public void setBicarbonate(Float bicarbonate) {
        this.bicarbonate = bicarbonate;
    }

    public Float getGlucose() {
        return glucose;
    }

    public void setGlucose(Float glucose) {
        this.glucose = glucose;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(Float creatinine) {
        this.creatinine = creatinine;
    }

    public Float getUreaNitrogen() {
        return ureaNitrogen;
    }

    public void setUreaNitrogen(Float ureaNitrogen) {
        this.ureaNitrogen = ureaNitrogen;
    }

    public Float getIonizedCalcium() {
        return ionizedCalcium;
    }

    public void setIonizedCalcium(Float ionizedCalcium) {
        this.ionizedCalcium = ionizedCalcium;
    }

    public Float getPhosphate() {
        return phosphate;
    }

    public void setPhosphate(Float phosphate) {
        this.phosphate = phosphate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.patientId);
        hash = 89 * hash + Objects.hashCode(this.time);
        hash = 89 * hash + Objects.hashCode(this.sodium);
        hash = 89 * hash + Objects.hashCode(this.chloride);
        hash = 89 * hash + Objects.hashCode(this.ammonia);
        hash = 89 * hash + Objects.hashCode(this.ketones);
        hash = 89 * hash + Objects.hashCode(this.bicarbonate);
        hash = 89 * hash + Objects.hashCode(this.glucose);
        hash = 89 * hash + Objects.hashCode(this.protein);
        hash = 89 * hash + Objects.hashCode(this.creatinine);
        hash = 89 * hash + Objects.hashCode(this.ureaNitrogen);
        hash = 89 * hash + Objects.hashCode(this.ionizedCalcium);
        hash = 89 * hash + Objects.hashCode(this.phosphate);
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
        final UrineLab other = (UrineLab) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.sodium, other.sodium)) {
            return false;
        }
        if (!Objects.equals(this.chloride, other.chloride)) {
            return false;
        }
        if (!Objects.equals(this.ammonia, other.ammonia)) {
            return false;
        }
        if (!Objects.equals(this.ketones, other.ketones)) {
            return false;
        }
        if (!Objects.equals(this.bicarbonate, other.bicarbonate)) {
            return false;
        }
        if (!Objects.equals(this.glucose, other.glucose)) {
            return false;
        }
        if (!Objects.equals(this.protein, other.protein)) {
            return false;
        }
        if (!Objects.equals(this.creatinine, other.creatinine)) {
            return false;
        }
        if (!Objects.equals(this.ureaNitrogen, other.ureaNitrogen)) {
            return false;
        }
        if (!Objects.equals(this.ionizedCalcium, other.ionizedCalcium)) {
            return false;
        }
        return Objects.equals(this.phosphate, other.phosphate);
    }
    
    
}
