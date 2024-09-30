package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.ProductPage;

public class productPageTest {
    Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("http://automationexercise.com/");
    }


    @Test(priority = 1)
    public void productPageDisplayed() {


        new Homepage(driver).clickOnProductLink()
                        .checkThatUserNavigatedToProductPageSuccessfully()
                        .checkThatAllProductsDisplayed()
                        .checkThatSearchProductDisplayed();



    }

    @Test(dependsOnMethods ="productPageDisplayed" , priority = 2)
    public void productPageDetailsDisplayed() {
        new ProductPage(driver).clickOnViewProductButton()
                               .checkThatProductDetailsDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
