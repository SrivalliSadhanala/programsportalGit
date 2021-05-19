package org.epam.programsportal.tests.webtests;

import org.epam.programsportal.dataproviders.DataProvidersBase;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.pages.*;
import org.epam.programsportal.tests.jdbc.TestCollegeInserted;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestAddCollege {

    WebDriver driver;
    @BeforeClass
    public  void setup() {
        BrowserConfiguration browser = new BrowserConfiguration();
        driver = browser.getDriver("chrome");
        new SignUpPage(driver).launchSignUpPageProgramsPortal().enterCredentialsInSignUp().clickOnSubmit()
                              .launchSignInPageProgramsPortal().enterCredentialsInSignIn()
                              .clickToggleButton().navigateToMDM().navigateToColleges();

    }

    @Test(dataProvider = "College Data", dataProviderClass = DataProvidersBase.class)
    public void AddCollegeTest(String clgname,String groupname,String clgcity, String ptoname, String ptomail, String ptonumber) throws SQLException, IOException {
        new CollegesPage(driver).clickAddCollegeButton();
        AddCollegePage addCollege = new AddCollegePage(driver);
        addCollege.addingDataInAddCollege(clgname,groupname,clgcity,ptoname,ptomail,ptonumber);
        addCollege.clickOnSave();
        Assert.assertTrue(TestCollegeInserted.TestIfCollegeInserted());
    }

//    @AfterClass
//    public void tearDown() {
//        driver.close();
//    }

}
