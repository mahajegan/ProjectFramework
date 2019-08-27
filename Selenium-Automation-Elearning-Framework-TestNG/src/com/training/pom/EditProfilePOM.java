package com.training.pom;

import com.training.sanity.tests.*;
import com.training.pom.*;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.training.generics.*;

public class EditProfilePOM {
	
	public WebDriver driver;
	
	public EditProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Xpath of the Admin Howdy
	@FindBy(xpath="//*[contains (text(),'Howdy')]")
	public WebElement user; 
	
	//Xpath of the Edit Profile Link after hovering over Howdy
	@FindBy(xpath="//*[@id='wp-admin-bar-edit-profile']/a")
	public WebElement editmyprofile;
	
	//Locator of the Agent Title Text Box
	@FindBy(id="agent-title")
	private WebElement title;
	
	//Locator of Phone number Text Box
	@FindBy(id="billing_phone")
	private WebElement phone;
	
	//Locator of the Update Profile button
	@FindBy(xpath="//*[@class='button button-primary' and @id='submit']")
	private WebElement updateprofile;
	
	//Xpath of the GeneratePwd Button
	@FindBy(xpath="//*[@class='button wp-generate-pw hide-if-no-js']")
	private WebElement generatepwd;
	
	//Locator of the new password text box
	@FindBy(id="pass1-text")
	private WebElement newpwd;
	
	//Method to Hover over Howdy
	public void Hover() throws InterruptedException {
		Actions Act = new Actions(driver);
		Act.moveToElement(user).build().perform();
	}
	
	//Method to click on Edit Profile Link
	public void editmyprofile(){
		this.editmyprofile.click();
	}

	//Method to clear and enter the Agent Title
	public void enteragenttitle(String title){
		this.title.clear(); 
		this.title.sendKeys(title);
	}
	
	//Method to verify the entered title
	public void verifyenteredtitle(){
	String enteredtitle =	this.title.getAttribute("value");
	System.out.println("Entered Title: " +enteredtitle);
	Assert.assertEquals(enteredtitle, "mithran");
	}
	
	//Method to enter phone number
	public void enterphoneno(String number){
		this.phone.clear();
		this.phone.sendKeys(number);
	}
	
	//Method to verify the entered phone number
		public void verifyenteredphone(){
		String enteredphone =	this.phone.getAttribute("value");
		System.out.println("Entered Phone: " +enteredphone);
		Assert.assertEquals(enteredphone, "9884063632");
		}
		
	//Method to click generate pwd
	public void clickgeneratepwd() throws InterruptedException{
		Thread.sleep(3000);
		this.generatepwd.click();
	}
	
	//Method to enter new pwd
	public void enternewpwd(String newpwd){
		this.newpwd.clear();
		this.newpwd.sendKeys(newpwd);
	}
	
	//Method to verify the entered new pwd
			public void verifyenterednewpwd(){
			String enteredpwd =	this.newpwd.getAttribute("value");
			System.out.println("Entered New Password: " +enteredpwd);
			Assert.assertEquals(enteredpwd, "adminuser@123");
			}
	
	
	//Method to click updateprofile button
	public void clickupdateprofile(){
		this.updateprofile.click();
	}
}
