package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.logging.Handler;

public class CheckOutTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");
    }

    @Test(priority = 1)
    public void checkThatAddressIsSameAsEnteredInRegistration() throws InterruptedException {
        driver.browser().deleteAllCookies();
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnSignUpLink();
        new LoginSignupPage(driver).checkThatUserCanNavigateToLoginSignUpPage()
                .fillInSignUpName("yyyehia")
                .fillInSignUpEmail("yyyehia@gmail.com")
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
                .fillState("egypt")
                .fillCity("alexandria")
                .fillZipCode("54371")
                .fillMobileNumber("01115667781")
                .clickCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton();
        new Homepage(driver).clickOnAddToCartFirstProduct()
                .clickOnContinueShoppingButton()
                .clickOnCart()
                .checkThatCartPageIsDisplayed();
        new CartPage(driver).clickOnProceedToCheckOut();
        new CheckOutPage(driver).checkThatDeliveryAddressIsShownAsEnteredInRegistration()
                .checkThatBillingAddressIsShownAsEnteredInRegistration();
        new Homepage(driver).clickOnDeleteAccountLink()
                .checkThatAccountShouldBeDeletedSuccessfully();

    }






    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
