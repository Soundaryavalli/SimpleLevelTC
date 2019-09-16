package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPOM {
	
	private WebDriver driver;
	
	public SignUpPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[@href='http://elearning.upskills.in/main/auth/inscription.php']")
	private WebElement signup;
	
	@FindBy(xpath ="//*[@class='register-profile' and  @value = '1']")
	private WebElement selteacher;
	
	@FindBy(id ="registration_firstname")
	private WebElement firstname;
	
	@FindBy(id ="registration_lastname")
	private WebElement lastname;
	
	@FindBy(id ="registration_email")
	private WebElement email;
	
	@FindBy(id ="username")
	private WebElement username;
	
	@FindBy(id ="pass1")
	private WebElement pass;

	@FindBy(id ="pass2")
	private WebElement confirmpass;

	@FindBy(id ="registration_phone")
	private WebElement phone;
	
	
	@FindBy(id ="registration_submit")
	private WebElement register;
	
	@FindBy(xpath ="//*[@class='col-xs-12 col-md-12']/p")
	private WebElement verifyregsuccess;
	
	public void signup()
	{
		Actions act = new Actions(driver);
		act.moveToElement(signup).build().perform();
		act.doubleClick(signup).build().perform();
		
			}
	
	public void verifyregistration()
	{
		String exp ="Registration";
		String act =driver.findElement(By.xpath("//*[@class='col-xs-12 col-md-12']/h2")).getText();
		Assert.assertEquals(act, exp,"Registration page is opened");
	}
	public void selteacher()
	{
		 if (driver.findElement(By.xpath("//*[@class='register-profile' and  @value = '5']")).isSelected())
		 {
			this.selteacher.click();
			System.out.println("teacher is selected");
		 }
	}
	
	public void firstname(String fname)
	{
		
		this.firstname.sendKeys(fname);
		Assert.assertEquals(this.firstname.getAttribute("value"), fname);
	}
	public void lastname(String lname)
	{
		
		this.lastname.sendKeys(lname);
		Assert.assertEquals(this.lastname.getAttribute("value"), lname);
	}
	public void email(String email)
	{
		
		this.email.sendKeys(email);
		Assert.assertEquals(this.email.getAttribute("value"), email);
	}
	public void username(String uname)
	{
		
		this.username.sendKeys(uname);
		Assert.assertEquals(this.username.getAttribute("value"), uname);
	}
	public void pass(String pass)
	{
		
		this.pass.sendKeys(pass);
		Assert.assertEquals(this.pass.getAttribute("value"), pass);
	}
	public void confirmpass(String confirmpass)
	{
		
		this.confirmpass.sendKeys(confirmpass);
		Assert.assertEquals(this.confirmpass.getAttribute("value"), confirmpass);
	}
	public void phone(String phone)
	{
		
		this.phone.sendKeys(phone);
		Assert.assertEquals(this.phone.getAttribute("value"), phone);
	}
	
		public void registration()
	{
		this.register.click();
	}
	
	
	public void verifyregsuccess()
	{
		String text =this.verifyregsuccess.getText();
		System.out.println(text);
	}
}
