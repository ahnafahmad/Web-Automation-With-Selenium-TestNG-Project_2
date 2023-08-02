package testRunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreateAccountPage;
import page.LoginPage;
import page.SignupPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class LoginTestRunner extends Setup {

    LoginPage loginPage;
    CreateAccountPage createAccountPage;
    Utils utils;

    SignupPage signupPage;


    @Test(priority = 1, description = "Test Case 3: Login User with incorrect email and password")
    public void loginUnsuccessfulWithInvalidCredentials() throws InterruptedException {

        driver.get("https://www.automationexercise.com");

        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);

        signupPage.navLogin.click();

        // Login/Signup Page Assertion
        String actualSignupPage = loginPage.loginAssertion.getText();
        String expectedSignupPage = "Login to your account";
        Assert.assertTrue(actualSignupPage.contains(expectedSignupPage));

        String userEmail = "abc@gmail.com";
        String userPassword = "12345";
        Thread.sleep(1000);

        loginPage.doLogin(userEmail,userPassword);

        // Warning Error Message After Entering Invalid credentials Assertion
        String actualAccountCreatedHomePage = loginPage.errorMessageAssertion.getText();
        String expectedAccountCreatedHomePage = "Your email or password is incorrect!";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));

    }

    @Test(priority = 2, description = "Test Case 2: Login User with correct email and password")
    public void loginSuccessfulWithValidCredentials() throws IOException, ParseException, InterruptedException {

        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        utils = new Utils();

        String file = "./src/test/resources/user.json";

        List users = Utils.readJsonData(file);

        JSONObject userObject = (JSONObject) users.get(users.size()-1);

        String userEmail = (String) userObject.get("userEmail");
        String userPassword = (String) userObject.get("userPassword");
        Thread.sleep(1000);


        loginPage.doLogin(userEmail,userPassword);
        Thread.sleep(1000);

        // After Account Creation Home Page Assertion
        String actualAccountCreatedHomePage = createAccountPage.afterAccountCreationHomePageAssertion.getText();
        String expectedAccountCreatedHomePage = "Logged in as";
        Assert.assertTrue(actualAccountCreatedHomePage.contains(expectedAccountCreatedHomePage));


//        createAccountPage.navDeleteAccount.click();
//
//
//        // Account Deletion Successful Page Assertion
//        String actualAccountDeletedPage = createAccountPage.accountDeletedSuccessfulAssertion.getText();
//        String expectedAccountDeletedPage = "ACCOUNT DELETED!";
//        Assert.assertTrue(actualAccountDeletedPage.contains(expectedAccountDeletedPage));
//
//
//        createAccountPage.btnContinue.click();
//
//
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
