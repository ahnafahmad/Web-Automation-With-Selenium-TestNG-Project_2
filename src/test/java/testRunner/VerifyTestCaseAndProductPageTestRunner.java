package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignupPage;
import page.VerifyTestCaseAndProductPage;
import setup.Setup;

public class VerifyTestCaseAndProductPageTestRunner extends Setup {

    SignupPage signupPage;
    VerifyTestCaseAndProductPage verifyTestCaseAndProductPage;

    @Test(priority = 1, description = "Test Case 7: Verify Test Cases Page")
    public void verifyTestCasePageSuccessfully() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        signupPage = new SignupPage(driver);
        verifyTestCaseAndProductPage = new VerifyTestCaseAndProductPage(driver);

        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


        verifyTestCaseAndProductPage.navTestCase.click();
        Thread.sleep(3000);


        //Verify Test Case Page Assertion
        String actualTestCasePage = verifyTestCaseAndProductPage.verifyTestCasePage.getText();
        String expectedTestCasePage = "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:";
        Assert.assertTrue(actualTestCasePage.equals(expectedTestCasePage));

    }


    @Test(priority = 2, description = "Test Case 8: Verify All Products and product detail page")
    public void verifyProductPageSuccessfully() {

        signupPage = new SignupPage(driver);
        verifyTestCaseAndProductPage = new VerifyTestCaseAndProductPage(driver);


        verifyTestCaseAndProductPage.navProduct.click();


        //Product Page Assertion
        String actualProductPage = verifyTestCaseAndProductPage.verifyProductPage.getText();
        String expectedProductPage = "ALL PRODUCTS";
        Assert.assertTrue(actualProductPage.equals(expectedProductPage));


        //Product List Visibility Assertion
        String actualProductList = verifyTestCaseAndProductPage.verifyProductList.getText();
        String expectedProductList = "Add to cart";
        Assert.assertTrue(actualProductList.equals(expectedProductList));


        verifyTestCaseAndProductPage.viewProduct.click();


        //Product Name Visibility Assertion
        String actualProductName = verifyTestCaseAndProductPage.productName.getText();
        String expectedProductName = "Blue Top";
        Assert.assertTrue(actualProductName.equals(expectedProductName));


        //Product Category Visibility Assertion
        String actualProductCategory = verifyTestCaseAndProductPage.productCategory.getText();
        String expectedProductCategory = "Category: Women > Tops";
        Assert.assertTrue(actualProductCategory.equals(expectedProductCategory));


        //Product Price Visibility Assertion
        String actualProductPrice = verifyTestCaseAndProductPage.productPrice.getText();
        String expectedProductPrice = "Rs. 500";
        Assert.assertTrue(actualProductPrice.equals(expectedProductPrice));


        //Product Availability Visibility Assertion
        String actualProductAvailability = verifyTestCaseAndProductPage.productAvailability.getText();
        String expectedProductAvailability = "Availability:";
        Assert.assertTrue(actualProductAvailability.equals(expectedProductAvailability));


        //Product Condition Visibility Assertion
        String actualProductCondition = verifyTestCaseAndProductPage.productCondition.getText();
        String expectedProductCondition = "Condition:";
        Assert.assertTrue(actualProductCondition.equals(expectedProductCondition));


        //Product Brand Visibility Assertion
        String actualProductBrand = verifyTestCaseAndProductPage.productBrand.getText();
        String expectedProductBrand = "Brand:";
        Assert.assertTrue(actualProductBrand.equals(expectedProductBrand));


    }

}
