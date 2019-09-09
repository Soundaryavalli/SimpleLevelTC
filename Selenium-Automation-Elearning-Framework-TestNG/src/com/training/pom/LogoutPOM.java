package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class LogoutPOM {
	private WebDriver driver;
	//ExtentTest logger;
	
	public LogoutPOM(WebDriver driver ) {
		this.driver = driver; 
		//this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath ="//a[@class ='dropdown-toggle']")
	private WebElement dropdown;
	
	@FindBy(id = "logout_button")
	private WebElement logout;
	
	//@FindBy(xpath ="//ul[@class ='dropdown-menu']")
	//private WebElement verifydropdown;
	
	
	public void clickdropdown()
	{
		this.dropdown.click();
	}
	
	
	public void clicklogout()
	{
		this.logout.click();
	}
}

