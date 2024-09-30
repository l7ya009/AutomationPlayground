package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class NewTest {
Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");

    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){

        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                            .clickOnLoginLink()
                            .checkThatUserCanNavigateToLoginSignUpPage()
                            .fillInSignUpName("yehia")
                            .fillInSignUpEmail("yehiiiiii@yahoo.com")
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
                            .checkThatSuccessMessageShouldBeDisplayed();

        driver.get().manage().deleteAllCookies();

    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully" , priority = 2)
    public void userCanLoginSuccessfully(){
        driver.browser().navigateToUrl("https://automationexercise.com/login");

        new LoginSignupPage(driver).fillInLoginEmail("yehiiiiii@yahoo.com")
                                   .fillInLoginPassword("12345")
                                   .clickOnLoginButton();


    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully" , priority = 3)
    public void userCanLogOutSuccessfully(){
        new Homepage(driver).checkThatLogOutLinkShouldBeDisplayed()
                            .clickOnLogoutLink()
                            .checkThatUserCanNavigateToLoginSignUpPage();

    }

    @Test(dependsOnMethods ="userCanLogOutSuccessfully",priority = 4)
    public void userCannotRegisterWithExistingEmail(){
        new LoginSignupPage(driver).fillInSignUpName("yehia")
                                   .fillInSignUpEmail("yehiiiiii@yahoo.com")
                                   .clickOnSignUpButton();

        new LoginSignupPage(driver).checkThatUserCannotSignUpWithExistingEmail();

    }

    @Test(dependsOnMethods = "userCanLogOutSuccessfully" , priority = 5)
    public void userCanDeleteAccountSuccessfully() {

        new LoginSignupPage(driver).fillInLoginEmail("yehiiiiii@yahoo.com")
                                   .fillInLoginPassword("12345")
                                   .clickOnLoginButton();
        new Homepage(driver).checkThatLogOutLinkShouldBeDisplayed()
                                   .clickOnDeleteAccountLink()
                                   .checkThatAccountShouldBeDeletedSuccessfully()
                                   .clickContinueButton()
                                   .checkThatUserShouldBeNavigatedToHomePageSuccessfully();
    }

    @Test(priority = 6)
    public void incorrectEmailAndPassword(){
        driver.browser().navigateToUrl("https://automationexercise.com/login");
        new LoginSignupPage(driver).fillInLoginEmail("ye@yahoo.com")
                                   .fillInLoginPassword("1234")
                                   .clickOnLoginButton()
                                   .checkThatUserCannotLoginWithWrongEmailAndPassword();
    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }

}
