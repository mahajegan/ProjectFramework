package com.training.report;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.*;
import com.trianing.*;

public class ExtentReport {
	
	private WebDriver driver;

	public void GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public void fetchExtentReport(String htmlreportfilename, String status, String message){
	
		
	ExtentReports extent;
	ExtentTest logger;
	extent = new ExtentReports (System.getProperty("user.dir") + "/test-output/" + htmlreportfilename + ".html",true);
	extent.loadConfig(new File (System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
	logger = extent.startTest("ExtentReport");
	if(status.equals("PASS")){
		logger.log(LogStatus.PASS, message);
	} else if(status.equals("FAIL")){
		logger.log(LogStatus.FAIL, message);
	}
	extent.endTest(logger);
	extent.flush();
	extent.close();
	}	
}