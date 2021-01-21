package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    @FindBy(xpath="//section[@aria-label='4 Stars & Up']//i")
    WebElement fourStartAndUpFilter;
    @FindBy(xpath="//a[@class='a-link-normal a-text-normal']")
    List<WebElement> resultsLinks;
    @FindBy(xpath="//span[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']/h1/div/div/div/div/span[1]")
    WebElement resultsCountString;

    public ResultsPage(WebDriver driver) { super(driver); }

    public void applyCustomerReviewFilter(){
        waitForVisibilityOfElement(fourStartAndUpFilter);
        fourStartAndUpFilter.click();
    }

    public ProductPage selectFirstProduct() {
        waitForVisibilityOfElement(this.resultsCountString);
        this.resultsLinks.get(0).click();
        return new ProductPage(driver);
    }

    public int getResultsCount(){
        waitForVisibilityOfElement(this.resultsCountString);
        String[] countString =this.resultsCountString.getText().split(" ");
        return Integer.parseInt(countString[3].replaceAll(",", ""));
    }





}
