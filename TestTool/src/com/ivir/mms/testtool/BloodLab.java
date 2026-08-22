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
public class BloodLab {
    
    @CsvBindByName(column = "patientId (HLAASCIIstring)")
    String patientId = null;
    
    @CsvBindByName(column = "time (HLAinteger64Time)")
    Long time = null;
    
    @CsvBindByName(column = "sodium (FloatType32BE)")
    Float sodium = null;
    
    @CsvBindByName(column = "potassium (FloatType32BE)")
    Float potassium = null;
    
    @CsvBindByName(column = "chloride (FloatType32BE)")
    Float chloride = null;
    
    @CsvBindByName(column = "lactate (FloatType32BE)")
    Float lactate = null;
    
    @CsvBindByName(column = "ketones (FloatType32BE)")
    Float ketones = null;
    
    @CsvBindByName(column = "bicarbonate (FloatType32BE)")
    Float bicarbonate = null;
    
    @CsvBindByName(column = "glucose (FloatType32BE)")
    Float glucose = null;
    
    @CsvBindByName(column = "fattyAcids (FloatType32BE)")
    Float fattyAcids = null;
    
    @CsvBindByName(column = "triglycerides (FloatType32BE)")
    Float triglycerides = null;
    
    @CsvBindByName(column = "creatinine (FloatType32BE)")
    Float creatinine = null;
    
    @CsvBindByName(column = "ureaNitrogen (FloatType32BE)")
    Float ureaNitrogen = null;
    
    @CsvBindByName(column = "pH (FloatType32BE)")
    Float pH = null;
    
    @CsvBindByName(column = "ionizedCalcium (FloatType32BE)")
    Float ionizedCalcium = null;
    
    @CsvBindByName(column = "phosphate (FloatType32BE)")
    Float phosphate = null;
    
    @CsvBindByName(column = "hematocrit (FloatType32BE)")
    Float hematocrit = null;
    
    @CsvBindByName(column = "hemoglobin (FloatType32BE)")
    Float hemoglobin = null;
    
    

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

    public Float getPotassium() {
        return potassium;
    }

    public void setPotassium(Float potassium) {
        this.potassium = potassium;
    }

    public Float getChloride() {
        return chloride;
    }

    public void setChloride(Float chloride) {
        this.chloride = chloride;
    }

    public Float getLactate() {
        return lactate;
    }

    public void setLactate(Float lactate) {
        this.lactate = lactate;
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

    public Float getFattyAcids() {
        return fattyAcids;
    }

    public void setFattyAcids(Float fattyAcids) {
        this.fattyAcids = fattyAcids;
    }

    public Float getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(Float triglycerides) {
        this.triglycerides = triglycerides;
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

    public Float getpH() {
        return pH;
    }

    public void setpH(Float pH) {
        this.pH = pH;
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

    public Float getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(Float hematocrit) {
        this.hematocrit = hematocrit;
    }

    public Float getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(Float hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.patientId);
        hash = 29 * hash + Objects.hashCode(this.time);
        hash = 29 * hash + Objects.hashCode(this.sodium);
        hash = 29 * hash + Objects.hashCode(this.potassium);
        hash = 29 * hash + Objects.hashCode(this.chloride);
        hash = 29 * hash + Objects.hashCode(this.lactate);
        hash = 29 * hash + Objects.hashCode(this.ketones);
        hash = 29 * hash + Objects.hashCode(this.bicarbonate);
        hash = 29 * hash + Objects.hashCode(this.glucose);
        hash = 29 * hash + Objects.hashCode(this.fattyAcids);
        hash = 29 * hash + Objects.hashCode(this.triglycerides);
        hash = 29 * hash + Objects.hashCode(this.creatinine);
        hash = 29 * hash + Objects.hashCode(this.ureaNitrogen);
        hash = 29 * hash + Objects.hashCode(this.pH);
        hash = 29 * hash + Objects.hashCode(this.ionizedCalcium);
        hash = 29 * hash + Objects.hashCode(this.phosphate);
        hash = 29 * hash + Objects.hashCode(this.hematocrit);
        hash = 29 * hash + Objects.hashCode(this.hemoglobin);
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
        final BloodLab other = (BloodLab) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.sodium, other.sodium)) {
            return false;
        }
        if (!Objects.equals(this.potassium, other.potassium)) {
            return false;
        }
        if (!Objects.equals(this.chloride, other.chloride)) {
            return false;
        }
        if (!Objects.equals(this.lactate, other.lactate)) {
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
        if (!Objects.equals(this.fattyAcids, other.fattyAcids)) {
            return false;
        }
        if (!Objects.equals(this.triglycerides, other.triglycerides)) {
            return false;
        }
        if (!Objects.equals(this.creatinine, other.creatinine)) {
            return false;
        }
        if (!Objects.equals(this.ureaNitrogen, other.ureaNitrogen)) {
            return false;
        }
        if (!Objects.equals(this.pH, other.pH)) {
            return false;
        }
        if (!Objects.equals(this.ionizedCalcium, other.ionizedCalcium)) {
            return false;
        }
        if (!Objects.equals(this.phosphate, other.phosphate)) {
            return false;
        }
        if (!Objects.equals(this.hematocrit, other.hematocrit)) {
            return false;
        }
        return Objects.equals(this.hemoglobin, other.hemoglobin);
    }
    
    
    
}
