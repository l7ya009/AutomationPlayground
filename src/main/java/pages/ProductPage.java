package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
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
    By brandCategory = By.xpath("//div[@class=\"brands_products\"]");
    By poloCategory = By.xpath("//a[@href=\"/brand_products/Polo\"]");
    By poloTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By hmCategory = By.xpath("//a[@href=\"/brand_products/H&M\"]");
    By hmTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By resultsOfSearchedFirstJeansProducts = By.xpath("(//p)[3]");
    By resultsOfSearchedSecondJeansProducts = By.xpath("(//p)[5]");
    By resultsOfSearchedThirdJeansProducts = By.xpath("(//p)[7]");
    By addToCartFirstJeansProduct = By.xpath("(//a[@data-product-id=\"33\"])[1]");
    By addToCartSecondJeansProduct= By.xpath("(//a[@data-product-id=\"35\"])[1]");
    By addToCartThirdJeansProduct =By.xpath("(//a[@data-product-id=\"37\"])[1]");
    By cartButtonInJeansPage = By.xpath("//i[@class=\"fa fa-shopping-cart\"]");
    By reviewForm = By.id("review-form");
    By reviewFormName = By.id("name");
    By reviewFormEmail = By.id("email");
    By reviewContent = By.id("review");
    By submitReviewButton = By.id("button-review");
    By reviewSuccessMessage = By.xpath("(//div[@class=\"alert-success alert\"])[1]");

    public ProductPage(Driver driver) {
        this.driver = driver;
    }

    /**************************** Assertions *******************************************/

    @Step("checkThatUserNavigatedToProductPageSuccessfully")
    public ProductPage checkThatUserNavigatedToProductPageSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("products"));
        Assert.assertEquals(driver.element().getTextOf(formTitle), "ALL PRODUCTS");
        return this;
    }

    @Step("checkThatAllProductsDisplayed")
    public ProductPage checkThatAllProductsDisplayed() {
        Assert.assertTrue(driver.get().findElement(allProducts).isDisplayed());
        return this;
    }

    @Step("checkThatSearchProductDisplayed")
    public ProductPage checkThatSearchProductDisplayed() {
        Assert.assertTrue(driver.get().findElement(searchProduct).isDisplayed());
        return this;
    }

    @Step("checkThatProductDetailsDisplayed")
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

    @Step("checkThatPoloProductDisplayed")
    public ProductPage checkThatPoloProductDisplayed(){
        Assert.assertTrue(driver.get().findElement(poloProduct).isDisplayed());
        return this;
    }

    @Step("checkThatSelectedProductDetailsDisplayed")
    public ProductPage checkThatSelectedProductDetailsDisplayed(){
        Assert.assertTrue(driver.get().findElement(productDetails).isDisplayed());
        return this;
    }

    @Step("checkThatBrandsAreVisibleOnLeftSideBar")
    public ProductPage checkThatBrandsAreVisibleOnLeftSideBar(){
        Assert.assertTrue(driver.get().findElement(brandCategory).isDisplayed());
        return this;
    }

    @Step("checkThatUserNavigatedToPolo")
    public ProductPage checkThatUserNavigatedToPolo(){
        Assert.assertEquals(driver.element().getTextOf(poloTitle),"BRAND -  POLO PRODUCTS");
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("brand_products/Polo"));
        return this;
    }

    @Step("checkThatUserNavigatedToHm")
    public ProductPage checkThatUserNavigatedToHm(){
        Assert.assertEquals(driver.element().getTextOf(hmTitle),"BRAND - H&M PRODUCTS");
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("brand_products/H&M"));
        return this;
    }

    @Step("checkThatResultsOfSearchAreVisibleForJeans")
    public ProductPage checkThatResultsOfSearchAreVisibleForJeans(){
        Assert.assertEquals(driver.element().getTextOf(resultsOfSearchedFirstJeansProducts), "Soft Stretch Jeans");
        Assert.assertEquals(driver.element().getTextOf(resultsOfSearchedSecondJeansProducts)," Regular Fit Straight JeansRegular Fit Straight Jeans");
        Assert.assertEquals(driver.element().getTextOf(resultsOfSearchedThirdJeansProducts),"Grunt Blue Slim Fit Jeans");
    return this;
    }

    @Step("checkThatReviewFormisDisplayed")
    public ProductPage checkThatReviewFormisDisplayed(){
        Assert.assertTrue(driver.get().findElement(reviewForm).isDisplayed());
        return this;
    }

    @Step("checkThatReviewSubmittedSuccessMessageDisplayed")
    public ProductPage checkThatReviewSubmittedSuccessMessageDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(reviewSuccessMessage),"Thank you for your review.");
        return this;
    }

    /******************************* Actions *******************************************/

    @Step("clickOnViewProductButton")
    public ProductPage clickOnViewProductButton() {
        driver.element().click(viewProductButtom);
        return this;
    }

    @Step("enterProductNameInSearch")
    public ProductPage enterProductNameInSearch(String product) {
        driver.element().fillField(searchProduct,product);
        return this;
    }

    @Step("clickOnSearchButton")
    public ProductPage clickOnSearchButton(){
        driver.element().click(searchButton);
        return this;
    }

    @Step("scrollToFirstProduct")
    public ProductPage scrollToFirstProduct(){
        driver.element().scrollToElement(firstProduct);
        return this;
    }

    @Step("hooverOnFirstProduct")
    public ProductPage hooverOnFirstProduct(){
        driver.element().hoverOnItem(firstProductHoverLink);
        return this;
    }

    @Step("clickOnAddToCartFirstProduct")
    public ProductPage clickOnAddToCartFirstProduct() throws InterruptedException {
        driver.element().click(addToCartFirstProduct);
        Thread.sleep(5000);
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    @Step("hooverOnSecondProduct")
    public ProductPage hooverOnSecondProduct(){
        driver.element().hoverOnItem(secondProductHoverLink);
        return this;
    }

    @Step("clickOnAddToCartSecondProduct")
    public ProductPage clickOnAddToCartSecondProduct() throws InterruptedException {
        driver.element().click(addToCartSecondProduct);
        Thread.sleep(5000);
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnPoloCategory")
    public ProductPage clickOnPoloCategory(){
        driver.element().click(poloCategory);
        return this;
    }

    @Step("clickOnHmCategory")
    public ProductPage clickOnHmCategory(){
        driver.element().click(hmCategory);
        return this;
    }

    @Step("addResultsOfSearchJeansProductsToCart")
    public ProductPage addResultsOfSearchJeansProductsToCart() throws InterruptedException {
        driver.element().click(addToCartFirstJeansProduct);
        Thread.sleep(5000);
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        driver.element().click(addToCartSecondJeansProduct);
        Thread.sleep(5000);
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        driver.element().click(addToCartThirdJeansProduct);
        Thread.sleep(5000);
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnCartButtonInJeansPage")
    public ProductPage clickOnCartButtonInJeansPage(){
        driver.element().click(cartButtonInJeansPage);
        return this;
    }

    @Step("fillReviewFormName")
    public ProductPage fillReviewFormName(String name){
        driver.element().fillField(reviewFormName, name);
        return this;
    }

    @Step("fillReviewFormEmail")
    public ProductPage fillReviewFormEmail(String email){
        driver.element().fillField(reviewFormEmail, email);
        return this;
    }

    @Step("fillReviewFormContent")
    public ProductPage fillReviewFormContent(String review){
        driver.element().fillField(reviewContent, review);
        return this;
    }

    @Step("clickOnSubmitReviewButton")
    public ProductPage clickOnSubmitReviewButton(){
        driver.element().click(submitReviewButton);
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

    @Step("clickOnContinueButton")
    public ProductPage clickOnContinueButton() throws InterruptedException {
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnCartButton")
    public ProductPage clickOnCartButton(){
        driver.element().click(cartButton);
        return this;
    }

    @Step("increaseQuantityToFour")
    public ProductPage increaseQuantityToFour(int quantityNum){
        driver.element().fillField(quantity, String.valueOf(quantityNum));
        return this;
        }

        @Step("clickOnAddToCartButton")
        public ProductPage clickOnAddToCartButton() throws InterruptedException {
        driver.element().click(addToCartButton);
        Thread.sleep(5000);
        return this;
        }
    }


