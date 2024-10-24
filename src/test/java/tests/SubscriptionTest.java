package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

import java.time.Duration;

public class SubscriptionTest {
    public Driver driver;

    @BeforeClass

    public void setUp() {
        driver = new Driver();
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.browser().navigateToUrl("http://automationexercise.com/");
        driver.browser().scrollToBottom();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test
    public void subscriptionDisplayed() {
//new Homepage(driver).driver.browser().scrollToBottom();
                new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                        .checkThatSubscriptionIsDisplayed()
                        .fillSubscriptionField("yehiaosamma00@gmail.com")
                .clickOnSubscriptionButton();
//                .checkThatSuccessfulSubscriptionMessageDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
