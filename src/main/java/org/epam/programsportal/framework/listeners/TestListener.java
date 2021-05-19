package org.epam.programsportal.framework.listeners;

import org.epam.programsportal.framework.loggers.LogUtilityFunctions;
import org.epam.programsportal.framework.screenshots.ScreenshotsHandle;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {

    @Override
    public void onTestStart(ITestResult result) {
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtilityFunctions.logInfoMessage(result.getName());
        ScreenshotsHandle.takeScreenShot((WebDriver)result.getTestContext().getAttribute("driver"), result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        LogUtilityFunctions.logInfoMessage(result.getName());
        ScreenshotsHandle.takeScreenShot((WebDriver)result.getTestContext().getAttribute("driver"), result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtilityFunctions.logInfoMessage(result.getName());
    }
}


