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

import com.ivir.mms.testtool.tree.PairTreeBuilder;
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.InjuryDescriptionEnum;
import devstudio.generatedcode.datatypes.InjuryTypeEnum;
import devstudio.generatedcode.datatypes.MechanismOfInjuryRecord;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class UiCommandHandler {
    private static final UiCommandHandler handler = new UiCommandHandler(); 
    private MmsFederate mmsFederate = null;
    private PatientVitalSignsSim patientVitalSignsSim = null;
    private PatientRespiratorySim patientRespiratorySim = null;
    private EventSim eventSim = null;
    private TcccSim tcccSim = null;
    private InteractionSim interactionSim = null;
    private CreatePatientSim cPatientSim = null;
    private DataLogSim dataLogSim = null;
    private FederationStateSim federationStateSim = null;
    private DocumentSim documentSim = null;
    private DateTimeSim dateTimeSim = null;
    private BodyFluidsSim bodyFluidsSim = null;
    private NeuroScalesSim neuroScalesSim = null;
    private LabDataSim labDataSim = null;
    private InjuryDataSim injuryDataSim = null;
    private ReplayTimer replayTimer = null;
    private CasualtyStateSim casualtyStateSim = null;
    private FacilitySim facilitySim = null;
    
    private UiCommandHandler(){
        
    }
    
    public static UiCommandHandler getUiCommandHandler(){
        return handler;
    }

    public void setMmsFederate(MmsFederate federate){
        this.mmsFederate = federate;
    }
    
    public void setPatientVitalSignsSim(PatientVitalSignsSim vitalsSim){
        this.patientVitalSignsSim = vitalsSim;
    }
    
    public void setPatientRespiratorySim(PatientRespiratorySim respSim){
        this.patientRespiratorySim = respSim;
    }
    
    public void setEventSim(EventSim sim){
        this.eventSim = sim;
    }
    
    public void setTcccSim(TcccSim sim){
        this.tcccSim = sim;
    }
    
    public void setCreatePatientSim(CreatePatientSim sim){
        this.cPatientSim = sim;
    }
    
    public void setInteractionSim(InteractionSim iSim){
        this.interactionSim = iSim;
    }
    
    public void setDataLogSim(DataLogSim dlSim){
        this.dataLogSim = dlSim;
    }
    
    public void setFederationStateSim(FederationStateSim fsSim){
        this.federationStateSim = fsSim;
    }
    
    public void setDocumentSim(DocumentSim dSim){
        this.documentSim = dSim;
    }
    
    public void setDateTimeSim(DateTimeSim dtSim){
        this.dateTimeSim = dtSim;
    }
    
    public void setBodyFluidsSim(BodyFluidsSim bSim){
        this.bodyFluidsSim = bSim;
    }
    
    public void setNeuroScalesSim(NeuroScalesSim nSim){
        this.neuroScalesSim = nSim;
    }
    
    public void setLabDataSim(LabDataSim dSim){
        this.labDataSim = dSim;
    }
    
    public void setInjuryDataSim(InjuryDataSim dSim){
        this.injuryDataSim = dSim;
    }
    
    public void setreplayTimer (ReplayTimer replayTimer) {
        this.replayTimer = replayTimer;
    }

    public void setCasualtyStateSim(CasualtyStateSim sim){
	    this.casualtyStateSim = sim;
    }

    public void setFacilitySim(FacilitySim sim){
        this.facilitySim = sim;
    }

    public void joinFederation(){
        mmsFederate.connect();
    }
    
    public void resignFederation(){
        mmsFederate.disconnect();
    }
    
    public void createRespiratoryPatient(Patient patient){
        patientRespiratorySim.createPatient(patient);
    }
    
    public void updateRespiratoryPatient(Patient patient) {
        patientRespiratorySim.updatePatient(patient);
    }
    
    public void createPatient(Patient patient){
       patientVitalSignsSim.createPatient(patient);
    }
    
    public void updatePatient(Patient patient) {
        patientVitalSignsSim.updatePatient(patient);
    }
    
    // TODO: Determine final solution for this once more Patient discussion is completed
    public void selectPatient(String patientId){
        patientVitalSignsSim.focusPatient(patientId, this.patientRespiratorySim);
    }

    public void acquireOwnership(){
        patientVitalSignsSim.acquireOwnershipForFocusedPatient();
    }

    public void releaseOwnership(){
        patientVitalSignsSim.releaseOwnershipForFocusedPatient();
    }
    
    public void createSigns(Signs signs) {
        patientVitalSignsSim.createSigns(signs);
    }
    
    public void createSymptoms(Symptoms symptoms) {
        patientVitalSignsSim.createSymptoms(symptoms);
    }
    
    
    public void createPhysicalTreatment(PhysicalTreatment treatment){
        patientVitalSignsSim.createPhysicalTreatment(treatment);
    }
    
    public void createMedicationTreatment(MedicationTreatment treatment){
        patientVitalSignsSim.createMedicationTreatment(treatment);
    }
    
    public void createInjury(Injury injury){
        patientVitalSignsSim.createInjury(injury);
    }

    public void createEvent(Event event){
        eventSim.createEvent(event);
    }
    
    public void selectEvent(String instanceName){
        eventSim.focusEvent(instanceName);
    }
    
    public void modifyUpdater(boolean start, PatientChangeAttributes attributeEnumm, Object increment, int duration){
        patientVitalSignsSim.modifyUpdater(start, attributeEnumm, increment, duration);
    }
    
    public void createTccc(){
        this.tcccSim.createTccc();
    }
    
    public void selectTccc(String instanceName){
        this.tcccSim.focusTccc(instanceName);
    }
    
    public Set<String> getListOfTcccCards(){
        return this.tcccSim.getListOfTcccCards();
    }
    
    public void createCreatePatient(CreatePatient cPatient){
        this.cPatientSim.createCreatePatient(cPatient);
    }
    
    public CreatePatient getCreatePatient(String patientId){
        return this.cPatientSim.getCreatePatient(patientId);
    }
    
    public void sendSelectScenario(String name){
        this.interactionSim.selectSceanrio(name);
    }
    
    public void sendStart(){
        this.interactionSim.start();
    }

    public void sendStop(){
        this.interactionSim.stop();
    }

    public void sendPause(){
        this.interactionSim.pause();
    }

    public void sendResume(){
        this.interactionSim.resume();
    }
    
    public void sendSave(String label){
        this.interactionSim.save(label);
    }
    
    public void createDataLog(DataLog newLog){
        this.dataLogSim.createDataLog(newLog);
    }
    
    public void selectDataLog(String intstanceName){
        this.dataLogSim.focusEvent(intstanceName);
    }
    
    public void sendLoadPatient(String patientId){
        this.interactionSim.loadPatient(patientId);
    }
    
    public void sendStartPatient(long startTime, String patientId){
        this.interactionSim.startPatient(startTime, patientId);
    }
    
    public void sendStopPatient(long stopTime, String patientId){
        this.interactionSim.stopPatient(stopTime, patientId);
    }
    
    public void sendPausePatient(long pauseTime, String patientId){
        this.interactionSim.pausePatient(pauseTime, patientId);
    }
    
    public void sendResumePatient(long resumeTime, String patientId){
        this.interactionSim.resumePatient(resumeTime, patientId);
    }
    
    public void sendMedicalEvacuationRequest(String patientId, String transportType, String siteName){
        this.interactionSim.medicalEvacuationRequest(patientId, transportType, siteName);
    }
     
    public void sendMedicalEvacuationResponse(String patientId, String evacuationState, String vehicleId, String siteName){
        this.interactionSim.medicalEvacuationResponse(patientId, evacuationState, vehicleId, siteName);
    }
    
    public void sendMedicalEvacuationUpdate(String patientId, String evacuationState, String vehicleId, String siteName){
        this.interactionSim.medicalEvacuationUpdate(patientId, evacuationState, vehicleId, siteName);
    }
    
    public void updateFederationState(String newState){
        this.federationStateSim.updateState(newState);
    }
    
    public void createDocument(String name, String type, String patientId, String filePath){
        this.documentSim.sendDocument(name, type, patientId, filePath);
    }
    
    public void updateTimeSim(int ratio, boolean isOwner){
        this.dateTimeSim.updateDateTimeSim(isOwner, ratio);
    }
    
    public void enableReplayTimer(boolean enable) {
        this.dateTimeSim.enableReplayTimer(enable);
    }
    
    public void setReplayClassLists(List replayClassLists) {
        this.replayTimer.setReplayClassLists(replayClassLists);
    }
    
    public void updateElapsedReplayTimer(Long elapsedTime) {
        this.replayTimer.updateElapsedTime(elapsedTime);
    }
    
    public void startReplayTimer() {
        this.replayTimer.startReplayTimer();
    }
    
    public void stopReplayTimer() {
        this.replayTimer.stopReplayTimer();
    }
    
    public void pauseReplayTimer() {
        this.replayTimer.pauseReplayTimer();
    }
    
    public void resumeReplayTimer() {
        this.replayTimer.resumeReplayTimer();
    }
    
    public void instructionalStart(String facilityId){
        this.interactionSim.instructionalStart(facilityId);
    }
    
    public void instructionalStop(String facilityId){
        this.interactionSim.instructionalStop(facilityId);
    }
    
    public void instructionalPause(String facilityId){
        this.interactionSim.instructionalPause(facilityId);
    }

    public void instructionalResume(String facilityId){
        this.interactionSim.instructionalResume(facilityId);
    }
    
    public void createBodyFluids(String patientId, Float bloodFloss, 
            Float bloodVolume, Float sweatOutput, Float urineOutput){        
        this.bodyFluidsSim.createBodyFluids(patientId, bloodFloss, bloodVolume, 
                sweatOutput, urineOutput);
    }
    
        public void createBodyFluids(BodyFluids bodyFluids){        
        this.bodyFluidsSim.createBodyFluids(bodyFluids);
    }
    
    public void modifyBodyFluidsUpdater(String instanceId, boolean start, String attribute, 
            Float increment, Integer duration){
        
        BodyFluidsChangeAttribute attributeEnum = null;

        if(attribute.equalsIgnoreCase("Blood Loss")){
            attributeEnum = BodyFluidsChangeAttribute.BLOOD_LOSS;
        }else if(attribute.equalsIgnoreCase("Blood Volume")){
            attributeEnum = BodyFluidsChangeAttribute.BLOOD_VOLUME;
        }else if(attribute.equalsIgnoreCase("Sweat Rate")){
            attributeEnum = BodyFluidsChangeAttribute.SWEAT_OUTPUT;
        }else if(attribute.equalsIgnoreCase("Urine Output")){
            attributeEnum = BodyFluidsChangeAttribute.URINE_OUTPUT;
        }
        
        this.bodyFluidsSim.modifyUpdater(start, instanceId, attributeEnum, 
                increment, duration);
    }

    public void createNeuroScales(String patientId, Integer eyesScale, 
            Integer verbalScale, Integer motorScale, String levelOfResponse, 
            String levelOfConsciousness){
        
        this.neuroScalesSim.createNeuroScales(patientId, eyesScale, verbalScale, 
                motorScale, levelOfResponse, levelOfConsciousness);
    }
    
        public void createNeuroScales(NeurologicalScales neuroScales){
        
        this.neuroScalesSim.createNeuroScales(neuroScales);
    }

    public void updateNeuroScales(String instanceId, String patientId, 
            Integer eyesScale, Integer verbalScale, Integer motorScale,
            String levelOfResponse, String levelOfConsciousness){
        
        this.neuroScalesSim.updateNeuroScales(instanceId, patientId, eyesScale, 
                verbalScale, motorScale, levelOfResponse, levelOfConsciousness);
    }
    
    public void createBloodLab(String patientId){
        this.labDataSim.createBloodLab(patientId, new Date().getTime(), 
                randomNum(), randomNum(), randomNum(), randomNum(), randomNum(), 
                randomNum(), randomNum(), randomNum(), randomNum(), randomNum(),
                randomNum(), randomNum(), randomNum(), randomNum(), randomNum(), 
                randomNum());
    }
    
    public void createBloodLab(BloodLab bloodLab){
        this.labDataSim.createBloodLab(bloodLab);
    }

    public void createBloodGasLab(String patientId){
        this.labDataSim.createBloodGasLab(patientId, new Date().getTime(), 
                randomNum(), randomNum(), 
                randomNum(), randomNum());
    }
    
    public void createBloodGasLab(BloodGasLab bloodGasLab) {
        this.labDataSim.createBloodGasLab(bloodGasLab);
    }
    
    public void createUrineLab(String patientId){
        this.labDataSim.createUrineLab(patientId, new Date().getTime(), 
                randomNum(), randomNum(), randomNum(), randomNum(), randomNum(), 
                randomNum(), randomNum(), randomNum(), randomNum(), randomNum(), 
                randomNum());
    }
    
    public void createUrineLab(UrineLab urineLab){
        this.labDataSim.createUrineLab(urineLab);
    }
    
    private Float randomNum(){
        float ranNum =  (float)Math.random()*12f;
        if(ranNum > 10){
            return null;
        }
        return ranNum;
    }

    
    public void createInjury(String patientId, String injuryId, Long time,
            BodyLocationRecord bodyLocationRecord, InjuryTypeEnum injuryType, 
            InjuryDescriptionEnum description, String injuryDetail, Integer severity, 
            MechanismOfInjuryRecord mechanismOfInjury, Float hemorrhageRate, Float totalBodySurfaceArea) {
        
        this.injuryDataSim.createInjury(patientId, injuryId, time, bodyLocationRecord, injuryType, description, 
                injuryDetail, severity, mechanismOfInjury, hemorrhageRate, totalBodySurfaceArea);
    }

    public void magicVitals(String patientId, String type, float value){
        this.interactionSim.magicVitals(patientId, type, value);
    }

    public void magicTransfer(String patientId, String facilityId){
        this.interactionSim.magicTransfer(patientId, facilityId);
    }

    public void vitalsVisibility(String patientId, String type, boolean turnOn){
        this.interactionSim.vitalsVisiblity(patientId, type, turnOn);
    }

    public void createCasualtyState(String patientId, String facilityId, String evacuationPriority, String triage){
        this.casualtyStateSim.createCasualtyState(patientId, facilityId, evacuationPriority, triage);
    }

    public String getCasualtyStateDetails(String instanceName){
        PairTreeBuilder treeBuilder = this.casualtyStateSim.getDetails(instanceName);
        if(treeBuilder == null){
            return "";
        }
        return PairTreeBuilder.treeString(treeBuilder.getRoot());
    }

    public void createFacility(String facilityId, String facilityType, String patientCapacity, String roleOfCare){
        this.facilitySim.createFacility(facilityId,facilityType, patientCapacity, roleOfCare);
    }

    public String getFacilityDetails(String instanceName){
        PairTreeBuilder treeBuilder = this.facilitySim.getDetails(instanceName);
        if(treeBuilder == null){
            return "";
        }
        return PairTreeBuilder.treeString(treeBuilder.getRoot());
    }
}
