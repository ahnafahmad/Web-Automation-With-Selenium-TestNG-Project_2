package testRunner;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;


public class ProductTestRunner extends Setup {


    SignupPage signupPage;
    LoginPage loginPage;
    CreateAccountPage createAccountPage;
    ProductPage productPage;
    SubscriptionPage subscriptionPage;
    VerifyDifferentUIPage verifyDifferentUIPage;


    @Test(priority = 1, description = "Test Case 2: Login User with correct email and password")
    public void loginSuccessfulWithValidCredentials() throws IOException, ParseException, InterruptedException {

        driver.get("https://www.automationexercise.com");

        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);


        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


        signupPage.navLogin.click();

        String file = "./src/test/resources/user.json";

        List users = Utils.readJsonData(file);

        JSONObject userObject = (JSONObject) users.get(users.size() - 1);

        String userEmail = (String) userObject.get("userEmail");
        String userPassword = (String) userObject.get("userPassword");
        Thread.sleep(1000);


        loginPage.doLogin(userEmail, userPassword);
        Thread.sleep(1000);

        // After Account Creation Home Page Assertion
        String actualAccountCreatedHomePage = createAccountPage.afterAccountCreationHomePageAssertion.getText();
        String expectedAccountCreatedHomePage = "Logged in as";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));

    }


    @Test(priority = 2, description = "Test Case 9: Search Product")
    public void searchProductsSuccessfully() {

        signupPage = new SignupPage(driver);

        productPage = new ProductPage(driver);


        productPage.navProduct.click();


        //Product Page Assertion
        String actualProductPage = productPage.productPageAssertion.getText();
        String expectedProductPage = "ALL PRODUCTS";
        Assert.assertTrue(actualProductPage.equals(expectedProductPage));


        productPage.searchProduct.sendKeys("Saree");

        productPage.btnSearch.click();


        //Search Page Assertion
        String actualSearchPage = productPage.searchProductPageAssertion.getText();
        String expectedSearchPage = "SEARCHED PRODUCTS";
        Assert.assertTrue(actualSearchPage.equals(expectedSearchPage));


        //Verify The Specific Searched Products are Visible
        String actualSearchProduct = productPage.verifySearchedProductVisible.get(0).getText();
        String expectedSearchProduct = "Cotton Silk Hand Block Print Saree";
        Assert.assertTrue(actualSearchProduct.equals(expectedSearchProduct));


    }

    @Test(priority = 3, description = "Test Case 12: Add Products in Cart")
    public void addSingleQuantityProductsInCart() throws InterruptedException {

        productPage = new ProductPage(driver);

        subscriptionPage = new SubscriptionPage(driver);


        //Add 1st Product to the Cart

        productPage.addToCart.get(0).click();
        Thread.sleep(2000);


        // Product Add To Cart Successfully
        String actualAddToCartProduct1 = productPage.successfullyAddToCartAssertion.getText();
        String expectedAddToCartProduct1 = "Your product has been added to cart.";
        Assert.assertTrue(actualAddToCartProduct1.equals(expectedAddToCartProduct1));

        productPage.btnContinueShopping.click();
        Thread.sleep(2000);


        //Add 2nd Product to the Cart

        productPage.addToCart.get(4).click();
        Thread.sleep(2000);


        // Product Add To Cart Successfully
        String actualAddToCartProduct2 = productPage.successfullyAddToCartAssertion.getText();
        String expectedAddToCartProduct2 = "Your product has been added to cart.";
        Assert.assertTrue(actualAddToCartProduct2.equals(expectedAddToCartProduct2));

        productPage.btnViewCart.click();
        Thread.sleep(2000);


        //Cart Page Assertion
        String actualCartPage = subscriptionPage.cartPageAssertion.getText();
        String expectedCartPage = "Shopping Cart";
        Assert.assertTrue(actualCartPage.equals(expectedCartPage));


        //1st Product Added Successfully Assertion

        //1st Product Description Assertion
        String actualProductDescription1 = productPage.verifyProductDescription1.getText();
        String expectedProductDescription1 = "Cotton Silk Hand Block Print Saree";
        Assert.assertTrue(actualProductDescription1.equals(expectedProductDescription1));

        //1st Product Price Assertion
        String actualProductPrice1 = productPage.verifyProductPrice.get(0).getText();
        String expectedProductPrice1 = "Rs. 3000";
        Assert.assertTrue(actualProductPrice1.equals(expectedProductPrice1));

        //1st Product Quantity Assertion
        String actualProductQuantity1 = productPage.verifyProductQuantity.get(0).getText();
        String expectedProductQuantity1 = "1";
        Assert.assertTrue(actualProductQuantity1.equals(expectedProductQuantity1));

        //1st Product total Price Assertion
        String actualProductTotalPrice1 = productPage.verifyProductTotalPriceInProductDetailsPage.get(0).getText();
        String expectedProductTotalPrice1 = "Rs. 3000";
        Assert.assertTrue(actualProductTotalPrice1.equals(expectedProductTotalPrice1));


        //2nd Product Added Successfully Assertion

        //2nd Product Description Assertion
        String actualProductDescription2 = productPage.verifyProductDescription2.getText();
        String expectedProductDescription2 = "Beautiful Peacock Blue Cotton Linen Saree";
        Assert.assertTrue(actualProductDescription2.equals(expectedProductDescription2));

        //2nd Product Price Assertion
        String actualProductPrice2 = productPage.verifyProductPrice.get(1).getText();
        String expectedProductPrice2 = "Rs. 5000";
        Assert.assertTrue(actualProductPrice2.equals(expectedProductPrice2));

        //2nd Product Quantity Assertion
        String actualProductQuantity2 = productPage.verifyProductQuantity.get(1).getText();
        String expectedProductQuantity2 = "1";
        Assert.assertTrue(actualProductQuantity2.equals(expectedProductQuantity2));

        //2nd Product total Price Assertion
        String actualProductTotalPrice2 = productPage.verifyProductTotalPriceInProductDetailsPage.get(1).getText();
        String expectedProductTotalPrice2 = "Rs. 5000";
        Assert.assertTrue(actualProductTotalPrice2.equals(expectedProductTotalPrice2));


        for (int i = 0; i < 2; i++) {
            productPage.deleteProducts.get(0).click();
            Thread.sleep(2000);
        }

        productPage.buyProductWhenCartIsEmpty.click();
        Thread.sleep(3000);

    }

    @Test(priority = 4, description = "Test Case 18: View Category Products and Test Case 19: View & Cart Brand Products")
    public void viewCategoryProducts() throws InterruptedException {

        productPage = new ProductPage(driver);


        Utils.waitForElement(driver, productPage.productPageAssertion, 50);
        if (productPage.productPageAssertion.isDisplayed()) {

            productPage.brand1.click();
            Thread.sleep(1000);

        }


        //Polo Brand Assertion in
        String actualPoloBrandAssertion = productPage.categoryAssertion.getText();
        String expectedPoloBrandAssertion = "BRAND - POLO PRODUCTS";
        Assert.assertTrue(actualPoloBrandAssertion.equals(expectedPoloBrandAssertion));


        productPage.brand2.click();


        //KOOKIE KIDS Brand Assertion in
        String actualKookieKidsBrandAssertion = productPage.categoryAssertion.getText();
        String expectedKookieKidsBrandAssertion = "BRAND - KOOKIE KIDS PRODUCTS";
        Assert.assertTrue(actualKookieKidsBrandAssertion.equals(expectedKookieKidsBrandAssertion));


        productPage.category1.click();
        Thread.sleep(1000);
        productPage.subCategory1.get(0).click();

        //Woman Category Dress Sub-Category Assertion in
        String actualDressAssertion = productPage.categoryAssertion.getText();
        String expectedDressAssertion = "WOMEN - DRESS PRODUCTS";
        Assert.assertTrue(actualDressAssertion.equals(expectedDressAssertion));


        productPage.category2.click();
        Thread.sleep(1000);
        productPage.subCategory2.click();


        //Man Category Jeans Sub-Category Assertion in
        String actualJeansAssertion = productPage.categoryAssertion.getText();
        String expectedJeansAssertion = "MEN - JEANS PRODUCTS";
        Assert.assertTrue(actualJeansAssertion.equals(expectedJeansAssertion));

    }


    @Test(priority = 5, description = "Test Case 13: Verify Product quantity in Cart & Test Case 21: Add review on product")
    public void addMultipleQuantityProductsInCart() throws InterruptedException {

        productPage = new ProductPage(driver);
        subscriptionPage = new SubscriptionPage(driver);
        verifyDifferentUIPage = new VerifyDifferentUIPage(driver);


        //Add Multiple Quantity Product to the Cart

        productPage.btnViewProduct.get(1).click();
        Thread.sleep(1000);


        //Product Name Visibility Assertion
        String actualProductName = verifyDifferentUIPage.productName.getText();
        String expectedProductName = "Regular Fit Straight Jeans";
        Assert.assertTrue(actualProductName.equals(expectedProductName));


        //Product Category Visibility Assertion
        String actualProductCategory = verifyDifferentUIPage.productCategory.getText();
        String expectedProductCategory = "Category: Men > Jeans";
        Assert.assertTrue(actualProductCategory.equals(expectedProductCategory));


        //Product Price Visibility Assertion
        String actualProductPriceInView = verifyDifferentUIPage.productPrice.getText();
        String expectedProductPriceInView = "Rs. 1200";
        Assert.assertTrue(actualProductPriceInView.equals(expectedProductPriceInView));


        //Product Availability Visibility Assertion
        String actualProductAvailability = verifyDifferentUIPage.productAvailability.getText();
        String expectedProductAvailability = "Availability:";
        Assert.assertTrue(actualProductAvailability.equals(expectedProductAvailability));


        //Product Condition Visibility Assertion
        String actualProductCondition = verifyDifferentUIPage.productCondition.getText();
        String expectedProductCondition = "Condition:";
        Assert.assertTrue(actualProductCondition.equals(expectedProductCondition));


        //Product Brand Visibility Assertion
        String actualProductBrand = verifyDifferentUIPage.productBrand.getText();
        String expectedProductBrand = "Brand:";
        Assert.assertTrue(actualProductBrand.equals(expectedProductBrand));


        productPage.productQuantity.clear();
        productPage.productQuantity.sendKeys("4");


        //Add a Review on Product

        //Review Element Assertion
        String actualReviewPage = productPage.verifyReviewPage.getText();
        String expectedReviewPage = "WRITE YOUR REVIEW";
        Assert.assertTrue(actualReviewPage.equals(expectedReviewPage));


        String name = "Admin";
        String email = "admin4@gmail.com";
        String review = "That's look like a Beautiful Product. I like it so much";


        productPage.givingReview(name, email, review);


        //Review Submitted Successfully Assertion
        String actualSuccessfulReviewAssertion = productPage.reviewSubmittedSuccessfully.getText();
        String expectedSuccessfulReviewAssertion = "Thank you for your review.";
        Assert.assertTrue(actualSuccessfulReviewAssertion.equals(expectedSuccessfulReviewAssertion));
        Thread.sleep(3000);


        productPage.btnAddToCart.click();
        Thread.sleep(2000);


        // Product Add To Cart Successfully
        String actualAddToCartProduct = productPage.successfullyAddToCartAssertion.getText();
        String expectedAddToCartProduct = "Your product has been added to cart.";
        Assert.assertTrue(actualAddToCartProduct.equals(expectedAddToCartProduct));


        productPage.btnViewCart.click();
        Thread.sleep(1000);


        //Cart Page Assertion
        String actualCartPage = subscriptionPage.cartPageAssertion.getText();
        String expectedCartPage = "Shopping Cart";
        Assert.assertTrue(actualCartPage.equals(expectedCartPage));


        //Product Added Successfully Assertion

        //Product Description Assertion
        String actualProductDescription = productPage.verifySingleProductDescription.getText();
        String expectedProductDescription = "Regular Fit Straight Jeans";
        Assert.assertTrue(actualProductDescription.equals(expectedProductDescription));

        //1st Product Price Assertion
        String actualProductPrice = productPage.verifyProductPrice.get(0).getText();
        String expectedProductPrice = "Rs. 1200";
        Assert.assertTrue(actualProductPrice.equals(expectedProductPrice));

        //1st Product Quantity Assertion
        String actualProductQuantity = productPage.verifyProductQuantity.get(0).getText();
        String expectedProductQuantity = "4";
        Assert.assertTrue(actualProductQuantity.equals(expectedProductQuantity));

        //1st Product total Price Assertion
        String actualProductTotalPrice = productPage.verifyProductTotalPriceInProductDetailsPage.get(0).getText();
        String expectedProductTotalPrice = "Rs. 4800";
        Assert.assertTrue(actualProductTotalPrice.equals(expectedProductTotalPrice));


    }

    @Test(priority = 6, description = "Test Case 16: Place Order: Register while Checkout , Test Case 23: Verify address details in checkout page , Test Case 24: Download Invoice after purchase order & Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void placeOrderSuccessfully() throws InterruptedException, IOException, ParseException {

        productPage = new ProductPage(driver);


        String file = "./src/test/resources/user.json";

        List users = Utils.readJsonData(file);

        JSONObject userObject = (JSONObject) users.get(users.size() - 1);

        String userFirstName = (String) userObject.get("userFirstName");
        String userCompany = (String) userObject.get("userCompany");
        String userAddress1 = (String) userObject.get("userAddress1");
        String userAddress2 = (String) userObject.get("userAddress2");
        String userCity = (String) userObject.get("userCity");
        String userMobile = (String) userObject.get("userMobile");
        Thread.sleep(1000);


        productPage.proceedToCheckout.click();


        Utils.scrollThePage(driver);


        //Review Your Order
        String actualReviewYourOrder = productPage.headerTitle.get(1).getText();
        String expectedReviewYourOrder = "Review Your Order";
        Assert.assertTrue(actualReviewYourOrder.equals(expectedReviewYourOrder));

        //Total Price Assertion
        String actualTotalPrice = productPage.verifyProductTotalPriceInCheckoutPage.get(1).getText();
        String expectedTotalPrice = "Rs. 4800";
        Assert.assertTrue(actualTotalPrice.equals(expectedTotalPrice));


        productPage.scrollUpButton.click();


        //Checkout Page Assertion

        // Address Details
        String actualAddressDetails = productPage.headerTitle.get(0).getText();
        String expectedAddressDetails = "Address Details";
        Assert.assertTrue(actualAddressDetails.equals(expectedAddressDetails));


        // DELIVERY ADDRESS Assertion
        String actualDeliveryAddress = productPage.headerSubTitle.get(0).getText();
        String expectedDeliveryAddress = "YOUR DELIVERY ADDRESS";
        Assert.assertTrue(actualDeliveryAddress.equals(expectedDeliveryAddress));

        String actualDeliveryAddressFirstName = productPage.addressFirstName.get(0).getText();
        String expectedDeliveryAddressFirstName = userFirstName;
        Assert.assertTrue(actualDeliveryAddressFirstName.contains(expectedDeliveryAddressFirstName));

        String actualDeliveryAddressCompany = productPage.address1.get(0).getText();
        String expectedDeliveryAddressCompany = userCompany;
        Assert.assertTrue(actualDeliveryAddressCompany.contains(expectedDeliveryAddressCompany));

        String actualDeliveryAddress1 = productPage.address1.get(1).getText();
        String expectedDeliveryAddress1 = userAddress1;
        Assert.assertTrue(actualDeliveryAddress1.contains(expectedDeliveryAddress1));

        String actualDeliveryAddress2 = productPage.address1.get(2).getText();
        String expectedDeliveryAddress2 = userAddress2;
        Assert.assertTrue(actualDeliveryAddress2.contains(expectedDeliveryAddress2));

        String actualDeliveryAddressCity = productPage.addressCity.get(0).getText();
        String expectedDeliveryAddressCity = userCity;
        Assert.assertTrue(actualDeliveryAddressCity.contains(expectedDeliveryAddressCity));

        String actualDeliveryAddressMobileNumber = productPage.addressPhone.get(0).getText();
        String expectedDeliveryAddressMobileNumber = userMobile;
        Assert.assertTrue(actualDeliveryAddressMobileNumber.contains(expectedDeliveryAddressMobileNumber));


        // BILLING ADDRESS Assertion
        String actualBillingAddress = productPage.headerSubTitle.get(1).getText();
        String expectedBillingAddress = "YOUR BILLING ADDRESS";
        Assert.assertTrue(actualBillingAddress.equals(expectedBillingAddress));

        String actualBillingAddressFirstName = productPage.addressFirstName.get(1).getText();
        String expectedBillingAddressFirstName = userFirstName;
        Assert.assertTrue(actualBillingAddressFirstName.contains(expectedBillingAddressFirstName));

        String actualBillingAddressCompany = productPage.address1.get(3).getText();
        String expectedBillingAddressCompany = userCompany;
        Assert.assertTrue(actualBillingAddressCompany.contains(expectedBillingAddressCompany));

        String actualBillingAddress1 = productPage.address1.get(4).getText();
        String expectedBillingAddress1 = userAddress1;
        Assert.assertTrue(actualBillingAddress1.contains(expectedBillingAddress1));

        String actualBillingAddress2 = productPage.address1.get(5).getText();
        String expectedBillingAddress2 = userAddress2;
        Assert.assertTrue(actualBillingAddress2.contains(expectedBillingAddress2));

        String actualBillingAddressCity = productPage.addressCity.get(1).getText();
        String expectedBillingAddressCity = userCity;
        Assert.assertTrue(actualBillingAddressCity.contains(expectedBillingAddressCity));

        String actualBillingAddressMobileNumber = productPage.addressPhone.get(1).getText();
        String expectedBillingAddressMobileNumber = userMobile;
        Assert.assertTrue(actualBillingAddressMobileNumber.contains(expectedBillingAddressMobileNumber));


        productPage.commentBox.sendKeys("Please Send Me the order in the Below given Address.");
        Thread.sleep(2000);

        productPage.btnPlaceOrder.click();

        String cardName = "Admin";
        String cardNumber = "56765436523467523";
        String cardCvc = "689";
        String expiryMonth = "09";
        String expiryYear = "2027";

        productPage.givingCardInformationForPayment(cardName, cardNumber, cardCvc, expiryMonth, expiryYear);
        Thread.sleep(3000);


        //Place Order Assertion
        String actualOrderPlace = productPage.placeOrderSuccessfullyAssertion.getText();
        String expectedOrderPlace = "Congratulations! Your order has been confirmed!";
        Assert.assertTrue(actualOrderPlace.equals(expectedOrderPlace));


        productPage.btnDownloadInvoice.click();

        productPage.btnContinue.click();


        //Home Page Assertion After Placing an Order Successfully
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


    }

    @Test(priority = 7, description = "Test Case 22: Add to cart from Recommended items")
    public void addToCartFromRecommendedItems() throws InterruptedException {

        productPage = new ProductPage(driver);


        Utils.scrollThePage(driver);


        //Recommended Items Page Assertion
        String actualRecommendedItemsPage = productPage.verifyRecommendedPageAssertion.getText();
        String expectedRecommendedItemsPage = "RECOMMENDED ITEMS";
        Assert.assertTrue(actualRecommendedItemsPage.equals(expectedRecommendedItemsPage));


        Utils.waitForElement(driver, productPage.waitForThisProduct, 50);
        if (productPage.waitForThisProduct.isDisplayed()) {
            productPage.addToCart.get(68).click();
            Thread.sleep(2000);
        }


        // Product Add To Cart Successfully
        String actualAddToCartProduct = productPage.successfullyAddToCartAssertion.getText();
        String expectedAddToCartProduct = "Your product has been added to cart.";
        Assert.assertTrue(actualAddToCartProduct.equals(expectedAddToCartProduct));


        productPage.btnViewCart.click();
        Thread.sleep(1000);


        //Product Added Successfully Assertion

        //Product Description Assertion
        String actualProductDescription = productPage.verifyRecommendedProductDescription.getText();
        String expectedProductDescription = "Blue Top";
        Assert.assertTrue(actualProductDescription.equals(expectedProductDescription));

        //1st Product Price Assertion
        String actualProductPrice = productPage.verifyProductPrice.get(0).getText();
        String expectedProductPrice = "Rs. 500";
        Assert.assertTrue(actualProductPrice.equals(expectedProductPrice));

        //1st Product Quantity Assertion
        String actualProductQuantity = productPage.verifyProductQuantity.get(0).getText();
        String expectedProductQuantity = "1";
        Assert.assertTrue(actualProductQuantity.equals(expectedProductQuantity));

        //1st Product total Price Assertion
        String actualProductTotalPrice = productPage.verifyProductTotalPriceInProductDetailsPage.get(0).getText();
        String expectedProductTotalPrice = "Rs. 500";
        Assert.assertTrue(actualProductTotalPrice.equals(expectedProductTotalPrice));


        productPage.deleteProducts.get(0).click();

    }

    @Test(priority = 8, description = "Delete Account")
    public void deleteAccount() {

        createAccountPage = new CreateAccountPage(driver);


        createAccountPage.navDeleteAccount.click();


        // Account Deletion Successful Page Assertion
        String actualAccountDeletedPage = createAccountPage.accountDeletedSuccessfulAssertion.getText();
        String expectedAccountDeletedPage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualAccountDeletedPage.contains(expectedAccountDeletedPage));


        createAccountPage.btnContinue.click();


        // After Account Deletion Home Page Assertion
        String actualAccountDeletedHomePage = createAccountPage.afterAccountDeletionHomePageAssertion.getText();
        String expectedAccountDeletedHomePage = "Signup / Login";
        Assert.assertTrue(actualAccountDeletedHomePage.contains(expectedAccountDeletedHomePage));

    }


}
