package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
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

    @Step("checkThatUserShouldBeNavigatedToRegistrationPage")
    public RegistrationPage checkThatUserShouldBeNavigatedToRegistrationPage() {
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(enterAccountInformationTitle), "ENTER ACCOUNT INFORMATION");
        return this;
    }

    /******************************** Actions ********************************************/

    @Step("selectTitle")
    public RegistrationPage selectTitle(){
        driver.element().click(title);
        return this;
    }

    @Step("fillPassword")
    public RegistrationPage fillPassword(String pass){
        driver.element().fillField(password, pass);
        return this;
    }

    @Step("fillDayOfBirth")
    public RegistrationPage fillDayOfBirth(){
        driver.element().selectByValue(dayOfBirth, "15");
        return this;
    }

    @Step("fillMonthOfBirth")
    public RegistrationPage fillMonthOfBirth(){
        driver.element().selectByValue(monthOfBirth, "4");
        return this;
    }

    @Step("fillYearOfBirth")
    public RegistrationPage fillYearOfBirth(){
        driver.element().selectByValue(yearOfBirth, "1992");
        return this;
    }

    @Step("fillFirstName")
    public RegistrationPage fillFirstName(String name){
        driver.element().fillField(firstName, name);
        return this;
    }

    @Step("fillLastName")
    public RegistrationPage fillLastName(String name){
        driver.element().fillField(lastName, name);
        return this;
    }

    @Step("fillCompany")
    public RegistrationPage fillCompany(String companyName){
        driver.element().fillField(company, companyName);
        return this;
    }

    @Step("fillAddress1")
    public RegistrationPage fillAddress1(String address){
        driver.element().fillField(address1, address);
        return this;
    }

    @Step("fillAddress2")
    public RegistrationPage fillAddress2(String address){
        driver.element().fillField(address2, address);
        return this;
    }

    @Step("fillCountry")
    public RegistrationPage fillCountry(){
        driver.element().selectByValue(country, "United States");
        return this;
    }

    @Step("fillState")
    public RegistrationPage fillState(String stateName){
        driver.element().fillField(state, stateName);
        return this;
    }

    @Step("fillCity")
    public RegistrationPage fillCity(String cityName){
        driver.element().fillField(city, cityName);
        return this;
    }

    @Step("fillZipCode")
    public RegistrationPage fillZipCode(String zipCodeNumber){
        driver.element().fillField(zipcode, zipCodeNumber);
        return this;
    }

    @Step("fillMobileNumber")
    public RegistrationPage fillMobileNumber(String mobileNum){
        driver.element().fillField(mobileNumber, mobileNum);
        return this;
    }

    @Step("clickCreateAccountButton")
    public RegistrationSuccessPage clickCreateAccountButton(){
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);
    }
}
