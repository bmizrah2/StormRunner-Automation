package il.co.jb.amazon.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTests {

	private WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	@Test
	public void _001_amazonSearchTest() {
		
		String searchTerm = "Samsung";
		String expectedWordInFisrtResult = "Galaxy";
		
		driver.get("http://amazon.com");
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(searchTerm);
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	
		String firstNonSponsoredResultTitle = driver.findElement(By.xpath("//div[@data-index='2']//h5")).getText();
		
		Assert.assertTrue(firstNonSponsoredResultTitle.contains(expectedWordInFisrtResult), "The first result doesn't contain '" + expectedWordInFisrtResult + "'");
	}
	
	
	@Test
	public void _002_loginToAmazon() {
		
		driver.get("http://amazon.com");
		
		Actions action = new Actions(driver);
		WebElement helloSignInLink = driver.findElement(By.id("nav-link-accountList"));
		
		action.moveToElement(helloSignInLink).build().perform();
		
		driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[text()='Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("aa@bb.com");
		driver.findElement(By.id("ap_password")).sendKeys("123456");
		driver.findElement(By.id("signInSubmit")).click();
		
		WebElement warningMessageTitle = driver.findElement(By.xpath("//div[@id='auth-warning-message-box']//h4"));
		String warningMessageTitleText = warningMessageTitle.getText();
		
		Assert.assertEquals(warningMessageTitleText, "Important Message", "Wrong warning message");
	}
}
