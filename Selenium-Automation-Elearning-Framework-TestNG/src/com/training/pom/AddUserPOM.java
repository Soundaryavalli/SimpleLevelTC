package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddUserPOM {

	private WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	
	
	public AddUserPOM(WebDriver driver,ExtentTest logger) {
		this.driver = driver; 
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath ="//a[@href='user_add.php']")
	private WebElement adduser;
	
	@FindBy (id ="firstname")
	private WebElement firstname;
	
	@FindBy (id ="lastname")
	private WebElement lastname;
	
	@FindBy (id ="email")
	private WebElement email;
	
	@FindBy (id ="phone")
	private WebElement phone;
	
	@FindBy (id ="username")
	private WebElement username;
	
	@FindBy (name ="password[password_auto] and @value ='1']")
	private WebElement newpassword;
	
	@FindBy (xpath ="//input[@name ='password[password_auto]'and @value ='0']")
	private WebElement enterpassword;
	
	@FindBy (id ="password")
	private WebElement password;
	
	@FindBy (xpath ="//*[@class='filter-option']")
	private WebElement profile;
	
	@FindBy (xpath ="//*[@class='form-control' and @aria-label='Search']")
	private WebElement enterprofile;
	
	@FindBy (xpath ="//*[@class='dropdown-menu inner ']/li/a[1]")
	private WebElement selprofile;
	
	@FindBy (name ="submit")
	private WebElement addbtn;
	
	@FindBy (xpath ="//*[@class='alert alert-info']")
	private WebElement usercreated;
	
	@FindBy (xpath ="//*[@class='breadcrumb']/li/a[1]")
	private WebElement adminlink;
	
	@FindBy (xpath ="//a[@href='subscribe_user2course.php']")
	private WebElement addusertocourselink;
	
	@FindBy (xpath ="//*[@name='firstLetterUser']/option[@value ='S']")
	private WebElement selfname;
	
	@FindBy (xpath ="//select[@name='UserList[]']")
	private WebElement seluser ;
	
	@FindBy (xpath ="//*[@name='firstLetterCourse']/option[@value ='B']")
	private WebElement selfcoursename;
	
	@FindBy (xpath ="//*[@name='CourseList[]']/option[@value ='BL']")
	private WebElement selcoursename;
	
	@FindBy (xpath ="//button[@class='btn btn-primary']")
	private WebElement addcoursebtn;
	
	@FindBy (xpath ="//*[@class='alert alert-success']")
	private WebElement usersaddedtocourse;
	
	
	public void adduserlink()
	{
	 this.adduser.click();	
	 
	}
	
	public void firstname(String fname) 
	{
	  this.firstname.clear();
		this.firstname.sendKeys(fname);
		String actual =this.firstname.getAttribute("value");
		System.out.println(actual);
	    Assert.assertTrue(actual.contains(fname));
		logger.log(LogStatus.INFO, "Entered Firstname : " +fname);
			
	}
	public void lastname(String lname)
	{
	  this.lastname.clear();
		this.lastname.sendKeys(lname);
		Assert.assertEquals(this.lastname.getAttribute("value"), lname);
		logger.log(LogStatus.INFO, "Entered Lastname : " +lname);
		
	}
	
	public void email(String mail)
	{
	  this.email.clear();
		this.email.sendKeys(mail);
		Assert.assertEquals(this.email.getAttribute("value"), mail);
		logger.log(LogStatus.INFO, "Entered email address : " +mail);
		
	}
	
	public void phone(String phone)
	{
	  this.phone.clear();
		this.phone.sendKeys(phone);
		Assert.assertEquals(this.phone.getAttribute("value"), phone);
		logger.log(LogStatus.INFO, "Entered phone number : " +phone);
		
	}
	
	public void username(String uname)
	{
	  this.username.clear();
		this.username.sendKeys(uname);
		Assert.assertEquals(this.username.getAttribute("value"), uname);
		logger.log(LogStatus.INFO, "Entered username : " +uname);
		
		
	}
	
	public void radiopassclick()
	{
	
		 this.enterpassword.click();
		 logger.log(LogStatus.PASS, "Enter Password radio button is clicked");
	 if (this.enterpassword.isSelected())
	 {
		
		 logger.log(LogStatus.PASS,"Enter Password is selected");
	 }
	 else
	 { 
		 logger.log(LogStatus.FAIL, "Enter Password is not selected");
	}
	 
	}
	
	public void password(String pass)
	{
	  this.password.clear();
		this.password.sendKeys(pass);
		Assert.assertEquals(this.password.getAttribute("value"), pass);
		logger.log(LogStatus.INFO, "Enter the Password" +pass);
		
		
			
	}
	public void clickprofile()
	{
	 this.profile.click();
	 logger.log(LogStatus.PASS, "Profile is clicked");
	}
	
	public void enterprofile(String enterprofile)
	{
	 this.enterprofile.sendKeys(enterprofile);
	 logger.log(LogStatus.INFO, "Entered Profile : " +enterprofile);
	 
	}
	
	public void selprofile()
	{
	 this.selprofile.click();
	 logger.log(LogStatus.PASS, "Profile is selected");
	 
	}
	
	public void addbtn()
	{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 //js.executeScript("window.scrollTo(0,200)");
	 this.addbtn.click();
	 logger.log(LogStatus.PASS, "Add button is clicked");
	}
	
	public void usercreated()
	{
			
	 if (this.usercreated.isDisplayed())
	 {
		
		 System.out.println("New User got added");
		 logger.log(LogStatus.PASS, "New User got added");
	 }
	 else
	 {
		 System.out.println("New User not added");
	 	logger.log(LogStatus.FAIL, "New User not added");
	 }
	}
	
	public void adminlink()
	{
	 this.adminlink.click();
	 logger.log(LogStatus.PASS, "Administartion link is clicked");
	
	}
	
	public void addusertocourse()
	{
	 this.addusertocourselink.click();
	 logger.log(LogStatus.PASS, "Add User to Course link is clicked");
	}
	
	public void selfname()
	{
	 this.selfname.click();
	 logger.log(LogStatus.PASS, "Firstletter of the firstname is selected");
	}
	
	public void seluser()
	{
		//get all the options from drop down
		Select sel = new Select(this.seluser);
		List<WebElement> allOptions = sel.getOptions();
		int selectoptions = allOptions.size();
		System.out.println(selectoptions);
		if(allOptions.size() >0)
		{
		sel.selectByIndex(allOptions.size()-1);
		System.out.println(allOptions.get(allOptions.size()-1).getText());
		 	
	   	 logger.log(LogStatus.PASS, "User is selected");
		}
	   	 else
	   		 Assert.fail("User is not Selected");
	}
	
	public void selfcoursename()
	{
	 this.selfcoursename.click();
	}
	public void selcourse()
	{
	 this.selcoursename.click();
	 if(this.selcoursename.isSelected())
	 {
		 System.out.println("Coursename is Selected");
	 logger.log(LogStatus.PASS, "Coursename is selected");
	 }
	 else
	 {
		 System.out.println("Coursename is not selected");
	 	logger.log(LogStatus.FAIL, "Coursename is not selected");
	}
	}
	public void addcourse()
	{
		this.addcoursebtn.click();
		logger.log(LogStatus.PASS, " Add Course Button is clicked");
	}
	public void usersubscribedtocourse()
	{
		if(this.usersaddedtocourse.isDisplayed())
		{
			System.out.println("User is Subscribed to  Selected Course");
			logger.log(LogStatus.PASS, "User is Subscribed to  Selected Course");
		}
		else
		{
			System.out.println("User is not Subscribed to  Selected Course");
		logger.log(LogStatus.FAIL, "User is not Subscribed to  Selected Course");
			
		}
	}
	
}
