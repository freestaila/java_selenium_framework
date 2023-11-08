package utilities;

import config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase extends Config {
    private static final Logger _logger = LogManager.getLogger(TestBase.class);

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeClass
    public static void init() throws Exception {
        _logger.info("Initialize driver: " + System.getProperty("driver"));

        if (System.getProperty("driver").equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (System.getProperty("driver").equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            driver = new FirefoxDriver(options);
        } else if (System.getProperty("driver").equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new Exception("Incorrect driver provided. Please check properties file");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void cleanUP() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
