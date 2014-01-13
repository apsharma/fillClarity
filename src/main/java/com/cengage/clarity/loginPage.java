package com.cengage.clarity;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class loginPage extends Driver {

    @FindBy(name = "userName")
    private WebElement username;

    @FindBy(name = "passWord")
    private WebElement password;

    @FindBy(xpath="//*[@id='BtnLgoutimg']")
    private WebElement logout_btn;

    @FindBy(className = "formButtonLogin")
    private WebElement form;

    @FindBy(id="timeadmin.timesheetBrowserReturn")
    private WebElement timesheets_link;

    @FindBy(xpath = "//*[@class='toolbarLink']")
    private WebElement expandFilter_link;

    @FindBy(xpath = "//*[@id='portlet-timeadmin.timesheetBrowser']/table[2]/tbody/tr/td/table/tbody/tr[2]/td/form/table[4]/tbody/tr/td[1]/button[2]")
    private WebElement showAll_link;

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public void loginMethod(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
    }

    public void logout(WebDriver driver) {
        logout_btn.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);     // Wait for 1 sec
    }

    public void openTimeSheet() {
        form.click();
        timesheets_link.click();      // Click "Timesheets" link
        expandFilter_link.click();    // Click over "Expand Filter" link
        showAll_link.click();      // Click on "Show All" button
    }
}