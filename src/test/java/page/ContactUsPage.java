package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    public WebElement navContactUs;

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    public WebElement ContactUsPageAssertion;

    @FindBy(css = "[name = name]")
    WebElement txtName;

    @FindBy(css = "[name = email]")
    WebElement txtEmail;

    @FindBy(css = "[name = subject]")
    WebElement txtSubject;

    @FindBy(css = "[name = message]")
    WebElement txtMessage;

    @FindBy(css = "[name = upload_file]")
    WebElement uploadImage;

    @FindBy(css = "[name = submit]")
    public WebElement btnSubmit;

    @FindBy(xpath = "//div[contains(text(),'Success! Your details have been submitted successfully')]")
    public WebElement successMessageAssertion;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement btnHome;

    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged')]")
    public WebElement homePageAssertion;


    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void contactUsFormSubmission(String name, String email, String subject, String message,String imageUrl) throws InterruptedException {

        txtName.sendKeys(name);
        txtEmail.sendKeys(email);
        txtSubject.sendKeys(subject);
        txtMessage.sendKeys(message);
        Thread.sleep(1000);

        uploadImage.sendKeys(imageUrl);
        Thread.sleep(1000);

    }

}
