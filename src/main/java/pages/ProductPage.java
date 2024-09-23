package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {
    Driver driver;

    By formTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By allProducts = By.xpath("//div[@class=\"features_items\"]");
    By searchProduct = By.id("search_product");
    By viewProductButtom = By.xpath("//a[@href=\"/product_details/1\"]");
//    By productInformation = By.xpath("//div[@class=\"product-information\"]");
    By productName = By.xpath("(//h2)[3]");
    By productCategory = By.xpath("(//p)[3]");
    By productPrice = By.xpath("(//span)[12]");
    By productAvailability = By.xpath("(//b)[2]");
    By productCondition = By.xpath("(//b)[3]");
    By productBrand = By.xpath("(//p/b)[3]");

    public ProductPage(Driver driver) {
        this.driver = driver;
    }

    /**************************** Assertions *******************************************/

    public ProductPage checkThatUserNavigatedToProductPageSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("products"));
        Assert.assertEquals(driver.element().getTextOf(formTitle), "ALL PRODUCTS");
        return this;
    }

    public ProductPage checkThatAllProductsDisplayed() {
        Assert.assertTrue(driver.get().findElement(allProducts).isDisplayed());
        return this;
    }

    public ProductPage checkThatSearchProductDisplayed() {
        Assert.assertTrue(driver.get().findElement(searchProduct).isDisplayed());
        return this;
    }

    public ProductPage checkThatProductDetailsDisplayed() {
//        Assert.assertTrue(driver.findElement(productInformation).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productName).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productCategory).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productPrice).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productAvailability).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productCondition).isDisplayed());
        Assert.assertTrue(driver.get().findElement(productBrand).isDisplayed());
        return this;
    }


    /******************************* Actions *******************************************/

    public ProductPage clickOnViewProductButton() {
        driver.element().click(viewProductButtom);
        return this;
    }

}
