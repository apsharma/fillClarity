package com.cengage.clarity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Driver {

    public WebDriver driver;
    private int AJAX_WAIT=10;

    public static loginPage login;
    public static mailProject mail;
    public static takeScreenCapture screenShot;

    public Driver(WebDriver driver) {
        this.driver=driver;
        ElementLocatorFactory finder =  new AjaxElementLocatorFactory(driver, AJAX_WAIT);
        PageFactory.initElements(finder, this);
    }

    public static void initPageObjects (WebDriver driver) {
       login = new loginPage(driver);
       mail = new mailProject();
       screenShot = new takeScreenCapture();
    }


}
