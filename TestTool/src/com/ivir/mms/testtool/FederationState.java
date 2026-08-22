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
public class FederationState {
    private String instanceName = null;
    private String state = null;
    private boolean ghosted;

    public String getInstanceName() {
        return instanceName;
    }

    public FederationState setInstanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }

    public String getState() {
        return state;
    }

    public FederationState setState(String state) {
        this.state = state;
        return this;
    }

    public boolean isGhosted() {
        return ghosted;
    }

    public FederationState setGhosted(boolean ghosted) {
        this.ghosted = ghosted;
        return this;
    }

    
}
