package org.epam.programsportal.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.pages.HomePage;
import org.epam.programsportal.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigatingToSpeakers {

    WebDriver driver = BrowserConfiguration.getDriver("chrome");

    @Given("User signedin to the Programs portal and is in HomePage")
    public void SignIn() {
        new SignUpPage(driver).launchSignUpPageProgramsPortal().enterCredentialsInSignUp().clickOnSubmit()
                              .launchSignInPageProgramsPortal().enterCredentialsInSignIn();
    }
    @When("User clicks on togglebutton")
    public void clickOnToggle() {
        // Write code here that turns the phrase above into concrete actions
        new HomePage(driver).clickToggleButton();
    }
    @And("From the displayed items user clicks on MasterDataManagement")
    public void SelectMDM() {
                new HomePage(driver).navigateToMDM();
    }
    @And("when he selects Speakers from MasterDataManagement")
    public void selects_speakers() {
        new HomePage(driver).navigateToSpeakers();
    }
    @Then("User will be navigated to Speakers Page")
    public void validateSpeakersPage() {
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"SPEAKERS","User successfully navigated to Speakers Page");
    }

}
