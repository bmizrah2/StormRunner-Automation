package com.stormrunner.auto.infra.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stormrunner.auto.infra.web.By2;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public class AssertUtils {

	//private WebDriverWait webDriverWait;
	private static ReportDispatcher report = ReportManager.getInstance();
	
	
	public static void assertEquals(Object actual, Object expected, String message) {
		assertEquals(actual, expected, message, false);
	}
	
	
//	public void waitForElementToBeClickable(By2 elementLocator) {
//		report.log("Wait for element: " + elementLocator + " to be clickable");
//		webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator.by));
//	}

	
	
	
	
	
	public static void assertEquals(Object actual, Object expected, String message, boolean softAssert) {
		
		try {
			Assert.assertEquals(actual, expected, message);
			report.log(message + "; Both are equal to: " + expected + " - OK");
		}
		catch (AssertionError e) {
			
			report.log(e.getMessage(), Status.failure);

			if (!softAssert) {
				throw e;
			}
		}
	}
	
	
	public static void assertTrue(boolean condition, String message) {
		assertTrue(condition, message, false);
	}
	
	public static void assertTrue(boolean condition, String message, boolean softAssert) {
		
		try {
			Assert.assertTrue(condition, message);
			report.log(message + " - OK");
		}
		catch (AssertionError e) {
			
			report.log(e.getMessage(), Status.failure);

			if (!softAssert) {
				throw e;
			}
		}
	}
}
