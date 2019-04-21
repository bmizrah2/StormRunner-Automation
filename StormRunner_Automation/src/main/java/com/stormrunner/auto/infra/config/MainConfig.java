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
	
	public static String StormRunnerLabelName;
	
	public static void initFromFile(String filePath) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);

		prop.load(input);

		webDriverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		closeBrowserAtTestEnd = Boolean.parseBoolean(prop.getProperty("closeBrowserAtTestEnd"));
		webDriverImplicitWaitInSeconds = Integer.parseInt(prop.getProperty("webDriverImplicitWaitInSeconds"));
		baseUrl = prop.getProperty("baseUrl");
		StormRunnerURL = prop.getProperty("StormRunnerURL");
		StormRunnerHomeURL = prop.getProperty("StormRunnerHomeURL");
		StormRunnerLoadTestsURL = prop.getProperty("StormRunnerLoadTestsURL");
		StormRunnerLabelName = prop.getProperty("StormRunnerLabelName");
		
		input.close();
	}
}
