package ContactManagementSystem;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent; 
	public ExtentTest test;
	
	
	public void onStart(ITestContext context) {
	
	sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
	sparkReporter.config().setDocumentTitle("Automation Reports");
	sparkReporter.config().setReportName("Regression Testing");
	sparkReporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	
	extent.setSystemInfo("Computer name"," Local Host");
	extent.setSystemInfo("Enviornment", "QA");
	extent.setSystemInfo("Tester Name", "Madhan");
	extent.setSystemInfo("os", "Windows");
	extent.setSystemInfo("Browser", "Chrome");
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed: "+result.getName());	
	}
	
   public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed: "+result.getName());	
	}
   public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case skiped: "+result.getName());	
	}
   public void onFinish(ITestContext context) {
	   extent.flush();
   }

}
