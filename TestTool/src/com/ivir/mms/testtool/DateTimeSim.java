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

import devstudio.generatedcode.HlaDateTime;
import devstudio.generatedcode.HlaDateTimeAttributes;
import devstudio.generatedcode.HlaDateTimeListener;
import devstudio.generatedcode.HlaDateTimeManager;
import devstudio.generatedcode.HlaDateTimeUpdater;
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
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateTimeSim implements DisconnectListener{
    private long startTimeMs = 0;
    private long elapasedTimeMs = 0;
    private long lastUpdateTimeMs = 0;
    private long simTimeMs = 0; //simulation absolute time
    private int runRate = 1;
    private final int updateRate = 1;
    private Timer updateTimer;
    private HlaDateTimeManager dateTimeManager = null;
    private HlaDateTime thisDatetime = null;
    private boolean shouldPublish = false;
    private boolean replayTimerEnabled = false;
    private UiCommandHandler handler = UiCommandHandler.getUiCommandHandler();
    
    public DateTimeSim(){
        dateTimeManager = MmsFederate.getHlaWorld().getHlaDateTimeManager();
        dateTimeManager.addHlaDateTimeDefaultInstanceListener(new DateTimeListener());
    }
    
    public void updateDateTimeSim(boolean publish, int ratio){
        this.shouldPublish = publish;
        if(ratio != this.runRate){
            this.runRate = ratio;
        }
    }
    
    public void enableReplayTimer(boolean enable) {
        this.replayTimerEnabled = enable;
    }
    
    public void startTime(){
        if(shouldPublish){
            elapasedTimeMs = 0;
            startTimeMs = new Date().getTime();
            lastUpdateTimeMs = startTimeMs;
            simTimeMs = startTimeMs;
            updateTimer = new Timer("Update Timer");
            updateTimer.scheduleAtFixedRate(new UpdateTimerTask(), updateRate * 1000, updateRate * 1000);
            initializeFedObject();            
        }
        if(replayTimerEnabled) {
            handler.startReplayTimer();
        }
    }
  
    public void stopTime(){
        if(shouldPublish){
            updateTimer.cancel();
            updateTimer.purge();
            updateTimer = null;
        }
        if(replayTimerEnabled){
            handler.stopReplayTimer();
        }
    }
    
    public void pauseTime(){
        if(shouldPublish){
            updateTimer.cancel();
            updateTimer.purge();
            updateTimer = null;
        }
        if(replayTimerEnabled){
            handler.pauseReplayTimer();
        }
    }
    
    public void resumeTime(){
        if(shouldPublish){
            updateTimer = new Timer("Update Timer");
            updateTimer.scheduleAtFixedRate(new UpdateTimerTask(), updateRate * 1000, updateRate * 1000);
        }
        if(replayTimerEnabled){
            handler.resumeReplayTimer();
        }
    }
        
    private void initializeFedObject(){
        if(this.thisDatetime == null){
            try {
                this.thisDatetime = this.dateTimeManager.createLocalHlaDateTime();
            } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
                Logger.getLogger(DateTimeSim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void publishDateTime(){
        HlaDateTimeUpdater updater = this.thisDatetime.getHlaDateTimeUpdater();
        updater.setCurrentDateTime(lastUpdateTimeMs);
        updater.setSimulatedDateTime(lastUpdateTimeMs);
        updater.setSimulationElapsedTime(elapasedTimeMs);
        updater.setTimeScale(this.runRate);
        try {
            updater.sendUpdate();
        } catch (HlaNotConnectedException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaInternalException | HlaRtiException | HlaObjectInstanceIsRemovedException | HlaSaveInProgressException | HlaRestoreInProgressException ex) {
            Logger.getLogger(DateTimeSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateTime(){
        long nowTime = new Date().getTime();
        long deltaTimeMs = (nowTime - lastUpdateTimeMs) * runRate;
        elapasedTimeMs += deltaTimeMs;
        simTimeMs += deltaTimeMs;
        lastUpdateTimeMs = nowTime;        
        publishDateTime();
    }
    
    private class UpdateTimerTask extends TimerTask{

        @Override
        public void run() {
            updateTime();
        }
    
    }
    
    public class DateTimeListener implements HlaDateTimeListener{

        @Override
        public void attributesUpdated(HlaDateTime dateTime, Set<HlaDateTimeAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            if(!dateTime.isLocal()){
                shouldPublish = false;
                for(HlaDateTimeAttributes.Attribute attribute : attributes){
                    switch(attribute){
                        case CURRENT_DATE_TIME : lastUpdateTimeMs = dateTime.getCurrentDateTime();
                            break;
                        case SIMULATED_DATE_TIME : simTimeMs = dateTime.getSimulatedDateTime();
                            break;
                        case SIMULATION_ELAPSED_TIME : elapasedTimeMs = dateTime.getSimulationElapsedTime();
                            break;
                        case TIME_SCALE : runRate = dateTime.getTimeScale();
                            break;
                    }
                }
            }
            UiUpdateHandler.getUiUpdateHandler().updateClock(elapasedTimeMs, simTimeMs, lastUpdateTimeMs, runRate);
            
            if(replayTimerEnabled){
                handler.updateElapsedReplayTimer(elapasedTimeMs);
            }
        }
        
    }    

    @Override
    public void hlaDisconnected() {
	this.stopTime();
    }
    
}
