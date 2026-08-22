export RTI_HOME=/Users/lewanw/projects/portico-2.1.4
export RTI_LIB=$RTI_HOME/lib
export RTI_RID_FILE=gatewayRTI.rid

java -Ddevstudio.generatedcode.settings=FederateConfig.txt -Djava.net.preferIPv4Stack=true -cp "$RTI_LIB/*:lib/*:TestTool.jar" com.ivir.mms.testtool.TestTool

