package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    public WebElement navProduct;

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement productPageAssertion;

    @FindBy(css = "[name = search]")
    public WebElement searchProduct;

    @FindBy(id = "submit_search")
    public WebElement btnSearch;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    public WebElement searchProductPageAssertion;

    @FindBy(xpath = "//p[contains(text(),'Cotton Silk Hand Block Print Saree')]")
    public WebElement verifySearchedProductVisible;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
