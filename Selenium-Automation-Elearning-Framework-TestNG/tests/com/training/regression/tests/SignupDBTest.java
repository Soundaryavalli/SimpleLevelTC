package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ElearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.SignupDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SignupDBTest {
	private WebDriver driver;
	private String baseUrl;
	private SignUpPOM signupPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM =new SignUpPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = SignupDataProviders.class)
public void SignupDBTest(String FirstName , String LastName,String email,String UserName,String Pass,String ConfirmPass,String Phone) 
	
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