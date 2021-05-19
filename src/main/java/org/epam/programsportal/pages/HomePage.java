package org.epam.programsportal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    private By toggleButton = By.className("uui-toggle-box");
    private By masterDataManagement = By.xpath("//div[@id='mCSB_2_container']/ul/li[4]/a/span[contains(text(),'Master Data management')]");
    private By colleges = By.xpath("//div[@id='mCSB_2_container']/ul/li[4]/ul/li[4]/a");
    private By speakers = By.xpath("//div[@id='mCSB_2_container']/ul/li[4]/ul/li[3]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickToggleButton() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(toggleButton).click();
        return new HomePage(driver);
    }

    public HomePage navigateToMDM() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElement(masterDataManagement).click();
        return new HomePage(driver);

    }

    public CollegesPage navigateToColleges() {
        driver.findElement(colleges).click();
        return new CollegesPage(driver);
    }

    public void navigateToSpeakers() {
        driver.findElement(speakers).click();
    }


}
