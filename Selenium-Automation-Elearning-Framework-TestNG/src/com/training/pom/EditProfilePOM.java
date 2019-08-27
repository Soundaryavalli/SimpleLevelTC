	package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	public class EditProfilePOM  {
	
		private WebDriver driver; 
		
		public EditProfilePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		
		
		@FindBy(xpath ="//*[@class ='homepage ']/a[1]")
		private WebElement Homepage;
		
		@FindBy(xpath = "//*[@class = 'list-group-item profile-social']/a[1]")
		private WebElement Edit;
		
		@FindBy(id = "profile_password0")
		private WebElement oldpass;
		
		@FindBy(id = "password1")
		private WebElement newpassword;
		
		@FindBy(id = "profile_password2")
		private WebElement confirmpassword;
		
		@FindBy(id = "profile_apply_change")
		private WebElement save;
		
		public void Homepage() throws InterruptedException
		{
			System.out.println("Click on Home page");
			Thread.sleep(5000);
			this.Homepage.click();
		}
		
		public void clickedit() throws InterruptedException
		{
			Thread.sleep(5000);
			this.Edit.click();
		}
		
		public void newpassword(String newpassword)
		{
			this.newpassword.sendKeys(newpassword);
			
		}
		public void confirmpassword(String confirmpassword )
		{
			this.confirmpassword.sendKeys(confirmpassword);
			
		}

		public void oldpass(String pass)
			{
				this.oldpass.sendKeys(pass);
			}

		public void save()
		{
			
		this.save.click();
		
		}
}
	