package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM {
	private WebDriver driver; 
	
	public LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath ="//a[@class ='dropdown-toggle']")
	private WebElement dropdown;
	
	@FindBy(id = "logout_button")
	private WebElement logout;
	
	
	public void clickdropdown()
	{
		this.dropdown.click();
	}
	
	public void clicklogout()
	{
		this.logout.click();
	}
}

