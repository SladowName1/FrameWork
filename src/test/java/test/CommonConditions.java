package test;

import driver.DriverSingleton;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class CommonConditions {
    protected WebDriver driver;

    @Before
    public void setUp(){driver= DriverSingleton.getDriver();}

    @After
    public void tearDown(){DriverSingleton.closeDriver();}
}
