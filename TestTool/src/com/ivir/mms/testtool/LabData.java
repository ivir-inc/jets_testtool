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

import devstudio.generatedcode.HlaBloodGasLab;
import devstudio.generatedcode.HlaBloodLab;
import devstudio.generatedcode.HlaUrineLab;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class LabData implements TableModel{

    private final HashMap<String, LabDataContainer> instanceNameToHlaObjMap = new HashMap<>();
    private final ArrayList<String> instanceNameOrderList = new ArrayList<>();
    private final ArrayList<TableModelListener> tableModelListeners = new ArrayList<>();

    public void add(HlaBloodGasLab hlaObj){
        LabDataContainer container = new LabDataContainer(hlaObj);
        this.instanceNameOrderList.add(container.getInstanceKey());        
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        fireTableChanged();
    }

    public void add(HlaBloodLab hlaObj){
        LabDataContainer container = new LabDataContainer(hlaObj);
        this.instanceNameOrderList.add(container.getInstanceKey());        
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        fireTableChanged();
    }

    public void add(HlaUrineLab hlaObj){
        LabDataContainer container = new LabDataContainer(hlaObj);
        this.instanceNameOrderList.add(container.getInstanceKey());        
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        fireTableChanged();
    }
    
    public void add(LabDataContainer container){
        this.instanceNameOrderList.add(container.getInstanceKey());        
        this.instanceNameToHlaObjMap.put(container.getInstanceKey(), container);
        fireTableChanged();
    }

    public void clear(){
	instanceNameOrderList.clear();
	instanceNameToHlaObjMap.clear();
	fireTableChanged();
    }
    
    public void fireTableChanged(){
        this.tableModelListeners.forEach((listener)->{
            listener.tableChanged(new TableModelEvent(this));
        });
    }

    
    //--------------------------------------------------------------------------
    //    Table Model Implementations
    //--------------------------------------------------------------------------    

    @Override
    public int getRowCount() {
        return instanceNameOrderList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Local";
            case 1: return "Time";
            case 2: return "Instance Name";
            case 3: return "Patient ID";
            case 4: return "Type";
            case 5: return "Labs";
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex >= this.instanceNameOrderList.size()){
            return null;
        }
       LabDataContainer dataContainer = this.instanceNameToHlaObjMap
               .get(this.instanceNameOrderList.get(rowIndex));
        switch(columnIndex){
                case 0: return String.valueOf(dataContainer.isLocal());
                case 1: return dataContainer.getTime();
                case 2: return dataContainer.getInstanceName();
                case 3: return dataContainer.getPatientId();
                case 4: return dataContainer.getTypeStr();
                case 5: return dataContainer.getLabData();
                default: return null;
        }
    }

    
    @Override
    public void setValueAt(Object o, int i, int i1) {
        //do nothing
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        this.tableModelListeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        this.tableModelListeners.remove(l);
    }
       
}
