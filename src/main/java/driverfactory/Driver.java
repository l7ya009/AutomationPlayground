package driverfactory;

import browserActions.BrowserActions;
import elementactions.ElementActions;
import listeners.webDriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static Utilities.properties.PropertiesManager.WebConfig;

public class Driver {

    public ThreadLocal<WebDriver> driver;

    public Driver() {
        String driverType = WebConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
//        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
//                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver);
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver));
        System.out.println("Starting the execution via " + driverType + " driver");
        driver.get().manage().window().maximize();

        if (!WebConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(WebConfig.getProperty("BaseURL"));
        }
    }

    public Driver(String driverType) {
//        String driverType = WebConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
//        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
//                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver);
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver));
        System.out.println("Starting the execution via " + driverType + " driver");
        driver.get().manage().window().maximize();

        if (!WebConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(WebConfig.getProperty("BaseURL"));
        }
    }
    private DriverAbstract getDriver(String driver){

        switch (driver){
            case "CHROME": {
                return new ChromeDriverFactory();
        }
            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();
            }
            default: {
                throw new IllegalStateException("Unknown driver type: " + driver);
            }
        }
    }
    public WebDriver get(){ return driver.get(); }
    public void quit(){ driver.get().quit(); }

    public ElementActions element(){
        return new ElementActions(driver.get());
    }

    public BrowserActions browser(){
        return new BrowserActions(driver.get());
    }
}
