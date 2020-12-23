package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {
    private final By COST_SUMM_ITEM=By.xpath("//*[@id='allSum_FORMATED']");
    private final By REMOVE_FROM_CART_BUTTON=By.xpath("//a[@class='basket-item-control']//i[@class='icon-close']");
    private final By CHECK_FREE_CART=By.xpath("//span[@class='alert alert-warning alert-show']");
    private final By BUTTON_REMOVE_ONE_ITEM=By.xpath("//*[@data-item-price='22']/div[7]/div/a[2]");
    private final By BUTTON_ADD_TO_DEFERRED=By.xpath("//a[@class='basket-item-control']//i[@class='icon-star']");
    private final By GO_TO_DEFERRED=By.xpath("//li[@class='bx-ordercart-tab' and @onclick='showBasketItemsList(2)']");
    private final By CHECK_ITEM_IN_DEFFERED=By.xpath("//*[@id='delayed_items']/div[1]/div[2]");

    public CartPage(WebDriver driver, String pageUrl) { super(driver, pageUrl); }

    public String getCartOrderTotal(){
        return waitForElementLocatedBy(driver,COST_SUMM_ITEM,WAIT_TIME_SECONDS).getText();
    }

    public CartPage removeFormCart(){
        WebElement removeButton=waitForElementLocatedBy(driver,REMOVE_FROM_CART_BUTTON,WAIT_TIME_SECONDS);

        removeButton.click();
        return this;
    }

    public CartPage removeOneItem(){
        WebElement removeButton=waitForElementLocatedBy(driver,BUTTON_REMOVE_ONE_ITEM,WAIT_TIME_SECONDS);
        removeButton.click();

        return this;
    }

    public CartPage addToDeferred(){
        WebElement buttonToAdd=waitForElementLocatedBy(driver,BUTTON_ADD_TO_DEFERRED,WAIT_TIME_SECONDS);
        buttonToAdd.click();

        return this;
    }

    public  CartPage goToDeferred(){
        WebElement buttonGoToDeferred=waitForElementLocatedBy(driver,GO_TO_DEFERRED,WAIT_TIME_SECONDS);
        buttonGoToDeferred.click();

        return this;
    }

    public String checkOnDeferred(){
        return waitForElementLocatedBy(driver,CHECK_ITEM_IN_DEFFERED,WAIT_TIME_SECONDS).getText();
    }
    public String getCartFree(){
        return waitForElementLocatedBy(driver,CHECK_FREE_CART,WAIT_TIME_SECONDS).getText();
    }

}
