package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.ProductPage;

public class productPageTest {
  public Driver driver;

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

    @Test(dependsOnMethods = "productPageDisplayed" , priority = 3)
    public void poloProductDesplayed() {
        new Homepage(driver).clickOnProductLink();
        new ProductPage(driver).enterProductNameInSearch("polo").
                clickOnSearchButton()
                .checkThatPoloProductDisplayed();
    }

    @Test(dependsOnMethods = "poloProductDesplayed", priority = 4)
    public void checkThatUserCanNavigatedToOtherBrandPage(){
        driver.browser().navigateToUrl("http://automationexercise.com/");
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnProductLink()
                .checkThatUserNavigatedToProductPageSuccessfully();
        new ProductPage(driver).checkThatBrandsAreVisibleOnLeftSideBar()
                .clickOnPoloCategory()
                .checkThatUserNavigatedToPolo()
                .clickOnHmCategory()
                .checkThatUserNavigatedToHm();
    }




    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
