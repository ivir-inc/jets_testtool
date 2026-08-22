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

import java.util.ArrayList;

public class Tccc {
    private String instanceId = null;
    private boolean ghosted = false;
    
    private String battleRosterNumber = null;
    private TcccEvacuationLevel evacuationLevelRequest = null;
    private String patientNameLast = null;
    private String patientNameFirst = null;
    private String ssan = null;
    private TcccGender gender = null;
    private String date = null;
    private String time = null;
    private String service = null;
    private String unit = null;
    private String allergies = null;
    private TcccMechanismOfInjury mechanismOfInjury = null;
    private String injuryAnnotation = null;
    private ArrayList<TcccSignsSymptons>signsSymptoms = null;  //max 4
    private TcccTreatmentCirculatoryTourniquet treatmentCirculatoryTourniquet = null;
    private TcccTreatmentCirculatoryDressing treatmentCirculatoryDressing = null;
    private TcccTreatmentAirway treatmentAirway = null;
    private TcccTreatmentBreathing treatmentBreathing = null;
    private ArrayList<TcccTreatmentFluid> treatmentFluids = null; //max 2
    private ArrayList<TcccTreatmentFluid> treatmentBloodProducts = null; //max 2
    private ArrayList<TcccTreatmentMeds> treatmentMedsAnalgesic = null; //max 3
    private ArrayList<TcccTreatmentMeds> treatmentMedsAntibiotic = null; //max 2
    private ArrayList<TcccTreatmentMeds> treatmentMedsOther = null; //max 2
    private TcccTreatmentOther treatmentOther = null;
    private String treatmentNotes = null;
    private TcccResponder responder = null;


    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public void setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
    }
    
    public String getBattleRosterNumber() {
        return battleRosterNumber;
    }

    public void setBattleRosterNumber(String battleRosterNumber) {
        this.battleRosterNumber = battleRosterNumber;
    }

    public TcccEvacuationLevel getEvacuationLevelRequest() {
        return evacuationLevelRequest;
    }

    public void setEvacuationLevelRequest(TcccEvacuationLevel evacuationLevelRequest) {
        this.evacuationLevelRequest = evacuationLevelRequest;
    }

    public String getPatientNameLast() {
        return patientNameLast;
    }

    public void setPatientNameLast(String patientNameLast) {
        this.patientNameLast = patientNameLast;
    }

    public String getPatientNameFirst() {
        return patientNameFirst;
    }

    public void setPatientNameFirst(String patientNameFirst) {
        this.patientNameFirst = patientNameFirst;
    }

    public String getSsan() {
        return ssan;
    }

    public void setSsan(String ssan) {
        this.ssan = ssan;
    }

    public TcccGender getGender() {
        return gender;
    }

    public void setGender(TcccGender gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public TcccMechanismOfInjury getMechanismOfInjury() {
        return mechanismOfInjury;
    }

    public void setMechanismOfInjury(TcccMechanismOfInjury mechanismOfInjury) {
        this.mechanismOfInjury = mechanismOfInjury;
    }

    public String getInjuryAnnotation() {
        return injuryAnnotation;
    }

    public void setInjuryAnnotation(String injuryAnnotation) {
        this.injuryAnnotation = injuryAnnotation;
    }

    public ArrayList<TcccSignsSymptons> getSignsSymptoms() {
        return signsSymptoms;
    }

    public void setSignsSymptoms(ArrayList<TcccSignsSymptons> signsSymptoms) {
        this.signsSymptoms = signsSymptoms;
    }

    public TcccTreatmentCirculatoryTourniquet getTreatmentCirculatoryTourniquet() {
        return treatmentCirculatoryTourniquet;
    }

    public void setTreatmentCirculatoryTourniquet(TcccTreatmentCirculatoryTourniquet treatmentCirculatoryTourniquet) {
        this.treatmentCirculatoryTourniquet = treatmentCirculatoryTourniquet;
    }

    public TcccTreatmentCirculatoryDressing getTreatmentCirculatoryDressing() {
        return treatmentCirculatoryDressing;
    }

    public void setTreatmentCirculatoryDressing(TcccTreatmentCirculatoryDressing treatmentCirculatoryDressing) {
        this.treatmentCirculatoryDressing = treatmentCirculatoryDressing;
    }

    public TcccTreatmentAirway getTreatmentAirway() {
        return treatmentAirway;
    }

    public void setTreatmentAirway(TcccTreatmentAirway treatmentAirway) {
        this.treatmentAirway = treatmentAirway;
    }

    public TcccTreatmentBreathing getTreatmentBreathing() {
        return treatmentBreathing;
    }

    public void setTreatmentBreathing(TcccTreatmentBreathing treatmentBreathing) {
        this.treatmentBreathing = treatmentBreathing;
    }

    public ArrayList<TcccTreatmentFluid> getTreatmentFluids() {
        return treatmentFluids;
    }

    public void setTreatmentFluids(ArrayList<TcccTreatmentFluid> treatmentFluids) {
        this.treatmentFluids = treatmentFluids;
    }

    public ArrayList<TcccTreatmentFluid> getTreatmentBloodProducts() {
        return treatmentBloodProducts;
    }

    public void setTreatmentBloodProducts(ArrayList<TcccTreatmentFluid> treatmentBloodProducts) {
        this.treatmentBloodProducts = treatmentBloodProducts;
    }

    public ArrayList<TcccTreatmentMeds> getTreatmentMedsAnalgesic() {
        return treatmentMedsAnalgesic;
    }

    public void setTreatmentMedsAnalgesic(ArrayList<TcccTreatmentMeds> treatmentMedsAnalgesic) {
        this.treatmentMedsAnalgesic = treatmentMedsAnalgesic;
    }

    public ArrayList<TcccTreatmentMeds> getTreatmentMedsAntibiotic() {
        return treatmentMedsAntibiotic;
    }

    public void setTreatmentMedsAntibiotic(ArrayList<TcccTreatmentMeds> treatmentMedsAntibiotic) {
        this.treatmentMedsAntibiotic = treatmentMedsAntibiotic;
    }

    public ArrayList<TcccTreatmentMeds> getTreatmentMedsOther() {
        return treatmentMedsOther;
    }

    public void setTreatmentMedsOther(ArrayList<TcccTreatmentMeds> treatmentMedsOther) {
        this.treatmentMedsOther = treatmentMedsOther;
    }

    public TcccTreatmentOther getTreatmentOther() {
        return treatmentOther;
    }

    public void setTreatmentOther(TcccTreatmentOther treatmentOther) {
        this.treatmentOther = treatmentOther;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    public TcccResponder getResponder() {
        return responder;
    }

    public void setResponder(TcccResponder responder) {
        this.responder = responder;
    }

    @Override
    public String toString() {
        return "Tccc{" + "battleRosterNumber=" + battleRosterNumber + ", evacuationLevelRequest=" + evacuationLevelRequest + ", patientNameLast=" + patientNameLast + ", patientNameFirst=" + patientNameFirst + ", ssan=" + ssan + ", gender=" + gender + ", date=" + date + ", time=" + time + ", service=" + service + ", unit=" + unit + ", allergies=" + allergies + ", mechanismOfInjury=" + mechanismOfInjury + ", injuryAnnotation=" + injuryAnnotation + ", signsSymptoms=" + signsSymptoms + ", treatmentCirculatoryTourniquet=" + treatmentCirculatoryTourniquet + ", treatmentCirculatoryDressing=" + treatmentCirculatoryDressing + ", treatmentAirway=" + treatmentAirway + ", treatmentBreathing=" + treatmentBreathing + ", treatmentFluids=" + treatmentFluids + ", treatmentBloodProducts=" + treatmentBloodProducts + ", treatmentMedsAnalgesic=" + treatmentMedsAnalgesic + ", treatmentMedsAntibiotic=" + treatmentMedsAntibiotic + ", treatmentMedsOther=" + treatmentMedsOther + ", treatmentOther=" + treatmentOther + ", treatmentNotes=" + treatmentNotes + ", responder=" + responder + '}';
    }
    
}
