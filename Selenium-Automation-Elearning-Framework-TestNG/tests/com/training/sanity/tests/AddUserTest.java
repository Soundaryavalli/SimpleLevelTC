package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.training.generics.ScreenShot;
import com.training.pom.AddUserPOM;

public class AddUserTest extends AdminLoginTests {

	private AddUserPOM adduser;
	public ScreenShot screenshot;
		
	@Test(priority =2)
	public void validAddUserTest() throws InterruptedException {
		System.out.println("Add  User Scenario");
		 adduser = new AddUserPOM(driver,logger);
		screenshot = new ScreenShot(driver);
		
		// To click on add user link
		adduser.adduserlink();
		screenshot.captureScreenShot("Step1");
		
		// To enter the firstname
		adduser.firstname("Sahi");
		screenshot.captureScreenShot("Step2");
		
		// To enter the lastname
		adduser.lastname("Suda");
		screenshot.captureScreenShot("Step3");
		
		
		// To enter the email
		adduser.email("Sahi1231@gmail.com");
		screenshot.captureScreenShot("Step4");
		
		
		
		//TO enter the phone number
		adduser.phone("34617123487");
		screenshot.captureScreenShot("Step5");
		
		//To enter the Login name
		adduser.username("Sahi");
		screenshot.captureScreenShot("Step6");
		
		// To click on the enter password radio button
		adduser.radiopassclick();
		screenshot.captureScreenShot("Step7");
		
		// TO enter the password
		adduser.password("sahi123");
		screenshot.captureScreenShot("Step8");
		
		// To click on profile list box
		adduser.clickprofile();
		screenshot.captureScreenShot("Step9");
		
		//To enter the Trainer in the text box
		adduser.enterprofile("Trainer");
		screenshot.captureScreenShot("Step10");
		
		//To select the Trainer Profile from the dropdown
		adduser.selprofile();
		screenshot.captureScreenShot("Step11");
		
		//To click on add button 
		adduser.addbtn();
		screenshot.captureScreenShot("Step12");
		
		// To Verify the user created
		 adduser.usercreated();
		 screenshot.captureScreenShot("Step13");
		 
		 // TO click on admin link
		adduser.adminlink();
		screenshot.captureScreenShot("Step14");
		
		// To click on add user to course link 
		adduser.addusertocourse();
		screenshot.captureScreenShot("Step15");
		
		// To select the first letter of user name
		adduser.selfname();
		screenshot.captureScreenShot("Step16");
		
		// To Select the user from the list box
		adduser.seluser();
		screenshot.captureScreenShot("Step17");
		
		//To Select the first letter of course name
		adduser.selfcoursename();
		screenshot.captureScreenShot("Step18");
		
		// To Select the course from the list box
		adduser.selcourse();
		screenshot.captureScreenShot("Step19");
		
		//To click on add course to users
		adduser.addcourse();
		screenshot.captureScreenShot("Step20");
		
		//To verify the user is subscribed to course
		adduser.usersubscribedtocourse();
		screenshot.captureScreenShot("Step21");
	}
		
}
