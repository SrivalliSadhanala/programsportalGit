package org.epam.programsportal.tests.webtests;

import org.epam.programsportal.dataproviders.DataProvidersBase;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.framework.listeners.TestListener;
import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.epam.programsportal.pages.SignInPage;
import org.epam.programsportal.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestSignIn {

    static WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context) throws Exception {
        driver = BrowserConfiguration.getDriver("chrome");
        context.setAttribute("driver",driver);
    }

    @Test(dataProvider = "Account Credentials", dataProviderClass = DataProvidersBase.class)
    public static void SignInValidation(String username, String passkey) throws Exception {

        SignUpPage signup = new SignUpPage(driver);
        SignInPage signin = signup.launchSignUpPageProgramsPortal().enterCredentialsInSignUp().clickOnSubmit();
        signin.launchSignInPageProgramsPortal().enterCredentialsInSignIn(username, passkey);
        //Assert.assertTrue(false);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
