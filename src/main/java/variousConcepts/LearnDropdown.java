package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {
	WebDriver driver;
	By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a");
	By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//*[@id=\"cid\"]");
	By ADD_CONTACT_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By COUNTRY_FIELD = By.xpath("//*[@id='country']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://techfios.com/billing/?ng=admin/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// @Test
	public void Locators() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();

		String dashboardheader = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		Assert.assertEquals("dashboard not found", "Dashboard", dashboardheader);

	}

	@Test
	public void addcustomer() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();

		String dashboardheader = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		Assert.assertEquals("dashboard page not found", "Dashboard", dashboardheader);

		driver.findElement(CUSTOMER_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		driver.findElement(FULL_NAME_FIELD).sendKeys("Rabia");
		driver.findElement(COMPANY_DROPDOWN_FIELD);

		String companydropdown = driver.findElement(ADD_CONTACT_HEADER_FIELD).getText();
		Assert.assertEquals("add contact page not found", "Add Contact", companydropdown);

		Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Apple");
		driver.findElement(COUNTRY_FIELD);
		Select sel1 = new Select(driver.findElement(COUNTRY_FIELD));
		sel1.selectByVisibleText("Pakistan");
	}

	@After
	public void TearDown() {

		driver.close();
		driver.quit();

	}

}
