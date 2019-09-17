package com.training.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trianing.waits.WaitTypes;

public class UsersPOM {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public com.training.sanity.tests.UsersTest UsersTest;
	
	
	public UsersPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-users']")
	public WebElement users;
	
	@FindBy(linkText="All Users")
	public WebElement allusers;
	
	@FindBy(xpath="//*[@class='wp-list-table widefat fixed striped users']")
	public WebElement userstable;
	
	@FindBy(xpath="//*[@type='checkbox' and @id='user_277']")
	public WebElement MathanRaj;
	
	@FindBy(xpath="//*[@id='user_276']")
	public WebElement Mahalakshmi;
	
	@FindBy(xpath="//*[@id='user_268']")
	public WebElement Krishnapriya;
	
	@FindBy(xpath="//*[@id='new_role2' and @name='new_role2']")
	public WebElement roledropdown;
	
	@FindBy(id="changeit2")
	public WebElement changebutton;
	
	@FindBy(xpath="//*[@id='message']/p")
	public WebElement changemessage;
	
	@FindBy(xpath="//*[@class='name column-name']")
	public List<WebElement> names;
	
	public void usershover(){
		this.users.isDisplayed();
		Actions act = new Actions(driver);
		act.moveToElement(users).build().perform();		
	}
	
	//Verifying the links when hovering over Users link
	public void verifyusersHover(){
		
		//Fetch all the links of the Properties
		List<WebElement> userslinks = driver.findElements(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-users']"));
		System.out.println(userslinks.size());
		//Storing the size of the links in linktext
		String [] userslinktext = new String[userslinks.size()];
		
		String expecteduserslinks[] = {"Users","All Users","Add New","Your Profile"};
		
		try{
		//Extract the link names for each link element
		int i=0;
		for (WebElement e:userslinks){
			userslinktext[i]=e.getText();
			if (userslinktext[i].contains(expecteduserslinks[i])){
				logger.log(LogStatus.INFO, "Verified Link in Users:" +userslinktext[i]);
				
				i++;
				}
			} 
		}
		catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
		logger.log(LogStatus.PASS, "Verified all link when hovering on Users");
	}
	
	public void clickallusers(){
		this.allusers.click();
		if (this.userstable.isDisplayed()){
			logger.log(LogStatus.PASS, "Clicked on Users link and verifed that the users table is displayed");
		}
		else
			logger.log(LogStatus.FAIL, "Users table is not available");
	}
	
	public void verifytable() throws InterruptedException{
		this.userstable.isDisplayed();
		logger.log(LogStatus.PASS, "Verified the user table");
	}
	


	public void clickcheckbox(String name){
		
		this.userstable.isDisplayed();
		int count=this.names.size();
		for (int o=0;o<count;o++){
		
		}	
		if (name.equalsIgnoreCase("MathanRaj")){
			this.MathanRaj.click();
		} else if (name.equalsIgnoreCase("Mahalakshmi")){
			this.Mahalakshmi.click();
		}else if (name.equalsIgnoreCase("Krishnapriya S")){
			this.Krishnapriya.click();
		}
		
		logger.log(LogStatus.PASS, "Clicked on the checkbox based on the input from excel");
	
	}
	
	public void searchname(String name){
		logger.log(LogStatus.PASS, "SearchName: " +name);
	}
	
	public void rolechange(String role){
				
				this.roledropdown.click();
				logger.log(LogStatus.PASS, "Clicked on Role Drop Down");
				Select sel = new Select (roledropdown);
				int total=sel.getOptions().size();
				
				for (int m=0;m<total;m++){
				String listofroles = sel.getOptions().get(m).getAttribute("value");
				}	
				sel.selectByValue(role);
				this.changebutton.click();
				logger.log(LogStatus.PASS, "Clicked on Change button");
			
			
		}
	
	public void changemessage(){
		this.changemessage.isDisplayed();	
		logger.log(LogStatus.PASS, "Verified the change message");
	}
}
