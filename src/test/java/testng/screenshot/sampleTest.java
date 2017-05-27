package testng.screenshot;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class sampleTest extends Maintest {

	@Test
	public void captureonFail(){
		
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://www.automationtesting.in");
		
		Assert.assertEquals("Home- Auotmation test", driver.getTitle());
	}
}
