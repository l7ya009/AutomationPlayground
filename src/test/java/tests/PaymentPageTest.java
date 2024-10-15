package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class PaymentPageTest {
   public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");

    }

    @Test(priority = 1)
    public void checkThatUserCanRegisterSuccessfullyWhileCheckOut () throws InterruptedException {
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnAddToCartFirstProduct()
                .clickOnContinueShoppingButton()
                .clickOnCart()
                .checkThatCartPageIsDisplayed();
        new CartPage(driver).clickOnProceedToCheckOut()
                .clickOnContinueOnCart()
                .clickOnSignUpLink();
        new LoginSignupPage(driver).fillInSignUpName("yehiaaaaa ooosamaa")
                .fillInSignUpEmail("yehiaaaaooosamaa@yahoo.com")
                .clickOnSignUpButton();
        new RegistrationPage(driver).selectTitle()
                .fillPassword("12345")
                .fillDayOfBirth()
                .fillMonthOfBirth()
                .fillYearOfBirth()
                .fillFirstName("yehia")
                .fillLastName("osama")
                .fillCompany("testing")
                .fillAddress1("gamal abdl nasser")
                .fillAddress2("miami")
                .fillCountry()
                .fillState("california")
                .fillCity("alexandria")
                .fillZipCode("54371")
                .fillMobileNumber("01115667781")
                .clickCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnCart();
        new CartPage(driver).clickOnProceedToCheckOut();
        new CheckOutPage(driver).checkThatAddressDetailsAndOrderDetailsDisplayed()
                .fillCommentField("description")
                .clickOnPlaceOrderButton();
        new pages.PaymentPage(driver).checkThatUserNavigatedToPaymentPage()
                .fillNameOnCard("yehia")
                .fillCardNumber("15425213213212")
                .fillCvc("243")
                .fillExpirationMonth("10")
                .fillExpirationYear("2026")
                .clickOnPayAndConfirmButton()
                .checkThatOrderPlacedAndConfirmedSuccessfully()
                .clickOnDeleteAccount()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();

    }

    @Test (dependsOnMethods = "checkThatUserCanRegisterSuccessfullyWhileCheckOut", priority = 2)
    public void checkThatUserCanRegisterSuccessfullyBeforeCheckOut() throws InterruptedException {
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnSignUpLink();
        new LoginSignupPage(driver).fillInSignUpName("yehiaaaaa ooosamaa")
                .fillInSignUpEmail("yehiaaaaooosamaa@yahoo.com")
                .clickOnSignUpButton();
        new RegistrationPage(driver).checkThatUserShouldBeNavigatedToRegistrationPage()
                .selectTitle()
                .fillPassword("12345")
                .fillDayOfBirth()
                .fillMonthOfBirth()
                .fillYearOfBirth()
                .fillFirstName("yehia")
                .fillLastName("osama")
                .fillCompany("testing")
                .fillAddress1("gamal abdl nasser")
                .fillAddress2("miami")
                .fillCountry()
                .fillState("california")
                .fillCity("alexandria")
                .fillZipCode("54371")
                .fillMobileNumber("01115667781")
                .clickCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLoggedInAsUserNameAtTop()
                .clickOnAddToCartFirstProduct()
                .clickOnContinueShoppingButton()
                .clickOnCart()
                .checkThatCartPageIsDisplayed();
        new CartPage(driver)
                .clickOnProceedToCheckOut();
        new CheckOutPage(driver).checkThatAddressDetailsAndOrderDetailsDisplayed()
                .fillCommentField("description")
                .clickOnPlaceOrderButton();
        new pages.PaymentPage(driver).checkThatUserNavigatedToPaymentPage()
                .fillNameOnCard("yehia")
                .fillCardNumber("15425213213212")
                .fillCvc("243")
                .fillExpirationMonth("10")
                .fillExpirationYear("2026")
                .clickOnPayAndConfirmButton()
                .checkThatOrderPlacedAndConfirmedSuccessfully()
                .clickOnDeleteAccount()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();
    }

    @Test(dependsOnMethods = "checkThatUserCanRegisterSuccessfullyBeforeCheckOut",priority = 3)
    public void checkThatUserCanLoginSuccessfullyBeforeCheckOut() throws InterruptedException {
        driver.browser().deleteAllCookies();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully().clickOnSignUpLink();
        new LoginSignupPage(driver).fillInSignUpName("yehiaaaaa ooosamaa")
                .fillInSignUpEmail("yehiaaaaooosamaa@yahoo.com")
                .clickOnSignUpButton();
        new RegistrationPage(driver).checkThatUserShouldBeNavigatedToRegistrationPage()
                .selectTitle()
                .fillPassword("12345")
                .fillDayOfBirth()
                .fillMonthOfBirth()
                .fillYearOfBirth()
                .fillFirstName("yehia")
                .fillLastName("osama")
                .fillCompany("testing")
                .fillAddress1("gamal abdl nasser")
                .fillAddress2("miami")
                .fillCountry()
                .fillState("california")
                .fillCity("alexandria")
                .fillZipCode("54371")
                .fillMobileNumber("01115667781")
                .clickCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnLogoutLink();
        new LoginSignupPage(driver).checkThatUserCanNavigateToLoginSignUpPage()
                .fillInLoginEmail("yehiaosama0009@gmail.com")
                .fillInLoginPassword("12345")
                .clickOnLoginButton();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLoggedInAsUserNameAtTop()
                .clickOnAddToCartFirstProduct()
                .clickOnContinueShoppingButton()
                .clickOnCart();
        new CartPage(driver).checkThatProductIsDisplayedInCart()
                .clickOnProceedToCheckOut();
        new CheckOutPage(driver).checkThatAddressDetailsAndOrderDetailsDisplayed()
                .fillCommentField("description")
                .clickOnPlaceOrderButton();
        new pages.PaymentPage(driver).checkThatUserNavigatedToPaymentPage()
                .fillNameOnCard("yehia")
                .fillCardNumber("15425213213212")
                .fillCvc("243")
                .fillExpirationMonth("10")
                .fillExpirationYear("2026")
                .clickOnPayAndConfirmButton()
                .checkThatOrderPlacedAndConfirmedSuccessfully()
                .clickOnDeleteAccount()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();
    }

    @Test(dependsOnMethods = "checkThatUserCanLoginSuccessfullyBeforeCheckOut", priority = 4)
    public void checkThatUserCanRemoveProductFromCart() throws InterruptedException {
        driver.browser().deleteAllCookies();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnAddToCartFirstProduct()
                .clickOnContinueShoppingButton()
                .clickOnCart();
        new CartPage(driver).clickOnXButton()
                .checkThatCartIsEmpty();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }


}