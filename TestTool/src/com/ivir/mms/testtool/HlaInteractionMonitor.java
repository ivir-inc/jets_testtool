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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import devstudio.generatedcode.HlaInteractionListener;
import devstudio.generatedcode.HlaInteractionManager;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.MedicalEvacuationStateEnum;
import devstudio.generatedcode.datatypes.TransportTypeEnum;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HlaInteractionMonitor implements HlaInteractionListener, DisconnectListener {

	private static final Logger logger = LogManager.getLogger(HlaInteractionMonitor.class);
	private static final org.apache.logging.log4j.Logger hlaLogger = LogManager.getLogger("hla_trace");
	private LinkedList<String> patientInteractionHistory = new LinkedList<>();
	private LinkedList<String> controlInteractionHistory = new LinkedList<>();
	private int historySize = 20;
	private DateTimeSim dateTimeSim = null;

	public void setDateTimeSim(DateTimeSim dts) {
		this.dateTimeSim = dts;
	}

	private void addToControlHistory(String newLine) {
		controlInteractionHistory.push(newLine);
		if (controlInteractionHistory.size() > historySize) {
			controlInteractionHistory.removeLast();
		}
		String history = "";
		for (String line : controlInteractionHistory) {
			history += line + "\n\n";
		}
		UiUpdateHandler.getUiUpdateHandler().updateControlInteractionHistory(history);
	}

	private void addToPatientHistory(String newLine) {
		patientInteractionHistory.push(newLine);
		if (patientInteractionHistory.size() > historySize) {
			patientInteractionHistory.removeLast();
		}
		String history = "";
		for (String line : patientInteractionHistory) {
			history += line + "\n\n";
		}
		UiUpdateHandler.getUiUpdateHandler().updatePatientInteractionHistory(history);
	}

	private void clearHistory() {
		controlInteractionHistory.clear();
		patientInteractionHistory.clear();
		String history = "";
		UiUpdateHandler.getUiUpdateHandler().updateControlInteractionHistory(history);
		UiUpdateHandler.getUiUpdateHandler().updatePatientInteractionHistory(history);

	}

	private void displayAndLog(boolean local, boolean controlInteraction, String interactionName, Consumer<Pairs> parameters){
		String type = "Sent ";
		if (!local) {
			type = "Received ";
		}

		String parametersString = "";
		if(parameters != null){
			Pairs pairs = new Pairs();
			parameters.accept(pairs);
			parametersString = pairs.stream()
				.map((entry)-> entry.getKey() + "=" + entry.getValue())
				.collect(Collectors.joining(", "));
		}
		
		String message = type + interactionName;
		if(parametersString.length() >0){
			message += ": " + parametersString;
		}
		
		hlaLogger.trace("Interaction," + local + "," + new Date().getTime() + ", " + interactionName);
		if(controlInteraction){
			addToControlHistory(message);
		}else{
			addToPatientHistory(message);
		}
	}

	@Override
	public void start(boolean local, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		if (dateTimeSim != null) {
			dateTimeSim.startTime();
		}
		displayAndLog(local,true,"Start",null);
	}

	@Override
	public void stop(boolean local, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		if (dateTimeSim != null) {
			dateTimeSim.stopTime();
		}
		displayAndLog(local, true,"Stop", null);
	}

	@Override
	public void pause(boolean local, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		if (dateTimeSim != null) {
			dateTimeSim.pauseTime();
		}
		displayAndLog(local,true,"Pause", null);
	}

	@Override
	public void resume(boolean local, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		if (dateTimeSim != null) {
			dateTimeSim.resumeTime();
		}
		displayAndLog(local,true,"Resume", null);
	}

	@Override
	public void save(boolean local, HlaInteractionManager.HlaSaveParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String value = parameters.getLabel("<not provided>");
		displayAndLog(local,true,"Resume", (params)->params.put("label", value));
	}

	@Override
	public void requestTCCC(boolean local, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"RequestTCCC", null);
	}

	@Override
	public void provideTCCC(boolean local, HlaInteractionManager.HlaProvideTCCCParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String value = parameters.getPatient("<not provided>");
		displayAndLog(local,true,"ProvideTCCC", (params)->params.put("patientId",value));
	}

	@Override
	public void selectScenario(boolean local, HlaInteractionManager.HlaSelectScenarioParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String value = parameters.getScenarioName("<not provided>");
		displayAndLog(local,true,"SelectScenario", (params)->params.put("scenarioName",value));
	}

	@Override
	public void restore(boolean local, HlaInteractionManager.HlaRestoreParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String value = parameters.getLabel("<not provided>");
		displayAndLog(local,true,"Restore", (params)->params.put("label",value));
	}

	@Override
	public void requestLab(boolean local, HlaInteractionManager.HlaRequestLabParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		String labType = parameters.getLabType("<not provided>");
		displayAndLog(local,false,"RequestLab", (params)->params.put("patientId",patientId).put("labType", labType));
	}

	@Override
	public void loadPatient(boolean local, HlaInteractionManager.HlaLoadPatientParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		displayAndLog(local,true,"LoadPatient", (params)->params.put("patientId",patientId));
	}

	@Override
	public void startPatient(boolean local, HlaInteractionManager.HlaStartPatientParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		String startTime = String.valueOf(parameters.getSimulationElapsedTime(0));
		displayAndLog(local,true,"StartPatient", (params)->params.put("patientId",patientId).put("startTime", startTime));
	}

	@Override
	public void stopPatient(boolean local, HlaInteractionManager.HlaStopPatientParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		String startTime = String.valueOf(parameters.getSimulationElapsedTime(0));
		displayAndLog(local,true,"StopPatient", (params)->params.put("patientId",patientId).put("stopTime", startTime));
	}

	@Override
	public void pausePatient(boolean local, HlaInteractionManager.HlaPausePatientParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		String startTime = String.valueOf(parameters.getSimulationElapsedTime(0));
		displayAndLog(local,true,"PausePatient", (params)->params.put("patientId",patientId).put("pauseTime", startTime));
	}

	@Override
	public void resumePatient(boolean local, HlaInteractionManager.HlaResumePatientParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String patientId = parameters.getPatientId("<not provided>");
		String startTime = String.valueOf(parameters.getSimulationElapsedTime(0));
		displayAndLog(local,true,"ResumePatient", (params)->params.put("patientId",patientId).put("resumeTime", startTime));
	}

	@Override
	public void medicalEvacuationRequest(boolean local, HlaInteractionManager.HlaMedicalEvacuationRequestParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local, false, "MedicalEvacuationRequest", (params)->
			params.put("patientId", parameters.getPatientId("<not provided>"))
			.put("facilityId",parameters.getFacilityId("<not provided>"))
			.put("transportType",parameters.getTransportType(TransportTypeEnum.UNKNOWN)));
	}

	@Override
	public void medicalEvacuationUpdate(boolean local, HlaInteractionManager.HlaMedicalEvacuationUpdateParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local, false, "MedicalEvacuationUpdate", (params)->
			params.put("patientId", parameters.getPatientId("<not provided>"))
			.put("facilityId",parameters.getFacilityId("<not provided>"))
			.put("medicalEvacuationState",parameters.getMedicalEvacuationState(MedicalEvacuationStateEnum.NOT_APPLICABLE)));
	}

	@Override
	public void medicalEvacuationResponse(boolean local, HlaInteractionManager.HlaMedicalEvacuationResponseParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local, false, "MedicalEvacuationResponse", (params)->
			params.put("patientId", parameters.getPatientId("<not provided>"))
			.put("facilityId",parameters.getFacilityId("<not provided>"))
			.put("medicalEvacuationState",parameters.getMedicalEvacuationState(MedicalEvacuationStateEnum.NOT_APPLICABLE)));
	}

	@Override
	public void restCall(boolean local, HlaInteractionManager.HlaRestCallParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		//no actions at this point
	}

	@Override
	public void restResponse(boolean local, HlaInteractionManager.HlaRestResponseParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		//not action at this point
	}

	@Override
	public void instructionalStart(boolean local, HlaInteractionManager.HlaInstructionalStartParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"InstructionalStart", (params)->
			params.put("trainingFacilityId",parameters.getTrainingFacilityId("<not provided>")));
	}

	@Override
	public void instructionalStop(boolean local, HlaInteractionManager.HlaInstructionalStopParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"InstructionalStop", (params)->
			params.put("trainingFacilityId",parameters.getTrainingFacilityId("<not provided>")));
	}

	@Override
	public void instructionalPause(boolean local, HlaInteractionManager.HlaInstructionalPauseParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"InstructionalPause", (params)->
			params.put("trainingFacilityId",parameters.getTrainingFacilityId("<not provided>")));
	}

	@Override
	public void instructionalResume(boolean local, HlaInteractionManager.HlaInstructionalResumeParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"InstructionalResume", (params)->
			params.put("trainingFacilityId",parameters.getTrainingFacilityId("<not provided>")));
	}

	@Override
	public void setTimeScale(boolean local, HlaInteractionManager.HlaSetTimeScaleParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,true,"SetTimeScale", (params)->
			params.put("scale", parameters.getScale(-1)));
	}

	@Override
	public void magicVitals(boolean local, HlaInteractionManager.HlaMagicVitalsParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String vitals = parameters.hasMagicVital() ? parameters.getMagicVital().toString() : "<not provided>";
		String patient = parameters.getPatientId("<not provided>");
		float value = parameters.getMagicVitalValue(-1);
		displayAndLog(local, false,"MagicVitals", (params)->
			params.put("magicVtial",vitals)
			.put("patientId", patient)
			.put("value", value));
		
	}

	@Override
	public void vitalsDisplayControl(boolean local, HlaInteractionManager.HlaVitalsDisplayControlParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		String vitals = parameters.hasVisibleVitalSign() ? parameters.getVisibleVitalSign().toString() : "<not provided>";
		String patient = parameters.getPatientId("<not provided>");
		boolean value = parameters.getToggleVitalSignVisibility(false);
		displayAndLog(local,false,"VitalsDisplayControl", (params)->
			params.put("visibleVitalSign",vitals)
			.put("patientId", patient)
			.put("toggleVitalSignVisibility", value));
	}

	@Override
	public void magicTransfer(boolean local, HlaInteractionManager.HlaMagicTransferParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
		displayAndLog(local,false,"MagicTransfer", (params)->
			params.put("facilityId",parameters.getFacilityId("<not provided>"))
			.put("patientId", parameters.getPatientId("<not provided>")));
	}

	//-------------------------------------------------------------------------
	//                  DisconnectListener implementation
	//-------------------------------------------------------------------------
	@Override
	public void hlaDisconnected() {
		clearHistory();
	}

	private class Pairs{
		HashMap<String, Object> _map = new HashMap();
		public Pairs put(String key, Object value){
			_map.put(key, value);
			return this;
		}
		public Stream<Entry<String,Object>> stream(){
			return _map.entrySet().stream();
		}
	}
}
