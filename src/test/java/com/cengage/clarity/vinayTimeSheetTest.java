package com.cengage.clarity;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class vinayTimeSheetTest {

    Browser sessionBrowser = new Browser();
    WebDriver driver = sessionBrowser.getBrowserName();
    takeScreenCapture picture = new takeScreenCapture(driver);
    loginPage login = new loginPage(driver);
//    mailProject email = new mailProject();

    @BeforeTest
    public void start() {
        picture.maximizePage();
        driver.get("http://ohcinclarityp04.corp.local/niku/app?action=security.staticLogin");
        System.out.println("*** Please make sure you are connected to Internet and Cengage VPN should be connected to run this programm from Home.");
 }  

    @Test
    public void loginToTimeSheet() throws InterruptedException {
        login.loginMethod("c-apsharma","niku2000");
    }

    @Test (dependsOnMethods = "loginToTimeSheet")
    public void openTimeSheet() {
        login.openTimeSheet();
    }

    @Test (dependsOnMethods = "openTimeSheet")
    public void takeScreenShot() {
        picture.takeScreenShot("apsharma");
    }

    @Test (dependsOnMethods = "takeScreenShot")
    public void emailData() {
        login.logout(driver);
//        email.mailScreenshots();
    }

    @AfterTest
    public void close() {
     // This class do email work for us
        driver.quit();
 }  
	
}