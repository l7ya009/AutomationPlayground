package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage {
    public Driver driver;

    By cartIsEmpty = By.id("empty_cart");
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
    By signUpFromCheckOutBox = By.xpath("(//a[@href=\"/login\"])[2]");
    By XButton = By.xpath("//i[@class=\"fa fa-times\"]");
    By cartInfoForFirstJeansProduct = By.xpath("//a[@href=\"/product_details/33\"]");
    By cartInfoForSecondJeansProduct = By.xpath("//a[@href=\"/product_details/37\"]");
    By cartInfoForThirdJeansProduct = By.xpath("//a[@href=\"/product_details/35\"]");
    By recommendedProductInCart = By.xpath("//a[@href=\"/product_details/4\"]");

    By emailAddressLogin = By.name("email");
    By passWordLogin = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

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

    @Step("checkThatCartIsEmpty")
    public CartPage checkThatCartIsEmpty(){
        Assert.assertEquals(driver.element().getTextOf(cartIsEmpty),"Cart is empty! Click here to buy products.");
        return this;
    }

    @Step("checkThatSelectedJeansItemsAddedToCart")
    public CartPage checkThatSelectedJeansItemsAddedToCart(){
        Assert.assertEquals(driver.element().getTextOf(cartInfoForFirstJeansProduct),"Soft Stretch Jeans");
        Assert.assertEquals(driver.element().getTextOf(cartInfoForSecondJeansProduct) ,"Grunt Blue Slim Fit Jeans");
        Assert.assertEquals(driver.element().getTextOf(cartInfoForThirdJeansProduct),"Regular Fit Straight Jeans");
        return this;
    }

    @Step("checkThatRecommendedProductAddToCartIsDisplayedInCartSuccessfully")
    public CartPage checkThatRecommendedProductAddToCartIsDisplayedInCartSuccessfully(){
        Assert.assertEquals(driver.element().getTextOf(recommendedProductInCart),"Stylish Dress");
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

@Step("clickOnXButton")
public CartPage clickOnXButton(){
    driver.element().click(XButton);
    return this;
}

@Step("fillEmailAddressLogin")
public CartPage fillEmailAddressLogin(String email){
    driver.element().fillField(emailAddressLogin,email);
    return this;
}

@Step("fillPassWordLogin")
public CartPage fillPassWordLogin(String password){
    driver.element().fillField(passWordLogin,password);
    return this;
}

@Step("pressOnLoginButton")
public CartPage pressOnLoginButton(){
    driver.element().click(loginButton);
    return this;
}

@Step("clickOnSignUpFromCheckOutBox")
public CartPage clickOnSignUpFromCheckOutBox() throws InterruptedException {
    driver.element().click(signUpFromCheckOutBox);
    Thread.sleep(5000);
    return this;
}



}