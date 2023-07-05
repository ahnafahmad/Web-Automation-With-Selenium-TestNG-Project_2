package pages;

import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    @FindBy(id = "id_gender1")
    WebElement title;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "days")
    WebElement dropDownDays;

    @FindBy(id = "months")
    WebElement dropDownMonths;

    @FindBy(id = "years")
    WebElement dropDownYears;

    @FindBy(id = "newsletter")
    WebElement newSletterCheckBox;

    @FindBy(id = "optin")
    WebElement optinCheckBox;

    @FindBy(id = "first_name")
    WebElement txtFirstName;

    @FindBy(id = "last_name")
    WebElement txtLastName;

    @FindBy(id = "company")
    WebElement txtCompany;

    @FindBy(id = "address1")
    WebElement txtAddress1;

    @FindBy(id = "address2")
    WebElement txtAddress2;

    @FindBy(id = "country")
    WebElement dropDownCountry;

    @FindBy(id = "state")
    WebElement txtState;

    @FindBy(id = "city")
    WebElement txtCity;

    @FindBy(id = "zipcode")
    WebElement txtZipcode;

    @FindBy(id = "mobile_number")
    WebElement txtMobileNumber;

    @FindBy(css = "[data-qa = create-account]")
    WebElement btnCreateAccount;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void createAccount(String password, String firstName, String lastName, String company, String address1, String address2, String state, String city, String zipCode, String mobileNumber) throws InterruptedException {

        title.click();

        txtPassword.sendKeys(password);

        dropDownDays.click();
        for (int i = 0; i < 7; i++) {
            dropDownDays.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(200);
        }
        dropDownDays.sendKeys(Keys.ENTER);

        dropDownMonths.click();
        for (int i = 0; i < 5; i++) {
            dropDownMonths.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(200);
        }
        dropDownMonths.sendKeys(Keys.ENTER);

        dropDownYears.click();
        for (int i = 0; i < 22; i++) {
            dropDownYears.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(200);
        }
        dropDownYears.sendKeys(Keys.ENTER);

        newSletterCheckBox.click();
        optinCheckBox.click();

        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtCompany.sendKeys(company);
        txtAddress1.sendKeys(address1);
        txtAddress2.sendKeys(address2);

        dropDownCountry.click();
        for (int i = 0; i < 4; i++) {
            dropDownCountry.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(200);
        }
        dropDownCountry.sendKeys(Keys.ENTER);

        txtState.sendKeys(state);
        txtCity.sendKeys(city);
        txtZipcode.sendKeys(zipCode);
        txtMobileNumber.sendKeys(mobileNumber);
        btnCreateAccount.click();

    }

}


