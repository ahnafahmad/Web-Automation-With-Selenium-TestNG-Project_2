package testRunner;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreateAccountPage;
import page.SignupPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class CreateAccountTestRunner extends Setup {

    SignupPage signupPage;

    CreateAccountPage createAccountPage;

    Utils utils;

    String userEmail;

   public String userPassword;
    public String firstName;
    public String lastName;
    public String company;
    public String address1;
    public String address2;
    public String state;
    public String city;
    public String zipCode;
    public String mobileNumber;


    @Test(priority = 1, description = "Test Case 5: Register User with existing email")
    public void signUpUnsuccessfulWithExistingCredentials() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        createAccountPage = new CreateAccountPage(driver);
        signupPage = new SignupPage(driver);

        //Home Page Assertion
        String actualHomePage = signupPage.homePageAssertion.getText();
        String expectedHomePage = "Full-Fledged practice website for Automation Engineers";
        Assert.assertTrue(actualHomePage.equals(expectedHomePage));


        signupPage.navLogin.click();
        Thread.sleep(3000);


        // Login/Signup Page Assertion
        String actualSignupPage = createAccountPage.newUserSignupAssertion.getText();
        String expectedSignupPage = "New User Signup!";
        Assert.assertTrue(actualSignupPage.contains(expectedSignupPage));


        String name = "Admin";
        String userEmail = "admin2@gmail.com";

        signupPage.doSignUp(name, userEmail);
        Thread.sleep(3000);

        // Warning Error Message After Entering Invalid credentials Assertion
        String actualAccountCreatedHomePage = signupPage.errorMessageAssertion.getText();
        String expectedAccountCreatedHomePage = "Email Address already exist!";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));

    }


    @Test(priority = 2, description = "Test Case 1: Register User")
    public void signUpSuccessfullyWithNewCredentials() throws InterruptedException {


        signupPage = new SignupPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        utils = new Utils();
        utils.randomData();


        String newUserName = utils.getUserName();
        userEmail = utils.getUserName() + "@gmail.com";


        signupPage.doSignUp(newUserName, userEmail);
        Thread.sleep(3000);


        // Account Information Page Assertion
        String actualAccountInfoPage = createAccountPage.enterAccountInfoAssertion.getText();
        String expectedAccountInfoPage = "ENTER ACCOUNT INFORMATION";
        Assert.assertTrue(actualAccountInfoPage.contains(expectedAccountInfoPage));

    }

    @Test(priority = 3, description = "Enter All the Relevant Information after Signing up Successfully")
    public void enteredAccountInformationSuccessfully() throws InterruptedException, IOException, ParseException {

        createAccountPage = new CreateAccountPage(driver);
        utils = new Utils();
        utils.randomData();

        userPassword = "admin123";
        firstName = utils.getFirstName();
        lastName = utils.getLastName();
        company = utils.getCompany();
        address1 = utils.getAddress1();
        address2 = utils.getAddress2();
        state = utils.getState();
        city = utils.getCity();
        zipCode = utils.getZipCode();
        mobileNumber = utils.getMobileNumber();


        createAccountPage.createAccount(userPassword, firstName, lastName, company, address1, address2, state, city, zipCode, mobileNumber);
        Thread.sleep(3000);


        // Account Creation Successful Page Assertion
        String actualAccountCreatedPage = createAccountPage.accountCreatedSuccessfulAssertion.getText();
        String expectedAccountCreatedPage = "ACCOUNT CREATED!";
        Assert.assertTrue(actualAccountCreatedPage.contains(expectedAccountCreatedPage));
        Thread.sleep(1000);

        Utils.waitForElement(driver, createAccountPage.accountCreatedSuccessfulAssertion, 50);
        if (createAccountPage.accountCreatedSuccessfulAssertion.isDisplayed()) {
            utils.saveJsonList(userEmail, userPassword, firstName, company, address1, address2, city, mobileNumber );
        }

        createAccountPage.btnContinue.click();
        Thread.sleep(1000);


        // After Account Creation Home Page Assertion
        String actualAccountCreatedHomePage = createAccountPage.afterAccountCreationHomePageAssertion.getText();
        String expectedAccountCreatedHomePage = "Logged in as";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));


//        createAccountPage.navDeleteAccount.click();


//        // Account Deletion Successful Page Assertion
//        String actualAccountDeletedPage = createAccountPage.accountDeletedSuccessfulAssertion.getText();
//        String expectedAccountDeletedPage = "ACCOUNT DELETED!";
//        Assert.assertTrue(actualAccountDeletedPage.contains(expectedAccountDeletedPage));


//        createAccountPage.btnContinue.click();


//        // After Account Deletion Home Page Assertion
//        String actualAccountDeletedHomePage = createAccountPage.afterAccountDeletionHomePageAssertion.getText();
//        String expectedAccountDeletedHomePage = "Signup / Login";
//        Assert.assertTrue(actualAccountDeletedHomePage.contains(expectedAccountDeletedHomePage));

        createAccountPage.logOutAccount.click();


        // After Logout the Account Home Page Assertion
        String actualAccountLogoutHomePage = createAccountPage.afterAccountLogoutHomePageAssertion.getText();
        String expectedAccountLogoutHomePage = "Signup / Login";
        Assert.assertTrue(actualAccountLogoutHomePage.contains(expectedAccountLogoutHomePage));
        Thread.sleep(3000);

    }

}

