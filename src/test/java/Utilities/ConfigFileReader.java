package Utilities;

import java.util.Properties;

public class ConfigFileReader {

	public String getReportConfigPath(){
		String reportConfigPath = System.getProperty("user.dir")+"\\extent-config.xml";
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
}
