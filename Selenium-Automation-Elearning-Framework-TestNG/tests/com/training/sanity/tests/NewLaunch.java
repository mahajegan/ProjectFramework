package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.FeaturesPOM;
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;


public class NewLaunch {
	
	
	public static WebDriver driver;
	private static String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private static Properties properties;
	private static ScreenShot screenShot;
	public ExtentReports extent;
	public static ExtentTest logger;
	public static WaitTypes WaitTypes;
	public static NewLaunchPOM NewLaunchPOM;

	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		NewLaunchPOM = new NewLaunchPOM(driver,logger,WaitTypes); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	

	
	@Test(priority=1)
	public void RETC_073() throws InterruptedException{
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "RETC_073" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the Test
		logger = extent.startTest("RETC_073");
		
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		logger.log(LogStatus.INFO, "Executing Test Case 1: RETC_073- To verify New Launch Page");
		
		//Initializing the POM file
		NewLaunchPOM = new NewLaunchPOM(driver,logger,WaitTypes);
		
		//Click on New Launch link
		NewLaunchPOM.newlaunch();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 1 - Click on New Launch");
		screenShot.captureScreenShot("NewLaunch_TC1_Step1");
		
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
	
	@Test(priority =2 ,dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void RETC_073_fetchdatafromDB(String city, String name, String email, String subject, String message) {
		
		//Initializing Extent Report Path and file name along with configuring the extent-config xml 
		extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + "RETC_073_fetchdatafromDB" + ".html",true);
		extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		//start the logging of the Test
		logger = extent.startTest("RETC_073_fetchdatafromDB");
				
		//Initializing the screenshot
		screenShot = new ScreenShot(driver);
		//logger.log(LogStatus.INFO, "Executing Test Case 1: RETC_073_fetchdatafromDB- To Enter details in the Contact form");
				
		//Initializing the POM file
		NewLaunchPOM = new NewLaunchPOM(driver,logger,WaitTypes);
		
		//Enter details to find your home
		NewLaunchPOM.findyourhome(city);
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 2 - Enter details in Find Your Home");
		screenShot.captureScreenShot("NewLaunch_TC1_Step2");
		
		//Click on Drop us a Line
		NewLaunchPOM.dropusalineclick();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 3 - Click on Drop Us a Line");
		screenShot.captureScreenShot("NewLaunch_TC1_Step3");
		
		//Fill in the Contact name in Contact Form
		NewLaunchPOM.contactformname(name);
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 4 - Enter name in Contact form" +name);
		screenShot.captureScreenShot("NewLaunch_TC1_Step4");
		
		//Fill in the Email Address in Contact form
		NewLaunchPOM.contactformemail(email);
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 5 - Enter email in Contact form" +email);
		screenShot.captureScreenShot("NewLaunch_TC1_Step5");
		
		//Fill in the Subject in Contact form
		NewLaunchPOM.contactformsubject(subject);
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 6 - Enter subject in Contact form" +subject);
		screenShot.captureScreenShot("NewLaunch_TC1_Step6");
		
		//Fill in the Message in Contact form
		NewLaunchPOM.contactformmessage(message);
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 7 - Enter message in Contact form" +message);
		screenShot.captureScreenShot("NewLaunch_TC1_Step7");
		
		//Click on the submit button in Contact form
		NewLaunchPOM.contactformclick();
		logger.log(LogStatus.INFO, "Verified Test Case 1 - Step 8 - Click the submit button");
		screenShot.captureScreenShot("NewLaunch_TC1_Step8");
		
		
		logger.log(LogStatus.INFO, "End Of Test Case 1");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
}
}
