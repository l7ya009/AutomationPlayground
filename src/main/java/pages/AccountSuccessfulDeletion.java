package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountSuccessfulDeletion {
    public Driver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccessfulDeletion(Driver driver) {
        this.driver = driver;
    }

    /******************************** Assertions ******************************************/

    @Step("checkThatAccountShouldBeDeletedSuccessfully")
    public AccountSuccessfulDeletion checkThatAccountShouldBeDeletedSuccessfully() {

        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.get().findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT DELETED!");
        return this;
    }

    /**************************** Actions ************************************************/

    @Step("clickContinueButton")
    public Homepage clickContinueButton() {
        driver.element().click(continueButton);
        return new Homepage(driver);
}

}
