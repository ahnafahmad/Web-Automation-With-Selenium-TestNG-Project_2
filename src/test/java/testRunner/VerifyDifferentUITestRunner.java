package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import page.SignupPage;
import page.VerifyDifferentUIPage;
import setup.Setup;

public class VerifyDifferentUITestRunner extends Setup {

    SignupPage signupPage;
    VerifyDifferentUIPage verifyDifferentUIPage;

    ProductPage productPage;

    @Test(priority = 1, description = "Test Case 7: Verify Test Cases Page")
    public void verifyTestCasePageSuccessfully() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        signupPage = new SignupPage(driver);
        verifyDifferentUIPage = new VerifyDifferentUIPage(driver);

        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


        verifyDifferentUIPage.navTestCase.click();
        Thread.sleep(3000);


        //Verify Test Case Page Assertion
        String actualTestCasePage = verifyDifferentUIPage.verifyTestCasePage.getText();
        String expectedTestCasePage = "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:";
        Assert.assertTrue(actualTestCasePage.equals(expectedTestCasePage));

    }


    @Test(priority = 2, description = "Test Case 8: Verify All Products and product detail page")
    public void verifyProductPageSuccessfully() {

        signupPage = new SignupPage(driver);
        verifyDifferentUIPage = new VerifyDifferentUIPage(driver);
        productPage = new ProductPage(driver);


        productPage.navProduct.click();


        //Product Page Assertion
        String actualProductPage = productPage.productPageAssertion.getText();
        String expectedProductPage = "ALL PRODUCTS";
        Assert.assertTrue(actualProductPage.equals(expectedProductPage));


        //Product List Visibility Assertion
        String actualProductList = verifyDifferentUIPage.verifyProductList.getText();
        String expectedProductList = "Add to cart";
        Assert.assertTrue(actualProductList.equals(expectedProductList));


        verifyDifferentUIPage.viewProduct.click();


        //Product Name Visibility Assertion
        String actualProductName = verifyDifferentUIPage.productName.getText();
        String expectedProductName = "Blue Top";
        Assert.assertTrue(actualProductName.equals(expectedProductName));


        //Product Category Visibility Assertion
        String actualProductCategory = verifyDifferentUIPage.productCategory.getText();
        String expectedProductCategory = "Category: Women > Tops";
        Assert.assertTrue(actualProductCategory.equals(expectedProductCategory));


        //Product Price Visibility Assertion
        String actualProductPrice = verifyDifferentUIPage.productPrice.getText();
        String expectedProductPrice = "Rs. 500";
        Assert.assertTrue(actualProductPrice.equals(expectedProductPrice));


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


    }

}
