package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {


    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    public WebElement subscriptionFieldAssertion;

    @FindBy(id = "susbscribe_email")
    public WebElement txtEmailSubscription;

    @FindBy(id = "subscribe")
    public WebElement btnSubscription;

    @FindBy(className = "alert-success")
    public WebElement subscriptionSuccessMessage;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    public WebElement navCart;

    @FindBy(xpath = "//li[contains(text(),'Shopping Cart')]")
    public WebElement cartPageAssertion;


    public SubscriptionPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    public void doSubscription(String email) throws InterruptedException {

        txtEmailSubscription.sendKeys(email);
        Thread.sleep(3000);
        btnSubscription.click();
        Thread.sleep(1000);

    }

}
