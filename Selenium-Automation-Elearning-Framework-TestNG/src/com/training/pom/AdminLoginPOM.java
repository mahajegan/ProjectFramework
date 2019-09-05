package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.training.*;

public class AdminLoginPOM {
	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	//username locator
	@FindBy(id="user_login")
	private WebElement userName; 
	
	//password locator
	@FindBy(id="user_pass")
	private WebElement password;
	
	//login button locator
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	//logout locator
	@FindBy(xpath="//*[@id='wp-admin-bar-logout']/a")
	private WebElement logout;
	
	//method to enter user name
	public void UserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		}
	
	//method to enter password
	public void Password(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		
	}
	
	//click on login button
	public void LoginBtn() {
		this.loginBtn.click(); 
}
	//click on logout button
	public void clicklogout(){
		this.logout.click();
	}
	
	
}
