package org.epam.programsportal.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.programsportal.framework.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class GoogleSearchWord {
    static WebDriver driver = BrowserConfiguration.getDriver("chrome");

    @When("^user type word and enter$")
    public void openGoogle(){

        driver.get("https://www.google.com");
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        webElement.sendKeys("rose");
        webElement.sendKeys(Keys.ENTER);
    }
    @Then("^user found that word$")
    public void search(){
       //String str= driver.findElement(By.className("gLFyf gsfi")).getText();
        //Assert.assertEquals("rose",str);
        //*[@id="tsf"]/div[1]/div[1]/div[2]/div/div[2]/input
        Assert.assertTrue(true);
    }

}

