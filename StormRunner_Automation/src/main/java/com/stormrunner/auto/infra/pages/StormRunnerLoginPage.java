package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public class StormRunnerLoginPage extends AbstractPage {

	//private static final By2 searchBox = new By2("Main search box", By.id("twotabsearchtextbox"));
	//private static final By2 goButton = new By2("'Go' button", By.xpath("//input[@value='Go']"));
	//private static final By2 signInSecurlyButtonBy = new By2("'Sign-in securly' button", By.id("a-autoid-0-announce"));
	//private static final By2 amazonMusicLink = new By2("'Amazon Music' link", By.xpath("//a[text()='Amazon Music']"));

	//UserName field textbox
	private static final By2 userNameField = new By2("User Name field", By.id("federateLoginName"));

	//PasswordField textbox
	private static final By2 passwordField = new By2("Password field", By.id("password"));

	//continue button in Login page
	private static final By2 continueAfterEnteringUserName = new By2("'Continue' button after entering User name field",By.id("fed-submit"));

	//Sign in button
	private static final By2 signIn = new By2("'Sign in' button after entering Password",By.id("submit_button"));


	private static final By2 launchButton = new By2("'Launch' button", By.xpath("//a[text()='Launch']"));

	// 'Home' tab
	//private static final By2 homeTab = new By2("'Home' Tab", By.cssSelector(".stm-tst-home"));
	private static final By2 createTestButton = new By2("'Create a test' button", By.cssSelector(".stm-tst-create-a-test"));
	
	
	//By.xpath("//a[text()='Launch']"


	// ORIG func
	//public StormRunnerLoginPage(WebDriver driver) throws Exception {
	//	super(driver, searchBox, goButton);
	//}

	// StormRunner - Constructor
	public StormRunnerLoginPage(WebDriver driver) throws Exception {
		super(driver, userNameField, continueAfterEnteringUserName);
	}

	// ORIG func
	//	public void writeToSearchbox(String searchTerm) {
	//	bot.writeToElement(searchBox, searchTerm);
	//}

	// StornRunner - Write the userName in the user field
	public void writeToUserNameField(String userName) {
		bot.writeToElement(userNameField, userName);
	}

	//ORIG Func	
	//public AmazonSearchResultsPage clickOnGoButton() throws Exception {
	//	bot.click(goButton);
	//	return new AmazonSearchResultsPage(driver);
	//}

	//StormRunner - func to click "Continue"
	public void clickOnContinueButton() throws Exception {
		bot.click(continueAfterEnteringUserName);
	}





	// StornRunner - Write the userName in the user field
	public void writeToPasswordField(String password) {
		bot.writeToElement(passwordField, password);
	}


	//StormRunner - func to click "Sign in"
	public void clickOnSignIn() throws Exception {
		bot.click(signIn);
		//return new StormRunnerHomePage(driver);
	}

	// Move to the new opened tab after Login to the tenant
	public void moveToNewOpenedTab() {
		bot.moveToNewOpenedTab(launchButton);

	}

	public void waitToHomePageToBeVisible() {
		bot.waitForElementToBeClickable(createTestButton);	
	}

	
	//	public AmazonSearchResultsPage clickOnGoButton() throws Exception {
	//		bot.click(goButton);
	//		return new AmazonSearchResultsPage(driver);
	//	}
	//	public AmazonProductPage clickOnSearchResultTitleByIndex(int resultIndex) throws Exception {

	//		By2 resultTitle = new By2("Title of search result #" + resultIndex, By.xpath("//div[@data-index='" + resultIndex + "']//h5"));
	//		bot.click(resultTitle);
	//		return new AmazonProductPage(driver);
	//	}



	//public void WaitForSignInSecurlyButtonEnabled() {
	//	bot.waitForElementToBeClickable(signInSecurlyButtonBy);
	//}

	//public void clickAmazonMusicLink() {
	//	bot.click(amazonMusicLink);
	//}
}
