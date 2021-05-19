package org.epam.programsportal.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.epam.programsportal.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUp {

    WebDriver driver = BrowserConfiguration.getDriver("chrome");

    SignUpPage signup = new SignUpPage(driver);

    @Given("^Programs portal URL$")
    public void openProgramsPortal() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("http://epinhydw0087/programs/#/register");
        driver.manage().window().maximize();
    }

    @When("^User enters credentials$")
    public void user_enters_credentials()  {
        // Write code here that turns the phrase above into concrete actions
        signup.enterCredentialsInSignUp();
    }

    @And("^Click on Submit button$")
    public void click_on_Submit_button()  {
        // Write code here that turns the phrase above into concrete actions
        signup.clickOnSubmit();
    }

    @Then("^User should be navigated to SignIn Page$")
    public void user_should_be_navigated_to_SignIn_Page()  {
        String signin_URL = driver.getCurrentUrl();
        Assert.assertEquals(signin_URL,"http://epinhydw0087/programs/#/register", "SIGNUP IS NOT SUCCESSFUL");
    }


}
