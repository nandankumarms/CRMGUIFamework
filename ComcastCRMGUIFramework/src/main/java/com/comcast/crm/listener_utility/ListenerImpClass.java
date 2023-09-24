package com.comcast.crm.listener_utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriver_utility.UtilityClassObject;

public class ListenerImpClass extends BaseClass implements ITestListener, ISuiteListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static  ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		//Spark report config
				spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM test suit result");
				spark.config().setReportName("CRM report");
				spark.config().setTheme(Theme.DARK);
				
				//Add environment information and create test
				report=new ExtentReports();
				 report.attachReporter(spark);
				 report.setSystemInfo("OS", "Windows");
				 report.setSystemInfo("Browser", "Chrome");
			
	}

	@Override
	public void onFinish(ISuite suite) {
		test.log(Status.INFO, "Bcked up");
		report.flush();
		System.out.println("Report backup");
		// Take back up of report
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		UtilityClassObject.setTest(test);
		System.out.println(result.getMethod().getMethodName() + " ====STARTED======");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " ====end======");
		
		test.log(Status.INFO, result.getName()+" Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Step 1 Create an object to EventFiringWebDriver
		TakesScreenshot sc = (TakesScreenshot) sdriver;

		// Step 2 use getScreenshotAs method to take the screenshot in runtime in file
		// format
		String filePath = sc.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(filePath, result.getName()+time);
		
		test.log(Status.FAIL, result.getName()+" is failed");
	}
}
