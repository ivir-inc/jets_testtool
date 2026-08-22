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

import devstudio.generatedcode.HlaDocumentManager;
import devstudio.generatedcode.HlaDocument;
import devstudio.generatedcode.HlaDocumentAttributes;
import devstudio.generatedcode.HlaDocumentUpdater;
import devstudio.generatedcode.HlaDocumentListener;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.DocumentTypeEnum;
import devstudio.generatedcode.exceptions.HlaAttributeNotOwnedException;
import devstudio.generatedcode.exceptions.HlaInternalException;
import devstudio.generatedcode.exceptions.HlaNotConnectedException;
import devstudio.generatedcode.exceptions.HlaObjectInstanceIsRemovedException;
import devstudio.generatedcode.exceptions.HlaRestoreInProgressException;
import devstudio.generatedcode.exceptions.HlaRtiException;
import devstudio.generatedcode.exceptions.HlaSaveInProgressException;
import devstudio.generatedcode.exceptions.HlaUpdaterReusedException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class DocumentSim implements DisconnectListener{
    private static final Logger logger = LogManager.getLogger(DocumentSim.class);
    private HlaDocumentManager documentManager = null;
    private StringBuilder statusSB = new StringBuilder();
    
    public DocumentSim(){
        logger.info("Starting DocumentSim");
        this.documentManager = MmsFederate.getHlaWorld().getHlaDocumentManager();
        this.documentManager.addHlaDocumentDefaultInstanceListener(new DocumentUpdateListener());
    }
    
    public void sendDocument(String name, String type, String patientId, String filePath){
        try {
            Path path = Paths.get(filePath);        
            byte[] fileData = Files.readAllBytes(path);
            sendDocument(name, type, patientId, fileData);
        } catch (IOException ex) {
            logger.error("Could not load document:",ex);
        }
    }
    
    public void sendDocument(String name, String type, String patientId, byte[] fileBytes){
        try {
            HlaDocument hlaDocument = this.documentManager.createLocalHlaDocument();
            HlaDocumentUpdater docUpdater = hlaDocument.getHlaDocumentUpdater();
            if(type != null){
                docUpdater.setDocumentType(DocumentTypeEnum.valueOf(type));
            }
            docUpdater.setPatientId(patientId);
            docUpdater.setDocumentName(name);
            docUpdater.setDocumentBody(fileBytes);
            docUpdater.sendUpdate();
        } catch (HlaNotConnectedException | HlaInternalException | HlaRtiException | HlaSaveInProgressException | HlaRestoreInProgressException | HlaAttributeNotOwnedException | HlaUpdaterReusedException | HlaObjectInstanceIsRemovedException ex) {
            java.util.logging.Logger.getLogger(DocumentSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class DocumentUpdateListener implements HlaDocumentListener {

        @Override
        public void attributesUpdated(HlaDocument document, Set<HlaDocumentAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            if (document.isLocal()) {
                statusSB.append("\n").append("Document sent: ").append(document.getDocumentName());
                UiUpdateHandler.getUiUpdateHandler().updateDocumentStatusText(statusSB.toString());
            } else {

                StringBuilder fileSB = new StringBuilder("docsave/");

                if (!document.hasDocumentBody()) {
                    logger.warn("Missing document body. Will not save");
                    return;
                }
                if (!document.hasDocumentType()) {
                    logger.warn("Missing document type.  will not save");
                    return;
                }
                if (document.hasPatientId()) {
                    fileSB.append(document.getPatientId()).append("_");
                }
                if (document.hasDocumentName()) {
                    fileSB.append(document.getDocumentName());
                }

                switch (document.getDocumentType()) {
                    case JPG:
                        fileSB.append(".jpg");
                        break;
                    case PDF:
                        fileSB.append(".pdf");
                        break;
                    case PNG:
                        fileSB.append(".png");
                        break;
                    case TXT:
                        fileSB.append(".txt");
                        break;
                    case UNKNOWN:
                        fileSB.append(".ukn");
                        break;
                    case XLS:
                        fileSB.append(".xls");
                        break;
                }

                try {
                    Files.write(Paths.get(fileSB.toString()), document.getDocumentBody());
                    statusSB.append("\n").append(fileSB);
                    UiUpdateHandler.getUiUpdateHandler().updateDocumentStatusText(statusSB.toString());
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(DocumentSim.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//not local

        }

    }

    @Override
    public void hlaDisconnected(){
	statusSB = new StringBuilder();	
        UiUpdateHandler.getUiUpdateHandler().updateDocumentStatusText(statusSB.toString());
    }
}
