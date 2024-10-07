package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage {

    Driver driver;

    By testCasesTitle = By.xpath("(//div[@class=\"row\"])[2]");

    public TestCasesPage(Driver driver) {
        this.driver = driver;
    }

    /**************************** Asserts ********************************/

    @Step("checkThatUserNavigatedToTestCasesPageSuccessfully")
    public TestCasesPage checkThatUserNavigatedToTestCasesPageSuccessfully() {
        Assert.assertTrue(driver.get().findElement(testCasesTitle).isDisplayed());
        return this;
    }

    /**************************** Actions *******************************/

}


