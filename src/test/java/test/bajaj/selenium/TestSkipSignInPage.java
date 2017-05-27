package test.bajaj.selenium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.bajaj.selenium.HomePage;
import com.bajaj.selenium.SkipSignInPage;
import datProvider.TestNG.XLAPITest;
import testng.reports.GenerateExtentReport;
import testng.screenshot.GetScreenshot;

public class TestSkipSignInPage {
	WebDriver driver;
	XLAPITest xls;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		
		
		
		extent = GenerateExtentReport.GetExtent();
		
		xls = new XLAPITest("C:\\AnkitOXY\\Bajaj\\Book1.xls");
		
		// xls.getTableArray("C:\\AnkitOXY\\Bajaj\\Book1.xls", "Sheet1");
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			
			
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			driver=new RemoteWebDriver(new URL("http://192.168.255.1:4444/wd/hub"), cap);
		}
		

		else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
			
			DesiredCapabilities cap= DesiredCapabilities.firefox();

			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
			driver=new RemoteWebDriver(new URL("http://192.168.255.1:4444/wd/hub"), cap);
		}

		else if (browser.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\MicrosoftWebDriver.exe");
//			driver = new EdgeDriver();
			
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
		//	cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			//cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
			
			driver=new RemoteWebDriver(new URL("http://192.168.255.1:4444/wd/hub"), cap);
		}
		
		else if(browser.equalsIgnoreCase("headless"))
				{
					driver=new HtmlUnitDriver();
				}
		
		else 
		{
			throw new Exception("NoMatchingBrowser found");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/");
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] Details() throws Exception {
		String sTestCaseName = this.toString();
		int iTestCaseRow;
		//
		// Object a[][]= new Object[][] {{xls.getCellData("Sheet1",1,
		// "FirstName"),xls.getCellData("Sheet1",1,
		// "LastName"),xls.getCellData("Sheet1",1,
		// "Address"),xls.getCellData("Sheet1",1, "Email")},
		// {xls.getCellData("Sheet1",2, "FirstName"),xls.getCellData("Sheet1",2,
		// "LastName"),xls.getCellData("Sheet1",2,
		// "Address"),xls.getCellData("Sheet1",2, "Email")},
		// {xls.getCellData("Sheet1",3, "FirstName"),xls.getCellData("Sheet1",3,
		// "LastName"),xls.getCellData("Sheet1",3,
		// "Address"),xls.getCellData("Sheet1",3, "Email")},
		// {xls.getCellData("Sheet1",4, "FirstName"),xls.getCellData("Sheet1",4,
		// "LastName"),xls.getCellData("Sheet1",4,
		// "Address"),xls.getCellData("Sheet1",4, "Email")},
		//
		// };
		// System.out.println(a.toString());
		// return a;
	//	String sTestCaseName = xls.getTestCaseName(this.toString());
	//	System.out.println(sTestCaseName);
	//	int iTestCaseRow = xls.getRowContains(sTestCaseName,0);
	//	System.out.println(iTestCaseRow);
		return xls.getTableArray("C:\\AnkitOXY\\Bajaj\\Book1.xls", "Sheet1");

	}

	@Test(dataProvider = "Details")
	public void checkRegistration(String fname, String lname, String address, String email) throws Exception {
		test=extent.createTest("checkRegistration","this test will enter the details");
		
		HomePage homepage = new HomePage(driver);

		// SkipSignInPage skipsigninpage= new SkipSignInPage(driver);
		SkipSignInPage skipsigninpage = homepage.GotoSkipSignInPage();
		// skipsigninpage.Enterdetails(xls.getCellData("Sheet1",1,
		// "FirstName"),xls.getCellData("Sheet1",1,
		// "LastName"),xls.getCellData("Sheet1",1,
		// "Address"),xls.getCellData("Sheet1",1, "Email"));
		skipsigninpage.Enterdetails(fname, lname, address, email);
		skipsigninpage.goToHomePage();
		
		
	}
	
//	@Test	
//	public void failedTest(){
//		test=extent.createTest("checkRegistration","this test will show you how to fail");
//		Assert.assertTrue(false);
//	}
//	@Test
//	public void failedTest2(){
//		test=extent.createTest("checkRegistration","this test will show you how to fail");
//		Assert.assertTrue(false);
//	}
//	@Test
//	public void failedTest3(){
//		test=extent.createTest("checkRegistration","this test will show you how to fail");
//		Assert.assertTrue(false);
//	}
//	@Test
//	public void failedTest4(){
//		test=extent.createTest("checkRegistration","this test will show you how to fail");
//		Assert.assertTrue(false);
//	}
//	@Test
//	public void failedTest5(){
//		test=extent.createTest("checkRegistration","this test will show you how to fail");
//		Assert.assertTrue(false);
//	}
//	
//	@Test
//	public void SkipTest(){
//		test=extent.createTest("checkRegistration","this test will show you how to Skip");
//		throw new SkipException("this test is skipped just like that");
//	}
//	@Test
//	public void SkipTest2(){
//		test=extent.createTest("checkRegistration","this test will show you how to Skip again");
//		throw new SkipException("this test is skipped just like that again");
//	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{	
			//String screenShotPath = GetScreenshot.capture(driver, "screenShotName");
			//test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test case failed due to below issue ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{	
			//String screenShotPath = GetScreenshot.capture(driver, "screenShotName");
		//	test.pass("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"  " +"Test case passed",ExtentColor.CYAN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test case skiped due to below issue ", ExtentColor.ORANGE));
			test.fail(result.getThrowable());
		}
		else{
			System.out.println("ooooooooooooooppps");
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		extent.flush();
	}

}
