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

import devstudio.generatedcode.HlaInjury;
import devstudio.generatedcode.HlaInjuryAttributes;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.INJURY_DESCRIPTION;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.INJURY_ID;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.INJURY_LOCATION;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.INJURY_SEVERITY;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.INJURY_TYPE;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.PATIENT_ID;
import static devstudio.generatedcode.HlaInjuryAttributes.Attribute.TIME;
import devstudio.generatedcode.HlaInjuryListener;
import devstudio.generatedcode.HlaInjuryManager;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaMedicationTreatment;
import devstudio.generatedcode.HlaMedicationTreatmentAttributes;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.ADMINISTRATION_ROUTE;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.DOSAGE_ACTIVE;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.DOSAGE_TIME_PERIOD;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.DOSAGE_VALUE;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.INJURY_ID;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.PATIENT_ID;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.TREATMENT_ID;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.TREATMENT_LOCATION;
import static devstudio.generatedcode.HlaMedicationTreatmentAttributes.Attribute.TREATMENT_TIME;
import devstudio.generatedcode.HlaMedicationTreatmentListener;
import devstudio.generatedcode.HlaMedicationTreatmentManager;
import devstudio.generatedcode.HlaPhysicalTreatment;
import devstudio.generatedcode.HlaPhysicalTreatmentAttributes;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.DEVICE_USED;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.INJURY_ID;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.PATIENT_ID;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.TREATMENT;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.TREATMENT_ACTIVE;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.TREATMENT_ID;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.TREATMENT_LOCATION;
import static devstudio.generatedcode.HlaPhysicalTreatmentAttributes.Attribute.TREATMENT_TIME;
import devstudio.generatedcode.HlaPhysicalTreatmentListener;
import devstudio.generatedcode.HlaPhysicalTreatmentManager;
import devstudio.generatedcode.HlaRespiratoryPhysiology;
import devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_DEAD_SPACE;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_EXPIRATORY_RESERVE;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_INSPIRATORY_RESERVE;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_RESIDUAL_VOLUME;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_TIDAL_VOLUME;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.LUNG_TOTAL_CAPACITY;
import static devstudio.generatedcode.HlaRespiratoryPhysiologyAttributes.Attribute.PATIENT_ID;
import devstudio.generatedcode.HlaRespiratoryPhysiologyListener;
import devstudio.generatedcode.HlaRespiratoryPhysiologyManager;
import devstudio.generatedcode.HlaRespiratoryPhysiologyUpdater;
import devstudio.generatedcode.HlaTimeStamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class PatientRespiratorySim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(PatientRespiratorySim.class);
    private static final org.apache.logging.log4j.Logger hlaLogger = LogManager.getLogger("hla_trace");
    private final HashMap<String,Patient> patients = new HashMap<>();
    private final HashMap<String,HashMap<String,Treatment>> treatments = new HashMap<>();
    private final HashMap<String,HashMap<String,Injury>> injuries = new HashMap<>();
    private final HashMap<String,PhysiologyChangeThread> attributeChangers = new HashMap<>();
    private HlaRespiratoryPhysiologyManager patientRespiratoryManager = null;
    private HlaPhysicalTreatmentManager physicalTreatmentManager = null;
    private HlaMedicationTreatmentManager medicationTreatmentManager = null;
    private HlaInjuryManager injuryManager = null;
    private String focusedPatientId = null;
    
    // TODO: This sim was created to support v3 FOM update. Functionality here was
    //       not necessary at creation, so modifications will likely be required.
    
    public PatientRespiratorySim() {
        logger.info("Starting PatientRespiratorySim");
        // May want to create separate Respiratory Patient csv headers, saving for later discussion
//        hlaLogger.trace(Patient.getCsvHeaders());
//        hlaLogger.trace(Treatment.getCsvHeaders());
        patientRespiratoryManager = MmsFederate.getHlaWorld().getHlaRespiratoryPhysiologyManager();
        patientRespiratoryManager.addHlaRespiratoryPhysiologyDefaultInstanceListener(
                new PatientRespiratoryUpdateListener());
        physicalTreatmentManager = MmsFederate.getHlaWorld().getHlaPhysicalTreatmentManager();
       physicalTreatmentManager.addHlaPhysicalTreatmentDefaultInstanceListener(
               new PhysicalTreatmentUpdateListener());
       medicationTreatmentManager = MmsFederate.getHlaWorld().getHlaMedicationTreatmentManager();
       medicationTreatmentManager.addHlaMedicationTreatmentDefaultInstanceListener(
               new MedicationTreatmentUpdateListener());
       injuryManager = MmsFederate.getHlaWorld().getHlaInjuryManager();
       injuryManager.addHlaInjuryDefaultInstanceListener(new InjuryUpdateListener());
    }
    
    public void createPatient (Patient patient) {
        String id = patient.getId();
        if(patients.get(id) == null) {
            patient.setGhosted(false);
            patients.put(id, patient);
            
            try {
                HlaRespiratoryPhysiology hlaRespPatient = patientRespiratoryManager.createLocalHlaRespiratoryPhysiology();
                HlaRespiratoryPhysiologyUpdater updater = hlaRespPatient.getHlaRespiratoryPhysiologyUpdater();
                updater.setPatientID(id);
                patient.setInstanceName(hlaRespPatient.getHlaInstanceName());
                patientUpdater(patient, updater);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            UiUpdateHandler.getUiUpdateHandler().addToPatientList(patient);
        } else {
            logger.warn("Attempted to create new respiratory patient without a patient ID. "
                    + "Skipping create for: " + patient);
        }
    }
    
    public void updatePatient (Patient patient) {
        Patient localListPatient = patients.get(patient.getId());
        if (localListPatient != null) {
            HlaRespiratoryPhysiology hlaRespPatient = this.patientRespiratoryManager
                        .getRespiratoryPhysiologyByHlaInstanceName(localListPatient.getInstanceName());
            HlaRespiratoryPhysiologyUpdater updater = hlaRespPatient.getHlaRespiratoryPhysiologyUpdater();
            updater.setPatientID(patient.getId());

            patientUpdater(patient, updater);
        } else {
            createPatient(patient);
        }
    }
    
    private void patientUpdater (Patient patient, HlaRespiratoryPhysiologyUpdater updater) {
        try {
            if(patient.getLungDeadSpace() != null)
                    updater.setLungDeadSpace(patient.getLungDeadSpace());
                if(patient.getLungExpiratoryReserve() != null)
                    updater.setLungExpiratoryReserve(patient.getLungExpiratoryReserve());
                if(patient.getLungInspiratoryReserve() !=null)
                    updater.setLungInspiratoryReserve(patient.getLungInspiratoryReserve());
                if(patient.getLungResidualVolume() != null)
                    updater.setLungResidualVolume(patient.getLungResidualVolume());
                if(patient.getLungTidalVolume() != null)
                    updater.setLungTidalVolume(patient.getLungTidalVolume());
                if(patient.getLungTotalCapacity() != null)
                    updater.setLungTotalCapacity(patient.getLungTotalCapacity());
                
                updater.sendUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void focusPatient(String patientId){
        this.focusedPatientId = patientId;
        //do the initial update
        Patient patient = this.patients.get(patientId);
        if(patient != null){
            displayPatient(patient);
        }else{
            System.out.println("Warning: no respiratory patient found for ID " + patientId);
            logger.warn("Respiratory Patient not found with ID: " + patientId);
        }
    }
    
    
    private void displayPatient(Patient patient) {
        HlaRespiratoryPhysiology hlaRespiratoryPhysiology = 
                patientRespiratoryManager.getRespiratoryPhysiologyByHlaInstanceName(patient.getInstanceName());
        UiUpdateHandler uiUpdateHandler = UiUpdateHandler.getUiUpdateHandler();
        
        
        // TODO: Need to assess whether we want to actually display this or not when changing Lung Patient
        uiUpdateHandler.updatePatientVitalsText(patientText(hlaRespiratoryPhysiology,
                patient.isGhosted()));
//        uiUpdateHandler.updatePatientTreatmentText(treatmentText(patient.getId()));
//        uiUpdateHandler.updatePatientInjuriesTextArea(injuryText(patient.getId()));

        uiUpdateHandler.updatePatientTreatmentText("");
        uiUpdateHandler.updatePatientInjuriesTextArea("");
    }
    
    private String patientText(HlaRespiratoryPhysiology respiratoryPhysiology, boolean ghost) {
        String pText = "Respiratory Patient " + respiratoryPhysiology.getHlaInstanceName();
        if(ghost){
            pText += " -- Ghost";
        }
        pText += "\n|- Patient ID: " + respiratoryPhysiology.getPatientID("ANON") +"\n";
        if(respiratoryPhysiology.hasLungDeadSpace()){
            pText += "|- LungDeadSpace: " + respiratoryPhysiology.getLungDeadSpace() +"\n";
        }
        if(respiratoryPhysiology.hasLungExpiratoryReserve()){
            pText += "|- LungExpiratoryReserve: " + respiratoryPhysiology.getLungExpiratoryReserve() +"\n";
        }
        if(respiratoryPhysiology.hasLungInspiratoryReserve()){
            pText += "|- LungInspiratoryReserve: " + respiratoryPhysiology.getLungInspiratoryReserve() +"\n";
        }
        if(respiratoryPhysiology.hasLungResidualVolume()){
            pText += "|- LungResidualVolume: " + respiratoryPhysiology.getLungResidualVolume() +"\n";
        }
        if(respiratoryPhysiology.hasLungTidalVolume()){
            pText += "|- LungTidalVolume: " + respiratoryPhysiology.getLungTidalVolume() +"\n";
        }
        if(respiratoryPhysiology.hasLungTotalCapacity()){
            pText += "|- LungTotalCapacity: " + respiratoryPhysiology.getLungTotalCapacity() +"\n";
        }
        
        return pText;
        
    }
    
    private class PatientRespiratoryUpdateListener implements HlaRespiratoryPhysiologyListener{
        
        @Override
        public void attributesUpdated (HlaRespiratoryPhysiology respiratoryPhysiology, 
                Set<HlaRespiratoryPhysiologyAttributes.Attribute> attributes, 
                HlaTimeStamp timeStamp,
                HlaLogicalTime logicalTime) {
            boolean isNewPatient = false;
            String patientId = respiratoryPhysiology.getPatientID("ANON");
            if(!respiratoryPhysiology.isLocal()) {
                Patient patient = patients.get(patientId);
                if(patient == null) {
                    patient = new Patient();
                    patient.setGhosted(true);
                    patient.setInstanceName(respiratoryPhysiology.getHlaInstanceName());
                    patient.setId(patientId);
                    isNewPatient = true;
                }
                
                patient.setTimeStamp(new Date().getTime());
                for(HlaRespiratoryPhysiologyAttributes.Attribute attribute : attributes) {
                    switch(attribute) {
                        case PATIENT_ID: patient.setId(patientId);
                                         break;
                        case LUNG_TIDAL_VOLUME: patient.setLungTidalVolume(respiratoryPhysiology.getLungTidalVolume());
                                         break;
                        case LUNG_DEAD_SPACE: patient.setLungDeadSpace(respiratoryPhysiology.getLungDeadSpace());
                                         break;
                        case LUNG_TOTAL_CAPACITY: patient.setLungTotalCapacity(respiratoryPhysiology.getLungTotalCapacity());
                                         break;
                        case LUNG_EXPIRATORY_RESERVE: patient.setLungExpiratoryReserve(respiratoryPhysiology.getLungExpiratoryReserve());
                                         break;
                        case LUNG_INSPIRATORY_RESERVE: patient.setLungInspiratoryReserve(respiratoryPhysiology.getLungInspiratoryReserve());
                                         break;
                        case LUNG_RESIDUAL_VOLUME: patient.setLungResidualVolume(respiratoryPhysiology.getLungResidualVolume());
                                         break;
                    }
                }
                patients.put(patient.getId(), patient);
                if(isNewPatient) {
                    UiUpdateHandler.getUiUpdateHandler().addToPatientList(patient);
                }
                logger.info("got patient: " + patient.toString());
                hlaLogger.trace(patient.csvString());
            }
            
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)) {
                displayPatient(patients.get(patientId));
            }
        }
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
                    case INJURY_DESCRIPTION:
                        injury.setDescription(hlaInjury.getInjuryDescription());
                        break;
                    case INJURY_ID:
                        injury.setInjuryId(hlaInjury.getInjuryId());
                        break;
                    case INJURY_LOCATION:
                        injury.setBodyLocationRecord(hlaInjury.getInjuryLocation());
                        break;
                    case INJURY_SEVERITY:
                        injury.setSeverity(hlaInjury.getInjurySeverity());
                        break;
                    case INJURY_TYPE:
                        injury.setInjuryType(hlaInjury.getInjuryType());
                        break;
                    case PATIENT_ID:
                        injury.setPatientId(hlaInjury.getPatientId());
                        break;
                    case TIME:
                        injury.setTime(hlaInjury.getTime());
                        break;
                }
            }
            if((focusedPatientId != null) & patientId.equalsIgnoreCase(focusedPatientId)){
                displayPatient(patients.get(patientId));                   
            }
        }
    }
    
    //--------------------------------------------------------------------------
    //      DisconnectListener Implementation
    //--------------------------------------------------------------------------
    @Override
    public void hlaDisconnected(){
    	patients.clear();
    	treatments.clear();
    	injuries.clear();
    	attributeChangers.clear();
        UiUpdateHandler uiUpdateHandler = UiUpdateHandler.getUiUpdateHandler();
	uiUpdateHandler.clearPatientList();
        uiUpdateHandler.updatePatientVitalsText("");
        uiUpdateHandler.updatePatientTreatmentText("");
        uiUpdateHandler.updatePatientInjuriesTextArea("");
    }     
    
}
