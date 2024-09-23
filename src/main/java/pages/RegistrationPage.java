package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    public Driver driver;

    By enterAccountInformationTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By title = By.cssSelector("label.top");
    By password = By.id("password");
    By dayOfBirth = By.id("days");
    By monthOfBirth = By.id("months");
    By yearOfBirth = By.id("years");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    /******************************** Assertions ******************************************/

    public RegistrationPage checkThatUserShouldBeNavigatedToRegistrationPage() {
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(enterAccountInformationTitle), "ENTER ACCOUNT INFORMATION");
        return this;
    }

    /******************************** Actions ********************************************/

    public RegistrationPage selectTitle(){
        driver.element().click(title);
        return this;
    }
    public RegistrationPage fillPassword(String pass){
        driver.element().fillField(password, pass);
        return this;
    }
    public RegistrationPage fillDayOfBirth(){
        driver.element().selectByValue(dayOfBirth, "15");
        return this;
    }
    public RegistrationPage fillMonthOfBirth(){
        driver.element().selectByValue(monthOfBirth, "4");
        return this;
    }
    public RegistrationPage fillYearOfBirth(){
        driver.element().selectByValue(yearOfBirth, "1992");
        return this;
    }
    public RegistrationPage fillFirstName(String name){
        driver.element().fillField(firstName, name);
        return this;
    }
    public RegistrationPage fillLastName(String name){
        driver.element().fillField(lastName, name);
        return this;
    }
    public RegistrationPage fillCompany(String companyName){
        driver.element().fillField(company, companyName);
        return this;
    }
    public RegistrationPage fillAddress1(String address){
        driver.element().fillField(address1, address);
        return this;
    }
    public RegistrationPage fillAddress2(String address){
        driver.element().fillField(address2, address);
        return this;
    }
    public RegistrationPage fillCountry(){
        driver.element().selectByValue(country, "United States");
        return this;
    }
    public RegistrationPage fillState(String stateName){
        driver.element().fillField(state, stateName);
        return this;
    }
    public RegistrationPage fillCity(String cityName){
        driver.element().fillField(city, cityName);
        return this;
    }
    public RegistrationPage fillZipCode(String zipCodeNumber){
        driver.element().fillField(zipcode, zipCodeNumber);
        return this;
    }
    public RegistrationPage fillMobileNumber(String mobileNum){
        driver.element().fillField(mobileNumber, mobileNum);
        return this;
    }
    public RegistrationSuccessPage clickCreateAccountButton(){
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);
    }
}
