package com.training.sanity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.pom.EditProfilePOM;


public class EditProfile extends AdminLoginTests {

	
	private EditProfilePOM editPOM;
	
	@Test(priority =2)
	public void validEditProfileTest() throws InterruptedException
	{
		
		System.out.println("Edit Profile Scenario");
		Thread.sleep(3000);
		
		editPOM = new EditProfilePOM(driver);
		
		// Call the method to click the home page
		editPOM.Homepage();
		
		// call the method to click on edit profile
		editPOM.clickedit();
		
		//call the method to enter the old password
		editPOM.oldpass("admin@123");
		
		// call the method to enter the new password
		editPOM.newpassword("Sound@123");
		
		// call the method to enter the password again to confirm it is same.
		editPOM.confirmpassword("Sound@123");
		
		// call the method to save the changes
		editPOM.save();
		
		// To verify the Text "Your new profile has been saved" is displayed.
		String Expectedmsg = "Your new profile has been saved";
		WebElement Actual = driver.findElement(By.xpath("// div [@class ='alert alert-info']"));
		String Actmsg = Actual.getText();
		Assert.assertEquals(Actmsg, Expectedmsg);
}
}

