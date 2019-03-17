package il.co.jb.amazon.auto.infra.config;

import il.co.jb.amazon.auto.infra.web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType = WebDriverType.CHROME;
	public static boolean closeBrowserAtTestEnd = false;
	public static int webDriverImplicitWaitInSeconds = 5;
	
}
