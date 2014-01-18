package com.cengage.clarity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {

    private WebDriver driver;
    String browserName = System.getProperty("browser");

    WebDriver getBrowserName() {
        if(browserName.equalsIgnoreCase("firefox"))  {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setJavascriptEnabled(true);
            driver = new ChromeDriver(caps);
        }
        return driver;
    }
}
