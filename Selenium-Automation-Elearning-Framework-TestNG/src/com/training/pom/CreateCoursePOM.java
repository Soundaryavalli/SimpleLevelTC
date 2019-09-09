package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trianing.waits.WaitTypes;

public class CreateCoursePOM {
	
private WebDriver driver; 
private ExtentTest logger;
private WaitTypes wait;

	
	public  CreateCoursePOM (WebDriver driver,ExtentTest logger,WaitTypes wait) 
	{
		this.driver = driver; 
		this.logger =logger;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath ="//*[@class ='btn btn-primary btn-large']")
	private WebElement Coursebtn;
	
	@FindBy(xpath ="//*[@class='list-group-item list-course']/a")
	private WebElement Courselink;
	
	@FindBy(xpath ="//*[@class ='col-md-12']/h2[1]")
	private WebElement Coursepage;
	
	@FindBy(name ="search_term")
	private WebElement SearchTextbox;
	
	@FindBy(xpath ="//*[@class ='btn btn-default']")
	private WebElement Search;

	@FindBy(xpath ="//*[contains(text(),'Search results for: java-selenium')]")
	private WebElement Coursedetails;
	
	@FindBy(xpath ="//*[@class='col-xs-12 col-sm-6 col-md-4']/div[1]/div[2]/div[1]/h4/a")
	private WebElement title;
	
	@FindBy(xpath ="//*[@class ='btn btn-success btn-sm']")
	private WebElement Subscribe;
	
	@FindBy(xpath ="//*[@class ='label-subscribed text-success']")
	private WebElement SubscribeSuccess;
	
	
	@FindBy(xpath ="//*[@class ='alert alert-info']")
	private WebElement Verifysuccessfullsubscriptionmsg;
	
	@FindBy(xpath ="//*[@class='my-course ']/a")
	private WebElement mycoursetab;
	
	@FindBy(xpath ="//h4[@class='course-items-title']/a[@href='http://elearning.upskills.in/courses/JAVASELENIUM1/index.php?id_session=0']")
	private WebElement selcourselink;
	
	@FindBy(xpath ="//*[contains(text(),'Project1')]")
	private WebElement projecticon;
	
	@FindBy(xpath ="//*[@title='[Blog: Project1] A task for me']")
	private WebElement mytasklink;
	
	@FindBy(xpath ="//a[@href='blog.php?action=execute_task&blog_id=36&task_id=60&post_id=96#add_comment']")
	private WebElement seltask;
	
	@FindBy(id ="add_post_title")
	private WebElement Titlecomment ;
	
	@FindBy(xpath ="//html[@dir='ltr']")
	private WebElement comment ;
	
	@FindBy(id ="add_post_save")
	private WebElement savecomment ;
	
	public void Course() throws InterruptedException
	{
		
		Thread.sleep(3000);
		try {
			if (this.Coursebtn.isDisplayed())
			{
				this.Coursebtn.click();
				logger.log(LogStatus.PASS, "Course Catalog button is Clicked");
			}
			
		} catch (Exception e) {
					
				this.Courselink.click();
						
				logger.log(LogStatus.PASS,"Course Catalog link is Clicked");
			
			e.printStackTrace();
		}
	
	}
	public void Coursepage()
	{
		String Expected ="Courses catalog";
		String Actual = this.Coursepage.getText();
		System.out.println(Actual);
		if(Actual.equals(Expected))
		{
			Assert.assertEquals(Actual, Expected,"Course Page is Lanuched");
			logger.log(LogStatus.PASS,"Course Page is Lanuched");
		}else
			Assert.assertEquals(Actual, Expected,"Course Page is not Lanuched");
			logger.log(LogStatus.PASS,"Course Page is not Lanuched");
		
	}
	
	public void SearchTextbox(String Search)
	{
		this.SearchTextbox.sendKeys(Search);
		String enteredcourse =this.SearchTextbox.getAttribute("value");
		System.out.println(enteredcourse);
		Assert.assertEquals(this.SearchTextbox.getAttribute("value"), Search);
		logger.log(LogStatus.PASS, "Entered Course:"+enteredcourse);
	}
	
	public void Search()
	{
		this.Search.click();
		String text =this.Search.getText();
		Assert.assertTrue(text.contains("Search"));
		logger.log(LogStatus.PASS, "Click on Search");
	}
	
	public void Coursedetails()
	{
		String Expected ="Search results for: java-selenium";
		String Actual = Coursedetails.getText();
		if(Actual.equals(Expected))
		{
			Assert.assertEquals(Actual, Expected,"Course Details is Displayed");
			logger.log(LogStatus.PASS, "The Course details is displayed");
		}else
			Assert.fail("Course Details is not Displayed");
			
			
}
	public void Subscribe() throws InterruptedException
	{
	
		Thread.sleep(3000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			try
			{
				if (this.SubscribeSuccess.isDisplayed())
					this.mycoursetab.click();
					String Actual =driver.findElement(By.linkText(" My courses")).getText();
					Assert.assertTrue(Actual.contains("courses"));
					logger.log(LogStatus.PASS,"My course Tab is clicked");
										
			} 
			catch (Exception e)
			{
					this.Subscribe.click();
					String Actual=this.Verifysuccessfullsubscriptionmsg.getText();
					System.out.println(Actual);
					Assert.assertTrue(Actual.contains("registered")," Success Message is  displayed");
					logger.log(LogStatus.PASS,"Successfull subscription message is  displayed");
					this.mycoursetab.click();
												
					e.printStackTrace();
			}
			
	}
	
	
		
	public void selcourselink()
	{
		this.selcourselink.click();
		logger.log(LogStatus.PASS,"Course link is selected");
	}
	
	public void projecticon() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		wait =new WaitTypes(driver);
		wait.elementToBeClickable(By.xpath("//*[contains(text(),'Project1')]"),30);
		 this.projecticon.click();
		String actual = driver.findElement(By.linkText("Project1")).getText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("Project1"));
		logger.log(LogStatus.PASS,"Project link is clicked");
	}
	public void mytasklink()
	{
		this.mytasklink.click();
				
		String actual = driver.findElement(By.linkText("Automation Tester")).getText();
		Assert.assertEquals(actual,"Automation Tester");
		System.out.println(actual);
		logger.log(LogStatus.PASS, "Automation Tester Task is clicked");
	}
	
	public void seltask()
	{
		this.seltask.click();
		String actual = driver.findElement(By.linkText("Automation Tester")).getText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("Automation Tester"));
		
	}
	
	public void titlecomment(String title)
	{
		this.Titlecomment.sendKeys(title);
		Assert.assertEquals(this.Titlecomment.getAttribute("value"),title);
		logger.log(LogStatus.PASS, "Entered Title:" +title);
	}
	
	public void comment(String comment)
	{
		//driver.switchTo().frame("cke_wysiwyg_frame cke_reset");
		wait.presenceElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"),30);
			driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")).sendKeys(comment);	
		String text = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")).getAttribute("value");
		System.out.println(text);
		//Assert.assertEquals(this.comment.getAttribute("value"), comment);
		logger.log(LogStatus.PASS,"Entered Comment :"+comment);
	}
	
	public void savecomment()
	{
		this.savecomment.click();
		String Text = this.savecomment.getText();
		System.out.println(Text);
		Assert.assertTrue(Text.contains("Save"));
		logger.log(LogStatus.PASS,"Save button is clicked");
		
	}
}
