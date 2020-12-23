package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{
    public HomePage(WebDriver driver, String pageUrl) { super(driver, pageUrl); }

    public HomePage openPage(){
        driver.get(pageUrl);
        return this;
    }
}
