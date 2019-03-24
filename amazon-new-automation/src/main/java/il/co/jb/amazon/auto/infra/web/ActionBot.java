package il.co.jb.amazon.auto.infra.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.jb.amazon.auto.infra.reports.ConsoleReporter;

public class ActionBot {

	private WebDriver driver;
	private WebDriverWait webDriverWait;
	
	public ActionBot(WebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 5);
	}
	
	public void click(By elementLocator) {
		ConsoleReporter.report("Click on element: " + elementLocator);
		driver.findElement(elementLocator).click();
	}
	
	public void writeToElement(By elementLocator, String text) {
		ConsoleReporter.report("Write '" + text + "' to element: " + elementLocator);
		driver.findElement(elementLocator).sendKeys(text);
	}
	
	public String getElementText(By elementLocator) { 
		String text = driver.findElement(elementLocator).getText();
		ConsoleReporter.report("Element " + elementLocator + " inner text: " + text);
		return text;
	}
	
	public void waitForElementToBeClickable(By elementLocator) {
		ConsoleReporter.report("Wait for element: " + elementLocator + " to be clickable");
		webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}
	
	public boolean isElementDisplayed1(By elementLocator) {
	
		List<WebElement> elements = driver.findElements(elementLocator);
		if (elements.size() > 0) {
			
			boolean isDisplayed = elements.get(0).isDisplayed();
			ConsoleReporter.report("Element " + elementLocator + " is displayed: " + isDisplayed);
			return isDisplayed;
		}
		
		ConsoleReporter.report("Element " + elementLocator + " is NOT displayed");
		return false;
	}
	
	public boolean isElementDisplayed2(By elementLocator) {
		
		try {
			WebElement xButton = driver.findElement(elementLocator);
			return xButton.isDisplayed();
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
}
