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
import devstudio.generatedcode.HlaBloodGasLabAttributes;
import devstudio.generatedcode.HlaBloodGasLabListener;
import devstudio.generatedcode.HlaBloodGasLabManager;
import devstudio.generatedcode.HlaBloodGasLabUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BloodGasLabSim implements HlaBloodGasLabListener, ConsoleCommand{
    HlaBloodGasLabManager manager = null;
 
    public BloodGasLabSim(){
        this.manager = MmsFederate.getHlaWorld().getHlaBloodGasLabManager();
        this.manager.addHlaBloodGasLabDefaultInstanceListener(this);
    }

    @Override
    public void attributesUpdated(HlaBloodGasLab bloodGasLab, Set<HlaBloodGasLabAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            //nothing to do yet
    }

    @Override
    public String getCommand() {
        return "bloodGasLab";
    }

    @Override
    public String executeCommand(String command, List<String> parameters) {
        if(parameters.size()==1){
            switch(parameters.get(0).toUpperCase()){
                case "CREATE":{
                    return createObject();
                }
                case "LIST":{
                    return listObjects();
                }
                default: return "include create or update as the command action";
            }
        }else{
            return "include create or update as the command action";
        }
    }
    
    private String createObject(){
        try {
            HlaBloodGasLab lab = manager.createLocalHlaBloodGasLab();
            HlaBloodGasLabUpdater labUpdater = lab.getHlaBloodGasLabUpdater();
            Random random = new Random();
            labUpdater.setPartialPressureCarbonDioxide(random.nextFloat(100));
            labUpdater.setPartialPressureOxygen(random.nextFloat(10));
            labUpdater.setPatientId("Patient#" + String.valueOf(random.nextInt(10)));
            labUpdater.setSulfurDioxide(random.nextFloat(100));
            labUpdater.setTime(random.nextLong());
            labUpdater.setTotalCarbonDioxide(random.nextFloat(20));
            labUpdater.sendUpdate();
            return "Sent: " + lab.toString();
        } catch (HlaNotConnectedException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaInternalException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaRtiException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaSaveInProgressException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaRestoreInProgressException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaAttributeNotOwnedException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaUpdaterReusedException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaObjectInstanceIsRemovedException ex) {
            Logger.getLogger(BloodGasLabSim.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "could not send";
    }
    
    private String listObjects(){
        StringBuilder stringBuilder = new StringBuilder();
        manager.getAllHlaBloodGasLabs().forEach((lab)->{
            stringBuilder.append("instanceName: ").append(lab.getHlaInstanceName()).append("\n");
            stringBuilder.append("PartialPressureCarbonDioxide: ").append(lab.getPartialPressureCarbonDioxide(-1.0f)).append("\n");
            stringBuilder.append("PartialPressureOxygen: ").append(lab.getPartialPressureOxygen()).append("\n");
            stringBuilder.append("PatientId: ").append(lab.getPatientId("n/a")).append("\n");
            stringBuilder.append(lab).append("\n");
        });
        return stringBuilder.toString();
    }
    
}