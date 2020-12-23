package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {
    private final By PERSONAL_ICON= By.xpath("//*[@id='user-obfodefn']");
    private final By PERSONAL_DATA_ICON=By.xpath("//a[@class='user-menu-item' and @title='Личные данные']");

    public LoginPage(WebDriver driver, String pageUrl) { super(driver, pageUrl); }

    public LoginPage selectPersonalIcon(){
        WebElement personalIcon=waitForElementLocatedBy(driver,PERSONAL_ICON,WAIT_TIME_SECONDS);
        personalIcon.click();
        return this;
    }

    public String getNoCorrectPassword()
    {
        return waitForElementLocatedBy(driver,By.xpath("//*[@id='system_auth_form6zOYVN_alert']"),WAIT_TIME_SECONDS).getText();
    }



}
