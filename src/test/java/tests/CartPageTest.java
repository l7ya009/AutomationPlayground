package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Homepage;
import pages.ProductPage;

public class CartPageTest {
   public Driver driver;

    @BeforeClass
    public void setup() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");
    }

    @Test(priority = 1)
    public void subscriptionOfCartPage(){
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
        .clickOnCart();
        new CartPage(driver).checkThatUserNavigatedToCartSuccessfully();
        driver.browser().scrollToBottom();
        new CartPage(driver).enterEmailAdress("yehia@outlook.com")
                .clickOnArrow();
//                .checkThatSuccessfulSubscriptionMessageDisplayed();
    }

    @Test(dependsOnMethods = "subscriptionOfCartPage", priority = 2)
    public void checkThatSelectedProductsAddedToCartSuccessfully() throws InterruptedException {
        driver.browser().navigateToUrl("https://automationexercise.com");
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnProductLink();
                new ProductPage(driver).scrollToFirstProduct()
                .hooverOnFirstProduct()
                .clickOnAddToCartFirstProduct()
                .clickOnAddToCartSecondProduct()
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

    @Test(dependsOnMethods ="checkThatProductsQuantityInCartDisplayed", priority = 4)
    public void checkThatProductsUserSearchedForAreDisplayedInCartAfterLogin() throws InterruptedException {
        driver.browser().deleteAllCookies().navigateToUrl("https://automationexercise.com");
        new Homepage(driver).clickOnProductLink()
                .checkThatUserNavigatedToProductPageSuccessfully();
        new ProductPage(driver).enterProductNameInSearch("jeans")
                .clickOnSearchButton()
                .checkThatResultsOfSearchAreVisibleForJeans()
                .addResultsOfSearchJeansProductsToCart()
                .clickOnCartButtonInJeansPage();
        new CartPage(driver).checkThatSelectedJeansItemsAddedToCart()
                .clickOnSignUpLink()
                .fillEmailAddressLogin("yehi@yahoo.com")
                .fillPassWordLogin("12345")
                .pressOnLoginButton();
        new Homepage(driver).clickOnCart();
        new CartPage(driver).checkThatSelectedJeansItemsAddedToCart();

    }

    @Test(priority = 5)
    public void checkThatUserCanAddItemsFormRecommendedItemsToCartSuccessfully() throws InterruptedException {
        driver.browser().deleteAllCookies().navigateToUrl("https://automationexercise.com")
                .scrollToBottom();
        new Homepage(driver).checkThatRecommendedItemsAreDisplayed()
                .addProductFormRecommendedProducts()
                .clickOnContinueShoppingButton()
                .clickOnCart();
        new CartPage(driver).checkThatRecommendedProductAddToCartIsDisplayedInCartSuccessfully();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
