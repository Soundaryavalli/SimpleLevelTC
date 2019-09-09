package com.training.sanity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.pom.LogoutPOM;


public class StudentLogoutTest  extends StudentLoginTest {

	
	private static LogoutPOM logoutPOM;
	
	
	@Test (priority =2)
	public void validLogoutTest() 
	{
		logoutPOM = new LogoutPOM(driver);
		
		// To verify whether the  "Hello Student name and Welcome" is displayed once the user logs in. 
		
		String actualmsg = "Hello Soundarya Rams and welcome,";
		WebElement expectedmsg = driver.findElement(By.xpath("//div[@class ='normal-message']/p[1]"));
		System.out.println(expectedmsg.getText());
		String expmsg =expectedmsg.getText();
		Assert.assertEquals(actualmsg, expmsg);
		
		
		// To click on the dropdown beside user icon
		logoutPOM.clickdropdown();
		
		
		// To verify whether the Inbox is displayed in the drop down list
			String Expected1 = "Inbox";
			WebElement Actual1 = driver.findElement(By.xpath("//*[@class ='user-body']/a[1]"));
			System.out.println(Actual1.getText());
			String Act1 =Actual1.getText();
			Assert.assertEquals(Act1, Expected1);
		
		// To verify whether the My certificates  is displayed in the drop down list
			String Expected2 = "My certificates";
			WebElement Actual2 = driver.findElement(By.xpath("//ul[@class ='dropdown-menu']//li [4]/a[1]"));
			System.out.println(Actual2.getText());
			String Act2 =Actual2.getText();
			Assert.assertEquals(Act2, Expected2);
		
		
		// To verify whether the Logout  is displayed in the drop down list
				String Expected3 = "Logout";
				WebElement Actual3 = driver.findElement(By.id("logout_button"));
				System.out.println(Actual3.getText());
				String Act3 =Actual3.getText();
				Assert.assertEquals(Act3,Expected3);
				
				
		// To Click on the Logout option in the dropdown		
		logoutPOM.clicklogout();
		
	}
	
	
}