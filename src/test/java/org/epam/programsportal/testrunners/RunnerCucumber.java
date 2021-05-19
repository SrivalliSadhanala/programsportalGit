package org.epam.programsportal.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(
//        plugin = {"html:target/cucumber-reports/report.html"},
//        glue  = {"stepdefinitions"},
//        features = {"src/test/resources/features/SignUp.feature"},
//        monochrome = true)

@CucumberOptions(
        plugin = {"html:target/cucumber-reports/report.html"},
        glue = {"org.epam.programsportal.stepdefinitions"},
        features = {"src/test/resources/features/Speakers.feature"},
        monochrome = true
)

public class RunnerCucumber extends AbstractTestNGCucumberTests {
}

//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},