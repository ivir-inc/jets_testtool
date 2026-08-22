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



import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.EnumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
        
/**
 *
 */
public class CsvProcessor implements Runnable {
    private static final String TIME_UNIT_MILLISECONDS = "milliseconds";
    private static final String TIME_UNIT_SECONDS = "seconds";
    private static final String TIME_UNIT_MINUTES = "minutes";
    private static final String TIME_UNIT_HOURS = "hours";
    
    private static final Logger logger = LogManager.getLogger(CsvProcessor.class);
    
    public static List<Patient> processVitalSignsCsv(File csvFile) throws FileNotFoundException{
          List<Patient> patientVitals = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)    
                    .withType(Patient.class)
                    .build()
                    .parse();
            
                return patientVitals;
    }
    
    public static List<MedicationTreatment> processMedicationTreatmentCsv(File csvFile) throws FileNotFoundException{
          List<MedicationTreatment> medTreatments = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(MedicationTreatment.class)
                    .build()
                    .parse();
            
                return medTreatments;
    }
    
    public static List<Event> processEventCsv(File csvFile) throws FileNotFoundException{
                List<Event> events = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(Event.class)
                    .build()
                    .parse();
            
                return events;
    }
    
    public static List<PhysicalTreatment> processPhysicalTreatmentCsv(File csvFile) throws FileNotFoundException{
                List<PhysicalTreatment> physTreatments = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(PhysicalTreatment.class)
                    .build()
                    .parse();
            
                return physTreatments;
    }
    
    public static List<BloodGasLab> processBloodGasLabCsv(File csvFile) throws FileNotFoundException{
                List<BloodGasLab> bloodGasLabs = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(BloodGasLab.class)
                    .build()
                    .parse();
            
                return bloodGasLabs;
    }
    
    public static List<BloodLab> processBloodLabCsv(File csvFile) throws FileNotFoundException{
                List<BloodLab> bloodLabs = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(BloodLab.class)
                    .build()
                    .parse();
            
                return bloodLabs;
    }
    
    public static List<UrineLab> processUrineLabCsv(File csvFile) throws FileNotFoundException{
                List<UrineLab> urineLabs = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(UrineLab.class)
                    .build()
                    .parse();
            
                return urineLabs;
    }
    
    public static List<BodyFluids> processBodyFluidsCsv(File csvFile) throws FileNotFoundException{
                List<BodyFluids> bodyFluids = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(BodyFluids.class)
                    .build()
                    .parse();
            
                return bodyFluids;
    }
    
    public static List<NeurologicalScales> processNeuroScalesCsv(File csvFile) throws FileNotFoundException{
                List<NeurologicalScales> neurologicalScales = new CsvToBeanBuilder(new FileReader(csvFile.getAbsolutePath()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withType(NeurologicalScales.class)
                    .build()
                    .parse();
            
                return neurologicalScales;
    }
    
    public static TimeUnitEnum getTimeUnit(File file) throws FileNotFoundException, IOException, CsvValidationException{
        CSVReader reader = new CSVReaderBuilder(new FileReader(file.getAbsolutePath())).build();
        TimeUnitEnum timeUnit = null;
        String [] nextLine;
        int numOfColumns;
        
        while (timeUnit == null){
            nextLine = reader.readNext();
            numOfColumns = nextLine.length;
            if (isTimeUnitEnum(nextLine[numOfColumns - 1])) {
                timeUnit = TimeUnitEnum.valueOf(nextLine[numOfColumns - 1].toUpperCase());
            }
        }
        if (timeUnit == null) {
            logger.warn("No time unit found in file: {}. Returning null.", file.getName());
        }
        
        return timeUnit;
    }
    
    private static boolean isTimeUnitEnum(String string){
       return EnumUtils.isValidEnumIgnoreCase(TimeUnitEnum.class, string);
    } 
    
    // May utilize this method later on
    
//    public static List processCsvs(File[] csvFiles) throws FileNotFoundException, IOException {
//        List fomEntityList = List.of();
//        //Parsing through all CSVs
//        for (File file : csvFiles) {
//            String fileName = file.getName();
//
//             if (fileName.contains("Event")) {
//                List<Event> events = new CsvToBeanBuilder(new FileReader(file.getAbsolutePath()))
//                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
//                    .withType(Event.class)
//                    .build()
//                    .parse();
//           
//                events.forEach(System.out::println);
//                
//            } else if (fileName.contains("Physiology")) {
//                List<Patient> patientVitals = new CsvToBeanBuilder(new FileReader(file.getAbsolutePath()))
//                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
//                    .withType(Patient.class)
//                    .build()
//                    .parse();
//            
//                return patientVitals;
//                
////                patientVitals.forEach(System.out::println);
//                
//            } else if (fileName.contains("PhysicalTreatment")){
//                List<PhysicalTreatment> physTreatments = new CsvToBeanBuilder(new FileReader(file.getAbsolutePath()))
//                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
//                    .withType(PhysicalTreatment.class)
//                    .build()
//                    .parse();
//            
//                physTreatments.forEach(System.out::println);
//            }
//            
//        }
//        
//        
//        return fomEntityList;
//       
//        
//    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
