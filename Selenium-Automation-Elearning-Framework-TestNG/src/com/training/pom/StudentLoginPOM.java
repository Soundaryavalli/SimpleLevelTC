package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class StudentLoginPOM {
	
	private WebDriver driver; 
	ExtentTest logger;
	
	public StudentLoginPOM(WebDriver driver,ExtentTest logger) 
	{
		this.driver = driver; 
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		Assert.assertEquals(this.userName.getAttribute("value"),userName);
		logger.log(LogStatus.INFO,"Entered UserName :" +userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		Assert.assertEquals(this.password.getAttribute("value"),password);
		logger.log(LogStatus.INFO, "Entered Password: " +password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		//String text = this.loginBtn.getText();
		//Assert.assertTrue(text.contains("Login"));
		logger.log(LogStatus.PASS, "Login is success");
	}
	
}
