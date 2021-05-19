package org.epam.programsportal.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SignInPage {
    private WebDriver driver;

    private By email = By.id("exampleInputEmail1");
    private By password = By.id("exampleInputPassword1");
    private By submit_button  = By.id("form_submit");

    //static Logger logger = (Logger) LogManager.getLogger(SignInPage.class);

    //public static final Logger logger = LogManager.getLogger();

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage launchSignInPageProgramsPortal() {
        driver.get("http://epinhydw0087/programs/#/login");
        return new SignInPage(driver);
    }

    public HomePage enterCredentialsInSignIn() {
        driver.findElement(email).sendKeys("abcdef@gmail.com");
        driver.findElement(password).sendKeys("abcdef");
        driver.findElement(submit_button).click();

        LogUtilityFunctions.logInfoMessage("SignIn successful navigated to HomePage");

        return new HomePage(driver);
    }

    public HomePage enterCredentialsInSignIn(String username, String passkey) {

        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(passkey);
        driver.findElement(submit_button).click();

        LogUtilityFunctions.logInfoMessage("SignIn successful navigated to HomePage");

        return new HomePage(driver);
    }
}
