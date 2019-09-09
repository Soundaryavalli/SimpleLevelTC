package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import bsh.This;


public class CourseCategoryPOM {

	
private WebDriver driver;
WebDriverWait wait ;
ExtentTest logger;
ExtentReports extent;

	
	public  CourseCategoryPOM (WebDriver driver,ExtentTest logger) 
	{
		this.driver = driver; 
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@title ='Administration']")
	private WebElement admintab;

	@FindBy(xpath ="//a[@href='course_category.php']")
	private WebElement CourseCategorylink;
	
	@FindBy(xpath ="//*[@class ='breadcrumb']/li[2]")
	private WebElement CourseCategorypage;
	
	
	@FindBy(xpath ="//*[@title='Add category']")
	private WebElement AddCategory;
	
	@FindBy(xpath ="//legend['Add category']")
	private WebElement AddCategorypage;
	
	@FindBy(id ="course_category_code")
	private WebElement Categorycode;
	
	@FindBy(id ="course_category_name")
	private WebElement Categoryname;
	
	@FindBy(xpath ="//input[@name ='auth_course_child' and @value ='TRUE']")
	private WebElement radio;
	
	@FindBy(name ="submit")
	private WebElement addCategorybtn;
	
	@FindBy(xpath ="//a[@href ='http://elearning.upskills.in/main/admin/course_category.php?category=BL']")
	private WebElement categorycreated;
	
	@FindBy(xpath ="//*[@class ='active']/a[1]")
	private WebElement adminlink;
	
		
	@FindBy(xpath ="//a[@href ='course_add.php']")
	private WebElement createcourse;
	
	@FindBy(xpath ="//*[@class ='breadcrumb']/li[3]")
	private WebElement CreateCoursepage;
	
	@FindBy(id ="update_course_title")
	private WebElement CourseTitle;
	
	@FindBy(id ="visual_code")
	private WebElement CourseCode;
	
	@FindBy(xpath ="//*[@class ='select2-selection__clear']")
	private WebElement clear;
	
	
	
