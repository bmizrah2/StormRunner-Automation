package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;
import com.stormrunner.auto.infra.web.TabAndIframeUtils;

public class MyAccountPage extends AbstractPage {


	// Account Name
	private static final By2 expectedAccountName = new By2("Expected Account Name", By.xpath("//div[@title='Benny Java Automation']"));

	// Launch Button
	private static final By2 launchButton = new By2("Launch Button", By.xpath("//a[text()='Launch']"));


	// MyAccount Page constructor
	public MyAccountPage(WebDriver driver) throws Exception {
		super(driver, expectedAccountName);
	}

	
	//Get StormRunner account
	public static String getAccountName() {
		String actualAccountName = bot.getElementText(expectedAccountName);
		return actualAccountName;
	}

	
	//Click on 'Launch' button
	public StormRunnerHomePage clickLaunchButton() throws Exception{
		bot.click(launchButton);
		TabAndIframeUtils.switchToTabByTitle(driver, "Home", 100000);
		return new StormRunnerHomePage(driver); 
	}



}		



