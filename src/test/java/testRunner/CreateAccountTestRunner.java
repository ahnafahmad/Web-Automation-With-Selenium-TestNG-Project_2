package testRunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.SignupPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class CreateAccountTestRunner extends Setup {

    SignupPage signupPage;
    LoginPage loginPage;
    CreateAccountPage createAccountPage;
    Utils utils;

    String userEmail;

    @Test(priority = 1)
    public void signUpSuccessfully() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        signupPage = new SignupPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        Utils utils = new Utils();
        utils.randomData();


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


        String newUserName = utils.getUserName();
        userEmail = utils.getUserName() + "@gmail.com";


        signupPage.doSignUp(newUserName, userEmail);
        Thread.sleep(3000);


        // Account Information Page Assertion
        String actualAccountInfoPage = createAccountPage.enterAccountInfoAssertion.getText();
        String expectedAccountInfoPage = "ENTER ACCOUNT INFORMATION";
        Assert.assertTrue(actualAccountInfoPage.contains(expectedAccountInfoPage));

    }

    @Test(priority = 2)
    public void enteredAccountInformationSuccessfully() throws InterruptedException, IOException, ParseException {

        createAccountPage = new CreateAccountPage(driver);
        utils = new Utils();
        utils.randomData();

        String userPassword = "admin123";
        String firstName = utils.getFirstName();
        String lastName = utils.getLastName();
        String company = utils.getCompany();
        String address1 = utils.getAddress1();
        String address2 = utils.getAddress2();
        String state = utils.getState();
        String city = utils.getCity();
        String zipCode = utils.getZipCode();
        String mobileNumber = utils.getMobileNumber();


        createAccountPage.createAccount(userPassword, firstName, lastName, company, address1, address2, state, city, zipCode, mobileNumber);
        Thread.sleep(3000);


        // Account Creation Successful Page Assertion
        String actualAccountCreatedPage = createAccountPage.accountCreatedSuccessfulAssertion.getText();
        String expectedAccountCreatedPage = "ACCOUNT CREATED!";
        Assert.assertTrue(actualAccountCreatedPage.contains(expectedAccountCreatedPage));
        Thread.sleep(1000);

        Utils.waitForElement(driver, createAccountPage.accountCreatedSuccessfulAssertion, 50);
        if (createAccountPage.accountCreatedSuccessfulAssertion.isDisplayed()) {
            utils.saveJsonList(userEmail, userPassword);
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

    @Test(priority = 3)
    public void loginSuccessfulWithValidCredentials() throws IOException, ParseException, InterruptedException {

        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
        utils = new Utils();


        // Login/Signup Page Assertion
        String actualSignupPage = loginPage.loginAssertion.getText();
        String expectedSignupPage = "Login to your account";
        Assert.assertTrue(actualSignupPage.contains(expectedSignupPage));

        String file = "./src/test/resources/user.json";

        List users = Utils.readJsondata(file);

        JSONObject userObject = (JSONObject) users.get(users.size()-1);

        String userEmail = (String) userObject.get("userEmail");
        String userPassword = (String) userObject.get("userPassword");
        Thread.sleep(1000);

        loginPage.doLogin(userEmail,userPassword);

        // After Account Creation Home Page Assertion
        String actualAccountCreatedHomePage = createAccountPage.afterAccountCreationHomePageAssertion.getText();
        String expectedAccountCreatedHomePage = "Logged in as";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));

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

