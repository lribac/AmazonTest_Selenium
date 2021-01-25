import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import properties.ReadElementPropertyValues;

import java.net.MalformedURLException;

public class SiteLanguageTest {

    public WebDriver driver;
    public ReadElementPropertyValues prop = new ReadElementPropertyValues();

    HomePage homePage;
    LanguageSettingsPage languageSettingsPage;

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
    public void verifySpanish() {
        System.out.println("verifySpanish with Thread Id:- "+ Thread.currentThread().getId());
        homePage = new HomePage(driver);
        languageSettingsPage = homePage.goToLanguageSettingsPage();
        languageSettingsPage.selectLanguage(languageSettingsPage.spanishCheckbox);
        homePage.verifyLanguageSelected("Hola, Identifícate");
    }

    @Test (dependsOnMethods={"verifySpanish"})
    public void verifyEnglish() {
        System.out.println("verifyEnglish with Thread Id:- "+ Thread.currentThread().getId());
        homePage = new HomePage(driver);
        languageSettingsPage = homePage.goToLanguageSettingsPage();
        languageSettingsPage.selectLanguage(languageSettingsPage.englishCheckbox);
        homePage.verifyLanguageSelected("Hello, Sign in");


    }

}
