package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.trianing.waits.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PropertiesPOM {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public String enteredTitletext;
	public WaitTypes WaitTypes;
	
	
	public PropertiesPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")
	public WebElement properties; 
	
	@FindBy(xpath="//*[contains(text(),'Add New') and @class='page-title-action']")
	public WebElement AddNewLink;
	
	@FindBy(xpath="//*[@class='current']")
	public WebElement AllLink;
	
	@FindBy(xpath="//*[@class='wp-heading-inline']")
	public WebElement AddPropertyHeadline;
	
	@FindBy(id="title")
	public WebElement titletext;
	
	@FindBy(id="content")
	public WebElement contenttext;
	
	@FindBy(xpath="//*[@class='button button-primary button-large']")
	public WebElement publishbutton;
	
	@FindBy(xpath="//*[@id='message']/p")
	public WebElement publishmessage;
	
	@FindBy(xpath="//*[@id='message']/p/a")
	public WebElement viewpostlink;
	
	@FindBy(xpath="//*[@class='property-title']/h2")
	public WebElement newpropertytitle;
	
	//Click on Properties Link
	public void clickproperties(){
		WaitTypes = new WaitTypes(driver);
		WaitTypes.presenceElementLocated(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']"), 30);
		this.properties.click();
	}
	
	//Verifying Properties Title
	public void verifypropertiestitle(){
		String actualtitle = this.driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "Properties ‹ Real Estate — WordPress");
		logger.log(LogStatus.PASS, "Verified Properties Title Page");
	}
	
	// Verifying All Properties and Add New Links after clicking Properties
	public void verifylinks(){
		this.AddNewLink.isDisplayed();
		this.AllLink.isDisplayed();
		logger.log(LogStatus.PASS, "Verified All Link and Add New Links in Properties Page");
	}
	
	//Click on Add New Link
	public void clickAddNew(){
		this.AddNewLink.click();
		this.AddPropertyHeadline.isDisplayed();
		logger.log(LogStatus.PASS, "Verified Add Property Heading after clicking Add New");
	}
	
	//Enter the Title for the Property
	public void enterTitle(String propertytitle){
		this.titletext.click();
		this.titletext.sendKeys(propertytitle);
		enteredTitletext = this.titletext.getAttribute("value");
		Assert.assertEquals(enteredTitletext, "New Property Title");
		logger.log(LogStatus.PASS, "Entered Title for the new property: " +propertytitle);
	}	
	
	//Enter Description for the Property
		public void enterContent(String propertycontent){
		this.contenttext.click();
		this.contenttext.sendKeys(propertycontent);
		String enteredContentText=this.contenttext.getAttribute("value");
		Assert.assertEquals(enteredContentText, "My Propery Content and Description");
		logger.log(LogStatus.PASS, "Entered Content for the new property: " +propertycontent);
	}
	
		//Clicking on Publish button 
		public void clickpublish(){
			this.publishbutton.click();
			this.publishmessage.isDisplayed();
			this.viewpostlink.isDisplayed();
			logger.log(LogStatus.PASS, "Clicked on Publish Button");
		}
	
		//Clicking on ViewPost Link
		public void clickViewPost(){
			this.viewpostlink.click();
			this.newpropertytitle.isDisplayed();
			logger.log(LogStatus.PASS, "Verified the Heading of the Entered title");
			
		}
		public void back(){
			this.driver.navigate().back();
		}
}

