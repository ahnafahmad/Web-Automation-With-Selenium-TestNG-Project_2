package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import page.SignupPage;
import page.SubscriptionPage;
import setup.Setup;

public class ProductTestRunner extends Setup {


    SignupPage signupPage;
    ProductPage productPage;

    SubscriptionPage subscriptionPage;

    @Test(priority = 1, description = "Test Case 9: Search Product")
    public void searchProductsSuccessfully() {

        driver.get("https://www.automationexercise.com");

        signupPage = new SignupPage(driver);

        productPage = new ProductPage(driver);


        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


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

    @Test(priority = 2, description = "Test Case 12: Add Products in Cart")
    public void addProductsInCart() throws InterruptedException {

        productPage = new ProductPage(driver);

        subscriptionPage = new SubscriptionPage(driver);


        //Add 1st Product to the Cart

        productPage.btnAddToCart.get(0).click();
        Thread.sleep(3000);


        // Product Add To Cart Successfully
        String actualAddToCartProduct1 = productPage.successfullyAddToCartAssertion.getText();
        String expectedAddToCartProduct1 = "Your product has been added to cart.";
        Assert.assertTrue(actualAddToCartProduct1.equals(expectedAddToCartProduct1));

        productPage.btnContinueShopping.click();
        Thread.sleep(2000);


        //Add 2nd Product to the Cart

        productPage.btnAddToCart.get(4).click();
        Thread.sleep(3000);


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
        String actualProductTotalPrice1 = productPage.verifyProductTotalPrice.get(0).getText();
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
        String actualProductTotalPrice2 = productPage.verifyProductTotalPrice.get(1).getText();
        String expectedProductTotalPrice2 = "Rs. 5000";
        Assert.assertTrue(actualProductTotalPrice2.equals(expectedProductTotalPrice2));

    }

}
