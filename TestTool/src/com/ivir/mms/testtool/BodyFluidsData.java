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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 */
public class BodyFluidsData implements TableModel{
    private HashMap<String, HlaBodyFluids> instanceNameToHlaObjMap = new HashMap<>();
    private ArrayList<String> instanceNameOrderList = new ArrayList<>();
    private ArrayList<TableModelListener> tableModelListeners = new ArrayList<>();
    
    public void add(HlaBodyFluids bodyFluids){
        this.instanceNameOrderList.add(bodyFluids.getHlaInstanceName());
        this.instanceNameToHlaObjMap.put(bodyFluids.getHlaInstanceName(), bodyFluids);
        fireTableChanged();
    }

    public void clearTable(){
	instanceNameToHlaObjMap.clear();
	instanceNameOrderList.clear();
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
            case 1: return "Patient ID";
            case 2: return "Blood Loss Rate";
            case 3: return "Blood Volume";
            case 4: return "Sweat Rate";
            case 5: return "Urine Output";
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
        HlaBodyFluids bodyFluids = this.instanceNameToHlaObjMap.get(this.instanceNameOrderList.get(rowIndex));
        switch(columnIndex){
            case 0: 
                return toStringOrEmpty(bodyFluids.isLocal());
            case 1:
                return bodyFluids.getPatientId("empty");
            case 2:
                return toStringOrEmpty(bodyFluids.getBloodLossRate(0));
            case 3:
                return toStringOrEmpty(bodyFluids.getBloodVolume(0));
            case 4:
                return toStringOrEmpty(bodyFluids.getSweatRate(0));
            case 5:
                return toStringOrEmpty(bodyFluids.getUrineOutputRate(0));
            default: return null;
        }        
    }

    public String toStringOrEmpty(Float fltValue){
        if(fltValue == null){
            return "empty";
        }
        return String.valueOf(fltValue);
    }
    
    public String toStringOrEmpty(Boolean boolValue){
        if(boolValue == null){
            return "empty";
        }
        if(boolValue){
            return "yes";
        }else{
            return "no";
        }
    }
    
    public List<BodyFluidsComboBoxItem> getComboBoxItemList(){
        ArrayList<BodyFluidsComboBoxItem> listItem = new ArrayList<>();
        this.instanceNameOrderList.forEach((instanceName)->{
            HlaBodyFluids obj = this.instanceNameToHlaObjMap.get(instanceName);
            listItem.add(new BodyFluidsComboBoxItem(instanceName,obj.getPatientId(null)));
        });
        return listItem;
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
