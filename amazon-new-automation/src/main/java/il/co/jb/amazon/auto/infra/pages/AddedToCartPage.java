package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddedToCartPage extends AbstractPage {

	private static final By addedToCartTitle = By.xpath("//h1[contains(text(),'Added to Cart')]");
	private static final By cartCounterSpan = By.id("nav-cart-count");
	
	public AddedToCartPage(WebDriver driver) throws Exception {
		super(driver, addedToCartTitle, cartCounterSpan);
	}
	
	public int getCartCounterValue() {
		
		String cartCounterText = bot.getElementText(cartCounterSpan);
		
		//String cartCounterText = driver.findElement(cartCounterSpan).getText();
		int cartCounter = Integer.parseInt(cartCounterText);
		return cartCounter;
	}
}
