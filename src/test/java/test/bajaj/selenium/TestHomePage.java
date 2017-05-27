package test.bajaj.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bajaj.selenium.HomePage;
import com.bajaj.selenium.SkipSignInPage;

public class TestHomePage {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumDrivers\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/");
        
	}
	//@Test
	public void test1()
	{	
		HomePage homepage = new HomePage(driver);
		homepage.EnterEmail("ankitbajaj100865@gmail.com");
		homepage.ClickOnEnter();
	}
	//@Test
	public void test2()
	{
		HomePage homepage = new HomePage(driver);
		homepage.GotoSignInPage();
	}
	
	@Test
	public void test3()
	{
		HomePage homepage = new HomePage(driver);
		SkipSignInPage	skipsigninpage= homepage.GotoSkipSignInPage();
		
		
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.quit();
	}
		
}
