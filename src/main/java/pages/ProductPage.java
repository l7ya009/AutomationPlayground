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
    By poloProduct = By.xpath("//div[@class=\"product-overlay\"]");
    By searchButton = By.id("submit_search");
    By firstProductHoverLink = By.xpath("(//a[@data-product-id=\"1\"])[1]");
    By secondProductHoverLink = By.xpath("(//a[@data-product-id=\"2\"])[1]");
    By addToCartFirstProduct = By.xpath("(//a[@data-product-id=\"1\"])[1]");
    By addToCartSecondProduct = By.xpath("(//a[@data-product-id=\"2\"])[1]");
    By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    By cartButton = By.xpath("//a[@href=\"/view_cart\"]");
    By firstProduct = By.xpath("(//div[@class=\"productinfo text-center\"])[1]");
    By productDetails = By.xpath("//div[@class=\"col-sm-9 padding-right\"]");
    By quantity = By.id("quantity");
    By addToCartButton = By.xpath("//button[@class=\"btn btn-default cart\"]");

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

    public ProductPage checkThatPoloProductDisplayed(){
        Assert.assertTrue(driver.get().findElement(poloProduct).isDisplayed());
        return this;
    }

    public ProductPage checkThatSelectedProductDetailsDisplayed(){
        Assert.assertTrue(driver.get().findElement(productDetails).isDisplayed());
        return this;
    }


    /******************************* Actions *******************************************/

    public ProductPage clickOnViewProductButton() {
        driver.element().click(viewProductButtom);
        return this;
    }

    public ProductPage enterProductNameInSearch(String product) {
        driver.element().fillField(searchProduct,product);
        return this;
    }

    public ProductPage clickOnSearchButton(){
        driver.element().click(searchButton);
        return this;
    }

    public ProductPage scrollToFirstProduct(){
        driver.element().scrollToElement(firstProduct);
        return this;
    }

    public ProductPage hooverOnFirstProduct(){
        driver.element().hoverOnItem(firstProductHoverLink);
        return this;
    }
    public ProductPage clickOnAddToCartFirstProduct() throws InterruptedException {
        driver.element().click(addToCartFirstProduct);
        Thread.sleep(5000);
        return this;
    }

    public ProductPage hooverOnSecondProduct(){
        driver.element().hoverOnItem(secondProductHoverLink);
        return this;
    }
    public ProductPage clickOnAddToCartSecondProduct() throws InterruptedException {
        driver.element().click(addToCartSecondProduct);
        Thread.sleep(5000);
        return this;
    }

//    public ProductPage hooverAndClickOnAddToCartFirstProduct() {
//        driver.element().hoverOnItem(firstProductHoverLink).click(addToCartFirstProduct);
//        return this;
//    }
//
//    public ProductPage hooverAndClickOnAddToCartSecondProduct() {
//        driver.element().hoverOnItem(secondProductHoverLink).click(addToCartSecondProduct);
//        return this;
//    }

//    public ProductPage hooverAndClickOnAddToCartFirstProduct(){
//        driver.element().click(addToCartFirstProduct);
//        return this;
//    }
//
//    public ProductPage hooverAndClickOnAddToCartSecondProduct(){
//        driver.element().click(addToCartSecondProduct);
//        return this;
//    }

    public ProductPage clickOnContinueButton() throws InterruptedException {
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    public ProductPage clickOnCartButton(){
        driver.element().click(cartButton);
        return this;
    }

    public ProductPage increaseQuantityToFour(int quantityNum){
        driver.element().fillField(quantity, String.valueOf(quantityNum));
        return this;
        }

        public ProductPage clickOnAddToCartButton() throws InterruptedException {
        driver.element().click(addToCartButton);
        Thread.sleep(5000);
        return this;
        }
    }


