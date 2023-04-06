package generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplimentaion implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	String methodname=	result.getMethod().getMethodName();
	
	System.out.println(methodname+"---->"+"Started Sucessfully");
	
	test=report.createTest(methodname);
			
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=	result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"---->"+"PASSED");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=	result.getMethod().getMethodName();
		test.log(Status.FAIL,methodname+"---->"+"FAILED");

		Webdriver_Utility wu=new Webdriver_Utility();
		Java_Utility ju=new Java_Utility();
		
		String ScreenshotName=methodname+"-"+ju.getRandomNumber();
		
		try {
			String path=wu.takeScreenShot(BaseClass.sDriver,ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=	result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"---->"+"SKIPPED");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("SUITE EXECUTION STARTED");
ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\Extentreport\\Report"+"-"+new Java_Utility().getSystemDateIn_Format()+".html");
		
		htmlreport.config().setDocumentTitle("V Tiger extent reports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("V TIGER EXTENT REPORTS");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Url","http://localhost:8888");
		report.setSystemInfo("Reporter Name","Upendar");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("SUITE EXECUTION ENDED");
		report.flush();
	}

}
