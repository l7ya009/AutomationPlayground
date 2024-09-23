package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSuccessPage {

    public Driver driver;
    private WebDriverWait wait;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");

    public RegistrationSuccessPage(Driver driver) {
        this.driver = driver;
//        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    /******************************** Assertions ******************************************/

    public RegistrationSuccessPage checkThatSuccessMessageShouldBeDisplayed() {
//        wait.until(ExpectedConditions.urlContains("/account_created"));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successMessage)));

        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.get().findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT CREATED!");
        return this;
    }
}
