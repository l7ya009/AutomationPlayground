package tests;

import Utilities.ScreenShotManager;
import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ContactUsPage;
import pages.Homepage;

import java.time.Duration;

public class ContactUsTest {

//   public ThreadLocal<Driver> driver;

    public Driver driver;
//    ThreadLocal<Driver> parallelDriver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME")String browserName) {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//        driver.set(new Driver(browserName));

        driver.get().manage().window().maximize();
        driver.browser().navigateToUrl("http://automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test
//    public void contactUsTest() throws InterruptedException {
//        driver.get().element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
//                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
//        Thread.sleep(5000);
    public void contactUsTest(){


        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnContactUsLink()
                        .checkThatContactUsPageIsLoadedSuccessfully()
                        .fillInContactUsForm("Yehia", "yehiaos@yahoo.com", "Test", "Welcome")
                        .clickOnSubmitButton()
                        .checkThatFormShouldBeSubmittedSuccessfully()
                        .clickOnHomeButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully();

    }

//    @AfterMethod
//    public void screenShotOnFailure(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test Failed");
//            System.out.println("Taking Screen Shot....");
//            ScreenShotManager.captureScreenShot(driver.get(), result.getName());
//        }
//    }

    @AfterClass
    public void teardown() {
        driver.get().manage().deleteAllCookies();
        driver.get().quit();

    }


}
