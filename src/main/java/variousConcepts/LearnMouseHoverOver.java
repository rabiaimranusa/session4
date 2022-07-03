package variousConcepts;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHoverOver {
	
	WebDriver driver;
	By PRODUCT_MENU_FIELD = By.xpath("//span[text()='Products']");
	By NETWORKING_MENU_FIELD = By.xpath("//a[contains(text(),'Networking')]");
	By FOR_HOME_FIELD = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[2]/ul/li[11]/ul/li[3]/a");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.dell.com/en-us");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void mousehoverover() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_MENU_FIELD)).build().perform();
		action.moveToElement(driver.findElement(NETWORKING_MENU_FIELD)).build().perform();
		
		driver.findElement(FOR_HOME_FIELD).click();
		
	}
	

}