package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    public Driver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By productLink = By.xpath("//a[@href=\"/products\"]");
    By testCasesLink = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By subscription = By.xpath("(//div[@class=\"row\"])[4]");
//By subscription = By.id("footer");
//    By subscriptionField = By.id("susbscribe_email");
    By subscriptionField = By.xpath("//input[@type=\"email\"]");
    By subscriptionButton = By.xpath("//i[@class=\"fa fa-arrow-circle-o-right\"]");
    By successfullSubscriptionMessage = By.name("csrfmiddlewaretoken");
    By cart = By.xpath("//a[@href=\"/view_cart\"]");
    By viewProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By productDetails = By.xpath("//div[@class=\"col-sm-9 padding-right\"]");
    By addToCartFirstProduct = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    By productDetailsInCart = By.id("product-1");
    By signUpLink = By.xpath("//a[@href=\"/login\"]");
    By loggedInAsUserName = By.xpath("//i[@class=\"fa fa-user\"]");
    By leftSideBar = By.xpath("(//h2)[4]");
    By categories = By.xpath("//div[@class=\"panel-group category-products\"]");
    By womenCategory = By.xpath("(//a[@data-toggle=\"collapse\"])[1]");
    By menCategory = By.xpath("(//a[@data-toggle=\"collapse\"])[2]");
    By dressCategory = By.xpath("//a[@href=\"/category_products/1\"]");
    By womenCategoryTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By jeansCategory = By.xpath("//a[@href=\"/category_products/6\"]");
    By jeansCategoryTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By recommendedItems = By.xpath("//div[@class=\"recommended_items\"]");
    By recommendedItemsTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By productFromRecommendedProducts = By.xpath("(//a[@data-product-id=\"4\"])[3]");
    By fullFledgedTitle = By.xpath("(//h2)[1]");
    By AutomationExerciseTitle = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");

    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /******************************** Assertions ******************************************/

    @Step("checkThatLogOutLinkShouldBeDisplayed")
    public Homepage checkThatLogOutLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(logoutLink).isDisplayed());
        return this;
    }

    @Step("checkThatUserShouldBeNavigatedToHomePageSuccessfully")
    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully(){
        Assert.assertEquals(driver.browser().getCurrentUrl(),"https://automationexercise.com/");
        return this;
    }

    @Step("checkThatLoginLinkShouldBeDisplayed")
    public Homepage checkThatLoginLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/login"));
        return this;
    }

    @Step("checkThatDeleteAccountLinkShouldBeDisplayed")
    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(deleteAccountLink).isDisplayed());
        return this;
    }

    @Step("checkThatSubscriptionIsDisplayed")
    public Homepage checkThatSubscriptionIsDisplayed(){
        Assert.assertTrue(driver.get().findElement(subscription).isDisplayed());
        return this;
    }


    @Step("checkThatSuccessfulSubscriptionMessageDisplayed")
    public Homepage checkThatSuccessfulSubscriptionMessageDisplayed(){
        Assert.assertEquals(driver.element().getTextOf(successfullSubscriptionMessage),"You have been successfully subscribed!");
        return this;
    }

    @Step("checkThatProductDetailsDisplayed")
    public Homepage checkThatProductDetailsDisplayed(){
        Assert.assertTrue(driver.get().findElement(productDetails).isDisplayed());
        return this;
    }

    @Step("checkThatCartPageIsDisplayed")
    public Homepage checkThatCartPageIsDisplayed(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/view_cart"));
        Assert.assertTrue(driver.get().findElement(productDetailsInCart).isDisplayed());
        return this;
    }

    @Step("checkThatLoggedInAsUserNameAtTop")
    public Homepage checkThatLoggedInAsUserNameAtTop(){
        Assert.assertTrue(driver.get().findElement(loggedInAsUserName).isDisplayed());
        return this;
    }

    @Step("checkThatCategoriesAreVisibleOnLeftSideBar")
    public Homepage checkThatCategoriesAreVisibleOnLeftSideBar() throws InterruptedException {
        Assert.assertEquals(driver.element().getTextOf(leftSideBar),"CATEGORY");
        Assert.assertTrue(driver.get().findElement(categories).isDisplayed());
        Thread.sleep(5000);
        return this;
    }

    @Step("checkThatCategoryPageIsDisplayed")
    public Homepage checkThatCategoryPageIsDisplayed(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("category_products/1"));
        Assert.assertEquals(driver.element().getTextOf(womenCategoryTitle),"WOMEN -  DRESS PRODUCTS");
        return this;
    }

    @Step("checkThatUserNavigatedToJeansPage")
    public Homepage checkThatUserNavigatedToJeansPage(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("category_products/6"));
        Assert.assertEquals(driver.element().getTextOf(jeansCategoryTitle),"MEN - JEANS PRODUCTS");
        return this;
    }

