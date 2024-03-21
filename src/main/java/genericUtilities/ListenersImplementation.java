package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author Sandeep Anand
 */

public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- test execution started -----");
		
		//Create a test for @Test in extent reports
		test = report.createTest(methodName); //Extent report will understand it is @Test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- Test PASS -----");
		
		//Log the pass status in extent reports
		test.log(Status.PASS, methodName + "---- Test Pass -----"); //any this print in report we use log
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----- Test FAIL -----");
		
		//Log the FAIL status in extent Reports
		test.log(Status.FAIL, methodName + " ----- Test FAIL -----");
		
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String ScreenShotName = methodName + "-" + j.getDate(); //ScreenShot name become method name with current system date & time
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, ScreenShotName);
			
			//Attach the screen shot for extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----- Test SKIP -----");
		
		//Log the SKIP status in Extent Reports
		test.log(Status.SKIP, methodName + " ----- Test SKIP -----");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println(" ----- Suite execution started -----");
		
		//Configure the extent reports
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution report");
		rep.config().setTheme(Theme.DARK);
		rep.config().setReportName("Vtiger Execution report");
		
		report = new ExtentReports();
		report.attachReporter(rep); //Configuration path in extent report is attached with ExtentReport
		report.setSystemInfo("Base browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Testing");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base url", "http://localhost:8888");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println(" ----- Suite execution finished -----");
		
		//generate extent report
		report.flush(); //Execution complete
			/*if we not write this than report will not generate*/
	}
}
