package com.cengage.clarity;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class vinayTimeSheetTest {

    WebDriver driver;
    takeScreenCapture picture = new takeScreenCapture();
    loginPage login = new loginPage(driver);
    mailProject email = new mailProject();

    @BeforeTest
    public void start() {
        driver = new FirefoxDriver();
        picture.maximizePage(driver);
        driver.get("http://ohcinclarityp04.corp.local/niku/app?action=security.staticLogin");
        System.out.println("*** Please make sure you are connected to Internet and Cengage VPN should be connected to run this programm from Home.");
 }  

    @Test
    public void loginToTimeSheet() {
        login.loginMethod("c-vthakur","password");
    }

    @Test
    public void openTimeSheet() {
        login.openTimeSheet();
    }

    @Test
    public void takeScreenShot() {
        email.mailScreenshots();
    }


    @AfterTest
    public void close() {
     // This class do email work for us
        login.logout(driver);
        driver.quit();
 }  
	
}