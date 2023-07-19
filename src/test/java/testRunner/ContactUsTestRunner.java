package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactUsPage;
import setup.Setup;
import utils.Utils;

public class ContactUsTestRunner extends Setup {

    ContactUsPage contactUsPage;
    Utils utils;

    @Test(priority = 1, description = "Test Case 6: Contact Us Form")
    public void submittedContactUsFormSuccessfully() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        contactUsPage = new ContactUsPage(driver);
        utils = new Utils();
        utils.randomData();


        contactUsPage.navContactUs.click();


        //Contact Us Page Assertion
        String actualContactUsPage = contactUsPage.ContactUsPageAssertion.getText();
        String expectedContactUsPage = "GET IN TOUCH";
        Assert.assertTrue(actualContactUsPage.contains(expectedContactUsPage));


        String name = utils.getFirstName();
        String userEmail = utils.getUserName() + "@gmail.com";

        String subject = "Can't Login to the System";

        String message = "I have a problem, i cant login my email on PC. When i input my email then appear " +
                "\"something went wrong, try again\" before i input my password. This only happen on my PC, " +
                "in my phone is normal. I have tried on 2 PC in the different place (my home and my office), " +
                "same problem. Please help me, thank you";

        String imageUrl = "D:\\OLDTestAutomation\\TestAttachments\\download.png";

        contactUsPage.contactUsFormSubmission(name, userEmail, subject, message, imageUrl);
        Thread.sleep(1000);

        contactUsPage.btnSubmit.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Contact Us Page Submission Successful Assertion
        String actualContactUsPageSubmissionSuccessful = contactUsPage.successMessageAssertion.getText();
        String expectedContactUsPageSubmissionSuccessful = "Success! Your details have been submitted successfully";
        Assert.assertTrue(actualContactUsPageSubmissionSuccessful.contains(expectedContactUsPageSubmissionSuccessful));

        contactUsPage.btnHome.click();

        //After Clicking the Home Button Home Page Assertion
        String actualHomePage = contactUsPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));
    }

}
