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
    By proceedToCheckOut = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By continueOnCartButton = By.xpath("//button[@class=\"btn btn-success close-checkout-modal btn-block\"]");
    By signUpLink = By.xpath("(//a[@href=\"/login\"])[1]");

    public CartPage(Driver driver) {
        this.driver = driver;
    }


    /***********************             Assertions            **********************/

    @Step("checkThatUserNavigatedToCartSuccessfully")
    public CartPage checkThatUserNavigatedToCartSuccessfully() {
     Assert.assertTrue(driver.get().findElement(cartIsEmpty).isDisplayed());
     Assert.assertEquals(driver.browser().getCurrentUrl(),"https://automationexercise.com/view_cart");
     return this;
    }

    @Step("checkThatTextSubscriptionDisplayed")
    public CartPage checkThatTextSubscriptionDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(subscription),"SUBSCRIPTION");
        return this;
    }

    @Step("checkThatSuccessfulSubscriptionMessageDisplayed")
    public CartPage checkThatSuccessfulSubscriptionMessageDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(successfullSubscriptionMessage),"You have been successfully subscribed!");
        return this;
    }

    @Step("checkThatBothProductsAddedToCart")
    public CartPage checkThatBothProductsAddedToCart(){
        Assert.assertTrue(driver.get().findElement(firstProductOnCart).isDisplayed());
        Assert.assertTrue(driver.get().findElement(secondProductOnCart).isDisplayed());
        return this;
    }

    @Step("checkThatAddedProductsPriceQuantityTotalPriceDisplayed")
    public CartPage checkThatAddedProductsPriceQuantityTotalPriceDisplayed(){
        Assert.assertTrue(driver.get().findElement(priceOfFirstProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(priceOfSecondProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(quantityOfFirstButton).isDisplayed());
        Assert.assertTrue(driver.get().findElement(quantityOfSecondButton).isDisplayed());
        Assert.assertTrue(driver.get().findElement(totalPriceOfFirstProduct).isDisplayed());
        Assert.assertTrue(driver.get().findElement(totalPriceOfSecondProduct).isDisplayed());
        return  this;
    }

    @Step("checkThatProductIsDisplayedInCartWithExactQuantity")
    public CartPage checkThatProductIsDisplayedInCartWithExactQuantity(){
        Assert.assertTrue(driver.get().findElement(firstProductOnCart).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(quantityButtonOnCart),"4");
        return this;
    }

    @Step("checkThatProductIsDisplayedInCart")
    public CartPage checkThatProductIsDisplayedInCart() {
        Assert.assertTrue(driver.get().findElement(firstProductOnCart).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(quantityButtonOnCart),"1");
        return this;
    }


/*************************          Actions               ***********************/

@Step("enterEmailAdress")
public CartPage enterEmailAdress(String email){
    driver.element().fillField(subscriptionField,email);
    return this;

}

@Step("clickOnArrow")
public CartPage clickOnArrow(){
    driver.element().click(arrow);
    return this;
}

@Step("clickOnProceedToCheckOut")
public CartPage clickOnProceedToCheckOut() throws InterruptedException {
    driver.element().click(proceedToCheckOut);
    Thread.sleep(5000);
    return this;
}

@Step("clickOnContinueOnCart")
public CartPage clickOnContinueOnCart(){
    driver.element().click(continueOnCartButton);
    return this;
}

@Step("clickOnSignUpLink")
public CartPage clickOnSignUpLink(){
    driver.element().click(signUpLink);
    return this;
}

}