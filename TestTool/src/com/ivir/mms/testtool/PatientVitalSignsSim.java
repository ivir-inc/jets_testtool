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

import devstudio.generatedcode.*;
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.MechanismOfInjuryRecord;
import devstudio.generatedcode.datatypes.MedicationAdministrationRouteEnum;
import devstudio.generatedcode.datatypes.PhysicalTreatmentTypeEnum;
import devstudio.generatedcode.datatypes.SkinRashRecord;
import devstudio.generatedcode.datatypes.TreatmentDeviceEnum;
import devstudio.generatedcode.datatypes.VisionDisturbanceEnum;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatientVitalSignsSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(PatientVitalSignsSim.class);
    private static final org.apache.logging.log4j.Logger hlaLogger = LogManager.getLogger("hla_trace");
    private final HashMap<String,Patient> patients = new HashMap<>();
    private final HashMap<String,HashMap<String,Treatment>> treatments = new HashMap<>();
    private final HashMap<String,HashMap<String,Injury>> injuries = new HashMap<>();
    private final HashMap<String,PhysiologyChangeThread> attributeChangers = new HashMap<>();
    private final HashMap<String,HashMap<String,Signs>> signsHash = new HashMap<>();
    private final HashMap<String,HashMap<String,Symptoms>> symptomsHash = new HashMap<>();
    private final HashMap<String,Set<HlaVitalSignsAttributes.Attribute>> patientAttributesRequested = new HashMap<>();
    private HlaVitalSignsManager patientVitalSignsManager = null;
    private HlaPhysicalTreatmentManager physicalTreatmentManager = null;
    private HlaMedicationTreatmentManager medicationTreatmentManager = null;
    private HlaInjuryManager injuryManager = null;
    private HlaSymptomsManager symptomsManager = null;
    private HlaSignsManager signsManager = null;
    private String focusedPatientId = null;
    
    public PatientVitalSignsSim( ){
       logger.info("Starting PatientPhysiologicalSim");
       hlaLogger.trace(Patient.getCsvHeaders());
       hlaLogger.trace(Treatment.getCsvHeaders());
       patientVitalSignsManager = MmsFederate.getHlaWorld().getHlaVitalSignsManager();
       patientVitalSignsManager.addHlaVitalSignsDefaultInstanceListener(new PatientVitalSignsUpdateListener());
       patientVitalSignsManager.setHlaVitalSignsDefaultOwnershipListener(new VitalSignsOwnershipListener());
       
       // Treatments
       physicalTreatmentManager = MmsFederate.getHlaWorld().getHlaPhysicalTreatmentManager();
       physicalTreatmentManager.addHlaPhysicalTreatmentDefaultInstanceListener(new PhysicalTreatmentUpdateListener());
       medicationTreatmentManager = MmsFederate.getHlaWorld().getHlaMedicationTreatmentManager();
       medicationTreatmentManager.addHlaMedicationTreatmentDefaultInstanceListener(new MedicationTreatmentUpdateListener());
       
       // Injuries
       injuryManager = MmsFederate.getHlaWorld().getHlaInjuryManager();
       injuryManager.addHlaInjuryDefaultInstanceListener(new InjuryUpdateListener());
       
       // Signs & Symptoms
       signsManager = MmsFederate.getHlaWorld().getHlaSignsManager();
       signsManager.addHlaSignsDefaultInstanceListener(new SignsUpdateListener());
       symptomsManager = MmsFederate.getHlaWorld().getHlaSymptomsManager();
       symptomsManager.addHlaSymptomsDefaultInstanceListener(new SymptomsUpdateListener());
       
    }
    
    public void createPatient(Patient patient){
        String id = patient.getId();
        if(patients.get(id) == null){
            patient.setGhosted(false);
	    patient.setOwnershipState(OwnershipState.CREATED);
            patients.put(id, patient);
            
            try {
                HlaVitalSigns hlaPatient = patientVitalSignsManager.createLocalHlaVitalSigns();
                HlaVitalSignsUpdater updater = hlaPatient.getHlaVitalSignsUpdater();
                updater.setPatientId(id);
                patient.setInstanceName(hlaPatient.getHlaInstanceName());
                patientUpdater(patient, updater);
                
            } catch(Exception e){
                e.printStackTrace();
            }
          
            UiUpdateHandler.getUiUpdateHandler().addToPatientList(patient);
        } else{
            logger.warn("Attempted to create new patient without a patient ID. Skipping create for: " + patient);
        }
    }
    
    public void updatePatient (Patient patient) {
        Patient localListPatient = patients.get(patient.getId());
        if (localListPatient != null) {
            HlaVitalSigns hlaPatient = this.patientVitalSignsManager
                        .getVitalSignsByHlaInstanceName(localListPatient.getInstanceName());
            HlaVitalSignsUpdater updater = hlaPatient.getHlaVitalSignsUpdater();
            updater.setPatientId(patient.getId());

            patientUpdater(patient, updater);
        } else {
            createPatient(patient);
        }
    }
    
    private void patientUpdater (Patient patient, HlaVitalSignsUpdater updater) {
        
        try {
            if(patient.getDiastolicBloodPressure() != null)
                    updater.setDiastolicBloodPressure(patient.getDiastolicBloodPressure());
                if(patient.getHeartRate() != null)
                    updater.setHeartRate(patient.getHeartRate());
                if(patient.getOxygenSaturation() != null)
                    updater.setPeripheralOxygenSaturation(patient.getOxygenSaturation());
                if(patient.getRespirationETco2() != null)
                    updater.setRespirationEndTidalCarbonDioxide(patient.getRespirationETco2());
                if(patient.getRespirationRate() != null)
                    updater.setRespirationRate(patient.getRespirationRate());
                if(patient.getSystolicBloodPressure() != null)
                    updater.setSystolicBloodPressure(patient.getSystolicBloodPressure());
                if(patient.getTemperatureFahrenheit() != null)
                    updater.setTemperatureFahrenheit(patient.getTemperatureFahrenheit());
                
                updater.sendUpdate();
        }catch(Exception e){
                e.printStackTrace();
            }

    }
    
    public void modifyUpdater(boolean start, PatientChangeAttributes attributeEnum, Object unitIncrement, int duration){
        Patient patient = patients.get(this.focusedPatientId);
        PhysiologyChangeThread attChange = this.attributeChangers.get(patient.getId() + attributeEnum.name());
        if(attChange != null){
            attChange.stopUpdater();
        }
        
        if(start){
            attChange = new PhysiologyChangeThread(this.patientVitalSignsManager, patient.getInstanceName(), attributeEnum ,unitIncrement,duration);
            this.attributeChangers.put(patient.getId(), attChange);
            new Thread(attChange).start();
        }
    }
    
    public void createPhysicalTreatment(PhysicalTreatment treatment){
        String patientId = this.focusedPatientId;
        try {
            HlaPhysicalTreatment hlaTreatment = physicalTreatmentManager.createLocalHlaPhysicalTreatment();
            HlaPhysicalTreatmentUpdater updater = hlaTreatment.getHlaPhysicalTreatmentUpdater();
            //general treatment
            updater.setPatientId(patientId);
            updater.setTreatmentId(treatment.getTreatmentId());
            updater.setTreatmentTime(new Date().getTime());
            if(treatment.getInjuryId() != null){
                updater.setInjuryId(treatment.getInjuryId());
            }
            
            if(treatment.getTreatmentLocation() != null){
                updater.setTreatmentLocation(treatment.getTreatmentLocation());
            }
            
            //physical treatment
            if(treatment.getTeatmentActive() != null){
                updater.setTreatmentActive(treatment.getTeatmentActive());
            }
            if(treatment.getDeviceUsed() != null){
                updater.setDeviceUsed(TreatmentDeviceEnum.valueOf(treatment.getDeviceUsed()));
            }
            if(treatment.getTreatment() != null){
                updater.setTreatment(PhysicalTreatmentTypeEnum.valueOf(treatment.getTreatment()));
            }

            updater.sendUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public void createMedicationTreatment(MedicationTreatment treatment){
        String patientId = this.focusedPatientId;
        try {
            HlaMedicationTreatment hlaTreatment = medicationTreatmentManager.createLocalHlaMedicationTreatment();
            HlaMedicationTreatmentUpdater updater = hlaTreatment.getHlaMedicationTreatmentUpdater();
            //general treatment
            updater.setPatientId(patientId);
            updater.setTreatmentId(treatment.getTreatmentId());
            updater.setTreatmentTime(new Date().getTime());
            if(treatment.getInjuryId() != null){
                updater.setInjuryId(treatment.getInjuryId());
            }
            
            if(treatment.getTreatmentLocation() != null){
                updater.setTreatmentLocation(treatment.getTreatmentLocation());
            }

            //physical treatment
            if(treatment.getDosageActive() != null){
                updater.setDosageActive(treatment.getDosageActive());
            }
            
            if(treatment.getMedicationName() != null){
                updater.setMedication(treatment.getMedicationName());
            }
            if(treatment.getPeriod() != null){
                updater.setDosageTimePeriod(treatment.getPeriod());
            }
            if(treatment.getRoute() != null){
                updater.setAdministrationRoute(MedicationAdministrationRouteEnum.valueOf(treatment.getRoute()));
            }
            if(treatment.getDosage() != null){
                updater.setDosageValue(treatment.getDosage());
            }

            updater.sendUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public void createInjury(Injury injury){
            createHlaInjury(injury);
    }
    
    private void createHlaInjury(Injury injury){
        String patientId = this.focusedPatientId;
        try{
            HlaInjury hlaInjury = injuryManager.createLocalHlaInjury();
            HlaInjuryUpdater updater = hlaInjury.getHlaInjuryUpdater();
            updater.setPatientId(patientId);
            
            if(injury.getInjuryId() != null){
                updater.setInjuryId(injury.getInjuryId());
            }
            if(injury.getDescription() != null){
                updater.setInjuryDescription(injury.getDescription());                
            }
            if(injury.getInjuryType() != null){
                updater.setInjuryType(injury.getInjuryType());                
            }
            if(injury.getSeverity() != null){
                updater.setInjurySeverity(injury.getSeverity());                
            }
            if(injury.getTime() != null){
                updater.setTime(injury.getTime()); 
            }
            if(injury.getBodyLocationRecord() != null) {
                updater.setInjuryLocation(injury.getBodyLocationRecord());
            }
            if(injury.getInjuryDetail() != null){
                updater.setInjuryDetail(injury.getInjuryDetail());
            }
            if(injury.getMechanismOfInjuryRecord() != null){
                updater.setMechanismOfInjury(injury.getMechanismOfInjuryRecord());
            }
            if(injury.getHemorrhageRate() != null){
                updater.setHemorrhageRate(injury.getHemorrhageRate());
            }
            if(injury.getTotalBodySurfaceArea() != null){
                updater.setTotalBodySurfaceArea(injury.getTotalBodySurfaceArea());
            }
            
            updater.sendUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createSigns(Signs signs){
        String patientId = this.focusedPatientId;
        try {
            HlaSigns hlaSigns = signsManager.createLocalHlaSigns();
            HlaSignsUpdater updater = hlaSigns.getHlaSignsUpdater();
            
            updater.setPatientId(patientId);
            if(signs.getSignLocation() != null) {
                updater.setSignLocation(signs.getSignLocation());
            }
            if(signs.getConfusion()!= null) {
                updater.setConfusion(signs.getConfusion());
            }
            if(signs.getSkinColor()!= null) {
                updater.setSkinColor(signs.getSkinColor());
            }
            if(signs.getSkinRashRecord() != null) {
                updater.setSkinRash(signs.getSkinRashRecord());
            }
            if(signs.getSkinMoisture() != null) {
                updater.setSkinMoisture(signs.getSkinMoisture());
            }
            if(signs.getCough() != null) {
                updater.setCough(signs.getCough());
            }
            if(signs.getEcgRhythm() != null) {
                updater.setEcgRhythm(signs.getEcgRhythm());
            }
            if(signs.getHeartSound()!= null) {
                updater.setHeartSound(signs.getHeartSound());
            }
            if(signs.getLungSound() != null) {
                updater.setLungSound(signs.getLungSound());
            }
            if(signs.getBowelSound()!= null) {
                updater.setBowelSound(signs.getBowelSound());
            }
            if(signs.getPupilSize() != null) {
                updater.setPupilSize(signs.getPupilSize());
            }
            
            updater.sendUpdate();
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void createSymptoms(Symptoms symptoms) {
        String patientId = this.focusedPatientId;
        try {
            HlaSymptoms hlaSymptoms = symptomsManager.createLocalHlaSymptoms();
            HlaSymptomsUpdater updater = hlaSymptoms.getHlaSymptomsUpdater();
            
            updater.setPatientId(patientId);
            updater.setLevelOfPain(symptoms.getLevelOfPain()); // Cannot be null
            
            if(symptoms.getSymptomLocation() != null) {
                updater.setSymptomLocation(symptoms.getSymptomLocation());
            }
            if(symptoms.getDizziness()!= null) {
                updater.setDizziness(symptoms.getDizziness());
            }
            if(symptoms.getNausea()!= null) {
                updater.setNausea(symptoms.getNausea());
            }
            if(symptoms.getFatigue()!= null) {
                updater.setFatigue(symptoms.getFatigue());
            }
            if(symptoms.getNumbness()!= null) {
                updater.setNumbness(symptoms.getNumbness());
            }
            if(symptoms.getVisionDisturbance()!= null) {
                updater.setVisionDisturbance(symptoms.getVisionDisturbance());
            }
            
            updater.sendUpdate();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public void focusPatient(String patientId, PatientRespiratorySim respSim){
        this.focusedPatientId = patientId;
        //do the initial update
        Patient patient = this.patients.get(patientId);
        if(patient != null){
            displayPatient(patient);
        }else{
            // TODO: Determine final solution for this once more Patient discussion is completed
            respSim.focusPatient(patientId);
            System.out.println("Warning: no patient found for ID " + patientId);
            logger.warn("Patient not found with ID: " + patientId);
        }
    }

    private void displayPatient(Patient patient){
        HlaVitalSigns hlaPatient = patientVitalSignsManager.getVitalSignsByHlaInstanceName(patient.getInstanceName());
        UiUpdateHandler uiUpdateHandler = UiUpdateHandler.getUiUpdateHandler();
               
        uiUpdateHandler.updatePatientVitalsText(patientText(hlaPatient,patient.isGhosted(), patient.getOwnershipState()));
        uiUpdateHandler.updatePatientTreatmentText(treatmentText(patient.getId()));
        uiUpdateHandler.updatePatientInjuriesTextArea(injuryText(patient.getId()));
        uiUpdateHandler.updatePatientSignsTextArea(signsText(patient.getId()));
        uiUpdateHandler.updatePatientSymptomsTextArea(symptomsText(patient.getId()));
       
    }

    private String patientText(HlaVitalSigns hlaPatient, boolean ghost, OwnershipState ownershipState){
        String pText = "Patient " + hlaPatient.getHlaInstanceName();
        if(ghost){
            pText += " -- Ghost";
        }
        pText += "\n|- Patient ID: " + hlaPatient.getPatientId("ANON") +"\n";
        pText += "|- Ownership State: " + ownershipState +"\n";
        if(hlaPatient.hasTemperatureFahrenheit()){
            pText += "|- TemperatureFahrenheit: " + hlaPatient.getTemperatureFahrenheit() +"\n";
        }
        if(hlaPatient.hasPeripheralOxygenSaturation()){
            pText += "|- PeripheralOxygenSaturation: " + hlaPatient.getPeripheralOxygenSaturation() +"\n";
        }
        pText += "+ Heart\n";

        if(hlaPatient.hasHeartRate()){
            pText += "|- HeartRate: " + hlaPatient.getHeartRate() +"\n";
        }
        if(hlaPatient.hasSystolicBloodPressure()){
            pText += "|- HeartSystolicBloodPressure: " + hlaPatient.getSystolicBloodPressure() +"\n";
        }
        if(hlaPatient.hasDiastolicBloodPressure()){
            pText += "|- HeartDiastolicBloodPressure: " + hlaPatient.getDiastolicBloodPressure() +"\n";
        }
        pText += "+ Lung\n";
        if(hlaPatient.hasRespirationEndTidalCarbonDioxide()){
            pText += "|- RespirationETco2: " + hlaPatient.getRespirationEndTidalCarbonDioxide() +"\n";
        }
        if(hlaPatient.hasRespirationRate()){
            pText += "|- RespirationRate: " + hlaPatient.getRespirationRate() +"\n";
        }
        
        return pText;
    }
    
    private String treatmentText(String patientId){
        String tText = "";
        HashMap<String, Treatment> patientTreatments = this.treatments.get(patientId);
        if(patientTreatments == null){
            return "";
        }

        for(Treatment treatment : patientTreatments.values()){
            if(treatment instanceof PhysicalTreatment){
                tText += "+ Physical Treatment";
                if(treatment.isGhosted()){
                    tText += " Ghosted";
                }
                HlaPhysicalTreatment hlaTreatment = physicalTreatmentManager.getPhysicalTreatmentByHlaInstanceName(treatment.getInstanceName());
                if(hlaTreatment == null){
                    System.out.println("Rejected treatment " + treatment.getTreatmentId() + ".  It is not in LRC");
                }else{
                    if(hlaTreatment.hasTreatmentId())
                        tText += "\n   |- Treatment ID:" + hlaTreatment.getTreatmentId();
                    if(hlaTreatment.hasInjuryId())
                        tText += "\n   |- Injury ID:" + hlaTreatment.getInjuryId();
                    if(hlaTreatment.hasTreatment())
                        tText += "\n   |- Treatment:" + hlaTreatment.getTreatment().name();
                    if(hlaTreatment.hasDeviceUsed())
                        tText += "\n   |- Device Used:" + hlaTreatment.getDeviceUsed();
                    if(hlaTreatment.hasTreatmentLocation()) {
                        BodyLocationRecord bodyLoc = hlaTreatment.getTreatmentLocation();
                        tText += "\n   |- Location:";
                        tText += "\n                "  + bodyLoc.generalRegion.name();
                        tText += "\n                "  + bodyLoc.regionTissueType.name();
                        tText += "\n                "  + bodyLoc.internalAnatomy.name();
                        tText += "\n                "  + bodyLoc.sagittalPlane.name();
                        tText += "\n                "  + bodyLoc.transversePlane.name();
                        tText += "\n                "  + bodyLoc.coronalPlane.name();
                        tText += "\n                "  + bodyLoc.skeletalSystem.name();
                        tText += "\n                "  + bodyLoc.detailedAnatomy.name();
                        tText += "\n                "  + bodyLoc.fmaid;
                }
                    if(hlaTreatment.hasTreatmentTime())
                        tText += "\n   |- Time:" + String.valueOf(hlaTreatment.getTreatmentTime());
                    tText += "\n";
                }
            }else{
                tText += "+ Medication Treatment";
                if(treatment.isGhosted()){
                    tText += " Ghosted";
                }
                HlaMedicationTreatment hlaTreatment =medicationTreatmentManager.getMedicationTreatmentByHlaInstanceName(treatment.getInstanceName());
                if(hlaTreatment.hasTreatmentId())
                    tText += "\n   |- Treatment ID:" + hlaTreatment.getTreatmentId();
                if(hlaTreatment.hasInjuryId())
                    tText += "\n   |- Injury ID:" + hlaTreatment.getInjuryId();
                if(hlaTreatment.hasMedication())
                    tText += "\n   |- Medication:" + hlaTreatment.getMedication().getName();
                if(hlaTreatment.hasAdministrationRoute())
                    tText += "\n   |- Route:" + hlaTreatment.getAdministrationRoute().toString();
                if(hlaTreatment.hasDosageValue())
                    tText += "\n   |- Dosage:" + hlaTreatment.getDosageValue();
                if(hlaTreatment.hasDosageActive()){
                    tText += "\n   |- Dosage Active:" + hlaTreatment.getDosageActive(false);
                }
                if(hlaTreatment.hasTreatmentLocation()) {
                    BodyLocationRecord bodyLoc = hlaTreatment.getTreatmentLocation();
                    tText += "\n   |- Location:";
                    tText += "\n                "  + bodyLoc.generalRegion.name();
                    tText += "\n                "  + bodyLoc.regionTissueType.name();
                    tText += "\n                "  + bodyLoc.internalAnatomy.name();
                    tText += "\n                "  + bodyLoc.sagittalPlane.name();
                    tText += "\n                "  + bodyLoc.transversePlane.name();
                    tText += "\n                "  + bodyLoc.coronalPlane.name();
                    tText += "\n                "  + bodyLoc.skeletalSystem.name();
                    tText += "\n                "  + bodyLoc.detailedAnatomy.name();
                    tText += "\n                "  + bodyLoc.fmaid;
                }
                if(hlaTreatment.hasTreatmentTime())
                    tText += "\n   |- Time:" + String.valueOf(hlaTreatment.getTreatmentTime());
                tText += "\n";
            }
        }
        
        return tText;
    }

    private String injuryText(String patientId){
        String tText = "";
        HashMap<String, Injury> patientInjuries = this.injuries.get(patientId);
        if(patientInjuries == null){
            return "";
        }

        for(Injury injury : patientInjuries.values()){
           
            tText += "+ Injury";
            
            if(injury.isGhosted()){
                tText += " Ghosted";
            }
            
            if(injury.getInjuryId() != null){
                tText += "\n   |- Injury ID:" + injury.getInjuryId();                
            }
            if(injury.getDescription() != null){
                tText += "\n   |- Description:" + injury.getDescription().toString();                
            }
            if(injury.getInjuryType() != null){
                tText += "\n   |- Injury Type:" + injury.getInjuryType().toString();                
            }
            if(injury.getSeverity() != null){
                tText += "\n   |- Severity:" + injury.getSeverity();                
            }
            if(injury.getTime() != null){
                tText += "\n   |- Time:" + String.valueOf(injury.getTime());                
            }
            if(injury.getBodyLocationRecord() != null){
                BodyLocationRecord bodyLoc = injury.getBodyLocationRecord();
                tText += "\n   |- Location:";
                tText += "\n                "  + bodyLoc.generalRegion.name();
                tText += "\n                "  + bodyLoc.regionTissueType.name();
                tText += "\n                "  + bodyLoc.internalAnatomy.name();
                tText += "\n                "  + bodyLoc.sagittalPlane.name();
                tText += "\n                "  + bodyLoc.transversePlane.name();
                tText += "\n                "  + bodyLoc.coronalPlane.name();
                tText += "\n                "  + bodyLoc.skeletalSystem.name();
                tText += "\n                "  + bodyLoc.detailedAnatomy.name();
                tText += "\n                "  + bodyLoc.fmaid;
            }
            if(injury.getMechanismOfInjuryRecord() != null){
                MechanismOfInjuryRecord mechOfInjury = injury.getMechanismOfInjuryRecord();
                tText += "\n   |- Mechanism Of Injury:";
                tText += "\n                "  + mechOfInjury.gunshotCaliber.toString();
                tText += "\n                "  + mechOfInjury.gunshotAmmunitionType.toString();
                tText += "\n                "  + mechOfInjury.blade.toString();
                tText += "\n                "  + mechOfInjury.blast.toString();
                tText += "\n                "  + mechOfInjury.vehicleCrash.toString();
                tText += "\n                "  + mechOfInjury.fall.toString();
                tText += "\n                "  + mechOfInjury.cbrn.toString();
                tText += "\n                "  + mechOfInjury.shrapnel.toString();
            }
            if(injury.getHemorrhageRate()!= null){
                tText += "\n   |- Hemorrhage Rate:" + injury.getHemorrhageRate() + " mL/min";                
            }
            if(injury.getTotalBodySurfaceArea()!= null){
                tText += "\n   |- Burn Surface Area:" + String.valueOf(injury.getTotalBodySurfaceArea()) + " %";                
            }
            
            if(injury.getInjuryDetail() != null){
                tText += "\n   |- Injury Detail:";
                tText += "\n                "  + injury.getInjuryDetail();
                        
            }
            tText += "\n";
        }
        
        return tText;
    }
    
    private String signsText(String patientId) {
        String tText = "";
        HashMap<String, Signs> patientSigns = this.signsHash.get(patientId);
        if (patientSigns == null) {
            return "";
        }
        
        for (Signs signs : patientSigns.values()) {
            
            tText += "+ Signs";
            
            if(signs.isGhosted()){
                tText += " Ghosted";
            }
            HlaSigns hlaSigns = signsManager.getSignsByHlaInstanceName(signs.getInstanceName());
            
            if(hlaSigns.hasConfusion()) {
                 tText += "\n   |- Confusion:" + hlaSigns.getConfusion();
            }
            if(hlaSigns.hasSkinColor()) {
                 tText += "\n   |- Skin Color:" + hlaSigns.getSkinColor();
            }
            if(hlaSigns.hasSkinRash()) {
                SkinRashRecord rashRec = signs.getSkinRashRecord();
                 tText += "\n   |- Skin Rash Record:";
                 tText += "\n                "  + rashRec.rashRaised;
                 tText += "\n                "  + rashRec.rashScab;
                 tText += "\n                "  + rashRec.rashUniform; 
            }
            if(hlaSigns.hasSkinMoisture()) {
                tText += "\n   |- Skin Moisture:" + hlaSigns.getSkinMoisture();
            }
            if(hlaSigns.hasCough()) {
                tText += "\n   |- Cough:" + hlaSigns.getCough();
            }
            if(hlaSigns.hasEcgRhythm()) {
                tText += "\n   |- ECG Rhythm:" + hlaSigns.getEcgRhythm();
            }
            if(hlaSigns.hasHeartSound()) {
                tText += "\n   |- Heart Sound:" + hlaSigns.getHeartSound();
            }
            if(hlaSigns.hasLungSound()) {
                tText += "\n   |- Lung Sound:" + hlaSigns.getLungSound();
            }
            if(hlaSigns.hasBowelSound()) {
                tText += "\n   |- Bowel Sound:" + hlaSigns.getBowelSound();
            }
            if(hlaSigns.hasPupilSize()) {
                tText += "\n   |- Pupil Size:" + hlaSigns.getPupilSize();
            }
            if(hlaSigns.hasSignLocation()){
                BodyLocationRecord bodyLoc = signs.getSignLocation();
                tText += "\n   |- Location:";
                tText += "\n                "  + bodyLoc.generalRegion.name();
                tText += "\n                "  + bodyLoc.regionTissueType.name();
                tText += "\n                "  + bodyLoc.internalAnatomy.name();
                tText += "\n                "  + bodyLoc.sagittalPlane.name();
                tText += "\n                "  + bodyLoc.transversePlane.name();
                tText += "\n                "  + bodyLoc.coronalPlane.name();
                tText += "\n                "  + bodyLoc.skeletalSystem.name();
                tText += "\n                "  + bodyLoc.detailedAnatomy.name();
                tText += "\n                "  + bodyLoc.fmaid;
            }
            
            tText += "\n";
        }
        
        return tText;
    }
    
    private String symptomsText(String patientId) {
        String tText = "";
        HashMap<String, Symptoms> patientSymptoms = this.symptomsHash.get(patientId);
        if (patientSymptoms == null) {
            return "";
        }
        
        for (Symptoms symptoms : patientSymptoms.values()) {
            
            tText += "+ Symptoms";
            
            if(symptoms.isGhosted()) {
                tText += " Ghosted";
            }
            
            tText += "\n   |- Level of Pain:" + symptoms.getLevelOfPain();
            
            if(symptoms.getDizziness() != null) {
                tText += "\n   |- Dizziness:" + symptoms.getDizziness();
            }
            if(symptoms.getNausea()!= null) {
                tText += "\n   |- Nausea:" + symptoms.getNausea();
            }
            if(symptoms.getFatigue()!= null) {
                tText += "\n   |- Fatigue:" + symptoms.getFatigue();
            }
            if(symptoms.getNumbness()!= null) {
                tText += "\n   |- Numbness:" + symptoms.getNumbness();
            }
            if(symptoms.getVisionDisturbance()!= null) {
                tText += "\n   |- VisionDisturbance:" + symptoms.getVisionDisturbance();
            }
            if(symptoms.getSymptomLocation()!= null){
                BodyLocationRecord bodyLoc = symptoms.getSymptomLocation();
                tText += "\n   |- Location:";
                tText += "\n                "  + bodyLoc.generalRegion.name();
                tText += "\n                "  + bodyLoc.regionTissueType.name();
                tText += "\n                "  + bodyLoc.internalAnatomy.name();
                tText += "\n                "  + bodyLoc.sagittalPlane.name();
                tText += "\n                "  + bodyLoc.transversePlane.name();
                tText += "\n                "  + bodyLoc.coronalPlane.name();
                tText += "\n                "  + bodyLoc.skeletalSystem.name();
                tText += "\n                "  + bodyLoc.detailedAnatomy.name();
                tText += "\n                "  + bodyLoc.fmaid;
            }
            
            tText += "\n";
        }
        return tText;
    }

	@Override
	public void hlaDisconnected() {
		logger.debug("Deleting patients");
		patients.clear();
    		treatments.clear();
    		injuries.clear();
    		attributeChangers.clear();
    		signsHash.clear();
    		symptomsHash.clear();
		focusedPatientId = null;
		
		UiUpdateHandler uiUpdateHandler = UiUpdateHandler.getUiUpdateHandler();
		uiUpdateHandler.clearPatientList();
               
            	uiUpdateHandler.updatePatientVitalsText("");
        	uiUpdateHandler.updatePatientTreatmentText("");
        	uiUpdateHandler.updatePatientInjuriesTextArea("");
        	uiUpdateHandler.updatePatientSignsTextArea("");
        	uiUpdateHandler.updatePatientSymptomsTextArea("");
	}
    
    private class PatientVitalSignsUpdateListener implements HlaVitalSignsListener{

        @Override
        public void attributesUpdated(HlaVitalSigns patientVitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            boolean isNewPatient = false;
            String patientId = patientVitalSigns.getPatientId("ANON");
            if(!patientVitalSigns.isLocal()){
                Patient patient = patients.get(patientId);
                if(patient == null){
                    patient = new Patient();
                    patient.setGhosted(true);
		    patient.setOwnershipState(OwnershipState.DISCOVERED);
                    patient.setInstanceName(patientVitalSigns.getHlaInstanceName());
                    patient.setId(patientId);
                    isNewPatient = true;
                }
                
                patient.setTimeStamp(new Date().getTime());
                for(HlaVitalSignsAttributes.Attribute attribute : attributes){
                    switch(attribute){
                        case PATIENT_ID: patient.setId(patientId);
                                         break;
                        case HEART_RATE: patient.setHeartRate(patientVitalSigns.getHeartRate());
                                         break;
                        case DIASTOLIC_BLOOD_PRESSURE: patient.setDiastolicBloodPressure(patientVitalSigns.getDiastolicBloodPressure());
                                         break;
                        case SYSTOLIC_BLOOD_PRESSURE: patient.setSystolicBloodPressure(patientVitalSigns.getSystolicBloodPressure());
                                         break;
                        case PERIPHERAL_OXYGEN_SATURATION: patient.setOxygenSaturation(patientVitalSigns.getPeripheralOxygenSaturation());
                                         break;
                        case TEMPERATURE_FAHRENHEIT: patient.setTemperatureFahrenheit(patientVitalSigns.getTemperatureFahrenheit());
                                         break;
                        case RESPIRATION_END_TIDAL_CARBON_DIOXIDE: patient.setRespirationETco2(patientVitalSigns.getRespirationEndTidalCarbonDioxide());
                                         break;
                        case RESPIRATION_RATE: patient.setRespirationRate(patientVitalSigns.getRespirationRate());
                                         break;
                    }
                }
                patients.put(patient.getId(), patient);
                if(isNewPatient)
                    UiUpdateHandler.getUiUpdateHandler().addToPatientList(patient);
                logger.info("got patient: " + patient.toString());
                hlaLogger.trace(patient.csvString());
            }//of !isLocal
            
            //leverage devstudio's ability to notify you of a attribute change
            //even if it is local
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)){
                displayPatient(patients.get(patientId));                   
            }
            
        }//of attributesUpdated
         
    }

    private class PhysicalTreatmentUpdateListener implements HlaPhysicalTreatmentListener{

        @Override
        public void attributesUpdated(HlaPhysicalTreatment hlaTreatment, Set<HlaPhysicalTreatmentAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            
            String patientId = hlaTreatment.getPatientId("ANON");
            //get treatments for patient ide
            HashMap<String,Treatment> patientTreatments = treatments.get(patientId);
            if(patientTreatments == null){
                patientTreatments = new HashMap<>();
            }
            //see if the specric treatment is already there
            PhysicalTreatment treatment = (PhysicalTreatment)patientTreatments.get(hlaTreatment.getHlaInstanceName());
            if(treatment == null){
                //new incoming treatement
                treatment = new PhysicalTreatment();
                treatment.setPatientId(hlaTreatment.getPatientId("ANON"));
                treatment.setInstanceName(hlaTreatment.getHlaInstanceName());
                treatment.setTreatmentId(hlaTreatment.getTreatmentId());
                treatment.setGhosted(!hlaTreatment.isLocal());
            }
            for(HlaPhysicalTreatmentAttributes.Attribute attribute : attributes){
                switch(attribute){
                    case TREATMENT:
                        treatment.setTreatment(hlaTreatment.getTreatment().name());
                        break;
                    case DEVICE_USED:
                        treatment.setDeviceUsed(hlaTreatment.getDeviceUsed().name());
                        break;                            
                    case TREATMENT_ACTIVE:
                        treatment.setTeatmentActive(hlaTreatment.getTreatmentActive());
                        break;
                    case PATIENT_ID:
                        //already set above
                        break;
                    case INJURY_ID:
                        treatment.setInjuryId(hlaTreatment.getInjuryId());
                        break;
                    case TREATMENT_ID:
                        //aready set above
                        break;
                    case TREATMENT_LOCATION:
                        treatment.setTreatmentLocation(hlaTreatment.getTreatmentLocation());
                        break;
                    case TREATMENT_TIME:
                        treatment.setTreatmentTime(hlaTreatment.getTreatmentTime());
                        break;
                }
            }

            patientTreatments.put(treatment.getInstanceName(), treatment);
            treatments.put(treatment.getPatientId(), patientTreatments);
            logger.info("New treatment added " + treatment);
            hlaLogger.trace(treatment.csvString());

            //leverage devstudio's ability to notify you of a attribute change
            //even if it is local
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)){
                displayPatient(patients.get(patientId));                   
            }
            
        }//of attributesUpdated()
         
    }//of TreatmentUpdateListener

    private class MedicationTreatmentUpdateListener implements HlaMedicationTreatmentListener{

        @Override
        public void attributesUpdated(HlaMedicationTreatment hlaTreatment, Set<HlaMedicationTreatmentAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            String patientId = hlaTreatment.getPatientId("ANON");

            //get treatments for patient ide
            HashMap<String,Treatment> patientTreatments = treatments.get(patientId);
            if(patientTreatments == null){
                patientTreatments = new HashMap<>();
            }
            //see if the specric treatment is already there
            MedicationTreatment treatment = (MedicationTreatment)patientTreatments.get(hlaTreatment.getHlaInstanceName());
            if(treatment == null){
                //new incoming treatement
                treatment = new MedicationTreatment();
                treatment.setPatientId(hlaTreatment.getPatientId("ANON"));
                treatment.setInstanceName(hlaTreatment.getHlaInstanceName());
                treatment.setTreatmentId(hlaTreatment.getTreatmentId());
                treatment.setGhosted(!hlaTreatment.isLocal());
            }
            for(HlaMedicationTreatment.Attribute attribute : attributes){
                switch(attribute){
                    case MEDICATION:
                        treatment.setMedicationName(hlaTreatment.getMedication());
                        break;
                    case ADMINISTRATION_ROUTE:
                        treatment.setRoute(hlaTreatment.getAdministrationRoute().name());
                        break;                            
                    case DOSAGE_VALUE:
                        treatment.setDosage(hlaTreatment.getDosageValue());
                        break;
                    case PATIENT_ID:
                        //already set above
                        break;
                    case DOSAGE_TIME_PERIOD:
                        treatment.setPeriod(hlaTreatment.getDosageTimePeriod());
                        break;
                    case DOSAGE_ACTIVE:
                        treatment.setDosageActive(hlaTreatment.getDosageActive(true));
                        break;
                    case INJURY_ID:
                        treatment.setInjuryId(hlaTreatment.getInjuryId());
                        break;
                    case TREATMENT_ID:
                        //aready set above
                        break;
                    case TREATMENT_LOCATION:
                        treatment.setTreatmentLocation(hlaTreatment.getTreatmentLocation());
                        break;
                    case TREATMENT_TIME:
                        treatment.setTreatmentTime(hlaTreatment.getTreatmentTime());
                        break;
                }
            }

            patientTreatments.put(treatment.getInstanceName(), treatment);
            treatments.put(treatment.getPatientId(), patientTreatments);
            logger.info("New treatment added " + treatment);
            hlaLogger.trace(treatment.csvString());
            
            //leverage devstudio's ability to notify you of a attribute change
            //even if it is local
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)){
                displayPatient(patients.get(patientId));                   
            }
        }//of attributesUpdated()
    }

    public class InjuryUpdateListener implements HlaInjuryListener{

        @Override
        public void attributesUpdated(HlaInjury hlaInjury, Set<HlaInjuryAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            String patientId = hlaInjury.getPatientId("ANON");

            //get treatments for patient id
            HashMap<String,Injury> patientInjuries = injuries.get(patientId);
            if(patientInjuries == null){
                patientInjuries = new HashMap<>();
            }

            Injury injury = patientInjuries.get(hlaInjury.getHlaInstanceName());
            if(injury == null){
                injury = new Injury();
                injury.setPatientId(hlaInjury.getPatientId("ANON"));
                injury.setInstanceName(hlaInjury.getHlaInstanceName());
                injury.setInjuryId(hlaInjury.getInjuryId("N/A"));
                injury.setGhosted(!hlaInjury.isLocal());
                patientInjuries.put(injury.getInstanceName(), injury);
                injuries.put(patientId, patientInjuries);
            }

            for(HlaInjuryAttributes.Attribute injuryAttribute : attributes){
                switch(injuryAttribute){
                    case PATIENT_ID:
                        injury.setPatientId(hlaInjury.getPatientId());
                        break;
                    case INJURY_ID:
                        injury.setInjuryId(hlaInjury.getInjuryId());
                        break;
                    case TIME:
                        injury.setTime(hlaInjury.getTime());
                        break;
                    case INJURY_LOCATION:
                        injury.setBodyLocationRecord(hlaInjury.getInjuryLocation());
                        break;
                    case INJURY_DESCRIPTION:
                        injury.setDescription(hlaInjury.getInjuryDescription());
                        break;
                    case INJURY_TYPE:
                        injury.setInjuryType(hlaInjury.getInjuryType());
                        break;
                    case INJURY_DETAIL:
                        injury.setInjuryDetail(hlaInjury.getInjuryDetail());
                        break;
                    case INJURY_SEVERITY:
                        injury.setSeverity(hlaInjury.getInjurySeverity());
                        break;
                    case MECHANISM_OF_INJURY:
                        injury.setMechanismOfInjuryRecord(hlaInjury.getMechanismOfInjury());
                        break;
                    case HEMORRHAGE_RATE:
                        injury.setHemorrhageRate(hlaInjury.getHemorrhageRate());
                        break;
                    case TOTAL_BODY_SURFACE_AREA:
                        injury.setTotalBodySurfaceArea(hlaInjury.getTotalBodySurfaceArea());
                        break;
                }
            }
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)){
                displayPatient(patients.get(patientId));                   
            }
        }
    }
    
    private class SignsUpdateListener implements HlaSignsListener{

        @Override
        public void attributesUpdated(HlaSigns hlaSigns, Set<HlaSignsAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            
            String patientId = hlaSigns.getPatientId("ANON");
            
            HashMap<String,Signs> patientSigns = signsHash.get(patientId);
            if(patientSigns == null) {
                patientSigns = new HashMap<>();
            }
            
            Signs signs = patientSigns.get(hlaSigns.getHlaInstanceName());
            if (signs == null) {
                signs = new Signs();
                signs.setPatientId(hlaSigns.getPatientId("ANON"));
                signs.setInstanceName(hlaSigns.getHlaInstanceName());
                signs.setGhosted(!hlaSigns.isLocal());
            }
            
            for (HlaSignsAttributes.Attribute signsAttribute : attributes) {
                switch(signsAttribute){
                    case PATIENT_ID:
                        signs.setPatientId(hlaSigns.getPatientId());
                        break;
                    case SIGN_LOCATION:
                        signs.setSignLocation(hlaSigns.getSignLocation());
                        break;
                    case CONFUSION:
                        signs.setConfusion(hlaSigns.getConfusion());
                        break;
                    case SKIN_COLOR:
                        signs.setSkinColor(hlaSigns.getSkinColor());
                        break;
                    case SKIN_RASH:
                        signs.setSkinRashRecord(hlaSigns.getSkinRash());
                        break;
                    case SKIN_MOISTURE:
                        signs.setSkinMoisture(hlaSigns.getSkinMoisture());
                        break;
                    case COUGH:
                        signs.setCough(hlaSigns.getCough());
                        break;
                    case ECG_RHYTHM:
                        signs.setEcgRhythm(hlaSigns.getEcgRhythm());
                        break;
                    case HEART_SOUND:
                        signs.setHeartSound(hlaSigns.getHeartSound());
                        break;
                    case LUNG_SOUND:
                        signs.setLungSound(hlaSigns.getLungSound());
                        break;
                    case BOWEL_SOUND:
                        signs.setBowelSound(hlaSigns.getBowelSound());
                        break;
                    case PUPIL_SIZE:
                        signs.setPupilSize(hlaSigns.getPupilSize());
                        break;
                }
            }
            
            patientSigns.put(signs.getInstanceName(), signs);
            signsHash.put(signs.getPatientId(), patientSigns);
            logger.info("New Signs added " + signs);
            System.out.println("New Signs added " + signs);
            
            
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)) {
                displayPatient(patients.get(patientId)); 
            }
        }
        
    }
    
    private class SymptomsUpdateListener implements HlaSymptomsListener {

        @Override
        public void attributesUpdated(HlaSymptoms hlaSymptoms, Set<HlaSymptomsAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            String patientId = hlaSymptoms.getPatientId("ANON");
            
            HashMap<String,Symptoms> patientSymptoms = symptomsHash.get(patientId);
            if(patientSymptoms == null) {
                patientSymptoms = new HashMap<>();
            }
            
            Symptoms symptoms = patientSymptoms.get(hlaSymptoms.getHlaInstanceName());
            if (symptoms == null) {
                symptoms = new Symptoms();
                symptoms.setPatientId(hlaSymptoms.getPatientId());
                symptoms.setInstanceName(hlaSymptoms.getHlaInstanceName());
                symptoms.setGhosted(!hlaSymptoms.isLocal());
            }
            
            for (HlaSymptomsAttributes.Attribute symptomsAttribute : attributes) {
                switch(symptomsAttribute){
                    case PATIENT_ID:
                        symptoms.setPatientId(hlaSymptoms.getPatientId());
                        break;
                    case SYMPTOM_LOCATION:
                        symptoms.setSymptomLocation(hlaSymptoms.getSymptomLocation());
                        break;
                    case DIZZINESS:
                        symptoms.setDizziness(hlaSymptoms.getDizziness());
                        break;
                    case NAUSEA:
                        symptoms.setNausea(hlaSymptoms.getNausea());
                        break;
                    case LEVEL_OF_PAIN:
                        symptoms.setLevelOfPain(hlaSymptoms.getLevelOfPain());
                        break;
                    case FATIGUE:
                        symptoms.setFatigue(hlaSymptoms.getFatigue());
                        break;
                    case NUMBNESS:
                        symptoms.setNumbness(hlaSymptoms.getNumbness());
                        break;
                    case VISION_DISTURBANCE:
                        symptoms.setVisionDisturbance(hlaSymptoms.getVisionDisturbance(
                                VisionDisturbanceEnum.DISTANCE_BLURRED));// Need Normal or Not Applicable option here
                        break;
                }
            }
                patientSymptoms.put(symptoms.getInstanceName(), symptoms);
                symptomsHash.put(patientId, patientSymptoms);
                logger.info("New Symptoms added " + symptoms);
            
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)) {
                displayPatient(patients.get(patientId));
            }
        }
        
    }

    //---------------------------------------------------------------------------------------------
    //                                    Ownership
    //---------------------------------------------------------------------------------------------
    public void acquireOwnershipForFocusedPatient(){
        try {
            Patient patient = patients.get(focusedPatientId);
            HlaVitalSigns vitalSigns = patientVitalSignsManager.getVitalSignsByHlaInstanceName(patient.getInstanceName());
            vitalSigns.acquireOwnership(getOwnershipSet());
            updateOwnershipStatus(vitalSigns,OwnershipState.RELEASE_OWNERSHIP_REQUESTED);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void releaseOwnershipForFocusedPatient(){
        try{
            Patient patient = patients.get(focusedPatientId);
            HlaVitalSigns vitalSigns = patientVitalSignsManager.getVitalSignsByHlaInstanceName(patient.getInstanceName());
            Set<HlaVitalSignsAttributes.Attribute> requestedAttributes = patientAttributesRequested.get(focusedPatientId);
            if(requestedAttributes == null){
                logger.warn("Did not receive an acquire request from HLA, releasing all attributes");
                requestedAttributes = getOwnershipSet();
            }
            logWarningIfNotFullSet(requestedAttributes);
            vitalSigns.releaseOwnership(requestedAttributes);
            patientAttributesRequested.remove(focusedPatientId);
            updateOwnershipStatus(vitalSigns,OwnershipState.OWNERSHIP_RELEASED);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Set<HlaVitalSignsAttributes.Attribute> getOwnershipSet(){
        return Arrays.stream(HlaVitalSignsAttributes.Attribute.values())
                .filter((att)->!att.equals(HlaVitalSignsAttributes.Attribute.HLA_PRIVILEGE_TO_DELETE_OBJECT))
                .collect(Collectors.toSet());
    }

    private class VitalSignsOwnershipListener implements HlaVitalSignsOwnershipListener{

        @Override
        public void releaseOwnershipRequested(HlaVitalSigns vitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes, HlaUserSuppliedTag<Object> tag) {
            if(vitalSigns.hasPatientId()){
                patientAttributesRequested.put(vitalSigns.getPatientId(), attributes);
            }
            updateOwnershipStatus(vitalSigns, OwnershipState.RELEASE_OWNERSHIP_REQUESTED);
        }

        @Override
        public void ownershipAcquired(HlaVitalSigns vitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes, HlaUserSuppliedTag<Object> tag) {
            updateOwnershipStatus(vitalSigns, OwnershipState.OWNERSHIP_ACQUIRED);
        }

        @Override
        public void ownershipOffered(HlaVitalSigns vitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes, HlaUserSuppliedTag<Object> tag) {
            updateOwnershipStatus(vitalSigns, OwnershipState.OWNERSHIP_OFFERED);
        }

        @Override
        public void attributeOwnershipDenied(HlaVitalSigns vitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes) {
            updateOwnershipStatus(vitalSigns, OwnershipState.ATTRIBUTE_OWNERSHIP_DENIED);
        }

        @Override
        public void cancelAcquireOwnershipSucceeded(HlaVitalSigns vitalSigns, Set<HlaVitalSignsAttributes.Attribute> attributes) {
            updateOwnershipStatus(vitalSigns, OwnershipState.CANCEL_ACQUIRE_OWNERSHIP_SUCCEEDED);
        }
    }

    private void updateOwnershipStatus(HlaVitalSigns vitalSigns, OwnershipState state){
        if(vitalSigns.hasPatientId()){
            Patient patient = patients.get(vitalSigns.getPatientId());
            if(patient != null){
                patient.setOwnershipState(state);
            }
        }
    }

    private void logWarningIfNotFullSet(Set<HlaVitalSignsAttributes.Attribute> acquireRequestSet){
        List<String> missingAttributes = new ArrayList<>();
        for (HlaVitalSignsAttributes.Attribute attribute : HlaVitalSignsAttributes.Attribute.values()) {
            if (!acquireRequestSet.contains(attribute) && !attribute.equals(HlaVitalSignsAttributes.Attribute.HLA_PRIVILEGE_TO_DELETE_OBJECT)) {
                missingAttributes.add(attribute.name());
            }
        }
        if(missingAttributes.size() > 0){
            logger.warn("Releasing ownership of VitalSigns with missing attributes: {}", String.join(", ", missingAttributes));
        }
    }

}
