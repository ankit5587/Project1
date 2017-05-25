package testng.screenshot;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAshotScreenShot {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
//		System.setProperty("webdriver.gecko.driver","C:\\SeleniumDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.get("http://automationtesting.in/");
	       Thread.sleep(2000);
	       WebElement element = driver.findElement(By.xpath(".//*[@id='buttons-5-0-1-2']/div/div/a"));
	       
	      // File ScreenShot = new File(System.getProperty("user.dir")+"/test-output/FullPageScreenshot.png");
	       
	       	File   ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	FileUtils.copyFile(ScreenShot, new File(System.getProperty("user.dir")+"/test-output/FullPageScreenshot.png"));
	       	BufferedImage  fullImg = ImageIO.read(ScreenShot);
		       Point point = element.getLocation();
		       int eleWidth = element.getSize().getWidth();
		       int eleHeight = element.getSize().getHeight();
	      
		       BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    		    eleWidth, eleHeight);
		       
		       ImageIO.write(eleScreenshot, "png", ScreenShot);
		        	FileUtils.copyFile(ScreenShot, new File(System.getProperty("user.dir")+"/test-output/elePageScreenshot.png"));
		        	
	       


	      //element.click();
	      // Screenshot ss = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
//	     Screenshot ss = new AShot().takeScreenshot(driver, element);
//	     System.out.println("screen shot is taken");
//	     ImageIO.write(ss.getImage(),"PNG",new File(System.getProperty("user.dir")+"/test-output/FullPageScreenshot.png"));

	      
}
}
