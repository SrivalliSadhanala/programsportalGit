package org.epam.programsportal.framework;

import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.epam.programsportal.constants.ConstantsSetup.*;
import static org.epam.programsportal.constants.ConstantsSetup.EDGEDRIVER_SYSTEM_PATH;

public class BrowserConfiguration {

    static WebDriver driver;
    public static WebDriver getDriver(String browserType)  {

        switch (browserType.toLowerCase()) {
            case "chrome": System.setProperty(CHROMEDRIVER_SYSTEM_PROPERTY, CHROMEDRIVER_SYSTEM_PATH);
                driver = new ChromeDriver();
                break;
            case "edge"  : System.setProperty(EDGEDRIVER_SYSTEM_PROPERTY,EDGEDRIVER_SYSTEM_PATH);
                driver = new EdgeDriver();
                break;
            default:       LogUtilityFunctions.logInfoMessage("No Such Browse");
        }
        return driver;
    }

}
