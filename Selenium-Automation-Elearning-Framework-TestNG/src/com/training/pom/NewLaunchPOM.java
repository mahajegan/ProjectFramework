package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trianing.waits.WaitTypes;

public class NewLaunchPOM {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public String enteredvalue;

	
	
	public NewLaunchPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='navigation']/div/ul/li[2]/a")
	public WebElement newlaunch;
	//*[@id='menu-item-354']/a
	
	@FindBy(id="keyword_search")
	public WebElement keywordsearch;
	
	@FindBy(xpath="//*[@class='button fullwidth']")
	public WebElement searchbutton;
	
	@FindBy(xpath="//*[@class='button fullwidth margin-top-20']")
	public WebElement dropusaline;
	
	@FindBy(xpath="//*[@class='wpb_column vc_column_container vc_col-sm-8']/div/div/h4")
	public WebElement contactformheading;
	
	@FindBy(name="name")
	public WebElement contactformname;
	
	@FindBy(name="email")
	public WebElement contactformemail;
	
	@FindBy(name="subject")
	public WebElement contactformsubject;
	
	@FindBy(name="id:comments")
	public WebElement contactformmessage;
	
	@FindBy(xpath="//*[@class='wpcf7-form-control wpcf7-submit']")
	public WebElement contactformsubmit;
	
	@FindBy(xpath="//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	public WebElement erroralert;
	
	//Click on New Launch
	public void newlaunch(){
		this.newlaunch.isDisplayed();
		this.newlaunch.click();
		logger.log(LogStatus.PASS, "Clicked on New Launch Link");
	}
	
	//Fill in details for Find Your Home
	public void findyourhome(String city){
		this.keywordsearch.sendKeys(city);
		this.searchbutton.click();
		logger.log(LogStatus.PASS, "Give details in Find Your Home and click on Search button");
	}
	
	//Click on Drop us a line button
	public void dropusalineclick(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		this.dropusaline.isDisplayed();
		this.dropusaline.click();
		System.out.println("Drop");
		logger.log(LogStatus.PASS, "Click on Drop us a Line Link");
	}
	
	public void contactformname(String name){
		WaitTypes = new WaitTypes(driver);
		WaitTypes.presenceElementLocated(By.xpath("//*[@class='wpb_column vc_column_container vc_col-sm-8']/div/div/h4"), 30);
		this.contactformheading.isDisplayed();
		this.contactformname.sendKeys(name);
		logger.log(LogStatus.PASS, "Entered name");
	}
	
	public void contactformemail(String email){
		this.contactformheading.isDisplayed();
		this.contactformemail.sendKeys(email);
		logger.log(LogStatus.PASS, "Entered Email");
	}
	
	public void contactformsubject(String subject){
		this.contactformheading.isDisplayed();
		this.contactformsubject.sendKeys(subject);
		logger.log(LogStatus.PASS, "Entered Subject");
	}
	
	public void contactformmessage(String message){
		this.contactformheading.isDisplayed();
		this.contactformmessage.sendKeys(message);
		logger.log(LogStatus.PASS, "Entered Message");
	}
	public void contactformclick(){
		
		this.contactformsubmit.click();
		logger.log(LogStatus.INFO, "Click Submit in the Contact Form");
		if(this.erroralert.isDisplayed()){
			logger.log(LogStatus.FAIL, "Failed to Submit, Redo the form");
		}
		else
			logger.log(LogStatus.PASS, "Verified the data entered and contact form is submitted");
		
	}
	
}
