package testng.reports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateExtentReport {
	
	static ExtentReports extent;
	ExtentTest test;
	static ExtentHtmlReporter htmlReporter;
	static String filePath = "./extentreport.html";
	
	
	
	public static ExtentReports GetExtent()
	{	
		if (extent != null)
            return extent;
		extent = new ExtentReports();
		extent.setSystemInfo("OS", "windows 10");
		extent.setSystemInfo("Envionemnt", "QA");
		extent.setSystemInfo("UserName", "Ankit_bAjaj");
		extent.setSystemInfo("Host", "automation.QA");
		
		
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	public static  ExtentReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("QAV automation report");
        htmlReporter.config().setReportName("Regression cycle");
        return htmlReporter;	
	}
	
	public ExtentTest createTest(String name, String description)
	{
		test = extent.createTest(name, description);
		return test;
	}
	
}
