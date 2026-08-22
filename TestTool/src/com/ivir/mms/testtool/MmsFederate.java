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

import devstudio.generatedcode.HlaFederateId;
import devstudio.generatedcode.HlaHLAfederate;
import devstudio.generatedcode.HlaHLAfederateAttributes;
import devstudio.generatedcode.HlaHLAfederateValueListener;
import devstudio.generatedcode.HlaHLAfederation;
import devstudio.generatedcode.HlaHLAfederationAttributes;
import devstudio.generatedcode.HlaHLAfederationValueListener;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaSettings;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.HlaWorld;
import devstudio.generatedcode.HlaWorldListener;
import devstudio.generatedcode.datatypes.HLAfederateState;

import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 */
public class MmsFederate {
    private static final Logger logger = LogManager.getLogger(MmsFederate.class);
    private static final Logger hlaLogger = LogManager.getLogger("hla_trace");

    private static HlaWorld hlaWorld;

    private DateTimeSim dateTimeSim = null;

    public static HlaWorld getHlaWorld() {
        return hlaWorld;
    }

    public void connect() {
        hlaWorld = HlaWorld.Factory.create();
        HlaWorldMonitor hlaWorldMonitor = new HlaWorldMonitor();
        hlaWorld.addHlaWorldListener(hlaWorldMonitor);
        try {

            UiUpdateHandler.getUiUpdateHandler().federationJoined();
            logger.info("Adding Interaction listener");
            HlaInteractionMonitor interactionMonitor = new HlaInteractionMonitor();
            hlaWorld.getHlaInteractionManager().addHlaInteractionListener(interactionMonitor);
            hlaWorldMonitor.addListener(interactionMonitor);

            InteractionSim iSim = new InteractionSim();
            UiCommandHandler.getUiCommandHandler().setInteractionSim(iSim);

            logger.info("adding federation list monitor");
            new HlaFederateMonitor(hlaWorld.getHlaHLAfederateManager()).start();

            logger.info("Adding DateTime listener");
            dateTimeSim = new DateTimeSim();
            UiCommandHandler.getUiCommandHandler().setDateTimeSim(dateTimeSim);
            interactionMonitor.setDateTimeSim(dateTimeSim);
            hlaWorldMonitor.addListener(dateTimeSim);

            logger.info("adding ReplayTimer");
            ReplayTimer replayTimer = new ReplayTimer();
            UiCommandHandler.getUiCommandHandler().setreplayTimer(replayTimer);

            logger.info("Adding PatientVitalSigns");
            PatientVitalSignsSim vitalSim = new PatientVitalSignsSim();
            UiCommandHandler.getUiCommandHandler().setPatientVitalSignsSim(vitalSim);
            hlaWorldMonitor.addListener(vitalSim);

            logger.info("Adding PatientRespiratoryPhysiology");
            PatientRespiratorySim respSim = new PatientRespiratorySim();
            UiCommandHandler.getUiCommandHandler().setPatientRespiratorySim(respSim);
            hlaWorldMonitor.addListener(respSim);

            logger.info("Adding Event");
            EventSim bmSim = new EventSim();
            UiCommandHandler.getUiCommandHandler().setEventSim(bmSim);
            hlaWorldMonitor.addListener(bmSim);

            logger.info("Adding CasualtyState");
            CasualtyStateSim casualtyStateSim = new CasualtyStateSim();
            UiCommandHandler.getUiCommandHandler().setCasualtyStateSim(casualtyStateSim);
            hlaWorldMonitor.addListener(casualtyStateSim);

            logger.info("Adding Facility");
            FacilitySim facilitySim = new FacilitySim();
            UiCommandHandler.getUiCommandHandler().setFacilitySim(facilitySim);
            hlaWorldMonitor.addListener(facilitySim);

            logger.info("Adding Tccc");
            TcccSim tcccSim = new TcccSim();
            UiCommandHandler.getUiCommandHandler().setTcccSim(tcccSim);
            hlaWorldMonitor.addListener(tcccSim);

            logger.info("Adding CreatePatient");
            CreatePatientSim createPatientSim = new CreatePatientSim();
            UiCommandHandler.getUiCommandHandler().setCreatePatientSim(createPatientSim);
            hlaWorldMonitor.addListener(createPatientSim);

            logger.info("Adding DataLog");
            DataLogSim dataLogSim = new DataLogSim();
            UiCommandHandler.getUiCommandHandler().setDataLogSim(dataLogSim);
            hlaWorldMonitor.addListener(dataLogSim);

            logger.info("Adding FederationState");
            FederationStateSim fedStateSim = new FederationStateSim();
            UiCommandHandler.getUiCommandHandler().setFederationStateSim(fedStateSim);
            hlaWorldMonitor.addListener(fedStateSim);

            logger.info("Adding Document");
            DocumentSim documentSim = new DocumentSim();
            UiCommandHandler.getUiCommandHandler().setDocumentSim(documentSim);
            hlaWorldMonitor.addListener(documentSim);

            logger.info("Adding BodyFluids");
            BodyFluidsSim bodyFluidsSim = new BodyFluidsSim();
            UiCommandHandler.getUiCommandHandler().setBodyFluidsSim(bodyFluidsSim);
            hlaWorldMonitor.addListener(bodyFluidsSim);

            logger.info("Adding Neuro Scales");
            NeuroScalesSim neuroScalesSim = new NeuroScalesSim();
            UiCommandHandler.getUiCommandHandler().setNeuroScalesSim(neuroScalesSim);
            hlaWorldMonitor.addListener(neuroScalesSim);


            logger.info("Adding Labs");
            LabDataSim labDataSim = new LabDataSim();
            UiCommandHandler.getUiCommandHandler().setLabDataSim(labDataSim);
            hlaWorldMonitor.addListener(labDataSim);

            logger.info("Adding Injury");
            InjuryDataSim injuryDataSim = new InjuryDataSim();
            UiCommandHandler.getUiCommandHandler().setInjuryDataSim(injuryDataSim);
            hlaWorldMonitor.addListener(injuryDataSim);

            logger.info("Adding BloodGasLab");
            BloodGasLabSim bloodGasLibSim = new BloodGasLabSim();
            ConsoleManager.getManaager().addConsoleCommand(bloodGasLibSim);

            logger.info("Adding BloodLab");
            BloodLabSim bloodLabSim = new BloodLabSim();
            ConsoleManager.getManaager().addConsoleCommand(bloodLabSim);

            FederateDataSim federateDataSim = new FederateDataSim();
            ConsoleManager.getManaager().addConsoleCommand(federateDataSim);

            hlaWorld.addHlaWorldListener(new HlaWorldMonitor());

            HlaLogicalTime logicalTime = hlaWorld.connect();
            hlaLogger.trace("federated");
            hlaLogger.trace(hlaWorld.getFederateId().getFederateName());
            hlaLogger.trace(hlaWorld.getEncodedHlaFederateHandle());
        } catch (Exception e) {
            logger.error("Could not connect to federation", e);
        }
    }

    public void disconnect() {
        try {
            dateTimeSim.stopTime();
            hlaWorld.disconnect();
            UiUpdateHandler.getUiUpdateHandler().federationResigned();
        } catch (Exception e) {
            logger.error("Could not connect to federation", e);
        }
    }

}
