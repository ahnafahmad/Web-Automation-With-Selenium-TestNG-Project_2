package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//p[contains(text(),'Saree')]")
    public List<WebElement> verifySearchedProductVisible;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//p[contains(text(),'Your product has been added to cart')]")
    public WebElement successfullyAddToCartAssertion;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    public WebElement btnContinueShopping;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    public WebElement btnViewCart;


    @FindBy(xpath = "//a[contains(text(),'Cotton Silk Hand Block Print Saree')]")
    public WebElement verifyProductDescription1;

    @FindBy(xpath = "//a[contains(text(),'Beautiful Peacock Blue Cotton Linen Saree')]")
    public WebElement verifyProductDescription2;

    @FindBy(xpath = "//a[contains(text(),'Blue Top')]")
    public WebElement verifySingleProductDescription;

    @FindBy(className = "cart_price")
    public List<WebElement> verifyProductPrice;

    @FindBy(className = "cart_quantity")
    public List<WebElement> verifyProductQuantity;

    @FindBy(className = "cart_total")
    public List<WebElement> verifyProductTotalPrice;

    @FindBy(className = "cart_quantity_delete")
    public List<WebElement> deleteProducts;

    @FindBy(xpath = "//u[contains(text(),'here')]")
    public WebElement buyProductWhenCartIsEmpty;

    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    public List<WebElement> btnViewProduct;

    @FindBy(id = "quantity")
    public WebElement productQuantity;

    @FindBy(css = "[type = button]")
    public WebElement btnAddToCart;

    @FindBy(className = "check_out")
    public WebElement proceedToCheckout;

    @FindBy(className = "heading")
    public List<WebElement> headerTitle;

    @FindBy(css = "[name = message]")
    public WebElement commentBox;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    public WebElement placeOrder;



    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
