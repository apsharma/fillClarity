package com.cengage.clarity;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;  


public class CengageClarityTimesheetTest {

WebDriver driver; 

@BeforeTest  
 public void start(){  
  driver = new FirefoxDriver();  
 }  
	    
 @Test 
  public void CengagClarityTimesheet() {

	// Maximize screen
	TakeScreenShotMethod picture = new TakeScreenShotMethod();
	                            // Below method call takes one parameter to maximize screen-size
	picture.maximizePage(driver); 
	 
	// Initializing Clarity site
	driver.get("http://ohcinclarityp04.corp.local/niku/app?action=security.staticLogin");
	System.out.println("*** Please make sure you are connected to Internet and Cengage VPN should be connected to run this programm from Home.");
	
	// Login User-name & Password???  --- #1 Pending as login details should come from other data file. 
	
	ClarityLoginMethod login = new ClarityLoginMethod(); // This class object work on Clarity, take screen-shots
	
	                                      // Below method takes 3 parameters (user, password and driver)
	login.loginMethod("c-vthakur","password",driver);
	login.loginMethod("c-nsharma","password",driver);
	login.loginMethod("vrana","password",driver);
	login.loginMethod("vjain","password",driver);
	login.loginMethod("c-ymotwani","password",driver);
	
	// Send Email ??? --- #2 Pending as screen-shot path is hard  coded right now
	MailProjectClass email = new MailProjectClass(); // This class do email work for us
	email.mailScreenshots();
 }

 @AfterTest  
 public void close(){  
  driver.quit();   
 }  
	
}