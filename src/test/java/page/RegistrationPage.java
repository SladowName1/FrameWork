package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends AbstractPage{
    private final By BUTTON_REGISTRATION_ON_MAIN_PAGE=By.xpath("//a[@href='/personal/private/?register=yes']");
    private final By ELEMENT_NAME_FORM=By.xpath("//input[@name='USER_NAME' and @class='form-control']");
    private final By ELEMENT_LAST_NAME_FORM=By.xpath("//input[@name='USER_LAST_NAME' and @class='form-control']");
    private final By ELEMENT_LOGIN_FORM=By.xpath("//input[@name='USER_LOGIN' and @class='form-control']");
    private final By ELEMENT_PASSWORD_FORM=By.xpath("//input[@name='USER_PASSWORD' and @class='form-control']");
    private final By ELEMENT_PASSWORD_REPEAT_FORM=By.xpath("//input[@name='USER_CONFIRM_PASSWORD' and @class='form-control']");
    private final By ELEMENT_EMAIL_FORM=By.xpath("//input[@name='USER_EMAIL' and @class='form-control']");
    private final By ELEMENT_CAPTCHA_FORM=By.xpath("//input[@name='captcha_word' and @class='form-control']");
    private final By BUTTON_REGISTRATION_ON_REGISTRATON_PAGE=By.xpath("//button[@class='btn btn-buy' and @name='Register']");
    private final By ELEMENT_VALIDATION_CAPTACHA=By.xpath("//span[@class='alert alert-error alert-show']");

    public RegistrationPage(WebDriver driver, String pageUrl) { super(driver, pageUrl); }

    public RegistrationPage selectButtonRegistration(){
        WebElement registrationButton=waitForElementLocatedBy(driver,BUTTON_REGISTRATION_ON_MAIN_PAGE,WAIT_TIME_SECONDS);
        registrationButton.click();

        return this;
    }

    public RegistrationPage inputAllDataToForm(User user){
        WebElement nameForm=waitForElementLocatedBy(driver,ELEMENT_NAME_FORM,WAIT_TIME_SECONDS);
        WebElement lastNameForm=waitForElementLocatedBy(driver,ELEMENT_LAST_NAME_FORM,WAIT_TIME_SECONDS);
        WebElement loginForm=waitForElementLocatedBy(driver,ELEMENT_LOGIN_FORM,WAIT_TIME_SECONDS);
        WebElement passwordForm=waitForElementLocatedBy(driver,ELEMENT_PASSWORD_FORM,WAIT_TIME_SECONDS);
        WebElement repeatPasswordForm=waitForElementLocatedBy(driver,ELEMENT_PASSWORD_REPEAT_FORM,WAIT_TIME_SECONDS);
        WebElement emailForm=waitForElementLocatedBy(driver,ELEMENT_EMAIL_FORM,WAIT_TIME_SECONDS);
        WebElement captchaForm=waitForElementLocatedBy(driver,ELEMENT_CAPTCHA_FORM,WAIT_TIME_SECONDS);

        nameForm.sendKeys(user.getFirstName());
        lastNameForm.sendKeys(user.getLastName());
        loginForm.sendKeys(user.getLogin());
        passwordForm.sendKeys(user.getPassword());
        repeatPasswordForm.sendKeys(user.getPassword());
        emailForm.sendKeys(user.getEmail());
        captchaForm.sendKeys(String.valueOf(Math.random()));

        return this;
    }
    public RegistrationPage setElementRegistration(){
        WebElement registrationButton=waitForElementLocatedBy(driver,BUTTON_REGISTRATION_ON_REGISTRATON_PAGE,WAIT_TIME_SECONDS);
        registrationButton.click();

        return this;
    }

    public String checkCaptchaValidation(){
        return waitForElementLocatedBy(driver,ELEMENT_VALIDATION_CAPTACHA,WAIT_TIME_SECONDS).getText();
    }
}
