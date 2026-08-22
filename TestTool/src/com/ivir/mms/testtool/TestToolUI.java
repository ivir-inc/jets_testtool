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

import devstudio.generatedcode.HlaNeurologicalScales;
import devstudio.generatedcode.datatypes.BowelSoundEnum;
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.CoughEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.EcgRhythmEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.GlasgowComaScaleRecord;
import devstudio.generatedcode.datatypes.HeartSoundEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import devstudio.generatedcode.datatypes.LearnerActionEnum;
import devstudio.generatedcode.datatypes.LevelOfConsciousnessEnum;
import devstudio.generatedcode.datatypes.LevelOfResponseEnum;
import devstudio.generatedcode.datatypes.LungSoundEnum;
import devstudio.generatedcode.datatypes.PupilSizeEnum;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.SkinColorEnum;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;
import devstudio.generatedcode.datatypes.VisionDisturbanceEnum;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.logging.log4j.core.config.builder.api.Component;

/**
 *
 */
public class TestToolUI extends javax.swing.JFrame {

	private UiCommandHandler uiCommandHandler = null;
	private boolean isTimeOwner = false;
	private int timeRatio = 1;
	private boolean timeRatioChanged = false;
	private String instanceName = null;

	/**
	 * Creates new form FedToolUI
	 */
	public TestToolUI() {
		this.uiCommandHandler = UiCommandHandler.getUiCommandHandler();

		initComponents();
		this.resignFedButton.setEnabled(false);
		this.newTreatmentButton.setEnabled(false);
		initializeEventComboBoxes();
		initializeNeuroScales();
		initializeReplayFileList();
	}

	public JButton getResignFedButton() {
		return this.resignFedButton;
	}

	public JButton getJoinFedButton() {
		return this.joinFedButton;
	}

	public JLabel getElapsedTimeLabel() {
		return this.elapsedTimeLabel;
	}

	public JLabel getReplayRuntimeLabel() {
		return this.replayRuntime;
	}

	public JLabel getSimDateTimeLabel() {
		return this.simDateTimeLabel;
	}

	public JLabel getWallClockLabel() {
		return this.wallClockLabel;
	}

	public JLabel getTimeScaleLabel() {
		return this.timeScaleLabel;
	}

	public JList getPatientList() {
		return this.patientList;
	}

	public JList getPatientListSS() {
		return this.patientListSS;
	}

	public JTextArea getPatientVitalsTextArea() {
		return this.patientVitalsTextArea;
	}

	public JTextArea getPatientTreatmentTextArea() {
		return this.patientTreatmentsTextArea;
	}

	public JTextArea getPatientInjuriesTextArea() {
		return this.patientInjuriesTextArea;
	}

	public JTextArea getPatientSignsTextArea() {
		return this.patientSignsTextArea;
	}

	public JTextArea getPatientSymptomsTextArea() {
		return this.patientSymptomsTextArea;
	}

	public JList getBookmarkList() {
		return this.bookmarkList;
	}

	public JTextArea getBookmarkTextArea() {
		return this.bookmarkTextArea;
	}

	public JList getTcccList() {
		return this.tcccList;
	}

	public JTextArea getTcccTextArea() {
		return this.tcccTextArea;
	}

	public JTextArea getControlInteractionHistoryArea() {
		return this.interactionHistoryTextArea;
	}

	public JTextArea getPatientInteractionHistoryArea() {
		return this.interactionHistoryTextArea1;
	}

	public JList getCreatePatientList() {
		return this.createPatientList;
	}

	public JTextArea getDataLogTextArea() {
		return this.logTextArea;
	}

	public JList getDataLogList() {
		return this.logList;
	}

	public JLabel getFedertionStateLabel() {
		return this.federationStateLabel;
	}

	public JTextArea getDocumentTextArea() {
		return this.documentTextArea;
	}

	public JTextArea getFederateListTextArea() {
		return this.fedListTextArea;
	}

	public JTable getBodyFluidsTable() {
		return this.fluidTable;
	}

	public JTable getNeuroTable() {
		return this.neuroTable;
	}

	public JTable getLabTable() {
		return this.labTable;
	}

	public void setTimeRatio(int newRatio) {
		this.timeRatio = newRatio;
	}

	public void setTimeOwner(boolean isOwner) {
		this.isTimeOwner = isOwner;
	}

	public int getTimeRatio() {
		return this.timeRatio;
	}

	public boolean getTimeOwner() {
		return this.isTimeOwner;
	}

	public JTree getInjury() {
		return this.injuryTree;
	}

	public JList getCasualtyStateList(){
		return this.casualyStateInstanceL;
	}

    public JList getFacilityInstanceList(){
        return this.facilityInstanceL;
    }

    public JTextArea getCasualtyStateTextArea(){
        return this.casualtyStateTA;
    }

    public JTextArea getFacilityInformationTextArea(){
        return this.facilityInformationTA;
    }

	private Float toFloatOrNull(String floatStr) {
		try {
			return Float.valueOf(floatStr);
		} catch (Exception e) {
			return null;
		}
	}

	private Integer toIntegerOrNull(String intStr) {
		try {
			return Integer.valueOf(intStr);
		} catch (Exception e) {
			return null;
		}
	}

	private void initializeNeuroScales() {
		List<String> lorList = new ArrayList<>();
		for (LevelOfResponseEnum lorEnum : LevelOfResponseEnum.values()) {
			String titleEnum = convertEnumToTitle(lorEnum.getName());
			lorList.add(titleEnum);
		}
		sortList(lorList);

		this.lorCb.setModel(new DefaultComboBoxModel<>(lorList.toArray(String[]::new)));

		List<String> locList = new ArrayList<>();
		for (LevelOfConsciousnessEnum locEnum : LevelOfConsciousnessEnum.values()) {
			String titleEnum = convertEnumToTitle(locEnum.getName());
			locList.add(titleEnum);
		}
		sortList(locList);

		this.locCb.setModel(new DefaultComboBoxModel<>(locList.toArray(String[]::new)));
	}

