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
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 */
public class InjuryData{

    private HashMap<String, InjuryDataContainer> instanceNameToHlaObjMap = new HashMap<>();
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    
    public InjuryData(){
	initializeData();
    }

    private void initializeData(){
        rootNode = new DefaultMutableTreeNode("Injuries");
        treeModel = new DefaultTreeModel(this.rootNode);
    }
    
    public DefaultTreeModel getTreeModel(){ 
        return this.treeModel;
    }
    
    
    public void add(InjuryDataContainer container){
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        addToTree(container);
    }
    
    public void add(HlaInjury hlaObj){
        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        addToTree(container);
    }

//    public void add(HlaBurnInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//
//    public void add(HlaChemicaIngestionlInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//    
//    public void add(HlaEnvenomationInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//
//    public void add(HlaHemorrhageInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//
//    public void add(HlaImmuneResponseInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//
//    public void add(HlaRadiationInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
//
//    public void add(HlaTissueDamageInjury hlaObj){
//        InjuryDataContainer container = new InjuryDataContainer(hlaObj);
//        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
//        addToTree(container);
//    }
    
    public void addToTree(InjuryDataContainer container){
        DefaultMutableTreeNode injuryNode = new DefaultMutableTreeNode(container.getPatientId() + " - " + container.getInjuryId());
        injuryNode.add(new DefaultMutableTreeNode("Instance:" + container.getInstanceName()));
        injuryNode.add(new DefaultMutableTreeNode("Injury Type:" + container.getInjuryType()));
        
        DefaultMutableTreeNode locNode = new DefaultMutableTreeNode("Location:");
        BodyLocationRecord location = container.getLocation();
        locNode.add(new DefaultMutableTreeNode(location));
       
//        for(String locStr : container.getLocation()){
//            locNode.add(new DefaultMutableTreeNode(locStr));
//        }
        injuryNode.add(locNode);
                
        injuryNode.add(new DefaultMutableTreeNode("Description:" + container.getDescription()));
        injuryNode.add(new DefaultMutableTreeNode("Time:" + container.getTime()));
        injuryNode.add(new DefaultMutableTreeNode("Severity: " + container.getServerity()));
        injuryNode.add(new DefaultMutableTreeNode("Hemorrhage Rate: " + container.getHemorrhageRate()));
        injuryNode.add(new DefaultMutableTreeNode("Total Body Surface Area: " + container.getTotalBodyArea()));

        DefaultMutableTreeNode objectNode = new DefaultMutableTreeNode("Object Type:" + container.getObjectTypeStr());
        for(String detail : container.getDetails()){
            objectNode.add(new DefaultMutableTreeNode(detail));
        }
        injuryNode.add(objectNode);

        
        this.rootNode.add(injuryNode);
        this.treeModel.reload();        
    }

    public void clear(){
    	instanceNameToHlaObjMap.clear();
	initializeData();
    }
    
}
