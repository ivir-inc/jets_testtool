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

import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.BowelSoundEnum;
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.CoughEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.EcgRhythmEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.HeartSoundEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import devstudio.generatedcode.datatypes.LungSoundEnum;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import devstudio.generatedcode.datatypes.MedicationAdministrationRouteEnum;
import devstudio.generatedcode.datatypes.MedicationEnum;
import devstudio.generatedcode.datatypes.PhysicalTreatmentTypeEnum;
import devstudio.generatedcode.datatypes.PupilSizeEnum;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.SkinColorEnum;
import devstudio.generatedcode.datatypes.SkinRashRecord;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;
import devstudio.generatedcode.datatypes.TreatmentDeviceEnum;
import devstudio.generatedcode.datatypes.VisionDisturbanceEnum;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;


/**
 *
 */
public class NewSignsOrSymptomsDialog extends javax.swing.JDialog {
    private boolean physicalTreatmentSelected = true;

    /**
     * Creates new form NewTreatmentDialog
     */
    public NewSignsOrSymptomsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        buildBodyLocationRecordOptions();
        buildSignsAndSymptomsComboBoxes();
        
    }
    
    private void buildBodyLocationRecordOptions(){
        
        // General Region
        List<String> genRegionList = new ArrayList<>();
        for(GeneralRegionEnum genRegEnum : GeneralRegionEnum.values()) {
            String titleEnum = convertEnumToTitle(genRegEnum.getName());
            genRegionList.add(titleEnum);
        }
        sortList(genRegionList);
        this.genRegionComboBox.setModel(new DefaultComboBoxModel<>(genRegionList.toArray(String[]::new)));
        
        // Region Tissue Type
        List<String> regionTissueList = new ArrayList<>();
        for(RegionTissueTypeEnum tissueEnum : RegionTissueTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(tissueEnum.getName());
            regionTissueList.add(titleEnum);
        }
        sortList(regionTissueList);
        this.regionTissueComboBox.setModel(new DefaultComboBoxModel<>(regionTissueList.toArray(String[]::new)));
        
        // Internal Anatomy
        List<String> internalAnatomyList = new ArrayList<>();
        for(InternalAnatomyEnum internalEnum : InternalAnatomyEnum.values()) {
            String titleEnum = convertEnumToTitle(internalEnum.getName());
            internalAnatomyList.add(titleEnum);
        }
        sortList(internalAnatomyList);
        this.internalAnatomyComboBox.setModel(new DefaultComboBoxModel<>(internalAnatomyList.toArray(String[]::new)));
        
        // Saggital Plane
        List<String> sagittalList = new ArrayList<>();
        for(SagittalPlaneEnum sagitalEnum : SagittalPlaneEnum.values()) {
            String titleEnum = convertEnumToTitle(sagitalEnum.getName());
            sagittalList.add(titleEnum);
        }
        sortList(sagittalList);
        this.sagittalComboBox.setModel(new DefaultComboBoxModel<>(sagittalList.toArray(String[]::new)));
        
        // Transverse Plane
        List<String> transverseList = new ArrayList<>();
        for(TransversePlaneEnum transverseEnum : TransversePlaneEnum.values()) {
            String titleEnum = convertEnumToTitle(transverseEnum.getName());
            transverseList.add(titleEnum);
        }
        sortList(transverseList);
        this.transverseComboBox.setModel(new DefaultComboBoxModel<>(transverseList.toArray(String[]::new)));
        
        // Coronal Plane
        List<String> coronalList = new ArrayList<>();
        for(CoronalPlaneEnum coronalEnum : CoronalPlaneEnum.values()) {
            String titleEnum = convertEnumToTitle(coronalEnum.getName());
            coronalList.add(titleEnum);
        }
        sortList(coronalList);
        this.coronalComboBox.setModel(new DefaultComboBoxModel<>(coronalList.toArray(String[]::new)));
        
        // Skeletal System
        List<String> skeletalList = new ArrayList<>();
        for(SkeletalSystemEnum skeletalEnum : SkeletalSystemEnum.values()) {
            String titleEnum = convertEnumToTitle(skeletalEnum.getName());
            skeletalList.add(titleEnum);
        }
        sortList(skeletalList);
        this.skeletalComboBox.setModel(new DefaultComboBoxModel<>(skeletalList.toArray(String[]::new)));
        
        // Detailed Anatomy
        List<String> detailedAnatomyList = new ArrayList<>();
        for(DetailedAnatomyEnum detailedAnatomyEnum : DetailedAnatomyEnum.values()) {
            String titleEnum = convertEnumToTitle(detailedAnatomyEnum.getName());
            detailedAnatomyList.add(titleEnum);
        }
        sortList(detailedAnatomyList);
        this.detailedAnatomyComboBox.setModel(new DefaultComboBoxModel<>(detailedAnatomyList.toArray(String[]::new)));
        
        
    }
    
    private void buildSignsAndSymptomsComboBoxes() {
        // Skin Color
        List<String> skinColorList = new ArrayList<>();
        for(SkinColorEnum skinColorEnum : SkinColorEnum.values()) {
            String titleEnum = convertEnumToTitle(skinColorEnum.getName());
            skinColorList.add(titleEnum);
        }
        
        Collections.sort(skinColorList); // Needed to add unique sort for skin color because it 
                                             //     uses "Normal" instead of "Not Applicable"        
        int normalIndex = skinColorList.indexOf("Normal");
        if (normalIndex != -1) {
            skinColorList.remove(normalIndex);
            skinColorList.add(0, "Normal"); 
        }
        
        this.skinColorCombo.setModel(new DefaultComboBoxModel<>(skinColorList.toArray(String[]::new)));
        
        // Cough
        List<String> coughList = new ArrayList<>();
        for(CoughEnum coughEnum : CoughEnum.values()) {
            String titleEnum = convertEnumToTitle(coughEnum.getName());
            coughList.add(titleEnum);
        }
        
        Collections.sort(coughList); // Needed to add unique sort for cough because it 
                                         //     is the only place that uses "N_A" instead
                                         //     Of "NOT_APPLICABLE"
        int naIndex = coughList.indexOf("N _a");
        if (naIndex != -1) {
            coughList.remove(naIndex);
            coughList.add(0, "Not Applicable"); // Need to use unique enum revert to match CoughEnum Set 
        }
        
        
        this.coughCombo.setModel(new DefaultComboBoxModel<>(coughList.toArray(String[]::new)));
        
        // ECG Rhythm
        List<String> ecgList = new ArrayList<>();
        for(EcgRhythmEnum ecgEnum : EcgRhythmEnum.values()) {
            String titleEnum = convertEnumToTitle(ecgEnum.getName());
            ecgList.add(titleEnum);
        }
        sortList(ecgList);
        this.ecgRhythmCombo.setModel(new DefaultComboBoxModel<>(ecgList.toArray(String[]::new)));
        
        // Heart Sound
        List<String> heartSoundList = new ArrayList<>();
        for(HeartSoundEnum heartSoundEnum : HeartSoundEnum.values()) {
            String titleEnum = convertEnumToTitle(heartSoundEnum.getName());
            heartSoundList.add(titleEnum);
        }
        sortList(heartSoundList);
        this.heartSoundCombo.setModel(new DefaultComboBoxModel<>(heartSoundList.toArray(String[]::new)));
        
        // Lung Sound
        List<String> lungSoundList = new ArrayList<>();
        for(LungSoundEnum lungSoundEnum : LungSoundEnum.values()) {
            String titleEnum = convertEnumToTitle(lungSoundEnum.getName());
            lungSoundList.add(titleEnum);
        }
        sortList(lungSoundList);
        this.lungSoundCombo.setModel(new DefaultComboBoxModel<>(lungSoundList.toArray(String[]::new)));
        
        // Bowel Sound
        List<String> bowelSoundList = new ArrayList<>();
        for(BowelSoundEnum bowelSoundEnum : BowelSoundEnum.values()) {
            String titleEnum = convertEnumToTitle(bowelSoundEnum.getName());
            bowelSoundList.add(titleEnum);
        }
        sortList(bowelSoundList);
        this.bowelSoundCombo.setModel(new DefaultComboBoxModel<>(bowelSoundList.toArray(String[]::new)));
        
        // Pupil Size
        List<String> pupilSizeList = new ArrayList<>();
        for(PupilSizeEnum pupilSizeEnum : PupilSizeEnum.values()) {
            String titleEnum = convertEnumToTitle(pupilSizeEnum.getName());
            pupilSizeList.add(titleEnum);
        }
        sortList(pupilSizeList);
        this.pupilSizeCombo.setModel(new DefaultComboBoxModel<>(pupilSizeList.toArray(String[]::new)));
        
        
        // Symptom - VisionDisturbance
        List<String> visDisturbList = new ArrayList<>();
        for(VisionDisturbanceEnum visDisturbEnum : VisionDisturbanceEnum.values()) {
            String titleEnum = convertEnumToTitle(visDisturbEnum.getName());
            visDisturbList.add(titleEnum);
        }
        
        // A custom sort/injection is needed for visionDisturbance because it is nullable and
        //      there is not a "NOT_APPLICABLE" option ----- will NEED custom form submission handling due to this
        visDisturbList.add(0, "Not Applicable");
        
        this.visionDisturbanceComboBox.setModel(new DefaultComboBoxModel<>(visDisturbList.toArray(String[]::new)));
    }
    
    private void sortList(List list) {
        Collections.sort(list);
        int naIndex = list.indexOf("Not Applicable");
        if (naIndex != -1) {
            list.remove(naIndex);
            list.add(0, "Not Applicable");
        }
    }
    
    public JLabel getPatientIdLabel(){
        return this.patientIdLabel;
    }
   
    
    public JComboBox getBodyLocationComboBox(){
        return this.regionTissueComboBox;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        symptomsPanel = new javax.swing.JPanel();
        dizzinessCB = new javax.swing.JCheckBox();
        nauseaCB = new javax.swing.JCheckBox();
        fatigueCB = new javax.swing.JCheckBox();
        numbnessCB = new javax.swing.JCheckBox();
        levelOfPainPanel = new javax.swing.JPanel();
        levelOfPainLabel = new javax.swing.JLabel();
        levelOfPainSlider = new javax.swing.JSlider();
        visionDisturbancePanel = new javax.swing.JPanel();
        visionDisturbanceLabel = new javax.swing.JLabel();
        visionDisturbanceComboBox = new javax.swing.JComboBox<>();
        signsPanel = new javax.swing.JPanel();
        confusionCheck = new javax.swing.JCheckBox();
        skinColorPane = new javax.swing.JPanel();
        skinColorCombo = new javax.swing.JComboBox<>();
        skinRashPane = new javax.swing.JPanel();
        skinRashRaisedCheck = new javax.swing.JCheckBox();
        skinRashUniformCheck = new javax.swing.JCheckBox();
        skinRashScabCheck = new javax.swing.JCheckBox();
        skinMoistureCheck = new javax.swing.JCheckBox();
        ecgRhythmPane = new javax.swing.JPanel();
        ecgRhythmCombo = new javax.swing.JComboBox<>();
        heartSoundPane = new javax.swing.JPanel();
        heartSoundCombo = new javax.swing.JComboBox<>();
        bowelSoundPane = new javax.swing.JPanel();
        bowelSoundCombo = new javax.swing.JComboBox<>();
        pupilSizePane = new javax.swing.JPanel();
        pupilSizeCombo = new javax.swing.JComboBox<>();
        coughPane = new javax.swing.JPanel();
        coughCombo = new javax.swing.JComboBox<>();
        lungSoundPane = new javax.swing.JPanel();
        lungSoundCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        patientIdLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        selectSignOrSymptomPane = new javax.swing.JPanel();
        selectSignOrSymptomLabel = new javax.swing.JLabel();
        selectSignsButton = new javax.swing.JButton();
        selectSymptomsButton = new javax.swing.JButton();
        bodyLocationPane = new javax.swing.JPanel();
        regionTissuePane = new javax.swing.JPanel();
        regionTissueComboBox = new javax.swing.JComboBox<>();
        internalAnatomyPane = new javax.swing.JPanel();
        internalAnatomyComboBox = new javax.swing.JComboBox<>();
        genRegionPane = new javax.swing.JPanel();
        genRegionComboBox = new javax.swing.JComboBox<>();
        sagittalPane = new javax.swing.JPanel();
        sagittalComboBox = new javax.swing.JComboBox<>();
        transversePane = new javax.swing.JPanel();
        transverseComboBox = new javax.swing.JComboBox<>();
        coronalPane = new javax.swing.JPanel();
        coronalComboBox = new javax.swing.JComboBox<>();
        skeletalPane = new javax.swing.JPanel();
        skeletalComboBox = new javax.swing.JComboBox<>();
        detailedAnatomyPane = new javax.swing.JPanel();
        detailedAnatomyComboBox = new javax.swing.JComboBox<>();
        fmaidLabel = new javax.swing.JLabel();
        fmaidTextField = new javax.swing.JTextField();

        symptomsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Symptoms"));
        symptomsPanel.setPreferredSize(new java.awt.Dimension(497, 240));

        dizzinessCB.setText("Dizziness");

        nauseaCB.setText("Nausea");

        fatigueCB.setText("Fatigue");

        numbnessCB.setText("Numbness");

        levelOfPainLabel.setText("Level Of Pain");

        levelOfPainSlider.setMajorTickSpacing(1);
        levelOfPainSlider.setMaximum(10);
        levelOfPainSlider.setPaintLabels(true);
        levelOfPainSlider.setPaintTicks(true);
        levelOfPainSlider.setSnapToTicks(true);
        levelOfPainSlider.setValue(0);

        javax.swing.GroupLayout levelOfPainPanelLayout = new javax.swing.GroupLayout(levelOfPainPanel);
        levelOfPainPanel.setLayout(levelOfPainPanelLayout);
        levelOfPainPanelLayout.setHorizontalGroup(
            levelOfPainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(levelOfPainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(levelOfPainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelOfPainSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        levelOfPainPanelLayout.setVerticalGroup(
            levelOfPainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(levelOfPainPanelLayout.createSequentialGroup()
                .addGroup(levelOfPainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(levelOfPainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(levelOfPainSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(levelOfPainPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(levelOfPainLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visionDisturbanceLabel.setText("Vision Disturbance");

        visionDisturbanceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIPLOPIA_HORIZONTAL" }));

        javax.swing.GroupLayout visionDisturbancePanelLayout = new javax.swing.GroupLayout(visionDisturbancePanel);
        visionDisturbancePanel.setLayout(visionDisturbancePanelLayout);
        visionDisturbancePanelLayout.setHorizontalGroup(
            visionDisturbancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(visionDisturbanceLabel)
            .addGroup(visionDisturbancePanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(visionDisturbanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        visionDisturbancePanelLayout.setVerticalGroup(
            visionDisturbancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visionDisturbancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visionDisturbancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visionDisturbanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visionDisturbanceLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout symptomsPanelLayout = new javax.swing.GroupLayout(symptomsPanel);
        symptomsPanel.setLayout(symptomsPanelLayout);
        symptomsPanelLayout.setHorizontalGroup(
            symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symptomsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(symptomsPanelLayout.createSequentialGroup()
                        .addComponent(visionDisturbancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(symptomsPanelLayout.createSequentialGroup()
                        .addGroup(symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numbnessCB)
                            .addComponent(dizzinessCB))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(symptomsPanelLayout.createSequentialGroup()
                        .addGroup(symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fatigueCB)
                            .addComponent(nauseaCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(levelOfPainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))))
        );
        symptomsPanelLayout.setVerticalGroup(
            symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symptomsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dizzinessCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(symptomsPanelLayout.createSequentialGroup()
                        .addComponent(nauseaCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fatigueCB))
                    .addComponent(levelOfPainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numbnessCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visionDisturbancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        signsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Signs"));

        confusionCheck.setText("Confusion");

        skinColorPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Skin Color"));
        skinColorPane.setOpaque(false);
        skinColorPane.setPreferredSize(new java.awt.Dimension(220, 51));

        skinColorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout skinColorPaneLayout = new javax.swing.GroupLayout(skinColorPane);
        skinColorPane.setLayout(skinColorPaneLayout);
        skinColorPaneLayout.setHorizontalGroup(
            skinColorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skinColorPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(skinColorCombo, 0, 182, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        skinColorPaneLayout.setVerticalGroup(
            skinColorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skinColorPaneLayout.createSequentialGroup()
                .addComponent(skinColorCombo)
                .addGap(126, 126, 126))
        );

        skinRashPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Skin Rash"));

        skinRashRaisedCheck.setText("Raised");
        skinRashRaisedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinRashRaisedCheckActionPerformed(evt);
            }
        });

        skinRashUniformCheck.setText("Uniform");
        skinRashUniformCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinRashUniformCheckActionPerformed(evt);
            }
        });

        skinRashScabCheck.setText("Scab");
        skinRashScabCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinRashScabCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout skinRashPaneLayout = new javax.swing.GroupLayout(skinRashPane);
        skinRashPane.setLayout(skinRashPaneLayout);
        skinRashPaneLayout.setHorizontalGroup(
            skinRashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skinRashPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(skinRashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skinRashRaisedCheck)
                    .addComponent(skinRashUniformCheck)
                    .addComponent(skinRashScabCheck))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        skinRashPaneLayout.setVerticalGroup(
            skinRashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skinRashPaneLayout.createSequentialGroup()
                .addComponent(skinRashRaisedCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skinRashUniformCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skinRashScabCheck))
        );

        skinMoistureCheck.setText("Skin Moisture");

        ecgRhythmPane.setBorder(javax.swing.BorderFactory.createTitledBorder("ECG Rhythm"));
        ecgRhythmPane.setPreferredSize(new java.awt.Dimension(220, 51));

        ecgRhythmCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));
        ecgRhythmCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecgRhythmComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ecgRhythmPaneLayout = new javax.swing.GroupLayout(ecgRhythmPane);
        ecgRhythmPane.setLayout(ecgRhythmPaneLayout);
        ecgRhythmPaneLayout.setHorizontalGroup(
            ecgRhythmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecgRhythmPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ecgRhythmCombo, 0, 181, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        ecgRhythmPaneLayout.setVerticalGroup(
            ecgRhythmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecgRhythmPaneLayout.createSequentialGroup()
                .addComponent(ecgRhythmCombo)
                .addContainerGap())
        );

        heartSoundPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Heart Sound"));
        heartSoundPane.setPreferredSize(new java.awt.Dimension(220, 51));

        heartSoundCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout heartSoundPaneLayout = new javax.swing.GroupLayout(heartSoundPane);
        heartSoundPane.setLayout(heartSoundPaneLayout);
        heartSoundPaneLayout.setHorizontalGroup(
            heartSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartSoundPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(heartSoundCombo, 0, 181, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        heartSoundPaneLayout.setVerticalGroup(
            heartSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartSoundPaneLayout.createSequentialGroup()
                .addComponent(heartSoundCombo)
                .addContainerGap())
        );

        bowelSoundPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Bowel Sound"));
        bowelSoundPane.setPreferredSize(new java.awt.Dimension(220, 51));

        bowelSoundCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout bowelSoundPaneLayout = new javax.swing.GroupLayout(bowelSoundPane);
        bowelSoundPane.setLayout(bowelSoundPaneLayout);
        bowelSoundPaneLayout.setHorizontalGroup(
            bowelSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bowelSoundPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(bowelSoundCombo, 0, 181, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        bowelSoundPaneLayout.setVerticalGroup(
            bowelSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bowelSoundPaneLayout.createSequentialGroup()
                .addComponent(bowelSoundCombo)
                .addContainerGap())
        );

        pupilSizePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Pupil Size"));
        pupilSizePane.setPreferredSize(new java.awt.Dimension(200, 51));

        pupilSizeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout pupilSizePaneLayout = new javax.swing.GroupLayout(pupilSizePane);
        pupilSizePane.setLayout(pupilSizePaneLayout);
        pupilSizePaneLayout.setHorizontalGroup(
            pupilSizePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pupilSizePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pupilSizeCombo, 0, 161, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        pupilSizePaneLayout.setVerticalGroup(
            pupilSizePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pupilSizePaneLayout.createSequentialGroup()
                .addComponent(pupilSizeCombo)
                .addContainerGap())
        );

        coughPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Cough"));
        coughPane.setPreferredSize(new java.awt.Dimension(220, 51));

        coughCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout coughPaneLayout = new javax.swing.GroupLayout(coughPane);
        coughPane.setLayout(coughPaneLayout);
        coughPaneLayout.setHorizontalGroup(
            coughPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coughPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(coughCombo, 0, 182, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        coughPaneLayout.setVerticalGroup(
            coughPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coughPaneLayout.createSequentialGroup()
                .addComponent(coughCombo)
                .addContainerGap())
        );

        lungSoundPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Lung Sound"));
        lungSoundPane.setPreferredSize(new java.awt.Dimension(200, 51));

        lungSoundCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout lungSoundPaneLayout = new javax.swing.GroupLayout(lungSoundPane);
        lungSoundPane.setLayout(lungSoundPaneLayout);
        lungSoundPaneLayout.setHorizontalGroup(
            lungSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lungSoundPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lungSoundCombo, 0, 182, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        lungSoundPaneLayout.setVerticalGroup(
            lungSoundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lungSoundPaneLayout.createSequentialGroup()
                .addComponent(lungSoundCombo)
                .addContainerGap())
        );

        javax.swing.GroupLayout signsPanelLayout = new javax.swing.GroupLayout(signsPanel);
        signsPanel.setLayout(signsPanelLayout);
        signsPanelLayout.setHorizontalGroup(
            signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confusionCheck)
                    .addComponent(skinMoistureCheck)
                    .addComponent(skinRashPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(skinColorPane, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coughPane, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lungSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heartSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bowelSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecgRhythmPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pupilSizePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        signsPanelLayout.setVerticalGroup(
            signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signsPanelLayout.createSequentialGroup()
                .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signsPanelLayout.createSequentialGroup()
                        .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ecgRhythmPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skinColorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heartSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coughPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(signsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bowelSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lungSoundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pupilSizePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(confusionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skinMoistureCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skinRashPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 480));
        setModal(true);
        setSize(new java.awt.Dimension(1300, 480));

        jLabel1.setText("Patient ID:");

        patientIdLabel.setText("1234567890");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        selectSignOrSymptomPane.setPreferredSize(new java.awt.Dimension(545, 418));

        selectSignOrSymptomLabel.setText("Select Sign or Symptom:");

        selectSignsButton.setText("Signs");
        selectSignsButton.setMaximumSize(new java.awt.Dimension(155, 70));
        selectSignsButton.setMinimumSize(new java.awt.Dimension(155, 70));
        selectSignsButton.setPreferredSize(new java.awt.Dimension(155, 70));
        selectSignsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSignsButtonActionPerformed(evt);
            }
        });

        selectSymptomsButton.setText("Symptoms");
        selectSymptomsButton.setMaximumSize(new java.awt.Dimension(155, 70));
        selectSymptomsButton.setMinimumSize(new java.awt.Dimension(155, 70));
        selectSymptomsButton.setPreferredSize(new java.awt.Dimension(155, 70));
        selectSymptomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSymptomsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectSignOrSymptomPaneLayout = new javax.swing.GroupLayout(selectSignOrSymptomPane);
        selectSignOrSymptomPane.setLayout(selectSignOrSymptomPaneLayout);
        selectSignOrSymptomPaneLayout.setHorizontalGroup(
            selectSignOrSymptomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSignOrSymptomPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(selectSignOrSymptomLabel)
                .addGap(18, 18, 18)
                .addComponent(selectSignsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(selectSymptomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        selectSignOrSymptomPaneLayout.setVerticalGroup(
            selectSignOrSymptomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSignOrSymptomPaneLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(selectSignOrSymptomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSignOrSymptomLabel)
                    .addComponent(selectSignsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectSymptomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        bodyLocationPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Sign Or Symptom Location"));

        regionTissuePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Region Tissue"));

        regionTissueComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout regionTissuePaneLayout = new javax.swing.GroupLayout(regionTissuePane);
        regionTissuePane.setLayout(regionTissuePaneLayout);
        regionTissuePaneLayout.setHorizontalGroup(
            regionTissuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regionTissuePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(regionTissueComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        regionTissuePaneLayout.setVerticalGroup(
            regionTissuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regionTissuePaneLayout.createSequentialGroup()
                .addComponent(regionTissueComboBox)
                .addContainerGap())
        );

        internalAnatomyPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Internal Anatomy"));

        internalAnatomyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout internalAnatomyPaneLayout = new javax.swing.GroupLayout(internalAnatomyPane);
        internalAnatomyPane.setLayout(internalAnatomyPaneLayout);
        internalAnatomyPaneLayout.setHorizontalGroup(
            internalAnatomyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalAnatomyPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(internalAnatomyComboBox, 0, 178, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        internalAnatomyPaneLayout.setVerticalGroup(
            internalAnatomyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalAnatomyPaneLayout.createSequentialGroup()
                .addComponent(internalAnatomyComboBox)
                .addContainerGap())
        );

        genRegionPane.setBorder(javax.swing.BorderFactory.createTitledBorder("General Region"));

        genRegionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout genRegionPaneLayout = new javax.swing.GroupLayout(genRegionPane);
        genRegionPane.setLayout(genRegionPaneLayout);
        genRegionPaneLayout.setHorizontalGroup(
            genRegionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genRegionPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(genRegionComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        genRegionPaneLayout.setVerticalGroup(
            genRegionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genRegionPaneLayout.createSequentialGroup()
                .addComponent(genRegionComboBox)
                .addContainerGap())
        );

        sagittalPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Sagittal Plane"));

        sagittalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout sagittalPaneLayout = new javax.swing.GroupLayout(sagittalPane);
        sagittalPane.setLayout(sagittalPaneLayout);
        sagittalPaneLayout.setHorizontalGroup(
            sagittalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagittalPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sagittalComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        sagittalPaneLayout.setVerticalGroup(
            sagittalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagittalPaneLayout.createSequentialGroup()
                .addComponent(sagittalComboBox)
                .addContainerGap())
        );

        transversePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Transverse Plane"));

        transverseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout transversePaneLayout = new javax.swing.GroupLayout(transversePane);
        transversePane.setLayout(transversePaneLayout);
        transversePaneLayout.setHorizontalGroup(
            transversePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transversePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(transverseComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        transversePaneLayout.setVerticalGroup(
            transversePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transversePaneLayout.createSequentialGroup()
                .addComponent(transverseComboBox)
                .addContainerGap())
        );

        coronalPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Coronal Plane"));

        coronalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout coronalPaneLayout = new javax.swing.GroupLayout(coronalPane);
        coronalPane.setLayout(coronalPaneLayout);
        coronalPaneLayout.setHorizontalGroup(
            coronalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coronalPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(coronalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        coronalPaneLayout.setVerticalGroup(
            coronalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coronalPaneLayout.createSequentialGroup()
                .addComponent(coronalComboBox)
                .addContainerGap())
        );

        skeletalPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Skeletal"));

        skeletalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout skeletalPaneLayout = new javax.swing.GroupLayout(skeletalPane);
        skeletalPane.setLayout(skeletalPaneLayout);
        skeletalPaneLayout.setHorizontalGroup(
            skeletalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skeletalPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(skeletalComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        skeletalPaneLayout.setVerticalGroup(
            skeletalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skeletalPaneLayout.createSequentialGroup()
                .addComponent(skeletalComboBox)
                .addContainerGap())
        );

        detailedAnatomyPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Detailed Anatomy"));

        detailedAnatomyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout detailedAnatomyPaneLayout = new javax.swing.GroupLayout(detailedAnatomyPane);
        detailedAnatomyPane.setLayout(detailedAnatomyPaneLayout);
        detailedAnatomyPaneLayout.setHorizontalGroup(
            detailedAnatomyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailedAnatomyPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(detailedAnatomyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailedAnatomyPaneLayout.setVerticalGroup(
            detailedAnatomyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailedAnatomyPaneLayout.createSequentialGroup()
                .addComponent(detailedAnatomyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fmaidLabel.setText("FMA ID");

        fmaidTextField.setToolTipText("");
        fmaidTextField.setMaximumSize(new java.awt.Dimension(120, 25));
        fmaidTextField.setMinimumSize(new java.awt.Dimension(120, 25));
        fmaidTextField.setName(""); // NOI18N
        fmaidTextField.setPreferredSize(new java.awt.Dimension(120, 25));
        fmaidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmaidTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyLocationPaneLayout = new javax.swing.GroupLayout(bodyLocationPane);
        bodyLocationPane.setLayout(bodyLocationPaneLayout);
        bodyLocationPaneLayout.setHorizontalGroup(
            bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                        .addComponent(fmaidLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fmaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                            .addComponent(skeletalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(detailedAnatomyPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                            .addComponent(sagittalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(transversePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(coronalPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                            .addComponent(genRegionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(regionTissuePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(internalAnatomyPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyLocationPaneLayout.setVerticalGroup(
            bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLocationPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genRegionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(internalAnatomyPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regionTissuePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sagittalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coronalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transversePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(skeletalPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailedAnatomyPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmaidLabel)
                    .addComponent(fmaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectSignOrSymptomPane, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(85, 85, 85)
                        .addComponent(patientIdLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bodyLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(patientIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectSignOrSymptomPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bodyLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        
        // Setting BodyLocationRecord
        BodyLocationRecord bodyLocation = null;
        
        String genRegionTitle = this.genRegionComboBox.getSelectedItem().toString();
        String genRegionName = titleStringToEnumName(genRegionTitle);
        
        String regionTissueTypeTitle = this.regionTissueComboBox.getSelectedItem().toString();
        String regionTissueTypeName = titleStringToEnumName(regionTissueTypeTitle);
        
        String internalAnatomyTitle = this.internalAnatomyComboBox.getSelectedItem().toString();
        String internalAnatomyName = titleStringToEnumName(internalAnatomyTitle);
        
        String sagittalTitle = this.sagittalComboBox.getSelectedItem().toString();
        String sagittalName = titleStringToEnumName(sagittalTitle);
        
        String transverseTitle = this.transverseComboBox.getSelectedItem().toString();
        String transverseeName = titleStringToEnumName(transverseTitle);
        
        String coronalTitle = this.coronalComboBox.getSelectedItem().toString();
        String coronalName = titleStringToEnumName(coronalTitle);
        
        String skeletalTitle = this.skeletalComboBox.getSelectedItem().toString();
        String skeletalName = titleStringToEnumName(skeletalTitle);
        
        String detailedAnatomyTitle = this.detailedAnatomyComboBox.getSelectedItem().toString();
        String detailedAnatomyName = titleStringToEnumName(detailedAnatomyTitle);
        
        bodyLocation = BodyLocationRecord.create(
                        GeneralRegionEnum.find(genRegionName), 
                        RegionTissueTypeEnum.find(regionTissueTypeName), 
                        InternalAnatomyEnum.find(internalAnatomyName), 
                        SagittalPlaneEnum.find(sagittalName), 
                        TransversePlaneEnum.find(transverseeName), 
                        CoronalPlaneEnum.find(coronalName), 
                        SkeletalSystemEnum.find(skeletalName), 
                        DetailedAnatomyEnum.find(detailedAnatomyName), 
                        0);
        
        if(this.signsPanel.isEnabled()){
            Signs signs = new Signs();
            
            signs.setSignLocation(bodyLocation);
            signs.setConfusion(this.confusionCheck.isSelected());
            
            String skinColor = titleStringToEnumName(this.skinColorCombo.getSelectedItem().toString());
            signs.setSkinColor(SkinColorEnum.find(skinColor));
            
            SkinRashRecord skinRash = SkinRashRecord.create(
                        this.skinRashRaisedCheck.isSelected(),
                        this.skinRashUniformCheck.isSelected(),
                        this.skinRashScabCheck.isSelected());
            signs.setSkinRashRecord(skinRash);
            
            signs.setSkinMoisture(this.skinMoistureCheck.isSelected());
           
            
            String coughString = titleStringToEnumName(this.coughCombo.getSelectedItem().toString());
            // NOTE: Due to CoughEnum using n_a instead of "notApplicable", 
            //      logic is modified to allow Enum.find() to operate properly
            if(coughString.equalsIgnoreCase("notApplicable")) {
                coughString = "n_a";
            }
            signs.setCough(CoughEnum.find(coughString));
            
            String ecgRhytmString = titleStringToEnumName(this.ecgRhythmCombo.getSelectedItem().toString());
            signs.setEcgRhythm(EcgRhythmEnum.find(ecgRhytmString));
            
            String heartSoundString = titleStringToEnumName(this.heartSoundCombo.getSelectedItem().toString());
            signs.setHeartSound(HeartSoundEnum.find(heartSoundString));
            
            String lungSoundString = titleStringToEnumName(this.lungSoundCombo.getSelectedItem().toString());
            signs.setLungSound(LungSoundEnum.find(lungSoundString));
            
            String bowelSoundString = titleStringToEnumName(this.bowelSoundCombo.getSelectedItem().toString());
            signs.setBowelSound(BowelSoundEnum.find(bowelSoundString));
            
            String pupilSizeString = titleStringToEnumName(this.pupilSizeCombo.getSelectedItem().toString());
            signs.setPupilSize(PupilSizeEnum.find(pupilSizeString));

            this.setVisible(false);
            UiCommandHandler.getUiCommandHandler().createSigns(signs);
                
        } else if(this.symptomsPanel.isEnabled()) {
            Symptoms symptoms = new Symptoms();
            
            symptoms.setSymptomLocation(bodyLocation);
            
            symptoms.setDizziness(this.dizzinessCB.isSelected());
            symptoms.setNausea(this.nauseaCB.isSelected());
            symptoms.setFatigue(this.fatigueCB.isSelected());
            symptoms.setNumbness(this.numbnessCB.isSelected());
            
            symptoms.setLevelOfPain(this.levelOfPainSlider.getValue());
            
            String visDisturbanceString = titleStringToEnumName(this.visionDisturbanceComboBox.getSelectedItem().toString());
            // NOTE: "Not Applicable" Option was inserted into ComboBox, but is not part of Enum Set
            //          This will return a null, and set VisionDisturbanceEnum to null--this is intentional
            symptoms.setVisionDisturbance(VisionDisturbanceEnum.find(visDisturbanceString));
            
            
            this.setVisible(false);
            UiCommandHandler.getUiCommandHandler().createSymptoms(symptoms);
       
        } else {
            this.setVisible(false);
        }
       
    }//GEN-LAST:event_addButtonActionPerformed

    private String revertTitleToEnumString (String title) {
        return title.toUpperCase().replaceAll(" ", "_");
    }
    
    private String titleStringToEnumName(String title) {
        String enumName = Character.toLowerCase(title.charAt(0)) + title.substring(1);
        
        return enumName.replaceAll(" ","");
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fmaidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmaidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmaidTextFieldActionPerformed

    private void selectSignsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSignsButtonActionPerformed

        this.signsPanel.setEnabled(true);
        this.symptomsPanel.setEnabled(false);
        this.addButton.setEnabled(true);
        
        if (this.symptomsPanel.isShowing()) {
            this.symptomsPanel.setEnabled(false);
            selectSignOrSymptomPane.remove(this.symptomsPanel);
        }
        Container contentPane = getContentPane();

        this.signsPanel.setBounds(this.selectSignOrSymptomLabel.getX() - 10,
            this.selectSignOrSymptomLabel.getY() + 50, 600, 290);
        this.selectSignOrSymptomPane.add(this.signsPanel);
//        switchToSigns(true);  ----- May need to implement later

        contentPane.validate();
        contentPane.repaint();
        this.pack();
    }//GEN-LAST:event_selectSignsButtonActionPerformed

    private void selectSymptomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSymptomsButtonActionPerformed

        this.symptomsPanel.setEnabled(true);
        this.signsPanel.setEnabled(false);
        this.addButton.setEnabled(true);
        
        if (this.signsPanel.isShowing()) {
            selectSignOrSymptomPane.remove(this.signsPanel);
        }
        Container contentPane = getContentPane();

        this.symptomsPanel.setBounds(this.selectSignOrSymptomLabel.getX() - 10,
            this.selectSignOrSymptomLabel.getY() + 50, 600, 290);
        this.selectSignOrSymptomPane.add(this.symptomsPanel);
//        switchToSigns(false); ----- May need to implement later

        contentPane.validate();
        contentPane.repaint();
        this.pack();
    }//GEN-LAST:event_selectSymptomsButtonActionPerformed

    private void skinRashRaisedCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinRashRaisedCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skinRashRaisedCheckActionPerformed

    private void skinRashUniformCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinRashUniformCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skinRashUniformCheckActionPerformed

    private void skinRashScabCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinRashScabCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skinRashScabCheckActionPerformed

    private void ecgRhythmComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecgRhythmComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecgRhythmComboActionPerformed

    
    
    private boolean nullOrEmpty(String value){
        if(value == null){
            return true;
        }else if(value.length() < 1){
            return true;
        }
        return false;
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
            java.util.logging.Logger.getLogger(NewSignsOrSymptomsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignsOrSymptomsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignsOrSymptomsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignsOrSymptomsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSignsOrSymptomsDialog dialog = new NewSignsOrSymptomsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bodyLocationPane;
    private javax.swing.JComboBox<String> bowelSoundCombo;
    private javax.swing.JPanel bowelSoundPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox confusionCheck;
    private javax.swing.JComboBox<String> coronalComboBox;
    private javax.swing.JPanel coronalPane;
    private javax.swing.JComboBox<String> coughCombo;
    private javax.swing.JPanel coughPane;
    private javax.swing.JComboBox<String> detailedAnatomyComboBox;
    private javax.swing.JPanel detailedAnatomyPane;
    private javax.swing.JCheckBox dizzinessCB;
    private javax.swing.JComboBox<String> ecgRhythmCombo;
    private javax.swing.JPanel ecgRhythmPane;
    private javax.swing.JCheckBox fatigueCB;
    private javax.swing.JLabel fmaidLabel;
    private javax.swing.JTextField fmaidTextField;
    private javax.swing.JComboBox<String> genRegionComboBox;
    private javax.swing.JPanel genRegionPane;
    private javax.swing.JComboBox<String> heartSoundCombo;
    private javax.swing.JPanel heartSoundPane;
    private javax.swing.JComboBox<String> internalAnatomyComboBox;
    private javax.swing.JPanel internalAnatomyPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel levelOfPainLabel;
    private javax.swing.JPanel levelOfPainPanel;
    private javax.swing.JSlider levelOfPainSlider;
    private javax.swing.JComboBox<String> lungSoundCombo;
    private javax.swing.JPanel lungSoundPane;
    private javax.swing.JCheckBox nauseaCB;
    private javax.swing.JCheckBox numbnessCB;
    private javax.swing.JLabel patientIdLabel;
    private javax.swing.JComboBox<String> pupilSizeCombo;
    private javax.swing.JPanel pupilSizePane;
    private javax.swing.JComboBox<String> regionTissueComboBox;
    private javax.swing.JPanel regionTissuePane;
    private javax.swing.JComboBox<String> sagittalComboBox;
    private javax.swing.JPanel sagittalPane;
    private javax.swing.JLabel selectSignOrSymptomLabel;
    private javax.swing.JPanel selectSignOrSymptomPane;
    private javax.swing.JButton selectSignsButton;
    private javax.swing.JButton selectSymptomsButton;
    private javax.swing.JPanel signsPanel;
    private javax.swing.JComboBox<String> skeletalComboBox;
    private javax.swing.JPanel skeletalPane;
    private javax.swing.JComboBox<String> skinColorCombo;
    private javax.swing.JPanel skinColorPane;
    private javax.swing.JCheckBox skinMoistureCheck;
    private javax.swing.JPanel skinRashPane;
    private javax.swing.JCheckBox skinRashRaisedCheck;
    private javax.swing.JCheckBox skinRashScabCheck;
    private javax.swing.JCheckBox skinRashUniformCheck;
    private javax.swing.JPanel symptomsPanel;
    private javax.swing.JComboBox<String> transverseComboBox;
    private javax.swing.JPanel transversePane;
    private javax.swing.JComboBox<String> visionDisturbanceComboBox;
    private javax.swing.JLabel visionDisturbanceLabel;
    private javax.swing.JPanel visionDisturbancePanel;
    // End of variables declaration//GEN-END:variables
}
