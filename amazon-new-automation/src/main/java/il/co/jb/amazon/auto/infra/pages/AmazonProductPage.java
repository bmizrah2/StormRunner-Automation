package il.co.jb.amazon.auto.infra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage extends AbstractPage {

	private static final By addToCartButton = By.id("add-to-cart-button");
	private static final By productTitle = By.id("productTitle");
	private static final By addToOrderPopupXButton = By.cssSelector("button[data-action='a-popover-close']");
	
	public AmazonProductPage(WebDriver driver) throws Exception {
		super(driver, addToCartButton, productTitle);
	}
	
	public AddedToCartPage clickAddToCartButton() throws Exception {
		
		bot.click(addToCartButton);
		Thread.sleep(500);
		
		driver.findElement(addToCartButton).click();
		if (bot.isElementDisplayed1(addToOrderPopupXButton)) {
			bot.click(addToOrderPopupXButton);
		}
		
		return new AddedToCartPage(driver);

		/*
		Thread.sleep(500);
		
		int numOfTries = 1;
		while (isAddToOrderPopupXButtonVisible()) {
			clickAddToOrderPopupXButton();
			System.out.println("Close popup, try #" + numOfTries);
			numOfTries++;
		}
		
		*/
		
	}
	
	public boolean isAddToOrderPopupXButtonVisible() {
		
		List<WebElement> elements = driver.findElements(addToOrderPopupXButton);
		if (elements.size() > 0) {
			return elements.get(0).isDisplayed();
		}
		
		return false;
		
		/*
		try {
			WebElement xButton = driver.findElement(addToOrderPopupXButton);
			return xButton.isDisplayed();
		}
		catch (NoSuchElementException e) {
			return false;
		}
		*/
	}
	
	public void clickAddToOrderPopupXButton() {
		
		/*
		WebElement xButton = driver.findElement(addToOrderPopupXButton);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(xButton));
		xButton.click();
		*/
		
		driver.findElement(addToOrderPopupXButton).click();
	}
}
