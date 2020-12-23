package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage  extends AbstractPage{
    private final By SELECTED_RED_BICYCLE= By.xpath("//*[@id='bx_3966226736_10205_7e1b8e3524755c391129a9d7e6f2d206']");
    private final By ADD_TO_BASKET_ON_SEARCH =By.id("bx_117848907_10205_buy_link");
    private final By SELECTED_FOURNIER= By.xpath("//*[@id='bx_3966226736_26346_7e1b8e3524755c391129a9d7e6f2d206']");
    private final By ADD_TO_BASKET_ON_SEARCH_BLUE =By.xpath("//*[@id='bx_117848907_26346_buy_link']");
    private final By COUNT_ITEM_TO_ORDER=By.xpath("//*[@id='bx_117848907_10205_quantity']");
    private final By PROMO_CODE_ELEMENT=By.xpath("//*[@id='coupon']");
    private final By CHEACK_PROMO_CODE_ELEMEN=By.xpath("//*[@id='coupons_block']/div[2]/span[1]");
    private final By BUTTON_TO_ADD_COUPON=By.xpath("//button[@onclick='enterCoupon();']");
    private final By CLICK_TO_EMPTY=By.xpath("//*[@id='bx_117848907_10205_tab_containers']/div/div[2]/div[2]/div[2]");

    public ProductPage(WebDriver driver, String pageUrl) { super(driver, pageUrl); }

    public ProductPage selectRedBicycle()
    {
        WebElement selectButton=waitForElementLocatedBy(driver, SELECTED_RED_BICYCLE,WAIT_TIME_SECONDS);
        selectButton.click();
        return this;
    }
    public ProductPage addToBasket(){
        WebElement cartButton=waitForElementLocatedBy(driver, ADD_TO_BASKET_ON_SEARCH,WAIT_TIME_SECONDS);
        cartButton.click();
        return this;
    }

    public ProductPage selectFournier()
    {
        WebElement selectButton=waitForElementLocatedBy(driver, SELECTED_FOURNIER,WAIT_TIME_SECONDS);
        selectButton.click();
        return this;
    }

    public ProductPage addToBasketBlueBicycle(){
        WebElement cartButton=waitForElementLocatedBy(driver, ADD_TO_BASKET_ON_SEARCH_BLUE,WAIT_TIME_SECONDS);
        cartButton.click();
        return this;
    }

    public ProductPage addMoreItemToOrder(String count){
        WebElement countOfItem=waitForElementLocatedBy(driver,COUNT_ITEM_TO_ORDER,WAIT_TIME_SECONDS);
        countOfItem.clear();
        countOfItem.sendKeys(count);
        return this;
    }
    public ProductPage checkCostItem()
    {
        WebElement costItem=waitForElementLocatedBy(driver,By.xpath("//*[@id='bx_117848907_10205_total_cost']/span"),WAIT_TIME_SECONDS);
        costItem.getText().equals("66 руб.");

        return this;
    }
    public ProductPage setPromoCode(String promo){
        WebElement promoCode=waitForElementLocatedBy(driver,PROMO_CODE_ELEMENT,WAIT_TIME_SECONDS);
        promoCode.sendKeys(promo);

        WebElement buttonToAdd=waitForElementLocatedBy(driver,BUTTON_TO_ADD_COUPON,WAIT_TIME_SECONDS);
        buttonToAdd.click();

        return this;
    }

    public ProductPage clickToEmpty(){
        WebElement clickEmpty=waitForElementLocatedBy(driver,CLICK_TO_EMPTY,WAIT_TIME_SECONDS);
        clickEmpty.click();

        return this;
    }
    public String checkPromoCode()
    {
        return waitForElementLocatedBy(driver,CHEACK_PROMO_CODE_ELEMEN,WAIT_TIME_SECONDS).getText();
    }
}