@Step("checkThatRecommendedItemsAreDisplayed")
    public Homepage checkThatRecommendedItemsAreDisplayed(){
        Assert.assertTrue(driver.get().findElement(recommendedItems).isDisplayed());
        Assert.assertEquals(driver.element().getTextOf(AutomationExerciseTitle),"RECOMMENDED ITEMS");
        return this;
    }

    @Step("checkThatFullFledgedTitleIsDisplayed")
    public Homepage checkThatFullFledgedTitleIsDisplayed() throws InterruptedException {
        Assert.assertEquals(driver.element().getTextOf(fullFledgedTitle),"Full-Fledged practice website for Automation Engineers");
        Thread.sleep(5000);
        return this;
    }

    @Step("checkThatAutomationExerciseLogoIsDisplayed")
    public Homepage checkThatAutomationExerciseLogoIsDisplayed() throws InterruptedException {
        Assert.assertTrue(driver.get().findElement(AutomationExerciseTitle).isDisplayed());
        Thread.sleep(5000);
        return this;
    }



    /******************************** Actions ********************************************/

    @Step("clickOnLoginLink")
    public LoginSignupPage clickOnLoginLink(){
        driver.element().click(loginLink);
        return new LoginSignupPage(driver);
    }

    @Step("clickOnLogoutLink")
    public LoginSignupPage clickOnLogoutLink(){
        driver.get().findElement(logoutLink).click();
        return new LoginSignupPage(driver);
    }

    @Step("clickOnDeleteAccountLink")
    public AccountSuccessfulDeletion clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    @Step("clickOnContactUsLink")
    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    @Step("clickOnProductLink")
    public ProductPage clickOnProductLink(){
        driver.element().click(productLink);
        return new ProductPage(driver);
    }

    @Step("clickOnTestCasesLink")
    public TestCasesPage clickOnTestCasesLink(){
        driver.element().click(testCasesLink);
        return new TestCasesPage(driver);
    }

    @Step("fillSubscriptionField")
    public Homepage fillSubscriptionField(String email){
        driver.element().fillField(subscriptionField, email);
        return this;
    }

    @Step("clickOnSubscriptionButton")
    public Homepage clickOnSubscriptionButton(){
        driver.element().click(subscriptionButton);
        return this;
    }

    @Step("clickOnCart")
    public Homepage clickOnCart(){
        driver.element().click(cart);
        return this;
    }

    @Step("clickOnViewProduct")
    public Homepage clickOnViewProduct(){
        driver.element().click(viewProduct);
        return this;
    }

    @Step("clickOnAddToCartFirstProduct")
    public Homepage clickOnAddToCartFirstProduct() throws InterruptedException {
        driver.element().click(addToCartFirstProduct);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnContinueShoppingButton")
    public Homepage clickOnContinueShoppingButton() throws InterruptedException {
        driver.element().click(continueShoppingButton);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnSignUpLink")
    public Homepage clickOnSignUpLink(){
        driver.element().click(signUpLink);
        return this;
    }

    @Step("clickOnWomenCategory")
    public Homepage clickOnWomenCategory() throws InterruptedException {
        driver.element().click(womenCategory);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnDressCategory")
    public Homepage clickOnDressCategory() throws InterruptedException {
        driver.element().click(dressCategory);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnMenCategory")
    public Homepage clickOnMenCategory() throws InterruptedException {
        driver.element().click(menCategory);
        Thread.sleep(5000);
        return this;
    }

    @Step("clickOnJeansCategory")
    public Homepage clickOnJeansCategory() throws InterruptedException {
        driver.element().click(jeansCategory);
        Thread.sleep(5000);
        return this;
    }

    @Step("scrollToLiftSideBar")
    public Homepage scrollToLiftSideBar() throws InterruptedException {
        driver.element().scrollToElement(leftSideBar);
        Thread.sleep(5000);
        return this;
    }

    @Step("addProductFormRecommendedProducts")
    public Homepage addProductFormRecommendedProducts() throws InterruptedException {
        driver.element().click(productFromRecommendedProducts);
        Thread.sleep(5000);
        return this;
    }

    @Step("scrollDown")
    public Homepage scrollDown() throws InterruptedException {
        driver.browser().scrollToBottom();
        Thread.sleep(5000);
        return this;
    }

    @Step("scrollUp")
    public Homepage scrollUp() throws InterruptedException {
        driver.browser().scrollToUpper();
        Thread.sleep(5000);
        return this;
    }





}
