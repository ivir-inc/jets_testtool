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

import devstudio.generatedcode.HlaBloodLab;
import devstudio.generatedcode.HlaBloodLabAttributes;
import devstudio.generatedcode.HlaBloodLabListener;
import devstudio.generatedcode.HlaBloodLabManager;
import devstudio.generatedcode.HlaBloodLabUpdater;
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
public class BloodLabSim implements HlaBloodLabListener, ConsoleCommand{
    HlaBloodLabManager manager = null;
 
    public BloodLabSim(){
        this.manager = MmsFederate.getHlaWorld().getHlaBloodLabManager();
        this.manager.addHlaBloodLabDefaultInstanceListener(this);
    }

    @Override
    public void attributesUpdated(HlaBloodLab bloodLab, Set<HlaBloodLabAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            //nothing to do yet
    }

    @Override
    public String getCommand() {
        return "bloodLab";
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
            HlaBloodLab lab = manager.createLocalHlaBloodLab();
            HlaBloodLabUpdater labUpdater = lab.getHlaBloodLabUpdater();
            Random random = new Random();
            labUpdater.setBaseExcess(random.nextFloat(100));
            labUpdater.setBloodGlucose(random.nextFloat(100));
            labUpdater.setBloodPh(random.nextFloat(100));
            labUpdater.setHematocrit(random.nextFloat(100));
            labUpdater.setHemoglobin(random.nextFloat(100));
            labUpdater.setIonizedCalcium(random.nextFloat(100));
            labUpdater.setPotassium(random.nextFloat(100));
            labUpdater.setPatientId("Patient#" + String.valueOf(random.nextInt(10)));
            labUpdater.setTime(random.nextLong());
            labUpdater.sendUpdate();
            return "Sent: " + lab.toString();
        } catch (HlaNotConnectedException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaInternalException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaRtiException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaSaveInProgressException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaRestoreInProgressException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaAttributeNotOwnedException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaUpdaterReusedException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HlaObjectInstanceIsRemovedException ex) {
            Logger.getLogger(BloodLabSim.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "could not send";
    }
    
    private String listObjects(){
        StringBuilder stringBuilder = new StringBuilder();
        manager.getAllHlaBloodLabs().forEach((lab)->{
            stringBuilder.append(lab).append("\n");
        });
        return stringBuilder.toString();
    }
    
}