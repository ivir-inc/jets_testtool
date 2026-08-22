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

import devstudio.generatedcode.datatypes.BladeTypeEnum;
import devstudio.generatedcode.datatypes.BlastTypeEnum;
import devstudio.generatedcode.datatypes.BodyLocationRecord;
import devstudio.generatedcode.datatypes.CBRNTypeEnum;
import devstudio.generatedcode.datatypes.CoronalPlaneEnum;
import devstudio.generatedcode.datatypes.DetailedAnatomyEnum;
import devstudio.generatedcode.datatypes.FallTypeEnum;
import devstudio.generatedcode.datatypes.GeneralRegionEnum;
import devstudio.generatedcode.datatypes.GunshotAmmunitionTypeEnum;
import devstudio.generatedcode.datatypes.GunshotCaliberEnum;
import devstudio.generatedcode.datatypes.InjuryDescriptionEnum;
import devstudio.generatedcode.datatypes.InjuryTypeEnum;
import devstudio.generatedcode.datatypes.InternalAnatomyEnum;
import devstudio.generatedcode.datatypes.MechanismOfInjuryRecord;
import devstudio.generatedcode.datatypes.RegionTissueTypeEnum;
import devstudio.generatedcode.datatypes.SagittalPlaneEnum;
import devstudio.generatedcode.datatypes.ShrapnelTypeEnum;
import devstudio.generatedcode.datatypes.SkeletalSystemEnum;
import devstudio.generatedcode.datatypes.TransversePlaneEnum;
import devstudio.generatedcode.datatypes.VehicleCrashEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 */
public class NewInjuryDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewInjuryDialog
     */
    public NewInjuryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buildInjuryTypes();
        buildBodyLocationRecordOptions();
        buildInjuryDescriptions();
        buildMechanismOfInjury();
    }
    
    private void buildInjuryTypes(){
        List<String> injuryTypeList = new ArrayList<>();
        for(InjuryTypeEnum injuryType : InjuryTypeEnum.values()){
            String titleEnum = convertEnumToTitle(injuryType.getName());
            injuryTypeList.add(titleEnum);
        }
        sortList(injuryTypeList);
        
        this.injuryTypeCBox.setModel(new DefaultComboBoxModel<>(injuryTypeList.toArray(String[]::new)));
    }
    
    private void buildInjuryDescriptions() {
        List<String> injuryDescriptionList = new ArrayList<>();
        for(InjuryDescriptionEnum injuryDesc : InjuryDescriptionEnum.values()) {
            String titleEnum = convertEnumToTitle(injuryDesc.getName());
            injuryDescriptionList.add(titleEnum);
        }
        sortList(injuryDescriptionList);
        
        this.injuryDescComboBox.setModel(new DefaultComboBoxModel<>(injuryDescriptionList.toArray(String[]::new)));
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
    
    private void buildMechanismOfInjury() {
        
        // Gunshot Caliber
        List<String> gunshotCaliberList = new ArrayList<>();
        for(GunshotCaliberEnum caliberEnum : GunshotCaliberEnum.values()) {
            String titleEnum = convertEnumToTitle(caliberEnum.getName());
            gunshotCaliberList.add(titleEnum);
        }
        sortList(gunshotCaliberList);
        this.gunshotCaliberComboBox.setModel(new DefaultComboBoxModel<>(gunshotCaliberList.toArray(String[]::new)));
        
        // Gunshot Ammunition Type
        List<String> gunshotAmmoList = new ArrayList<>();
        for(GunshotAmmunitionTypeEnum ammoEnum : GunshotAmmunitionTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(ammoEnum.getName());
            gunshotAmmoList.add(titleEnum);
        }
        sortList(gunshotAmmoList);
        this.gunshotAmmoTypeComboBox.setModel(new DefaultComboBoxModel<>(gunshotAmmoList.toArray(String[]::new)));
        
        // Blade Type
        List<String> bladeList = new ArrayList<>();
        for(BladeTypeEnum bladeEnum : BladeTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(bladeEnum.getName());
            bladeList.add(titleEnum);
        }
        sortList(bladeList);
        this.bladeComboBox.setModel(new DefaultComboBoxModel<>(bladeList.toArray(String[]::new)));
        
        // Blast Type
        List<String> blastList = new ArrayList<>();
        for(BlastTypeEnum blastEnum : BlastTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(blastEnum.getName());
            blastList.add(titleEnum);
        }
        sortList(blastList);
        this.blastComboBox.setModel(new DefaultComboBoxModel<>(blastList.toArray(String[]::new)));
        
        // Vehicle Crash
        List<String> vehicleCrashList = new ArrayList<>();
        for(VehicleCrashEnum crashEnum : VehicleCrashEnum.values()) {
            String titleEnum = convertEnumToTitle(crashEnum.getName());
            vehicleCrashList.add(titleEnum);
        }
        sortList(vehicleCrashList);
        this.vehicleCrashComboBox.setModel(new DefaultComboBoxModel<>(vehicleCrashList.toArray(String[]::new)));
        
        // Fall Type
        List<String> fallList = new ArrayList<>();
        for(FallTypeEnum fallEnum : FallTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(fallEnum.getName());
            fallList.add(titleEnum);
        }
        sortList(fallList);
        this.fallComboBox.setModel(new DefaultComboBoxModel<>(fallList.toArray(String[]::new)));
        
        // CBRN Type (Chemical Burn)
        List<String> cbrnList = new ArrayList<>();
        for(CBRNTypeEnum cbrnEnum : CBRNTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(cbrnEnum.getName());
            cbrnList.add(titleEnum);
        }
        sortList(cbrnList);
        this.cbrnComboBox.setModel(new DefaultComboBoxModel<>(cbrnList.toArray(String[]::new)));
        
        // Shrapnel Type
        List<String> shrapnelList = new ArrayList<>();
        for(ShrapnelTypeEnum shrapnelEnum : ShrapnelTypeEnum.values()) {
            String titleEnum = convertEnumToTitle(shrapnelEnum.getName());
            shrapnelList.add(titleEnum);
        }
        sortList(shrapnelList);
        this.shrapnelComboBox.setModel(new DefaultComboBoxModel<>(shrapnelList.toArray(String[]::new)));
        
        
    }
    
    private void sortList(List list) {
        Collections.sort(list);
        int naIndex = list.indexOf("Not Applicable");
        if (naIndex != -1) {
            list.remove(naIndex);
            list.add(0, "Not Applicable");
        }
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

        injuryButtonGroup = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        generalPanel = new javax.swing.JPanel();
        necessaryAttributePane = new javax.swing.JPanel();
        patientIdPanel = new javax.swing.JPanel();
        patientIdLabel = new javax.swing.JLabel();
        patientIdTField = new javax.swing.JTextField();
        injuryIdPanel = new javax.swing.JPanel();
        injuryIdLabel = new javax.swing.JLabel();
        injuryIdTField = new javax.swing.JTextField();
        timePanel = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        timeTField = new javax.swing.JTextField();
        injuryTypePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        injuryTypeCBox = new javax.swing.JComboBox<>();
        serverityPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        severityTField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        descrptionPanel = new javax.swing.JPanel();
        descLabel = new javax.swing.JLabel();
        injuryDescComboBox = new javax.swing.JComboBox<>();
        optionalFieldPane = new javax.swing.JPanel();
        hemorrhageRatePane = new javax.swing.JPanel();
        hemorrhageRateLabel = new javax.swing.JLabel();
        hemorrhageRateTField = new javax.swing.JTextField();
        totalBodySAPane = new javax.swing.JPanel();
        totalBodySALabel = new javax.swing.JLabel();
        totalbodySATField = new javax.swing.JTextField();
        injuryDetail = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        injuryDetailTextArea = new javax.swing.JTextArea();
        mechanismOfInjuryPane = new javax.swing.JPanel();
        gunshotCaliberPane = new javax.swing.JPanel();
        gunshotCaliberComboBox = new javax.swing.JComboBox<>();
        gunshotAmmoTypePane = new javax.swing.JPanel();
        gunshotAmmoTypeComboBox = new javax.swing.JComboBox<>();
        bladePane = new javax.swing.JPanel();
        bladeComboBox = new javax.swing.JComboBox<>();
        vehicleCrashPane = new javax.swing.JPanel();
        vehicleCrashComboBox = new javax.swing.JComboBox<>();
        cbrnPane = new javax.swing.JPanel();
        cbrnComboBox = new javax.swing.JComboBox<>();
        blastPane = new javax.swing.JPanel();
        blastComboBox = new javax.swing.JComboBox<>();
        fallPane = new javax.swing.JPanel();
        fallComboBox = new javax.swing.JComboBox<>();
        shrapnelPane = new javax.swing.JPanel();
        shrapnelComboBox = new javax.swing.JComboBox<>();
        buttonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        patientIdTField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1265, 750));
        setPreferredSize(new java.awt.Dimension(1265, 750));
        setSize(new java.awt.Dimension(1265, 750));

        titleLabel.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        titleLabel.setText("New Injury");

        mainPanel.setMinimumSize(new java.awt.Dimension(1215, 685));
        mainPanel.setPreferredSize(new java.awt.Dimension(1215, 685));

        generalPanel.setPreferredSize(new java.awt.Dimension(970, 233));

        patientIdLabel.setText("Patient ID");
        patientIdLabel.setMaximumSize(new java.awt.Dimension(60, 14));
        patientIdLabel.setMinimumSize(new java.awt.Dimension(60, 14));
        patientIdLabel.setOpaque(true);
        patientIdLabel.setPreferredSize(new java.awt.Dimension(60, 14));

        patientIdTField.setToolTipText("");
        patientIdTField.setMaximumSize(new java.awt.Dimension(120, 25));
        patientIdTField.setMinimumSize(new java.awt.Dimension(120, 25));
        patientIdTField.setName(""); // NOI18N
        patientIdTField.setPreferredSize(new java.awt.Dimension(120, 25));
        patientIdTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientIdTFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientIdPanelLayout = new javax.swing.GroupLayout(patientIdPanel);
        patientIdPanel.setLayout(patientIdPanelLayout);
        patientIdPanelLayout.setHorizontalGroup(
            patientIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientIdPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(patientIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patientIdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientIdPanelLayout.setVerticalGroup(
            patientIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientIdPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(patientIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientIdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        injuryIdLabel.setText("Injury ID");
        injuryIdLabel.setMaximumSize(new java.awt.Dimension(60, 14));
        injuryIdLabel.setMinimumSize(new java.awt.Dimension(60, 14));
        injuryIdLabel.setName(""); // NOI18N
        injuryIdLabel.setPreferredSize(new java.awt.Dimension(60, 14));

        injuryIdTField.setToolTipText("");
        injuryIdTField.setMaximumSize(new java.awt.Dimension(120, 25));
        injuryIdTField.setMinimumSize(new java.awt.Dimension(120, 25));
        injuryIdTField.setName(""); // NOI18N
        injuryIdTField.setPreferredSize(new java.awt.Dimension(120, 25));

        javax.swing.GroupLayout injuryIdPanelLayout = new javax.swing.GroupLayout(injuryIdPanel);
        injuryIdPanel.setLayout(injuryIdPanelLayout);
        injuryIdPanelLayout.setHorizontalGroup(
            injuryIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryIdPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(injuryIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(injuryIdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        injuryIdPanelLayout.setVerticalGroup(
            injuryIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryIdPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(injuryIdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(injuryIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(injuryIdTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        timeLabel.setText("Time");
        timeLabel.setFocusable(false);
        timeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        timeLabel.setMaximumSize(new java.awt.Dimension(60, 14));
        timeLabel.setMinimumSize(new java.awt.Dimension(60, 14));
        timeLabel.setPreferredSize(new java.awt.Dimension(60, 14));

        timeTField.setToolTipText("");
        timeTField.setMaximumSize(new java.awt.Dimension(120, 25));
        timeTField.setMinimumSize(new java.awt.Dimension(120, 25));
        timeTField.setName(""); // NOI18N
        timeTField.setPreferredSize(new java.awt.Dimension(120, 25));

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(timeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jLabel5.setText("InjuryType");
        jLabel5.setMaximumSize(new java.awt.Dimension(60, 14));
        jLabel5.setMinimumSize(new java.awt.Dimension(60, 14));
        jLabel5.setName(""); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 14));

        injuryTypeCBox.setMaximumSize(new java.awt.Dimension(220, 25));
        injuryTypeCBox.setMinimumSize(new java.awt.Dimension(220, 25));
        injuryTypeCBox.setName(""); // NOI18N
        injuryTypeCBox.setPreferredSize(new java.awt.Dimension(220, 25));

        javax.swing.GroupLayout injuryTypePanelLayout = new javax.swing.GroupLayout(injuryTypePanel);
        injuryTypePanel.setLayout(injuryTypePanelLayout);
        injuryTypePanelLayout.setHorizontalGroup(
            injuryTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryTypePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(injuryTypeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        injuryTypePanelLayout.setVerticalGroup(
            injuryTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryTypePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(injuryTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(injuryTypeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jLabel6.setText("Severity");
        jLabel6.setMaximumSize(new java.awt.Dimension(60, 14));
        jLabel6.setMinimumSize(new java.awt.Dimension(60, 14));
        jLabel6.setName(""); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 14));

        severityTField.setToolTipText("");
        severityTField.setMaximumSize(new java.awt.Dimension(40, 25));
        severityTField.setMinimumSize(new java.awt.Dimension(40, 25));
        severityTField.setName(""); // NOI18N
        severityTField.setPreferredSize(new java.awt.Dimension(40, 25));
        severityTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                severityTFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel1.setText("(0-10)");

        javax.swing.GroupLayout serverityPanelLayout = new javax.swing.GroupLayout(serverityPanel);
        serverityPanel.setLayout(serverityPanelLayout);
        serverityPanelLayout.setHorizontalGroup(
            serverityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverityPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(severityTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        serverityPanelLayout.setVerticalGroup(
            serverityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverityPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(serverityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(severityTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6))
        );

        descLabel.setText("Description");
        descLabel.setMaximumSize(new java.awt.Dimension(60, 14));
        descLabel.setMinimumSize(new java.awt.Dimension(60, 14));
        descLabel.setPreferredSize(new java.awt.Dimension(60, 14));

        injuryDescComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout descrptionPanelLayout = new javax.swing.GroupLayout(descrptionPanel);
        descrptionPanel.setLayout(descrptionPanelLayout);
        descrptionPanelLayout.setHorizontalGroup(
            descrptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descrptionPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(injuryDescComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        descrptionPanelLayout.setVerticalGroup(
            descrptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descrptionPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(descrptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(injuryDescComboBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout necessaryAttributePaneLayout = new javax.swing.GroupLayout(necessaryAttributePane);
        necessaryAttributePane.setLayout(necessaryAttributePaneLayout);
        necessaryAttributePaneLayout.setHorizontalGroup(
            necessaryAttributePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, necessaryAttributePaneLayout.createSequentialGroup()
                .addGroup(necessaryAttributePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverityPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descrptionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(injuryTypePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(injuryIdPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientIdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        necessaryAttributePaneLayout.setVerticalGroup(
            necessaryAttributePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(necessaryAttributePaneLayout.createSequentialGroup()
                .addComponent(patientIdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(injuryIdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(injuryTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(descrptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        optionalFieldPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Optional Fields"));

        hemorrhageRatePane.setBorder(javax.swing.BorderFactory.createTitledBorder("HemorrhageRate"));

        hemorrhageRateLabel.setText("mL/min");

        hemorrhageRateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hemorrhageRateTFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hemorrhageRatePaneLayout = new javax.swing.GroupLayout(hemorrhageRatePane);
        hemorrhageRatePane.setLayout(hemorrhageRatePaneLayout);
        hemorrhageRatePaneLayout.setHorizontalGroup(
            hemorrhageRatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hemorrhageRatePaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(hemorrhageRateTField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hemorrhageRateLabel)
                .addContainerGap())
        );
        hemorrhageRatePaneLayout.setVerticalGroup(
            hemorrhageRatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hemorrhageRatePaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hemorrhageRatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hemorrhageRateLabel)
                    .addComponent(hemorrhageRateTField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        totalBodySAPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Body Surface Area"));

        totalBodySALabel.setText("% of body burned");

        javax.swing.GroupLayout totalBodySAPaneLayout = new javax.swing.GroupLayout(totalBodySAPane);
        totalBodySAPane.setLayout(totalBodySAPaneLayout);
        totalBodySAPaneLayout.setHorizontalGroup(
            totalBodySAPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalBodySAPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(totalbodySATField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalBodySALabel)
                .addGap(74, 74, 74))
        );
        totalBodySAPaneLayout.setVerticalGroup(
            totalBodySAPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalBodySAPaneLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(totalBodySAPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBodySALabel)
                    .addComponent(totalbodySATField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        injuryDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Injury Detail"));

        injuryDetailTextArea.setColumns(20);
        injuryDetailTextArea.setRows(5);
        jScrollPane1.setViewportView(injuryDetailTextArea);

        javax.swing.GroupLayout injuryDetailLayout = new javax.swing.GroupLayout(injuryDetail);
        injuryDetail.setLayout(injuryDetailLayout);
        injuryDetailLayout.setHorizontalGroup(
            injuryDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryDetailLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        injuryDetailLayout.setVerticalGroup(
            injuryDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuryDetailLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout optionalFieldPaneLayout = new javax.swing.GroupLayout(optionalFieldPane);
        optionalFieldPane.setLayout(optionalFieldPaneLayout);
        optionalFieldPaneLayout.setHorizontalGroup(
            optionalFieldPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionalFieldPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(optionalFieldPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(injuryDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(optionalFieldPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(totalBodySAPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hemorrhageRatePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        optionalFieldPaneLayout.setVerticalGroup(
            optionalFieldPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionalFieldPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hemorrhageRatePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalBodySAPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(injuryDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(necessaryAttributePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(optionalFieldPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(necessaryAttributePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(optionalFieldPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mechanismOfInjuryPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mechanism Of Injury"));
        mechanismOfInjuryPane.setPreferredSize(new java.awt.Dimension(960, 270));

        gunshotCaliberPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Gunshot Caliber"));

        gunshotCaliberComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout gunshotCaliberPaneLayout = new javax.swing.GroupLayout(gunshotCaliberPane);
        gunshotCaliberPane.setLayout(gunshotCaliberPaneLayout);
        gunshotCaliberPaneLayout.setHorizontalGroup(
            gunshotCaliberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gunshotCaliberPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(gunshotCaliberComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        gunshotCaliberPaneLayout.setVerticalGroup(
            gunshotCaliberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gunshotCaliberPaneLayout.createSequentialGroup()
                .addComponent(gunshotCaliberComboBox)
                .addContainerGap())
        );

        gunshotAmmoTypePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Gunshot Ammo Type"));

        gunshotAmmoTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout gunshotAmmoTypePaneLayout = new javax.swing.GroupLayout(gunshotAmmoTypePane);
        gunshotAmmoTypePane.setLayout(gunshotAmmoTypePaneLayout);
        gunshotAmmoTypePaneLayout.setHorizontalGroup(
            gunshotAmmoTypePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gunshotAmmoTypePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(gunshotAmmoTypeComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        gunshotAmmoTypePaneLayout.setVerticalGroup(
            gunshotAmmoTypePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gunshotAmmoTypePaneLayout.createSequentialGroup()
                .addComponent(gunshotAmmoTypeComboBox)
                .addContainerGap())
        );

        bladePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Blade Type"));

        bladeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout bladePaneLayout = new javax.swing.GroupLayout(bladePane);
        bladePane.setLayout(bladePaneLayout);
        bladePaneLayout.setHorizontalGroup(
            bladePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bladePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(bladeComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        bladePaneLayout.setVerticalGroup(
            bladePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bladePaneLayout.createSequentialGroup()
                .addComponent(bladeComboBox)
                .addContainerGap())
        );

        vehicleCrashPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehicle Crash"));

        vehicleCrashComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout vehicleCrashPaneLayout = new javax.swing.GroupLayout(vehicleCrashPane);
        vehicleCrashPane.setLayout(vehicleCrashPaneLayout);
        vehicleCrashPaneLayout.setHorizontalGroup(
            vehicleCrashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicleCrashPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(vehicleCrashComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        vehicleCrashPaneLayout.setVerticalGroup(
            vehicleCrashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicleCrashPaneLayout.createSequentialGroup()
                .addComponent(vehicleCrashComboBox)
                .addContainerGap())
        );

        cbrnPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Chemical Burn Type (CBRN)"));

        cbrnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout cbrnPaneLayout = new javax.swing.GroupLayout(cbrnPane);
        cbrnPane.setLayout(cbrnPaneLayout);
        cbrnPaneLayout.setHorizontalGroup(
            cbrnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbrnPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbrnComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        cbrnPaneLayout.setVerticalGroup(
            cbrnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbrnPaneLayout.createSequentialGroup()
                .addComponent(cbrnComboBox)
                .addContainerGap())
        );

        blastPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Blast Type"));

        blastComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout blastPaneLayout = new javax.swing.GroupLayout(blastPane);
        blastPane.setLayout(blastPaneLayout);
        blastPaneLayout.setHorizontalGroup(
            blastPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blastPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(blastComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        blastPaneLayout.setVerticalGroup(
            blastPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blastPaneLayout.createSequentialGroup()
                .addComponent(blastComboBox)
                .addContainerGap())
        );

        fallPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Fall Type"));

        fallComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout fallPaneLayout = new javax.swing.GroupLayout(fallPane);
        fallPane.setLayout(fallPaneLayout);
        fallPaneLayout.setHorizontalGroup(
            fallPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fallPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(fallComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        fallPaneLayout.setVerticalGroup(
            fallPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fallPaneLayout.createSequentialGroup()
                .addComponent(fallComboBox)
                .addContainerGap())
        );

        shrapnelPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Shrapnel Type"));

        shrapnelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));

        javax.swing.GroupLayout shrapnelPaneLayout = new javax.swing.GroupLayout(shrapnelPane);
        shrapnelPane.setLayout(shrapnelPaneLayout);
        shrapnelPaneLayout.setHorizontalGroup(
            shrapnelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shrapnelPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(shrapnelComboBox, 0, 138, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        shrapnelPaneLayout.setVerticalGroup(
            shrapnelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shrapnelPaneLayout.createSequentialGroup()
                .addComponent(shrapnelComboBox)
                .addContainerGap())
        );

        javax.swing.GroupLayout mechanismOfInjuryPaneLayout = new javax.swing.GroupLayout(mechanismOfInjuryPane);
        mechanismOfInjuryPane.setLayout(mechanismOfInjuryPaneLayout);
        mechanismOfInjuryPaneLayout.setHorizontalGroup(
            mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mechanismOfInjuryPaneLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mechanismOfInjuryPaneLayout.createSequentialGroup()
                        .addComponent(gunshotAmmoTypePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blastPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fallPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(shrapnelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mechanismOfInjuryPaneLayout.createSequentialGroup()
                        .addComponent(gunshotCaliberPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bladePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehicleCrashPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbrnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        mechanismOfInjuryPaneLayout.setVerticalGroup(
            mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mechanismOfInjuryPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gunshotCaliberPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bladePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicleCrashPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbrnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gunshotAmmoTypePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mechanismOfInjuryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(blastPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fallPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shrapnelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addButton.setText("Add");
        addButton.setToolTipText("");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
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

        jLabel2.setText("FMA ID");

        patientIdTField1.setToolTipText("");
        patientIdTField1.setMaximumSize(new java.awt.Dimension(120, 25));
        patientIdTField1.setMinimumSize(new java.awt.Dimension(120, 25));
        patientIdTField1.setName(""); // NOI18N
        patientIdTField1.setPreferredSize(new java.awt.Dimension(120, 25));
        patientIdTField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientIdTField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout treatmentLocationPaneLayout = new javax.swing.GroupLayout(treatmentLocationPane);
        treatmentLocationPane.setLayout(treatmentLocationPaneLayout);
        treatmentLocationPaneLayout.setHorizontalGroup(
            treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
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
                    .addGroup(treatmentLocationPaneLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(patientIdTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
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
                .addGap(18, 18, 18)
                .addGroup(treatmentLocationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientIdTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(treatmentLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mechanismOfInjuryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(treatmentLocationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(mechanismOfInjuryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))))
                .addGap(8, 8, 8))
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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
        
        // Setting Mechanism Of Injury
        String caliberTitle = this.gunshotCaliberComboBox.getSelectedItem().toString();
        String caliberName = titleStringToEnumName(caliberTitle);
        
        String ammoTypeTitle = this.gunshotAmmoTypeComboBox.getSelectedItem().toString();
        String ammoTypeName = titleStringToEnumName(ammoTypeTitle);
        
        String bladeTypeTitle = this.bladeComboBox.getSelectedItem().toString();
        String bladeTypeName = titleStringToEnumName(bladeTypeTitle);
        
        String blastTypeTitle = this.blastComboBox.getSelectedItem().toString();
        String blastTypeName = titleStringToEnumName(blastTypeTitle);
        
        String vehicleCrashTitle = this.vehicleCrashComboBox.getSelectedItem().toString();
        String vehicleCrashName = titleStringToEnumName(vehicleCrashTitle);
        
        String fallTypeTitle = this.fallComboBox.getSelectedItem().toString();
        String fallTypeName = titleStringToEnumName(fallTypeTitle);
        
        String cbrnTypeTitle = this.cbrnComboBox.getSelectedItem().toString();
        String cbrnTypeName = titleStringToEnumName(cbrnTypeTitle);
        
        String shrapnelTypeTitle = this.shrapnelComboBox.getSelectedItem().toString();
        String shrapnelTypeName = titleStringToEnumName(shrapnelTypeTitle);
        
        MechanismOfInjuryRecord mechOfInjury = MechanismOfInjuryRecord.create(
                GunshotCaliberEnum.find(caliberName), 
                GunshotAmmunitionTypeEnum.find(ammoTypeName), 
                BladeTypeEnum.find(bladeTypeName), 
                BlastTypeEnum.find(blastTypeName), 
                VehicleCrashEnum.find(vehicleCrashName), 
                FallTypeEnum.find(fallTypeName), 
                CBRNTypeEnum.find(cbrnTypeName), 
                ShrapnelTypeEnum.find(shrapnelTypeName));
        
        // Setting Injury Type
        String injuryTypeTitle = this.injuryTypeCBox.getSelectedItem().toString();
        String injuryTypeName = titleStringToEnumName(injuryTypeTitle);
        
        // Setting Injury Description
        String injuryDescTitle = this.injuryDescComboBox.getSelectedItem().toString();
        String injuryDescName = titleStringToEnumName(injuryDescTitle);
        
        // Setting Injury Detail
        String injuryDetail = this.injuryDetailTextArea.getText();
        
        
        UiCommandHandler.getUiCommandHandler().createInjury(
                this.patientIdTField.getText(), 
                this.injuryIdTField.getText(), 
                nullOrLong(this.timeTField.getText()), 
                bodyLocation, 
                InjuryTypeEnum.find(injuryTypeName),
                InjuryDescriptionEnum.find(injuryDescName), 
                injuryDetail, nullOrInteger(this.severityTField.getText()), 
                mechOfInjury, 
                nullOrFloat(this.hemorrhageRateTField.getText()), 
                nullOrFloat(this.totalbodySATField.getText()));

        this.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private String titleStringToEnumName(String title) {
        String enumName = Character.toLowerCase(title.charAt(0)) + title.substring(1);
        
        return enumName.replaceAll(" ","");
    }
    
    private boolean nullOrEmpty(String value){
        if(value == null){
            return true;
        }else if(value.length() < 1){
            return true;
        }
        return false;
    }
    
    private Long nullOrLong(String value){
        if(value == null){
            return null;
        }
        try{
            return Long.parseLong(value);
        }catch(Exception e){
            return null;
        }
    }
    
    private Integer nullOrInteger(String value){
        if(value == null){
            return null;
        }
        try{
            return Integer.parseInt(value);
        }catch(Exception e){
            return null;
        }
    }
    
    private String nullOrToString(Object obj){
        if(obj == null){
            return null;
        }
        return revertTitleToEnumString(obj.toString());
    }
    
    private String revertTitleToEnumString(String title) {
        return title.toUpperCase().replaceAll(" ", "_");
    }
    
    
    private Float nullOrFloat(String value){
        if(value == null){
            return null;
        }
        try{
            return Float.parseFloat(value);
        }catch(Exception e){
            return null;
        }
    }
    
    private void patientIdTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientIdTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientIdTFieldActionPerformed

    private void severityTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_severityTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_severityTFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void hemorrhageRateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hemorrhageRateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hemorrhageRateTFieldActionPerformed

    private void patientIdTField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientIdTField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientIdTField1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewInjuryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewInjuryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewInjuryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewInjuryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewInjuryDialog dialog = new NewInjuryDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> bladeComboBox;
    private javax.swing.JPanel bladePane;
    private javax.swing.JComboBox<String> blastComboBox;
    private javax.swing.JPanel blastPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cbrnComboBox;
    private javax.swing.JPanel cbrnPane;
    private javax.swing.JComboBox<String> coronalComboBox;
    private javax.swing.JPanel coronalPane;
    private javax.swing.JLabel descLabel;
    private javax.swing.JPanel descrptionPanel;
    private javax.swing.JComboBox<String> detailedAnatomyComboBox;
    private javax.swing.JPanel detailedAnatomyPane;
    private javax.swing.JComboBox<String> fallComboBox;
    private javax.swing.JPanel fallPane;
    private javax.swing.JComboBox<String> genRegionComboBox;
    private javax.swing.JPanel genRegionPane;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JComboBox<String> gunshotAmmoTypeComboBox;
    private javax.swing.JPanel gunshotAmmoTypePane;
    private javax.swing.JComboBox<String> gunshotCaliberComboBox;
    private javax.swing.JPanel gunshotCaliberPane;
    private javax.swing.JLabel hemorrhageRateLabel;
    private javax.swing.JPanel hemorrhageRatePane;
    private javax.swing.JTextField hemorrhageRateTField;
    private javax.swing.ButtonGroup injuryButtonGroup;
    private javax.swing.JComboBox<String> injuryDescComboBox;
    private javax.swing.JPanel injuryDetail;
    private javax.swing.JPanel injuryDetail1;
    private javax.swing.JTextArea injuryDetailTextArea;
    private javax.swing.JTextArea injuryDetailTextArea1;
    private javax.swing.JLabel injuryIdLabel;
    private javax.swing.JPanel injuryIdPanel;
    private javax.swing.JTextField injuryIdTField;
    private javax.swing.JComboBox<String> injuryTypeCBox;
    private javax.swing.JPanel injuryTypePanel;
    private javax.swing.JComboBox<String> internalAnatomyComboBox;
    private javax.swing.JPanel internalAnatomyPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mechanismOfInjuryPane;
    private javax.swing.JPanel necessaryAttributePane;
    private javax.swing.JPanel optionalFieldPane;
    private javax.swing.JLabel patientIdLabel;
    private javax.swing.JPanel patientIdPanel;
    private javax.swing.JTextField patientIdTField;
    private javax.swing.JTextField patientIdTField1;
    private javax.swing.JComboBox<String> regionTissueComboBox;
    private javax.swing.JPanel regionTissuePane;
    private javax.swing.JComboBox<String> sagittalComboBox;
    private javax.swing.JPanel sagittalPane;
    private javax.swing.JPanel serverityPanel;
    private javax.swing.JTextField severityTField;
    private javax.swing.JComboBox<String> shrapnelComboBox;
    private javax.swing.JPanel shrapnelPane;
    private javax.swing.JComboBox<String> skeletalComboBox;
    private javax.swing.JPanel skeletalPane;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel timePanel;
    private javax.swing.JTextField timeTField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalBodySALabel;
    private javax.swing.JPanel totalBodySAPane;
    private javax.swing.JTextField totalbodySATField;
    private javax.swing.JComboBox<String> transverseComboBox;
    private javax.swing.JPanel transversePane;
    private javax.swing.JPanel treatmentLocationPane;
    private javax.swing.JComboBox<String> vehicleCrashComboBox;
    private javax.swing.JPanel vehicleCrashPane;
    // End of variables declaration//GEN-END:variables
}
