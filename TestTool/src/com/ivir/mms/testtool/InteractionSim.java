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

import devstudio.generatedcode.HlaInteractionManager;
import devstudio.generatedcode.datatypes.MagicVitalsEnum;
import devstudio.generatedcode.datatypes.MedicalEvacuationStateEnum;
import devstudio.generatedcode.datatypes.TransportTypeEnum;
import devstudio.generatedcode.datatypes.VisibleVitalSignEnum;
import devstudio.generatedcode.exceptions.HlaFomException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InteractionSim {
    private HlaInteractionManager interactionManager = null;
    
    public InteractionSim(){
        interactionManager = MmsFederate.getHlaWorld().getHlaInteractionManager();
    }
        
    public void selectSceanrio(String name){
        try{
            interactionManager.sendSelectScenario(name);
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void start(){
        try{
            interactionManager.sendStart();
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void stop(){
        try{
            interactionManager.sendStop();
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void resume(){
        try{
            interactionManager.sendResume();
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void pause(){
        try{
            interactionManager.sendPause();
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void save(String label){
        try{
            interactionManager.sendSave(label);
        } catch (Exception ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void loadPatient(String patientId){
        try {
            interactionManager.sendLoadPatient(patientId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startPatient(long startTime, String patientId){
        try {
            interactionManager.sendStartPatient(startTime, patientId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopPatient(long stopTime, String patientId){
        try {
            interactionManager.sendStopPatient(stopTime, patientId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pausePatient(long pauseTime, String patientId){
        try {
            interactionManager.sendPausePatient(pauseTime, patientId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resumePatient(long resumeTime, String patientId){
        try {
            interactionManager.sendResumePatient(resumeTime, patientId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void medicalEvacuationRequest(String patientId, String transportTypeStr, String siteName){
        try {
            interactionManager.sendMedicalEvacuationRequest(patientId, TransportTypeEnum.valueOf(transportTypeStr), siteName);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void medicalEvacuationResponse(String patientId, String evacuationState, String vehicleId, String siteName){
        try {
            interactionManager.sendMedicalEvacuationResponse(patientId, MedicalEvacuationStateEnum.valueOf(evacuationState), vehicleId, siteName);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void medicalEvacuationUpdate(String patientId, String evacuationState, String vehicleId, String siteName){
        try {
            interactionManager.sendMedicalEvacuationUpdate(patientId, MedicalEvacuationStateEnum.valueOf(evacuationState), vehicleId, siteName);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void instructionalStart(String facilityId){
        try {
            interactionManager.sendInstructionalStart(facilityId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void instructionalStop(String facilityId){
        try {
            interactionManager.sendInstructionalStop(facilityId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void instructionalResume(String facilityId){
        try {
            interactionManager.sendInstructionalResume(facilityId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void instructionalPause(String facilityId){
        try {
            interactionManager.sendInstructionalPause(facilityId);
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(InteractionSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void magicVitals(String patientId, String type, float value){
    	try{
		interactionManager.sendMagicVitals(patientId, toMagicVitals(type), value);
    	}catch(Exception e){
		e.printStackTrace();
	}
    }

    public MagicVitalsEnum toMagicVitals(String enumStr){
	    if(enumStr == null) return null;
	    if("RR".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.RESPIRATION_RATE;
	    if("HR".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.HEART_RATE;
	    if("DBP".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.DIASTOLIC_BLOOD_PRESSURE;
	    if("SBP".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.SYSTOLIC_BLOOD_PRESSURE;
	    if("SpO2".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.PERIPHERAL_OXYGEN_SATURATION;
	    if("Temp".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.TEMPERATURE_FAHRENHEIT;
	    if("EtCO2".equalsIgnoreCase(enumStr)) return MagicVitalsEnum.RESPIRATION_END_TIDAL_CARBON_DIOXIDE;
	    return null;
    }

    public void vitalsVisiblity(String patientId, String type, boolean turnOn){
	   try{
		interactionManager.sendVitalsDisplayControl(patientId, turnOn, toVisibleVitalSignEnum(type));
	   }catch(Exception e){
		   e.printStackTrace();
	   }
    }

    private VisibleVitalSignEnum toVisibleVitalSignEnum(String enumStr){
	    if(enumStr == null) return null;
	    if("RR".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.RESPIRATION_RATE;
	    if("HR".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.HEART_RATE;
	    if("BP".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.BLOOD_PRESSURE;
	    if("SpO2".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.OXYGEN_SATURATION;
	    if("Temp".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.TEMPERATURE;
	    if("EtCO2".equalsIgnoreCase(enumStr)) return VisibleVitalSignEnum.END_TIDAL_CARBON_DIOXIDE;
	    return null;
    }

    public void magicTransfer(String patientId, String facilityId){
	    try{
		    interactionManager.sendMagicTransfer(patientId, facilityId);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
    }
}
