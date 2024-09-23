package listener.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverListeners implements WebDriverListener {

    private WebDriver driver;
    public WebDriverListeners(WebDriver driver) {
        this.driver = driver;
    }

    /***************** Browser Action Listeners *********************/

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Getting to \"" + url + "\".");
    }

    @Override
    public void afterGetCurrentUrl(WebDriver driver, String result){
        System.out.println("Current Page URL is: \"" + result + "\".");
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Navigating to URL \"" + url + "\".");
    }
}
