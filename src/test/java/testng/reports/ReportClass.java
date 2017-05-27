package testng.reports;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class ReportClass implements IReporter  {

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for(ISuite suite:suites){
			String suiteName = suite.getName();
			
			Map<String,ISuiteResult> suiteResult= suite.getResults();
	
		for(ISuiteResult sr:suiteResult.values()){
			ITestContext tc =sr.getTestContext();
			
			System.out.println("Passed test for suite"+ " "+ suiteName +" "+"is"+ "  "+tc.getPassedTests().getAllResults().size());
			System.out.println("failed test for suite"+ " "+ suiteName +" "+"is"+ "  "+tc.getFailedTests().getAllResults().size());
		}
		
		}
	}

}
