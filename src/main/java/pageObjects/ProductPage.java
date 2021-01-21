package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id="productTitle")
    WebElement productTitle;
    @FindBy(id="add-to-cart-button")
    WebElement addToCartButton;
    @FindBy(id="hlb-view-cart-announce")
    WebElement cartButtonAddedProduct;

    public ProductPage(WebDriver driver) { super(driver); }

    public String getProductTitle(){
        waitForVisibilityOfElement(this.productTitle);
        return this.productTitle.getText();
    }

    public void addToCart(){
        this.addToCartButton.click();
    }

    public CartPage goToCartPage(){
        waitForVisibilityOfElement(this.cartButtonAddedProduct);
        this.cartButtonAddedProduct.click();
        return new CartPage(driver);
    }
}
