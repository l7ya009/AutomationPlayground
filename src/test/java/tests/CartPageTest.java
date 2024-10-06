package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Homepage;
import pages.ProductPage;

public class CartPageTest {
    Driver driver;

    @BeforeClass
    public void setup() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");
    }

    @Test(priority = 1)
    public void subscriptionOfCartPage(){
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        new Homepage(driver).clickOnCart();
        new CartPage(driver).checkThatUserNavigatedToCartSuccessfully();
        driver.browser().scrollToBottom();
        new CartPage(driver).enterEmailAdress("yehiaosama009@gmail.com")
                .clickOnArrow();
//                .checkThatSuccessfulSubscriptionMessageDisplayed();
    }

    @Test(dependsOnMethods = "subscriptionOfCartPage", priority = 2)
    public void checkThatSelectedProductsAddedToCartSuccessfully() throws InterruptedException {
        driver.browser().navigateToUrl("https://automationexercise.com");
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnProductLink()
                .scrollToFirstProduct()
                .hooverOnFirstProduct()
                .clickOnAddToCartFirstProduct()
                .clickOnContinueButton()
                .hooverOnSecondProduct()
                .clickOnAddToCartSecondProduct()
                .clickOnContinueButton()
                .clickOnCartButton();
        new CartPage(driver).checkThatBothProductsAddedToCart()
                .checkThatAddedProductsPriceQuantityTotalPriceDisplayed();
    }

    @Test(dependsOnMethods = "checkThatSelectedProductsAddedToCartSuccessfully", priority = 3)
    public void checkThatProductsQuantityInCartDisplayed() throws InterruptedException {
        driver.browser().deleteAllCookies().navigateToUrl("https://automationexercise.com");
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnViewProduct();
        new ProductPage(driver).checkThatSelectedProductDetailsDisplayed()
                .increaseQuantityToFour(4)
                .clickOnAddToCartButton()
                .clickOnContinueButton()
                .clickOnCartButton();
        new CartPage(driver).checkThatProductIsDisplayedInCartWithExactQuantity();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
