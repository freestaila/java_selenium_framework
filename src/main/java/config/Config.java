package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Config {
    private static final Logger _logger = LogManager.getLogger(Config.class);

    @BeforeSuite
    @Parameters("driver")
    public void setup(String driver, ITestContext context) {
        System.setProperty("driver", driver);
        _logger.info("Tests will be performed with: " + System.getProperty("driver") + " driver");
    }
}
