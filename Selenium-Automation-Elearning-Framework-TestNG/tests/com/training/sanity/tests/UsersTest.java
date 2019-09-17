package com.training.sanity.tests;

import java.io.File;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.FeaturesPOM;
import com.training.pom.UsersPOM;
import com.trianing.waits.WaitTypes;

public class UsersTest extends AdminLoginTest {
	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public UsersPOM UsersPOM;
	
	
	@Test(priority=1)
	public void RETC_074() throws Throwable{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "RETC_074" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the FeaturesPage Test
		logger = extent.startTest("RETC_074");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		
		//Logging of Test Case 2 Start
		logger.log(LogStatus.INFO, "Executing Test Case 2: RETC_074- To verify Users Link using excel sheet input");
		
		//Initalizing the Users POM along with logger and WaitTypes
		UsersPOM = new UsersPOM(driver,logger,WaitTypes);
		
		//Performing hover on Users link and verify the links
		UsersPOM.usershover();
		UsersPOM.verifyusersHover();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 1 - Hovered on Users link and verified the links present");
		screenShot.captureScreenShot("UsersPage_TC2_Step1");
		
		UsersPOM.clickallusers();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 2 - Clicked on All Users link under Users");
		screenShot.captureScreenShot("UsersPage_TC2_Step2");
		
		UsersPOM.verifytable();
		logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 3 - Verify the Table data");
		screenShot.captureScreenShot("UsersPage_TC2_Step3");
		
		//End of Test Case 2 Logger and Flushing of the Features Page Logger
		logger.log(LogStatus.INFO, "End Of Test Case 2");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
	
	@Test(priority=2,dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void RETC_074_Excel(String name,String role) throws Throwable{
				//Initializing Extent Report Path and file name along with configuring the extent-config xml 
				extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "RETC_074_ExcelData" + ".html",true);
				extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
				
				//start the logging of the FeaturesPage Test
				logger = extent.startTest("RETC_074_Excel");
				
				//Initializing the screenshot
				screenShot = new ScreenShot(driver);
				
				//Logging of Test Case 2 Start
				logger.log(LogStatus.INFO, "Executing Test Case 2: RETC_074- To continue the test case using excel input");
				
				//Initalizing the Users POM along with logger and WaitTypes
				UsersPOM = new UsersPOM(driver,logger,WaitTypes);
		
				UsersPOM.searchname(name);
				logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 4 - Search for the name in users list");
				screenShot.captureScreenShot("UsersPage_TC2_Step4");
				
				UsersPOM.clickcheckbox(name);
				logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 5 - Click on the check box");
				screenShot.captureScreenShot("UsersPage_TC2_Step5");
		
				UsersPOM.rolechange(role);
				logger.log(LogStatus.INFO, "Verified Test Case 2 - Step 6 - Perform role change");
				screenShot.captureScreenShot("UsersPage_TC2_Step6");
		
				//End of Test Case 2 Logger and Flushing of the Features Page Logger
				logger.log(LogStatus.INFO, "End Of Test Case 2");
				extent.endTest(logger);
				extent.flush();
				extent.close();
	}
	
	
}
