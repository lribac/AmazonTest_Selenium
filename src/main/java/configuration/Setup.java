package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import util.TestUtil;
import properties.ReadElementPropertyValues;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Setup {

    public WebDriver driver;
    public ReadElementPropertyValues prop = new ReadElementPropertyValues();

    public WebDriver initializeDriver() {

        /*
         * Local test
         */

       // String browserName = prop.getProperty("browser");
        // String browserName="chrome";

        /**
         * Jenkins test   mvn -test Dbrowser=chrome
         */
          String browserName = System.getProperty("browser");

        if (browserName.contains("chrome")) {

            WebDriverManager.chromedriver().setup();

            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

            if (browserName.contains("chromeHeadless")) {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);

        } else if (browserName.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.setLogLevel(FirefoxDriverLogLevel.FATAL);
            options.setAcceptInsecureCerts(true);

            if (browserName.contains("firefoxHeadless")) {
                options.setHeadless(true);
            }

            driver = new FirefoxDriver(options);

        } else if (browserName.equals("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        return driver;

    }

    public void hitUrl(String url) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);

    }

}


