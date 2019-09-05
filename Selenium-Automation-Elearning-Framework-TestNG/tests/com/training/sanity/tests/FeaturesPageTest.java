package com.training.sanity.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import com.training.pom.*;
import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.EditProfilePOM;
import com.trianing.waits.WaitTypes;


public class FeaturesPageTest extends AdminLoginTest {

	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public PropertiesPOM PropertiesPOM;
	public FeaturesPOM FeaturesPOM;
	
	
	@Test(priority=2)
	public void RETC_044() throws InterruptedException{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "featurestest" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the FeaturesPage Test
		logger = extent.startTest("FeaturesPageTest");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		
		//Logging of Test Case 2 Start
		logger.log(LogStatus.INFO, "Executing Test Case 2 - To verify whether admin is able to create property details based on the Feature");
		
		//Initalizing the Features POM along with logger and WaitTypes
		FeaturesPOM = new FeaturesPOM(driver,logger, WaitTypes);
		
		//Verify the Links when hovering over the Properties link - logger and screen shot
		FeaturesPOM.verifyPropertiesHover();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 1");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step1");
		
		//Click on Features Link after hovering over the Properties link
		FeaturesPOM.clickFeatures();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 2");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step2");
		
		//Add a new name for the New Feature
		FeaturesPOM.addtagname("TAGNAME");
		
		//Verify the TagName for the New Feature
		FeaturesPOM.verifytagname();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 3");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step3");
		
		//Add and Verify the slugname for the new feature
		FeaturesPOM.addslug("SLUGNAME");
		FeaturesPOM.verifyslug();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 4");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step4");
		
		//Add and Verify the Description of the new feature
		FeaturesPOM.adddescription("DESCRIPTION CONTENT BY MAHA");
		FeaturesPOM.verifytagdescription();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 5");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step5");
		
		//Click on Add New Button
		FeaturesPOM.clickaddnewbutton();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 6");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step6");
		
		//Search for the new feature - enter the newly created feature name
		FeaturesPOM.searchfornewfeature();
		FeaturesPOM.verifyfeaturetable();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 7");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step7");
		
		//Calling the object defined in PropertiesPOM
		PropertiesPOM = new PropertiesPOM(driver,logger,WaitTypes);
		
		//Clicking on Properties Link
		PropertiesPOM.clickproperties();
		
		//Clicking on Add New
		PropertiesPOM.clickAddNew();
		
		//Enter the Title for the Property
		PropertiesPOM.enterTitle("New Property Title");
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 8");
		screenShot.captureScreenShot("PropertiesPage_TC2_Step8");
		
		//Enter the Description for the Property
		PropertiesPOM.enterContent("My Propery Content and Description");
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 9");
		screenShot.captureScreenShot("PropertiesPage_TC2_Step9");
		
		//Click in the feature check box - the feature that we created in the Step 3
		FeaturesPOM.newfeaturecheckbox();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 10");
		screenShot.captureScreenShot("FeaturesPage_TC2_Step10");
		
		//Click on Publish Button
		PropertiesPOM.clickpublish();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 11");
		screenShot.captureScreenShot("PropertiesPage_TC2_Step11");
		
		//End of Test Case 2 Logger and Flushing of the Features Page Logger
		logger.log(LogStatus.INFO, "End Of Test Case 2");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
		//hovering on the properties link for the next case to pick
		FeaturesPOM.propertieshover();
	}
}
