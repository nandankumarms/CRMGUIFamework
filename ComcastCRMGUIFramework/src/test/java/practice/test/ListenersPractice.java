package practice.test;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;


public class ListenersPractice extends BaseClass{
	
	static ExtentSparkReporter spark;
	static ExtentReports report;
	@Test
	public void reportingTest() {
		//Spark report config
		spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suit result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//Add environment information and create test
		 report=new ExtentReports();
		 report.attachReporter(spark);
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("Browser", "Chrome");
		 ExtentTest test=report.createTest("createContactTest");
		 
       WebDriver driver=new ChromeDriver();
		 
		 driver.get("https://www.google.com");
		 
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 String filePath=ts.getScreenshotAs(OutputType.BASE64);
		 
//		 test.log(Status.INFO, "Login to app");
//		 test.log(Status.INFO, "Navigate to page");
//		 test.log(Status.INFO, "create contact ");
		 if( "nandn".equals("nandan")) {
		 test.log(Status.PASS, "Created");
		 }
		 else {
			 test.addScreenCaptureFromBase64String(filePath);
		 }
		 report.flush();
		 
		 
	}
}