	private void initializeReplayFileList() {
                DefaultListModel<File> dLModel = new DefaultListModel<>();
                this.replayFileList.setModel(dLModel);

                // Optional: nicer display (show just the file name)
                this.replayFileList.setCellRenderer(new DefaultListCellRenderer() {
                        @Override
                        public java.awt.Component getListCellRendererComponent(
                                JList<?> list, Object value, int index,
                                boolean isSelected, boolean cellHasFocus) {

                        java.awt.Component c = super.getListCellRendererComponent(
                                list, value, index, isSelected, cellHasFocus);

                        if (value instanceof File) {
                                setText(((File) value).getName());
                        }
                        return c;
                        }
                });
        }


	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                createPatientPanel = new javax.swing.JPanel();
                jScrollPane8 = new javax.swing.JScrollPane();
                createPatientList = new javax.swing.JList<>();
                newCreatePatientButton = new javax.swing.JButton();
                selectCreatePatientButton = new javax.swing.JButton();
                newPatientButtion = new javax.swing.JButton();
                lungVariablesPanel = new javax.swing.JPanel();
                jLabel23 = new javax.swing.JLabel();
                jLabel24 = new javax.swing.JLabel();
                jLabel25 = new javax.swing.JLabel();
                deadSpaceTextField = new javax.swing.JTextField();
                jLabel26 = new javax.swing.JLabel();
                totalCapacityTextField = new javax.swing.JTextField();
                jLabel27 = new javax.swing.JLabel();
                expReserveTextField = new javax.swing.JTextField();
                jLabel28 = new javax.swing.JLabel();
                insReserveTextField = new javax.swing.JTextField();
                jLabel29 = new javax.swing.JLabel();
                residualVolumeTextField = new javax.swing.JTextField();
                tidalVolumenTextField = new javax.swing.JTextField();
                updatePatientButton = new javax.swing.JButton();
                vitalsUpdaterStopButton = new javax.swing.JButton();
                atTimePanel = new javax.swing.JPanel();
                atTimeLabel = new javax.swing.JLabel();
                timeAtTextField = new javax.swing.JTextField();
                provideTCCCLabel3 = new javax.swing.JLabel();
                testFluidUpdater = new javax.swing.JPanel();
                jLabel50 = new javax.swing.JLabel();
                jPanel20 = new javax.swing.JPanel();
                startButton1 = new javax.swing.JButton();
                stopButton1 = new javax.swing.JButton();
                jPanel22 = new javax.swing.JPanel();
                jLabel51 = new javax.swing.JLabel();
                objectsCb = new javax.swing.JComboBox<>();
                jPanel23 = new javax.swing.JPanel();
                jLabel52 = new javax.swing.JLabel();
                fluidAttributeCb = new javax.swing.JComboBox<>();
                jPanel24 = new javax.swing.JPanel();
                jLabel55 = new javax.swing.JLabel();
                durationTf = new javax.swing.JTextField();
                jLabel56 = new javax.swing.JLabel();
                jLabel53 = new javax.swing.JLabel();
                incrementTf = new javax.swing.JTextField();
                jLabel54 = new javax.swing.JLabel();
                jTabbedPane = new javax.swing.JTabbedPane();
                simControlInternalFrame = new javax.swing.JInternalFrame();
                jPanel9 = new javax.swing.JPanel();
                fedControlPanel = new javax.swing.JPanel();
                controlButtonPanel = new javax.swing.JPanel();
                joinFedButton = new javax.swing.JButton();
                resignFedButton = new javax.swing.JButton();
                fedListPanel = new javax.swing.JPanel();
                jScrollPane12 = new javax.swing.JScrollPane();
                fedListTextArea = new javax.swing.JTextArea();
                jLabel11 = new javax.swing.JLabel();
                jPanel6 = new javax.swing.JPanel();
                jLabel12 = new javax.swing.JLabel();
                fedStatusPanel = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                elapsedTimeLabel = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                federationStateLabel = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                simDateTimeLabel = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                wallClockLabel = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                timeScaleLabel = new javax.swing.JLabel();
                jPanel7 = new javax.swing.JPanel();
                jPanel5 = new javax.swing.JPanel();
                jLabel13 = new javax.swing.JLabel();
                fedStateComboBox = new javax.swing.JComboBox<>();
                changeStateConfirmButton = new javax.swing.JButton();
                jPanel8 = new javax.swing.JPanel();
                timeRatioLabel = new javax.swing.JLabel();
                timeRatioTextField = new javax.swing.JTextField();
                jLabel15 = new javax.swing.JLabel();
                timeUpdateButton = new javax.swing.JToggleButton();
                publishTimeCb = new javax.swing.JCheckBox();
                jSeparator2 = new javax.swing.JSeparator();
                jLabel2 = new javax.swing.JLabel();
                replayTabFrame = new javax.swing.JInternalFrame();
                replayMainPanel = new javax.swing.JPanel();
                fileDisplayPanel = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                replayFileList = new javax.swing.JList<>();
                jLabel73 = new javax.swing.JLabel();
                replayButtonPanel = new javax.swing.JPanel();
                jPanel37 = new javax.swing.JPanel();
                uploadCsvBtn = new javax.swing.JButton();
                replayControlLabel = new javax.swing.JLabel();
                jPanel38 = new javax.swing.JPanel();
                runReplayBtn = new javax.swing.JButton();
                jPanel39 = new javax.swing.JPanel();
                pauseResumeReplayBtn = new javax.swing.JButton();
                jPanel40 = new javax.swing.JPanel();
                stopReplayBtn = new javax.swing.JButton();
                listIxBtnPanel = new javax.swing.JPanel();
                selectAllPanel = new javax.swing.JPanel();
                selectAllBtn = new javax.swing.JButton();
                removeSelectedPanel = new javax.swing.JPanel();
                removeSelectedBtn = new javax.swing.JButton();
                statusAndRuntimePanel = new javax.swing.JPanel();
                replayStatusPanel = new javax.swing.JPanel();
                jLabel69 = new javax.swing.JLabel();
                replayStatusLabel = new javax.swing.JLabel();
                runtimePanel = new javax.swing.JPanel();
                jLabel70 = new javax.swing.JLabel();
                replayRuntime = new javax.swing.JLabel();
                patientInternalFrame = new javax.swing.JInternalFrame();
                patientDetailsPanel = new javax.swing.JPanel();
                mainPatientPanel = new javax.swing.JPanel();
                vitalsLabel = new javax.swing.JLabel();
                treatmentsLabel = new javax.swing.JLabel();
                injuriesLabel = new javax.swing.JLabel();
                label1 = new java.awt.Label();
                jLabel30 = new javax.swing.JLabel();
                jSeparator4 = new javax.swing.JSeparator();
                patientInjuriesPane = new javax.swing.JScrollPane();
                patientInjuriesTextArea = new javax.swing.JTextArea();
                patientTreatmentsPane = new javax.swing.JScrollPane();
                patientTreatmentsTextArea = new javax.swing.JTextArea();
                patientVitalsPane = new javax.swing.JScrollPane();
                patientVitalsTextArea = new javax.swing.JTextArea();
                filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 0));
                newTreatmentButton = new javax.swing.JButton();
                vitalsUpdaterPanel = new javax.swing.JPanel();
                vitalsUpdaterStartButton = new javax.swing.JToggleButton();
                jLabel31 = new javax.swing.JLabel();
                intervalTextField = new javax.swing.JTextField();
                jLabel32 = new javax.swing.JLabel();
                jLabel33 = new javax.swing.JLabel();
                durationTextField = new javax.swing.JTextField();
                attributeComboBox = new javax.swing.JComboBox<>();
                jLabel34 = new javax.swing.JLabel();
                vitalsUpdaterLabel = new javax.swing.JLabel();
                jPanel10 = new javax.swing.JPanel();
                patientIdsPanel = new javax.swing.JPanel();
                patiendIdsLabel = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                patientList = new javax.swing.JList<>();
                jSeparator1 = new javax.swing.JSeparator();
                jPanel13 = new javax.swing.JPanel();
                tempPanel = new javax.swing.JPanel();
                jLabel17 = new javax.swing.JLabel();
                tempTextField = new javax.swing.JTextField();
                jLabel18 = new javax.swing.JLabel();
                jLabel21 = new javax.swing.JLabel();
                respirationRatePanel = new javax.swing.JPanel();
                jLabel20 = new javax.swing.JLabel();
                respRateTextField = new javax.swing.JTextField();
                etco2Panel = new javax.swing.JPanel();
                jLabel19 = new javax.swing.JLabel();
                etco2TextField = new javax.swing.JTextField();
                o2SaturationPanel = new javax.swing.JPanel();
                jLabel22 = new javax.swing.JLabel();
                o2SaturationTextField = new javax.swing.JTextField();
                jPanel12 = new javax.swing.JPanel();
                patientIDLabel = new javax.swing.JLabel();
                patientIDTF = new javax.swing.JTextField();
                autoFillButton = new javax.swing.JButton();
                heartRatePanel = new javax.swing.JPanel();
                heartRateLabel = new javax.swing.JLabel();
                heartRateTF = new javax.swing.JTextField();
                bloodPressurePanel = new javax.swing.JPanel();
                jLabel14 = new javax.swing.JLabel();
                systolicBPTextField = new javax.swing.JTextField();
                jLabel16 = new javax.swing.JLabel();
                diastolicBPTextField = new javax.swing.JTextField();
                requiredLabel = new javax.swing.JLabel();
                jPanel33 = new javax.swing.JPanel();
                addPatientButton = new javax.swing.JButton();
                createLungPatientButton = new javax.swing.JButton();
                jSeparator3 = new javax.swing.JSeparator();
                jPanel43 = new javax.swing.JPanel();
                patientAcquireB = new javax.swing.JButton();
                patientReleaseB = new javax.swing.JButton();
                casualtyStateTabFrame = new javax.swing.JInternalFrame();
                eventsPanel1 = new javax.swing.JPanel();
                jScrollPane20 = new javax.swing.JScrollPane();
                casualtyStateTA = new javax.swing.JTextArea();
                eventsListLabel1 = new javax.swing.JLabel();
                eventList1 = new javax.swing.JScrollPane();
                casualyStateInstanceL = new javax.swing.JList<>();
                eventInformationLabel1 = new javax.swing.JLabel();
                createNewEventPanel1 = new javax.swing.JPanel();
                jLabel79 = new javax.swing.JLabel();
                jPanel41 = new javax.swing.JPanel();
                jLabel81 = new javax.swing.JLabel();
                casualtyStatePatientIdTF = new javax.swing.JTextField();
                casualtyStateFacilityIdTF = new javax.swing.JTextField();
                jLabel84 = new javax.swing.JLabel();
                casualtyStateCreateB = new javax.swing.JButton();
                jLabel82 = new javax.swing.JLabel();
                casualtyStateEvacPirorityCB = new javax.swing.JComboBox<>();
                jLabel83 = new javax.swing.JLabel();
                casualtyStateTriageClassificationCB = new javax.swing.JComboBox<>();
                signsAndSymptomsTabFrame = new javax.swing.JInternalFrame();
                patientIdsPanel1 = new javax.swing.JPanel();
                patiendIdsLabelSS = new javax.swing.JLabel();
                patientIdsScrollPaneSS = new javax.swing.JScrollPane();
                patientListSS = new javax.swing.JList<>();
                addSignSymptomButton = new javax.swing.JButton();
                singsAndSymptomsPane = new javax.swing.JPanel();
                patientSignsPane = new javax.swing.JScrollPane();
                patientSignsTextArea = new javax.swing.JTextArea();
                patientSymptomsPane = new javax.swing.JScrollPane();
                patientSymptomsTextArea = new javax.swing.JTextArea();
                signsLabel = new javax.swing.JLabel();
                symptomsLabel = new javax.swing.JLabel();
                instructionalTabFrame = new javax.swing.JInternalFrame();
                eventsPanel = new javax.swing.JPanel();
                jScrollPane4 = new javax.swing.JScrollPane();
                bookmarkTextArea = new javax.swing.JTextArea();
                eventsListLabel = new javax.swing.JLabel();
                eventList = new javax.swing.JScrollPane();
                bookmarkList = new javax.swing.JList<>();
                eventInformationLabel = new javax.swing.JLabel();
                createNewEventPanel = new javax.swing.JPanel();
                jLabel38 = new javax.swing.JLabel();
                notesLabel = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                notesTextArea = new javax.swing.JTextArea();
                jLabel39 = new javax.swing.JLabel();
                jScrollPane16 = new javax.swing.JScrollPane();
                desTextArea = new javax.swing.JTextArea();
                jPanel11 = new javax.swing.JPanel();
                typeLabel = new javax.swing.JLabel();
                typeComboBox = new javax.swing.JComboBox<>();
                jLabel41 = new javax.swing.JLabel();
                pidTextField = new javax.swing.JTextField();
                jLabel43 = new javax.swing.JLabel();
                iidTextField = new javax.swing.JTextField();
                jLabel45 = new javax.swing.JLabel();
                tidTextField = new javax.swing.JTextField();
                facilityTextField = new javax.swing.JTextField();
                sourceTextField = new javax.swing.JTextField();
                jLabel42 = new javax.swing.JLabel();
                lidTextField = new javax.swing.JTextField();
                jLabel44 = new javax.swing.JLabel();
                jLabel40 = new javax.swing.JLabel();
                createEventButton = new javax.swing.JButton();
                learnerActionLabel = new javax.swing.JLabel();
                learnerActionCB = new javax.swing.JComboBox<>();
                facilityTabFrame = new javax.swing.JInternalFrame();
                eventsPanel2 = new javax.swing.JPanel();
                jScrollPane21 = new javax.swing.JScrollPane();
                facilityInformationTA = new javax.swing.JTextArea();
                eventsListLabel2 = new javax.swing.JLabel();
                eventList2 = new javax.swing.JScrollPane();
                facilityInstanceL = new javax.swing.JList<>();
                eventInformationLabel2 = new javax.swing.JLabel();
                createNewEventPanel2 = new javax.swing.JPanel();
                jLabel80 = new javax.swing.JLabel();
                jPanel42 = new javax.swing.JPanel();
                facilityFacilityIdTF = new javax.swing.JTextField();
                jLabel86 = new javax.swing.JLabel();
                jLabel87 = new javax.swing.JLabel();
                facilityRoleOfCareCB = new javax.swing.JComboBox<>();
                jLabel88 = new javax.swing.JLabel();
                facilityFacilityTypeCB = new javax.swing.JComboBox<>();
                jLabel85 = new javax.swing.JLabel();
                facilityPatientCapacityTF = new javax.swing.JTextField();
                facilityCreateB = new javax.swing.JButton();
                controlInteractionsTabFrame = new javax.swing.JInternalFrame();
                jScrollPane7 = new javax.swing.JScrollPane();
                interactionHistoryTextArea = new javax.swing.JTextArea();
                interactionsControlPanel = new javax.swing.JPanel();
                federationControlPanel = new javax.swing.JPanel();
                selectScenarioPanel = new javax.swing.JPanel();
                selectScenarioJButton = new javax.swing.JButton();
                scenarioNameTextField = new javax.swing.JTextField();
                startButtonPanel = new javax.swing.JPanel();
                startButton = new javax.swing.JButton();
                stopButton = new javax.swing.JButton();
                pauseButton = new javax.swing.JButton();
                resumeButton = new javax.swing.JButton();
                scenarioNameLabel = new javax.swing.JLabel();
                instructionalControlsPanel = new javax.swing.JPanel();
                instructionPanel = new javax.swing.JPanel();
                iStartButton = new javax.swing.JButton();
                jLabel8 = new javax.swing.JLabel();
                facilityIdTextField = new javax.swing.JTextField();
                iStopButton = new javax.swing.JButton();
                iPauseButton = new javax.swing.JButton();
                iResumeButton = new javax.swing.JButton();
                patientControlPanel = new javax.swing.JPanel();
                loadPatientButton = new javax.swing.JButton();
                patientActionPatientIdLabel = new javax.swing.JLabel();
                startPatientButton = new javax.swing.JButton();
                patientControlPatientIdTextField = new javax.swing.JTextField();
                stopPatientButton = new javax.swing.JButton();
                pausePatientButton = new javax.swing.JButton();
                resumePatientButton = new javax.swing.JButton();
                saveButton = new javax.swing.JButton();
                saveTextField = new javax.swing.JTextField();
                saveLabel = new javax.swing.JLabel();
                patientInteractionsTabFrame = new javax.swing.JInternalFrame();
                jScrollPane19 = new javax.swing.JScrollPane();
                interactionHistoryTextArea1 = new javax.swing.JTextArea();
                interactionsControlPanel1 = new javax.swing.JPanel();
                medicalEvacuationPanel1 = new javax.swing.JPanel();
                evacPatientIdLabel1 = new javax.swing.JLabel();
                evacPatientIdTextField1 = new javax.swing.JTextField();
                siteNameLabel1 = new javax.swing.JLabel();
                siteNameTextField1 = new javax.swing.JTextField();
                requestEvacButton1 = new javax.swing.JButton();
                transportTypeComboBox1 = new javax.swing.JComboBox<>();
                vehicleIdLabel1 = new javax.swing.JLabel();
                vehicleIdTextField1 = new javax.swing.JTextField();
                evacStageLabel1 = new javax.swing.JLabel();
                evacStateComboBox1 = new javax.swing.JComboBox<>();
                updateEvacButton1 = new javax.swing.JButton();
                responseEvacButton1 = new javax.swing.JButton();
                jPanel34 = new javax.swing.JPanel();
                jLabel71 = new javax.swing.JLabel();
                magicVitalsPatientIdTF = new javax.swing.JTextField();
                magicVitalsTypeCB = new javax.swing.JComboBox<>();
                jLabel72 = new javax.swing.JLabel();
                jLabel74 = new javax.swing.JLabel();
                magicVitalsValueTF = new javax.swing.JTextField();
                sendMagicVitalsB = new javax.swing.JButton();
                jPanel35 = new javax.swing.JPanel();
                jLabel75 = new javax.swing.JLabel();
                jLabel76 = new javax.swing.JLabel();
                vitalsVisibilityTypeCB = new javax.swing.JComboBox<>();
                vitalsVisibilityMakeVisibleB = new javax.swing.JButton();
                vitalsVisibilityHideB = new javax.swing.JButton();
                vitalsVisibilityPatientIdTF1 = new javax.swing.JTextField();
                jPanel36 = new javax.swing.JPanel();
                jLabel77 = new javax.swing.JLabel();
                magicTransferPatientIdTF = new javax.swing.JTextField();
                jLabel78 = new javax.swing.JLabel();
                magicTransferFacilityIdTF = new javax.swing.JTextField();
                magicTransferB = new javax.swing.JButton();
                fluidsTabFrame = new javax.swing.JInternalFrame();
                jScrollPane13 = new javax.swing.JScrollPane();
                fluidTable = new javax.swing.JTable();
                jPanel25 = new javax.swing.JPanel();
                jPanel26 = new javax.swing.JPanel();
                jPanel14 = new javax.swing.JPanel();
                jPanel15 = new javax.swing.JPanel();
                jLabel37 = new javax.swing.JLabel();
                fluidsPatientIdTf = new javax.swing.JTextField();
                jPanel16 = new javax.swing.JPanel();
                jLabel46 = new javax.swing.JLabel();
                bloodLossTf = new javax.swing.JTextField();
                jLabel57 = new javax.swing.JLabel();
                jPanel17 = new javax.swing.JPanel();
                jLabel47 = new javax.swing.JLabel();
                bloodVolumeTf = new javax.swing.JTextField();
                jLabel58 = new javax.swing.JLabel();
                jPanel18 = new javax.swing.JPanel();
                jLabel48 = new javax.swing.JLabel();
                sweatRateTf = new javax.swing.JTextField();
                jLabel59 = new javax.swing.JLabel();
                jPanel19 = new javax.swing.JPanel();
                jLabel49 = new javax.swing.JLabel();
                urineOutputTf = new javax.swing.JTextField();
                jLabel60 = new javax.swing.JLabel();
                createFluidButton = new javax.swing.JButton();
                jLabel36 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                updateFluidButton = new javax.swing.JButton();
                jLabel61 = new javax.swing.JLabel();
                neuroTabFrame = new javax.swing.JInternalFrame();
                neuroLabel = new javax.swing.JLabel();
                jScrollPane14 = new javax.swing.JScrollPane();
                neuroTable = new javax.swing.JTable();
                jPanel21 = new javax.swing.JPanel();
                jPanel27 = new javax.swing.JPanel();
                scaleTitleLabel = new javax.swing.JLabel();
                jLabel62 = new javax.swing.JLabel();
                neuroPatientIdTf = new javax.swing.JTextField();
                jPanel28 = new javax.swing.JPanel();
                jPanel29 = new javax.swing.JPanel();
                jLabel63 = new javax.swing.JLabel();
                eyesTf = new javax.swing.JTextField();
                jPanel30 = new javax.swing.JPanel();
                jLabel64 = new javax.swing.JLabel();
                verbalTf = new javax.swing.JTextField();
                jPanel31 = new javax.swing.JPanel();
                jLabel65 = new javax.swing.JLabel();
                motorTf = new javax.swing.JTextField();
                addNeuroScalesButton = new javax.swing.JButton();
                jLabel67 = new javax.swing.JLabel();
                locCb = new javax.swing.JComboBox<>();
                jLabel66 = new javax.swing.JLabel();
                lorCb = new javax.swing.JComboBox<>();
                jPanel2 = new javax.swing.JPanel();
                updateNeuroButton = new javax.swing.JButton();
                jLabel68 = new javax.swing.JLabel();
                labsTabFrame = new javax.swing.JInternalFrame();
                jLabel9 = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                addLabButton = new javax.swing.JButton();
                jScrollPane15 = new javax.swing.JScrollPane();
                labTable = new javax.swing.JTable(){
                        //add tooltip to display the full cell text when not displayed
                        public String getToolTipText( MouseEvent e )
                        {
                                int row = rowAtPoint( e.getPoint() );
                                //labs column is at index 5
                                int column = 5;

                                Object value = getValueAt(row, column);
                                return value == null ? null : value.toString();
                        }
                };
                injuriesTabFrame = new javax.swing.JInternalFrame();
                jLabel10 = new javax.swing.JLabel();
                jScrollPane17 = new javax.swing.JScrollPane();
                injuryTree = new javax.swing.JTree();
                jPanel4 = new javax.swing.JPanel();
                addInjuryButton = new javax.swing.JButton();
                consoleTabFrame = new javax.swing.JInternalFrame();
                jScrollPane18 = new javax.swing.JScrollPane();
                outputTextArea = new javax.swing.JTextArea();
                consoleInputPanel = new javax.swing.JPanel();
                inputTextField = new javax.swing.JTextField();
                sendButton = new javax.swing.JButton();
                dataLogsTabFrame = new javax.swing.JInternalFrame();
                dataLogPanel = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jScrollPane9 = new javax.swing.JScrollPane();
                logList = new javax.swing.JList<>();
                newLogButton = new javax.swing.JButton();
                selectLogButton = new javax.swing.JButton();
                jScrollPane10 = new javax.swing.JScrollPane();
                logTextArea = new javax.swing.JTextArea();
                documentsTabFrame = new javax.swing.JInternalFrame();
                documentsPanel = new javax.swing.JPanel();
                newDocButton = new javax.swing.JButton();
                jScrollPane11 = new javax.swing.JScrollPane();
                documentTextArea = new javax.swing.JTextArea();
                jLabel35 = new javax.swing.JLabel();
                tcccTabFrame = new javax.swing.JInternalFrame();
                newButton = new javax.swing.JButton();
                jScrollPane6 = new javax.swing.JScrollPane();
                tcccTextArea = new javax.swing.JTextArea();
                jPanel32 = new javax.swing.JPanel();
                jScrollPane5 = new javax.swing.JScrollPane();
                tcccList = new javax.swing.JList<>();

                createPatientPanel.setMinimumSize(new java.awt.Dimension(300, 96));
                createPatientPanel.setPreferredSize(new java.awt.Dimension(300, 96));

                jScrollPane8.setViewportView(createPatientList);

                newCreatePatientButton.setText("New CreatePatient");
                newCreatePatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newCreatePatientButtonActionPerformed(evt);
                        }
                });

                selectCreatePatientButton.setText("Select CreatePatient");
                selectCreatePatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                selectCreatePatientButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout createPatientPanelLayout = new javax.swing.GroupLayout(createPatientPanel);
                createPatientPanel.setLayout(createPatientPanelLayout);
                createPatientPanelLayout.setHorizontalGroup(
                        createPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createPatientPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newCreatePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectCreatePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(355, 355, 355))
                );
                createPatientPanelLayout.setVerticalGroup(
                        createPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createPatientPanelLayout.createSequentialGroup()
                                .addGroup(createPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(createPatientPanelLayout.createSequentialGroup()
                                                .addComponent(newCreatePatientButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectCreatePatientButton))
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
                );

                newPatientButtion.setText("New Patient");
                newPatientButtion.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newPatientButtionActionPerformed(evt);
                        }
                });

                lungVariablesPanel.setMinimumSize(new java.awt.Dimension(255, 200));

                jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel23.setText("Lung Variables:");

                jLabel24.setText("Tidal Volume:");

                jLabel25.setText("Dead Space:");

                jLabel26.setText("Total Capacity:");

                totalCapacityTextField.setToolTipText("");

                jLabel27.setText("Expiratory Reserve:");

                jLabel28.setText("Inspiratory Reserve:");

                jLabel29.setText("Residual Volume:");

                tidalVolumenTextField.setToolTipText("");

                javax.swing.GroupLayout lungVariablesPanelLayout = new javax.swing.GroupLayout(lungVariablesPanel);
                lungVariablesPanel.setLayout(lungVariablesPanelLayout);
                lungVariablesPanelLayout.setHorizontalGroup(
                        lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lungVariablesPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addGroup(lungVariablesPanelLayout.createSequentialGroup()
                                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel28)
                                                        .addComponent(jLabel29)
                                                        .addComponent(jLabel27))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(deadSpaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tidalVolumenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(expReserveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(residualVolumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(insReserveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                lungVariablesPanelLayout.setVerticalGroup(
                        lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lungVariablesPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(tidalVolumenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(deadSpaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(totalCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(expReserveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(insReserveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lungVariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29)
                                        .addComponent(residualVolumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                updatePatientButton.setText("Vitals Updater");
                updatePatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updatePatientButtonActionPerformed(evt);
                        }
                });

                vitalsUpdaterStopButton.setText("Stop");
                vitalsUpdaterStopButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vitalsUpdaterStopButtonActionPerformed(evt);
                        }
                });

                atTimeLabel.setText("At Time:");

                provideTCCCLabel3.setText("(ms)");

                javax.swing.GroupLayout atTimePanelLayout = new javax.swing.GroupLayout(atTimePanel);
                atTimePanel.setLayout(atTimePanelLayout);
                atTimePanelLayout.setHorizontalGroup(
                        atTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(atTimePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(atTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeAtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(provideTCCCLabel3)
                                .addContainerGap(34, Short.MAX_VALUE))
                );
                atTimePanelLayout.setVerticalGroup(
                        atTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(atTimePanelLayout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addGroup(atTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(atTimeLabel)
                                        .addComponent(timeAtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(provideTCCCLabel3)))
                );

                testFluidUpdater.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel50.setText("Body Fluids Updater");

                startButton1.setLabel("Start");
                startButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startButton1ActionPerformed(evt);
                        }
                });

                stopButton1.setText("Stop");
                stopButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                stopButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
                jPanel20.setLayout(jPanel20Layout);
                jPanel20Layout.setHorizontalGroup(
                        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(startButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stopButton1)
                                .addContainerGap())
                );
                jPanel20Layout.setVerticalGroup(
                        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startButton1)
                                        .addComponent(stopButton1)))
                );

                jLabel51.setText("For Object:");

                objectsCb.setPreferredSize(new java.awt.Dimension(200, 22));

                javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
                jPanel22.setLayout(jPanel22Layout);
                jPanel22Layout.setHorizontalGroup(
                        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel51)
                                .addGap(5, 5, 5)
                                .addComponent(objectsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                jPanel22Layout.setVerticalGroup(
                        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel51))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(objectsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jLabel52.setText("Update: ");

                fluidAttributeCb.setMinimumSize(new java.awt.Dimension(100, 22));
                fluidAttributeCb.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                fluidAttributeCbActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
                jPanel23.setLayout(jPanel23Layout);
                jPanel23Layout.setHorizontalGroup(
                        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fluidAttributeCb, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel23Layout.setVerticalGroup(
                        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel52))
                        .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(fluidAttributeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jLabel55.setText("for");

                durationTf.setPreferredSize(new java.awt.Dimension(50, 22));

                jLabel56.setText("seconds");

                javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
                jPanel24.setLayout(jPanel24Layout);
                jPanel24Layout.setHorizontalGroup(
                        jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel55)
                                .addGap(5, 5, 5)
                                .addComponent(durationTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel56))
                );
                jPanel24Layout.setVerticalGroup(
                        jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel55))
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(durationTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel56))
                );

                jLabel53.setText("by");

                incrementTf.setToolTipText("");
                incrementTf.setPreferredSize(new java.awt.Dimension(50, 22));

                jLabel54.setText("units");

                javax.swing.GroupLayout testFluidUpdaterLayout = new javax.swing.GroupLayout(testFluidUpdater);
                testFluidUpdater.setLayout(testFluidUpdaterLayout);
                testFluidUpdaterLayout.setHorizontalGroup(
                        testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel53)
                                                .addGap(5, 5, 5)
                                                .addComponent(incrementTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel54))
                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
                );
                testFluidUpdaterLayout.setVerticalGroup(
                        testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel50)
                                .addGap(12, 12, 12)
                                .addGroup(testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(incrementTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addGroup(testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel53)
                                                                .addComponent(jLabel54)))))
                                .addGroup(testFluidUpdaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(testFluidUpdaterLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBounds(new java.awt.Rectangle(0, 0, 900, 780));
                setSize(new java.awt.Dimension(920, 855));

                jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
                jTabbedPane.setMinimumSize(new java.awt.Dimension(820, 550));
                jTabbedPane.setPreferredSize(new java.awt.Dimension(860, 780));

                simControlInternalFrame.setPreferredSize(new java.awt.Dimension(820, 550));
                simControlInternalFrame.setVisible(true);

                joinFedButton.setText("Join Federation");
                joinFedButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                joinFedButtonActionPerformed(evt);
                        }
                });

                resignFedButton.setText("Resign");
                resignFedButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resignFedButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout controlButtonPanelLayout = new javax.swing.GroupLayout(controlButtonPanel);
                controlButtonPanel.setLayout(controlButtonPanelLayout);
                controlButtonPanelLayout.setHorizontalGroup(
                        controlButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(joinFedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(resignFedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                controlButtonPanelLayout.setVerticalGroup(
                        controlButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlButtonPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(joinFedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resignFedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                fedListTextArea.setColumns(20);
                fedListTextArea.setRows(5);
                fedListTextArea.setName(""); // NOI18N
                jScrollPane12.setViewportView(fedListTextArea);

                jLabel11.setText("Connected Federates");
                jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                javax.swing.GroupLayout fedListPanelLayout = new javax.swing.GroupLayout(fedListPanel);
                fedListPanel.setLayout(fedListPanelLayout);
                fedListPanelLayout.setHorizontalGroup(
                        fedListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fedListPanelLayout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(fedListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fedListPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fedListPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(68, 68, 68))))
                );
                fedListPanelLayout.setVerticalGroup(
                        fedListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fedListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout fedControlPanelLayout = new javax.swing.GroupLayout(fedControlPanel);
                fedControlPanel.setLayout(fedControlPanelLayout);
                fedControlPanelLayout.setHorizontalGroup(
                        fedControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fedControlPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(controlButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(fedListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                );
                fedControlPanelLayout.setVerticalGroup(
                        fedControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fedControlPanelLayout.createSequentialGroup()
                                .addGroup(fedControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(controlButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fedListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );

                jLabel12.setText("Federation Control");
                jLabel12.setAutoscrolls(true);
                jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                fedStatusPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
                fedStatusPanel.setLayout(new java.awt.GridLayout(5, 2, 0, 4));

                jLabel1.setText("Sim Elapsed Time:");
                fedStatusPanel.add(jLabel1);

                elapsedTimeLabel.setText("00:00:00");
                fedStatusPanel.add(elapsedTimeLabel);

                jLabel4.setText("Federation State:");
                fedStatusPanel.add(jLabel4);

                federationStateLabel.setText("No State Available");
                fedStatusPanel.add(federationStateLabel);

                jLabel5.setText("Sim Date Time:");
                fedStatusPanel.add(jLabel5);

                simDateTimeLabel.setText("Not Available");
                fedStatusPanel.add(simDateTimeLabel);

                jLabel6.setText("Wall Clock:");
                fedStatusPanel.add(jLabel6);

                wallClockLabel.setText("Not Available");
                fedStatusPanel.add(wallClockLabel);

                jLabel7.setText("Time Scale:");
                fedStatusPanel.add(jLabel7);

                timeScaleLabel.setText("1:1");
                fedStatusPanel.add(timeScaleLabel);

                jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabel13.setText("Change State:");

                fedStateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING_START", "RUNNING", "STOPPED", "PAUSED", "SAVING", "RESUMING" }));

                changeStateConfirmButton.setText("Confirm");
                changeStateConfirmButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changeStateConfirmButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(56, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(26, 26, 26)
                                .addComponent(fedStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(changeStateConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                );
                jPanel5Layout.setVerticalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fedStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changeStateConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                timeRatioLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                timeRatioLabel.setText("Change Time Scale:");

                timeRatioTextField.setText("1");
                timeRatioTextField.setToolTipText("");
                timeRatioTextField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                timeRatioTextFieldActionPerformed(evt);
                        }
                });

                jLabel15.setText(": 1");

                timeUpdateButton.setText("Update");
                timeUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                timeUpdateButtonActionPerformed(evt);
                        }
                });

                publishTimeCb.setText("Own Sim Time");
                publishTimeCb.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                publishTimeCbActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(timeRatioLabel)
                                                .addGap(69, 69, 69)
                                                .addComponent(timeRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(publishTimeCb)
                                                .addGap(74, 74, 74)))
                                .addComponent(timeUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                );
                jPanel8Layout.setVerticalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(timeRatioLabel))
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(timeRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel15))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(publishTimeCb))))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(timeUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                );

                jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12)
                                                .addGap(93, 93, 93)))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fedStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                jPanel6Layout.setVerticalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fedStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
                jPanel9.setLayout(jPanel9Layout);
                jPanel9Layout.setHorizontalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(fedControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );
                jPanel9Layout.setVerticalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(fedControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jLabel2.setText("TestTool 4.0.b");
                jLabel2.setToolTipText("");

                javax.swing.GroupLayout simControlInternalFrameLayout = new javax.swing.GroupLayout(simControlInternalFrame.getContentPane());
                simControlInternalFrame.getContentPane().setLayout(simControlInternalFrameLayout);
                simControlInternalFrameLayout.setHorizontalGroup(
                        simControlInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(simControlInternalFrameLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34))
                        .addGroup(simControlInternalFrameLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                simControlInternalFrameLayout.setVerticalGroup(
                        simControlInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(simControlInternalFrameLayout.createSequentialGroup()
                                .addContainerGap(164, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15))
                );

                jTabbedPane.addTab("SimControl", simControlInternalFrame);

                replayTabFrame.setVisible(true);

                fileDisplayPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jScrollPane3.setViewportView(replayFileList);

                jLabel73.setText("Uploaded Files");

                javax.swing.GroupLayout fileDisplayPanelLayout = new javax.swing.GroupLayout(fileDisplayPanel);
                fileDisplayPanel.setLayout(fileDisplayPanelLayout);
                fileDisplayPanelLayout.setHorizontalGroup(
                        fileDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fileDisplayPanelLayout.createSequentialGroup()
                                .addGroup(fileDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(fileDisplayPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(fileDisplayPanelLayout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel73)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                fileDisplayPanelLayout.setVerticalGroup(
                        fileDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fileDisplayPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                );

                replayButtonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jPanel37.setPreferredSize(new java.awt.Dimension(165, 124));

                uploadCsvBtn.setText("Upload CSV");
                uploadCsvBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                uploadCsvBtnActionPerformed(evt);
                        }
                });

                replayControlLabel.setText("Replay Controls");

                javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
                jPanel37.setLayout(jPanel37Layout);
                jPanel37Layout.setHorizontalGroup(
                        jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel37Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(uploadCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel37Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(replayControlLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel37Layout.setVerticalGroup(
                        jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addComponent(replayControlLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uploadCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
                );

                jPanel38.setPreferredSize(new java.awt.Dimension(165, 124));

                runReplayBtn.setText("Run Replay");
                runReplayBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                runReplayBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
                jPanel38.setLayout(jPanel38Layout);
                jPanel38Layout.setHorizontalGroup(
                        jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(runReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel38Layout.setVerticalGroup(
                        jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(runReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
                );

                pauseResumeReplayBtn.setText("Pause/Resume");
                pauseResumeReplayBtn.setEnabled(false);
                pauseResumeReplayBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                pauseResumeReplayBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
                jPanel39.setLayout(jPanel39Layout);
                jPanel39Layout.setHorizontalGroup(
                        jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel39Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pauseResumeReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel39Layout.setVerticalGroup(
                        jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(pauseResumeReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                );

                jPanel40.setPreferredSize(new java.awt.Dimension(165, 124));

                stopReplayBtn.setText("Stop");
                stopReplayBtn.setEnabled(false);
                stopReplayBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                stopReplayBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
                jPanel40.setLayout(jPanel40Layout);
                jPanel40Layout.setHorizontalGroup(
                        jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel40Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(stopReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel40Layout.setVerticalGroup(
                        jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addComponent(stopReplayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                );

                javax.swing.GroupLayout replayButtonPanelLayout = new javax.swing.GroupLayout(replayButtonPanel);
                replayButtonPanel.setLayout(replayButtonPanelLayout);
                replayButtonPanelLayout.setHorizontalGroup(
                        replayButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayButtonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(replayButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(replayButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                replayButtonPanelLayout.setVerticalGroup(
                        replayButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayButtonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                selectAllBtn.setText("Select All");
                selectAllBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                selectAllBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout selectAllPanelLayout = new javax.swing.GroupLayout(selectAllPanel);
                selectAllPanel.setLayout(selectAllPanelLayout);
                selectAllPanelLayout.setHorizontalGroup(
                        selectAllPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectAllPanelLayout.createSequentialGroup()
                                .addContainerGap(39, Short.MAX_VALUE)
                                .addComponent(selectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                );
                selectAllPanelLayout.setVerticalGroup(
                        selectAllPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectAllPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(selectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
                );

                removeSelectedBtn.setText("<html>\n\t<center>\n\t\tRemove\n\t\t<br></br> \n\t\tSelected Files\n\t</center>\n</html>");
                removeSelectedBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                removeSelectedBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout removeSelectedPanelLayout = new javax.swing.GroupLayout(removeSelectedPanel);
                removeSelectedPanel.setLayout(removeSelectedPanelLayout);
                removeSelectedPanelLayout.setHorizontalGroup(
                        removeSelectedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(removeSelectedPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(removeSelectedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
                );
                removeSelectedPanelLayout.setVerticalGroup(
                        removeSelectedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(removeSelectedPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(removeSelectedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout listIxBtnPanelLayout = new javax.swing.GroupLayout(listIxBtnPanel);
                listIxBtnPanel.setLayout(listIxBtnPanelLayout);
                listIxBtnPanelLayout.setHorizontalGroup(
                        listIxBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listIxBtnPanelLayout.createSequentialGroup()
                                .addComponent(selectAllPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeSelectedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                listIxBtnPanelLayout.setVerticalGroup(
                        listIxBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listIxBtnPanelLayout.createSequentialGroup()
                                .addGroup(listIxBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(selectAllPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeSelectedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel69.setText("Replay Status: ");

                replayStatusLabel.setText("Idle");

                javax.swing.GroupLayout replayStatusPanelLayout = new javax.swing.GroupLayout(replayStatusPanel);
                replayStatusPanel.setLayout(replayStatusPanelLayout);
                replayStatusPanelLayout.setHorizontalGroup(
                        replayStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayStatusPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(replayStatusLabel)
                                .addContainerGap(82, Short.MAX_VALUE))
                );
                replayStatusPanelLayout.setVerticalGroup(
                        replayStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayStatusPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(replayStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel69)
                                        .addComponent(replayStatusLabel))
                                .addContainerGap(15, Short.MAX_VALUE))
                );

                jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel70.setText("Runtime:");

                replayRuntime.setText("00:00:00");

                javax.swing.GroupLayout runtimePanelLayout = new javax.swing.GroupLayout(runtimePanel);
                runtimePanel.setLayout(runtimePanelLayout);
                runtimePanelLayout.setHorizontalGroup(
                        runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(runtimePanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel70)
                                .addGap(27, 27, 27)
                                .addComponent(replayRuntime)
                                .addContainerGap(100, Short.MAX_VALUE))
                );
                runtimePanelLayout.setVerticalGroup(
                        runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(runtimePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel70)
                                        .addComponent(replayRuntime))
                                .addContainerGap(18, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout statusAndRuntimePanelLayout = new javax.swing.GroupLayout(statusAndRuntimePanel);
                statusAndRuntimePanel.setLayout(statusAndRuntimePanelLayout);
                statusAndRuntimePanelLayout.setHorizontalGroup(
                        statusAndRuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusAndRuntimePanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(statusAndRuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(replayStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(runtimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                statusAndRuntimePanelLayout.setVerticalGroup(
                        statusAndRuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusAndRuntimePanelLayout.createSequentialGroup()
                                .addComponent(replayStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runtimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout replayMainPanelLayout = new javax.swing.GroupLayout(replayMainPanel);
                replayMainPanel.setLayout(replayMainPanelLayout);
                replayMainPanelLayout.setHorizontalGroup(
                        replayMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayMainPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(replayMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(listIxBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(statusAndRuntimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fileDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(replayButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
                );
                replayMainPanelLayout.setVerticalGroup(
                        replayMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(replayMainPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(replayMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(replayButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(replayMainPanelLayout.createSequentialGroup()
                                                .addComponent(fileDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(listIxBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(statusAndRuntimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout replayTabFrameLayout = new javax.swing.GroupLayout(replayTabFrame.getContentPane());
                replayTabFrame.getContentPane().setLayout(replayTabFrameLayout);
                replayTabFrameLayout.setHorizontalGroup(
                        replayTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, replayTabFrameLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(replayMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(164, Short.MAX_VALUE))
                );
                replayTabFrameLayout.setVerticalGroup(
                        replayTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, replayTabFrameLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(replayMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Replay", replayTabFrame);

                patientInternalFrame.setPreferredSize(new java.awt.Dimension(830, 720));
                patientInternalFrame.setVisible(true);

                patientDetailsPanel.setMinimumSize(new java.awt.Dimension(600, 500));
                patientDetailsPanel.setPreferredSize(new java.awt.Dimension(600, 500));

                mainPatientPanel.setMinimumSize(new java.awt.Dimension(700, 300));
                mainPatientPanel.setPreferredSize(new java.awt.Dimension(700, 250));
                mainPatientPanel.setRequestFocusEnabled(false);

                vitalsLabel.setText("Vitals");

                treatmentsLabel.setText("Treatments");

                injuriesLabel.setText("Injuries");

                label1.setAlignment(java.awt.Label.CENTER);
                label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                label1.setMinimumSize(new java.awt.Dimension(161, 50));
                label1.setText("Patient Object Manager");

                jLabel30.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
                jLabel30.setText("Patient Details");

                patientInjuriesTextArea.setColumns(20);
                patientInjuriesTextArea.setRows(5);
                patientInjuriesPane.setViewportView(patientInjuriesTextArea);

                patientTreatmentsTextArea.setColumns(20);
                patientTreatmentsTextArea.setRows(5);
                patientTreatmentsPane.setViewportView(patientTreatmentsTextArea);

                patientVitalsTextArea.setColumns(20);
                patientVitalsTextArea.setRows(5);
                patientVitalsPane.setViewportView(patientVitalsTextArea);

                javax.swing.GroupLayout mainPatientPanelLayout = new javax.swing.GroupLayout(mainPatientPanel);
                mainPatientPanel.setLayout(mainPatientPanelLayout);
                mainPatientPanelLayout.setHorizontalGroup(
                        mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel30)
                                .addGap(199, 199, 199)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPatientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                                .addComponent(patientVitalsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addComponent(treatmentsLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(patientTreatmentsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                                                        .addComponent(patientInjuriesPane))
                                                                .addGap(43, 43, 43)))))
                                .addContainerGap())
                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(vitalsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(injuriesLabel)
                                .addGap(188, 188, 188))
                );
                mainPatientPanelLayout.setVerticalGroup(
                        mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel30))
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vitalsLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPatientPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(injuriesLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPatientPanelLayout.createSequentialGroup()
                                                .addComponent(patientInjuriesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(treatmentsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(patientTreatmentsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                        .addComponent(patientVitalsPane))
                                .addContainerGap())
                );

                newTreatmentButton.setText("New Treatment");
                newTreatmentButton.setMaximumSize(new java.awt.Dimension(180, 46));
                newTreatmentButton.setMinimumSize(new java.awt.Dimension(180, 46));
                newTreatmentButton.setPreferredSize(new java.awt.Dimension(180, 46));
                newTreatmentButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newTreatmentButtonActionPerformed(evt);
                        }
                });

                vitalsUpdaterPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                vitalsUpdaterStartButton.setText("Start");
                vitalsUpdaterStartButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vitalsUpdaterStartButtonActionPerformed(evt);
                        }
                });

                jLabel31.setText("Update Interval:");

                jLabel32.setText("units per second");

                jLabel33.setText("Duration:");

                durationTextField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                durationTextFieldActionPerformed(evt);
                        }
                });

                attributeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BP Diastolic", "BP Systolic", "Heart Rate", "Resp Rate", "SPO2", "Temp", " " }));

                jLabel34.setText("seconds");

                vitalsUpdaterLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
                vitalsUpdaterLabel.setText("Vitals Updater");

                javax.swing.GroupLayout vitalsUpdaterPanelLayout = new javax.swing.GroupLayout(vitalsUpdaterPanel);
                vitalsUpdaterPanel.setLayout(vitalsUpdaterPanelLayout);
                vitalsUpdaterPanelLayout.setHorizontalGroup(
                        vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(vitalsUpdaterLabel))
                                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(intervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel32))
                                                        .addComponent(jLabel31)
                                                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(attributeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(vitalsUpdaterStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel33)
                                                                .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel34))))))
                                .addContainerGap(13, Short.MAX_VALUE))
                );
                vitalsUpdaterPanelLayout.setVerticalGroup(
                        vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(vitalsUpdaterPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(vitalsUpdaterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attributeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel32)
                                        .addComponent(intervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(vitalsUpdaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(vitalsUpdaterStartButton)
                                .addGap(25, 25, 25))
                );

                javax.swing.GroupLayout patientDetailsPanelLayout = new javax.swing.GroupLayout(patientDetailsPanel);
                patientDetailsPanel.setLayout(patientDetailsPanelLayout);
                patientDetailsPanelLayout.setHorizontalGroup(
                        patientDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientDetailsPanelLayout.createSequentialGroup()
                                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPatientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(patientDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vitalsUpdaterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(patientDetailsPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(newTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(91, Short.MAX_VALUE))
                );
                patientDetailsPanelLayout.setVerticalGroup(
                        patientDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientDetailsPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(patientDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(patientDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(vitalsUpdaterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10))
                                        .addGroup(patientDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(mainPatientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                patiendIdsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
                patiendIdsLabel.setText("PatientIDs");

                patientList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                patientList.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                patientListMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(patientList);

                javax.swing.GroupLayout patientIdsPanelLayout = new javax.swing.GroupLayout(patientIdsPanel);
                patientIdsPanel.setLayout(patientIdsPanelLayout);
                patientIdsPanelLayout.setHorizontalGroup(
                        patientIdsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(patientIdsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patiendIdsLabel)
                                .addContainerGap(83, Short.MAX_VALUE))
                );
                patientIdsPanelLayout.setVerticalGroup(
                        patientIdsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientIdsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patiendIdsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

                jLabel17.setText("Temperature:");

                jLabel18.setText("F");

                javax.swing.GroupLayout tempPanelLayout = new javax.swing.GroupLayout(tempPanel);
                tempPanel.setLayout(tempPanelLayout);
                tempPanelLayout.setHorizontalGroup(
                        tempPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tempPanelLayout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addGap(7, 7, 7))
                );
                tempPanelLayout.setVerticalGroup(
                        tempPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tempPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(tempPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18)))
                );

                jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel21.setText("Create New Patient Form");

                jLabel20.setText("Respiration Rate:");

                javax.swing.GroupLayout respirationRatePanelLayout = new javax.swing.GroupLayout(respirationRatePanel);
                respirationRatePanel.setLayout(respirationRatePanelLayout);
                respirationRatePanelLayout.setHorizontalGroup(
                        respirationRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(respirationRatePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
                );
                respirationRatePanelLayout.setVerticalGroup(
                        respirationRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(respirationRatePanelLayout.createSequentialGroup()
                                .addGroup(respirationRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20))
                                .addGap(0, 2, Short.MAX_VALUE))
                );

                jLabel19.setText("ETCO2:");

                etco2TextField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                etco2TextFieldActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout etco2PanelLayout = new javax.swing.GroupLayout(etco2Panel);
                etco2Panel.setLayout(etco2PanelLayout);
                etco2PanelLayout.setHorizontalGroup(
                        etco2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(etco2PanelLayout.createSequentialGroup()
                                .addGap(0, 60, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etco2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                );
                etco2PanelLayout.setVerticalGroup(
                        etco2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(etco2PanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(etco2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(etco2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jLabel22.setText("O2 Saturation:");

                javax.swing.GroupLayout o2SaturationPanelLayout = new javax.swing.GroupLayout(o2SaturationPanel);
                o2SaturationPanel.setLayout(o2SaturationPanelLayout);
                o2SaturationPanelLayout.setHorizontalGroup(
                        o2SaturationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(o2SaturationPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(o2SaturationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                );
                o2SaturationPanelLayout.setVerticalGroup(
                        o2SaturationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(o2SaturationPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(o2SaturationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(o2SaturationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                );

                patientIDLabel.setText("Patient ID:");

                patientIDTF.setToolTipText("");
                patientIDTF.setPreferredSize(new java.awt.Dimension(75, 23));
                patientIDTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                patientIDTFActionPerformed(evt);
                        }
                });

                autoFillButton.setText("AutoFill Vitals");
                autoFillButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                autoFillButtonActionPerformed(evt);
                        }
                });

                heartRateLabel.setText("Heart Rate:");

                heartRateTF.setToolTipText("");

                javax.swing.GroupLayout heartRatePanelLayout = new javax.swing.GroupLayout(heartRatePanel);
                heartRatePanel.setLayout(heartRatePanelLayout);
                heartRatePanelLayout.setHorizontalGroup(
                        heartRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(heartRatePanelLayout.createSequentialGroup()
                                .addComponent(heartRateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(heartRateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                );
                heartRatePanelLayout.setVerticalGroup(
                        heartRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(heartRatePanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(heartRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(heartRateLabel)
                                        .addComponent(heartRateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jLabel14.setText("Blood Pressure:");

                systolicBPTextField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                systolicBPTextFieldActionPerformed(evt);
                        }
                });

                jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel16.setText("/");

                javax.swing.GroupLayout bloodPressurePanelLayout = new javax.swing.GroupLayout(bloodPressurePanel);
                bloodPressurePanel.setLayout(bloodPressurePanelLayout);
                bloodPressurePanelLayout.setHorizontalGroup(
                        bloodPressurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bloodPressurePanelLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(systolicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diastolicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                                .addContainerGap())
                );
                bloodPressurePanelLayout.setVerticalGroup(
                        bloodPressurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bloodPressurePanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(bloodPressurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(systolicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diastolicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                requiredLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
                requiredLabel.setText("(Required)");

                javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                jPanel12.setLayout(jPanel12Layout);
                jPanel12Layout.setHorizontalGroup(
                        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(patientIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(requiredLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(autoFillButton))
                                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(heartRatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(bloodPressurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );
                jPanel12Layout.setVerticalGroup(
                        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientIDLabel)
                                        .addComponent(patientIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(requiredLabel))
                                .addGap(24, 24, 24)
                                .addComponent(autoFillButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heartRatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloodPressurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                addPatientButton.setText("Add Patient");
                addPatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addPatientButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
                jPanel33.setLayout(jPanel33Layout);
                jPanel33Layout.setHorizontalGroup(
                        jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addPatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                );
                jPanel33Layout.setVerticalGroup(
                        jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
                jPanel13.setLayout(jPanel13Layout);
                jPanel13Layout.setHorizontalGroup(
                        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(etco2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel13Layout.createSequentialGroup()
                                                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(respirationRatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(o2SaturationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tempPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(1, 1, 1))))))
                                .addContainerGap(15, Short.MAX_VALUE))
                );
                jPanel13Layout.setVerticalGroup(
                        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(o2SaturationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tempPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(respirationRatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(etco2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                createLungPatientButton.setText("<html>\n\t<center>\n\t\tCreate Patient\n\t\t<br></br> \n\t\tWith Lung\n\t\t<br></br>\n\t\tVariables\n\t</center>\n</html>\n\n");
                createLungPatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                createLungPatientButtonActionPerformed(evt);
                        }
                });

                jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(patientIdsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createLungPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                );
                jPanel10Layout.setVerticalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(createLungPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(patientIdsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                                .addGap(151, 151, 151))
                );

                jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Attribute Ownership"));

                patientAcquireB.setText("Acquire");
                patientAcquireB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                patientAcquireBActionPerformed(evt);
                        }
                });

                patientReleaseB.setText("Release");
                patientReleaseB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                patientReleaseBActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
                jPanel43.setLayout(jPanel43Layout);
                jPanel43Layout.setHorizontalGroup(
                        jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel43Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patientAcquireB)
                                .addGap(18, 18, 18)
                                .addComponent(patientReleaseB)
                                .addContainerGap(36, Short.MAX_VALUE))
                );
                jPanel43Layout.setVerticalGroup(
                        jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel43Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientAcquireB)
                                        .addComponent(patientReleaseB))
                                .addContainerGap(20, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout patientInternalFrameLayout = new javax.swing.GroupLayout(patientInternalFrame.getContentPane());
                patientInternalFrame.getContentPane().setLayout(patientInternalFrameLayout);
                patientInternalFrameLayout.setHorizontalGroup(
                        patientInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientInternalFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(patientInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(patientInternalFrameLayout.createSequentialGroup()
                                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(patientInternalFrameLayout.createSequentialGroup()
                                                .addGroup(patientInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(patientDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                patientInternalFrameLayout.setVerticalGroup(
                        patientInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientInternalFrameLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(patientDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Patient", patientInternalFrame);

                casualtyStateTabFrame.setVisible(true);

                eventsPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Events"));

                casualtyStateTA.setColumns(20);
                casualtyStateTA.setRows(5);
                casualtyStateTA.setToolTipText("");
                jScrollPane20.setViewportView(casualtyStateTA);

                eventsListLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventsListLabel1.setText("Casualty State");

                casualyStateInstanceL.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                casualyStateInstanceLMouseClicked(evt);
                        }
                });
                casualyStateInstanceL.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                casualyStateInstanceLKeyPressed(evt);
                        }
                });
                eventList1.setViewportView(casualyStateInstanceL);

                eventInformationLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventInformationLabel1.setText("Casualty State Information");

                javax.swing.GroupLayout eventsPanel1Layout = new javax.swing.GroupLayout(eventsPanel1);
                eventsPanel1.setLayout(eventsPanel1Layout);
                eventsPanel1Layout.setHorizontalGroup(
                        eventsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanel1Layout.createSequentialGroup()
                                .addComponent(eventList1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane20)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventsPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(eventsListLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventInformationLabel1)
                                .addGap(303, 303, 303))
                );
                eventsPanel1Layout.setVerticalGroup(
                        eventsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(eventsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eventsListLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eventInformationLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eventsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eventList1))
                                .addContainerGap(17, Short.MAX_VALUE))
                );

                jLabel79.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel79.setText("Create New Casualty state");

                jLabel81.setText("Patient ID:");

                casualtyStatePatientIdTF.setMinimumSize(new java.awt.Dimension(100, 20));
                casualtyStatePatientIdTF.setPreferredSize(new java.awt.Dimension(100, 20));

                casualtyStateFacilityIdTF.setMinimumSize(new java.awt.Dimension(100, 20));
                casualtyStateFacilityIdTF.setPreferredSize(new java.awt.Dimension(100, 20));
                casualtyStateFacilityIdTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                casualtyStateFacilityIdTFActionPerformed(evt);
                        }
                });

                jLabel84.setText("Facility ID:");

                casualtyStateCreateB.setText("Create Casualy State");
                casualtyStateCreateB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                casualtyStateCreateBActionPerformed(evt);
                        }
                });

                jLabel82.setText("Evacuation Priority:");

                casualtyStateEvacPirorityCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "Urgent", "Urgent Surgical", "Priority", "Routine", "Convenience", "Not Applicable" }));

                jLabel83.setText("Triage Classification:");

                casualtyStateTriageClassificationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Delayed", "Immediate", "Expectant", "Minimal" }));
                casualtyStateTriageClassificationCB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                casualtyStateTriageClassificationCBActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
                jPanel41.setLayout(jPanel41Layout);
                jPanel41Layout.setHorizontalGroup(
                        jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel41Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel41Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(casualtyStateCreateB, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel41Layout.createSequentialGroup()
                                                .addComponent(jLabel81)
                                                .addGap(18, 18, 18)
                                                .addComponent(casualtyStatePatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel41Layout.createSequentialGroup()
                                                .addComponent(jLabel84)
                                                .addGap(18, 18, 18)
                                                .addComponent(casualtyStateFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel41Layout.createSequentialGroup()
                                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(casualtyStateEvacPirorityCB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel41Layout.createSequentialGroup()
                                                .addComponent(jLabel83)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(casualtyStateTriageClassificationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
                );
                jPanel41Layout.setVerticalGroup(
                        jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel81)
                                        .addComponent(casualtyStatePatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel84)
                                        .addComponent(casualtyStateFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel82)
                                        .addComponent(casualtyStateEvacPirorityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel83)
                                        .addComponent(casualtyStateTriageClassificationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(casualtyStateCreateB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout createNewEventPanel1Layout = new javax.swing.GroupLayout(createNewEventPanel1);
                createNewEventPanel1.setLayout(createNewEventPanel1Layout);
                createNewEventPanel1Layout.setHorizontalGroup(
                        createNewEventPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createNewEventPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createNewEventPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel79)
                                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(512, Short.MAX_VALUE))
                );
                createNewEventPanel1Layout.setVerticalGroup(
                        createNewEventPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createNewEventPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout casualtyStateTabFrameLayout = new javax.swing.GroupLayout(casualtyStateTabFrame.getContentPane());
                casualtyStateTabFrame.getContentPane().setLayout(casualtyStateTabFrameLayout);
                casualtyStateTabFrameLayout.setHorizontalGroup(
                        casualtyStateTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(casualtyStateTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(casualtyStateTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createNewEventPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                casualtyStateTabFrameLayout.setVerticalGroup(
                        casualtyStateTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(casualtyStateTabFrameLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(eventsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(createNewEventPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("CasualtyState", casualtyStateTabFrame);

                signsAndSymptomsTabFrame.setVisible(true);

                patiendIdsLabelSS.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
                patiendIdsLabelSS.setText("Select A Patient:");

                patientListSS.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                patientListSS.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                patientListSSMouseClicked(evt);
                        }
                });
                patientIdsScrollPaneSS.setViewportView(patientListSS);

                javax.swing.GroupLayout patientIdsPanel1Layout = new javax.swing.GroupLayout(patientIdsPanel1);
                patientIdsPanel1.setLayout(patientIdsPanel1Layout);
                patientIdsPanel1Layout.setHorizontalGroup(
                        patientIdsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientIdsPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patiendIdsLabelSS, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                        .addComponent(patientIdsScrollPaneSS, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                );
                patientIdsPanel1Layout.setVerticalGroup(
                        patientIdsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientIdsPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patiendIdsLabelSS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientIdsScrollPaneSS, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                addSignSymptomButton.setText("Add Sign/Symptom");
                addSignSymptomButton.setEnabled(false);
                addSignSymptomButton.setPreferredSize(new java.awt.Dimension(361, 73));
                addSignSymptomButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addSignSymptomButtonActionPerformed(evt);
                        }
                });

                patientSignsPane.setPreferredSize(new java.awt.Dimension(280, 370));

                patientSignsTextArea.setColumns(20);
                patientSignsTextArea.setRows(5);
                patientSignsPane.setViewportView(patientSignsTextArea);

                patientSymptomsPane.setPreferredSize(new java.awt.Dimension(280, 370));

                patientSymptomsTextArea.setColumns(20);
                patientSymptomsTextArea.setRows(5);
                patientSymptomsPane.setViewportView(patientSymptomsTextArea);

                signsLabel.setText("Patient Signs");

                symptomsLabel.setText("Patient Symptoms");

                javax.swing.GroupLayout singsAndSymptomsPaneLayout = new javax.swing.GroupLayout(singsAndSymptomsPane);
                singsAndSymptomsPane.setLayout(singsAndSymptomsPaneLayout);
                singsAndSymptomsPaneLayout.setHorizontalGroup(
                        singsAndSymptomsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(singsAndSymptomsPaneLayout.createSequentialGroup()
                                .addGroup(singsAndSymptomsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(singsAndSymptomsPaneLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(patientSignsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(patientSymptomsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(singsAndSymptomsPaneLayout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addComponent(signsLabel)
                                                .addGap(225, 225, 225)
                                                .addComponent(symptomsLabel)))
                                .addContainerGap(312, Short.MAX_VALUE))
                );
                singsAndSymptomsPaneLayout.setVerticalGroup(
                        singsAndSymptomsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(singsAndSymptomsPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(singsAndSymptomsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signsLabel)
                                        .addComponent(symptomsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(singsAndSymptomsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(patientSignsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientSymptomsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(47, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout signsAndSymptomsTabFrameLayout = new javax.swing.GroupLayout(signsAndSymptomsTabFrame.getContentPane());
                signsAndSymptomsTabFrame.getContentPane().setLayout(signsAndSymptomsTabFrameLayout);
                signsAndSymptomsTabFrameLayout.setHorizontalGroup(
                        signsAndSymptomsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(patientIdsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signsAndSymptomsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(singsAndSymptomsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(addSignSymptomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                signsAndSymptomsTabFrameLayout.setVerticalGroup(
                        signsAndSymptomsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                .addGroup(signsAndSymptomsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(patientIdsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(signsAndSymptomsTabFrameLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(addSignSymptomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(singsAndSymptomsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(216, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Signs & Symptoms", signsAndSymptomsTabFrame);

                instructionalTabFrame.setVisible(true);

                eventsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Events"));

                bookmarkTextArea.setColumns(20);
                bookmarkTextArea.setRows(5);
                bookmarkTextArea.setToolTipText("");
                jScrollPane4.setViewportView(bookmarkTextArea);

                eventsListLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventsListLabel.setText("Events");

                bookmarkList.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                bookmarkListMouseClicked(evt);
                        }
                });
                eventList.setViewportView(bookmarkList);

                eventInformationLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventInformationLabel.setText("Event Information");

                javax.swing.GroupLayout eventsPanelLayout = new javax.swing.GroupLayout(eventsPanel);
                eventsPanel.setLayout(eventsPanelLayout);
                eventsPanelLayout.setHorizontalGroup(
                        eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanelLayout.createSequentialGroup()
                                .addComponent(eventList, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventsPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(eventsListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventInformationLabel)
                                .addGap(303, 303, 303))
                );
                eventsPanelLayout.setVerticalGroup(
                        eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eventsListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eventInformationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(eventList, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(17, Short.MAX_VALUE))
                );

                jLabel38.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel38.setText("Create New Event");

                notesLabel.setText("Notes:");

                notesTextArea.setColumns(20);
                notesTextArea.setRows(5);
                jScrollPane2.setViewportView(notesTextArea);

                jLabel39.setText("Description:");

                desTextArea.setColumns(20);
                desTextArea.setRows(5);
                jScrollPane16.setViewportView(desTextArea);

                typeLabel.setText("Type:");

                typeComboBox.setMinimumSize(new java.awt.Dimension(150, 22));
                typeComboBox.setPreferredSize(new java.awt.Dimension(150, 22));

                jLabel41.setText("Patient ID:");

                pidTextField.setMinimumSize(new java.awt.Dimension(100, 20));
                pidTextField.setPreferredSize(new java.awt.Dimension(100, 20));

                jLabel43.setText("Instructor ID:");

                iidTextField.setToolTipText("");
                iidTextField.setMinimumSize(new java.awt.Dimension(100, 20));
                iidTextField.setPreferredSize(new java.awt.Dimension(100, 20));

                jLabel45.setText("Team ID:");

                tidTextField.setMinimumSize(new java.awt.Dimension(100, 20));
                tidTextField.setPreferredSize(new java.awt.Dimension(100, 20));

                facilityTextField.setMinimumSize(new java.awt.Dimension(100, 20));
                facilityTextField.setPreferredSize(new java.awt.Dimension(100, 20));
                facilityTextField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                facilityTextFieldActionPerformed(evt);
                        }
                });

                sourceTextField.setPreferredSize(new java.awt.Dimension(100, 20));

                jLabel42.setText("Facility ID:");

                lidTextField.setMinimumSize(new java.awt.Dimension(100, 20));
                lidTextField.setPreferredSize(new java.awt.Dimension(100, 20));

                jLabel44.setText("Learner ID:");

                jLabel40.setText("Source:");

                createEventButton.setText("Create Event");
                createEventButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                createEventButtonActionPerformed(evt);
                        }
                });

                learnerActionLabel.setText("Learner Action:");

                learnerActionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(typeLabel)
                                                .addGap(46, 46, 46)
                                                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel41)
                                                                .addGap(19, 19, 19)
                                                                .addComponent(pidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel43)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(iidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel45)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(tidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel40)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(sourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel42)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(facilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addComponent(jLabel44)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(lidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                        .addComponent(learnerActionLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(learnerActionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(createEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(12, Short.MAX_VALUE))
                );
                jPanel11Layout.setVerticalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(typeLabel))
                                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel41))
                                                        .addComponent(pidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel43))
                                                        .addComponent(iidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel45))
                                                        .addComponent(tidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel40))
                                                        .addComponent(sourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel42))
                                                        .addComponent(facilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel44))
                                                        .addComponent(lidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(learnerActionCB)
                                        .addComponent(learnerActionLabel))
                                .addGap(18, 18, 18)
                                .addComponent(createEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                );

                javax.swing.GroupLayout createNewEventPanelLayout = new javax.swing.GroupLayout(createNewEventPanel);
                createNewEventPanel.setLayout(createNewEventPanelLayout);
                createNewEventPanelLayout.setHorizontalGroup(
                        createNewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createNewEventPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createNewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel38)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addGroup(createNewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                                                .addComponent(notesLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel39)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane16)
                                                        .addComponent(jScrollPane2))))
                                .addContainerGap())
                );
                createNewEventPanelLayout.setVerticalGroup(
                        createNewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createNewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(createNewEventPanelLayout.createSequentialGroup()
                                                .addComponent(notesLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel39)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane16))
                                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout instructionalTabFrameLayout = new javax.swing.GroupLayout(instructionalTabFrame.getContentPane());
                instructionalTabFrame.getContentPane().setLayout(instructionalTabFrameLayout);
                instructionalTabFrameLayout.setHorizontalGroup(
                        instructionalTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(instructionalTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(instructionalTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createNewEventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                instructionalTabFrameLayout.setVerticalGroup(
                        instructionalTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(instructionalTabFrameLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(eventsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(createNewEventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Instructional", instructionalTabFrame);

                facilityTabFrame.setVisible(true);

                eventsPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Events"));

                facilityInformationTA.setColumns(20);
                facilityInformationTA.setRows(5);
                facilityInformationTA.setToolTipText("");
                jScrollPane21.setViewportView(facilityInformationTA);

                eventsListLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventsListLabel2.setText("Facilities");

                facilityInstanceL.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                facilityInstanceLMouseClicked(evt);
                        }
                });
                facilityInstanceL.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                facilityInstanceLKeyPressed(evt);
                        }
                });
                eventList2.setViewportView(facilityInstanceL);

                eventInformationLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                eventInformationLabel2.setText("Facility Information");

                javax.swing.GroupLayout eventsPanel2Layout = new javax.swing.GroupLayout(eventsPanel2);
                eventsPanel2.setLayout(eventsPanel2Layout);
                eventsPanel2Layout.setHorizontalGroup(
                        eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanel2Layout.createSequentialGroup()
                                .addComponent(eventList2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventsPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(eventsListLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                                .addComponent(eventInformationLabel2)
                                .addGap(303, 303, 303))
                );
                eventsPanel2Layout.setVerticalGroup(
                        eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventsPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eventsListLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eventInformationLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eventList2))
                                .addContainerGap(17, Short.MAX_VALUE))
                );

                jLabel80.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel80.setText("Create New Facility");

                facilityFacilityIdTF.setMinimumSize(new java.awt.Dimension(100, 20));
                facilityFacilityIdTF.setPreferredSize(new java.awt.Dimension(100, 20));
                facilityFacilityIdTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                facilityFacilityIdTFActionPerformed(evt);
                        }
                });

                jLabel86.setText("Facility ID:");

                jLabel87.setText("Role of Care:");

                facilityRoleOfCareCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Role 1", "Role 2", "Role 3", "Role 4", "En Route" }));

                jLabel88.setText("Facility Type:");

                facilityFacilityTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Fixed", "Ground", "Air" }));
                facilityFacilityTypeCB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                facilityFacilityTypeCBActionPerformed(evt);
                        }
                });

                jLabel85.setText("Patient Capacity:");

                facilityCreateB.setText("Create Facility");
                facilityCreateB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                facilityCreateBActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
                jPanel42.setLayout(jPanel42Layout);
                jPanel42Layout.setHorizontalGroup(
                        jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                                .addComponent(jLabel86)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(facilityFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(facilityRoleOfCareCB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                                .addComponent(jLabel88)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(facilityFacilityTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                                .addComponent(jLabel85)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(facilityPatientCapacityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel42Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(facilityCreateB, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(26, Short.MAX_VALUE))
                );
                jPanel42Layout.setVerticalGroup(
                        jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel86)
                                        .addComponent(facilityFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel87)
                                        .addComponent(facilityRoleOfCareCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel88)
                                        .addComponent(facilityFacilityTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel85)
                                        .addComponent(facilityPatientCapacityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(facilityCreateB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout createNewEventPanel2Layout = new javax.swing.GroupLayout(createNewEventPanel2);
                createNewEventPanel2.setLayout(createNewEventPanel2Layout);
                createNewEventPanel2Layout.setHorizontalGroup(
                        createNewEventPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createNewEventPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createNewEventPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel80)
                                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                createNewEventPanel2Layout.setVerticalGroup(
                        createNewEventPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createNewEventPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(68, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout facilityTabFrameLayout = new javax.swing.GroupLayout(facilityTabFrame.getContentPane());
                facilityTabFrame.getContentPane().setLayout(facilityTabFrameLayout);
                facilityTabFrameLayout.setHorizontalGroup(
                        facilityTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(facilityTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(facilityTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventsPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createNewEventPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                facilityTabFrameLayout.setVerticalGroup(
                        facilityTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(facilityTabFrameLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(eventsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(createNewEventPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(209, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Facilities", facilityTabFrame);

                controlInteractionsTabFrame.setPreferredSize(new java.awt.Dimension(850, 760));
                controlInteractionsTabFrame.setVisible(true);

                jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                interactionHistoryTextArea.setColumns(20);
                interactionHistoryTextArea.setLineWrap(true);
                interactionHistoryTextArea.setRows(5);
                jScrollPane7.setViewportView(interactionHistoryTextArea);

                federationControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Federation Controls"));

                selectScenarioPanel.setMinimumSize(new java.awt.Dimension(250, 80));
                selectScenarioPanel.setOpaque(false);
                selectScenarioPanel.setPreferredSize(new java.awt.Dimension(250, 30));

                selectScenarioJButton.setText("Select Scenario");
                selectScenarioJButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                selectScenarioJButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout selectScenarioPanelLayout = new javax.swing.GroupLayout(selectScenarioPanel);
                selectScenarioPanel.setLayout(selectScenarioPanelLayout);
                selectScenarioPanelLayout.setHorizontalGroup(
                        selectScenarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectScenarioPanelLayout.createSequentialGroup()
                                .addComponent(selectScenarioJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scenarioNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                selectScenarioPanelLayout.setVerticalGroup(
                        selectScenarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectScenarioPanelLayout.createSequentialGroup()
                                .addGroup(selectScenarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectScenarioJButton)
                                        .addComponent(scenarioNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                startButton.setText("Start");
                startButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startButtonActionPerformed(evt);
                        }
                });

                stopButton.setText("Stop");
                stopButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                stopButtonActionPerformed(evt);
                        }
                });

                pauseButton.setText("Pause");
                pauseButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                pauseButtonActionPerformed(evt);
                        }
                });

                resumeButton.setText("Resume");
                resumeButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resumeButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout startButtonPanelLayout = new javax.swing.GroupLayout(startButtonPanel);
                startButtonPanel.setLayout(startButtonPanelLayout);
                startButtonPanelLayout.setHorizontalGroup(
                        startButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startButtonPanelLayout.createSequentialGroup()
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pauseButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resumeButton)
                                .addGap(0, 6, Short.MAX_VALUE))
                );
                startButtonPanelLayout.setVerticalGroup(
                        startButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startButtonPanelLayout.createSequentialGroup()
                                .addGroup(startButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startButton)
                                        .addComponent(stopButton)
                                        .addComponent(pauseButton)
                                        .addComponent(resumeButton))
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                scenarioNameLabel.setText("(name)");

                javax.swing.GroupLayout federationControlPanelLayout = new javax.swing.GroupLayout(federationControlPanel);
                federationControlPanel.setLayout(federationControlPanelLayout);
                federationControlPanelLayout.setHorizontalGroup(
                        federationControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(federationControlPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(federationControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(selectScenarioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addComponent(startButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(scenarioNameLabel)
                                .addGap(17, 17, 17))
                );
                federationControlPanelLayout.setVerticalGroup(
                        federationControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(federationControlPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(federationControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(selectScenarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scenarioNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                );

                instructionalControlsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructional Controls"));

                instructionPanel.setToolTipText("");
                instructionPanel.setMinimumSize(new java.awt.Dimension(350, 60));
                instructionPanel.setName(""); // NOI18N
                instructionPanel.setPreferredSize(new java.awt.Dimension(350, 60));

                iStartButton.setText("I Start");
                iStartButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                iStartButtonActionPerformed(evt);
                        }
                });

                jLabel8.setText("Facility ID:");

                iStopButton.setText("I Stop");
                iStopButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                iStopButtonActionPerformed(evt);
                        }
                });

                iPauseButton.setText("I Pause");
                iPauseButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                iPauseButtonActionPerformed(evt);
                        }
                });

                iResumeButton.setText("I Resume");
                iResumeButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                iResumeButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout instructionPanelLayout = new javax.swing.GroupLayout(instructionPanel);
                instructionPanel.setLayout(instructionPanelLayout);
                instructionPanelLayout.setHorizontalGroup(
                        instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(instructionPanelLayout.createSequentialGroup()
                                .addComponent(iStartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(instructionPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(facilityIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(instructionPanelLayout.createSequentialGroup()
                                                .addComponent(iStopButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(iPauseButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(iResumeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                                .addGap(10, 10, 10))))
                );
                instructionPanelLayout.setVerticalGroup(
                        instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, instructionPanelLayout.createSequentialGroup()
                                .addGroup(instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(facilityIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(iStartButton)
                                        .addComponent(iStopButton)
                                        .addComponent(iPauseButton)
                                        .addComponent(iResumeButton))
                                .addContainerGap(9, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout instructionalControlsPanelLayout = new javax.swing.GroupLayout(instructionalControlsPanel);
                instructionalControlsPanel.setLayout(instructionalControlsPanelLayout);
                instructionalControlsPanelLayout.setHorizontalGroup(
                        instructionalControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(instructionalControlsPanelLayout.createSequentialGroup()
                                .addComponent(instructionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                instructionalControlsPanelLayout.setVerticalGroup(
                        instructionalControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(instructionalControlsPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(instructionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(13, Short.MAX_VALUE))
                );

                patientControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Patient Controls"));
                patientControlPanel.setMinimumSize(new java.awt.Dimension(350, 150));
                patientControlPanel.setPreferredSize(new java.awt.Dimension(350, 150));

                loadPatientButton.setText("Load Patient");
                loadPatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loadPatientButtonActionPerformed(evt);
                        }
                });

                patientActionPatientIdLabel.setText("Patient ID:");

                startPatientButton.setText("Start Patient");
                startPatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startPatientButtonActionPerformed(evt);
                        }
                });

                stopPatientButton.setText("Stop Patient");
                stopPatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                stopPatientButtonActionPerformed(evt);
                        }
                });

                pausePatientButton.setText("Pause Patient");
                pausePatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                pausePatientButtonActionPerformed(evt);
                        }
                });

                resumePatientButton.setText("Resume Patient");
                resumePatientButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resumePatientButtonActionPerformed(evt);
                        }
                });

                saveButton.setText("Save");
                saveButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                saveButtonActionPerformed(evt);
                        }
                });

                saveLabel.setText("(Label)");

                javax.swing.GroupLayout patientControlPanelLayout = new javax.swing.GroupLayout(patientControlPanel);
                patientControlPanel.setLayout(patientControlPanelLayout);
                patientControlPanelLayout.setHorizontalGroup(
                        patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientControlPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(patientActionPatientIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientControlPatientIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loadPatientButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(patientControlPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(patientControlPanelLayout.createSequentialGroup()
                                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startPatientButton)
                                                        .addComponent(pausePatientButton))
                                                .addGap(42, 42, 42)
                                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(stopPatientButton)
                                                        .addComponent(resumePatientButton)))
                                        .addGroup(patientControlPanelLayout.createSequentialGroup()
                                                .addComponent(saveButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(saveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(saveLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                patientControlPanelLayout.setVerticalGroup(
                        patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientControlPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientActionPatientIdLabel)
                                        .addComponent(patientControlPatientIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loadPatientButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startPatientButton)
                                        .addComponent(stopPatientButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pausePatientButton)
                                        .addComponent(resumePatientButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(patientControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveButton)
                                        .addComponent(saveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveLabel))
                                .addContainerGap(32, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout interactionsControlPanelLayout = new javax.swing.GroupLayout(interactionsControlPanel);
                interactionsControlPanel.setLayout(interactionsControlPanelLayout);
                interactionsControlPanelLayout.setHorizontalGroup(
                        interactionsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(interactionsControlPanelLayout.createSequentialGroup()
                                .addGroup(interactionsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(federationControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(instructionalControlsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(patientControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                                .addContainerGap())
                );
                interactionsControlPanelLayout.setVerticalGroup(
                        interactionsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(interactionsControlPanelLayout.createSequentialGroup()
                                .addComponent(federationControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(instructionalControlsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(344, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout controlInteractionsTabFrameLayout = new javax.swing.GroupLayout(controlInteractionsTabFrame.getContentPane());
                controlInteractionsTabFrame.getContentPane().setLayout(controlInteractionsTabFrameLayout);
                controlInteractionsTabFrameLayout.setHorizontalGroup(
                        controlInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlInteractionsTabFrameLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(interactionsControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addGap(21, 21, 21))
                );
                controlInteractionsTabFrameLayout.setVerticalGroup(
                        controlInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlInteractionsTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(controlInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane7)
                                        .addComponent(interactionsControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );

                jTabbedPane.addTab("Control Interactions", controlInteractionsTabFrame);

                patientInteractionsTabFrame.setPreferredSize(new java.awt.Dimension(850, 760));
                patientInteractionsTabFrame.setVisible(true);

                jScrollPane19.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                interactionHistoryTextArea1.setColumns(20);
                interactionHistoryTextArea1.setLineWrap(true);
                interactionHistoryTextArea1.setRows(5);
                jScrollPane19.setViewportView(interactionHistoryTextArea1);

                medicalEvacuationPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Medical Evacuation"));
                medicalEvacuationPanel1.setMinimumSize(new java.awt.Dimension(350, 154));
                medicalEvacuationPanel1.setOpaque(false);

                evacPatientIdLabel1.setText("Patient ID:");

                siteNameLabel1.setText("Site Name:");

                requestEvacButton1.setText("Request Evac");
                requestEvacButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                requestEvacButton1ActionPerformed(evt);
                        }
                });

                transportTypeComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ground", "Air", "Unknown" }));

                vehicleIdLabel1.setText("Vehicle ID:");

                evacStageLabel1.setText("Evac State:");

                evacStateComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Applicable", "Acknowledgement", "Enroute", "Arrival", "Patient Loaded", "Dropoff" }));

                updateEvacButton1.setText("Update Evac");
                updateEvacButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateEvacButton1ActionPerformed(evt);
                        }
                });

                responseEvacButton1.setText("Respond Evac");
                responseEvacButton1.setActionCommand("RespondEvac");
                responseEvacButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                responseEvacButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout medicalEvacuationPanel1Layout = new javax.swing.GroupLayout(medicalEvacuationPanel1);
                medicalEvacuationPanel1.setLayout(medicalEvacuationPanel1Layout);
                medicalEvacuationPanel1Layout.setHorizontalGroup(
                        medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                                .addComponent(vehicleIdLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vehicleIdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(evacStageLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(evacStateComboBox1, 0, 229, Short.MAX_VALUE))
                                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                                                .addComponent(updateEvacButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(responseEvacButton1))
                                                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                                                .addComponent(requestEvacButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(transportTypeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(evacPatientIdLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(evacPatientIdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(siteNameLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(siteNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                medicalEvacuationPanel1Layout.setVerticalGroup(
                        medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(medicalEvacuationPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(evacPatientIdLabel1)
                                        .addComponent(evacPatientIdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(siteNameLabel1)
                                        .addComponent(siteNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(requestEvacButton1)
                                        .addComponent(transportTypeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(vehicleIdLabel1)
                                        .addComponent(vehicleIdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(evacStageLabel1)
                                        .addComponent(evacStateComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(medicalEvacuationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateEvacButton1)
                                        .addComponent(responseEvacButton1))
                                .addGap(18, 18, 18))
                );

                jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Magic Vitals"));

                jLabel71.setText("Patient ID:");

                magicVitalsPatientIdTF.setColumns(6);
                magicVitalsPatientIdTF.setMinimumSize(new java.awt.Dimension(74, 22));
                magicVitalsPatientIdTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicVitalsPatientIdTFActionPerformed(evt);
                        }
                });

                magicVitalsTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "HR", "DBP", "SBP", "SpO2", "Temp", "EtCO2", "RR" }));
                magicVitalsTypeCB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicVitalsTypeCBActionPerformed(evt);
                        }
                });

                jLabel72.setText("Vitals:");

                jLabel74.setText("Value:");

                magicVitalsValueTF.setColumns(4);
                magicVitalsValueTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicVitalsValueTFActionPerformed(evt);
                        }
                });

                sendMagicVitalsB.setText("Send Magic Vitals");
                sendMagicVitalsB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                sendMagicVitalsBActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
                jPanel34.setLayout(jPanel34Layout);
                jPanel34Layout.setHorizontalGroup(
                        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sendMagicVitalsB)
                                        .addGroup(jPanel34Layout.createSequentialGroup()
                                                .addComponent(jLabel71)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(magicVitalsPatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel72)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(magicVitalsTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel74)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(magicVitalsValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(56, Short.MAX_VALUE))
                );
                jPanel34Layout.setVerticalGroup(
                        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel71)
                                        .addComponent(magicVitalsPatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(magicVitalsTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel72)
                                        .addComponent(jLabel74)
                                        .addComponent(magicVitalsValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendMagicVitalsB)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Vitals Visibility"));

                jLabel75.setText("Patient ID:");

                jLabel76.setText("Vitals:");

                vitalsVisibilityTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "HR", "BP", "SpO2", "Temp", "EtCO2", "RR" }));

                vitalsVisibilityMakeVisibleB.setText("Make Visible");
                vitalsVisibilityMakeVisibleB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vitalsVisibilityMakeVisibleBActionPerformed(evt);
                        }
                });

                vitalsVisibilityHideB.setText("Hide");
                vitalsVisibilityHideB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vitalsVisibilityHideBActionPerformed(evt);
                        }
                });

                vitalsVisibilityPatientIdTF1.setColumns(5);
                vitalsVisibilityPatientIdTF1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vitalsVisibilityPatientIdTF1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
                jPanel35.setLayout(jPanel35Layout);
                jPanel35Layout.setHorizontalGroup(
                        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addComponent(vitalsVisibilityMakeVisibleB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(vitalsVisibilityHideB))
                                        .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addComponent(jLabel75)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(vitalsVisibilityPatientIdTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel76)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vitalsVisibilityTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel35Layout.setVerticalGroup(
                        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel75)
                                        .addComponent(jLabel76)
                                        .addComponent(vitalsVisibilityTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vitalsVisibilityPatientIdTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(vitalsVisibilityMakeVisibleB)
                                        .addComponent(vitalsVisibilityHideB))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Magic Transfer"));

                jLabel77.setText("Patient ID:");

                magicTransferPatientIdTF.setColumns(5);
                magicTransferPatientIdTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicTransferPatientIdTFActionPerformed(evt);
                        }
                });

                jLabel78.setText("Facility ID:");

                magicTransferFacilityIdTF.setColumns(5);
                magicTransferFacilityIdTF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicTransferFacilityIdTFActionPerformed(evt);
                        }
                });

                magicTransferB.setText("Transfer");
                magicTransferB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                magicTransferBActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
                jPanel36.setLayout(jPanel36Layout);
                jPanel36Layout.setHorizontalGroup(
                        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(magicTransferB)
                                        .addGroup(jPanel36Layout.createSequentialGroup()
                                                .addComponent(jLabel77)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(magicTransferPatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel78)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(magicTransferFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel36Layout.setVerticalGroup(
                        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel36Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel77)
                                        .addComponent(magicTransferPatientIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel78)
                                        .addComponent(magicTransferFacilityIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(magicTransferB)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout interactionsControlPanel1Layout = new javax.swing.GroupLayout(interactionsControlPanel1);
                interactionsControlPanel1.setLayout(interactionsControlPanel1Layout);
                interactionsControlPanel1Layout.setHorizontalGroup(
                        interactionsControlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(interactionsControlPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(interactionsControlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(medicalEvacuationPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                interactionsControlPanel1Layout.setVerticalGroup(
                        interactionsControlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(interactionsControlPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(medicalEvacuationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(287, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout patientInteractionsTabFrameLayout = new javax.swing.GroupLayout(patientInteractionsTabFrame.getContentPane());
                patientInteractionsTabFrame.getContentPane().setLayout(patientInteractionsTabFrameLayout);
                patientInteractionsTabFrameLayout.setHorizontalGroup(
                        patientInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientInteractionsTabFrameLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(interactionsControlPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addGap(21, 21, 21))
                );
                patientInteractionsTabFrameLayout.setVerticalGroup(
                        patientInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(patientInteractionsTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(patientInteractionsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane19)
                                        .addComponent(interactionsControlPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );

                jTabbedPane.addTab("Patient Interactions", patientInteractionsTabFrame);

                fluidsTabFrame.setVisible(true);

                fluidTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                jScrollPane13.setViewportView(fluidTable);

                jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jLabel37.setText("Patient ID");

                fluidsPatientIdTf.setPreferredSize(new java.awt.Dimension(100, 22));

                javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                jPanel15.setLayout(jPanel15Layout);
                jPanel15Layout.setHorizontalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel37)
                                .addGap(5, 5, 5)
                                .addComponent(fluidsPatientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel15Layout.setVerticalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel37))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(fluidsPatientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jLabel46.setText("Blood Loss");

                bloodLossTf.setPreferredSize(new java.awt.Dimension(100, 22));

                jLabel57.setText("mL/min");

                javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
                jPanel16.setLayout(jPanel16Layout);
                jPanel16Layout.setHorizontalGroup(
                        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel46)
                                .addGap(5, 5, 5)
                                .addComponent(bloodLossTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel16Layout.setVerticalGroup(
                        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel46))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bloodLossTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel57)))
                );

                jLabel47.setText("Blood Volume");

                bloodVolumeTf.setPreferredSize(new java.awt.Dimension(100, 22));

                jLabel58.setText("mL");

                javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
                jPanel17.setLayout(jPanel17Layout);
                jPanel17Layout.setHorizontalGroup(
                        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloodVolumeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel17Layout.setVerticalGroup(
                        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel47)
                                        .addComponent(bloodVolumeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel58))
                                .addGap(3, 3, 3))
                );

                jLabel48.setText("Sweat Rate");

                sweatRateTf.setToolTipText("");
                sweatRateTf.setPreferredSize(new java.awt.Dimension(100, 22));

                jLabel59.setText("mL/min");

                javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
                jPanel18.setLayout(jPanel18Layout);
                jPanel18Layout.setHorizontalGroup(
                        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel48)
                                .addGap(5, 5, 5)
                                .addComponent(sweatRateTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel59)
                                .addContainerGap())
                );
                jPanel18Layout.setVerticalGroup(
                        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel48))
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sweatRateTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel59))))
                                .addContainerGap(8, Short.MAX_VALUE))
                );

                jLabel49.setText("Urine Output");

                urineOutputTf.setPreferredSize(new java.awt.Dimension(100, 22));

                jLabel60.setText("mL/min");

                javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
                jPanel19.setLayout(jPanel19Layout);
                jPanel19Layout.setHorizontalGroup(
                        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel49)
                                .addGap(5, 5, 5)
                                .addComponent(urineOutputTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addContainerGap(70, Short.MAX_VALUE))
                );
                jPanel19Layout.setVerticalGroup(
                        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel49))
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(urineOutputTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                );

                createFluidButton.setText("Create Fluid");
                createFluidButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                createFluidButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
                jPanel14.setLayout(jPanel14Layout);
                jPanel14Layout.setHorizontalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createFluidButton)))
                                .addContainerGap())
                );
                jPanel14Layout.setVerticalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createFluidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                );

                jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel36.setText("Create Body Fluids");

                javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
                jPanel26.setLayout(jPanel26Layout);
                jPanel26Layout.setHorizontalGroup(
                        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
                );
                jPanel26Layout.setVerticalGroup(
                        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                );

                jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                updateFluidButton.setText("Update Fluid");
                updateFluidButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateFluidButtonActionPerformed(evt);
                        }
                });

                jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                jLabel61.setText("Update Body Fluids");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(updateFluidButton)
                                        .addComponent(jLabel61))
                                .addGap(0, 30, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(41, 41, 41)
                                .addComponent(updateFluidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
                jPanel25.setLayout(jPanel25Layout);
                jPanel25Layout.setHorizontalGroup(
                        jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel25Layout.setVerticalGroup(
                        jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout fluidsTabFrameLayout = new javax.swing.GroupLayout(fluidsTabFrame.getContentPane());
                fluidsTabFrame.getContentPane().setLayout(fluidsTabFrameLayout);
                fluidsTabFrameLayout.setHorizontalGroup(
                        fluidsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fluidsTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(fluidsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane13)
                                        .addGroup(fluidsTabFrameLayout.createSequentialGroup()
                                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                fluidsTabFrameLayout.setVerticalGroup(
                        fluidsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fluidsTabFrameLayout.createSequentialGroup()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Fluids", fluidsTabFrame);

                neuroTabFrame.setPreferredSize(new java.awt.Dimension(850, 760));
                neuroTabFrame.setVisible(true);

                neuroLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
                neuroLabel.setText("Neurological Scales");

                neuroTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                jScrollPane14.setViewportView(neuroTable);

                jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                scaleTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                scaleTitleLabel.setText("New Neuro Scales");

                jLabel62.setText("Patient ID:");

                neuroPatientIdTf.setMinimumSize(new java.awt.Dimension(150, 22));
                neuroPatientIdTf.setPreferredSize(new java.awt.Dimension(150, 22));

                jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Glasgow Scale"));

                jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jLabel63.setText("Eyes:");
                jPanel29.add(jLabel63);

                eyesTf.setMinimumSize(new java.awt.Dimension(80, 22));
                eyesTf.setName(""); // NOI18N
                eyesTf.setPreferredSize(new java.awt.Dimension(80, 22));
                jPanel29.add(eyesTf);

                jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jLabel64.setText("Verbal:");
                jPanel30.add(jLabel64);

                verbalTf.setMinimumSize(new java.awt.Dimension(80, 22));
                verbalTf.setPreferredSize(new java.awt.Dimension(80, 22));
                jPanel30.add(verbalTf);

                jPanel31.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jLabel65.setText("Motor:");
                jPanel31.add(jLabel65);

                motorTf.setMinimumSize(new java.awt.Dimension(80, 22));
                motorTf.setPreferredSize(new java.awt.Dimension(80, 22));
                jPanel31.add(motorTf);

                javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
                jPanel28.setLayout(jPanel28Layout);
                jPanel28Layout.setHorizontalGroup(
                        jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel28Layout.setVerticalGroup(
                        jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                                .addContainerGap())
                );

                addNeuroScalesButton.setText("Add Neuro Scales");
                addNeuroScalesButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addNeuroScalesButtonActionPerformed(evt);
                        }
                });

                jLabel67.setText("Level of Consciousness:");

                locCb.setMinimumSize(new java.awt.Dimension(120, 22));
                locCb.setPreferredSize(new java.awt.Dimension(120, 22));

                jLabel66.setText("Level of Response:");

                lorCb.setMinimumSize(new java.awt.Dimension(100, 22));
                lorCb.setPreferredSize(new java.awt.Dimension(100, 22));

                javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
                jPanel27.setLayout(jPanel27Layout);
                jPanel27Layout.setHorizontalGroup(
                        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel67)
                                                .addGroup(jPanel27Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel27Layout.createSequentialGroup()
                                                                        .addComponent(jLabel62)
                                                                        .addGap(5, 5, 5)
                                                                        .addComponent(neuroPatientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jLabel66))))
                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(locCb, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lorCb, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(scaleTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addNeuroScalesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
                );
                jPanel27Layout.setVerticalGroup(
                        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                                                .addComponent(scaleTitleLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                                                                .addGap(2, 2, 2)
                                                                                .addComponent(jLabel62))
                                                                        .addComponent(neuroPatientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel66)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jLabel67)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(locCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(addNeuroScalesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                updateNeuroButton.setText("Update Neuro");
                updateNeuroButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateNeuroButtonActionPerformed(evt);
                        }
                });

                jLabel68.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                jLabel68.setText("Update Neuro Scales");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel68)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateNeuroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel68)
                                .addGap(41, 41, 41)
                                .addComponent(updateNeuroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
                jPanel21.setLayout(jPanel21Layout);
                jPanel21Layout.setHorizontalGroup(
                        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel21Layout.setVerticalGroup(
                        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout neuroTabFrameLayout = new javax.swing.GroupLayout(neuroTabFrame.getContentPane());
                neuroTabFrame.getContentPane().setLayout(neuroTabFrameLayout);
                neuroTabFrameLayout.setHorizontalGroup(
                        neuroTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(neuroTabFrameLayout.createSequentialGroup()
                                .addComponent(neuroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(neuroTabFrameLayout.createSequentialGroup()
                                .addGroup(neuroTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane14))
                                .addContainerGap())
                );
                neuroTabFrameLayout.setVerticalGroup(
                        neuroTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(neuroTabFrameLayout.createSequentialGroup()
                                .addComponent(neuroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane.addTab("Neuro", neuroTabFrame);

                labsTabFrame.setVisible(true);

                jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel9.setText("Labs");

                jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                addLabButton.setText("Add Lab");
                addLabButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addLabButtonActionPerformed(evt);
                        }
                });
                jPanel3.add(addLabButton);

                labTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                labTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                labTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                labTableMouseClicked(evt);
                        }
                });
                jScrollPane15.setViewportView(labTable);

                javax.swing.GroupLayout labsTabFrameLayout = new javax.swing.GroupLayout(labsTabFrame.getContentPane());
                labsTabFrame.getContentPane().setLayout(labsTabFrameLayout);
                labsTabFrameLayout.setHorizontalGroup(
                        labsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                labsTabFrameLayout.setVerticalGroup(
                        labsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(labsTabFrameLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                jTabbedPane.addTab("Labs", labsTabFrame);

                injuriesTabFrame.setVisible(true);

                jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
                jLabel10.setText("Injuries");

                javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
                injuryTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
                injuryTree.setPreferredSize(new java.awt.Dimension(500, 78));
                injuryTree.setRequestFocusEnabled(false);
                jScrollPane17.setViewportView(injuryTree);

                jPanel4.setPreferredSize(new java.awt.Dimension(215, 33));
                jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                addInjuryButton.setText("Add Injury");
                addInjuryButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addInjuryButtonActionPerformed(evt);
                        }
                });
                jPanel4.add(addInjuryButton);

                javax.swing.GroupLayout injuriesTabFrameLayout = new javax.swing.GroupLayout(injuriesTabFrame.getContentPane());
                injuriesTabFrame.getContentPane().setLayout(injuriesTabFrameLayout);
                injuriesTabFrameLayout.setHorizontalGroup(
                        injuriesTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(injuriesTabFrameLayout.createSequentialGroup()
                                .addGroup(injuriesTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(injuriesTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane17)
                                .addContainerGap())
                );
                injuriesTabFrameLayout.setVerticalGroup(
                        injuriesTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(injuriesTabFrameLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jTabbedPane.addTab("Injuries", injuriesTabFrame);

                consoleTabFrame.setVisible(true);

                outputTextArea.setColumns(20);
                outputTextArea.setRows(5);
                jScrollPane18.setViewportView(outputTextArea);

                consoleTabFrame.getContentPane().add(jScrollPane18, java.awt.BorderLayout.CENTER);

                inputTextField.setMinimumSize(new java.awt.Dimension(400, 25));
                inputTextField.setName(""); // NOI18N
                inputTextField.setOpaque(true);
                inputTextField.setPreferredSize(new java.awt.Dimension(400, 25));
                consoleInputPanel.add(inputTextField);

                sendButton.setText("send");
                sendButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                sendButtonActionPerformed(evt);
                        }
                });
                consoleInputPanel.add(sendButton);

                consoleTabFrame.getContentPane().add(consoleInputPanel, java.awt.BorderLayout.SOUTH);

                jTabbedPane.addTab("Console", consoleTabFrame);

                dataLogsTabFrame.setVisible(true);

                jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("DataLogs");

                jScrollPane9.setViewportView(logList);

                newLogButton.setText("New Log");
                newLogButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newLogButtonActionPerformed(evt);
                        }
                });

                selectLogButton.setText("Select Log");
                selectLogButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                selectLogButtonActionPerformed(evt);
                        }
                });

                logTextArea.setColumns(20);
                logTextArea.setRows(5);
                jScrollPane10.setViewportView(logTextArea);

                javax.swing.GroupLayout dataLogPanelLayout = new javax.swing.GroupLayout(dataLogPanel);
                dataLogPanel.setLayout(dataLogPanelLayout);
                dataLogPanelLayout.setHorizontalGroup(
                        dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataLogPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(dataLogPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(selectLogButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                dataLogPanelLayout.setVerticalGroup(
                        dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataLogPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(dataLogPanelLayout.createSequentialGroup()
                                                .addComponent(newLogButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectLogButton)
                                                .addGap(20, 20, 20))
                                        .addGroup(dataLogPanelLayout.createSequentialGroup()
                                                .addGroup(dataLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
                );

                javax.swing.GroupLayout dataLogsTabFrameLayout = new javax.swing.GroupLayout(dataLogsTabFrame.getContentPane());
                dataLogsTabFrame.getContentPane().setLayout(dataLogsTabFrameLayout);
                dataLogsTabFrameLayout.setHorizontalGroup(
                        dataLogsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 902, Short.MAX_VALUE)
                        .addGroup(dataLogsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dataLogsTabFrameLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(dataLogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
                );
                dataLogsTabFrameLayout.setVerticalGroup(
                        dataLogsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 776, Short.MAX_VALUE)
                        .addGroup(dataLogsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dataLogsTabFrameLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(dataLogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(626, Short.MAX_VALUE)))
                );

                jTabbedPane.addTab("DataLogs", dataLogsTabFrame);

                documentsTabFrame.setName(""); // NOI18N
                documentsTabFrame.setVisible(true);

                documentsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Documents"));

                newDocButton.setText("New Document");
                newDocButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newDocButtonActionPerformed(evt);
                        }
                });

                documentTextArea.setColumns(20);
                documentTextArea.setRows(5);
                jScrollPane11.setViewportView(documentTextArea);

                javax.swing.GroupLayout documentsPanelLayout = new javax.swing.GroupLayout(documentsPanel);
                documentsPanel.setLayout(documentsPanelLayout);
                documentsPanelLayout.setHorizontalGroup(
                        documentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(documentsPanelLayout.createSequentialGroup()
                                .addComponent(newDocButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                documentsPanelLayout.setVerticalGroup(
                        documentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(documentsPanelLayout.createSequentialGroup()
                                .addGroup(documentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newDocButton))
                                .addGap(0, 389, Short.MAX_VALUE))
                );

                jLabel35.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
                jLabel35.setText("Documents");

                javax.swing.GroupLayout documentsTabFrameLayout = new javax.swing.GroupLayout(documentsTabFrame.getContentPane());
                documentsTabFrame.getContentPane().setLayout(documentsTabFrameLayout);
                documentsTabFrameLayout.setHorizontalGroup(
                        documentsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(documentsTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(documentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(documentsTabFrameLayout.createSequentialGroup()
                                .addGap(381, 381, 381)
                                .addComponent(jLabel35)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                documentsTabFrameLayout.setVerticalGroup(
                        documentsTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(documentsTabFrameLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel35)
                                .addGap(29, 29, 29)
                                .addComponent(documentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(180, 180, 180))
                );

                jTabbedPane.addTab("Docs", documentsTabFrame);

                tcccTabFrame.setVisible(true);

                newButton.setText("New TCCC");
                newButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newButtonActionPerformed(evt);
                        }
                });

                jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder("TCCC Details"));

                tcccTextArea.setColumns(20);
                tcccTextArea.setRows(5);
                jScrollPane6.setViewportView(tcccTextArea);

                jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Select TCCC"));

                tcccList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tcccList.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tcccListMouseClicked(evt);
                        }
                });
                jScrollPane5.setViewportView(tcccList);

                javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
                jPanel32.setLayout(jPanel32Layout);
                jPanel32Layout.setHorizontalGroup(
                        jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel32Layout.setVerticalGroup(
                        jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout tcccTabFrameLayout = new javax.swing.GroupLayout(tcccTabFrame.getContentPane());
                tcccTabFrame.getContentPane().setLayout(tcccTabFrameLayout);
                tcccTabFrameLayout.setHorizontalGroup(
                        tcccTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tcccTabFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(tcccTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6)
                                        .addGroup(tcccTabFrameLayout.createSequentialGroup()
                                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 508, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                tcccTabFrameLayout.setVerticalGroup(
                        tcccTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tcccTabFrameLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tcccTabFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tcccTabFrameLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(newButton)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(tcccTabFrameLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
                );

                jTabbedPane.addTab("TCCC", tcccTabFrame);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
	    this.uiCommandHandler.createTccc();
    }//GEN-LAST:event_newButtonActionPerformed

    private void pausePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausePatientButtonActionPerformed
	    this.patientActionPatientIdLabel.setForeground(Color.BLACK);
	    this.atTimeLabel.setForeground(Color.BLACK);
	    String patientId = this.patientControlPatientIdTextField.getText();

	    boolean ready = true;
	    if ((patientId == null) || (patientId.length() < 1)) {
		    this.patientActionPatientIdLabel.setForeground(Color.RED);
		    ready = false;
	    }
	    long atTime = 0;

	    if (ready)
		    this.uiCommandHandler.sendPausePatient(atTime, patientId);
    }//GEN-LAST:event_pausePatientButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
	    this.saveLabel.setForeground(Color.BLACK);
	    String label = this.saveTextField.getText();
	    if ((label == null) || (label.length() < 1)) {
		    this.saveLabel.setForeground(Color.RED);
	    } else {
		    this.uiCommandHandler.sendSave(label);
	    }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPatientButtonActionPerformed
	    this.patientActionPatientIdLabel.setForeground(Color.BLACK);
	    String patientId = this.patientControlPatientIdTextField.getText();
	    if ((patientId == null) || (patientId.length() < 1)) {
		    this.patientActionPatientIdLabel.setForeground(Color.RED);
	    } else {
		    this.uiCommandHandler.sendLoadPatient(patientId);
	    }
    }//GEN-LAST:event_loadPatientButtonActionPerformed

    private void startPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPatientButtonActionPerformed
	    this.patientActionPatientIdLabel.setForeground(Color.BLACK);
	    this.atTimeLabel.setForeground(Color.BLACK);
	    String patientId = this.patientControlPatientIdTextField.getText();

	    boolean ready = true;
	    if ((patientId == null) || (patientId.length() < 1)) {
		    this.patientActionPatientIdLabel.setForeground(Color.RED);
		    ready = false;
	    }
	    long atTime = 0;

	    if (ready)
		    this.uiCommandHandler.sendStartPatient(atTime, patientId);
    }//GEN-LAST:event_startPatientButtonActionPerformed

    private void stopPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopPatientButtonActionPerformed
	    this.patientActionPatientIdLabel.setForeground(Color.BLACK);
	    this.atTimeLabel.setForeground(Color.BLACK);
	    String patientId = this.patientControlPatientIdTextField.getText();

	    boolean ready = true;
	    if ((patientId == null) || (patientId.length() < 1)) {
		    this.patientActionPatientIdLabel.setForeground(Color.RED);
		    ready = false;
	    }
	    long atTime = 0;

	    if (ready)
		    this.uiCommandHandler.sendStopPatient(atTime, patientId);
    }//GEN-LAST:event_stopPatientButtonActionPerformed

    private void resumePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumePatientButtonActionPerformed
	    this.patientActionPatientIdLabel.setForeground(Color.BLACK);
	    this.atTimeLabel.setForeground(Color.BLACK);
	    String patientId = this.patientControlPatientIdTextField.getText();

	    boolean ready = true;
	    if ((patientId == null) || (patientId.length() < 1)) {
		    this.patientActionPatientIdLabel.setForeground(Color.RED);
		    ready = false;
	    }
	    long atTime = 0;

	    if (ready) {
		    this.uiCommandHandler.sendResumePatient(atTime, patientId);
	    }

    }//GEN-LAST:event_resumePatientButtonActionPerformed

    private void newDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDocButtonActionPerformed
	    new NewDocumentDialog(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_newDocButtonActionPerformed

    private void selectLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLogButtonActionPerformed
	    String selected = this.logList.getSelectedValue();
	    if (selected != null) {
		    this.uiCommandHandler.selectDataLog(selected);
	    }
    }//GEN-LAST:event_selectLogButtonActionPerformed

    private void newLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLogButtonActionPerformed
	    NewDataLogDialog newDataLogDialog = new NewDataLogDialog(this, true);
	    newDataLogDialog.setVisible(true);
    }//GEN-LAST:event_newLogButtonActionPerformed

    private void resignFedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resignFedButtonActionPerformed
	    this.uiCommandHandler.resignFederation();
    }//GEN-LAST:event_resignFedButtonActionPerformed

    private void joinFedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinFedButtonActionPerformed
	    this.uiCommandHandler.joinFederation();
    }//GEN-LAST:event_joinFedButtonActionPerformed

    private void selectScenarioJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectScenarioJButtonActionPerformed
	    this.scenarioNameLabel.setForeground(Color.BLACK);
	    String name = this.scenarioNameTextField.getText();
	    if ((name == null) || (name.length() < 1)) {
		    this.scenarioNameLabel.setForeground(Color.RED);
	    } else {
		    this.uiCommandHandler.sendSelectScenario(name);
	    }
    }//GEN-LAST:event_selectScenarioJButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
	    this.uiCommandHandler.sendResume();
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
	    this.uiCommandHandler.sendPause();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
	    this.uiCommandHandler.sendStop();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
	    this.uiCommandHandler.sendStart();
    }//GEN-LAST:event_startButtonActionPerformed

    private void iStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStartButtonActionPerformed
	    this.uiCommandHandler.instructionalStart(facilityIdTextField.getText());
    }//GEN-LAST:event_iStartButtonActionPerformed

    private void iStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStopButtonActionPerformed
	    this.uiCommandHandler.instructionalStop(facilityIdTextField.getText());
    }//GEN-LAST:event_iStopButtonActionPerformed

    private void iPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPauseButtonActionPerformed
	    this.uiCommandHandler.instructionalPause(facilityIdTextField.getText());
	    // TODO add your handling code here:
    }//GEN-LAST:event_iPauseButtonActionPerformed

    private void selectCreatePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCreatePatientButtonActionPerformed
	    CreatePatient patient = this.uiCommandHandler.getCreatePatient(this.createPatientList.getSelectedValue());
	    if (patient != null) {
		    CreatePatientDialog patientDialog = new CreatePatientDialog(this, true);
		    patientDialog.setCreatePatient(patient);
		    patientDialog.setVisible(true);
	    }
    }//GEN-LAST:event_selectCreatePatientButtonActionPerformed

    private void newCreatePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCreatePatientButtonActionPerformed

	    CreatePatientDialog patientDialog = new CreatePatientDialog(this, true);
	    patientDialog.setVisible(true);
	    CreatePatient createPatient = patientDialog.getCreatePatient();
	    if (createPatient != null) {
		    this.uiCommandHandler.createCreatePatient(createPatient);
	    }
    }//GEN-LAST:event_newCreatePatientButtonActionPerformed

    private void updatePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePatientButtonActionPerformed
	    new PatientUpdaterDialog(this, true).setVisible(true);
    }//GEN-LAST:event_updatePatientButtonActionPerformed

    private void newTreatmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTreatmentButtonActionPerformed
	    NewTreatmentDialog treatmentDialog = new NewTreatmentDialog(this, true);
	    treatmentDialog.getPatientIdLabel().setText(this.patientList.getSelectedValue());
	    treatmentDialog.setVisible(true);
    }//GEN-LAST:event_newTreatmentButtonActionPerformed

    private void newPatientButtionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientButtionActionPerformed
	    new NewRespiratoryPatientDialog(this, true).setVisible(true);
    }//GEN-LAST:event_newPatientButtionActionPerformed

    private void iResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResumeButtonActionPerformed
	    this.uiCommandHandler.instructionalResume(facilityIdTextField.getText());
	    // TODO add your handling code here:
    }//GEN-LAST:event_iResumeButtonActionPerformed

    private void updateFluidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFluidButtonActionPerformed
	    BodyFluidsUpdaterDialog updaterDialog = new BodyFluidsUpdaterDialog(this, true);
	    BodyFluidsData bodyFluidsData = (BodyFluidsData) this.getBodyFluidsTable().getModel();
	    updaterDialog.setInstanceCombo(bodyFluidsData.getComboBoxItemList());
	    updaterDialog.setVisible(true);
    }//GEN-LAST:event_updateFluidButtonActionPerformed

    private void updateNeuroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNeuroButtonActionPerformed
	    int selectedRow = this.neuroTable.getSelectedRow();
	    if (selectedRow >= 0) {
		    NeuroScalesData neuroScalesData = (NeuroScalesData) this.neuroTable.getModel();
		    HlaNeurologicalScales hlaObj = neuroScalesData.getHlaObject(selectedRow);
		    String instanceName = hlaObj.getHlaInstanceName();
		    String patientId = null;
		    if (hlaObj.hasPatientId()) {
			    patientId = hlaObj.getPatientId();
		    }
		    Integer eyesInt = null, verbalInt = null, motorInt = null;
		    if (hlaObj.hasGlasgowComaScale()) {
			    GlasgowComaScaleRecord gScale = hlaObj.getGlasgowComaScale();
			    eyesInt = gScale.getEyes();
			    verbalInt = gScale.getVerbal();
			    motorInt = gScale.getMotor();
		    }
		    String lorString = null, locString = null;
		    if (hlaObj.hasLevelOfResponse()) {
			    lorString = hlaObj.getLevelOfResponse().toString();
		    }
		    if (hlaObj.hasLevelOfConsciousness()) {
			    locString = hlaObj.getLevelOfConsciousness().toString();
		    }
		    if (hlaObj.isLocal()) {
			    new NewUpdateNeuroScalesDialog(this, true, instanceName, patientId,
				    eyesInt, verbalInt, motorInt, lorString, locString).setVisible(true);
		    } else {
			    JOptionPane.showMessageDialog(this,
				    "Only local objects can be updated", "WARNING",
				    JOptionPane.WARNING_MESSAGE);
		    }
	    }

    }//GEN-LAST:event_updateNeuroButtonActionPerformed

    private void addLabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLabButtonActionPerformed
	    new NewLabDialog(this, true).setVisible(true);
    }//GEN-LAST:event_addLabButtonActionPerformed

    private void addInjuryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInjuryButtonActionPerformed
	    new NewInjuryDialog(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_addInjuryButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
	    String result = ConsoleManager.getManaager().execute(inputTextField.getText());
	    outputTextArea.setText(result);        // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed

    private void changeStateConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStateConfirmButtonActionPerformed
	    UiCommandHandler.getUiCommandHandler().updateFederationState((String) this.fedStateComboBox.getSelectedItem());
    }//GEN-LAST:event_changeStateConfirmButtonActionPerformed

    private void timeUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeUpdateButtonActionPerformed
	    this.timeRatioLabel.setForeground(Color.black);
	    boolean validated = true;

	    this.isTimeOwner = this.publishTimeCb.isSelected();

	    try {
		    this.timeRatio = Integer.parseInt(timeRatioTextField.getText());
	    } catch (Exception e) {
		    validated = false;
		    this.timeRatioLabel.setForeground(Color.red);
	    }

	    if (this.timeRatio < 1) {
		    validated = false;
		    this.timeRatioLabel.setForeground(Color.red);
	    }

	    if (validated) {
		    this.timeRatioChanged = true;
		    this.publishTimeCb.setSelected(true);
		    this.uiCommandHandler.updateTimeSim(timeRatio, isTimeOwner);
	    }
    }//GEN-LAST:event_timeUpdateButtonActionPerformed

    private void timeRatioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRatioTextFieldActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_timeRatioTextFieldActionPerformed

    private void publishTimeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishTimeCbActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_publishTimeCbActionPerformed

    private void patientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientListMouseClicked
	    this.newTreatmentButton.setEnabled(true);
	    this.uiCommandHandler.selectPatient(this.patientList.getSelectedValue());
    }//GEN-LAST:event_patientListMouseClicked

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientButtonActionPerformed
	    String id = this.patientIDTF.getText();
	    Patient newPatient = new Patient();
	    this.patientIDLabel.setForeground(Color.black);

	    if ((id == null) || (id.length() < 1)) {
		    this.patientIDLabel.setForeground(Color.red);
	    } else {
		    newPatient.setId(id);
		    newPatient.setHeartRate(toIntegerOrNull(this.heartRateTF.getText()));
		    newPatient.setLungDeadSpace(toIntegerOrNull(this.deadSpaceTextField.getText()));
		    newPatient.setLungExpiratoryReserve(toIntegerOrNull(this.expReserveTextField.getText()));
		    newPatient.setLungInspiratoryReserve(toIntegerOrNull(this.insReserveTextField.getText()));
		    newPatient.setLungResidualVolume(toIntegerOrNull(this.residualVolumeTextField.getText()));
		    newPatient.setLungTidalVolume(toIntegerOrNull(this.tidalVolumenTextField.getText()));
		    newPatient.setLungTotalCapacity(toIntegerOrNull(this.totalCapacityTextField.getText()));
		    newPatient.setOxygenSaturation(toFloatOrNull(this.o2SaturationTextField.getText()));
		    newPatient.setRespirationETco2(toFloatOrNull(this.etco2TextField.getText()));
		    newPatient.setRespirationRate(toFloatOrNull(this.respRateTextField.getText()));
		    newPatient.setSystolicBloodPressure(toIntegerOrNull(this.systolicBPTextField.getText()));
		    newPatient.setDiastolicBloodPressure(toIntegerOrNull(this.diastolicBPTextField.getText()));
		    newPatient.setTemperatureFahrenheit(toFloatOrNull(this.tempTextField.getText()));

		    UiCommandHandler.getUiCommandHandler().createPatient(newPatient);

		    this.patientIDTF.setText("");
		    this.heartRateTF.setText("");
		    this.systolicBPTextField.setText("");
		    this.diastolicBPTextField.setText("");
		    this.o2SaturationTextField.setText("");
		    this.tempTextField.setText("");
		    this.etco2TextField.setText("");
		    this.respRateTextField.setText("");
	    }
    }//GEN-LAST:event_addPatientButtonActionPerformed

    private void etco2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etco2TextFieldActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_etco2TextFieldActionPerformed

    private void patientIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientIDTFActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_patientIDTFActionPerformed

    private void systolicBPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systolicBPTextFieldActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_systolicBPTextFieldActionPerformed

    private void autoFillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoFillButtonActionPerformed
	    this.heartRateTF.setText("75");
	    this.systolicBPTextField.setText("120");
	    this.diastolicBPTextField.setText("80");
	    this.o2SaturationTextField.setText("99");
	    this.tempTextField.setText("98.6");
	    this.etco2TextField.setText("35");
	    this.respRateTextField.setText("12");
    }//GEN-LAST:event_autoFillButtonActionPerformed

    private void createLungPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLungPatientButtonActionPerformed
	    new NewRespiratoryPatientDialog(this, true).setVisible(true);
    }//GEN-LAST:event_createLungPatientButtonActionPerformed

    private void vitalsUpdaterStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalsUpdaterStartButtonActionPerformed
	    Object interval = null;
	    int duration = 0;
	    boolean ready = true;

	    PatientChangeAttributes attEnum = PatientChangeAttributes.fromListName(this.attributeComboBox.getSelectedItem().toString());

	    try {
		    interval = attEnum.parseData(this.intervalTextField.getText());
	    } catch (Exception e) {
		    this.intervalTextField.setForeground(Color.red);
		    ready = false;
	    }

	    try {
		    duration = Integer.parseInt(this.durationTextField.getText());
	    } catch (Exception e) {
		    this.durationTextField.setForeground(Color.red);
		    ready = false;
	    }

	    if (ready) {
		    UiCommandHandler.getUiCommandHandler().modifyUpdater(true, attEnum, interval, duration);
		    this.intervalTextField.setText("");
		    this.durationTextField.setText("");
	    }

    }//GEN-LAST:event_vitalsUpdaterStartButtonActionPerformed

    private void durationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationTextFieldActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_durationTextFieldActionPerformed

    private void vitalsUpdaterStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalsUpdaterStopButtonActionPerformed
	    PatientChangeAttributes attEnum = PatientChangeAttributes.fromListName(this.attributeComboBox.getSelectedItem().toString());
	    UiCommandHandler.getUiCommandHandler().modifyUpdater(false, attEnum, null, 0);
    }//GEN-LAST:event_vitalsUpdaterStopButtonActionPerformed

    private void createEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventButtonActionPerformed
	    String notes = this.notesTextArea.getText();
	    this.notesLabel.setForeground(Color.black);

	    if (nullOrEmpty(notes)) {
		    this.notesLabel.setForeground(Color.red);
	    } else {
		    Event event = new Event();
		    String eventTypeSelection = this.typeComboBox.getSelectedItem().toString();
		    event.setNotes(notes);
		    event.setType(EventType.valueOf(revertTitleToEnumString(eventTypeSelection)));
		    event.setLearnerActionEnum(LearnerActionEnum.valueOf(revertTitleToEnumString(this.learnerActionCB.getSelectedItem().toString())));
		    if (!nullOrEmpty(this.sourceTextField.getText())) {
			    event.setSource(this.sourceTextField.getText());
		    }
		    if (!nullOrEmpty(this.pidTextField.getText())) {
			    event.setPatientId(this.pidTextField.getText());
		    }
		    if (!nullOrEmpty(this.iidTextField.getText())) {
			    event.setInstructorId(this.iidTextField.getText());
		    }
		    if (!nullOrEmpty(this.lidTextField.getText())) {
			    event.setLearnerId(this.lidTextField.getText());
		    }
		    if (!nullOrEmpty(this.tidTextField.getText())) {
			    event.setTeamId(this.tidTextField.getText());
		    }
		    if (!nullOrEmpty(this.desTextArea.getText())) {
			    event.setDescription(this.desTextArea.getText());
		    }
		    if (!nullOrEmpty(this.facilityTextField.getText())) {
			    event.setFacilityId(this.facilityTextField.getText());
		    }

		    UiCommandHandler.getUiCommandHandler().createEvent(event);

		    clearCreateEventForm();
	    }
    }//GEN-LAST:event_createEventButtonActionPerformed

	private boolean nullOrEmpty(String value) {
		if (value == null) {
			return true;
		} else if (value.length() < 1) {
			return true;
		}
		return false;
	}

	private void initializeEventComboBoxes() {
		List<String> eventTypeList = new ArrayList<>();
		for (EventType eventEnum : EventType.values()) {
			eventTypeList.add(eventEnum.getName());
		}
		sortList(eventTypeList);

		this.typeComboBox.setModel(new DefaultComboBoxModel<>(eventTypeList.toArray(String[]::new)));

		List<String> learnerActionList = new ArrayList<>();
		for (LearnerActionEnum actionEnum : LearnerActionEnum.values()) {
			String titleEnum = convertEnumToTitle(actionEnum.getName());
			learnerActionList.add(titleEnum);
		}
		sortList(learnerActionList);

		this.learnerActionCB.setModel(new DefaultComboBoxModel<>(learnerActionList.toArray(String[]::new)));

	}

	private void sortList(List list) {
		Collections.sort(list);
		int naIndex = list.indexOf("Not Applicable");
		if (naIndex != -1) {
			list.remove(naIndex);
			list.add(0, "Not Applicable");
		}
	}

	private void clearCreateEventForm() {
		this.sourceTextField.setText("");
		this.pidTextField.setText("");
		this.iidTextField.setText("");
		this.lidTextField.setText("");
		this.tidTextField.setText("");
		this.desTextArea.setText("");
		this.facilityTextField.setText("");
	}

	private String revertTitleToEnumString(String title) {
		return title.toUpperCase().replaceAll(" ", "_");
	}

	private String convertEnumToTitle(String string) {
		String splitEnum = string.replaceAll(
			String.format("%s|%s|%s",
				"(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"
			),
			" "
		);
		return splitEnum.substring(0, 1).toUpperCase()
			+ splitEnum.substring(1);
	}


    private void facilityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityTextFieldActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_facilityTextFieldActionPerformed

    private void bookmarkListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookmarkListMouseClicked
	    if (this.bookmarkList.getSelectedValue() != null) {
		    this.uiCommandHandler.selectEvent(this.bookmarkList.getSelectedValue());
	    }

    }//GEN-LAST:event_bookmarkListMouseClicked

    private void createFluidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFluidButtonActionPerformed
	    UiCommandHandler.getUiCommandHandler().
		    createBodyFluids(this.fluidsPatientIdTf.getText(),
			    parseFloatOrNull(this.bloodLossTf.getText()),
			    parseFloatOrNull(this.bloodVolumeTf.getText()),
			    parseFloatOrNull(this.sweatRateTf.getText()),
			    parseFloatOrNull(this.urineOutputTf.getText()));

	    clearBodyFluidForm();
    }//GEN-LAST:event_createFluidButtonActionPerformed

	private void clearBodyFluidForm() {
		this.fluidsPatientIdTf.setText("");
		this.bloodLossTf.setText("");
		this.bloodVolumeTf.setText("");
		this.sweatRateTf.setText("");
		this.urineOutputTf.setText("");
	}

	private Float parseFloatOrNull(String floatString) {
		if (floatString == null) {
			return null;
		}
		try {
			return Float.parseFloat(floatString);
		} catch (Exception e) {
			return null;
		}
	}

    private void startButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButton1ActionPerformed
	    this.incrementTf.setBackground(Color.WHITE);
	    this.durationTf.setBackground(Color.WHITE);

	    float increment = 0;
	    int duration = 0;
	    try {
		    increment = Float.parseFloat(this.incrementTf.getText());
	    } catch (Exception e) {
		    this.incrementTf.setBackground(Color.red);
	    }
	    try {
		    duration = Integer.parseInt(this.durationTf.getText());
	    } catch (Exception e) {
		    this.durationTf.setBackground(Color.red);
	    }
	    if ((increment != 0) && (duration != 0)) {
		    UiCommandHandler.getUiCommandHandler().modifyBodyFluidsUpdater(
			    this.objectsCb.getSelectedItem().toString().split(":")[0],
			    true, this.fluidAttributeCb.getSelectedItem().toString(),
			    increment, duration);
	    }
    }//GEN-LAST:event_startButton1ActionPerformed

    private void stopButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButton1ActionPerformed
	    UiCommandHandler.getUiCommandHandler().modifyBodyFluidsUpdater(
		    this.objectsCb.getSelectedItem().toString().split(":")[0],
		    false, this.fluidAttributeCb.getSelectedItem().toString(),
		    null, null);
    }//GEN-LAST:event_stopButton1ActionPerformed

	private void initiFluidAttributeCb() {
		this.fluidAttributeCb.addItem("Blood Loss");
		this.fluidAttributeCb.addItem("Blood Volume");
		this.fluidAttributeCb.addItem("Sweat Rate");
		this.fluidAttributeCb.addItem("Urine Output");
	}

    private void fluidAttributeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fluidAttributeCbActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_fluidAttributeCbActionPerformed

    private void addNeuroScalesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNeuroScalesButtonActionPerformed
	    boolean readyToUpdate = true;

	    Integer eyesNum = null;
	    this.eyesTf.setBackground(Color.white);
	    if ((this.eyesTf.getText() != null) && (!this.eyesTf.getText().isEmpty())) {
		    try {
			    eyesNum = Integer.parseInt(this.eyesTf.getText());
		    } catch (Exception e) {
			    this.eyesTf.setBackground(Color.red);
			    readyToUpdate = false;
		    }
	    }

	    Integer verbalNum = null;
	    this.verbalTf.setBackground(Color.white);
	    if ((this.verbalTf.getText() != null) && (!this.verbalTf.getText().isEmpty())) {
		    try {
			    verbalNum = Integer.parseInt(this.verbalTf.getText());
		    } catch (Exception e) {
			    this.verbalTf.setBackground(Color.red);
			    readyToUpdate = false;
		    }
	    }

	    Integer motorNum = null;
	    this.motorTf.setBackground(Color.white);
	    if ((this.motorTf.getText() != null) && (!this.motorTf.getText().isEmpty())) {
		    try {
			    motorNum = Integer.parseInt(this.motorTf.getText());
		    } catch (Exception e) {
			    this.motorTf.setBackground(Color.red);
			    readyToUpdate = false;
		    }
	    }

	    if (readyToUpdate) {
		    UiCommandHandler.getUiCommandHandler().createNeuroScales(
			    this.neuroPatientIdTf.getText(), eyesNum, verbalNum, motorNum,
			    revertTitleToEnumString(this.lorCb.getSelectedItem().toString()),
			    revertTitleToEnumString(this.locCb.getSelectedItem().toString()));
	    }

	    clearNeuroTextFields();
    }//GEN-LAST:event_addNeuroScalesButtonActionPerformed

    private void labTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labTableMouseClicked
	    labTable.getToolTipText();
    }//GEN-LAST:event_labTableMouseClicked

    private void tcccListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tcccListMouseClicked
	    this.uiCommandHandler.selectTccc(this.tcccList.getSelectedValue());
    }//GEN-LAST:event_tcccListMouseClicked

    private void uploadCsvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadCsvBtnActionPerformed
    JFileChooser replayFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    // JFileChooser replayFileChooser = new JFileChooser(new java.io.File("E:\\IVIR\\CsvFiles"));

    FileNameExtensionFilter csvFilter = new FileNameExtensionFilter(".csv Files", "csv");
    replayFileChooser.setFileFilter(csvFilter);
    replayFileChooser.setAcceptAllFileFilterUsed(false); // keep it CSV-only
    replayFileChooser.setDialogTitle("Replay Tool CSV Selector");
    replayFileChooser.setApproveButtonText("Upload File(s)");
    replayFileChooser.setMultiSelectionEnabled(true);
    replayFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    int returnValue = replayFileChooser.showOpenDialog(this);

    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File[] selectedFiles = replayFileChooser.getSelectedFiles();
        if (selectedFiles == null || selectedFiles.length == 0) {
            File single = replayFileChooser.getSelectedFile();
            selectedFiles = (single != null) ? new File[] { single } : new File[0];
        }

        @SuppressWarnings("unchecked")
        DefaultListModel<File> dLModel = (DefaultListModel<File>) this.replayFileList.getModel();
        UiCommandHandler.getUiCommandHandler().enableReplayTimer(true);

        for (File f : selectedFiles) {
            if (f == null) continue;

            // Logging
            System.out.println(f.getName());
            try {
                System.out.println(f.getCanonicalPath());
            } catch (java.io.IOException ioe) {
                System.out.println(f.getAbsolutePath());
            }

            // Validate supported FOMClass
            if (!containsSupportedClass(f.getName())) {
                new UnsupportedFileDialog(this, true).setVisible(true);
                continue; // keep processing others
            }

            // Prevent duplicates via canonical path
            boolean alreadyInList = false;
            String candidatePath;
            try {
                candidatePath = f.getCanonicalPath();
            } catch (java.io.IOException ioe) {
                candidatePath = f.getAbsolutePath();
            }

            for (int i = 0; i < dLModel.size(); i++) {
                File existing = dLModel.get(i);
                if (existing == null) continue;
                String existingPath;
                try {
                    existingPath = existing.getCanonicalPath();
                } catch (java.io.IOException ioe) {
                    existingPath = existing.getAbsolutePath();
                }
                if (candidatePath.equalsIgnoreCase(existingPath)) {
                    alreadyInList = true;
                    break;
                }
            }

            if (alreadyInList) {
                new DuplicateFileDialog(this, true).setVisible(true);
                continue;
            }

            dLModel.addElement(f);
        }

    } else if (returnValue == JFileChooser.CANCEL_OPTION) {
        System.out.println("Cancel Was Selected");
    }
}//GEN-LAST:event_uploadCsvBtnActionPerformed


	private boolean containsSupportedClass(String fileName) {
		List<String> fomClassNames = Arrays.asList(
			"PHYSIOLOGY",
			"PHYSICALTREATMENT",
			"MEDICATIONTREATMENT",
			"EVENT",
			"BLOODGASLAB",
			"BLOODLAB",
			"URINELAB",
			"BODYFLUIDS",
			"NEUROLOGICALSCALES",
			"VITALSIGNS",
			"RESPIRATORY");

		for (String fomClass : fomClassNames) {
			if (fileName.toUpperCase().contains(fomClass)) {
				return true;
			}
		}
		return false;
	}

    private void runReplayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runReplayBtnActionPerformed
