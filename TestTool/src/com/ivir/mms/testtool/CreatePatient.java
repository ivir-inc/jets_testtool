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

/**
 *
 */
public class CreatePatient {
    private String patientId = null;
    private String target = null;
    private boolean ghosted;
    private String instanceName = null;

    public String getPatientId() {
        return patientId;
    }

    public CreatePatient setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public CreatePatient setTarget(String target) {
        this.target = target;
        return this;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public CreatePatient setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
        return this;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public String toString() {
        return "CreatePatient{" + "patientId=" + patientId + ", target=" + target + ", ghosted=" + ghosted + ", instanceName=" + instanceName + '}';
    }
  
}
