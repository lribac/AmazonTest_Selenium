import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import properties.ReadElementPropertyValues;

import java.net.MalformedURLException;

public class SearchTest {

    public WebDriver driver;
    public ReadElementPropertyValues prop = new ReadElementPropertyValues();

    HomePage homePage;
    ResultsPage resultsPage;

    int resultsCount;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        Setup s=new Setup();
        driver = s.initializeDriver();
        s.hitUrl(prop.getProperty("url"));
        //s.hitUrl("https://www.amazon.com/");
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }

    @Test
    public void searchForProduct() {
        System.out.println("searchForProduct with Thread Id:- "+ Thread.currentThread().getId());
        homePage = new HomePage(driver);
        resultsPage = homePage.search(prop.getProperty("searchTerm"));
        //resultsPage = homePage.search("Home & Kitchen", "pillow");
    }

    @Test (dependsOnMethods={"searchForProduct"})
    public void verifySearchResultsAreReturned() {
        System.out.println("verifySearchResultsAreReturned with Thread Id:- "+ Thread.currentThread().getId());
        resultsPage.applyCustomerReviewFilter();
        resultsCount = resultsPage.getResultsCount();
        Assert.assertTrue(resultsCount > 0);
    }

    @Test (dependsOnMethods={"verifySearchResultsAreReturned"})
    public void verifyRelevantSearchResultsAreReturned() {
        System.out.println("verifyRelevantSearchResultsAreReturned with Thread Id:- "+ Thread.currentThread().getId());

    }
}
