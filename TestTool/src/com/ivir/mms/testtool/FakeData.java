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

import devstudio.generatedcode.HlaPhysicalTreatment;
import devstudio.generatedcode.HlaPhysicalTreatmentUpdater;
import devstudio.generatedcode.HlaVitalSigns;
import devstudio.generatedcode.HlaVitalSignsUpdater;
import devstudio.generatedcode.HlaWorld;
import devstudio.generatedcode.datatypes.PhysicalTreatmentTypeEnum;
import devstudio.generatedcode.datatypes.TreatmentDeviceEnum;

/**
 *
 */
public class FakeData {
    public static void main(String args[]){
        try{
            HlaWorld world = HlaWorld.Factory.create();
            
            System.out.println("Press enter to join");
            new java.util.Scanner(System.in).nextLine();           
            world.connect();

            System.out.println("Press enter to publishPatientWithNoPatientId");
            new java.util.Scanner(System.in).nextLine();           
            publishPatientWithNoPatientId(world);

            System.out.println("Press enter to publishTreatmentWithNoPatientId");
            new java.util.Scanner(System.in).nextLine();           
            publishTreatmentWithNoPatientId(world);

            System.out.println("Press enter to resign");
            new java.util.Scanner(System.in).nextLine();           
            world.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void publishPatientWithNoPatientId(HlaWorld world) throws Exception{
        HlaVitalSigns hlaPatient = world.getHlaVitalSignsManager().createLocalHlaVitalSigns();
        HlaVitalSignsUpdater updater = hlaPatient.getHlaVitalSignsUpdater();
        updater.setHeartRate(80);
        updater.setRespirationRate(20.3f);
        updater.sendUpdate();
    }
    
    private static void publishTreatmentWithNoPatientId(HlaWorld world) throws Exception{
        HlaPhysicalTreatment treatment = world.getHlaPhysicalTreatmentManager().createLocalHlaPhysicalTreatment();
        HlaPhysicalTreatmentUpdater updater = treatment.getHlaPhysicalTreatmentUpdater();
        updater.setTreatmentId("test1");
        updater.setTreatment(PhysicalTreatmentTypeEnum.WARM_PATIENT);
        updater.setDeviceUsed(TreatmentDeviceEnum.LITTER);
        updater.sendUpdate();
    }
}
