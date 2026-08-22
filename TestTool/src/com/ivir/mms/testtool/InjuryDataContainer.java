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
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.InjuryDescriptionEnum;
import devstudio.generatedcode.datatypes.InjuryTypeEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

// TODO: Need to figure out how we want to handle this
public class InjuryDataContainer {
    private enum InjuryObjectType {
        BURN,
        CHEMICAL_INGESTION,
        ENVENOMATION,
        HEMORRHAGE,
        IMMUNE_RESPONSE,
        RADIATION,
        TISSUE_DAMAGE,
        GENERIC,
        ROOT
    }
    
    private InjuryObjectType objectType;
    private HlaInjury genericInjury;
//    private HlaBurnInjury burnInjury;
//    private HlaChemicaIngestionlInjury chemicalInjury;
//    private HlaEnvenomationInjury envenomationInjury;
//    private HlaHemorrhageInjury hemorrhageInjury;
//    private HlaImmuneResponseInjury immuneInjury;
//    private HlaRadiationInjury radiationInjury;
//    private HlaTissueDamageInjury tissueInjury;
    
    public InjuryDataContainer(){
        this.objectType = InjuryObjectType.ROOT;
    }
    
    public InjuryDataContainer(HlaInjury injury){
        this.genericInjury = injury;
        this.objectType = InjuryObjectType.GENERIC;
    }
    
//    public InjuryDataContainer(HlaBurnInjury injury){
//        this.burnInjury = injury;
//        this.objectType = InjuryObjectType.BURN;
//    }
//
//    public InjuryDataContainer(HlaChemicaIngestionlInjury injury){
//        this.chemicalInjury = injury;
//        this.objectType = InjuryObjectType.CHEMICAL_INGESTION;
//    }
//    
//    public InjuryDataContainer(HlaEnvenomationInjury injury){
//        this.envenomationInjury = injury;
//        this.objectType = InjuryObjectType.ENVENOMATION;
//    }
//    
//    public InjuryDataContainer(HlaHemorrhageInjury injury){
//        this.hemorrhageInjury = injury;
//        this.objectType = InjuryObjectType.HEMORRHAGE;
//    }
//    
//    public InjuryDataContainer(HlaImmuneResponseInjury injury){
//        this.immuneInjury = injury;
//        this.objectType = InjuryObjectType.IMMUNE_RESPONSE;
//    }
//    
//    public InjuryDataContainer(HlaRadiationInjury injury){
//        this.radiationInjury = injury;
//        this.objectType = InjuryObjectType.RADIATION;
//    }
//    
//    public InjuryDataContainer(HlaTissueDamageInjury injury){
//        this.tissueInjury = injury;
//        this.objectType = InjuryObjectType.TISSUE_DAMAGE;
//    }
        
    public String getInstanceKey(){
        switch(this.objectType){
            case ROOT : 
                return "root";
            case GENERIC :
                return "GI_" + this.genericInjury.getHlaInstanceName();
//            case BURN :
//                return "BI_" + this.burnInjury.getHlaInstanceName();
//            case CHEMICAL_INGESTION : 
//                return "CI_" + this.chemicalInjury.getHlaInstanceName();
//            case ENVENOMATION : 
//                return "EI_" + this.envenomationInjury.getHlaInstanceName();
//            case HEMORRHAGE : 
//                return "HI_" + this.hemorrhageInjury.getHlaInstanceName();
//            case IMMUNE_RESPONSE : 
//                return "IRI_" + this.immuneInjury.getHlaInstanceName();
//            case RADIATION : 
//                return "RI_" + this.radiationInjury.getHlaInstanceName();
//            case TISSUE_DAMAGE : 
//                return "TDI_" + this.tissueInjury.getHlaInstanceName();
        }
        return "no_key";
    }
    
    public String getObjectTypeStr(){
        return this.objectType.toString();
    }
    
