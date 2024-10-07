package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginSignupPage {

    public Driver driver;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpFormTitle = By.xpath("(//h2)[3]");
    By signUpName = By.xpath("//input[@data-qa=\"signup-name\"]");
    By SignUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By SignUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    By ExistingEmailMessage = By.xpath("(//p)[1]");
    By WrongEmailAndPasswordMessage = By.xpath("(//p)[1]");


    public LoginSignupPage(Driver driver) {
        this.driver = driver;
    }

    /******************************** Assertions ******************************************/

    @Step("checkThatUserCanNavigateToLoginSignUpPage")
    public LoginSignupPage checkThatUserCanNavigateToLoginSignUpPage() {

        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/login"));
        Assert.assertEquals(driver.element().getTextOf(signUpFormTitle), "New User Signup!");
        return this;

    }

    @Step("checkThatUserCannotSignUpWithExistingEmail")
    public LoginSignupPage checkThatUserCannotSignUpWithExistingEmail() {
        Assert.assertTrue(driver.get().findElement(ExistingEmailMessage).isDisplayed());
        return this;
    }

    @Step("checkThatUserCannotLoginWithWrongEmailAndPassword")
    public LoginSignupPage checkThatUserCannotLoginWithWrongEmailAndPassword() {
        Assert.assertTrue(driver.get().findElement(WrongEmailAndPasswordMessage).isDisplayed());
        return this;

    }


    /******************************** Actions ********************************************/

    @Step("fillInLoginEmail")
    public LoginSignupPage fillInLoginEmail(String email) {
        driver.element().fillField(loginEmail, email);
        return this;
    }

    @Step("fillInLoginPassword")
    public LoginSignupPage fillInLoginPassword(String password) {
        driver.element().fillField(loginPassword, password);
        return this;
    }

    @Step("clickOnLoginButton")
    public LoginSignupPage clickOnLoginButton() {
        driver.element().click(loginButton);
        return this;
    }

    @Step("fillInSignUpName")
    public LoginSignupPage fillInSignUpName(String name) {
        driver.element().fillField(signUpName, name);
        return this;
    }

    @Step("fillInSignUpEmail")
    public LoginSignupPage fillInSignUpEmail(String email) {
        driver.element().fillField(SignUpEmail, email);
        return this;
    }

    @Step("clickOnSignUpButton")
    public RegistrationSuccessPage clickOnSignUpButton() {
        driver.element().click(SignUpButton);
        return new RegistrationSuccessPage(driver);
    }
}
