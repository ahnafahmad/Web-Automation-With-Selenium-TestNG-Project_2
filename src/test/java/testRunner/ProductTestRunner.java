package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import page.SignupPage;
import setup.Setup;

public class ProductTestRunner extends Setup {


    SignupPage signupPage;
    ProductPage productPage;

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


        productPage.searchProduct.sendKeys("Cotton Silk Hand Block Print Saree");

        productPage.btnSearch.click();


        //Search Page Assertion
        String actualSearchPage = productPage.SearchProductPageAssertion.getText();
        String expectedSearchPage = "SEARCHED PRODUCTS";
        Assert.assertTrue(actualSearchPage.equals(expectedSearchPage));


        //Verify The Specific Search Product is Visible
        String actualSearchProduct = productPage.verifySearchedProductVisible.getText();
        String expectedSearchProduct = "Cotton Silk Hand Block Print Saree";
        Assert.assertTrue(actualSearchProduct.equals(expectedSearchProduct));










    }

}
