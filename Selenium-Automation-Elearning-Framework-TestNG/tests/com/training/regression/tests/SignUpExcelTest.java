package com.training.regression.tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.SignupDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SignUpExcelTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static SignUpPOM signupPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM = new SignUpPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		
	}

		
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	
	}

	
	@Test(dataProvider = "excel-inputs", dataProviderClass = SignupDataProviders.class)
	public void SignupExcelTest(String FirstName , String LastName,String email,String UserName,String Pass,String ConfirmPass,String Phone) 
	
	{
		
		signupPOM.signup();
		signupPOM.verifyregistration();
		signupPOM.selteacher();
		signupPOM.firstname(FirstName);
		signupPOM.lastname(LastName);
		signupPOM.email(email);
		signupPOM.username(UserName);
		signupPOM.pass(Pass);
		signupPOM.confirmpass(ConfirmPass);
		signupPOM.phone(Phone);
		signupPOM.registration();
		signupPOM.verifyregsuccess();
		screenShot.captureScreenShot("Registration Success");
		
	}

}