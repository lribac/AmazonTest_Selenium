package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="ap_email")
    WebElement emailField;
    @FindBy(id="continue")
    WebElement continueButton;
    @FindBy(id="ap_password")
    WebElement passwordField;
    @FindBy(id="signInSubmit")
    WebElement signInButton;

    public LoginPage(WebDriver driver) { super(driver); }

    public void signIn(String username, String password) {
        waitForVisibilityOfElement(this.emailField);
        this.emailField.sendKeys(username);
        this.continueButton.click();
        waitForVisibilityOfElement(passwordField);
        this.passwordField.sendKeys(password);
        this.signInButton.click();
    }
}
