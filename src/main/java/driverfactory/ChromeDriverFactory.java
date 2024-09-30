package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Utilities.properties.PropertiesManager.WebConfig;

public class ChromeDriverFactory extends DriverAbstract {

    @Override
    public WebDriver startDriver() {
        ChromeOptions options = new ChromeOptions();
        if (WebConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
            System.out.println("start with headless mode");
        }
            driver = new ChromeDriver(options);
            return driver;
        }
    }

