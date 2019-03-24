package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.jb.amazon.auto.infra.reports.ConsoleReporter;
import il.co.jb.amazon.auto.infra.web.ActionBot;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected ActionBot bot;
	protected By[] pageUniqueElements;
	
	public AbstractPage(WebDriver driver, By... pageUniqueElements) throws Exception {
		this.driver = driver;
		this.bot = new ActionBot(driver);
		this.pageUniqueElements = pageUniqueElements;
		assertInPage();
	}
	
	public void assertInPage() throws Exception {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		
		try {
			for (By uniqueElement : pageUniqueElements) {
				webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(uniqueElement));
			}
			ConsoleReporter.report("*** On page: " + this.getClass().getSimpleName());
		}
		catch (TimeoutException ex) {
			throw new Exception("Not on the expected page: " + this.getClass().getSimpleName() + "\n" + ex.getMessage());
		}
	}
}
