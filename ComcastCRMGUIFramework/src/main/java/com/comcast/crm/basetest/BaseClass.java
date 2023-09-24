package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.database_utility.DataBaseUtility;
import com.comcast.crm.generic.file_utility.ExcelUtility;
import com.comcast.crm.generic.file_utility.FileUtility;
import com.comcast.crm.generic.webdriver_utility.JavaUtility;
import com.comcast.crm.generic.webdriver_utility.UtilityClassObject;
import com.comcast.crm.generic.webdriver_utility.WebDriverUtility;
import com.comcast.crm.objectrepository_utility.HomePage;
import com.comcast.crm.objectrepository_utility.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();	
	
	
	@BeforeSuite
	public void configureBS() throws SQLException {
		//dbLib.getDbConnection();
	}

	@BeforeClass
	public void configBS() throws IOException {
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		driver.manage().window().maximize();
		driver.get(url);

	}

	@BeforeMethod
	public void configBM() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = fLib.getDataFromPropertiesFile("userName");
		String password = fLib.getDataFromPropertiesFile("password");
		login.loginToApp(userName, password);

	}

	@AfterMethod
	public void configAM() throws IOException {
		HomePage home = new HomePage(driver);
		home.logOut();

	}

	@AfterClass
	public void configAC() throws IOException {
		System.out.println("After class");
		driver.quit();

	}

	@AfterSuite
	public void configAS() throws IOException {
		//dbLib.closeDbConnection();
	}

}
