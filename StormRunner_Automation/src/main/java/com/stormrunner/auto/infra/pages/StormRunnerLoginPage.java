package com.stormrunner.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.stormrunner.auto.infra.web.By2;

public class StormRunnerLoginPage extends AbstractPage {


	//UserName field textbox
	private static final By2 userNameField = new By2("User Name field", By.id("federateLoginName"));

	//PasswordField textbox
	private static final By2 passwordField = new By2("Password field", By.id("password"));

	//continue button in Login page
	private static final By2 continueAfterEnteringUserName = new By2("'Continue' button after entering User name field",By.id("fed-submit"));

	//Sign in button
	private static final By2 signIn = new By2("'Sign in' button after entering Password",By.id("submit_button"));

	// 'Launch' button
	private static final By2 launchButton = new By2("'Launch' button", By.xpath("//a[text()='Launch']"));

	// 'Create' test button
	private static final By2 createTestButton = new By2("'Create a test' button", By.cssSelector(".stm-tst-create-a-test"));


	// StormRunner - Constructor
	public StormRunnerLoginPage(WebDriver driver) throws Exception {
		super(driver, userNameField, continueAfterEnteringUserName);
	}

	// StornRunner - Write the userName in the user field
	public void writeToUserNameField(String userName) {
		bot.writeToElement(userNameField, userName);
	}

	//StormRunner - function to click "Continue"
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

	// Wait till 'Home' page is presented	
	public void waitToHomePageToBeVisible() {
		bot.waitForElementToBeClickable(createTestButton);	
	}


}
