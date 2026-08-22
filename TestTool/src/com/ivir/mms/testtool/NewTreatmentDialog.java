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
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import devstudio.generatedcode.datatypes.MedicationAdministrationRouteEnum;
import devstudio.generatedcode.datatypes.MedicationEnum;
import devstudio.generatedcode.datatypes.PhysicalTreatmentTypeEnum;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;
import devstudio.generatedcode.datatypes.TreatmentDeviceEnum;
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
public class NewTreatmentDialog extends javax.swing.JDialog {
    private boolean physicalTreatmentSelected = true;

    /**
     * Creates new form NewTreatmentDialog
     */
    public NewTreatmentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        groupRadioButtons();
        buildBodyLocationRecordOptions();
        buildPhysicalTreatment();
        buildMedications();
        buildDeviceUsed();
        buildRouteUsed();
        switchTreatmentType(true);
        
    }
    private void groupRadioButtons(){
        ButtonGroup group = new ButtonGroup();
        group.add(this.physicalRadioButton);
        group.add(this.medicationRadioButton);
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

    private void buildPhysicalTreatment() {
        List<String> physicalTreatmentList = new ArrayList<>();
        for(PhysicalTreatmentTypeEnum mEnum : PhysicalTreatmentTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(mEnum.getName());
            physicalTreatmentList.add(titleEnum);
        }
        sortList(physicalTreatmentList);
        
        this.physicalComboBox.setModel(new DefaultComboBoxModel<>(physicalTreatmentList.toArray(String[]::new)));
    }
    
    private void buildMedications() {
        List<String> medicationEnumList = new ArrayList<>();
        for(MedicationEnum medEnum : MedicationEnum.values()) {
            String titleEnum = convertEnumToTitle(medEnum.getName());
            medicationEnumList.add(titleEnum);
        }
        sortList(medicationEnumList);
        
        this.medicationNameComboBox.setModel(new DefaultComboBoxModel<>(medicationEnumList.toArray(String[]::new)));
    }
    
    private void buildDeviceUsed(){
        List<String> deviceList = new ArrayList<>();
        for(TreatmentDeviceEnum dEnum : TreatmentDeviceEnum.values()){
            String titleEnum = convertEnumToTitle(dEnum.getName());
            deviceList.add(titleEnum);
        }
        sortList(deviceList);
        
        this.deviceUsedComboBox.setModel(new DefaultComboBoxModel<>(deviceList.toArray(String[]::new)));
    }

    private void buildRouteUsed(){
        List<String> routeList = new ArrayList<>();
        for(MedicationAdministrationRouteEnum mEnum : MedicationAdministrationRouteEnum.values()){
            String titleEnum = convertEnumToTitle(mEnum.getName());
            routeList.add(titleEnum);
        }
        sortList(routeList);
            
        this.routeComboBox.setModel(new DefaultComboBoxModel<>(routeList.toArray(String[]::new)));
        
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

    public JComboBox getPhysicalComboBox(){
        return this.physicalComboBox;
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

        physicalTreatmentPane = new javax.swing.JPanel();
        physicalRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        physicalComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        deviceUsedComboBox = new javax.swing.JComboBox<>();
        treatmentActiveCheckBox = new javax.swing.JCheckBox();
        medicinalTreatmentPane = new javax.swing.JPanel();
        medicationRadioButton = new javax.swing.JRadioButton();
        medicationLabel = new javax.swing.JLabel();
        viaRouteLabel = new javax.swing.JLabel();
        dosageJLabel = new javax.swing.JLabel();
        periodJLabel = new javax.swing.JLabel();
        routeComboBox = new javax.swing.JComboBox<>();
        dosageTextField = new javax.swing.JTextField();
        periodTextField = new javax.swing.JTextField();
        minutesLabel = new javax.swing.JLabel();
        dosageActiveCheckBox = new javax.swing.JCheckBox();
        medicationNameComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        treatmentIdJLabel = new javax.swing.JLabel();
        patientIdLabel = new javax.swing.JLabel();
        treatmentIdTextField = new javax.swing.JTextField();
        injuryIdTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        requiredLabel = new javax.swing.JLabel();
        selectTreatmentPane = new javax.swing.JPanel();
        selectTreatmentLabel = new javax.swing.JLabel();
        selectPhysicalTreatmentButton = new javax.swing.JButton();
        selectMedicinalTreatmentButton = new javax.swing.JButton();
        treatmentLocationPane = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        physicalTreatmentPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Physical"));

        physicalRadioButton.setText("Physical Treatment");
        physicalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physicalRadioButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Treatment Type:");

        physicalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        jLabel7.setText("Device Used:");

        deviceUsedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        treatmentActiveCheckBox.setSelected(true);
        treatmentActiveCheckBox.setText("Treatment Active");
        treatmentActiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentActiveCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout physicalTreatmentPaneLayout = new javax.swing.GroupLayout(physicalTreatmentPane);
        physicalTreatmentPane.setLayout(physicalTreatmentPaneLayout);
        physicalTreatmentPaneLayout.setHorizontalGroup(
            physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(physicalTreatmentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(physicalRadioButton)
                    .addGroup(physicalTreatmentPaneLayout.createSequentialGroup()
                        .addGroup(physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(physicalComboBox, 0, 296, Short.MAX_VALUE)
                            .addComponent(deviceUsedComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(treatmentActiveCheckBox))
                .addContainerGap())
        );
        physicalTreatmentPaneLayout.setVerticalGroup(
            physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(physicalTreatmentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(physicalRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(physicalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(physicalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(deviceUsedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treatmentActiveCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicinalTreatmentPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Medication"));

        medicationRadioButton.setText("Medication Treatment");
        medicationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicationRadioButtonActionPerformed(evt);
            }
        });

        medicationLabel.setText("Medication Name:");

        viaRouteLabel.setText("via:");

        dosageJLabel.setText("Dosage:");

        periodJLabel.setText("(mg or ml) every ");

        routeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        minutesLabel.setText("minutes");

        dosageActiveCheckBox.setSelected(true);
        dosageActiveCheckBox.setText("Dosage Active");

        medicationNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medication Names" }));

        javax.swing.GroupLayout medicinalTreatmentPaneLayout = new javax.swing.GroupLayout(medicinalTreatmentPane);
        medicinalTreatmentPane.setLayout(medicinalTreatmentPaneLayout);
        medicinalTreatmentPaneLayout.setHorizontalGroup(
            medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                        .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, medicinalTreatmentPaneLayout.createSequentialGroup()
                                .addComponent(dosageActiveCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viaRouteLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, medicinalTreatmentPaneLayout.createSequentialGroup()
                                .addComponent(dosageJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dosageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodJLabel)))
                        .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutesLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, medicinalTreatmentPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(routeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                        .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medicationRadioButton)
                            .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                                .addComponent(medicationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(medicationNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        medicinalTreatmentPaneLayout.setVerticalGroup(
            medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicinalTreatmentPaneLayout.createSequentialGroup()
                .addComponent(medicationRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medicationLabel)
                    .addComponent(medicationNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosageJLabel)
                    .addComponent(dosageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodJLabel)
                    .addComponent(periodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dosageActiveCheckBox)
                    .addGroup(medicinalTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viaRouteLabel)
                        .addComponent(routeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 480));
        setModal(true);
        setSize(new java.awt.Dimension(1300, 480));

        jLabel1.setText("Patient ID:");

        treatmentIdJLabel.setText("Treatment ID:");

        patientIdLabel.setText("1234567890");

        jLabel6.setText("Injury ID:");

        requiredLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        requiredLabel.setText("(Required)");

        selectTreatmentPane.setPreferredSize(new java.awt.Dimension(545, 363));

        selectTreatmentLabel.setText("Select Treatment Type:");

        selectPhysicalTreatmentButton.setText("Physical Treatment");
        selectPhysicalTreatmentButton.setMaximumSize(new java.awt.Dimension(155, 70));
        selectPhysicalTreatmentButton.setMinimumSize(new java.awt.Dimension(155, 70));
        selectPhysicalTreatmentButton.setPreferredSize(new java.awt.Dimension(155, 70));
        selectPhysicalTreatmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPhysicalTreatmentButtonActionPerformed(evt);
            }
        });

        selectMedicinalTreatmentButton.setText("Medication Treatment");
        selectMedicinalTreatmentButton.setMaximumSize(new java.awt.Dimension(155, 70));
        selectMedicinalTreatmentButton.setMinimumSize(new java.awt.Dimension(155, 70));
        selectMedicinalTreatmentButton.setPreferredSize(new java.awt.Dimension(155, 70));
        selectMedicinalTreatmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMedicinalTreatmentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectTreatmentPaneLayout = new javax.swing.GroupLayout(selectTreatmentPane);
        selectTreatmentPane.setLayout(selectTreatmentPaneLayout);
        selectTreatmentPaneLayout.setHorizontalGroup(
            selectTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectTreatmentPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(selectTreatmentLabel)
                .addGap(18, 18, 18)
                .addComponent(selectPhysicalTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(selectMedicinalTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        selectTreatmentPaneLayout.setVerticalGroup(
            selectTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectTreatmentPaneLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(selectTreatmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectTreatmentLabel)
                    .addComponent(selectPhysicalTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectMedicinalTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        treatmentLocationPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Treatment Location"));

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

        javax.swing.GroupLayout treatmentLocationPaneLayout = new javax.swing.GroupLayout(treatmentLocationPane);
        treatmentLocationPane.setLayout(treatmentLocationPaneLayout);
        treatmentLocationPaneLayout.setHorizontalGroup(
            treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                        .addComponent(fmaidLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fmaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                            .addComponent(skeletalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(detailedAnatomyPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                            .addComponent(sagittalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(transversePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(coronalPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                            .addComponent(genRegionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(regionTissuePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(internalAnatomyPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        treatmentLocationPaneLayout.setVerticalGroup(
            treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genRegionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(internalAnatomyPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regionTissuePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sagittalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coronalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transversePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(skeletalPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailedAnatomyPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmaidLabel)
                    .addComponent(fmaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(treatmentIdJLabel)
                                    .addComponent(jLabel6))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(injuryIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(patientIdLabel)
                                    .addComponent(treatmentIdTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(requiredLabel))
                            .addComponent(treatmentLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(selectTreatmentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1038, 1038, 1038)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(patientIdLabel))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(treatmentIdJLabel)
                            .addComponent(treatmentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requiredLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(injuryIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(treatmentLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectTreatmentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean hasErrors = false;
        //all treatments
        String treatmentId = null;
        String injuryId = null;
        BodyLocationRecord bodyLocation = null;
        //phsyical treatments only
        String treatmentType = null;
        String deviceUsed = null;
        Boolean treatmentActive = null;
        //medication treatments only
        MedicationEnum medication = null;
        String route = null;
        Float dosage = null;
        Integer period = null;
        Boolean dosageActive = null;
        
        //reset colors in cases there errors in the past
        this.treatmentIdJLabel.setForeground(Color.black);
        this.dosageJLabel.setForeground(Color.black);
        
        if(!nullOrEmpty(treatmentIdTextField.getText())){
            treatmentId = treatmentIdTextField.getText();        
        }else{
            this.treatmentIdJLabel.setForeground(Color.red);
            hasErrors = true;
        }
        
        if(!nullOrEmpty(this.injuryIdTextField.getText())){
            injuryId = this.injuryIdTextField.getText();
        }
        
        // Setting BodyLocationRecord
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
        
        if(this.physicalTreatmentSelected){
            PhysicalTreatment treatment = new PhysicalTreatment();
            treatment.setTreatmentId(treatmentId);
            treatment.setInjuryId(injuryId);
            treatment.setTreatmentLocation(bodyLocation);
            
            if(this.physicalComboBox.getSelectedIndex() >= 0){
                String treatmentTypeTitle = this.physicalComboBox.getSelectedItem().toString();
                
                treatmentType = revertTitleToEnumString(treatmentTypeTitle);
            }
            
            if(this.deviceUsedComboBox.getSelectedIndex() >= 0){
                String deviceUsedTitle = this.deviceUsedComboBox.getSelectedItem().toString();
                
                deviceUsed = revertTitleToEnumString(deviceUsedTitle);
            }
            treatmentActive = this.treatmentActiveCheckBox.isSelected();
            
            treatment.setTreatment(treatmentType);
            treatment.setDeviceUsed(deviceUsed);
            treatment.setTeatmentActive(treatmentActive);
            if(!hasErrors){
                this.setVisible(false);
                UiCommandHandler.getUiCommandHandler().createPhysicalTreatment(treatment);
            }
        }else{
            MedicationTreatment treatment = new MedicationTreatment();
            
            treatment.setTreatmentId(treatmentId);
            treatment.setInjuryId(injuryId);
            treatment.setTreatmentLocation(bodyLocation);
            
            String medTitle = this.medicationNameComboBox.getSelectedItem().toString();
            medication = MedicationEnum.find(titleStringToEnumName(medTitle));
            
            if(this.routeComboBox.getSelectedIndex() > 0){
                String routeTitle = this.routeComboBox.getSelectedItem().toString();
                
                route = revertTitleToEnumString(routeTitle);
            }
            if(!nullOrEmpty(this.dosageTextField.getText())){
                try{
                    dosage = Float.parseFloat(this.dosageTextField.getText());
                }catch(NumberFormatException ne){
                    this.dosageJLabel.setForeground(Color.red);
                    hasErrors = true;
                }
            }
            if(!nullOrEmpty(this.periodTextField.getText())){
                try{
                    period = Integer.parseInt(this.periodTextField.getText());
                }catch(NumberFormatException ne){
                    this.periodJLabel.setForeground(Color.red);
                    hasErrors = true;
                }
            }
            dosageActive = this.dosageActiveCheckBox.isSelected();
            
            treatment.setMedicationName(medication);
            treatment.setRoute(route);
            treatment.setDosage(dosage);
            treatment.setPeriod(period);
            treatment.setDosageActive(dosageActive);
            if(!hasErrors){
                this.setVisible(false);
                UiCommandHandler.getUiCommandHandler().createMedicationTreatment(treatment);
            }
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

    private void physicalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physicalRadioButtonActionPerformed
        switchTreatmentType(true);
    }//GEN-LAST:event_physicalRadioButtonActionPerformed

    private void treatmentActiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentActiveCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_treatmentActiveCheckBoxActionPerformed

    private void medicationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicationRadioButtonActionPerformed
        switchTreatmentType(false);
    }//GEN-LAST:event_medicationRadioButtonActionPerformed

    private void selectPhysicalTreatmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPhysicalTreatmentButtonActionPerformed
        
        if (this.medicinalTreatmentPane.isShowing()) {
            selectTreatmentPane.remove(this.medicinalTreatmentPane);
        }
        Container contentPane = getContentPane();
        
        this.physicalTreatmentPane.setBounds(this.selectTreatmentLabel.getX() + 30, 
                this.selectTreatmentLabel.getY() + 70, 431, 175);
        this.selectTreatmentPane.add(this.physicalTreatmentPane);
        switchTreatmentType(true);

        contentPane.validate();
        contentPane.repaint();
        this.pack();
    }//GEN-LAST:event_selectPhysicalTreatmentButtonActionPerformed

    private void selectMedicinalTreatmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMedicinalTreatmentButtonActionPerformed
        
        if (this.physicalTreatmentPane.isShowing()) {
            selectTreatmentPane.remove(this.physicalTreatmentPane);
        }
        Container contentPane = getContentPane();
        
        this.medicinalTreatmentPane.setBounds(this.selectTreatmentLabel.getX() - 10, 
                this.selectTreatmentLabel.getY() + 50, 530, 200);
        this.selectTreatmentPane.add(this.medicinalTreatmentPane);
        switchTreatmentType(false);

        contentPane.validate();
        contentPane.repaint();
        this.pack();
    }//GEN-LAST:event_selectMedicinalTreatmentButtonActionPerformed

    private void fmaidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmaidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmaidTextFieldActionPerformed

    
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
            java.util.logging.Logger.getLogger(NewTreatmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewTreatmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewTreatmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewTreatmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewTreatmentDialog dialog = new NewTreatmentDialog(new javax.swing.JFrame(), true);
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
    
    private void switchTreatmentType(boolean toPhysical){
        physicalTreatmentSelected = toPhysical;
        if(toPhysical){
            //disable
            this.medicationRadioButton.setSelected(false);
            this.medicationNameComboBox.setEnabled(false);
            this.routeComboBox.setEnabled(false);
            this.dosageTextField.setEnabled(false);
            this.periodTextField.setEnabled(false);
            this.dosageActiveCheckBox.setEnabled(false);
            //enable
            this.physicalRadioButton.setSelected(true);
            this.physicalComboBox.setEnabled(true);
            this.deviceUsedComboBox.setEnabled(true);
            this.treatmentActiveCheckBox.setEnabled(true);
        }else{
            //enable
            this.medicationRadioButton.setSelected(true);
            this.medicationNameComboBox.setEnabled(true);
            this.routeComboBox.setEnabled(true);
            this.dosageTextField.setEnabled(true);
            this.periodTextField.setEnabled(true);
            this.dosageActiveCheckBox.setEnabled(true);
            //disable
            this.physicalRadioButton.setSelected(false);
            this.physicalComboBox.setEnabled(false);
            this.deviceUsedComboBox.setEnabled(false);
            this.treatmentActiveCheckBox.setEnabled(false);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> coronalComboBox;
    private javax.swing.JPanel coronalPane;
    private javax.swing.JComboBox<String> detailedAnatomyComboBox;
    private javax.swing.JPanel detailedAnatomyPane;
    private javax.swing.JComboBox<String> deviceUsedComboBox;
    private javax.swing.JCheckBox dosageActiveCheckBox;
    private javax.swing.JLabel dosageJLabel;
    private javax.swing.JTextField dosageTextField;
    private javax.swing.JLabel fmaidLabel;
    private javax.swing.JTextField fmaidTextField;
    private javax.swing.JComboBox<String> genRegionComboBox;
    private javax.swing.JPanel genRegionPane;
    private javax.swing.JTextField injuryIdTextField;
    private javax.swing.JComboBox<String> internalAnatomyComboBox;
    private javax.swing.JPanel internalAnatomyPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel medicationLabel;
    private javax.swing.JComboBox<String> medicationNameComboBox;
    private javax.swing.JRadioButton medicationRadioButton;
    private javax.swing.JPanel medicinalTreatmentPane;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel patientIdLabel;
    private javax.swing.JLabel periodJLabel;
    private javax.swing.JTextField periodTextField;
    private javax.swing.JComboBox<String> physicalComboBox;
    private javax.swing.JRadioButton physicalRadioButton;
    private javax.swing.JPanel physicalTreatmentPane;
    private javax.swing.JComboBox<String> regionTissueComboBox;
    private javax.swing.JPanel regionTissuePane;
    private javax.swing.JLabel requiredLabel;
    private javax.swing.JComboBox<String> routeComboBox;
    private javax.swing.JComboBox<String> sagittalComboBox;
    private javax.swing.JPanel sagittalPane;
    private javax.swing.JButton selectMedicinalTreatmentButton;
    private javax.swing.JButton selectPhysicalTreatmentButton;
    private javax.swing.JLabel selectTreatmentLabel;
    private javax.swing.JPanel selectTreatmentPane;
    private javax.swing.JComboBox<String> skeletalComboBox;
    private javax.swing.JPanel skeletalPane;
    private javax.swing.JComboBox<String> transverseComboBox;
    private javax.swing.JPanel transversePane;
    private javax.swing.JCheckBox treatmentActiveCheckBox;
    private javax.swing.JLabel treatmentIdJLabel;
    private javax.swing.JTextField treatmentIdTextField;
    private javax.swing.JPanel treatmentLocationPane;
    private javax.swing.JLabel viaRouteLabel;
    // End of variables declaration//GEN-END:variables
}
