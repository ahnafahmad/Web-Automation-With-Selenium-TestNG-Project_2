package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(css = "[name = name]")
    WebElement txtUserName;

    @FindBy(css = "[data-qa = signup-email]")
    WebElement txtEmail;

    @FindBy(css = "[data-qa = signup-button]")
    WebElement btnSubmit;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String newUserName, String newUserEmail){

        txtUserName.sendKeys(newUserName);
        txtEmail.sendKeys(newUserEmail);
        btnSubmit.click();

    }

}

