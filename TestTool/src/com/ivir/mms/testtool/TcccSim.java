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

import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTacticalCombatCasualtyCareCard;
import devstudio.generatedcode.HlaTacticalCombatCasualtyCareCardAttributes;
import devstudio.generatedcode.HlaTacticalCombatCasualtyCareCardManager;
import devstudio.generatedcode.HlaTacticalCombatCasualtyCareCardListener;
import devstudio.generatedcode.HlaTacticalCombatCasualtyCareCardUpdater;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.EvacuationCategoryEnum;
import devstudio.generatedcode.datatypes.GenderEnum;
import devstudio.generatedcode.datatypes.MechanismOfInjuryCommsRecord;
import devstudio.generatedcode.datatypes.SignsSymptomsRecord;
import devstudio.generatedcode.datatypes.TreatmentAirwayRecord;
import devstudio.generatedcode.datatypes.TreatmentBreathingRecord;
import devstudio.generatedcode.datatypes.TreatmentCirculatoryDressingRecord;
import devstudio.generatedcode.datatypes.TreatmentCirculatoryTourniquetRecord;
import devstudio.generatedcode.datatypes.TreatmentFluidRecord;
import devstudio.generatedcode.datatypes.ResponderRecord;
import java.util.HashMap;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class TcccSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(TcccSim.class);
    private final HashMap<String,Tccc> tcccCards = new HashMap<>();
    private HlaTacticalCombatCasualtyCareCardManager hlaTCCCManager = null;
    private String fucusedTcccId = null;
    private String selectedTccc = null;

    public TcccSim(){
       logger.info("Starting BookmarkSim");
       hlaTCCCManager = MmsFederate.getHlaWorld().getHlaTacticalCombatCasualtyCareCardManager();
       hlaTCCCManager.addHlaTacticalCombatCasualtyCareCardDefaultInstanceListener(new TcccSim.TcccListener());
    }
    
    
    public void createTccc(){
        try{
            HlaTacticalCombatCasualtyCareCard hlaTccc = hlaTCCCManager.createLocalHlaTacticalCombatCasualtyCareCard();
            HlaTacticalCombatCasualtyCareCardUpdater hlaTcccUpdater = hlaTccc.getHlaTacticalCombatCasualtyCareCardUpdater();
            hlaTcccUpdater.setPatientId("123456");
            hlaTcccUpdater.setBattleRosterNumber("255");
            hlaTcccUpdater.setEvacuationLevelRequest(EvacuationCategoryEnum.ROUTINE);
            hlaTcccUpdater.setLastName("Jones");
            hlaTcccUpdater.setFirstName("Jane");
            hlaTcccUpdater.setSocialSecurityAccountNumber("000");
            hlaTcccUpdater.setGender(GenderEnum.MALE);
            hlaTcccUpdater.setDate("28-SEP-18");
            hlaTcccUpdater.setTime("1330 L");
            hlaTcccUpdater.setService("USMC");
            hlaTcccUpdater.setUnit("3/A/1/3");
            hlaTcccUpdater.setAllergies("NKA");
            hlaTcccUpdater.setMechanismOfInjury(
                    MechanismOfInjuryCommsRecord.create(false, //artillery
                                                         false, //blunt
                                                         false, //burn
                                                         false, //fall
                                                         false, //grenade
                                                         false, //gSW
                                                         true, //iED
                                                         false, //landmine
                                                         false, //mVC
                                                         false, //rPG
                                                         false, // other
                                                         "")); //other notes
            hlaTcccUpdater.setSignsSymptoms(new SignsSymptomsRecord[]{
               SignsSymptomsRecord.create("", //time
                                                "118", //pulse
                                                100, //systolic bp
                                                60, //diastolic bp
                                                18, //respiratory rate
                                                0, //o2
                                                (byte)'A', //AVPU
                                                10)
            });
            hlaTcccUpdater.setTreatmentCirculatoryTourniquet(
                    TreatmentCirculatoryTourniquetRecord.create(true,  //extremity 
                                                                      "CAT", //extemity type
                                                                      false, //junctional
                                                                      "", //junctional type
                                                                      false, //truncal
                                                                      ""));  //truncal type
            hlaTcccUpdater.setTreatmentAirway(
                    TreatmentAirwayRecord.create(true,//intact 
                                                       false,//npa
                                                       false,//CRIC
                                                       false,//ET-Tube
                                                       false,//SGA
                                                       ""));
            hlaTcccUpdater.setTreatmentBreathing(
                    TreatmentBreathingRecord.create(false,//o2 
                                                          false,//needle-D 
                                                          false,//chest tube
                                                          true,//chest seal
                                                          "Occlusive"));
            hlaTcccUpdater.setTreatmentFluids(new TreatmentFluidRecord[]{
                TreatmentFluidRecord.create("NS",//name
                                                  500,//volume
                                                  "IV",//route
                                                  "1340") //time
            });
            
            hlaTcccUpdater.setTreatmentNotes("22 year old female patient was hit with secondary projectiles from IED blast.  Did not lose consciousness.  Had sucking chest wound.  Applied occlusive dressing.  Had part amputation of lower left leg.  CAT applied immediately.");
            hlaTcccUpdater.setResponder(ResponderRecord.create("Gittere",//last name 
                                                                     "Joshua",//first name
                                                                     "",//training level
                                                                     "1111"));//ID
            hlaTcccUpdater.sendUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Set<String> getListOfTcccCards(){
        return this.tcccCards.keySet();
    }
    
    public void focusTccc(String instanceName){
        this.fucusedTcccId = instanceName;
        displayTccc(instanceName);
    }
    
    private void displayTccc(String instanceName){
        Tccc tccc = this.tcccCards.get(instanceName);
        HlaTacticalCombatCasualtyCareCard hlaTccc = this.hlaTCCCManager.getTacticalCombatCasualtyCareCardByHlaInstanceName(instanceName);
        UiUpdateHandler.getUiUpdateHandler().updateTcccText(
              tcccText(tccc, hlaTccc)  
        );
    }
    
    private String tcccText(Tccc tccc, HlaTacticalCombatCasualtyCareCard hlaTccc){
        String tText = "TCCC " + tccc.getInstanceId();
        if(tccc.isGhosted()){
            tText += " -- Ghost";
        }
        tText += "\n";
        
        if(hlaTccc.hasPatientId()){
            tText += "|- Patient ID: " + hlaTccc.getPatientId() + "\n";
        }
        
        if(hlaTccc.hasBattleRosterNumber()){
            tText += "|- Battle Roster Number: " + hlaTccc.getBattleRosterNumber() + "\n";
        }
        if(hlaTccc.hasEvacuationLevelRequest()){
            EvacuationCategoryEnum record = hlaTccc.getEvacuationLevelRequest();
            tText += "+ EVAC " + record.getName() + "\n";
        }
        if(hlaTccc.hasLastName()){
            tText += "|- Last Name: " + hlaTccc.getLastName() + "\n";
        }
        if(hlaTccc.hasFirstName()){
            tText += "|- First Name: " + hlaTccc.getFirstName() + "\n";
        }
        if(hlaTccc.hasSocialSecurityAccountNumber()){
            tText += "|- SSAN: " + hlaTccc.getSocialSecurityAccountNumber() + "\n";
        }
        if(hlaTccc.hasGender()){
            GenderEnum record = hlaTccc.getGender();
            tText += "+ Gender " + record.getName() + "\n";
        }
        if(hlaTccc.hasDate()){
            tText += "|- Date: " + hlaTccc.getDate() + "\n";
        }
        if(hlaTccc.hasTime()){
            tText += "|- Time: " + hlaTccc.getTime() + "\n";
        }
        if(hlaTccc.hasService()){
            tText += "|- Service: " + hlaTccc.getService() + "\n";
        }
        if(hlaTccc.hasUnit()){
            tText += "|- Unit: " + hlaTccc.getUnit() + "\n";
        }
        if(hlaTccc.hasAllergies()){
            tText += "|- Allergies: " + hlaTccc.getAllergies() + "\n";
        }
        if(hlaTccc.hasMechanismOfInjury()){
            MechanismOfInjuryCommsRecord record = hlaTccc.getMechanismOfInjury();
            tText += "+ Mechanism Of Injury \n";
            tText += "   |- Artillery: " + String.valueOf(record.getArtillery());
            tText += ", Blunt: " + String.valueOf(record.getBlunt());
            tText += ", Burn: " + String.valueOf(record.getBurn()) + "\n";
            tText += "   |- Fall: " + String.valueOf(record.getFall());
            tText += ", GSW: " + String.valueOf(record.getGunShotWound());
            tText += ", Grenade: " + String.valueOf(record.getGrenade()) + "\n";
            tText += "   |- IED: " + String.valueOf(record.getImprovisedExplosiveDevice());
            tText += ", Landmine: " + String.valueOf(record.getLandMine());
            tText += ", MVC: " + String.valueOf(record.getMotorVehicleCollision()) + "\n";
            tText += "   |- RPG: " + String.valueOf(record.getRocketPropelledGrenade());
            tText += ", Other: " + String.valueOf(record.getOther()) + " - ";
            tText += record.getOtherCause() + "\n";
        }
        if(hlaTccc.hasSignsSymptoms()){
            tText += "+ Signs and Symptons \n";
            for(SignsSymptomsRecord record : hlaTccc.getSignsSymptoms()){
                tText += "   + Record \n";
                tText += "      |- Pulse: " + record.getPulse() + "\n";
                tText += "      |- BP: " + record.getSystolicBloodPressure();
                tText += "/" + record.getDiastolicBloodPressure() + "\n";
                tText += "      |- Respiratory: " + record.getRespiratoryRate() + "\n";
                // Need to revert below to say saturation when FOM is fixed
                tText += "      |- O2: " + record.getPulseOxO2aturation() + "\n";
                tText += "      |- AVPU: " + (char)record.getAlertnessLevel() + "\n";
                tText += "      |- Pain: " + record.getPainScale() + "\n";
            }
        }
        
        tText += "+ Treatments \n";
        tText += "   + C \n";
        if(hlaTccc.hasTreatmentCirculatoryTourniquet()){
            TreatmentCirculatoryTourniquetRecord record = hlaTccc.getTreatmentCirculatoryTourniquet();
            tText += "      |- TQ- Extremity: " + record.getExtremity();
            tText += ", Junctional: " + record.getJunctional();
            tText += ", Truncal: " + record.getTruncal();
            tText += ", Type: " + record.getExtremityType() + "\n";
        }
        if(hlaTccc.hasTreatmentCirculatoryDressing()){
            TreatmentCirculatoryDressingRecord record = hlaTccc.getTreatmentCirculatoryDressing();
            tText += "      |- Dressing- Hemostatic: " + record.getHemostatic();
            tText += ", Pressure: " + record.getPressure();
            tText += ", Other: " + record.getOther() + " - " + record.getOtherType() + "\n";
        }
        if(hlaTccc.hasTreatmentAirway()){
            TreatmentAirwayRecord record = hlaTccc.getTreatmentAirway();
            tText += "   + A \n";
            tText += "      |- Intact:" + record.getIntact();
            tText += ", NPA: " + record.getNasopharyngealAirway();
            tText += ", CRIC: " + record.getCricothyroidotomy();
            tText += ", ET-Tube: " + record.getEndotrachealTube();
            tText += ", SGA: " + record.getSupraglotticAirway() + "\n";
            tText += "      |- Type: " + record.getType() + "\n";
        }
        tText += "   + C: \n";
        for(TreatmentFluidRecord record : hlaTccc.getTreatmentFluids(new TreatmentFluidRecord[0])){
            tText += "      + Fluid:\n";
            tText += "         |- Name: " + record.getName() + "\n";
            tText += "         |- Volume: " + record.getVolume() + "\n";
            tText += "         |- Route: " + record.getRoute() + "\n";
            tText += "         |- Time: " + record.getTime() + "\n";
        }
        
        for(TreatmentFluidRecord record : hlaTccc.getTreatmentBloodProducts(new TreatmentFluidRecord[0])){
            tText += "      + Blood:\n";
            tText += "         |- Name: " + record.getName() + "\n";
            tText += "         |- Volume: " + record.getVolume() + "\n";
            tText += "         |- Route: " + record.getRoute() + "\n";
            tText += "         |- Time: " + record.getTime() + "\n";
        }
        tText += "   + MEDS: \n";
        tText += "   + OTHER: \n";
        
        if(hlaTccc.hasTreatmentNotes()){
            tText += "+ NOTES: \n";
            tText += "   |- " +  hlaTccc.getTreatmentNotes() + "\n";
        }

        if(hlaTccc.hasResponder()){
            tText += "+ First Responder \n";
            ResponderRecord record = hlaTccc.getResponder();
            tText += "   |- Last Name: " + record.getLastName() + "\n";
            tText += "   |- First Name: " + record.getFirstName() + "\n";
            tText += "   |- SSAN: " + record.getSocialSecurityAccountNumber() + "\n";
        }
        
        
        return tText;
    }
    
    private class TcccListener implements HlaTacticalCombatCasualtyCareCardListener{

        @Override
        public void attributesUpdated(HlaTacticalCombatCasualtyCareCard hlaTccc, Set<HlaTacticalCombatCasualtyCareCardAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            String instanceName = hlaTccc.getHlaInstanceName();
            Tccc tccc = tcccCards.get(instanceName);
            boolean isNewTccc = false;
            if(tccc == null){
                tccc = new Tccc();
                tccc.setInstanceId(instanceName);
                tccc.setGhosted(!hlaTccc.isLocal());
                tcccCards.put(instanceName, tccc);
                isNewTccc = true;
            }
            
            if(isNewTccc){
                UiUpdateHandler.getUiUpdateHandler().addToTcccList(tccc);
            }
            if((selectedTccc != null) && selectedTccc.equalsIgnoreCase(instanceName)){
                displayTccc(instanceName);
            }
        }
        
    }

    @Override
    public void hlaDisconnected(){
	tcccCards.clear();
        UiUpdateHandler.getUiUpdateHandler().clearTcccList();
	UiUpdateHandler.getUiUpdateHandler().updateTcccText("");
    }
}
