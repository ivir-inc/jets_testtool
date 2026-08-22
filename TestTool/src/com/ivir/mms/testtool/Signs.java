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
import devstudio.generatedcode.datatypes.BowelSoundEnum;
import devstudio.generatedcode.datatypes.CoughEnum;
import devstudio.generatedcode.datatypes.EcgRhythmEnum;
import devstudio.generatedcode.datatypes.HeartSoundEnum;
import devstudio.generatedcode.datatypes.LungSoundEnum;
import devstudio.generatedcode.datatypes.PupilSizeEnum;
import devstudio.generatedcode.datatypes.SkinColorEnum;
import devstudio.generatedcode.datatypes.SkinRashRecord;

/**
 *
 */
public class Signs {
    
    private String patientId;
    private BodyLocationRecord signLocation;
    private Boolean confusion;
    private SkinColorEnum skinColor;
    private SkinRashRecord skinRashRecord;
    private Boolean skinMoisture;
    private CoughEnum cough;
    private EcgRhythmEnum ecgRhythm;
    private HeartSoundEnum heartSound;
    private LungSoundEnum lungSound;
    private BowelSoundEnum bowelSound;
    private PupilSizeEnum pupilSize;
    
    private boolean ghosted = false;
    private String instanceName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public BodyLocationRecord getSignLocation() {
        return signLocation;
    }

    public void setSignLocation(BodyLocationRecord signLocation) {
        this.signLocation = signLocation;
    }

    public Boolean getConfusion() {
        return confusion;
    }

    public void setConfusion(Boolean confusion) {
        this.confusion = confusion;
    }

    public SkinColorEnum getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(SkinColorEnum skinColor) {
        this.skinColor = skinColor;
    }

    public SkinRashRecord getSkinRashRecord() {
        return skinRashRecord;
    }

    public void setSkinRashRecord(SkinRashRecord skinRashRecord) {
        this.skinRashRecord = skinRashRecord;
    }

    public Boolean getSkinMoisture() {
        return skinMoisture;
    }

    public void setSkinMoisture(Boolean skinMoisture) {
        this.skinMoisture = skinMoisture;
    }

    public CoughEnum getCough() {
        return cough;
    }

    public void setCough(CoughEnum cough) {
        this.cough = cough;
    }

    public EcgRhythmEnum getEcgRhythm() {
        return ecgRhythm;
    }

    public void setEcgRhythm(EcgRhythmEnum ecgRhythm) {
        this.ecgRhythm = ecgRhythm;
    }

    public HeartSoundEnum getHeartSound() {
        return heartSound;
    }

    public void setHeartSound(HeartSoundEnum heartSound) {
        this.heartSound = heartSound;
    }

    public LungSoundEnum getLungSound() {
        return lungSound;
    }

    public void setLungSound(LungSoundEnum lungSound) {
        this.lungSound = lungSound;
    }

    public BowelSoundEnum getBowelSound() {
        return bowelSound;
    }

    public void setBowelSound(BowelSoundEnum bowelSound) {
        this.bowelSound = bowelSound;
    }

    public PupilSizeEnum getPupilSize() {
        return pupilSize;
    }

    public void setPupilSize(PupilSizeEnum pupilSize) {
        this.pupilSize = pupilSize;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public String toString() {
        return "Signs{" + "patientId=" + patientId + ", signLocation=" + signLocation + ", confusion=" + confusion + ", skinColor=" + skinColor + ", skinRashRecord=" + skinRashRecord + ", skinMoisture=" + skinMoisture + ", cough=" + cough + ", ecgRhythm=" + ecgRhythm + ", heartSound=" + heartSound + ", lungSound=" + lungSound + ", bowelSound=" + bowelSound + ", pupilSize=" + pupilSize + ", ghosted=" + ghosted + ", instanceName=" + instanceName + '}';
    }

    

    
    
    
}
