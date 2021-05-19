package org.epam.programsportal.pages;

import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private WebDriver driver;

    private By email = By.id("exampleInputEmail1");
    private By password = By.id("exampleInputPassword1");
    private By submit_button  = By.id("form_submit");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage launchSignUpPageProgramsPortal() {
        driver.get("http://epinhydw0087/programs/#/register");
        driver.manage().window().maximize();
        return new SignUpPage(driver);
    }

    public SignUpPage enterCredentialsInSignUp() {
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);

        LogUtilityFunctions.logInfoMessage("SignUp with default parameters");

        driver.findElement(email).sendKeys("abcdef@gmail.com");
        driver.findElement(password).sendKeys("abcdef");
        return new SignUpPage(driver);
    }

    public SignInPage clickOnSubmit() {
        driver.findElement(submit_button).click();
        LogUtilityFunctions.logInfoMessage("SignUp Successful, will be navigated to SignIn Page");
        return  new SignInPage(driver);
    }

    public SignUpPage enterCredentialsInSignUp(String username, String passkey) {
        LogUtilityFunctions.logInfoMessage("Sending the data from Excel through DataProvider");
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(passkey);
        return new SignUpPage(driver);
    }
}
