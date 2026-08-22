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

import devstudio.generatedcode.HlaBloodGasLab;
import devstudio.generatedcode.HlaBloodGasLabAttributes;
import devstudio.generatedcode.HlaBloodGasLabListener;
import devstudio.generatedcode.HlaBloodGasLabManager;
import devstudio.generatedcode.HlaBloodGasLabUpdater;
import devstudio.generatedcode.HlaBloodLab;
import devstudio.generatedcode.HlaBloodLabAttributes;
import devstudio.generatedcode.HlaBloodLabListener;
import devstudio.generatedcode.HlaBloodLabManager;
import devstudio.generatedcode.HlaBloodLabUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.HlaUrineLab;
import devstudio.generatedcode.HlaUrineLabAttributes;
import devstudio.generatedcode.HlaUrineLabListener;
import devstudio.generatedcode.HlaUrineLabManager;
import devstudio.generatedcode.HlaUrineLabUpdater;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LabDataSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(LabDataSim.class);
    private final HlaBloodLabManager hlaBloodManager;
    private final HlaBloodGasLabManager hlaBloodGasManager;
    private final HlaUrineLabManager hlaUrineManager;
    private ConcurrentHashMap<String,LabDataContainer> instanceToContainerMap = new ConcurrentHashMap<>();

    public LabDataSim(){
        hlaBloodManager = MmsFederate.getHlaWorld().getHlaBloodLabManager();
        hlaBloodGasManager = MmsFederate.getHlaWorld().getHlaBloodGasLabManager();
        hlaUrineManager = MmsFederate.getHlaWorld().getHlaUrineLabManager();
        HlaLabListener listener = new HlaLabListener();
        hlaBloodManager.addHlaBloodLabDefaultInstanceListener(listener);
        hlaBloodGasManager.addHlaBloodGasLabDefaultInstanceListener(listener);
        hlaUrineManager.addHlaUrineLabDefaultInstanceListener(listener);
    }
    
    public void createBloodLab(String patientId, Long time, Float sodium, Float potassium,
            Float chloride, Float lactate, Float ketones, Float bicarbonate,
            Float glucose, Float fattyAcids, Float triglycerides, 
            Float creatinine, Float ureaNitrogen, Float pH, Float ionizedCalcium,
            Float phosphate, Float hematocrit, Float hemoglobin){
        try {
            HlaBloodLab bloodLab = hlaBloodManager.createLocalHlaBloodLab();
            HlaBloodLabUpdater updater = bloodLab.getHlaBloodLabUpdater();
            if(patientId != null){
                updater.setPatientId(patientId);
            }
            if(time != null){
                updater.setTime(time);
            }
            if(sodium != null){
                updater.setBloodSodium(sodium);
            }
            if(potassium != null){
                updater.setPotassium(potassium);
            }
            if(chloride != null){
                updater.setBloodChloride(chloride);
            }
            if(lactate != null){
                updater.setLactate(lactate);
            }
            if(ketones != null){
                updater.setBloodKetones(ketones);
            }
            if(bicarbonate != null){
                updater.setBloodBicarbonate(bicarbonate);
            }
            if(glucose != null){
                updater.setBloodGlucose(glucose);
            }
            if(fattyAcids != null){
                updater.setFattyAcids(fattyAcids);
            }
            if(triglycerides != null){
                updater.setTriglycerides(triglycerides);
            }
            if(creatinine != null){
                updater.setBloodCreatinine(creatinine);
            }
            if(ureaNitrogen != null){
                updater.setBloodUreaNitrogen(ureaNitrogen);
            }
            if(pH != null){
                updater.setBloodPh(pH);
            }
            if(ionizedCalcium != null){
                updater.setIonizedCalcium(ionizedCalcium);
            }
            if(phosphate != null){
                updater.setBloodPhosphate(phosphate);
            }
            if(hematocrit != null){
                updater.setHematocrit(hematocrit);
            }
            if(hemoglobin != null){
                updater.setHemoglobin(hemoglobin);
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }
    
        public void createBloodLab(BloodLab bloodLab){
        try {
            HlaBloodLab hlaBloodLab = hlaBloodManager.createLocalHlaBloodLab();
            HlaBloodLabUpdater updater = hlaBloodLab.getHlaBloodLabUpdater();
            if(bloodLab.getPatientId() != null){
                updater.setPatientId(bloodLab.getPatientId());
            }
            if(bloodLab.getTime() != null){
                updater.setTime(bloodLab.getTime());
            }
            if(bloodLab.getSodium() != null){
                updater.setBloodSodium(bloodLab.getSodium());
            }
            if(bloodLab.getPotassium() != null){
                updater.setPotassium(bloodLab.getPotassium());
            }
            if(bloodLab.getChloride() != null){
                updater.setBloodChloride(bloodLab.getChloride());
            }
            if(bloodLab.getLactate() != null){
                updater.setLactate(bloodLab.getLactate());
            }
            if(bloodLab.getKetones() != null){
                updater.setBloodKetones(bloodLab.getKetones());
            }
            if(bloodLab.getBicarbonate() != null){
                updater.setBloodBicarbonate(bloodLab.getBicarbonate());
            }
            if(bloodLab.getGlucose() != null){
                updater.setBloodGlucose(bloodLab.getGlucose());
            }
            if(bloodLab.getFattyAcids() != null){
                updater.setFattyAcids(bloodLab.getFattyAcids());
            }
            if(bloodLab.getTriglycerides() != null){
                updater.setTriglycerides(bloodLab.getTriglycerides());
            }
            if(bloodLab.getCreatinine() != null){
                updater.setBloodCreatinine(bloodLab.getCreatinine());
            }
            if(bloodLab.getUreaNitrogen() != null){
                updater.setBloodUreaNitrogen(bloodLab.getUreaNitrogen());
            }
            if(bloodLab.getpH() != null){
                updater.setBloodPh(bloodLab.getpH());
            }
            if(bloodLab.getIonizedCalcium() != null){
                updater.setIonizedCalcium(bloodLab.getIonizedCalcium());
            }
            if(bloodLab.getPhosphate() != null){
                updater.setBloodPhosphate(bloodLab.getPhosphate());
            }
            if(bloodLab.getHematocrit() != null){
                updater.setHematocrit(bloodLab.getHematocrit());
            }
            if(bloodLab.getHemoglobin() != null){
                updater.setHemoglobin(bloodLab.getHemoglobin());
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }
    
    public void createBloodGasLab(String patientId, Long time, 
            Float partialPressureCarbonDioxide, Float partialPressureOxygen,
            Float sulfurDioxide, Float totalCarbonDioxide){
        try {
            HlaBloodGasLab bloodGasLab = hlaBloodGasManager.createLocalHlaBloodGasLab();
            HlaBloodGasLabUpdater updater = bloodGasLab.getHlaBloodGasLabUpdater();
            if(patientId != null){
                updater.setPatientId(patientId);
            }
            if(time != null){
                updater.setTime(time);
            }
            if(partialPressureCarbonDioxide != null){
                updater.setPartialPressureCarbonDioxide(partialPressureCarbonDioxide);
            }
            if(partialPressureOxygen != null){
                updater.setPartialPressureOxygen(partialPressureOxygen);
            }
            if(sulfurDioxide != null){
                updater.setSulfurDioxide(sulfurDioxide);
            }
            if(totalCarbonDioxide != null){
                updater.setTotalCarbonDioxide(totalCarbonDioxide);
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }
    
        public void createBloodGasLab(BloodGasLab bloodGasLab){
        try {
            HlaBloodGasLab hlaBloodGasLab = hlaBloodGasManager.createLocalHlaBloodGasLab();
            HlaBloodGasLabUpdater updater = hlaBloodGasLab.getHlaBloodGasLabUpdater();
            if(bloodGasLab.getPatientId() != null){
                updater.setPatientId(bloodGasLab.getPatientId());
            }
            if(bloodGasLab.getTime() != null){
                updater.setTime(bloodGasLab.getTime());
            }
            if(bloodGasLab.getPartialPressureCarbonDioxide() != null){
                updater.setPartialPressureCarbonDioxide(bloodGasLab.getPartialPressureCarbonDioxide());
            }
            if(bloodGasLab.getPartialPressureOxygen() != null){
                updater.setPartialPressureOxygen(bloodGasLab.getPartialPressureOxygen());
            }
            if(bloodGasLab.getSulfurDioxide() != null){
                updater.setSulfurDioxide(bloodGasLab.getSulfurDioxide());
            }
            if(bloodGasLab.getTotalCarbonDioxide() != null){
                updater.setTotalCarbonDioxide(bloodGasLab.getTotalCarbonDioxide());
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }
   
    public void createUrineLab(String patientId, Long time, Float sodium,
            Float chloride, Float ammonia, Float ketones, Float bicarbonate,
            Float glucose, Float protein, Float creatinine, Float ureaNitrogen, 
            Float ionizedCalcium, Float phosphate){
        try {
            HlaUrineLab urineLab = hlaUrineManager.createLocalHlaUrineLab();
            HlaUrineLabUpdater updater = urineLab.getHlaUrineLabUpdater();
            if(patientId != null){
                updater.setPatientId(patientId);
            }
            if(time != null){
                updater.setTime(time);
            }
            if(sodium != null){
                updater.setUrineSodium(sodium);
            }
            if(chloride != null){
                updater.setUrineChloride(chloride);
            }
            if(creatinine != null){
                updater.setUrineCreatinine(creatinine);
            }
            if(glucose != null){
                updater.setUrineGlucose(glucose);
            }
            if(bicarbonate != null){
                updater.setUrineBicarbonate(bicarbonate);
            }
            if(ketones != null){
                updater.setUrineKetones(ketones);
            }
            if(ammonia != null){
                updater.setAmmonia(ammonia);
            }
            if(phosphate != null){
                updater.setUrinePhosphate(phosphate);
            }
            if(ureaNitrogen != null){
                updater.setUrineUreaNitrogen(ureaNitrogen);
            }
            if(protein != null){
                updater.setProtein(protein);
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }
    
        public void createUrineLab(UrineLab urineLab){
        try {
            HlaUrineLab hlaUrineLab = hlaUrineManager.createLocalHlaUrineLab();
            HlaUrineLabUpdater updater = hlaUrineLab.getHlaUrineLabUpdater();
            if(urineLab.getPatientId() != null){
                updater.setPatientId(urineLab.getPatientId());
            }
            if(urineLab.getTime() != null){
                updater.setTime(urineLab.getTime());
            }
            if(urineLab.getSodium() != null){
                updater.setUrineSodium(urineLab.getSodium());
            }
            if(urineLab.getChloride() != null){
                updater.setUrineChloride(urineLab.getChloride());
            }
            if(urineLab.getCreatinine() != null){
                updater.setUrineCreatinine(urineLab.getCreatinine());
            }
            if(urineLab.getGlucose() != null){
                updater.setUrineGlucose(urineLab.getGlucose());
            }
            if(urineLab.getBicarbonate() != null){
                updater.setUrineBicarbonate(urineLab.getBicarbonate() );
            }
            if(urineLab.getKetones() != null){
                updater.setUrineKetones(urineLab.getKetones());
            }
            if(urineLab.getAmmonia() != null){
                updater.setAmmonia(urineLab.getAmmonia());
            }
            if(urineLab.getPhosphate() != null){
                updater.setUrinePhosphate(urineLab.getPhosphate());
            }
            if(urineLab.getUreaNitrogen() != null){
                updater.setUrineUreaNitrogen(urineLab.getUreaNitrogen() );
            }
            if(urineLab.getProtein() != null){
                updater.setProtein(urineLab.getProtein());
            }
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            logger.error(ex);
        }
    }

    
    private class HlaLabListener implements HlaBloodLabListener, HlaBloodGasLabListener, HlaUrineLabListener{

        @Override
        public void attributesUpdated(HlaBloodLab bloodLab, Set<HlaBloodLabAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            LabDataContainer container = new LabDataContainer(bloodLab);
            instanceToContainerMap.put(container.getInstanceKey(), container);
            UiUpdateHandler.getUiUpdateHandler().newLabData(container);
        }

        @Override
        public void attributesUpdated(HlaBloodGasLab bloodGasLab, Set<HlaBloodGasLabAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            LabDataContainer container = new LabDataContainer(bloodGasLab);
            instanceToContainerMap.put(container.getInstanceKey(), container);
            UiUpdateHandler.getUiUpdateHandler().newLabData(container);
        }

        @Override
        public void attributesUpdated(HlaUrineLab urineLab, Set<HlaUrineLabAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            LabDataContainer container = new LabDataContainer(urineLab);
            instanceToContainerMap.put(container.getInstanceKey(), container);
            UiUpdateHandler.getUiUpdateHandler().newLabData(container);
        }
        
    }

    @Override
    public void hlaDisconnected(){
	instanceToContainerMap.clear();
        UiUpdateHandler.getUiUpdateHandler().clearLabData();
    }
    
}
