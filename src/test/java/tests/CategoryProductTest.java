package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

public class CategoryProductTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("https://automationexercise.com");
    }

    @Test
        public void checkThatUserCanViewCategoryProduct() throws InterruptedException {
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .scrollToLiftSideBar()
                .checkThatCategoriesAreVisibleOnLeftSideBar()
                .clickOnWomenCategory()
                .clickOnDressCategory()
                .checkThatCategoryPageIsDisplayed()
                .clickOnMenCategory()
                .clickOnJeansCategory()
                .checkThatUserNavigatedToJeansPage();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
