package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.CreateCoursePOM;
import com.training.pom.EditProfilePOM;

public class CreateCourseTest extends StudentLoginTest {
	
	private CreateCoursePOM CoursePOM;
	
	@Test(priority =2)
	public void validCreateCourseTest() throws InterruptedException
	{
		
		System.out.println("CreateCourse Scenario");
		Thread.sleep(3000);
		
		CoursePOM = new CreateCoursePOM(driver,logger,wait);
		
		// To click on Course Catalog button
		CoursePOM.Course();
		
		// Verify the Course page is displayed
		CoursePOM.Coursepage();
		
		// TO enter the course name in search text box
		CoursePOM.SearchTextbox("java-selenium");
		
		//Click on Search button
		CoursePOM.Search();
		
		// To Verify Course matching details  is displayed
		CoursePOM.Coursedetails();
		
		//Click on Subscribe button
		CoursePOM.Subscribe();
		
}
	@Test(dependsOnMethods = "validCreateCourseTest")
	public void ValidCreateTask() throws InterruptedException
	{
		CoursePOM = new CreateCoursePOM(driver,logger,wait);
			
		//To click on course link
		CoursePOM.selcourselink();
		
		//TO click on Project icon
		CoursePOM.projecticon();
		
		//To Click on name of the  task link on my task section
		
		CoursePOM.mytasklink();
		
		//To click on task link
		CoursePOM.seltask();
		
		// To Enter the Title
		
		CoursePOM.titlecomment("Task Status");
		
		//TO Enter the Comment
		CoursePOM.comment("50%");
		
		//TO save the comment
		CoursePOM.savecomment();
		
		
		
		
	}
}
