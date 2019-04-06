package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class AmazonLandingPage extends AbstractPage {

	private static final By2 searchBox = new By2("Main search box", By.id("twotabsearchtextbox"));
	private static final By2 goButton = new By2("'Go' button", By.xpath("//input[@value='Go']"));
	private static final By2 signInSecurlyButtonBy = new By2("'Sign-in securly' button", By.id("a-autoid-0-announce"));
	private static final By2 amazonMusicLink = new By2("'Amazon Music' link", By.xpath("//a[text()='Amazon Music']"));
	
	public AmazonLandingPage(WebDriver driver) throws Exception {
		super(driver, searchBox, goButton);
	}
	
	public void writeToSearchbox(String searchTerm) {
		bot.writeToElement(searchBox, searchTerm);
	}
	
	public AmazonSearchResultsPage clickOnGoButton() throws Exception {
		bot.click(goButton);
		return new AmazonSearchResultsPage(driver);
	}
	
	public void WaitForSignInSecurlyButtonEnabled() {
		bot.waitForElementToBeClickable(signInSecurlyButtonBy);
	}
	
	public void clickAmazonMusicLink() {
		bot.click(amazonMusicLink);
	}
}
