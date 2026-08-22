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
import devstudio.generatedcode.*;
import devstudio.generatedcode.datatypes.FacilityTypeEnum;
import devstudio.generatedcode.datatypes.RoleOfCareEnum;

import java.util.HashSet;
import java.util.Set;

public class FacilitySim implements DisconnectListener{
	HlaFacilityManager facilityManager;
	HashSet<String> knownInstances = new HashSet<>();

	public FacilitySim(){
		facilityManager = MmsFederate.getHlaWorld().getHlaFacilityManager();
		facilityManager.addHlaFacilityDefaultInstanceListener(new FacilityListener());
	}

	public void createFacility(String facilityId, String facilityType, String patientCapacity, String roleOfCare){
		try{
			HlaFacility hlaFacility = this.facilityManager.createLocalHlaFacility();
			update(hlaFacility, facilityId, facilityType, patientCapacity, roleOfCare);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateFacility(String instanceName, String facilityId, String facilityType, String patientCapacity, String roleOfCare){
		HlaFacility hlaFacility = facilityManager.getFacilityByHlaInstanceName(instanceName);
		update(hlaFacility, facilityId, facilityType, patientCapacity, roleOfCare);
	}

	private void update(HlaFacility hlaFacility, String facilityId, String facilityType, String patientCapacity, String roleOfCare) {
		try {
			hlaFacility = this.facilityManager.createLocalHlaFacility();
			HlaFacilityUpdater facilityUpdater = hlaFacility.getHlaFacilityUpdater();

			if(facilityId != null) facilityUpdater.setFacilityId(facilityId);
			if(facilityType != null) facilityUpdater.setFacilityType(toFacilityType(facilityType));
			if(patientCapacity != null) facilityUpdater.setPatientCapacity(Integer.parseInt(patientCapacity));
			if(roleOfCare != null) facilityUpdater.setRoleOfCare(toRoleOfCare(roleOfCare));
			facilityUpdater.sendUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private FacilityTypeEnum toFacilityType(String value){
		if(value == null) return null;
		if(value.isEmpty()) return null;
		if(value.equalsIgnoreCase("Fixed")) return FacilityTypeEnum.FIXED;
		if(value.equalsIgnoreCase("Ground")) return FacilityTypeEnum.GROUND;
		if(value.equalsIgnoreCase("Air")) return FacilityTypeEnum.AIR;
		return null;
	}

	private RoleOfCareEnum toRoleOfCare(String value){
		if(value == null) return null;
		if(value.isEmpty()) return null;
		if(value.equalsIgnoreCase("Role 1")) return RoleOfCareEnum.ROLE1;
		if(value.equalsIgnoreCase("Role 2")) return RoleOfCareEnum.ROLE2;
		if(value.equalsIgnoreCase("Role 3")) return RoleOfCareEnum.ROLE3;
		if(value.equalsIgnoreCase("Role 4")) return RoleOfCareEnum.ROLE4;
		if(value.equalsIgnoreCase("En Route")) return RoleOfCareEnum.EN_ROUTE;
		return null;
	}

	public PairTreeBuilder getDetails(String instanceName){
		HlaFacility facility = facilityManager.getFacilityByHlaInstanceName(instanceName);
		if(facility == null){
			return null;
		}
		PairTreeBuilder treeBuilder =  new PairTreeBuilder("Facility",instanceName)
				.addChild("facilityId", facility.getFacilityId("<>"))
				.addSibling("facilityType", facility.getFacilityType(null))
				.addSibling("patientCapacity", facility.getPatientCapacity())
				.addSibling("roleOfCare", facility.getRoleOfCare());
		if(facility.hasLocation()){
			treeBuilder.addSibling("location", null)
				.addChild("latitude",facility.getLocation().getLatitude())
					.addSibling("longitude",facility.getLocation().getLongitude())
					.addSibling("altitude", facility.getLocation().getAltitude());
		}
		return treeBuilder;
	}

	@Override
	public void hlaDisconnected() {
		UiUpdateHandler.getUiUpdateHandler().clearFacilities();
		knownInstances.clear();
	}


	private class FacilityListener implements HlaFacilityListener{

		@Override
		public void attributesUpdated(HlaFacility facility, Set<HlaFacilityAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
			String instanceName = facility.getHlaInstanceName();
			if(!knownInstances.contains(instanceName)){
				knownInstances.add(instanceName);
				UiUpdateHandler.getUiUpdateHandler().addToFacilityList(instanceName);
			}	
		}
		
	}


}
