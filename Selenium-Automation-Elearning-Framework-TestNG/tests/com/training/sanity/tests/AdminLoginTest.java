package com.training.sanity.tests;

import com.training.pom.*;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {
	
	public static WebDriver driver;
	private static String baseUrl;
	private static AdminLoginPOM AdminloginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	public FeaturesPOM FeaturesPOM;

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
	
	@Test(priority=1, alwaysRun=true)
	public void AdminLogin() throws Exception {
		
		//Enter User Name
		AdminloginPOM.UserName("admin");
		
		//Enter Password
		AdminloginPOM.Password("adminuser@123");
		
		//Click on Login button
		AdminloginPOM.LoginBtn(); 
		screenShot.captureScreenShot("LoginPage");
		
		//Assert to verify the title
		String expectedtitle = "Dashboard ‹ Real Estate — WordPress";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle, "Dashboard ‹ Real Estate — WordPress");
	}
	
	//Setting up the medium Level test case RETC_043 to start after login test case
	@Test(dependsOnMethods="AdminLogin", priority=2)
	public void PropertiesTest() throws InterruptedException{
		AddPropertiesTest AddPropertiesTest = new AddPropertiesTest();
		AddPropertiesTest.RETC_043();
	}
	
	//Setting up the medium Level test case RETC_044 to start after login test case
	@Test(dependsOnMethods="AdminLogin",priority=3)
	public void FeaturesTest() throws InterruptedException{
		FeaturesPageTest FeaturesPageTest = new FeaturesPageTest();
		FeaturesPageTest.RETC_044();
	}
	
	//Setting up the medium Level test case RETC_045 to start after login test case
	@Test(dependsOnMethods="AdminLogin",priority=4)
	public void RegionsTest() throws InterruptedException{
		RegionsPageTest RegionsPageTest = new RegionsPageTest();
		RegionsPageTest.RETC_045();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
}
}
