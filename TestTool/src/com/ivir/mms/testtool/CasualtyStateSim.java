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
import devstudio.generatedcode.HlaCasualtyState;
import devstudio.generatedcode.HlaCasualtyStateAttributes;
import devstudio.generatedcode.HlaCasualtyStateListener;
import devstudio.generatedcode.HlaCasualtyStateManager;
import devstudio.generatedcode.HlaCasualtyStateUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.EvacuationPriorityEnum;
import devstudio.generatedcode.datatypes.TriageEnum;
import java.util.HashSet;
import java.util.Set;

public class CasualtyStateSim implements DisconnectListener{
	HlaCasualtyStateManager casualtyStateManager;
	HashSet<String> knownInstances = new HashSet<>();

	public CasualtyStateSim(){
		casualtyStateManager = MmsFederate.getHlaWorld().getHlaCasualtyStateManager();
		casualtyStateManager.addHlaCasualtyStateDefaultInstanceListener(new CasualtyStateListener());
	}

	public void createCasualtyState(String patientId, String facilityId, String evacuationPriority, String triage){
		try{
			HlaCasualtyState hlaState = this.casualtyStateManager.createLocalHlaCasualtyState();
			update(hlaState, patientId, facilityId, evacuationPriority, triage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateCasualtyState(String instanceName, String patientId, String facilityId, String evacuationPriority, String triage){
		HlaCasualtyState hlaState = casualtyStateManager.getCasualtyStateByHlaInstanceName(instanceName);
		update(hlaState, patientId, facilityId, evacuationPriority, triage);
	}

	private void update(HlaCasualtyState hlaState, String patientId, String facilityId, String evacuationPriority, String triage) {
		try {
			hlaState = this.casualtyStateManager.createLocalHlaCasualtyState();
			HlaCasualtyStateUpdater stateUpdater = hlaState.getHlaCasualtyStateUpdater();

			if (patientId != null) stateUpdater.setPatientId(patientId);
			if (facilityId != null) stateUpdater.setFacilityId(facilityId);
			if (evacuationPriority != null)
				stateUpdater.setEvacuationPriority(toEvacuationPriorityEnum(evacuationPriority));
			if (triage != null) stateUpdater.setTriageClassification(toTriageEnum(triage));
			stateUpdater.sendUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private EvacuationPriorityEnum toEvacuationPriorityEnum(String value){
		if(value == null) return null;
		if(value.isEmpty()) return null;
		if(value.equalsIgnoreCase("Urgent")) return EvacuationPriorityEnum.URGENT;
		if(value.equalsIgnoreCase("Urgent Surgical")) return EvacuationPriorityEnum.URGENT_SURGICAL;
		if(value.equalsIgnoreCase("Priority")) return EvacuationPriorityEnum.PRIORITY;
		if(value.equalsIgnoreCase("Routine")) return EvacuationPriorityEnum.ROUTINE;
		if(value.equalsIgnoreCase("Convenience")) return EvacuationPriorityEnum.CONVENIENCE;
		return EvacuationPriorityEnum.NOT_APPLICABLE;
	}

	private TriageEnum toTriageEnum(String value){
		if(value == null) return null;
		if(value.isEmpty()) return null;
		if(value.equalsIgnoreCase("Delayed")) return TriageEnum.DELAYED;
		if(value.equalsIgnoreCase("Immediate")) return TriageEnum.IMMEDIATE;
		if(value.equalsIgnoreCase("Expectant")) return TriageEnum.EXPECTANT;
		if(value.equalsIgnoreCase("Minimal")) return TriageEnum.MINIMAL;
		return null;
	}

	public PairTreeBuilder getDetails(String instanceName){
		HlaCasualtyState state = casualtyStateManager.getCasualtyStateByHlaInstanceName(instanceName);
		if(state == null){
			return null;
		}
		return new PairTreeBuilder("CasualtyState",instanceName)
				.addChild("patientId",state.getPatientId("<>"))
				.addSibling("facilityId", state.getFacilityId("<>"))
				.addSibling("evacuationPriority", state.getEvacuationPriority(null))
				.addSibling("triageClassification", state.getTriageClassification(null));
	}

	@Override
	public void hlaDisconnected() {
		UiUpdateHandler.getUiUpdateHandler().clearCasualtyState();
		knownInstances.clear();
	}


	private class CasualtyStateListener implements HlaCasualtyStateListener{

		@Override
		public void attributesUpdated(HlaCasualtyState casualtyState, Set<HlaCasualtyStateAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
			String instanceName = casualtyState.getHlaInstanceName();
			if(!knownInstances.contains(instanceName)){
				knownInstances.add(instanceName);
				UiUpdateHandler.getUiUpdateHandler().addToCasualtyStateList(instanceName);
			}	
		}
		
	}


}
