package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    public Driver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By productLink = By.xpath("//a[@href=\"/products\"]");
    By testCasesLink = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By subscription = By.xpath("(//div[@class=\"row\"])[4]");
//By subscription = By.id("footer");
//    By subscriptionField = By.id("susbscribe_email");
    By subscriptionField = By.xpath("//input[@type=\"email\"]");
    By subscriptionButton = By.xpath("//i[@class=\"fa fa-arrow-circle-o-right\"]");
    By successfullSubscriptionMessage = By.name("csrfmiddlewaretoken");
    By cart = By.xpath("//a[@href=\"/view_cart\"]");
    By viewProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By productDetails = By.xpath("//div[@class=\"col-sm-9 padding-right\"]");


    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /******************************** Assertions ******************************************/

    @Step("checkThatLogOutLinkShouldBeDisplayed")
    public Homepage checkThatLogOutLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(logoutLink).isDisplayed());
        return this;
    }

    @Step("checkThatUserShouldBeNavigatedToHomePageSuccessfully")
    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully(){
        Assert.assertEquals(driver.browser().getCurrentUrl(),"https://automationexercise.com/");
        return this;
    }

    @Step("checkThatLoginLinkShouldBeDisplayed")
    public Homepage checkThatLoginLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/login"));
        return this;
    }

    @Step("checkThatDeleteAccountLinkShouldBeDisplayed")
    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(deleteAccountLink).isDisplayed());
        return this;
    }

    @Step("checkThatSubscriptionIsDisplayed")
    public Homepage checkThatSubscriptionIsDisplayed(){
        Assert.assertTrue(driver.get().findElement(subscription).isDisplayed());
        return this;
    }


    @Step("checkThatSuccessfulSubscriptionMessageDisplayed")
    public Homepage checkThatSuccessfulSubscriptionMessageDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(successfullSubscriptionMessage),"You have been successfully subscribed!");
        return this;
    }

    @Step("checkThatProductDetailsDisplayed")
    public Homepage checkThatProductDetailsDisplayed(){
        Assert.assertTrue(driver.get().findElement(productDetails).isDisplayed());
        return this;
    }



    /******************************** Actions ********************************************/

    public LoginSignupPage clickOnLoginLink(){
        driver.element().click(loginLink);
        return new LoginSignupPage(driver);
    }

    public LoginSignupPage clickOnLogoutLink(){
        driver.get().findElement(logoutLink).click();
        return new LoginSignupPage(driver);
    }

    public AccountSuccessfulDeletion clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    public ProductPage clickOnProductLink(){
        driver.element().click(productLink);
        return new ProductPage(driver);
    }

    public TestCasesPage clickOnTestCasesLink(){
        driver.element().click(testCasesLink);
        return new TestCasesPage(driver);
    }

    public Homepage fillSubscriptionField(String email){
        driver.element().fillField(subscriptionField, email);
        return this;
    }

    public Homepage clickOnSubscriptionButton(){
        driver.element().click(subscriptionButton);
        return this;
    }

    public Homepage clickOnCart(){
        driver.element().click(cart);
        return this;
    }

    public Homepage clickOnViewProduct(){
        driver.element().click(viewProduct);
        return this;
    }

}
