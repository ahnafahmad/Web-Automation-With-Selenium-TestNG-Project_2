package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignupPage;
import page.SubscriptionPage;
import setup.Setup;
import utils.Utils;

public class SubscriptionTestRunner extends Setup {

    SignupPage signupPage;
    SubscriptionPage subscriptionPage;

    @Test(priority = 1, description = "Test Case 10: Verify Subscription in home page")
    public void verifySubscriptionInHomepageSuccessfully() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        signupPage = new SignupPage(driver);
        subscriptionPage = new SubscriptionPage(driver);


        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


        Utils.scrollThePage(driver);
        Thread.sleep(3000);


        //Subscription Field Assertion
        String actualSubscriptionField = subscriptionPage.subscriptionFieldAssertion.getText();
        String expectedSubscriptionField = "SUBSCRIPTION";
        Assert.assertTrue(actualSubscriptionField.equals(expectedSubscriptionField));


        subscriptionPage.doSubscription("admin@gmail.com");


        //Subscription Successful Assertion
        String actualSubscriptionSuccessMessage = subscriptionPage.subscriptionSuccessMessage.getText();
        String expectedSubscriptionSuccessMessage = "You have been successfully subscribed!";
        Assert.assertTrue(actualSubscriptionSuccessMessage.equals(expectedSubscriptionSuccessMessage));


    }

    @Test(priority = 2, description = "Test Case 11: Verify Subscription in Cart page")
    public void verifySubscriptionInCartpageSuccessfully() throws InterruptedException {

        subscriptionPage = new SubscriptionPage(driver);


        subscriptionPage.navCart.click();


        //Cart Page Assertion
        String actualCartPage = subscriptionPage.cartPageAssertion.getText();
        String expectedCartPage = "Shopping Cart";
        Assert.assertTrue(actualCartPage.equals(expectedCartPage));


        Utils.scrollThePage(driver);
        Thread.sleep(3000);


        //Subscription Field Assertion
        String actualSubscriptionField = subscriptionPage.subscriptionFieldAssertion.getText();
        String expectedSubscriptionField = "SUBSCRIPTION";
        Assert.assertTrue(actualSubscriptionField.equals(expectedSubscriptionField));


        subscriptionPage.doSubscription("admin@gmail.com");


        //Subscription Successful Assertion
        String actualSubscriptionSuccessMessage = subscriptionPage.subscriptionSuccessMessage.getText();
        String expectedSubscriptionSuccessMessage = "You have been successfully subscribed!";
        Assert.assertTrue(actualSubscriptionSuccessMessage.equals(expectedSubscriptionSuccessMessage));

    }
}
