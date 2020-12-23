package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected String pageUrl;
    protected final long WAIT_TIME_SECONDS=20;
    private final By AUTORIZATION_BUTTON_ELEMENT=By.xpath("//*[@id='user-obfodefn']");
    private final By INPUT_LOGIN=By.xpath("//input[@name='USER_LOGIN']");
    private final By INPUT_PASSWORD=By.xpath("//input[@name='USER_PASSWORD']");
    private final By LOGIN_BUTTON_ELEMENT=By.xpath("//button[@id='system_auth_form6zOYVN_btn']");


    public AbstractPage(WebDriver driver,String pageUrl){
        this.driver=driver;
        this.pageUrl=pageUrl;
    }

    public ProductPage searchForProductName(String productName){
        WebElement searchInputField=waitForElementLocatedBy(driver,
                By.id("title-search-input"),WAIT_TIME_SECONDS);
        searchInputField.sendKeys(productName);
        searchInputField.sendKeys(Keys.ENTER);
        return new ProductPage(driver,pageUrl);
    }
    public LoginPage inputLoginandPassword(String login,String password){
        WebElement inputLogin=waitForElementLocatedBy(driver,INPUT_LOGIN,WAIT_TIME_SECONDS);
        inputLogin.sendKeys(login);
        inputLogin.submit();
        WebElement inputPassword=waitForElementLocatedBy(driver,INPUT_PASSWORD,WAIT_TIME_SECONDS);
        inputPassword.sendKeys(login);
        inputPassword.submit();
        return new LoginPage(driver,pageUrl);
    }

    public CartPage openCart(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
        return new CartPage(driver, pageUrl);
    }

    public LoginPage selectAutorization(){
        WebElement autorization=waitForElementLocatedBy(driver,AUTORIZATION_BUTTON_ELEMENT,WAIT_TIME_SECONDS);
        autorization.click();
        return new LoginPage(driver,pageUrl);
    }

    public RegistrationPage selectRegistration(){
        WebElement autorization=waitForElementLocatedBy(driver,AUTORIZATION_BUTTON_ELEMENT,WAIT_TIME_SECONDS);
        autorization.click();
        return new RegistrationPage(driver,pageUrl);
    }
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement fluentWaitForElementLocatedBy(WebDriver driver, By by, long time, long pollingEvery) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .ignoring(NoSuchElementException.class);
        return  (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
