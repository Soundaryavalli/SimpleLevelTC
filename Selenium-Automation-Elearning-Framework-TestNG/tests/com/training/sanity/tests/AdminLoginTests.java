package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTests {

	public static WebDriver driver;
	public static String baseUrl;
	public static AdminLoginPOM AdminloginPOM;
	public static Properties properties;
	public static ScreenShot screenShot;
	public static ExtentReports extent;// overall report
	public static ExtentTest logger;// log of test steps

	
@BeforeSuite
	
	public void beforesuite()
	{
	 //Path of report- true means give path is correct
	 extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Report/CourseCategoryReport.html",true);
	 
	 // To load the config file
	 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		// verify whether it loads chrome browser for every class
		System.out.println("start check");
		logger = extent.startTest("TestResults");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		logger.log(LogStatus.PASS, "Browser lanuched Successfully");
		baseUrl = properties.getProperty("baseURL");
		AdminloginPOM = new AdminLoginPOM(driver);
		screenShot = new ScreenShot(driver);
		// open the browser 
		driver.get(baseUrl);
		String currenturl = driver.getCurrentUrl();
		logger.log(LogStatus.PASS,"The Current URL of the web page" +currenturl);
	}

		
	@AfterClass
		public void tearDown() throws Exception
	{
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "Browser Closed Successfully");
		
		extent.endTest(logger);
		
	}
	
	@AfterSuite
	public void aftersuite()
	{
		extent.flush();
		extent.close();
		
	}
	
	@Test(priority =1)
	public void validLoginTest() throws InterruptedException {
		System.out.println("Login Test Scenario");
		
		// To enter the username
		AdminloginPOM.sendUserName("admin");
		
		// To enter the password
		AdminloginPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("LoginPage");
		
		// To click on Login button
		Thread.sleep(3000);
		AdminloginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginPage is Success");
	
		logger.log(LogStatus.PASS, "Login is success");
		
		// To verify the title
		Thread.sleep(10000);
		String Expected ="e Learning - My education";
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, Expected);
		
		
	}
	
}
