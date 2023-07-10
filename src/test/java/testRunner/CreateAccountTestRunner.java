package testRunner;

import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.SignupPage;
import setup.Setup;
import utils.Utils;

public class CreateAccountTestRunner extends Setup {

    SignupPage signupPage;
    CreateAccountPage createAccountPage;

    @Test (priority = 1)
    public void signUpSuccessfully() throws InterruptedException {
        driver.get("https://www.automationexercise.com/login");
        signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        utils.randomData();

        String newUserName = "Admin";
        String newUserEmail = utils.getFirstName() + "@gmail.com";

        signupPage.doLogin(newUserName, newUserEmail);
        Thread.sleep(3000);

    }

    @Test(priority = 2)
    public void enteredAccountInformationSuccessfully() throws InterruptedException {

        createAccountPage = new CreateAccountPage(driver);
        Utils utils = new Utils();
        utils.randomData();

        String password = "admin123";
        String firstName = utils.getFirstName();
        String lastName = utils.getLastName();
        String company = utils.getCompany();
        String address1 = utils.getAddress1();
        String address2 = utils.getAddress2();
        String state = utils.getState();
        String city = utils.getCity();
        String zipCode = utils.getZipCode();
        String mobileNumber = utils.getMobileNumber();


//        String firstName = "Alen";
//        String lastName = "Shopon";
//        String company  = "MISL";
//        String address1 = "32/4";
//        String address2 = "North Street";
//        String state = "goalcoast";
//        String city = "perth";
//        String zipCode = "49763";
//        String mobileNumber = "01786734583";


        createAccountPage.createAccount(password,firstName,lastName,company,address1,address2,state, city, zipCode, mobileNumber);
        Thread.sleep(3000);

    }

}
