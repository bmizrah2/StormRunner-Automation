package com.stormrunner.auto.infra.web;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class TabAndIframeUtils {

	private static ReportDispatcher report = ReportManager.getInstance();

	// Switch to tab by Title
	public static void switchToTabByTitle(WebDriver driver, String title, long timeoutInMillis) throws Exception {

		Set<String> windowHandles = driver.getWindowHandles();
		boolean foundTab = false;

		long startTime = System.currentTimeMillis();
		long timeElapsed = 0;

		while (!foundTab && timeElapsed < timeoutInMillis) {

			for (String windowHandle : windowHandles) {

				driver.switchTo().window(windowHandle);

				if (driver.getTitle().equals(title)) {
					foundTab = true;
					break;
				}
			}

			if (!foundTab) {
				Thread.sleep(2000);
				timeElapsed = System.currentTimeMillis() - startTime;
			}
		}

		if (foundTab) {
			report.log("Switched to tab with title: '" + title + "'");
		}
		else {
			throw new Exception("Tab with title: '" + title + "' wasn't found!");
		}
	}

	//Switch to tab by URL
	public static void switchToTabByUrl(WebDriver driver, String url) throws Exception {

		Set<String> windowHandles = driver.getWindowHandles();
		boolean foundTab = false;

		for (String windowHandle : windowHandles) {

			driver.switchTo().window(windowHandle);

			if (driver.getCurrentUrl().contains(url)) {
				foundTab = true;
				break;
			}
		}

		if (foundTab) {
			report.log("Switched to tab with URL containing: '" + url + "'");
		}
		else {
			throw new Exception("Tab with URL containing: '" + url + "' wasn't found!");
		}
	}

	// Switch to another iframe
	public static void switchToIframe(WebDriver driver, By iframeBy) {

		WebElement iframeElement = driver.findElement(iframeBy);
		driver.switchTo().frame(iframeElement);
		report.log("Switched to iframe: " + iframeBy);
	}
}
