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

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class ReplayTimer {
    private Timer replayTimer;
    private long elapsedTimeMs;
    private final int updateRate = 1;
    private boolean timerPaused = false;
    private List<List<?>> replayClassLists = null;
    
    
    public void setReplayClassLists(List<List<?>> replayClassLists) {
        this.replayClassLists = replayClassLists;
    }
    
    public void startReplayTimer() {
        timerPaused = false;
        replayTimer = new Timer("Replay Timer");
        replayTimer.scheduleAtFixedRate(new ReplayTimerTask(), updateRate * 100, updateRate * 100);
    }
    
    public void stopReplayTimer() {
        replayTimer.cancel();
        replayTimer.purge();
        replayTimer = null;
        timerPaused = false;
    }
    
    public void pauseReplayTimer() {
        timerPaused = true;
    }
    
    public void resumeReplayTimer() {
        timerPaused = false;
    }
    
    public void updateElapsedTime(long elapsedTime) {
        this.elapsedTimeMs = elapsedTime;
    }
    
    
    public void parseReplayList() {
    if (timerPaused || replayClassLists == null) return;

    UiCommandHandler handler = UiCommandHandler.getUiCommandHandler();

    // iterate outer list safely
    Iterator<List<?>> outer = replayClassLists.iterator();
    while (outer.hasNext()) {
        List<?> classList = outer.next();
        if (classList.isEmpty()) { outer.remove(); continue; }

        Iterator<?> it = classList.iterator();
        if (!it.hasNext()) continue;

        Object obj = it.next(); // consume exactly one item

        try {
            if (obj instanceof Patient) {
                Patient p = (Patient) obj;
                if (elapsedTimeMs >= p.getTimeStamp()) {
                    handler.updatePatient(p);
                    it.remove();
                }

            } else if (obj instanceof MedicationTreatment) {
                MedicationTreatment t = (MedicationTreatment) obj;
                if (elapsedTimeMs >= t.getTreatmentTime()) {
                    handler.selectPatient(t.getPatientId());
                    handler.createMedicationTreatment(t);
                    it.remove();
                }

            } else if (obj instanceof PhysicalTreatment) {
                PhysicalTreatment t = (PhysicalTreatment) obj;
                if (elapsedTimeMs >= t.getTreatmentTime()) {
                    handler.selectPatient(t.getPatientId());
                    handler.createPhysicalTreatment(t);
                    it.remove();
                }

            } else if (obj instanceof Event) {
                Event e = (Event) obj;
                if (elapsedTimeMs >= e.getSimTime()) {
                    handler.selectPatient(e.getPatientId());
                    handler.createEvent(e);
                    it.remove();
                }

            } else if (obj instanceof BloodGasLab) {
                BloodGasLab l = (BloodGasLab) obj;
                if (elapsedTimeMs >= l.getTime()) {
                    handler.selectPatient(l.getPatientId());
                    handler.createBloodGasLab(l);
                    it.remove();
                }

            } else if (obj instanceof BloodLab) {
                BloodLab l = (BloodLab) obj;
                if (elapsedTimeMs >= l.getTime()) {
                    handler.selectPatient(l.getPatientId());
                    handler.createBloodLab(l);
                    it.remove();
                }

            } else if (obj instanceof UrineLab) {
                UrineLab l = (UrineLab) obj;
                if (elapsedTimeMs >= l.getTime()) {
                    handler.selectPatient(l.getPatientId());
                    handler.createUrineLab(l);
                    it.remove();
                }

            } else if (obj instanceof NeurologicalScales) {
                NeurologicalScales n = (NeurologicalScales) obj;
                if (elapsedTimeMs >= n.getTime()) {
                    handler.selectPatient(n.getPatientId());
                    handler.createNeuroScales(n);
                    it.remove();
                }

            } else if (obj instanceof BodyFluids) {
                BodyFluids b = (BodyFluids) obj;
                if (elapsedTimeMs >= b.getTime()) {
                    handler.selectPatient(b.getPatientId());
                    handler.createBodyFluids(b);
                    it.remove();
                }
            }
        } catch (NoSuchElementException ignore) {
            // should never happen now; we no longer over-consume
        }

        // if this sublist became empty, remove it safely
        if (classList.isEmpty()) outer.remove();
    }
}

    
        private class ReplayTimerTask extends TimerTask {

        @Override
        public void run() {
            if (replayClassLists != null) {
                parseReplayList();
            }
        }
    }
    
}
