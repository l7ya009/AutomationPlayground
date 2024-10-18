package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentPage {
    public Driver driver;

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expirationMonth = By.name("expiry_month");
    By expirationYear = By.name("expiry_year");
    By payAndConfirmButton = By.id("submit");
    By orderPlacedMessage = By.xpath("(//b)[2]");
    By orderConfirmedMessage = By.xpath("//p[1]");
    By deleteAccount = By.xpath("//a[@href=\"/delete_account\"]");
    By accountDeletedMessage = By.xpath("(//b)[1]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    By downloadInVoiceButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");



    public PaymentPage(Driver driver) {
        this.driver = driver;
    }

        /*************************************** Assertions *********************************/

       @Step("checkThatUserNavigatedToPaymentPage")
        public PaymentPage checkThatUserNavigatedToPaymentPage(){
            Assert.assertTrue(driver.browser().getCurrentUrl().contains("/payment"));
            return this;
        }
        @Step("checkThatOrderPlacedAndConfirmedSuccessfully")
        public PaymentPage checkThatOrderPlacedAndConfirmedSuccessfully(){
            Assert.assertTrue(driver.browser().getCurrentUrl().contains("/payment_done"));
            Assert.assertEquals(driver.element().getTextOf(orderPlacedMessage),"ORDER PLACED!");
            Assert.assertEquals(driver.element().getTextOf(orderConfirmedMessage),"Congratulations! Your order has been confirmed!");
            return this;
        }

        @Step("checkThatAccountDeletedSuccessfully")
        public PaymentPage checkThatAccountDeletedSuccessfully(){
            Assert.assertTrue(driver.browser().getCurrentUrl().contains("/delete_account"));
            Assert.assertEquals(driver.element().getTextOf(accountDeletedMessage),"ACCOUNT DELETED!");
            return this;
        }


        /*************************************** Actions ************************************/

        @Step("fillNameOnCard")
        public PaymentPage fillNameOnCard(String name){
            driver.element().fillField(nameOnCard,name);
            return this;
        }

        @Step("fillCardNumber")
        public PaymentPage fillCardNumber(String cardNum){
            driver.element().fillField(cardNumber,cardNum);
            return this;
        }

        @Step("fillCvc")
        public PaymentPage fillCvc(String CVC){
            driver.element().fillField(cvc,CVC);
            return this;
        }

        @Step("fillExpirationMonth")
        public PaymentPage fillExpirationMonth(String month){
            driver.element().fillField(expirationMonth,month);
            return this;
            }

            @Step("fillExpirationYear")
            public PaymentPage fillExpirationYear(String year){
            driver.element().fillField(expirationYear,year);
            return this;
        }

        @Step("clickOnPayAndConfirmButton")
        public PaymentPage clickOnPayAndConfirmButton() throws InterruptedException {
            driver.element().click(payAndConfirmButton);
            Thread.sleep(5000);
            return this;
        }

        @Step("clickOnDeleteAccount")
        public PaymentPage clickOnDeleteAccount(){
            driver.element().click(deleteAccount);
            return this;
        }

        @Step("clickOnContinueButton")
        public PaymentPage clickOnContinueButton(){
            driver.element().click(continueButton);
            return this;
        }

        @Step("clickOnDownloadInvoiceButton")
        public PaymentPage clickOnDownloadInvoiceButton(){
            driver.element().click(downloadInVoiceButton);
            return this;
        }


}
