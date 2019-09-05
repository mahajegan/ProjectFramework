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


public class FeaturesPOM {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public String enteredTitletext;
	public WaitTypes WaitTypes;
	public PropertiesPOM PropertiesPOM;
	public String enteredname;
	
	public FeaturesPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")
	public WebElement properties; 
	
	@FindBy(xpath="//*[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-property']")
	public WebElement propertiesmenu;
	
	@FindBy(linkText="Features")
	public WebElement features;
	
	@FindBy(xpath="//*[@class='form-wrap']/h2")
	public WebElement addnewfeature;
	
	@FindBy(id="tag-name")
	public WebElement tagname;
	
	@FindBy(id="tag-slug")
	public WebElement tagslug;
	
	@FindBy(id="tag-description")
	public WebElement tagdescription;
	
	@FindBy(id="submit")
	public WebElement addnewbutton;
	
	@FindBy(xpath="//*[@class='wp-list-table widefat fixed striped tags']")
	public WebElement featuretable;
	
	@FindBy(xpath="//*[contains(text(),'TAGNAME')]")
	public WebElement myfeaturetitle;
	
	@FindBy(id="tag-search-input")
	public WebElement searchfield;
	
	@FindBy(id="search-submit")
	public WebElement searchsubmit;
	
	//hovering on the properties link for the next test case to start
	public void propertieshover(){
		this.properties.isDisplayed();
		Actions act = new Actions(driver);
		act.moveToElement(properties).build().perform();
	}
	
	//Verify the links present in the Properties Mouse Over
	public void verifyPropertiesHover(){
		WaitTypes = new WaitTypes(driver);
		WaitTypes.presenceElementLocated(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']"), 30);
		this.properties.isDisplayed();
		Actions act = new Actions(driver);
		act.moveToElement(properties).build().perform();
		
		//Fetch all the links of the Properties
		List<WebElement> actuallinks = driver.findElements(By.xpath("//*[@class='wp-submenu wp-submenu-wrap']"));
		
		//Storing the size of the links in linktext
		String [] actuallinktext = new String[actuallinks.size()];
		
		
		String expectedlinks[] = {"Properties","All Properties","Add New","Features","Regions","Properties Settings"};
		
		try{
		//Extract the link names for each link element
		int i=0;
		for (WebElement e:actuallinks){
			actuallinktext[i]=e.getText();
			if (actuallinktext[i].contains(expectedlinks[i])){
				logger.log(LogStatus.INFO, "Verified Link in Properties:" +actuallinktext[i]);
				//System.out.println(actuallinktext[i]);
				i++;
				}
			} 
		}
		catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
		logger.log(LogStatus.PASS, "Verified all link when hovering on Properties");
	}

	//Click on Features link
	public void clickFeatures(){
		this.features.click();
		this.addnewfeature.isDisplayed();
		logger.log(LogStatus.PASS, "Clicked on Features and Add New Feature Page is displayed");
	}
	
	//Add a tagname/ feature name
	public void addtagname(String tagnametosend){
		this.tagname.click();
		this.tagname.sendKeys(tagnametosend);
		logger.log(LogStatus.INFO, "Entered Tag Name: " +tagnametosend);
	}

	//verify the tag name
	public void verifytagname(){
		this.tagname.isDisplayed();
		enteredname = this.tagname.getAttribute("value");
		Assert.assertEquals(enteredname,"TAGNAME");	
		logger.log(LogStatus.PASS, "Verified the Entered Tag Name");
	}
	
	//add a slug name
	public void addslug(String slugnametosend){
		this.tagslug.click();
		this.tagslug.sendKeys(slugnametosend);
		logger.log(LogStatus.INFO, "Entered Slug Name: "+slugnametosend);
	}
	
	//verify the slug name
	public void verifyslug(){
		this.tagslug.isDisplayed();
		String enteredslugname = this.tagslug.getAttribute("value");
		Assert.assertEquals(enteredslugname,"SLUGNAME");
		logger.log(LogStatus.PASS, "Verified the Entered Slug");
	}
	
	//add description
	public void adddescription(String description){
		this.tagdescription.click();
		this.tagdescription.sendKeys(description);
		logger.log(LogStatus.INFO, "Add a new description: " +description);
	}
	
	//verify the description
	public void verifytagdescription(){
		this.tagdescription.isDisplayed();
		String entereddescription = this.tagdescription.getAttribute("value");
		Assert.assertEquals(entereddescription,"DESCRIPTION CONTENT BY MAHA");
		logger.log(LogStatus.PASS, "Verified the Entered Description");
	}
	
	//click on add new button
	public void clickaddnewbutton(){
		this.addnewbutton.click();
		logger.log(LogStatus.PASS, "Clicked on Add New Feature Button");
	}
	
	//verify the feature table whether the newly added feature is available or not
	public void verifyfeaturetable(){
		this.featuretable.isDisplayed();
		if (this.featuretable.getText().contains(enteredname)){
			logger.log(LogStatus.PASS, "Added New Feature is available in the feature Table");
		}
		else
			logger.log(LogStatus.FAIL, "New Feature is not added to the Table");	
	}
	
	//click on the newly added feature check box
	public void newfeaturecheckbox(){
		this.myfeaturetitle.isDisplayed();
		this.myfeaturetitle.click();
		logger.log(LogStatus.PASS, "Above Added Feature Check box is displayed and is clicked");
	}
	
	//search for a new feature that we added above
	public void searchfornewfeature(){
		this.searchfield.isSelected();
		this.searchfield.sendKeys(enteredname);
		this.searchsubmit.click();
	}
	
}