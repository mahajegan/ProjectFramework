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


public class RegionsPageTest extends AdminLoginTest {

	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public PropertiesPOM PropertiesPOM;
	public FeaturesPOM FeaturesPOM;
	public RegionsPOM RegionsPOM;
	
	
	@Test(priority=2)
	public void RETC_045() throws InterruptedException{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "regionstest" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the RegionsPage Test
		logger = extent.startTest("RegionsPageTest");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		
		//Logging of Test Case 3 Start
		logger.log(LogStatus.INFO, "Executing Test Case 3 - To verify whether admin is able to create property details based on the Region");
		
		//Initializing PropertiesPOM, RegionsPOM and FeaturesPOM as we will use it here
		PropertiesPOM = new PropertiesPOM(driver,logger,WaitTypes);
		RegionsPOM = new RegionsPOM(driver,logger,WaitTypes);
		FeaturesPOM = new FeaturesPOM(driver,logger,WaitTypes);
		
		//Hover over the Properties link and verify the links present in it
		FeaturesPOM.verifyPropertiesHover();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 1");
		screenShot.captureScreenShot("RegionsPage_TC3_Step1");
		
		//Click on the Regions link
		RegionsPOM.clickRegions();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 2");
		screenShot.captureScreenShot("RegionsPage_TC3_Step2");
		
		//Verify the headline for the parent region
		RegionsPOM.verifyparentregion();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 3");
		screenShot.captureScreenShot("RegionsPage_TC3_Step2");
		
		//Enter the name for the new region
		FeaturesPOM.addtagname("REGIONSTAGNAME");
		
		//Verify the new region name that we entered
		RegionsPOM.verifytagname();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 3");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step3");
		
		//Add the slug name and verify it
		FeaturesPOM.addslug("SLUGNAME");
		RegionsPOM.verifyslug();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 4");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step4");
		
		//Select the parent region drop down
		RegionsPOM.parentregiondropdown();
		
		//Verify the parent region in the drop down
		RegionsPOM.verifyparentregion();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 5");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step5");
		
		//Select a parent region
		RegionsPOM.selectparentregion();		
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 6");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step6");
		
		//Add a description for the new region
		FeaturesPOM.adddescription("DESCRIPTION CONTENT BY MAHA");
		RegionsPOM.verifytagdescription();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 7");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step7");
		
		//click on add new region button
		RegionsPOM.clickaddRegionbutton();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 8");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step8");
		
		//Search for a region that we just created in the Step 3
		RegionsPOM.searchfornewregion();
		
		//Verify whether the new region that we added is available in the Regions table
		RegionsPOM.verifyregionstable();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 9");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step9");
		
		//Click on Properties Link 
		PropertiesPOM.clickproperties();
		
		//Click on Add New 
		PropertiesPOM.clickAddNew();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 10");
		screenShot.captureScreenShot("PropertiesPage_TC3_Step10");
		
		//Enter a Property Title
		PropertiesPOM.enterTitle("New Property Title");
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 11");
		screenShot.captureScreenShot("PropertiesPage_TC3_Step11");
		
		//Enter Description for the property
		PropertiesPOM.enterContent("My Propery Content and Description");
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 12");
		screenShot.captureScreenShot("PropertiesPage_TC3_Step12");
		
		//Click on the region check box that we created above
		RegionsPOM.newregioncheckbox();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 13");
		screenShot.captureScreenShot("FeaturesPage_TC3_Step13");
		
		//Click on Publish button
		PropertiesPOM.clickpublish();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 14");
		screenShot.captureScreenShot("PropertiesPage_TC3_Step14");
		
		//End of Test Case 3 Logger and Flushing of the Regions Page Logger
		logger.log(LogStatus.INFO, "End Of Test Case 3");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
