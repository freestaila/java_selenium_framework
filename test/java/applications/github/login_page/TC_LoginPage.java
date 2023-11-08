package applications.github.login_page;

import applications.github.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Properties;

import static applications.github.LoginPage.LOGIN_PAGE_PATH;
import static utilities.common.PropertiesUtil.loadProperties;

public class TC_LoginPage extends TestBase {
    private static final Logger _logger = LogManager.getLogger(TC_LoginPage.class);

    @Test
    public void IsLoginPageOpen() {
        _logger.info("Open Login Page");
        driver.get(LOGIN_PAGE_PATH);
        LoginPage loginPage = new LoginPage(driver, wait);
        Assert.assertTrue(loginPage.isPageDisplayed());
    }

    @Test
    @Parameters("user-data")
    public void IncorrectMessageIsDisplayedAfterProvideWrongUserData(String user_data) throws InterruptedException {
        Properties incorrect_user_data = loadProperties(user_data);
        _logger.info("Provide incorrect user data on login page and check if Incorrect data message is displayed\n" +
                "username: " + incorrect_user_data.getProperty("username") +
                "\npassword: " + incorrect_user_data.getProperty("password"));
        driver.get(LOGIN_PAGE_PATH);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.isPageDisplayed();
        loginPage.fillLoginField(incorrect_user_data.getProperty("username"));
        loginPage.fillPasswordField(incorrect_user_data.getProperty("password"));
        loginPage.clickSignInButton();
        Assert.assertTrue(loginPage.isIncorrectUserDataMessageDisplayed());
    }
}
