package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "[data-qa = login-email]")
    WebElement txtEmail;

    @FindBy(css = "[data-qa = login-password]")
    WebElement txtPassword;

    @FindBy(css = "[data-qa = login-button]")
    WebElement btnSubmit;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    public WebElement loginAssertion;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    public WebElement errorMessageAssertion;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String userEmail, String userPassword){

        txtEmail.clear();
        txtPassword.clear();

        txtEmail.sendKeys(userEmail);
        txtPassword.sendKeys(userPassword);
        btnSubmit.click();

    }

}
