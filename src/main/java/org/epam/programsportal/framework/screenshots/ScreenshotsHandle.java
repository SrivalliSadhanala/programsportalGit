package org.epam.programsportal.framework.screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotsHandle {

        public static void takeScreenShot(WebDriver driver, String fileName) {
            File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file,new File("./src/test/java/org/epam/programsportal/screenshots_output/"+fileName+".jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

//./src/main/java/screenshots_output/