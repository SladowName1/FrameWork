package test;

import driver.DriverSingleton;
import model.Item;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import page.*;
import service.ItemCreator;
import service.UserCreator;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IgroMasteryTest extends CommonConditions{


    @Test
    @Order(1)
    public void checkInvalidPasswordTest()
    {
        setUp();

        User user= UserCreator.withCredantialsFromProperty("second");

        LoginPage loginPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .selectAutorization()
                .inputLoginandPassword(user.getLogin(),user.getPassword());
        Assert.assertEquals(loginPage.getNoCorrectPassword(),"Неверный логин или пароль.");

        tearDown();
    }


    @Test
    @Order(2)
    public void addToCartProductWithCorrespondingArticleTest()
    {

        setUp();

        Item firstItem= ItemCreator.withCredentialsFromProperty("first");
        Item secondItem=ItemCreator.withCredentialsFromProperty("second");

        CartPage firstCartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(firstItem.getName())
                .selectRedBicycle()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/");

       CartPage secondCartPage=new HomePage(driver,"https://igromaster.by/")
               .openPage()
               .searchForProductName(secondItem.getName())
               .selectFournier()
               .addToBasketBlueBicycle()
               .openCart(driver,"https://igromaster.by/personal/cart/");


       Assert.assertEquals(secondCartPage.getCartOrderTotal(),"59 руб.");

       tearDown();
    }

    @Test
    @Order(3)
    public void removeFromCartTest(){
        setUp();

        Item firstItem= ItemCreator.withCredentialsFromProperty("first");
        CartPage firstCartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(firstItem.getName())
                .selectRedBicycle()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/")
                .removeFormCart();

        Assert.assertEquals(firstCartPage.getCartFree(),"Ваша корзина пуста");

        tearDown();
    }

    @Test
    @Order(4)
    public void checkInvalidCaptchaTest(){

        setUp();

        User user= UserCreator.withCredantialsFromProperty("first");
        RegistrationPage registrationPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .selectRegistration()
                .selectButtonRegistration()
                .inputAllDataToForm(user)
                .setElementRegistration();

        Assert.assertEquals(registrationPage.checkCaptchaValidation(),"Слово для защиты от автоматической регистрации введено неверно");

      tearDown();
    }

    @Test
    @Order(5)
    public void removeOneItemFromCart(){

        setUp();

        Item firstItem= ItemCreator.withCredentialsFromProperty("first");
        Item secondItem=ItemCreator.withCredentialsFromProperty("second");

        CartPage firstCartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(firstItem.getName())
                .selectRedBicycle()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/");

        CartPage secondCartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(secondItem.getName())
                .selectFournier()
                .addToBasketBlueBicycle()
                .openCart(driver,"https://igromaster.by/personal/cart/")
                .removeOneItem();

        Assert.assertEquals(secondCartPage.getCartOrderTotal(),"37 руб.");

        tearDown();
    }

    @Test
    @Order(6)
    public void addManyItemsToCart(){

        setUp();

        Item item=ItemCreator.withCredentialsFromProperty("first");
        CartPage cartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(item.getName())
                .selectRedBicycle()
                .addMoreItemToOrder("3")
                .checkCostItem()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/");

        Assert.assertEquals(cartPage.getCartOrderTotal(),"66 руб.");

        tearDown();
    }

    @Test
    @Order(7)
    public void checkPoromoCodeTest(){

        setUp();

        Item item=ItemCreator.withCredentialsFromProperty("first");
        ProductPage productPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(item.getName())
                .selectRedBicycle()
                .addToBasket()
                .setPromoCode("asdasd");

        Assert.assertEquals(productPage.checkPromoCode(),"asdasd не найден");

        tearDown();
    }

    @Test
    @Order(8)
    public void checkInvalidLoginTest(){

        setUp();

        User user= UserCreator.withCredantialsFromProperty("first");

        LoginPage loginPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .selectAutorization()
                .inputLoginandPassword(user.getLogin(),user.getPassword());
        Assert.assertEquals(loginPage.getNoCorrectPassword(),"Неверный логин или пароль.");

      tearDown();
    }

    @Test
    @Order(9)
    public void checkMoreItemThenThree(){

        setUp();

        Item item=ItemCreator.withCredentialsFromProperty("first");
        CartPage cartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(item.getName())
                .selectRedBicycle()
                .addMoreItemToOrder("10")
                .clickToEmpty()
                .checkCostItem()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/");

        Assert.assertEquals(cartPage.getCartOrderTotal(),"66 руб.");

        tearDown();
    }

    @Test
    @Order(10)
    public void checkItemInDeferred(){
        setUp();

        Item item=ItemCreator.withCredentialsFromProperty("first");
        CartPage cartPage=new HomePage(driver,"https://igromaster.by/")
                .openPage()
                .searchForProductName(item.getName())
                .selectRedBicycle()
                .addToBasket()
                .openCart(driver,"https://igromaster.by/personal/cart/")
                .addToDeferred()
                .goToDeferred();

        Assert.assertEquals(cartPage.checkOnDeferred(),"Товары");

        tearDown();
    }

}
