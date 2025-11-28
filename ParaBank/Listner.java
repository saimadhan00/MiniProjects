package ParaBank;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner implements ITestListener {

	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest test;

	    public void onStart(ITestContext context) {
	        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
	        sparkReporter.config().setDocumentTitle("Automation Reports");
	        sparkReporter.config().setReportName("Regression Testing");
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        extent.setSystemInfo("Computer name", "Local Host");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester Name", "Madhan");
	        extent.setSystemInfo("os", "Windows");
	        extent.setSystemInfo("Browser", "Chrome");
	    }

	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Case Passed: " + result.getName());
	    }

	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Case Failed: " + result.getName());
	    }

	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
	    }

	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
