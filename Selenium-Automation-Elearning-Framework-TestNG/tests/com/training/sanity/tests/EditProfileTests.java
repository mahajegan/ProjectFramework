package com.training.sanity.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.*;
import com.training.pom.AdminLoginPOM;
import com.training.sanity.tests.AdminLoginTest;
import com.training.pom.EditProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class EditProfileTests extends AdminLoginTest {
	
	private String baseUrl;
	private AdminLoginTest AdminLoginTest;
	private AdminLoginPOM AdminloginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private EditProfilePOM EditProfilePOM;
	public AdminLoginPOM AdminLoginPOM;
	

	@Test(priority=2)
	public void EditProfile() throws Exception  {
		
	//Test Case 2: Enter the Agent Title and Phone number and click on update profile
	  //Initialize the EditProfilePOM
	  EditProfilePOM = new EditProfilePOM(driver);
	  
	  //Hover on the Edit Profile
	  EditProfilePOM.Hover();
	  
	  //Click on EditProfile
	  EditProfilePOM.editmyprofile();
	  
	  //Enter Agent Title
	  EditProfilePOM.enteragenttitle("mithran");
	  
	  //verify the entered title
	  EditProfilePOM.verifyenteredtitle();
	 
	  //Enter Phone number
	  EditProfilePOM.enterphoneno("9884063632");
	  
	//verify the entered phone number
	  EditProfilePOM.verifyenteredphone();
	  
	  //Click on Update Profile
	  EditProfilePOM.clickupdateprofile();
	 
	  
	 //Test Case 3: Click on Generate Password and enter new password and click on Update profile
	  //Click on Generate Pwd
	 EditProfilePOM.clickgeneratepwd();
	 
	 //Enter the new Pwd
	 EditProfilePOM.enternewpwd("adminuser@123");
	 
	//verify the entered new pwd
	  EditProfilePOM.verifyenterednewpwd();
	 
	 //Click on Update Profile button
	 EditProfilePOM.clickupdateprofile();
	 
	 //Test Case 1: Is to Login and Logout as Admin, So hovering over Admin and click on Logout button after done with test case 2 and 3.
	 //Hovering over Howdy
	 EditProfilePOM.Hover();
	 
	 //Initialize the AdminPOM
	  AdminLoginPOM = new AdminLoginPOM(driver);
	  
	  //Click on Logout button
	  AdminLoginPOM.clicklogout(); 
	
  }
}
