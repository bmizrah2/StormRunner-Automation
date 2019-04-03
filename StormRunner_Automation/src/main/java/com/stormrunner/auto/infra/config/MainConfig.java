package com.stormrunner.auto.infra.config;

import com.stormrunner.auto.infra.web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType = WebDriverType.CHROME;
	public static boolean closeBrowserAtTestEnd = false;
	public static int webDriverImplicitWaitInSeconds = 5;
	
}
