package com.cengage.clarity;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class ClarityLoginMethodTest {
	
	TakeScreenShotMethod picture = new TakeScreenShotMethod();
	
	public void loginMethod(String user, String pass, WebDriver driver){
		// Login to Clarity
		WebElement username = driver.findElement(ByName.name("userName"));
		username.sendKeys(user);		 
		WebElement password = driver.findElement(ByName.name("passWord"));
		password.sendKeys(pass);
		driver.findElement(By.className("formButtonLogin")).click();
		
		// Click "Timesheets" link
		driver.findElement(By.id("timeadmin.timesheetBrowserReturn")).click();
		
		// Click over "Expand Filter" link
		driver.findElement(By.xpath("//*[@class='toolbarLink']")).click();
		
		// Click on "Show All" button
		driver.findElement(By.xpath("//*[@id='portlet-timeadmin.timesheetBrowser']/table[2]/tbody/tr/td/table/tbody/tr[2]/td/form/table[4]/tbody/tr/td[1]/button[2]")).click();
		
		//Take Screen-shot 
		picture.takeScreenShot(user);
		
		// Logout Application	
		driver.findElement(By.xpath("//*[@id='BtnLgoutimg']")).click();
		
		// Wait for 1 sec -- as after click in logout it takes a while to come up login screen again and to process with next user
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}

}
