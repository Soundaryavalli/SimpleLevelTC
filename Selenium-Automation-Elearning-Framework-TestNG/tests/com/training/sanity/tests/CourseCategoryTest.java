package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.pom.CourseCategoryPOM;


public class CourseCategoryTest  extends AdminLoginTests {

	
	private CourseCategoryPOM CourseCategoryPOM;
	
	@Test(priority =2)
	public void validCourseCategoryTest() throws InterruptedException, AWTException
	{
		
		System.out.println("CourseCategory Scenario");
		Thread.sleep(3000);
		
		CourseCategoryPOM = new CourseCategoryPOM(driver,logger);
		
		// To click on Administrator Tab
		CourseCategoryPOM.admintab();
		
		//TO Click on Course Categories link
		CourseCategoryPOM.coursecategorylink();
		
		//To Verify the Course Category Page is displayed
		CourseCategoryPOM.coursecategorypage();
			
		//TO click on add Category icon
		CourseCategoryPOM.addcategory();
		
		//To Verify the add Category Page is displayed
		CourseCategoryPOM.addcategorypage();
		
		//To enter the Category Code
		CourseCategoryPOM.categorycode("BL");
		
		//To enter the Category name
		CourseCategoryPOM.categoryname("Blended Learning");
		
		//To Click on radio button of adding course in this category
		CourseCategoryPOM.radio();
		
		// To click on add Category button
		CourseCategoryPOM.addcategorybtn();
		
		//To Verify the Category is created
		CourseCategoryPOM.categorycreated();
		
		//To Click on Administration link
		CourseCategoryPOM.adminlink();
		
		// To Click on Create Course link
		CourseCategoryPOM.createcourse();
		
		// TO Verify the Create Course page is displayed
		CourseCategoryPOM.createcoursepage();
		
		//To enter the Course Title
		CourseCategoryPOM.CourseTitle("WebTesting3");
		
		//To Enter the Course Code
		CourseCategoryPOM.CourseCode("WT3");
		
		// TO select the on Category from list box
		CourseCategoryPOM.selcategory("Blended Learning (BL)");
		
		// To click on Teacher list box
		CourseCategoryPOM.clear();
		
		// To enter the Teacher name in the text box
		CourseCategoryPOM.enterTeachername("Manzoor");
		
		// To select the teacher from the dropdown list
		CourseCategoryPOM.SelTeacher();
		
		// To select the language from the list box
		CourseCategoryPOM.language();
		
		//To click on submit button
		CourseCategoryPOM.coursesubmit();
		
		// To Verify the course is displayed
		CourseCategoryPOM.coursedisplay();
		
}
}

