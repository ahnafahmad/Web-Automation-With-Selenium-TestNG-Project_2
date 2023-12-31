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

    @FindBy(xpath = "//a[contains(text(),'Regular Fit Straight Jeans')]")
    public WebElement verifySingleProductDescription;

    @FindBy(className = "cart_price")
    public List<WebElement> verifyProductPrice;

    @FindBy(className = "cart_quantity")
    public List<WebElement> verifyProductQuantity;

    @FindBy(className = "cart_total")
    public List<WebElement> verifyProductTotalPriceInProductDetailsPage;

    @FindBy(className = "cart_quantity_delete")
    public List<WebElement> deleteProducts;

    @FindBy(xpath = "//u[contains(text(),'here')]")
    public WebElement buyProductWhenCartIsEmpty;


    @FindBy(xpath = "//a[normalize-space()='Women']")
    public WebElement category1;

    @FindBy(xpath = "//a[contains(text(),'Dress')]")
    public List<WebElement> subCategory1;

    @FindBy(className = "title")
    public WebElement categoryAssertion;

    @FindBy(xpath = "//a[normalize-space()='Men']")
    public WebElement category2;

    @FindBy(xpath = "//a[contains(text(),'Jeans')]")
    public WebElement subCategory2;


    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    public WebElement brand1;

    @FindBy(xpath = "//a[@href='/brand_products/Kookie Kids']")
    public WebElement brand2;


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

    @FindBy(className = "page-subheading")
    public List<WebElement> headerSubTitle;

    @FindBy(className = "address_firstname")
    public List<WebElement> addressFirstName;

    @FindBy(className = "address_address1")
    public List<WebElement> address1;

    @FindBy(className = "address_city")
    public List<WebElement> addressCity;

    @FindBy(className = "address_country_name")
    public List<WebElement> addressCountry;

    @FindBy(className = "address_phone")
    public List<WebElement> addressPhone;




    @FindBy(css = "[name = message]")
    public WebElement commentBox;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    public WebElement btnPlaceOrder;

    @FindBy(css = "[name = name_on_card]")
    WebElement nameOnCard;

    @FindBy(css = "[name = card_number]")
    WebElement cardNumber;

    @FindBy(css = "[name = cvc]")
    WebElement cardCvc;

    @FindBy(css = "[name = expiry_month]")
    WebElement cardExpiryMonth;

    @FindBy(css = "[name = expiry_year]")
    WebElement cardExpiryYear;

    @FindBy(id = "submit")
    WebElement btnConfirmOrder;

    @FindBy(xpath = "//p[contains(text(),'Congratulations!')]")
    public WebElement placeOrderSuccessfullyAssertion;

    @FindBy(css = "[data-qa = continue-button]")
    public WebElement btnContinue;

    @FindBy(xpath = "//a[contains(text(),'Download')]")
    public WebElement btnDownloadInvoice;

    @FindBy(className = "cart_total_price")
    public List<WebElement> verifyProductTotalPriceInCheckoutPage;



    @FindBy(xpath = "//a[contains(text(),'Write')]")
    public WebElement verifyReviewPage;

    @FindBy(id = "name")
    public WebElement txtName;

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "review")
    public WebElement txtReview;

    @FindBy(id = "button-review")
    public WebElement btnSubmit;

    @FindBy(xpath = "//span[contains(text(),'Thank you')]")
    public WebElement reviewSubmittedSuccessfully;



    @FindBy(xpath = "//h2[contains(text(),'recommended')]")
    public WebElement verifyRecommendedPageAssertion;



    @FindBy(xpath = "//a[contains(text(),'Blue Top')]")
    public WebElement verifyRecommendedProductDescription;

    @FindBy(xpath = "//p[contains(text(),'Blue')]")
    public List<WebElement> waitForThisProduct;


    @FindBy(className = "fa-angle-up")
    public WebElement scrollUpButton;



    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void givingCardInformationForPayment(String name, String number, String cvc, String expiryMonth, String expiryYear){

        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        cardCvc.sendKeys(cvc);
        cardExpiryMonth.sendKeys(expiryMonth);
        cardExpiryYear.sendKeys(expiryYear);

        btnConfirmOrder.click();


    }

    public void givingReview(String name, String email, String review){

            txtName.sendKeys(name);
            txtEmail.sendKeys(email);
            txtReview.sendKeys(review);

            btnSubmit.click();

    }

}
