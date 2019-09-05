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


public class AddPropertiesTest extends AdminLoginTest {
	
	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;
	public PropertiesPOM PropertiesPOM;
	public String propertiestest;
	public WaitTypes WaitTypes;
	
	@Test(priority=2)
	public void RETC_043() throws InterruptedException{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "propertiestest" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the AddPropertiesTest
		logger = extent.startTest("AddPropertiesTest");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		
		//Initalizing the Properties POM
		PropertiesPOM = new PropertiesPOM(driver, logger,WaitTypes);
		
		//Logging of Test Case 1 Start
		logger.log(LogStatus.INFO, "Executing Test Case 1 - To verify whether admin is able to view added property details in Home screen");
		
		//Click the Properties Click
		PropertiesPOM.clickproperties();
		
		//Verify the Properties Title after clicking on Properties Link
		PropertiesPOM.verifypropertiestitle();
		
		//Logger and Screen Shot for Clicking on the Properties Link and Verifying the Title
		logger.log(LogStatus.INFO, "Proceeded into Properties Page");
		screenShot.captureScreenShot("PropertiesPage_TC1_PropertiesHomePage");
		
		//Verify the links of the Properties along with logger and screenshot
		PropertiesPOM.verifylinks();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 1");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step1");
		
		//Click on Add New Link
		PropertiesPOM.clickAddNew();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 2");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step2");
		
		//Enter a Title for the New Property
		PropertiesPOM.enterTitle("New Property Title");
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 3");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step3");
		
		//Enter the Description for the New Property
		PropertiesPOM.enterContent("My Propery Content and Description");
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 4");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step4");
		
		//Click on Publish Button for the New Property
		PropertiesPOM.clickpublish();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 5");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step5");
		
		//Once successfully published, verify the ViewPost link
		PropertiesPOM.clickViewPost();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 6");
		screenShot.captureScreenShot("PropertiesPage_TC1_Step6");
		
		//End of Test Case 1 Logger and Flushing of the PropertiesTest Logger
		logger.log(LogStatus.INFO, "End Of Test Case 1");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
		//Going back to the home page for the next case to continue
		PropertiesPOM.back();
		
	}
	
}
