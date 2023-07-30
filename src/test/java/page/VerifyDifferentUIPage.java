package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyDifferentUIPage {

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    public WebElement navTestCase;

    @FindBy(xpath = "//span[contains(text(),'Below is the list of test Cases for you to practice the Automation')]")
    public WebElement verifyTestCasePage;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    public WebElement verifyProductList;

    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    public WebElement viewProduct;

    @FindBy(xpath = "//h2[contains(text(),'Straight')]")
    public WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    public WebElement productCategory;

    @FindBy(xpath = "//span[contains(text(),'Rs')]")
    public WebElement productPrice;

    @FindBy(xpath = "//b[contains(text(),'Availability')]")
    public WebElement productAvailability;

    @FindBy(xpath = "//b[contains(text(),'Condition')]")
    public WebElement productCondition;
    @FindBy(xpath = "//b[contains(text(),'Brand')]")
    public WebElement productBrand;


    public VerifyDifferentUIPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

}
