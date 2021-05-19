package org.epam.programsportal.tests.webtests;

import org.epam.programsportal.dataproviders.DataProvidersBase;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.framework.listeners.TestListener;
import org.epam.programsportal.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class TestSignUp {

    static WebDriver driver;

    @BeforeClass
    public void setup(ITestContext context) throws Exception {
        driver = BrowserConfiguration.getDriver("chrome");
        context.setAttribute("driver",driver);
    }

    @Test(dataProvider = "Account Credentials", dataProviderClass = DataProvidersBase.class)
    public void TestSignUpPage(String user, String passkey) {
        SignUpPage signup = new SignUpPage(driver);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        signup.launchSignUpPageProgramsPortal().enterCredentialsInSignUp(user,passkey).clickOnSubmit();
        //Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"SIGN IN", "SIGNUP IS NOT SUCCESSFUL");
        //Assert.assertEquals(driver.getCurrentUrl(),"http://epinhydw0087/programs/#/login","SIGNUP IS NOT SUCCESSFUL");
    }

}
