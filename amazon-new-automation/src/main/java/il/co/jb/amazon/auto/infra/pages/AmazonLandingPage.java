package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.jb.amazon.auto.infra.reports.ConsoleReporter;

public class AmazonLandingPage extends AbstractPage {

	private static final By searchBox = By.id("twotabsearchtextbox");
	private static final By goButton = By.xpath("//input[@value='Go']");
	private static final By signInSecurlyButtonBy = By.id("a-autoid-0-announce");
	
	public AmazonLandingPage(WebDriver driver) throws Exception {
		super(driver, searchBox, goButton);
	}
	
	public void writeToSearchbox(String searchTerm) {
		
		bot.writeToElement(searchBox, searchTerm);
		
		/*
		ConsoleReporter.report("Write '" + searchTerm + "' into search box (" + searchBox + ")");
		driver.findElement(searchBox).sendKeys(searchTerm);
		*/
	}
	
	public AmazonSearchResultsPage clickOnGoButton() throws Exception {
		
		bot.click(goButton);
		//driver.findElement(goButton).click();
		return new AmazonSearchResultsPage(driver);
	}
	
	public void WaitForSignInSecurlyButtonEnabled() {
		
		bot.waitForElementToBeClickable(signInSecurlyButtonBy);
		
		/*
		WebElement signInSecurlyButton = driver.findElement(signInSecurlyButtonBy);
		WebDriverWait webdriverWait = new WebDriverWait(driver, 5);
		webdriverWait.until(ExpectedConditions.elementToBeClickable(signInSecurlyButton));
		*/
	}
}