//        // Send Start
	    this.uiCommandHandler.sendStart();
//        // Button Logic
	    this.replayStatusLabel.setText("Running");
	    this.pauseResumeReplayBtn.setText("Pause");
	    this.pauseResumeReplayBtn.setEnabled(true);
	    this.stopReplayBtn.setEnabled(true);
	    this.runReplayBtn.setEnabled(false);
//        

	    this.selectAllBtnActionPerformed(evt);
	    File[] csvFiles = this.replayFileList.getSelectedValuesList().toArray(new File[0]);
	    System.out.println(csvFiles.toString());
	    List replayClassLists = null;

	    if (csvFiles.length > 0) {
		    replayClassLists = convertCsvFilesToClassLists(csvFiles);
	    } else {
		    UiCommandHandler.getUiCommandHandler().enableReplayTimer(false);
		    return;
	    }

	    if (replayClassLists != null) {
		    System.out.println("Setting Replay Class Lists");
		    UiCommandHandler.getUiCommandHandler().setReplayClassLists(replayClassLists);
	    }

    }//GEN-LAST:event_runReplayBtnActionPerformed

	private List convertCsvFilesToClassLists(File[] csvFiles) {
		List<List> replayClassLists = new ArrayList<List>();

		for (File file : csvFiles) {
			String fileName = file.getName();
			if (fileName.contains("MedicationTreatment")) {
				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<MedicationTreatment> medicationTreatments = CsvProcessor.processMedicationTreatmentCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (MedicationTreatment treatment : medicationTreatments) {
						Long treatmentTime = treatment.getTreatmentTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							treatment.setTreatmentTime(convertToMs(treatmentTime, timeUnit));
						}
						treatment.buildBodyLocation();
					}

					// Adding to replayClassLists
					replayClassLists.add(medicationTreatments);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			} else if (fileName.contains("Event")) {
				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of Events
					List<Event> events = CsvProcessor.processEventCsv(file);

					//Iterating Over List
					Long previousTime = 0L;
					for (Event event : events) {
						Long eventSimTime = event.getSimTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							event.setSimTime(convertToMs(eventSimTime, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(events);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			} else if (fileName.contains("VitalSigns")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of Patient Physiologies
					List<Patient> patientVitals = CsvProcessor.processVitalSignsCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (Patient patient : patientVitals) {
						Long timestamp = patient.getTimeStamp().longValue();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							patient.setTimeStamp(convertToMs(timestamp, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(patientVitals);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			} else if (fileName.contains("PhysicalTreatment")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<PhysicalTreatment> physicalTreatments = CsvProcessor.processPhysicalTreatmentCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (PhysicalTreatment treatment : physicalTreatments) {
						Long treatmentTime = treatment.getTreatmentTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							treatment.setTreatmentTime(convertToMs(treatmentTime, timeUnit));
						}
						treatment.buildBodyLocation();
					}

					// Adding to replayClassLists
					replayClassLists.add(physicalTreatments);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (fileName.contains("BloodGasLab")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<BloodGasLab> bloodGasLabs = CsvProcessor.processBloodGasLabCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (BloodGasLab lab : bloodGasLabs) {
						Long time = lab.getTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							lab.setTime(convertToMs(time, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(bloodGasLabs);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (fileName.contains("BloodLab")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<BloodLab> bloodLabs = CsvProcessor.processBloodLabCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (BloodLab lab : bloodLabs) {
						Long time = lab.getTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							lab.setTime(convertToMs(time, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(bloodLabs);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (fileName.contains("UrineLab")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<UrineLab> urineLabs = CsvProcessor.processUrineLabCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (UrineLab lab : urineLabs) {
						Long time = lab.getTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							lab.setTime(convertToMs(time, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(urineLabs);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (fileName.contains("BodyFluids")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<BodyFluids> bodyFluidsList = CsvProcessor.processBodyFluidsCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (BodyFluids bodyFluids : bodyFluidsList) {
						Long time = bodyFluids.getTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							bodyFluids.setTime(convertToMs(time, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(bodyFluidsList);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (fileName.contains("NeurologicalScales")) {

				try {
					// TimeUnitCheck
					TimeUnitEnum timeUnit = CsvProcessor.getTimeUnit(file);
					System.out.println(file.getName() + "'s timeUnit has been assigned to: " + timeUnit.toString());

					// Creating List of MedicationTreatments
					List<NeurologicalScales> neurologicalScalesList = CsvProcessor.processNeuroScalesCsv(file);

					// Iterating Over List
					Long previousTime = 0L;
					for (NeurologicalScales neurologicalScales : neurologicalScalesList) {
						Long treatmentTime = neurologicalScales.getTime();
						if (timeUnit != TimeUnitEnum.MILLISECONDS) {
							neurologicalScales.setTime(convertToMs(treatmentTime, timeUnit));
						}
					}

					// Adding to replayClassLists
					replayClassLists.add(neurologicalScalesList);

				} catch (Exception ex) {
					Logger.getLogger(TestToolUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return replayClassLists;
	}

	private Long convertToMs(Long timestamp, TimeUnitEnum timeUnit) {
		Long timeInMs = null;
		if (timeUnit == TimeUnitEnum.SECONDS) {
			timeInMs = timestamp * 1000;
		} else if (timeUnit == TimeUnitEnum.MINUTES) {
			timeInMs = timestamp * 1000 * 60;
		} else if (timeUnit == TimeUnitEnum.HOURS) {
			timeInMs = timestamp * 1000 * 60 * 60;
		} else {
			System.out.println("Could not Convert time to ms");
		}
		return timeInMs;
	}


    private void pauseResumeReplayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseResumeReplayBtnActionPerformed
	    if (this.replayStatusLabel.getText().equalsIgnoreCase("Running")) {
		    this.uiCommandHandler.sendPause();
		    this.replayStatusLabel.setText("Paused");

		    this.pauseResumeReplayBtn.setText("Resume");

	    } else {
		    this.uiCommandHandler.sendResume();
		    this.replayStatusLabel.setText("Running");
		    this.pauseResumeReplayBtn.setText("Pause");
	    }
    }//GEN-LAST:event_pauseResumeReplayBtnActionPerformed

    private void stopReplayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopReplayBtnActionPerformed
	    this.uiCommandHandler.sendStop();
	    this.pauseResumeReplayBtn.setText("Pause/Resume");
	    this.pauseResumeReplayBtn.setEnabled(false);

	    this.replayStatusLabel.setText("Idle");
	    this.stopReplayBtn.setEnabled(false);
	    this.runReplayBtn.setEnabled(true);
	    this.replayRuntime.setText("00:00:00");

    }//GEN-LAST:event_stopReplayBtnActionPerformed

    private void selectAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllBtnActionPerformed
	    int maxIndex = this.replayFileList.getModel().getSize();
	    this.replayFileList.setSelectionInterval(0, maxIndex - 1);
    }//GEN-LAST:event_selectAllBtnActionPerformed

    private void removeSelectedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSelectedBtnActionPerformed
	    int[] selectedIndices = this.replayFileList.getSelectedIndices();
	    DefaultListModel dLModel = (DefaultListModel) this.replayFileList.getModel();

	    if (selectedIndices.length > 0) {
		    for (int i = selectedIndices.length - 1; i >= 0; i--) {
			    dLModel.removeElementAt(selectedIndices[i]);
		    }
	    }

	    this.replayFileList.clearSelection();

    }//GEN-LAST:event_removeSelectedBtnActionPerformed

    private void patientListSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientListSSMouseClicked
	    this.addSignSymptomButton.setEnabled(true);
	    this.uiCommandHandler.selectPatient(this.patientListSS.getSelectedValue());
    }//GEN-LAST:event_patientListSSMouseClicked

    private void addSignSymptomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSignSymptomButtonActionPerformed
	    NewSignsOrSymptomsDialog signSymptomDialog = new NewSignsOrSymptomsDialog(this, true);
	    signSymptomDialog.getPatientIdLabel().setText(this.patientListSS.getSelectedValue());
	    signSymptomDialog.setVisible(true);
    }//GEN-LAST:event_addSignSymptomButtonActionPerformed

        private void requestEvacButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestEvacButton1ActionPerformed
		this.evacPatientIdLabel1.setForeground(Color.black);
		this.siteNameLabel1.setForeground(Color.black);

		boolean ready = true;

		String patientId = this.evacPatientIdTextField1.getText();
		if ((patientId == null) || (patientId.length() < 1)) {
			this.evacPatientIdLabel1.setForeground(Color.RED);
			ready = false;
		}

		String siteName = this.siteNameTextField1.getText();
		if ((siteName == null) || (siteName.length() < 1)) {
			this.siteNameLabel1.setForeground(Color.RED);
			ready = false;
		}

		String transportType = revertTitleToEnumString(this.transportTypeComboBox1.getSelectedItem().toString());

		if (ready) {
			this.uiCommandHandler.sendMedicalEvacuationRequest(patientId, transportType, siteName);
		}
        }//GEN-LAST:event_requestEvacButton1ActionPerformed

        private void updateEvacButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEvacButton1ActionPerformed
		this.evacPatientIdLabel1.setForeground(Color.black);
		this.siteNameLabel1.setForeground(Color.black);
		this.vehicleIdLabel1.setForeground(Color.black);

		boolean ready = true;

		String patientId = this.evacPatientIdTextField1.getText();
		if ((patientId == null) || (patientId.length() < 1)) {
			this.evacPatientIdLabel1.setForeground(Color.RED);
			ready = false;
		}

		String siteName = this.siteNameTextField1.getText();
		if ((siteName == null) || (siteName.length() < 1)) {
			this.siteNameLabel1.setForeground(Color.RED);
			ready = false;
		}

		String vehicleId = this.vehicleIdTextField1.getText();
		if ((vehicleId == null) || (vehicleId.length() < 1)) {
			this.vehicleIdLabel1.setForeground(Color.RED);
			ready = false;
		}

		String evacState = revertTitleToEnumString(this.evacStateComboBox1.getSelectedItem().toString());

		if (ready) {
			this.uiCommandHandler.sendMedicalEvacuationUpdate(patientId, evacState, vehicleId, siteName);
		}
        }//GEN-LAST:event_updateEvacButton1ActionPerformed

        private void responseEvacButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responseEvacButton1ActionPerformed
	this.evacPatientIdLabel1.setForeground(Color.black);
        this.siteNameLabel1.setForeground(Color.black);
        this.vehicleIdLabel1.setForeground(Color.black);

        boolean ready = true;

        String patientId = this.evacPatientIdTextField1.getText();
        if((patientId == null) || (patientId.length() < 1)){
            this.evacPatientIdLabel1.setForeground(Color.RED);
            ready = false;
        }

        String siteName = this.siteNameTextField1.getText();
        if((siteName == null) || (siteName.length() < 1)){
            this.siteNameLabel1.setForeground(Color.RED);
            ready = false;
        }

        String vehicleId = this.vehicleIdTextField1.getText();
        if((vehicleId == null) || (vehicleId.length() < 1)){
            this.vehicleIdLabel1.setForeground(Color.RED);
            ready = false;
        }

        String evacState = revertTitleToEnumString(this.evacStateComboBox1.getSelectedItem().toString());

        if(ready){
            this.uiCommandHandler.sendMedicalEvacuationResponse(patientId, evacState, vehicleId, siteName);
	}
        }//GEN-LAST:event_responseEvacButton1ActionPerformed

        private void magicVitalsPatientIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicVitalsPatientIdTFActionPerformed

        }//GEN-LAST:event_magicVitalsPatientIdTFActionPerformed

        private void magicVitalsTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicVitalsTypeCBActionPerformed
                
        }//GEN-LAST:event_magicVitalsTypeCBActionPerformed

        private void magicVitalsValueTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicVitalsValueTFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_magicVitalsValueTFActionPerformed

        private void sendMagicVitalsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMagicVitalsBActionPerformed
               this.uiCommandHandler.magicVitals(this.magicVitalsPatientIdTF.getText()
		   , this.magicVitalsTypeCB.getSelectedItem().toString()
		   , Float.parseFloat(this.magicVitalsValueTF.getText()));
        }//GEN-LAST:event_sendMagicVitalsBActionPerformed

        private void magicTransferPatientIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicTransferPatientIdTFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_magicTransferPatientIdTFActionPerformed

        private void vitalsVisibilityMakeVisibleBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalsVisibilityMakeVisibleBActionPerformed
		this.uiCommandHandler.vitalsVisibility(this.vitalsVisibilityPatientIdTF1.getText()
		    , this.vitalsVisibilityTypeCB.getSelectedItem().toString(), true);                // TODO add your handling code here:
        }//GEN-LAST:event_vitalsVisibilityMakeVisibleBActionPerformed

        private void vitalsVisibilityHideBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalsVisibilityHideBActionPerformed
		this.uiCommandHandler.vitalsVisibility(this.vitalsVisibilityPatientIdTF1.getText()
		    , this.vitalsVisibilityTypeCB.getSelectedItem().toString(), false);                // TODO add your handling code here:
        }//GEN-LAST:event_vitalsVisibilityHideBActionPerformed

        private void vitalsVisibilityPatientIdTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalsVisibilityPatientIdTF1ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_vitalsVisibilityPatientIdTF1ActionPerformed

        private void magicTransferFacilityIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicTransferFacilityIdTFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_magicTransferFacilityIdTFActionPerformed

        private void magicTransferBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicTransferBActionPerformed
		this.uiCommandHandler.magicTransfer(this.magicTransferPatientIdTF.getText()
		    , this.magicTransferFacilityIdTF.getText() );
        }//GEN-LAST:event_magicTransferBActionPerformed

        private void casualyStateInstanceLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casualyStateInstanceLMouseClicked
		String instanceNameSel = this.casualyStateInstanceL.getSelectedValue();
		String data = this.uiCommandHandler.getCasualtyStateDetails(instanceNameSel);
		this.casualtyStateTA.setText(data);
        }//GEN-LAST:event_casualyStateInstanceLMouseClicked

        private void casualtyStateFacilityIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casualtyStateFacilityIdTFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_casualtyStateFacilityIdTFActionPerformed

        private void casualtyStateCreateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casualtyStateCreateBActionPerformed
         	this.uiCommandHandler.createCasualtyState(
		    this.casualtyStatePatientIdTF.getText(), 
		    this.casualtyStateFacilityIdTF.getText(), 
		    this.casualtyStateEvacPirorityCB.getSelectedItem().toString(), 
		    this.casualtyStateTriageClassificationCB.getSelectedItem().toString());       // TODO add your handling code here:
        }//GEN-LAST:event_casualtyStateCreateBActionPerformed

        private void casualtyStateTriageClassificationCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casualtyStateTriageClassificationCBActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_casualtyStateTriageClassificationCBActionPerformed

        private void casualyStateInstanceLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casualyStateInstanceLKeyPressed
		String instanceNameSel = this.casualyStateInstanceL.getSelectedValue();
		String data = this.uiCommandHandler.getCasualtyStateDetails(instanceNameSel);
		this.casualtyStateTA.setText(data);
        }//GEN-LAST:event_casualyStateInstanceLKeyPressed

        private void facilityInstanceLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facilityInstanceLMouseClicked
		String instanceNameSel = this.facilityInstanceL.getSelectedValue();
		String data = this.uiCommandHandler.getFacilityDetails(instanceNameSel);
		this.facilityInformationTA.setText(data);
        }//GEN-LAST:event_facilityInstanceLMouseClicked

        private void facilityInstanceLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_facilityInstanceLKeyPressed
                // TODO add your handling code here:
        }//GEN-LAST:event_facilityInstanceLKeyPressed

        private void facilityFacilityIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityFacilityIdTFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_facilityFacilityIdTFActionPerformed

        private void facilityCreateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityCreateBActionPerformed
         	this.uiCommandHandler.createFacility(
		    this.facilityFacilityIdTF.getText(),
		    this.facilityFacilityTypeCB.getSelectedItem().toString(),
		    this.facilityPatientCapacityTF.getText(),
		    this.facilityRoleOfCareCB.getSelectedItem().toString());
        }//GEN-LAST:event_facilityCreateBActionPerformed

        private void facilityFacilityTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityFacilityTypeCBActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_facilityFacilityTypeCBActionPerformed

        private void patientAcquireBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientAcquireBActionPerformed
		this.uiCommandHandler.acquireOwnership();
        }//GEN-LAST:event_patientAcquireBActionPerformed

        private void patientReleaseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientReleaseBActionPerformed
        	this.uiCommandHandler.releaseOwnership();
        }//GEN-LAST:event_patientReleaseBActionPerformed
//    private void switchToSigns
	private void clearNeuroTextFields() {
		this.neuroPatientIdTf.setText("");
		this.eyesTf.setText("");
		this.verbalTf.setText("");
		this.motorTf.setText("");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TestToolUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TestToolUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TestToolUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TestToolUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TestToolUI().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton addInjuryButton;
        private javax.swing.JButton addLabButton;
        private javax.swing.JButton addNeuroScalesButton;
        private javax.swing.JButton addPatientButton;
        private javax.swing.JButton addSignSymptomButton;
        private javax.swing.JLabel atTimeLabel;
        private javax.swing.JPanel atTimePanel;
        private javax.swing.JComboBox<String> attributeComboBox;
        private javax.swing.JButton autoFillButton;
        private javax.swing.JTextField bloodLossTf;
        private javax.swing.JPanel bloodPressurePanel;
        private javax.swing.JTextField bloodVolumeTf;
        private javax.swing.JList<String> bookmarkList;
        private javax.swing.JTextArea bookmarkTextArea;
        private javax.swing.JButton casualtyStateCreateB;
        private javax.swing.JComboBox<String> casualtyStateEvacPirorityCB;
        private javax.swing.JTextField casualtyStateFacilityIdTF;
        private javax.swing.JTextField casualtyStatePatientIdTF;
        private javax.swing.JTextArea casualtyStateTA;
        private javax.swing.JInternalFrame casualtyStateTabFrame;
        private javax.swing.JComboBox<String> casualtyStateTriageClassificationCB;
        private javax.swing.JList<String> casualyStateInstanceL;
        private javax.swing.JButton changeStateConfirmButton;
        private javax.swing.JPanel consoleInputPanel;
        private javax.swing.JInternalFrame consoleTabFrame;
        private javax.swing.JPanel controlButtonPanel;
        private javax.swing.JInternalFrame controlInteractionsTabFrame;
        private javax.swing.JButton createEventButton;
        private javax.swing.JButton createFluidButton;
        private javax.swing.JButton createLungPatientButton;
        private javax.swing.JPanel createNewEventPanel;
        private javax.swing.JPanel createNewEventPanel1;
        private javax.swing.JPanel createNewEventPanel2;
        private javax.swing.JList<String> createPatientList;
        private javax.swing.JPanel createPatientPanel;
        private javax.swing.JPanel dataLogPanel;
        private javax.swing.JInternalFrame dataLogsTabFrame;
        private javax.swing.JTextField deadSpaceTextField;
        private javax.swing.JTextArea desTextArea;
        private javax.swing.JTextField diastolicBPTextField;
        private javax.swing.JTextArea documentTextArea;
        private javax.swing.JPanel documentsPanel;
        private javax.swing.JInternalFrame documentsTabFrame;
        private javax.swing.JTextField durationTextField;
        private javax.swing.JTextField durationTf;
        private javax.swing.JLabel elapsedTimeLabel;
        private javax.swing.JPanel etco2Panel;
        private javax.swing.JTextField etco2TextField;
        private javax.swing.JLabel evacPatientIdLabel1;
        private javax.swing.JTextField evacPatientIdTextField1;
        private javax.swing.JLabel evacStageLabel1;
        private javax.swing.JComboBox<String> evacStateComboBox1;
        private javax.swing.JLabel eventInformationLabel;
        private javax.swing.JLabel eventInformationLabel1;
        private javax.swing.JLabel eventInformationLabel2;
        private javax.swing.JScrollPane eventList;
        private javax.swing.JScrollPane eventList1;
        private javax.swing.JScrollPane eventList2;
        private javax.swing.JLabel eventsListLabel;
        private javax.swing.JLabel eventsListLabel1;
        private javax.swing.JLabel eventsListLabel2;
        private javax.swing.JPanel eventsPanel;
        private javax.swing.JPanel eventsPanel1;
        private javax.swing.JPanel eventsPanel2;
        private javax.swing.JTextField expReserveTextField;
        private javax.swing.JTextField eyesTf;
        private javax.swing.JButton facilityCreateB;
        private javax.swing.JTextField facilityFacilityIdTF;
        private javax.swing.JComboBox<String> facilityFacilityTypeCB;
        private javax.swing.JTextField facilityIdTextField;
        private javax.swing.JTextArea facilityInformationTA;
        private javax.swing.JList<String> facilityInstanceL;
        private javax.swing.JTextField facilityPatientCapacityTF;
        private javax.swing.JComboBox<String> facilityRoleOfCareCB;
        private javax.swing.JInternalFrame facilityTabFrame;
        private javax.swing.JTextField facilityTextField;
        private javax.swing.JPanel fedControlPanel;
        private javax.swing.JPanel fedListPanel;
        private javax.swing.JTextArea fedListTextArea;
        private javax.swing.JComboBox<String> fedStateComboBox;
        private javax.swing.JPanel fedStatusPanel;
        private javax.swing.JPanel federationControlPanel;
        private javax.swing.JLabel federationStateLabel;
        private javax.swing.JPanel fileDisplayPanel;
        private javax.swing.Box.Filler filler7;
        private javax.swing.JComboBox<String> fluidAttributeCb;
        private javax.swing.JTable fluidTable;
        private javax.swing.JTextField fluidsPatientIdTf;
        private javax.swing.JInternalFrame fluidsTabFrame;
        private javax.swing.JLabel heartRateLabel;
        private javax.swing.JPanel heartRatePanel;
        private javax.swing.JTextField heartRateTF;
        private javax.swing.JButton iPauseButton;
        private javax.swing.JButton iResumeButton;
        private javax.swing.JButton iStartButton;
        private javax.swing.JButton iStopButton;
        private javax.swing.JTextField iidTextField;
        private javax.swing.JTextField incrementTf;
        private javax.swing.JLabel injuriesLabel;
        private javax.swing.JInternalFrame injuriesTabFrame;
        private javax.swing.JTree injuryTree;
        private javax.swing.JTextField inputTextField;
        private javax.swing.JTextField insReserveTextField;
        private javax.swing.JPanel instructionPanel;
        private javax.swing.JPanel instructionalControlsPanel;
        private javax.swing.JInternalFrame instructionalTabFrame;
        private javax.swing.JTextArea interactionHistoryTextArea;
        private javax.swing.JTextArea interactionHistoryTextArea1;
        private javax.swing.JPanel interactionsControlPanel;
        private javax.swing.JPanel interactionsControlPanel1;
        private javax.swing.JTextField intervalTextField;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel24;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel27;
        private javax.swing.JLabel jLabel28;
        private javax.swing.JLabel jLabel29;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel30;
        private javax.swing.JLabel jLabel31;
        private javax.swing.JLabel jLabel32;
        private javax.swing.JLabel jLabel33;
        private javax.swing.JLabel jLabel34;
        private javax.swing.JLabel jLabel35;
        private javax.swing.JLabel jLabel36;
        private javax.swing.JLabel jLabel37;
        private javax.swing.JLabel jLabel38;
        private javax.swing.JLabel jLabel39;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel40;
        private javax.swing.JLabel jLabel41;
        private javax.swing.JLabel jLabel42;
        private javax.swing.JLabel jLabel43;
        private javax.swing.JLabel jLabel44;
        private javax.swing.JLabel jLabel45;
        private javax.swing.JLabel jLabel46;
        private javax.swing.JLabel jLabel47;
        private javax.swing.JLabel jLabel48;
        private javax.swing.JLabel jLabel49;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel50;
        private javax.swing.JLabel jLabel51;
        private javax.swing.JLabel jLabel52;
        private javax.swing.JLabel jLabel53;
        private javax.swing.JLabel jLabel54;
        private javax.swing.JLabel jLabel55;
        private javax.swing.JLabel jLabel56;
        private javax.swing.JLabel jLabel57;
        private javax.swing.JLabel jLabel58;
        private javax.swing.JLabel jLabel59;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel60;
        private javax.swing.JLabel jLabel61;
        private javax.swing.JLabel jLabel62;
        private javax.swing.JLabel jLabel63;
        private javax.swing.JLabel jLabel64;
        private javax.swing.JLabel jLabel65;
        private javax.swing.JLabel jLabel66;
        private javax.swing.JLabel jLabel67;
        private javax.swing.JLabel jLabel68;
        private javax.swing.JLabel jLabel69;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel70;
        private javax.swing.JLabel jLabel71;
        private javax.swing.JLabel jLabel72;
        private javax.swing.JLabel jLabel73;
        private javax.swing.JLabel jLabel74;
        private javax.swing.JLabel jLabel75;
        private javax.swing.JLabel jLabel76;
        private javax.swing.JLabel jLabel77;
        private javax.swing.JLabel jLabel78;
        private javax.swing.JLabel jLabel79;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel80;
        private javax.swing.JLabel jLabel81;
        private javax.swing.JLabel jLabel82;
        private javax.swing.JLabel jLabel83;
        private javax.swing.JLabel jLabel84;
        private javax.swing.JLabel jLabel85;
        private javax.swing.JLabel jLabel86;
        private javax.swing.JLabel jLabel87;
        private javax.swing.JLabel jLabel88;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel16;
        private javax.swing.JPanel jPanel17;
        private javax.swing.JPanel jPanel18;
        private javax.swing.JPanel jPanel19;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel20;
        private javax.swing.JPanel jPanel21;
        private javax.swing.JPanel jPanel22;
        private javax.swing.JPanel jPanel23;
        private javax.swing.JPanel jPanel24;
        private javax.swing.JPanel jPanel25;
        private javax.swing.JPanel jPanel26;
        private javax.swing.JPanel jPanel27;
        private javax.swing.JPanel jPanel28;
        private javax.swing.JPanel jPanel29;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel30;
        private javax.swing.JPanel jPanel31;
        private javax.swing.JPanel jPanel32;
        private javax.swing.JPanel jPanel33;
        private javax.swing.JPanel jPanel34;
        private javax.swing.JPanel jPanel35;
        private javax.swing.JPanel jPanel36;
        private javax.swing.JPanel jPanel37;
        private javax.swing.JPanel jPanel38;
        private javax.swing.JPanel jPanel39;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel40;
        private javax.swing.JPanel jPanel41;
        private javax.swing.JPanel jPanel42;
        private javax.swing.JPanel jPanel43;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane10;
        private javax.swing.JScrollPane jScrollPane11;
        private javax.swing.JScrollPane jScrollPane12;
        private javax.swing.JScrollPane jScrollPane13;
        private javax.swing.JScrollPane jScrollPane14;
        private javax.swing.JScrollPane jScrollPane15;
        private javax.swing.JScrollPane jScrollPane16;
        private javax.swing.JScrollPane jScrollPane17;
        private javax.swing.JScrollPane jScrollPane18;
        private javax.swing.JScrollPane jScrollPane19;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane20;
        private javax.swing.JScrollPane jScrollPane21;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JScrollPane jScrollPane6;
        private javax.swing.JScrollPane jScrollPane7;
        private javax.swing.JScrollPane jScrollPane8;
        private javax.swing.JScrollPane jScrollPane9;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JSeparator jSeparator4;
        private javax.swing.JTabbedPane jTabbedPane;
        private javax.swing.JButton joinFedButton;
        private javax.swing.JTable labTable;
        private java.awt.Label label1;
        private javax.swing.JInternalFrame labsTabFrame;
        private javax.swing.JComboBox<String> learnerActionCB;
        private javax.swing.JLabel learnerActionLabel;
        private javax.swing.JTextField lidTextField;
        private javax.swing.JPanel listIxBtnPanel;
        private javax.swing.JButton loadPatientButton;
        private javax.swing.JComboBox<String> locCb;
        private javax.swing.JList<String> logList;
        private javax.swing.JTextArea logTextArea;
        private javax.swing.JComboBox<String> lorCb;
        private javax.swing.JPanel lungVariablesPanel;
        private javax.swing.JButton magicTransferB;
        private javax.swing.JTextField magicTransferFacilityIdTF;
        private javax.swing.JTextField magicTransferPatientIdTF;
        private javax.swing.JTextField magicVitalsPatientIdTF;
        private javax.swing.JComboBox<String> magicVitalsTypeCB;
        private javax.swing.JTextField magicVitalsValueTF;
        private javax.swing.JPanel mainPatientPanel;
        private javax.swing.JPanel medicalEvacuationPanel1;
        private javax.swing.JTextField motorTf;
        private javax.swing.JLabel neuroLabel;
        private javax.swing.JTextField neuroPatientIdTf;
        private javax.swing.JInternalFrame neuroTabFrame;
        private javax.swing.JTable neuroTable;
        private javax.swing.JButton newButton;
        private javax.swing.JButton newCreatePatientButton;
        private javax.swing.JButton newDocButton;
        private javax.swing.JButton newLogButton;
        private javax.swing.JButton newPatientButtion;
        private javax.swing.JButton newTreatmentButton;
        private javax.swing.JLabel notesLabel;
        private javax.swing.JTextArea notesTextArea;
        private javax.swing.JPanel o2SaturationPanel;
        private javax.swing.JTextField o2SaturationTextField;
        private javax.swing.JComboBox<String> objectsCb;
        private javax.swing.JTextArea outputTextArea;
        private javax.swing.JLabel patiendIdsLabel;
        private javax.swing.JLabel patiendIdsLabelSS;
        private javax.swing.JButton patientAcquireB;
        private javax.swing.JLabel patientActionPatientIdLabel;
        private javax.swing.JPanel patientControlPanel;
        private javax.swing.JTextField patientControlPatientIdTextField;
        private javax.swing.JPanel patientDetailsPanel;
        private javax.swing.JLabel patientIDLabel;
        private javax.swing.JTextField patientIDTF;
        private javax.swing.JPanel patientIdsPanel;
        private javax.swing.JPanel patientIdsPanel1;
        private javax.swing.JScrollPane patientIdsScrollPaneSS;
        private javax.swing.JScrollPane patientInjuriesPane;
        private javax.swing.JTextArea patientInjuriesTextArea;
        private javax.swing.JInternalFrame patientInteractionsTabFrame;
        private javax.swing.JInternalFrame patientInternalFrame;
        private javax.swing.JList<String> patientList;
        private javax.swing.JList<String> patientListSS;
        private javax.swing.JButton patientReleaseB;
        private javax.swing.JScrollPane patientSignsPane;
        private javax.swing.JTextArea patientSignsTextArea;
        private javax.swing.JScrollPane patientSymptomsPane;
        private javax.swing.JTextArea patientSymptomsTextArea;
        private javax.swing.JScrollPane patientTreatmentsPane;
        private javax.swing.JTextArea patientTreatmentsTextArea;
        private javax.swing.JScrollPane patientVitalsPane;
        private javax.swing.JTextArea patientVitalsTextArea;
        private javax.swing.JButton pauseButton;
        private javax.swing.JButton pausePatientButton;
        private javax.swing.JButton pauseResumeReplayBtn;
        private javax.swing.JTextField pidTextField;
        private javax.swing.JLabel provideTCCCLabel3;
        private javax.swing.JCheckBox publishTimeCb;
        private javax.swing.JButton removeSelectedBtn;
        private javax.swing.JPanel removeSelectedPanel;
        private javax.swing.JPanel replayButtonPanel;
        private javax.swing.JLabel replayControlLabel;
        private javax.swing.JList<java.io.File> replayFileList;
        private javax.swing.JPanel replayMainPanel;
        private javax.swing.JLabel replayRuntime;
        private javax.swing.JLabel replayStatusLabel;
        private javax.swing.JPanel replayStatusPanel;
        private javax.swing.JInternalFrame replayTabFrame;
        private javax.swing.JButton requestEvacButton1;
        private javax.swing.JLabel requiredLabel;
        private javax.swing.JTextField residualVolumeTextField;
        private javax.swing.JButton resignFedButton;
        private javax.swing.JTextField respRateTextField;
        private javax.swing.JPanel respirationRatePanel;
        private javax.swing.JButton responseEvacButton1;
        private javax.swing.JButton resumeButton;
        private javax.swing.JButton resumePatientButton;
        private javax.swing.JButton runReplayBtn;
        private javax.swing.JPanel runtimePanel;
        private javax.swing.JButton saveButton;
        private javax.swing.JLabel saveLabel;
        private javax.swing.JTextField saveTextField;
        private javax.swing.JLabel scaleTitleLabel;
        private javax.swing.JLabel scenarioNameLabel;
        private javax.swing.JTextField scenarioNameTextField;
        private javax.swing.JButton selectAllBtn;
        private javax.swing.JPanel selectAllPanel;
        private javax.swing.JButton selectCreatePatientButton;
        private javax.swing.JButton selectLogButton;
        private javax.swing.JButton selectScenarioJButton;
        private javax.swing.JPanel selectScenarioPanel;
        private javax.swing.JButton sendButton;
        private javax.swing.JButton sendMagicVitalsB;
        private javax.swing.JInternalFrame signsAndSymptomsTabFrame;
        private javax.swing.JLabel signsLabel;
        private javax.swing.JInternalFrame simControlInternalFrame;
        private javax.swing.JLabel simDateTimeLabel;
        private javax.swing.JPanel singsAndSymptomsPane;
        private javax.swing.JLabel siteNameLabel1;
        private javax.swing.JTextField siteNameTextField1;
        private javax.swing.JTextField sourceTextField;
        private javax.swing.JButton startButton;
        private javax.swing.JButton startButton1;
        private javax.swing.JPanel startButtonPanel;
        private javax.swing.JButton startPatientButton;
        private javax.swing.JPanel statusAndRuntimePanel;
        private javax.swing.JButton stopButton;
        private javax.swing.JButton stopButton1;
        private javax.swing.JButton stopPatientButton;
        private javax.swing.JButton stopReplayBtn;
        private javax.swing.JTextField sweatRateTf;
        private javax.swing.JLabel symptomsLabel;
        private javax.swing.JTextField systolicBPTextField;
        private javax.swing.JList<String> tcccList;
        private javax.swing.JInternalFrame tcccTabFrame;
        private javax.swing.JTextArea tcccTextArea;
        private javax.swing.JPanel tempPanel;
        private javax.swing.JTextField tempTextField;
        private javax.swing.JPanel testFluidUpdater;
        private javax.swing.JTextField tidTextField;
        private javax.swing.JTextField tidalVolumenTextField;
        private javax.swing.JTextField timeAtTextField;
        private javax.swing.JLabel timeRatioLabel;
        private javax.swing.JTextField timeRatioTextField;
        private javax.swing.JLabel timeScaleLabel;
        private javax.swing.JToggleButton timeUpdateButton;
        private javax.swing.JTextField totalCapacityTextField;
        private javax.swing.JComboBox<String> transportTypeComboBox1;
        private javax.swing.JLabel treatmentsLabel;
        private javax.swing.JComboBox<String> typeComboBox;
        private javax.swing.JLabel typeLabel;
        private javax.swing.JButton updateEvacButton1;
        private javax.swing.JButton updateFluidButton;
        private javax.swing.JButton updateNeuroButton;
        private javax.swing.JButton updatePatientButton;
        private javax.swing.JButton uploadCsvBtn;
        private javax.swing.JTextField urineOutputTf;
        private javax.swing.JLabel vehicleIdLabel1;
        private javax.swing.JTextField vehicleIdTextField1;
        private javax.swing.JTextField verbalTf;
        private javax.swing.JLabel vitalsLabel;
        private javax.swing.JLabel vitalsUpdaterLabel;
        private javax.swing.JPanel vitalsUpdaterPanel;
        private javax.swing.JToggleButton vitalsUpdaterStartButton;
        private javax.swing.JButton vitalsUpdaterStopButton;
        private javax.swing.JButton vitalsVisibilityHideB;
        private javax.swing.JButton vitalsVisibilityMakeVisibleB;
        private javax.swing.JTextField vitalsVisibilityPatientIdTF1;
        private javax.swing.JComboBox<String> vitalsVisibilityTypeCB;
        private javax.swing.JLabel wallClockLabel;
        // End of variables declaration//GEN-END:variables
}
