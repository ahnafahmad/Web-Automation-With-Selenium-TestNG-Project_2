package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignupPage {

    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged')]")
    public WebElement homePageAssertion;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    public WebElement navLogin;
    @FindBy(css = "[name = name]")
    WebElement txtUserName;

    @FindBy(css = "[data-qa = signup-email]")
    WebElement txtEmail;

    @FindBy(css = "[data-qa = signup-button]")
    WebElement btnSubmit;



    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doSignUp(String newUserName, String newUserEmail){

        txtUserName.sendKeys(newUserName);
        txtEmail.sendKeys(newUserEmail);
        btnSubmit.click();

    }

}

