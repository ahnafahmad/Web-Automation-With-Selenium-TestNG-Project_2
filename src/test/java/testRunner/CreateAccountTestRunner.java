package testRunner;

import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.SignupPage;
import setup.Setup;

public class CreateAccountTestRunner extends Setup {

    SignupPage signupPage;
    CreateAccountPage createAccountPage;

    @Test (priority = 1)
    public void signUpSuccessfully() throws InterruptedException {
        driver.get("https://www.automationexercise.com/login");
        signupPage = new SignupPage(driver);

        String newUserName = "Admin";
        String newUserEmail = "admin4@gmail.com";

        signupPage.doLogin(newUserName, newUserEmail);
        Thread.sleep(3000);

    }

    @Test(priority = 2)
    public void enteredAccountInformationSuccessfully() throws InterruptedException {

        createAccountPage = new CreateAccountPage(driver);

        String password = "admin123";
        String firstName = "Alen";
        String lastName = "Shopon";
        String company  = "MISL";
        String address1 = "32/4";
        String address2 = "North Street";
        String state = "goalcoast";
        String city = "perth";
        String zipCode = "49763";
        String mobileNumber = "01786734583";


        createAccountPage.createAccount(password,firstName,lastName,company,address1,address2,state, city, zipCode, mobileNumber);
        Thread.sleep(3000);

    }

}
