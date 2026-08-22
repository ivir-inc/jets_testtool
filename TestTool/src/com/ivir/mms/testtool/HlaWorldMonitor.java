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

import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.HlaWorldListener;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class HlaWorldMonitor implements HlaWorldListener{
    private static final Logger logger = LogManager.getLogger(PatientVitalSignsSim.class);
    ArrayList<DisconnectListener> disconnectListeners = new ArrayList();

    @Override
    public void connected(HlaTimeStamp timeStamp) {
	logger.info("Hla connected");
    }

    @Override
    public void disconnected(HlaTimeStamp timeStamp) {
        logger.info("HLA disconnected");
	disconnectListeners.forEach((listener)->listener.hlaDisconnected());
    }
    

    @Override
    public void timeAdvanceRequested(HlaTimeStamp timeStamp, HlaLogicalTime requestedTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void timeAdvanceGranted(HlaTimeStamp timeStamp, HlaLogicalTime grantedTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addListener(DisconnectListener listener){
	    this.disconnectListeners.add(listener);
    }
    
}
