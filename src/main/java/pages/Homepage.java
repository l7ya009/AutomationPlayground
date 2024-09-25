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
}
