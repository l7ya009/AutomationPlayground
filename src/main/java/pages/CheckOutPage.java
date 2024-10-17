package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutPage {
    public Driver driver;

    By yourDeliveryAddress = By.id("address_delivery");
    By youBillingAddress = By.id("address_invoice");
    By productDetails = By.id("product-1");
    By commentField = By.xpath("//textarea[@class=\"form-control\"]");
    By placeOrderButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By deliveryAddressShown = By.xpath("(//li[@class=\"address_city address_state_name address_postcode\"])[1]");
    By billingAddressShown = By.xpath("(//li[@class=\"address_city address_state_name address_postcode\"])[2]");


    public CheckOutPage (Driver driver){
        this.driver = driver;
    }

    /****************************************** Assertions ******************************************/

    @Step("checkThatAddressDetailsAndOrderDetailsDisplayed")
    public CheckOutPage checkThatAddressDetailsAndOrderDetailsDisplayed(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/checkout"));
        Assert.assertTrue(driver.get().findElement(yourDeliveryAddress).isDisplayed());
        Assert.assertTrue(driver.get().findElement(youBillingAddress).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productDetails).isDisplayed());
        return this;
    }

    public CheckOutPage checkThatDeliveryAddressIsShownAsEnteredInRegistration(){
        Assert.assertEquals(driver.element().getTextOf(deliveryAddressShown),"alexandria egypt 54371");
        return this;
    }

    public CheckOutPage checkThatBillingAddressIsShownAsEnteredInRegistration(){
        Assert.assertEquals(driver.element().getTextOf(billingAddressShown),"alexandria egypt 54371");
        return this;
    }

    /********************************************* Actions *****************************************/

    @Step("fillCommentField")
    public CheckOutPage fillCommentField(String comment){
        driver.element().fillField(commentField,comment);
        return this;
    }

    @Step("clickOnPlaceOrderButton")
    public CheckOutPage clickOnPlaceOrderButton(){
        driver.element().click(placeOrderButton);
        return this;
    }

}
