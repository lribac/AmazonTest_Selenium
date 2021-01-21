package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSettingsPage extends BasePage {

    public LanguageSettingsPage(WebDriver driver) { super(driver); }

    @FindBy(xpath="//input[@value='en_US']/following-sibling::i")
    public WebElement englishCheckbox;
    @FindBy(xpath="//input[@value='es_US']/following-sibling::i")
    public WebElement spanishCheckbox;
    @FindBy(id="icp-btn-save")
    WebElement saveButton;


    public void selectLanguage(WebElement checkbox){
        waitForVisibilityOfElement(checkbox);
        checkbox.click();
        this.saveButton.click();
    }

}
