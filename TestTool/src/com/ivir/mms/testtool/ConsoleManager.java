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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class ConsoleManager {
    private static final ConsoleManager manager = new ConsoleManager();
    private final HashMap<String,ConsoleCommand> nameToCommandMap = new HashMap<>();
    
    public static ConsoleManager getManaager(){
        return manager;
    }
    
    private ConsoleManager(){
        addConsoleCommand(new HelpCommand());
    }
    
    public String execute(String inputString){
        String commandArray[] = inputString.split("\\s+");
        List<String> parameters = Arrays.asList(commandArray);
        String commandName = parameters.get(0).toLowerCase();
        if(parameters.size() == 1){
            parameters = new ArrayList<>();
        }else{
            parameters = parameters.subList(1, parameters.size());        
        }
        ConsoleCommand command = nameToCommandMap.get(commandName);
        if(command == null){
            return "command not found";
        }
        return command.executeCommand(commandName, parameters);
    }
    
    public void addConsoleCommand(ConsoleCommand command){
        this.nameToCommandMap.put(command.getCommand().toLowerCase(), command);
    }
    
    public class HelpCommand implements ConsoleCommand{

        @Override
        public String getCommand() {
            return "help";
        }

        @Override
        public String executeCommand(String command, List<String> parameters) {
            StringBuilder outBuilder = new StringBuilder();
            nameToCommandMap.keySet().forEach((name)->{
                outBuilder.append(name).append("\n");
            });
            return outBuilder.toString();
        }
        
    }
    
}