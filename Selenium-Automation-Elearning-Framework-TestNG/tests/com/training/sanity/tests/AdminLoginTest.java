package com.training.sanity.tests;

import com.training.pom.AdminLoginPOM;
import com.relevantcodes.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.report.ExtentReport;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {
	
	public static WebDriver driver;
	private static String baseUrl;
	private static AdminLoginPOM AdminloginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	public static ExtentReport ExtentReport;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AdminloginPOM = new AdminLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	@Test(priority=1)
	public void AdminLogin() throws Exception {
		
		//Initialize Extent Report
		ExtentReport = new ExtentReport();
		
		//Enter User Name
		AdminloginPOM.UserName("admin");
		ExtentReport.fetchExtentReport("LoginAdminhtml","PASS","Username entered");
		
		//Enter Password
		AdminloginPOM.Password("adminuser@123");
		ExtentReport.fetchExtentReport("LoginAdminhtml","PASS","Password entered");
		
		//Click on Login button
		AdminloginPOM.LoginBtn(); 
		ExtentReport.fetchExtentReport("LoginAdminhtml","PASS","Click on Login Button");
		screenShot.captureScreenShot("Login");
		
		//Assert to verify the title
		String expectedtitle = "Dashboard ‹ Real Estate — WordPress";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle, "Dashboard ‹ Real Estate — WordPress");
		ExtentReport.fetchExtentReport("LoginAdminhtml","PASS","Title Verified");	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
}
}
