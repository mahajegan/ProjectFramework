package com.training.pom;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup.All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.trianing.waits.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.training.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RegionsPOM {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public String enteredTitletext;
	public WaitTypes WaitTypes;
	public PropertiesPOM PropertiesPOM;
	public FeaturesPOM FeaturesPOM;
	public static String enteredtag;
	
	
	public RegionsPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		PageFactory.initElements(driver, this);
		FeaturesPOM = new FeaturesPOM(driver, logger, WaitTypes);
	}
	
	@FindBy(xpath="//*[@value='-1']")
	public WebElement noneregion;
	
	@FindBy(xpath="//*[@value='41']")
	public WebElement plotsregion;
	
	@FindBy(xpath="//*[@value='40']")
	public WebElement villasregion;
	
	@FindBy(linkText="Regions")
	public WebElement region;
	
	@FindBy(xpath="//*[@class='form-wrap']/h2")
	public WebElement regionsheading;
	
	@FindBy(id="parent")
	public WebElement parent;
	
	@FindBy(xpath="//*[@class='postform' and @id='parent']")
	public WebElement parentregiondropdown;
	
	@FindBy(xpath="//*[contains(text(),'REGIONSTAGNAME')]")
	public WebElement myregiontitle;
	
	@FindBy(xpath="//*[@id='submit' and @value='Add New Region']")
	public WebElement addnewregion;
	
	@FindBy(xpath="//*[@class='wp-list-table widefat fixed striped tags']")
	public WebElement regiontable;
	
	@FindBy(id="tag-search-input")
	public WebElement searchfield;
	
	@FindBy(id="search-submit")
	public WebElement searchsubmit;
	
	//verify the tagname/regions name
	public void verifytagname(){
		this.FeaturesPOM.tagname.isDisplayed();
		enteredtag = this.FeaturesPOM.tagname.getAttribute("value");
		Assert.assertEquals(enteredtag,"REGIONSTAGNAME");	
		logger.log(LogStatus.PASS, "Verified the Entered Tag Name");
	}
	
	//verify the slug name
	public void verifyslug(){
		this.FeaturesPOM.tagslug.isDisplayed();
		String enteredslugname = this.FeaturesPOM.tagslug.getAttribute("value");
		Assert.assertEquals(enteredslugname,"SLUGNAME");
		logger.log(LogStatus.PASS, "Verified the Entered Slug");
	}

	//verify the description
	public void verifytagdescription(){
		this.FeaturesPOM.tagdescription.isDisplayed();
		String entereddescription = this.FeaturesPOM.tagdescription.getAttribute("value");
		Assert.assertEquals(entereddescription,"DESCRIPTION CONTENT BY MAHA");
		logger.log(LogStatus.PASS, "Verified the Entered Description");
	}
	
	//Click on Regions link
	public void clickRegions(){
		this.region.click();
		this.regionsheading.isDisplayed();
		logger.log(LogStatus.PASS, "Clicked on Regions Link");
	}
	
	//clicking on parent region drop down 
	public void parentregiondropdown(){
		this.parentregiondropdown.isDisplayed();
		this.parentregiondropdown.click();
		logger.log(LogStatus.INFO, "Clicked on Parent Region Drop Down");
	
	}
	//verify the parent region links - None, Villa, Plot
	public void verifyparentregion(){
		this.noneregion.isDisplayed();
		this.villasregion.isDisplayed();
		this.plotsregion.isDisplayed();
		logger.log(LogStatus.PASS, "None, Plot, Villa are displayed");
	}
	
	//Select Parent Region as Villa
	public void selectparentregion(){
		this.villasregion.click();
		logger.log(LogStatus.PASS, "Clicked on Villas");
	}
	
	//Click on the new Region check box - that we added above
	public void newregioncheckbox(){
		this.myregiontitle.isDisplayed();
		this.myregiontitle.click();
		logger.log(LogStatus.PASS, "Added Region Check box is displayed and is clicked");
	}
	
	//click on add new region button
	public void clickaddRegionbutton(){
		this.addnewregion.isEnabled();
		this.addnewregion.click();
		logger.log(LogStatus.PASS, "Clicked on Add New Region Button");
	}
	
	//search for new region that we added
	public void searchfornewregion(){
		this.searchfield.isSelected();
		this.searchfield.sendKeys(enteredtag);
		this.searchsubmit.click();
	}
	
	//verify the region table to check whether the new region that we added is available or not
	public void verifyregionstable(){
		this.regiontable.isDisplayed();
		if (this.regiontable.getText().contains(enteredtag)){
			logger.log(LogStatus.PASS, "Added New Region is available in the feature Table");
		}
		else
			logger.log(LogStatus.FAIL, "New Region is not added to the Table");	
	}
	
	
}