    public String getInjuryType(){
        switch(this.objectType){
            case GENERIC : return injuryTypeStringOrNull(this.genericInjury.getInjuryType(null));
//            case BURN : return injuryTypeStringOrNull(this.burnInjury.getInjuryType(null));
//            case CHEMICAL_INGESTION : return injuryTypeStringOrNull(this.chemicalInjury.getInjuryType(null));
//            case ENVENOMATION : return injuryTypeStringOrNull(this.envenomationInjury.getInjuryType(null));
//            case HEMORRHAGE : return injuryTypeStringOrNull(this.hemorrhageInjury.getInjuryType(null));
//            case IMMUNE_RESPONSE : return injuryTypeStringOrNull(this.immuneInjury.getInjuryType(null));
//            case RADIATION : return injuryTypeStringOrNull(this.radiationInjury.getInjuryType(null));
//            case TISSUE_DAMAGE : return injuryTypeStringOrNull(this.tissueInjury.getInjuryType(null));
        }
        return "no_type";    
    }
    
    private String injuryTypeStringOrNull(InjuryTypeEnum injuryType){
        if(injuryType == null){
            return null;
        }
        return injuryType.toString();
    }
    
    public String getInstanceName(){
        switch(this.objectType){
            case ROOT : return "root";
            case GENERIC : return this.genericInjury.getHlaInstanceName();
//            case BURN : return this.burnInjury.getHlaInstanceName();
//            case CHEMICAL_INGESTION : return this.chemicalInjury.getHlaInstanceName();
//            case ENVENOMATION : return this.envenomationInjury.getHlaInstanceName();
//            case HEMORRHAGE : return this.hemorrhageInjury.getHlaInstanceName();
//            case IMMUNE_RESPONSE : return this.immuneInjury.getHlaInstanceName();
//            case RADIATION : return this.radiationInjury.getHlaInstanceName();
//            case TISSUE_DAMAGE : return this.tissueInjury.getHlaInstanceName();
        }
        return "no_instance_name";
    }
    
    public boolean isLocal(){
        switch(this.objectType){
            case GENERIC : return this.genericInjury.isLocal();
//            case BURN : return this.burnInjury.isLocal();
//            case CHEMICAL_INGESTION : return this.chemicalInjury.isLocal();
//            case ENVENOMATION : return this.envenomationInjury.isLocal();
//            case HEMORRHAGE : return this.hemorrhageInjury.isLocal();
//            case IMMUNE_RESPONSE : return this.immuneInjury.isLocal();
//            case RADIATION : return this.radiationInjury.isLocal();
//            case TISSUE_DAMAGE : return this.tissueInjury.isLocal();
        }
        return true;
    }
    
    public String getPatientId(){
        switch(this.objectType){
            case GENERIC : return this.genericInjury.getPatientId("empty");
//            case BURN : return this.burnInjury.getPatientId("empty");
//            case CHEMICAL_INGESTION : return this.chemicalInjury.getPatientId("empty");
//            case ENVENOMATION : return this.envenomationInjury.getPatientId("empty");
//            case HEMORRHAGE : return this.hemorrhageInjury.getPatientId("empty");
//            case IMMUNE_RESPONSE : return this.immuneInjury.getPatientId("empty");
//            case RADIATION : return this.radiationInjury.getPatientId("empty");
//            case TISSUE_DAMAGE : return this.tissueInjury.getPatientId("empty");
        }
        return "no_pid";
    }
    
    public String getTime(){
        switch(this.objectType){
            case GENERIC : 
                return String.valueOf(this.genericInjury.getTime(0));
//            case BURN : 
//                return String.valueOf(this.burnInjury.getTime(0));
//            case CHEMICAL_INGESTION : 
//                return String.valueOf(this.chemicalInjury.getTime(0));
//            case ENVENOMATION : 
//                return String.valueOf(this.envenomationInjury.getTime(0));
//            case HEMORRHAGE : 
//                return String.valueOf(this.hemorrhageInjury.getTime(0));
//            case IMMUNE_RESPONSE : 
//                return String.valueOf(this.immuneInjury.getTime(0));
//            case RADIATION : 
//                return String.valueOf(this.radiationInjury.getTime(0));
//            case TISSUE_DAMAGE : 
//                return String.valueOf(this.tissueInjury.getTime(0));
        }
        return "no_time";
    }
    
