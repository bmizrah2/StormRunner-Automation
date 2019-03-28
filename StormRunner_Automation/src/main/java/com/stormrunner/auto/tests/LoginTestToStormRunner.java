package com.stormrunner.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestToStormRunner extends AbstractTest {

	@Test
	public void _002_loginToStormRunner() {
		
		//driver.get("http://amazon.com");
		
		// Login to my account of stormRunner Load
		driver.get("https://home.software.microfocus.com/myaccount");
		
		//Actions action = new Actions(driver);
		//WebElement helloSignInLink = driver.findElement(By.id("nav-link-accountList"));
		
		//action.moveToElement(helloSignInLink).build().perform();
		
		//driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[text()='Sign in']")).click();
		//driver.findElement(By.xpath("//input[@id='federateLoginName']")).click();
		
		// Entering user name as part of login to StormRunner
		driver.findElement(By.id("federateLoginName")).sendKeys(System.getenv("SEL_USERNAME"));
		driver.findElement(By.id("fed-submit")).click();
		
		
		//	driver.findElement(By.id("ap_password")).sendKeys("123456");
		//	driver.findElement(By.id("signInSubmit")).click();
		
		// Entering Password as part of login to StormRunner 
		//driver.findElement(By.id("password")).sendKeys("GoodPassword1");
		driver.findElement(By.id("password")).sendKeys(System.getenv("SEL_PASSWORD"));
		driver.findElement(By.id("submit_button")).click();
		
				
		//	WebElement warningMessageTitle = driver.findElement(By.xpath("//div[@id='auth-warning-message-box']//h4"));
			WebElement accountName = driver.findElement(By.xpath("//div[@title='Benny Java Automation']"));
		
		//	String warningMessageTitleText = warningMessageTitle.getText();
			String actualAccountName = accountName.getText();
		
			
		//	Assert.assertEquals(warningMessageTitleText, "Important Message", "Wrong warning message");
			Assert.assertEquals(actualAccountName, "Benny Java Automation", "The account name is NOT as expected !!!");
			
		// locate "Luanch" button
		// $x("//div/a[contains(@href,'175726009')]")
			
			
			
			
			
			
	}
}
