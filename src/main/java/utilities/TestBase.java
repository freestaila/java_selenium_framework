package utilities;

import config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
        driver = DriverUtils.init();
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
