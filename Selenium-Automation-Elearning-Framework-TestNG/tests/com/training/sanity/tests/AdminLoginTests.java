package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTests {

	public static WebDriver driver;
	public static String baseUrl;
	public static AdminLoginPOM AdminloginPOM;
	public static Properties properties;
	public ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		// verify whether it loads chrome browser for every class
		System.out.println("start check");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		AdminloginPOM = new AdminLoginPOM(driver);
		// open the browser 
		driver.get(baseUrl);
	}

		
	@AfterClass
		public void tearDown() throws Exception
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority =1)
	public void validLoginTest() {
		System.out.println("Login Test Scenario");
		
		// To enter the username
		AdminloginPOM.sendUserName("admin");
		
		// To enter the password
		AdminloginPOM.sendPassword("admin@123");
		
		// To click on Login button
		AdminloginPOM.clickLoginBtn(); 
		
	}
	
}
