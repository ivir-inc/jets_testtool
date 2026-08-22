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

import devstudio.generatedcode.HlaEvent;
import devstudio.generatedcode.HlaEventAttributes;
import devstudio.generatedcode.HlaEventListener;
import devstudio.generatedcode.HlaEventManager;
import devstudio.generatedcode.HlaEventUpdater;
import devstudio.generatedcode.HlaLogicalTime;
import devstudio.generatedcode.HlaTimeStamp;
import devstudio.generatedcode.datatypes.EventTypeEnum;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EventSim implements DisconnectListener{

    private static final Logger logger = LogManager.getLogger(EventSim.class);
    private final HashMap<String,Event> eventsMap = new HashMap<>();
    private HlaEventManager eventManager = null;
    private String fucusedEventId = null;    
    
    public EventSim(){
       logger.info("Starting EventSim");
       eventManager = MmsFederate.getHlaWorld().getHlaEventManager();
       eventManager.addHlaEventDefaultInstanceListener(new EventUpdateListener());
    }
    
    public void createEvent(Event event){           
        try {
            HlaEvent hlaEvent = eventManager.createLocalHlaEvent();
            HlaEventUpdater updater = hlaEvent.getHlaEventUpdater();

            if(event.getSimTime() != null){
                updater.setSimTime(event.getSimTime());
            }

            if(event.getType() != null){
                updater.setType(EventTypeEnum.valueOf(event.getType().name()));
            }

            if(event.getSource() != null){
                updater.setSource(event.getSource());
            }

            if(event.getPatientId() != null){
                updater.setPatientId(event.getPatientId());
            }
            
            if(event.getInstructorId() != null){
                updater.setInstructorId(event.getInstructorId());
            }

            if(event.getLearnerId() != null){
                updater.setLearnerId(event.getLearnerId());
            }

            if(event.getTeamId() != null){
                updater.setTeamId(event.getTeamId());
            }

            if(event.getNotes() != null)
                updater.setNotes(event.getNotes());
            
            if(event.getDescription() != null){
                updater.setDescription(event.getDescription());
            }
            
            if(event.getFacilityId() != null){
                updater.setTrainingFacilityId(event.getFacilityId());
            }
            
            if(event.getLearnerActionEnum() != null) {
                updater.setLearnerAction(event.getLearnerActionEnum());
            }
            
            updater.setTime(new Date().getTime());
            updater.sendUpdate();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EventSim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void focusEvent(String eventId){
        this.fucusedEventId = eventId;
        
        Event event = this.eventsMap.get(eventId);
	if(event != null){
        	UiUpdateHandler.getUiUpdateHandler().updateEventText(eventText(event));
	}
    }
    
    private String eventText(Event event){
        String bText = "Event " + event.getInstanceName();
        if(event.getGhosted()){
           bText += " -- Ghost";
        }
        bText += "\n";
        if(event.getTime() != null){
            bText += "|- Time: " + String.valueOf(event.getTime() + "\n");
        }
        if(event.getSimTime() != null){
            bText += "|- SimTime: " + String.valueOf(event.getSimTime() + "\n");
        }
        if(event.getType() != null){
            bText += "|- Type: " + String.valueOf(event.getType().getName() + "\n");
        }
        if(event.getSource() != null){
            bText += "|- Source: " + String.valueOf(event.getSource() + "\n");
        }
        if(event.getPatientId() != null){
            bText += "|- Patient ID: " + String.valueOf(event.getPatientId() + "\n");
        }
        if(event.getFacilityId() != null){
            bText += "|- Facility ID: " + String.valueOf(event.getFacilityId() + "\n");
        }
        if(event.getPatientId() != null){
            bText += "|- Instructor ID: " + String.valueOf(event.getInstructorId() + "\n");
        }
        if(event.getLearnerId()!= null){
            bText += "|- Learner ID: " + String.valueOf(event.getLearnerId()+ "\n");
        }
        if(event.getTeamId()!= null){
            bText += "|- Team ID: " + String.valueOf(event.getTeamId()+ "\n");
        }
        if(event.getNotes() != null){
            bText += "|- Notes: " + event.getNotes() + "\n";
        }
        if(event.getNotes() != null){
            bText += "|- Description: " + event.getDescription() + "\n";
        }
        return bText;
    }
    
    private class EventUpdateListener implements HlaEventListener{

        @Override
        public void attributesUpdated(HlaEvent hlaEvent, Set<HlaEventAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            boolean isNewEvent = false;
            Event event = eventsMap.get(hlaEvent.getHlaInstanceName());
            if(event == null){
                //must be new
                event = new Event();
                event.setInstanceName(hlaEvent.getHlaInstanceName());
                event.setGhosted(!hlaEvent.isLocal());
                isNewEvent = true;
            }
           
            for(HlaEventAttributes.Attribute attribute : attributes){
                switch(attribute){
                    case TIME: event.setTime(hlaEvent.getTime());
                        break;
                    case SIM_TIME: event.setSimTime(hlaEvent.getSimTime());
                        break;
                    case TYPE: event.setType(EventType.valueOf(hlaEvent.getType().name()));
                        break;
                    case SOURCE: event.setSource(hlaEvent.getSource());
                        break;
                    case PATIENT_ID: event.setPatientId(hlaEvent.getPatientId());
                        break;
                    case INSTRUCTOR_ID: event.setInstructorId(hlaEvent.getInstructorId());
                        break;
                    case LEARNER_ID: event.setLearnerId(hlaEvent.getLearnerId());
                        break;
                    case TEAM_ID: event.setTeamId(hlaEvent.getTeamId());
                        break;
                    case NOTES: event.setNotes(hlaEvent.getNotes());
                        break;
                    case DESCRIPTION: event.setDescription(hlaEvent.getDescription());
                        break;
                    case TRAINING_FACILITY_ID: event.setFacilityId(hlaEvent.getTrainingFacilityId());
                        break;
                }
            }
            eventsMap.put(event.getInstanceName(), event);
            if(isNewEvent){
                UiUpdateHandler.getUiUpdateHandler().addToEventList(event);
            }
        }
    }

    @Override
    public void hlaDisconnected(){
	eventsMap.clear();
	fucusedEventId = null;
	UiUpdateHandler.getUiUpdateHandler().clearEvents();
	
		
    }
}
