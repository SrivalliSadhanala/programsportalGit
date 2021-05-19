package org.epam.programsportal.tests.webtests;

import org.epam.programsportal.dataproviders.DataProvidersBase;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.epam.programsportal.pages.CollegesPage;
import org.epam.programsportal.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSearch {

    static WebDriver driver = BrowserConfiguration.getDriver("chrome");

    @BeforeClass
    public void setup() {
        new SignUpPage(driver).launchSignUpPageProgramsPortal().enterCredentialsInSignUp().clickOnSubmit()
                .launchSignInPageProgramsPortal().enterCredentialsInSignIn()
                .clickToggleButton().navigateToMDM().navigateToColleges();
    }

    @Test(dataProvider = "Search Data", dataProviderClass = DataProvidersBase.class)
    public void SearchTest(String searchkey) throws InterruptedException {
        CollegesPage college = new CollegesPage(driver);
        college.clickOnSearch(searchkey);
        boolean isSearchSuccessful = validateSearch(searchkey);
        Thread.sleep(1000);
        if(isSearchSuccessful==true)
            LogUtilityFunctions.logInfoMessage("Search Successful");
        //Thread.sleep(3000);
        college.clearText();
    }

    public boolean validateSearch(String searchkey) {
        String columnValue = "";
        boolean isSearchfoundinaRow = false;
        searchkey.toLowerCase();
        for(int i=1;i<=5;i++) {
            isSearchfoundinaRow = false;
            for(int j=1;j<=6;j++) {
                columnValue = driver.findElement(By.xpath("//*[@id='CollegeTable']/tbody[1]/tr[i]/td[j]")).getText().toLowerCase();
                if(columnValue.contains(searchkey)) {
                    isSearchfoundinaRow=true;
                    j=6;
                    //break;
                }
            }
            if(isSearchfoundinaRow==false)
                return false;
        }
        return true;
    }
}