	@FindBy(xpath ="//*[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement selteacher;
	
	@FindBy(xpath ="//*[@class='select2-search__field']")
	private WebElement Teacher;
	
	@FindBy(xpath ="//*[@id='update_course_category_code'] ")
	private WebElement selCategory;
	
	
	@FindBy(id ="update_course_course_language")
	private WebElement Language;
	
	@FindBy(id ="update_course_submit")
	private WebElement coursesubmit;
	
	@FindBy(xpath ="//*[@class='alert alert-success']")
	private WebElement coursedisplay ;
	
	public void admintab()
	{
		this.admintab.click();
		String text = this.admintab.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Administration"));
		logger.log(LogStatus.PASS,"Admin tab is clicked");
	}

	public void coursecategorylink() throws InterruptedException
	{
		//Thread.sleep(3000);
		this.CourseCategorylink.click();
		//String text = this.CourseCategorylink.getText();
		//System.out.println(text);
		logger.log(LogStatus.PASS,"Course Category link is Clicked ");
	}
	
	public void coursecategorypage()
	{
		String Expected ="Courses categories";	
		String Actual =this.CourseCategorypage.getText();
		//System.out.println(Actual);
		
		if(Actual.equals(Expected))
		{
			System.out.println("Courses categories page is displayed");
			Assert.assertEquals(Actual, Expected);
			logger.log(LogStatus.PASS, "Courses categories page is displayed");
		}
		else
		{
			System.out.println("Courses categories page is not displayed");
			Assert.fail("Courses categories page is not displayed");
			logger.log(LogStatus.FAIL, "Courses categories page is not displayed");
		}
	}
	
	public void addcategory()
	{
	this.AddCategory.click();
	
	logger.log(LogStatus.PASS,"AddCategory is clicked");
	}
	
	public void addcategorypage()
	{
		
		String Expected ="Add category";	
		String Actual =this.AddCategorypage.getText();
		//System.out.println(Actual);
		if(Actual.equals(Expected))
		{
			Assert.assertEquals(Actual, Expected,"Add category page is displayed");
			logger.log(LogStatus.PASS,"Add category page is displayed");
		}
		else
		{
			Assert.fail("Add category page is not displayed");
			logger.log(LogStatus.FAIL,"Add category page is not displayed");
		}
	}
	
	public void categorycode(String categorycode)
	{
	this.Categorycode.sendKeys(categorycode);
	Assert.assertEquals(this.Categorycode.getAttribute("value"),categorycode);
	logger.log(LogStatus.INFO,"Enter the CategoryCode :"+categorycode);
	
	
	}
	public void categoryname(String categoryname)
	{
	this.Categoryname.sendKeys(categoryname);
	Assert.assertEquals(this.Categoryname.getAttribute("value"),categoryname);
	logger.log(LogStatus.INFO,"Enter the Categoryname:" +categoryname);
	}
	public void radio()
	{
		 this.radio.click();
		logger.log(LogStatus.PASS,"The Radio button is clicked");
	}
	
	public void addcategorybtn()
	{
		 this.addCategorybtn.click();
		 logger.log(LogStatus.PASS, "Add Category button is clicked");
		
	}
	
	public void categorycreated()
	{
		 if(this.categorycreated.isDisplayed())
		 	
			 logger.log(LogStatus.PASS, "Category is created");
		 else
		 	 logger.log(LogStatus.PASS, "Category is not created");
		 				
	}
	public void adminlink()
	{
		 this.adminlink.click();
		
	}
	
	public void createcourse()
	{
		 this.createcourse.click();
		
	}
	public void createcoursepage()
	{
		String Expected ="Create a course";	
		String Actual =this.CreateCoursepage.getText();
		
		if(Actual.equals(Expected))
		{	
			Assert.assertEquals(Actual, Expected,"Create a course page is displayed");
			logger.log(LogStatus.PASS,"Create a course page is displayed");
		}	
		else
		
			Assert.assertEquals(Actual, Expected,"Create a course page is not displayed");
			logger.log(LogStatus.PASS,"Create a course page is not displayed");
	}
	
	public void CourseTitle(String courseTitle)
	{
	this.CourseTitle.sendKeys(courseTitle);
	Assert.assertEquals(this.CourseTitle.getAttribute("value"),courseTitle);
	logger.log(LogStatus.INFO,"Enter the Course Title :" +courseTitle);
	
	}
	public void CourseCode(String coursecode)
	{
	this.CourseCode.sendKeys(coursecode);
	Assert.assertEquals(this.CourseCode.getAttribute("value"),coursecode);
	logger.log(LogStatus.INFO,"Enter the Course code :" +coursecode);
	
	}
	
	public void clear()
	{
	this.clear.click();	
	}
	
	public void enterTeachername(String teachername) 
	{
			this.Teacher.click();
			this.Teacher.sendKeys(teachername);
			System.out.println(teachername);
			Assert.assertEquals(this.Teacher.getAttribute("value"),teachername);
			logger.log(LogStatus.INFO,"Enter the Teacher name:" +teachername);
			        		
	}
public void SelTeacher() throws InterruptedException
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(selteacher));
		this.selteacher.click();
		logger.log(LogStatus.PASS,"Teacher is selected");
		}
		
public void selcategory(String categoryName)
{
	Select sel = new Select(this.selCategory);
	sel.selectByVisibleText(categoryName);
	System.out.println(categoryName);
	String Actual =this.selCategory.getAttribute("value");
	System.out.println(Actual);
			
	Assert.assertTrue(this.selCategory.getAttribute("value").contains("BL"));
	logger.log(LogStatus.INFO,"Enter the categoryName :" +categoryName);
	
}
	
	public void language()
	{
		String Actual =this.Language.getAttribute("value");
		System.out.println(Actual);
		String Expected = "english";
		Assert.assertEquals(Actual, Expected,"English Language is selected");
		logger.log(LogStatus.PASS,"English Language is selected");
		
	}
	
	public void coursesubmit()
	{
		this.coursesubmit.click();
		
	}
	public void coursedisplay()
	{
		String text = this.coursedisplay.getText();
		Assert.assertTrue(text.contains("added"));	
		if(this.coursedisplay.isDisplayed())
				logger.log(LogStatus.PASS,"Course list is displayed");
		else
				logger.log(LogStatus.FAIL, "Course list is not displayed");
	}
}