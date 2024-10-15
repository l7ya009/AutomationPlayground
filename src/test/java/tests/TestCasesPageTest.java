package tests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginSignupPage;
import pages.TestCasesPage;

public class TestCasesPageTest {
 public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("http://automationexercise.com/");
    }

    @Test
    public void TestCasesPage() {
        

        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                            .clickOnTestCasesLink()
                            .checkThatUserNavigatedToTestCasesPageSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
