package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverUtils {
    private static final Logger _logger = LogManager.getLogger(DriverUtils.class);

    public static WebDriver init() throws Exception {
        _logger.info("Initialize driver setup in properties: " + System.getProperty("driver"));

        if (System.getProperty("driver").equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            return new ChromeDriver(options);
        } else if (System.getProperty("driver").equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            return new FirefoxDriver(options);
        } else if (System.getProperty("driver").equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else {
            _logger.error("Wrong driver in properties file");
            throw new Exception("Incorrect driver provided. Please check properties file");
        }
    }
}
