package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage {
    public Driver driver;

    By cartIsEmpty = By.xpath("//p[@class=\"text-center\"]");
    By subscription = By.xpath("//h2");
    By subscriptionField = By.id("susbscribe_email");
    By arrow = By.id("subscribe");
    By successfullSubscriptionMessage = By.name("csrfmiddlewaretoken");
    By priceOfFirstProduct = By.xpath("(//td[@class=\"cart_price\"])[1]");
    By priceOfSecondProduct = By.xpath("(//td[@class=\"cart_price\"])[2]");
    By quantityOfFirstButton = By.xpath("(//button[@class=\"disabled\"])[1]");
    By quantityOfSecondButton = By.xpath("(//button[@class=\"disabled\"])[2]");
    By totalPriceOfFirstProduct = By.xpath("(//p[@class=\"cart_total_price\"])[1]");
    By totalPriceOfSecondProduct = By.xpath("(//p[@class=\"cart_total_price\"])[2]");
    By firstProductOnCart = By.id("product-1");
    By secondProductOnCart = By.id("product-2");
    By quantityButtonOnCart = By.xpath("//button[@class=\"disabled\"]");

    public CartPage(Driver driver) {
        this.driver = driver;
    }


    /***********************             Assertions            **********************/

    public CartPage checkThatUserNavigatedToCartSuccessfully() {
     Assert.assertTrue(driver.get().findElement(cartIsEmpty).isDisplayed());
     Assert.assertEquals(driver.browser().getCurrentUrl(),"https://automationexercise.com/view_cart");
     return this;
    }

    public CartPage checkThatTextSubscriptionDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(subscription),"SUBSCRIPTION");
        return this;
    }

    public CartPage checkThatSuccessfulSubscriptionMessageDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(successfullSubscriptionMessage),"You have been successfully subscribed!");
        return this;
    }

    public CartPage checkThatBothProductsAddedToCart(){
        Assert.assertTrue(driver.get().findElement(firstProductOnCart).isDisplayed());
        Assert.assertTrue(driver.get().findElement(secondProductOnCart).isDisplayed());
        return this;
    }

    public CartPage checkThatAddedProductsPriceQuantityTotalPriceDisplayed(){
        Assert.assertTrue(driver.get().findElement(priceOfFirstProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(priceOfSecondProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(quantityOfFirstButton).isDisplayed());
        Assert.assertTrue(driver.get().findElement(quantityOfSecondButton).isDisplayed());
        Assert.assertTrue(driver.get().findElement(totalPriceOfFirstProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(totalPriceOfSecondProduct).isDisplayed());
        return  this;
    }

    public CartPage checkThatProductIsDisplayedInCartWithExactQuantity(){
        Assert.assertTrue(driver.get().findElement(firstProductOnCart).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(quantityButtonOnCart),"4");
        return this;
    }


/*************************          Actions               ***********************/

public CartPage enterEmailAdress(String email){
    driver.element().fillField(subscriptionField,email);
    return this;
}

public CartPage clickOnArrow(){
    driver.element().click(arrow);
    return this;
}

}