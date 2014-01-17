package com.cengage.clarity;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class vinayTimeSheetTest {

    WebDriver driver = new FirefoxDriver();
    takeScreenCapture picture = new takeScreenCapture();
    loginPage login = new loginPage(driver);
    mailProject email = new mailProject();

    @BeforeTest
    public void start() {
        picture.maximizePage(driver);
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
        email.mailScreenshots();
    }

    @AfterTest
    public void close() {
     // This class do email work for us
        login.logout(driver);
        driver.quit();
 }  
	
}