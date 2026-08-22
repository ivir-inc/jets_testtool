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

import devstudio.generatedcode.HlaBodyFluids;
import devstudio.generatedcode.HlaNeurologicalScales;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.DefaultListModel;

public class UiUpdateHandler{
    private static final UiUpdateHandler handler = new UiUpdateHandler();
    private TestToolUI testToolUI = null;
    private DefaultListModel<String> patientListModel = null;
    private DefaultListModel<String> bookmarkListModel = null;
    private DefaultListModel<String> tcccListModel = null;
    private DefaultListModel<String> createPatientListModel = null;
    private DefaultListModel<String> dataLogListModel = null;
    private DefaultListModel<String> casualtyStateListModel = null;
    private DefaultListModel<String> facilityListModel = null;
    private BodyFluidsData bodyFluidsData = null;
    private NeuroScalesData neuroScalesData = null;
    private LabData labData = null;
    private InjuryData injuryData = null;
    
    private UiUpdateHandler(){}
    
    public static UiUpdateHandler getUiUpdateHandler(){
        return handler;
    }
    
    public void setTestToolUI(TestToolUI ui){
        this.testToolUI = ui;
        this.bodyFluidsData = new BodyFluidsData();
        this.testToolUI.getBodyFluidsTable().setModel(bodyFluidsData);
        this.neuroScalesData = new NeuroScalesData();
        this.testToolUI.getNeuroTable().setModel(this.neuroScalesData);
        this.labData = new LabData();
        this.testToolUI.getLabTable().setModel(this.labData);
        this.injuryData = new InjuryData();
        this.testToolUI.getInjury().setModel(injuryData.getTreeModel());
    }
    
    public void federationJoined(){
        testToolUI.getJoinFedButton().setEnabled(false);
        testToolUI.getResignFedButton().setEnabled(true);
    }
    
    public void federationResigned(){
        testToolUI.getJoinFedButton().setEnabled(true);
        testToolUI.getResignFedButton().setEnabled(false);
    }
    
     public void updateReplayRuntimeClock(long elapsedTimeMs){
        if(elapsedTimeMs == 0){
            testToolUI.getReplayRuntimeLabel().setText("0");
        }else{
            long seconds = elapsedTimeMs / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            String time = padNumbers(days) 
                    + ":" + padNumbers(hours % 24) 
                    + ":" + padNumbers(minutes % 60) 
                    + ":" + padNumbers(seconds % 60);
            testToolUI.getReplayRuntimeLabel().setText(time);
            
        }
     }
        
    
    public void updateClock(long elapsedTimeMs, long simTimeMs, long wallTimeMs, int timeScale){
        if(elapsedTimeMs == 0){
            testToolUI.getElapsedTimeLabel().setText("0");
            testToolUI.getReplayRuntimeLabel().setText("0");
        }else{
            long seconds = elapsedTimeMs / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            String time = padNumbers(days) 
                    + ":" + padNumbers(hours % 24) 
                    + ":" + padNumbers(minutes % 60) 
                    + ":" + padNumbers(seconds % 60);
            testToolUI.getElapsedTimeLabel().setText(time);
            testToolUI.getReplayRuntimeLabel().setText(time);
            
        }
        
        if(simTimeMs != 0){
            Date date = new Date(simTimeMs);
            DateFormat formatter = new SimpleDateFormat("MMM-dd HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC-05"));
            testToolUI.getSimDateTimeLabel().setText(formatter.format(date));
        }
        