    public String getInjuryId(){
        switch(this.objectType){
            case GENERIC : return this.genericInjury.getInjuryId("empty");
//            case BURN : return this.burnInjury.getInjuryId("empty");
//            case CHEMICAL_INGESTION : return this.chemicalInjury.getInjuryId("empty");
//            case ENVENOMATION : return this.envenomationInjury.getInjuryId("empty");
//            case HEMORRHAGE : return this.hemorrhageInjury.getInjuryId("empty");
//            case IMMUNE_RESPONSE : return this.immuneInjury.getInjuryId("empty");
//            case RADIATION : return this.radiationInjury.getInjuryId("empty");
//            case TISSUE_DAMAGE : return this.tissueInjury.getInjuryId("empty");
        }
        return "no_injury_id";
    }
    
    public BodyLocationRecord getLocation(){
        switch(this.objectType){
            case GENERIC :
                return this.genericInjury.getInjuryLocation(null);
//                return concatenateLocations(this.genericInjury.getInjuryLocation(null));
//            case BURN :
//                return concatenateLocations(this.burnInjury.getInjuryLocation(null));
//            case CHEMICAL_INGESTION : 
//                return concatenateLocations(this.chemicalInjury.getInjuryLocation(null));
//            case ENVENOMATION : 
//                return concatenateLocations(this.envenomationInjury.getInjuryLocation(null));
//            case HEMORRHAGE : 
//                return concatenateLocations(this.hemorrhageInjury.getInjuryLocation(null));
//            case IMMUNE_RESPONSE : 
//                return concatenateLocations(this.immuneInjury.getInjuryLocation(null));
//            case RADIATION : 
//                return concatenateLocations(this.radiationInjury.getInjuryLocation(null));
//            case TISSUE_DAMAGE : 
//                return concatenateLocations(this.tissueInjury.getInjuryLocation(null));
        }
        return BodyLocationRecord.create(
                        GeneralRegionEnum.NOT_APPLICABLE, 
                        RegionTissueTypeEnum.NOT_APPLICABLE, 
                        InternalAnatomyEnum.NOT_APPLICABLE, 
                        SagittalPlaneEnum.NOT_APPLICABLE, 
                        TransversePlaneEnum.NOT_APPLICABLE, 
                        CoronalPlaneEnum.NOT_APPLICABLE, 
                        SkeletalSystemEnum.NOT_APPLICABLE, 
                        DetailedAnatomyEnum.NOT_APPLICABLE, 
                        0);
    }
    
//    public List<String> concatenateLocations(BodyLocationFineEnum[] locArray){
//        ArrayList<String> locStrArray = new ArrayList<>();
//  
//        if((locArray == null) || (locArray.length == 0)){
//            return locStrArray;
//        }
//        
//        for(BodyLocationFineEnum locEnum : Arrays.asList(locArray)){
//            locStrArray.add(locEnum.toString());
//        }
//        
//        return locStrArray;
//    }
    
    public InjuryDescriptionEnum getDescription(){
        switch(this.objectType){
            case GENERIC :
                return this.genericInjury.getInjuryDescription(InjuryDescriptionEnum.NOT_APPLICABLE);
//            case BURN : 
//                return this.burnInjury.getInjuryDescription("empty");
//            case CHEMICAL_INGESTION : 
//                return this.chemicalInjury.getInjuryDescription("empty");
//            case ENVENOMATION : 
//                return this.envenomationInjury.getInjuryDescription("empty");
//            case HEMORRHAGE : 
//                return this.hemorrhageInjury.getInjuryDescription("empty");
//            case IMMUNE_RESPONSE : 
//                return this.immuneInjury.getInjuryDescription("empty");
//            case RADIATION : 
//                return this.radiationInjury.getInjuryDescription("empty");
//            case TISSUE_DAMAGE : 
//                return this.tissueInjury.getInjuryDescription("empty");
        }
        return InjuryDescriptionEnum.NOT_APPLICABLE;
    }
    
