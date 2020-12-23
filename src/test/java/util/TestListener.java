package util;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener extends RunListener {

    public void testRunStarted(Description description) throws java.lang.Exception
    {
        System.out.println("Number of tests to execute : " + description.testCount());
    }

    public void testRunFinished(Result result) throws java.lang.Exception
    {
        System.out.println("Number of tests executed : " + result.getRunCount());
    }

    public void testStarted(Description description) throws java.lang.Exception
    {
        System.out.println("Starting execution of test case : "+ description.getMethodName());
    }

    public void testFinished(Description description) throws java.lang.Exception
    {
        System.out.println("Finished execution of test case : "+ description.getMethodName());
    }

    public void testFailure(Failure failure) throws java.lang.Exception
    {
        System.out.println("Execution of test case failed : "+ failure.getMessage());
    }

    public void testIgnored(Description description) throws java.lang.Exception
    {
        System.out.println("Execution of test case ignored : "+ description.getMethodName());
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}