        if(wallTimeMs != 0){
            Date date = new Date(wallTimeMs);
            DateFormat formatter = new SimpleDateFormat("MMM-dd HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC-05"));
            testToolUI.getWallClockLabel().setText(formatter.format(date));
        }
        
        testToolUI.getTimeScaleLabel().setText(timeScale + ":1");
    }
    
    private String padNumbers(long num){
        if(num < 10){
            return "0"+num;
        }
        return String.valueOf(num);
    }
        
    public void updatePatientVitalsText(String text) {
        testToolUI.getPatientVitalsTextArea().setText(text);
    }
    
    public void updatePatientTreatmentText(String text){
        testToolUI.getPatientTreatmentTextArea().setText(text);
    }
    
    public void updatePatientInjuriesTextArea(String text) {
        testToolUI.getPatientInjuriesTextArea().setText(text);
    }
    
    public void updatePatientSignsTextArea (String text) {
        testToolUI.getPatientSignsTextArea().setText(text);
    }
    
    public void updatePatientSymptomsTextArea (String text) {
        testToolUI.getPatientSymptomsTextArea().setText(text);
    }

    public void addToPatientList(Patient patient){
        if(this.patientListModel == null){
            patientListModel = new DefaultListModel<>();
            testToolUI.getPatientList().setModel(patientListModel);
            testToolUI.getPatientListSS().setModel(patientListModel);
        }
        
        this.patientListModel.addElement(patient.getId());
    }

    public void clearPatientList(){
	    if(patientListModel != null){
	    	this.patientListModel.clear();
	    }
    }
    
    public void addToEventList(Event event){
        if(this.bookmarkListModel == null){
            bookmarkListModel = new DefaultListModel<>();
            testToolUI.getBookmarkList().setModel(bookmarkListModel);
        }
        
        this.bookmarkListModel.addElement(event.getInstanceName());
    }
    
    public void updateEventText(String text){
        testToolUI.getBookmarkTextArea().setText(text);
    }

    public void clearEvents(){
	    if(bookmarkListModel != null){
		    bookmarkListModel.clear();
	    }
	    updateEventText("");
    }

    public void addToTcccList(Tccc tccc){
        if(this.tcccListModel == null){
            this.tcccListModel = new DefaultListModel<>();
            testToolUI.getTcccList().setModel(this.tcccListModel);
        }
        this.tcccListModel.addElement(tccc.getInstanceId());
    }

    public void clearTcccList(){
	    if(this.tcccListModel != null){
		    this.tcccListModel.clear();
	    }
    }
 
    public void updateTcccText(String text){
        testToolUI.getTcccTextArea().setText(text);
    }
    
    public void updateControlInteractionHistory(String history){
        testToolUI.getControlInteractionHistoryArea().setText(history);
    }
    
    public void updatePatientInteractionHistory(String history){
        testToolUI.getPatientInteractionHistoryArea().setText(history);
    }
    
    public void addToCreatePatientList(CreatePatient patient){
        if(this.createPatientListModel == null){
            this.createPatientListModel = new DefaultListModel<>();
            testToolUI.getCreatePatientList().setModel(this.createPatientListModel);
        }
        this.createPatientListModel.addElement(patient.getPatientId());
    }

    public void clearCreatePatientList(){
	    if(this.createPatientListModel != null){
	    	this.createPatientListModel.clear();
	    }
    }

    public void updateDataLogText(String text) {
        testToolUI.getDataLogTextArea().setText(text);
   }

    public void addToDataLogList(DataLog log) {
        if(this.dataLogListModel == null){
            this.dataLogListModel = new DefaultListModel<>();
            testToolUI.getDataLogList().setModel(this.dataLogListModel);
        }
        this.dataLogListModel.addElement(log.getInstanceName());
    }

    public void clearDataLogList(){
	    if(this.dataLogListModel != null){
		    this.dataLogListModel.clear();
	    }
    }
    
    public void updateFederationState(String stateText){
        testToolUI.getFedertionStateLabel().setText(stateText);
    }
    
    public void updateDocumentStatusText(String statusText){
        testToolUI.getDocumentTextArea().setText(statusText);
    }
    
    public void updateFederateList(String fedListText){
        testToolUI.getFederateListTextArea().setText(fedListText);
    }

    public void newBodyFluids(HlaBodyFluids bodyFluids){
        this.bodyFluidsData.add(bodyFluids);
    }
    
    public void clearBodyFluids(){
        this.bodyFluidsData.clearTable();
    }

    public void bodyFluidsDataChanged(){
        this.bodyFluidsData.fireTableChanged();
    }
    
    public void newNeuroScales(HlaNeurologicalScales hlaNeuroScales){
        this.neuroScalesData.add(hlaNeuroScales);
    }
    
    public void neuroScalesDataChanged(){
        this.neuroScalesData.fireTableChanged();
    }

    public void clearNeuroScales(){
	this.neuroScalesData.clear();
    }
    
    public void newLabData(LabDataContainer container){
        this.labData.add(container);
    }

    public void clearLabData(){
	this.labData.clear();
    }
    
    public void newInjuryData(InjuryDataContainer container){
        this.injuryData.add(container);
        this.testToolUI.getInjury().repaint();
    }

    public void clearInjuryData() {
        this.injuryData.clear();
        this.testToolUI.getInjury().setModel(injuryData.getTreeModel());
        this.testToolUI.getInjury().repaint();
    }

    public void addToCasualtyStateList(String instanceName) {
        if (this.casualtyStateListModel == null) {
            this.casualtyStateListModel = new DefaultListModel<>();
            this.testToolUI.getCasualtyStateList().setModel(this.casualtyStateListModel);
        }
        this.casualtyStateListModel.addElement(instanceName);
    }

    public void clearCasualtyState(){
        if(casualtyStateListModel != null){
            casualtyStateListModel.clear();
        }
        this.testToolUI.getCasualtyStateTextArea().setText("");

    }

    public void addToFacilityList(String instanceName){
        if(this.facilityListModel == null){
            this.facilityListModel = new DefaultListModel<>();
            this.testToolUI.getFacilityInstanceList().setModel(this.facilityListModel);
        }
        this.facilityListModel.addElement(instanceName);
    }

    public void clearFacilities(){
        if(facilityListModel != null){
            facilityListModel.clear();
        }
        this.testToolUI.getFacilityInformationTextArea().setText("");
    }
    
}
