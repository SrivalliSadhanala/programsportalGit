package org.epam.programsportal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class CollegesPage {

    private WebDriver driver;

    private By add_college_button = By.xpath("//button[@class='uui-button blue']");
    private By search_button = By.xpath("//input[@type='search']");

    public CollegesPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCollegePage clickAddCollegeButton() {
        driver.findElement(add_college_button).click();
        return new AddCollegePage(driver);
    }

//    @DataProvider(name="SearchData")
//    public Object[][] DataForSearch() {
//        return new Object[][] {
//                {"JNTUK"}
//        };
//    }

    public void clickOnSearch(String searchkey) {
        driver.findElement(search_button).sendKeys(searchkey);
    }

    public void clearText() {
        driver.findElement(search_button).clear();
    }
}
