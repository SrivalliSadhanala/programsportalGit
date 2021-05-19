package org.epam.programsportal.pages;

import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCollegePage {

    private WebDriver driver;

    private By college_name = By.xpath("//input[@type='text' and @name='collegeName']");
    private By group = By.xpath("//input[@type='text' and @name='collegeGroup']");
    private By college_city = By.xpath("//input[@type='text' and @name='collegeCity']");
    private By pto_name = By.xpath("//input[@type='text' and @name='collegePtoName']");
    private By pto_email = By.xpath("//input[@type='text' and @name='collegePtoEmail']");
    private By pto_phone = By.xpath("//input[@name='collegeDesc']");
    private By save = By.xpath("//div[@class='modal-footer']/button[2]");
    private By cancel = By.xpath("//button[@class='uui-button transparent']");

    public AddCollegePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCollegePage addingDataInAddCollege() {
        driver.findElement(college_name).sendKeys("Vishnu Institute of Technology");
        driver.findElement(group).sendKeys("CSE");
        driver.findElement(college_city).sendKeys("Bhimavaram");
        driver.findElement(pto_name).sendKeys("Narasimharao");
        driver.findElement(pto_email).sendKeys("narasimha_k@gmail.com");
        driver.findElement(pto_phone).sendKeys("9876543210");
        return new AddCollegePage(driver);
    }

    public void clickOnSave() {
        WebElement save_button = driver.findElement(save);
        if(save_button.isEnabled()) {
            //save_button.click();
            LogUtilityFunctions.logInfoMessage("Data can be added");
            clickOnCancel();
        }
        else
            System.out.println("Invalid Data");
    }

    public void clickOnCancel() {
        driver.findElement(cancel).click();
    }

    public void addingDataInAddCollege(String clgname, String groupname, String clgcity, String ptoname, String ptomail, String number) {
        driver.findElement(college_name).sendKeys(clgname);
        driver.findElement(group).sendKeys(groupname);
        driver.findElement(college_city).sendKeys(clgcity);
        driver.findElement(pto_name).sendKeys(ptoname);
        driver.findElement(pto_email).sendKeys(ptomail);
        driver.findElement(pto_phone).sendKeys(number);
    }
}
