package testng.screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class ShutterScreenShot {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("http://automationtesting.in/");
	       Thread.sleep(2000);
	       Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).save("C:\\AnkitOXY\\Bajaj\\test-output\\");
	}

}
