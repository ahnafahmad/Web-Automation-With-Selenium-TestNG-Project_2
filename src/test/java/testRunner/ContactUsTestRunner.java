package testRunner;

import org.testng.Assert;
import page.ContactUsPage;
import setup.Setup;

public class ContactUsTestRunner extends Setup {

    ContactUsPage contactUsPage;

    public void submittedContactUsFormSuccessfully(){

        driver.get("https://www.automationexercise.com");

        contactUsPage = new ContactUsPage(driver);


        contactUsPage.navContactUs.click();


        //Contact Us Page Assertion
        String actualContactUsPage = contactUsPage.ContactUsPageAssertion.getText();
        String expectedContactUsPage = "GET IN TOUCH";
        Assert.assertTrue(actualContactUsPage.contains(expectedContactUsPage));




    }


}
