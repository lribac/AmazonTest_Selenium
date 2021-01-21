package pageObjects;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    @FindBy(id="nav-link-accountList")
    WebElement accountsAndListsMenu;
    @FindBy(id="searchDropdownBox")
    WebElement categoryDropDown;
    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(id="nav-search-submit-button")
    WebElement magnifyingGlassIcon;
    @FindBy(id="nav-cart-count-container")
    WebElement cartButtonNavBar;
    @FindBy(id="icp-nav-flyout")
    WebElement languageIcon;
    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement greetingMessage;


    public HomePage(WebDriver driver) { super(driver); }

    public LoginPage goToSignPage(){
        waitForVisibilityOfElement(this.accountsAndListsMenu);
        this.accountsAndListsMenu.click();
        return new LoginPage(driver);
    }

    public ResultsPage search(String searchTerm) {
        waitForVisibilityOfElement(this.searchBox);
        //Select search = new Select(this.categoryDropDown);
        //search.selectByVisibleText(searchCategory);
        this.searchBox.sendKeys(searchTerm);
        this.magnifyingGlassIcon.click();
        return new ResultsPage(driver);
    }

    public CartPage goToCartPage(){
        waitForVisibilityOfElement(this.cartButtonNavBar);
        this.cartButtonNavBar.click();
        return new CartPage(driver);
    }

    public LanguageSettingsPage goToLanguageSettingsPage(){
        waitForVisibilityOfElement(this.languageIcon);
        this.languageIcon.click();
        return new LanguageSettingsPage(driver);
    }

    public void verifyLanguageSelected(String expectedString){
        waitForVisibilityOfElement(this.greetingMessage);
        String actualString = this.greetingMessage.getText();
        Assert.assertEquals(actualString, expectedString);

    }

}
