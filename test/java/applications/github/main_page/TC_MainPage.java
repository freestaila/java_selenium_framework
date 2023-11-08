package applications.github.main_page;

import applications.github.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static applications.github.MainPage.MAIN_PAGE_PATH;

public class TC_MainPage extends TestBase {
    private static final Logger _logger = LogManager.getLogger(TC_MainPage.class);

    @Test
    public void isMainPageOpen() {
        _logger.info("Test if Main Page is open");
        driver.get(MAIN_PAGE_PATH);
        Assert.assertTrue(new MainPage(driver, wait).isDisplayed());
    }
}

