package applications.github.e2e_test;

import applications.github.LoginPage;
import applications.github.MainPage;
import config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static applications.github.MainPage.MAIN_PAGE_PATH;

public class TC_MainLoginPageFlow extends TestBase {
    private static final Logger _logger = LogManager.getLogger(Config.class);

    @Test
    public void isLoginPageIsOpenFromMainPage() {
        _logger.info("Test if user is able to open Login page from Main page");
        driver.get(MAIN_PAGE_PATH);
        MainPage mainPage = new MainPage(driver, wait);
        if (mainPage.isDisplayed()) {
            mainPage.goToLoginPage();
        }
        Assert.assertTrue(new LoginPage(driver, wait).isPageDisplayed());
    }
}