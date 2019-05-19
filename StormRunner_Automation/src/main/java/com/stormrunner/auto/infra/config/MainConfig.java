package com.stormrunner.auto.infra.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.stormrunner.auto.infra.web.WebDriverType;

public class MainConfig {

	
	
	
	public static String StormRunnerURL;
	public static String StormRunnerHomeURL;
	public static String StormRunnerLoadTestsURL;
	
	public static WebDriverType webDriverType;
	public static boolean closeBrowserAtTestEnd;
	public static int webDriverImplicitWaitInSeconds;
	public static String baseUrl;
	
	public static int topologiesCounter=0;
	public static int numberOfTopologiesInTopologiesFile;
	public static String noDataMessageInTopologiesPage;
	
	public static String StormRunnerAccountName;
	
	public static String StormRunnerScriptName;
	
	
	public static String StormRunnerTestName;
	public static String StormRunnerTestDescription;
	public static String StormRunner_DisabledRunTestTitle;
	public static String StormRunner_EnabledRunTestTitle;
	
	
	public static String StormRunnerLabelName;
	
	public static String StormRunnerMonitorName;
	public static String StormRunnerSitescopeServerName;
	public static String StormRunnerSitescopeDescription;
	public static String StormRunnerSitescopeUserName;
	
	public static String StormRunnerLoadGeneratorName;
	public static String StormRunnerLoadGeneratorDescription;
	
	public static String StormRunnerTopologyName;
	public static String StormRunnerTopologyDescription;
	public static String StormRunnerSelectedMonitorForTopology;
	public static boolean StormRunnerTopologyFlag;
	
	public static String StormRunnerClientSideBreakdownTitle;
	public static String StormRunnerWebPageTestReportTitle;

	
	public static void initFromFile(String filePath) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);

		prop.load(input);

		webDriverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		closeBrowserAtTestEnd = Boolean.parseBoolean(prop.getProperty("closeBrowserAtTestEnd"));
		webDriverImplicitWaitInSeconds = Integer.parseInt(prop.getProperty("webDriverImplicitWaitInSeconds"));
		baseUrl = prop.getProperty("baseUrl");
		StormRunnerURL = prop.getProperty("StormRunnerURL");
		StormRunnerAccountName = prop.getProperty("StormRunnerAccountName");
		StormRunnerHomeURL = prop.getProperty("StormRunnerHomeURL");
		StormRunnerLoadTestsURL = prop.getProperty("StormRunnerLoadTestsURL");
		StormRunnerLabelName = prop.getProperty("StormRunnerLabelName");
		StormRunnerTestName = prop.getProperty("StormRunnerTestName");
		StormRunnerTestDescription = prop.getProperty("StormRunnerTestDescription");
		StormRunnerMonitorName = prop.getProperty("StormRunnerMonitorName");
		StormRunnerSitescopeServerName = prop.getProperty("StormRunnerSitescopeServerName");
		StormRunnerSitescopeDescription = prop.getProperty("StormRunnerSitescopeDescription");
		StormRunnerSitescopeUserName = prop.getProperty("StormRunnerSitescopeUserName");
		StormRunnerLoadGeneratorName = prop.getProperty("StormRunnerLoadGeneratorName");
		StormRunnerLoadGeneratorDescription = prop.getProperty("StormRunnerLoadGeneratorDescription");
		StormRunnerScriptName = prop.getProperty("StormRunnerScriptName");
		StormRunner_DisabledRunTestTitle = prop.getProperty("StormRunner_DisabledRunTestTitle");
		StormRunner_EnabledRunTestTitle = prop.getProperty("StormRunner_EnabledRunTestTitle");
		StormRunnerTopologyName = prop.getProperty("StormRunnerTopologyName");
		StormRunnerTopologyDescription = prop.getProperty("StormRunnerTopologyDescription");
		StormRunnerTopologyFlag = Boolean.parseBoolean(prop.getProperty("StormRunnerTopologyFlag"));
		StormRunnerSelectedMonitorForTopology = prop.getProperty("StormRunnerSelectedMonitorForTopology");
		numberOfTopologiesInTopologiesFile = Integer.parseInt(prop.getProperty("numberOfTopologiesInTopologiesFile"));
		noDataMessageInTopologiesPage = prop.getProperty("noDataMessageInTopologiesPage");
		StormRunnerClientSideBreakdownTitle = prop.getProperty("StormRunnerClientSideBreakdownTitle");
		StormRunnerWebPageTestReportTitle = prop.getProperty("StormRunnerWebPageTestReportTitle");
		
		input.close();
	}
}
