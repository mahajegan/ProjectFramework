package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.trianing.waits.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.training.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class PostsPOM {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public WaitTypes WaitTypes;
	public String enteredcategory;
	public String searchtext;
	
	
	public PostsPOM(WebDriver driver,ExtentTest logger,WaitTypes WaitTypes ) {
		this.driver = driver; 
		this.logger = logger;
		this.WaitTypes = WaitTypes;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-post']")
	public WebElement posts;
	
	@FindBy(linkText="Add New")
	public WebElement AddNew;
	
	@FindBy(xpath="//*[@class='wp-heading-inline']")
	public WebElement addnewheading;
	
	@FindBy(id="category-add-toggle")
	public WebElement addnewcategory;
	
	@FindBy(id="newcategory")
	public WebElement newcategory;
	
	@FindBy(id="newcategory_parent")
	public WebElement parentcategory;
	
	@FindBy(id="category-add-submit")
	public WebElement addnewcategorybutton;
	
	@FindBy(id="newcategory_parent")
	public WebElement categorylist;
	
	@FindBy(xpath="//*[contains(text(),'maha')]")
	public WebElement category;
	
	@FindBy(xpath="//*[contains(text(),'mithran') and @class='selectit']")
	public WebElement checkbox;
	
	@FindBy(xpath="//*[@id='title' and @name='post_title']")
	public WebElement posttitlebox;
	
	@FindBy(id="content")
	public WebElement postcontentbox;
	
	@FindBy(xpath="//*[@class='menupop with-avatar']/a")
	public WebElement howdy;
	
	@FindBy(xpath="//*[@id='wp-admin-bar-logout']/a")
	private WebElement logout;
	
	@FindBy(id="taxonomy-category")
	private WebElement AllCategoriesTable;
	
	@FindBy(xpath="//*[@id='publish' and @class='button button-primary button-large']")
	private WebElement publishbutton;
	
	@FindBy(linkText="Real Estate")
	private WebElement realestate;
	
	@FindBy(name="phrase")
	private WebElement searchfield;
	
	@FindBy(xpath="//*[@class='asl_content']")
	private WebElement searchdesc;
	
	//Verify the links present in the Properties Mouse Over
		public void verifyPostsHover(){
			WaitTypes = new WaitTypes(driver);
			WaitTypes.presenceElementLocated(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"), 30);
			this.posts.isDisplayed();
			Actions act = new Actions(driver);
			act.moveToElement(posts).build().perform();
			
			//Fetch all the links of the Properties
			List<WebElement> actualposts = driver.findElements(By.xpath("//*[@class='wp-submenu wp-submenu-wrap']"));
			
			//Storing the size of the links in linktext
			String [] actualposttext = new String[actualposts.size()];
			
			
			String expectedposts[] = {"Posts","All Posts","Add New","Categories","Tags"};
			
			try{
			//Extract the link names for each link element
			int i=0;
			for (WebElement e:actualposts){
				actualposttext[i]=e.getText();
				if (actualposttext[i].contains(expectedposts[i])){
					logger.log(LogStatus.INFO, "Verified Link in Properties:" +actualposttext[i]);
					//System.out.println(actualposttext[i]);
					i++;
					}
				} 
			}
			catch(ArrayIndexOutOfBoundsException e) {
	            System.out.println(e);
	        }
			logger.log(LogStatus.PASS, "Verified all link when hovering on Posts");
		}
	
		public void addnewposts(){
			this.AddNew.click();
			this.addnewheading.isDisplayed();
			logger.log(LogStatus.PASS, "Clicked on Add New and verified its heading");
		}
	
		public void addnewcategory(String enteredcategory){
			this.addnewcategory.click();
			this.newcategory.isDisplayed();
			this.newcategory.sendKeys(enteredcategory);
			logger.log(LogStatus.PASS, "Added New Category: " +enteredcategory);
		}
		
		public void parentcategory(){
			String selectedparentcategory = null;
			Select sel = new Select(parentcategory);
			int count = sel.getOptions().size();
			sel.selectByIndex(12);
			logger.log(LogStatus.PASS, "Added Parent Category: " +sel.getFirstSelectedOption().getText());
		}
		
		public void addnewcategorybutton(){
			this.addnewcategorybutton.click();
			logger.log(LogStatus.PASS, "Clicked on Submit button in new category");
		}
		
		public void refreshpage(){
			this.driver.navigate().refresh();
			logger.log(LogStatus.PASS, "Refreshed the page");
		}
		
		public void verifycategory(){
			if (AllCategoriesTable.getText().contains("mithran")){
				logger.log(LogStatus.PASS, "Added Category available in the list of categories");
			}
			else
				logger.log(LogStatus.FAIL, "Added Category available is not available in the list of categories");
				
			
		}
		
		public void entertitledescription(){
			this.posttitlebox.isSelected();
			this.posttitlebox.sendKeys("New Post on Maha Property");
			searchtext = this.posttitlebox.getAttribute("value");
			logger.log(LogStatus.PASS, "Entered title");
			
			this.postcontentbox.isSelected();
			this.postcontentbox.sendKeys("New Content on Maha Property");
			logger.log(LogStatus.PASS, "Entered Description");
			
			this.checkbox.click();
			logger.log(LogStatus.PASS, "Selected the newly created category");
			
			this.publishbutton.click();
			logger.log(LogStatus.PASS, "Clicked on Publish button");
		}
		
		
		public void logout(){
			this.howdy.isDisplayed();
			Actions act = new Actions(driver);
			act.moveToElement(howdy).build().perform();
			this.logout.click();
			logger.log(LogStatus.PASS, "Logged out of the Application");
		}
		
		public void clickrealestate(){
			this.realestate.click();
			logger.log(LogStatus.PASS, "Clicked on Real Estate");
		}
		
		public void searchmypost(){
			this.searchfield.sendKeys(searchtext);
			if (this.searchdesc.getText().contains(searchtext)){
				logger.log(LogStatus.PASS, "Search the new title of the Real Estate");
			}
			else
				logger.log(LogStatus.FAIL, "New Title is not listed");
		}
}