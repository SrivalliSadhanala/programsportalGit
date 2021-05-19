package org.epam.programsportal.tests.webtests;

import org.epam.programsportal.framework.BrowserConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserTest {

    WebDriver driver;
    public BrowserTest() throws Exception {

        BrowserConfiguration browser = new BrowserConfiguration();
        driver = browser.getDriver("chrome");

    }

    @Test
    public void launchGoogle() {
        driver.get("https://www.google.com");
    }
}
