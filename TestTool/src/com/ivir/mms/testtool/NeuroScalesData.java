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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class NeuroScalesData implements TableModel{
    private final HashMap<String, HlaNeurologicalScales> instanceNameToHlaObjMap = new HashMap<>();
    private final ArrayList<String> instanceNameOrderList = new ArrayList<>();
    private final ArrayList<TableModelListener> tableModelListeners = new ArrayList<>();

    public void add(HlaNeurologicalScales hlaNeuroScales){
        this.instanceNameOrderList.add(hlaNeuroScales.getHlaInstanceName());
        this.instanceNameToHlaObjMap.put(hlaNeuroScales.getHlaInstanceName(), hlaNeuroScales);
        fireTableChanged();
    }

    public void clear(){
	this.instanceNameOrderList.clear();
	this.instanceNameToHlaObjMap.clear();
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
            case 1: return "Instance Name";
            case 2: return "Patient ID";
            case 3: return "Glasgow"; //GLASGOW_COMA_SCALE
            case 4: return "Response"; //LEVEL_OF_RESPONSE
            case 5: return "Consciousness"; //LEVEL_OF_CONSCIOUSNESS
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
        HlaNeurologicalScales neuroScales = 
                this.instanceNameToHlaObjMap.get(this.instanceNameOrderList.get(rowIndex));
        switch(columnIndex){
                case 0: return String.valueOf(neuroScales.isLocal());
                case 1: return neuroScales.getHlaInstanceName();
                case 2: return neuroScales.getPatientId("empty");
                case 3: return getGlasgowComaScale(neuroScales);
                case 4: return getLevelOfResponse(neuroScales);
                case 5: return getLevelOfConsciousness(neuroScales);
                default: return null;
        }
    }

    private String getGlasgowComaScale(HlaNeurologicalScales neuroScales){
        if(!neuroScales.hasGlasgowComaScale()){
            return null;
        }
        
        String glasgowObjectString = neuroScales.getGlasgowComaScale().toString();
        return glasgowObjectString.substring(glasgowObjectString.indexOf("eyes"),
                glasgowObjectString.indexOf("}"));
    }
        
    private String getLevelOfResponse(HlaNeurologicalScales neuroScales){
        if(!neuroScales.hasLevelOfResponse()){
            return null;
        }
        return neuroScales.getLevelOfResponse().toString();
    }

    private String getLevelOfConsciousness(HlaNeurologicalScales neuroScales){
        if(!neuroScales.hasLevelOfConsciousness()){
            return null;
        }
        return neuroScales.getLevelOfConsciousness().toString();
    }
    
    public HlaNeurologicalScales getHlaObject(int row){
        return  this.instanceNameToHlaObjMap.get(this.instanceNameOrderList.get(row));
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
