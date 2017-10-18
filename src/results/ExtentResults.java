package results;

import java.io.File;

import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import libraries.Configurations;

public class ExtentResults {
	
	public static ExtentReports extreports = new ExtentReports(Configurations.resultsPath, true);
	public static ExtentTest log;
	
	
	public void createtestcase(String testcasename, String testname) throws Exception {
	
		log = extreports.startTest(testcasename);
		log.assignCategory(testname);
		extreports.endTest(log);
		
	}
	
	public void assertEquals(Object actual, Object expected, String message) {
		
		try {
		Assert.assertEquals(actual, expected, message);
		log.log(LogStatus.PASS, "PASS - "+message);
		}
		catch(AssertionError e) {
		log.log(LogStatus.FAIL, message, e);
		throw new AssertionError();
		}
		finally
		{
		extreports.endTest(log);
		extreports.flush();
		}
		
	}
	
	public void log(String message, boolean flag) {
		
		try {
		Reporter.log(message, flag);
		log.log(LogStatus.PASS, "PASS - "+message);
		}
		catch(Exception e) {
		log.log(LogStatus.FAIL, "FAIL - "+message, e);		
		}
		finally
		{
		extreports.endTest(log);
		extreports.flush();
		}
	}
	
}