    public Integer getServerity(){
        switch(this.objectType){
            case GENERIC : 
                return this.genericInjury.getInjurySeverity(-1);
//            case BURN : 
//                return this.burnInjury.getInjurySeverity(-1);
//            case CHEMICAL_INGESTION : 
//                return this.chemicalInjury.getInjurySeverity(-1);
//            case ENVENOMATION : 
//                return this.envenomationInjury.getInjurySeverity(-1);
//            case HEMORRHAGE : 
//                return this.hemorrhageInjury.getInjurySeverity(-1);
//            case IMMUNE_RESPONSE : 
//                return this.immuneInjury.getInjurySeverity(-1);
//            case RADIATION : 
//                return this.radiationInjury.getInjurySeverity(-1);
//            case TISSUE_DAMAGE : 
//                return this.tissueInjury.getInjurySeverity(-1);
        }
        return -1;
    }
    
    public float getHemorrhageRate(){
        return this.genericInjury.getHemorrhageRate(0);
    }
    
    public float getTotalBodyArea(){
        return this.genericInjury.getTotalBodySurfaceArea(0);
    }
    
    public List<String> getDetails(){
        switch(this.objectType){
            case GENERIC : 
                return new ArrayList<>();
//            case BURN : 
//                return getBurnDetails();
//            case CHEMICAL_INGESTION : 
//                return getChemicalIngestionDetails();
//            case ENVENOMATION : 
//                return getEnvenomationDetails();
//            case HEMORRHAGE : 
//                return getHemorrhageDetails();
//            case IMMUNE_RESPONSE : 
//                return getImmuneResponseDetails();
//            case RADIATION : 
//                return getRadiationDetails();
//            case TISSUE_DAMAGE : 
//                return getTissueDamageDetails();
        }
        return new ArrayList<>();
    }
    
//    private List<String> getChemicalIngestionDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.chemicalInjury.hasChemicalPH()){
//            list.add("Chemical PH: " + this.chemicalInjury.getChemicalPH(-1));
//        }
//        if(this.chemicalInjury.hasChemicalExposure()){
//            list.add("Chemical Exposure: "+ this.chemicalInjury.getChemicalExposure(false));
//        }
//        if(this.chemicalInjury.hasChemicalDosage()){
//            list.add("Chemical Dosage: "+ this.chemicalInjury.getChemicalDosage(-1));
//        }
//        return list;
//    }
//    
//    private List<String> getEnvenomationDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.envenomationInjury.hasVenomType()){
//            list.add("Venom Type: " +
//                    this.envenomationInjury.getVenomType());
//        }
//        if(this.envenomationInjury.hasVenomDose()){
//            list.add("Venom Dose: " +
//                    this.envenomationInjury.getVenomDose());
//        }
//        return list;
//    }
//    
//    private List<String> getHemorrhageDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.hemorrhageInjury.hasHemorrhageRate()){
//            list.add("Hemorrhage Rate: " +
//                this.hemorrhageInjury.getHemorrhageRate());
//        }
//        return list;
//    }
//    
//    private List<String> getImmuneResponseDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.immuneInjury.hasImmuneTrigger()){
//            list.add("Immune Trigger: " +
//                    this.immuneInjury.getImmuneTrigger());
//        }
//        return list;
//    }
//    
//    private List<String> getRadiationDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.radiationInjury.hasExposureTime()){
//            list.add("Exposure Time: " +
//                this.radiationInjury.getExposureTime());
//        }
//        return list;
//    }
//        
//    private List<String> getTissueDamageDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.tissueInjury.hasTissueType()){
//            list.add("Tissue Type: " +
//                this.tissueInjury.getTissueType());
//        }
//        return list;
//    }    
//    
//    private List<String> getBurnDetails(){
//        ArrayList<String> list = new ArrayList<>();
//        if(this.burnInjury.hasBurnDegree()){
//            list.add("Burn Degree: " +
//                this.burnInjury.getBurnDegree());
//        }
//        if(this.burnInjury.hasBurnDegree()){
//            list.add("Burn Type: " +
//                this.burnInjury.getBurnType());
//        }
//        if(this.burnInjury.hasTotalBodySurfaceArea()){
//            list.add("Total Body Surface Area: " +
//                this.burnInjury.getTotalBodySurfaceArea());
//        }
//        return list;
//    }
//    
    public String toString(){
        return this.getInstanceName();
    }

}
