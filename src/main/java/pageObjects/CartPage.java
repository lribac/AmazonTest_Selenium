package pageObjects;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath="//span[@class='a-size-medium sc-product-title a-text-bold']")
    WebElement productTitleCart;
    @FindBy(xpath="//input[@value='Delete']")
    WebElement deleteButton;

    public CartPage(WebDriver driver) { super(driver); }

    public String getProductTitleInCart(){
        waitForVisibilityOfElement(this.productTitleCart);
        return this.productTitleCart.getText();
    }

    public void deleteProductFromCart() {
        waitForVisibilityOfElement(this.deleteButton);
        this.deleteButton.click();
    }
    public boolean verifyProductIsNotInCart(String product){
        try{
            return getProductTitleInCart().contains(product);
        }catch(Exception e){
            return false;
        }
    }

}
