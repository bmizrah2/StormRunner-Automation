package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public abstract class AbstractStormRunnerPage extends AbstractPage {

	private static final By2 loadTestsMenuLink = new By2("'Load Tests' Menu Link", By.cssSelector(".stm-tst-load-tests"));
	
	public AbstractStormRunnerPage(WebDriver driver, By2... pageUniqueElements) throws Exception {
		super(driver, pageUniqueElements);
	}
	
	public StormRunnerLoadTestsPage clickLoadTestsMenuLink() throws Exception {
		bot.click(loadTestsMenuLink);
		return new StormRunnerLoadTestsPage(driver);
	}

}
