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


public class PostsTest extends AdminLoginTest {

	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public PostsPOM PostsPOM;
	
	
	@Test(priority=2)
	public void RETC_075() throws InterruptedException{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "RETC_075" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the RegionsPage Test
		logger = extent.startTest("RETC_075");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		
		//Logging of Test Case 3 Start
		logger.log(LogStatus.INFO, "Executing Test Case 3 - To verify whether admin is able to category while adding new post");
		
		//Initializing PropertiesPOM, RegionsPOM and FeaturesPOM as we will use it here
		PostsPOM = new PostsPOM(driver,logger,WaitTypes);
		
		//Hovering over Posts Link
		PostsPOM.verifyPostsHover();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 1 - Hover over Posts link is verfied");
		screenShot.captureScreenShot("PostsPage_TC3_Step1");
		
		//Click on Add New
		PostsPOM.addnewposts();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 2 - Clicked on Add New Posts");
		screenShot.captureScreenShot("PostsPage_TC3_Step2");
		
		PostsPOM.addnewcategory("mithran");
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 3 - Added a new category");
		screenShot.captureScreenShot("PostsPage_TC3_Step3");
		
		PostsPOM.parentcategory();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 4 - Selected parent category");
		screenShot.captureScreenShot("PostsPage_TC3_Step4");
		
		PostsPOM.addnewcategorybutton();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 5 - Clicked on add new category button");
		screenShot.captureScreenShot("PostsPage_TC3_Step5");
		
		PostsPOM.refreshpage();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 6 - Refreshed the page");
		screenShot.captureScreenShot("PostsPage_TC3_Step6");
		
		PostsPOM.verifycategory();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 7 - Verified the newly added category");
		screenShot.captureScreenShot("PostsPage_TC3_Step7");
		
		PostsPOM.entertitledescription();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 8 - Select the added category along with title and description");
		screenShot.captureScreenShot("PostsPage_TC3_Step8");
		
		PostsPOM.logout();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 9 - Logged out from the application");
		screenShot.captureScreenShot("PostsPage_TC3_Step9");
		
		PostsPOM.clickrealestate();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 10 - Clicked on Real Estate");
		screenShot.captureScreenShot("PostsPage_TC3_Step10");
		
		PostsPOM.searchmypost();
		logger.log(LogStatus.INFO, "Verified Test Case 3 - Step 11 - Search my post");
		screenShot.captureScreenShot("PostsPage_TC3_Step11");
		
		
		//End of Test Case 3 Logger and Flushing of the Regions Page Logger
		logger.log(LogStatus.INFO, "End Of Test Case 3");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
