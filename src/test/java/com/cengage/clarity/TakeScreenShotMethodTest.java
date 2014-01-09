package com.cengage.clarity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class TakeScreenShotMethodTest {
	// This method take screens of page when called
	void takeScreenShot(String user){
	    try{
	        //Thread.sleep(10000)
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        String path = "/Selenium/Output/screenshot_" + user + ".jpg";
	        ImageIO.write(image, "jpg", new File(path));
	        System.out.println("Screenshot taken..."+user);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	// This method maximize the page size as default selenium window size is not appropriate for screen-shots
	  void maximizePage(WebDriver d){
		    final JavascriptExecutor js = (JavascriptExecutor) d; 
	        js.executeScript("window.open('','testwindow','width=400,height=200')"); 
	        d.close(); 
	        d.switchTo().window("testwindow"); 
	        js.executeScript("window.moveTo(0,0);"); 
	        js.executeScript("window.resizeTo(window.screen.availWidth,window.screen.availHeight);"); 
	    }
}