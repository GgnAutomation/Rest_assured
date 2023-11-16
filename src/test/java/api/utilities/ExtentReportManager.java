package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkreport;
    public  ExtentReports extent;
    public ExtentTest test;
    String repName;
//    ThreadLocal<ExtentTest> extent_test;
    public void onStart(ITestContext testContext)
    {
    	String currenttime = new SimpleDateFormat("dd.MM.YYYY.HH.mm.ss").format(new Date());
    	repName = "Test-Report -"+currenttime +".html";
    	sparkreport = new ExtentSparkReporter(".\\Reports\\" +repName);
    	sparkreport.config().setDocumentTitle("RestAssured farmework for API test");
    	sparkreport.config().setReportName("Automation test");
    	sparkreport.config().setTheme(Theme.DARK);
    	extent = new ExtentReports();
    	extent.attachReporter(sparkreport);
    	extent.setSystemInfo("Application", "OneApp");
    	extent.setSystemInfo("Operating System", System.getProperty("os.name"));
    	extent.setSystemInfo("User name", System.getProperty("User.name"));
    	extent.setSystemInfo("Environemnt", "QA");
    	extent.setSystemInfo("User", "Nitesh");
//    	extent_test=new ThreadLocal<ExtentTest>();
//    	extent_test.set(test);
    }
    public void onTestSuccess(ITestResult result)
    {
    	test = extent.createTest(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.createNode(result.getName());
    	test.log(Status.PASS, "Test Passed");
    	
    }
    public void onTestFailure(ITestResult result)
    {
    	test = extent.createTest(result.getName());
    	test.createNode(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.FAIL, "Test Failed");
    	test.log(Status.FAIL, result.getThrowable().getMessage());
    }
    public void onTestSkipped(ITestResult result)
    {
    	test = extent.createTest(result.getName());
    	test.createNode(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.SKIP, "Test Skipped");
    	test.log(Status.SKIP, result.getThrowable().getMessage());
    }
    public void onFinish(ITestContext testContext)
    {
    	extent.flush();
    }
}
