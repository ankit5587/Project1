package testng.screenshot;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot{
	
	public static String capture(WebDriver driver,String screenshotname) throws Exception{
			
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String dest= System.getProperty("user.dir")+"/Error/"+screenshotname+".png";
		
		File destination =new File(dest);
		FileUtils.copyFile(source, destination); 
 		return dest;
		
	}

}
