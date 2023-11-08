package utilities.PageObject;

import config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class BasePageObject extends TestBase {
    private static final Logger _logger = LogManager.getLogger(Config.class);

    WebDriver driver;
    WebDriverWait wait;

    protected BasePageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this
        );
    }

    protected boolean isDisplayed(WebElement element) {
        _logger.debug("Is element displayed: " + element);
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected void clickButton(WebElement element) {
        _logger.debug("Click on element: " + element);
        element.click();
    }

    protected void fillFieldWithText(WebElement element, String text) {
        _logger.debug("Fill field: " + element + " with text: " + text);
        element.sendKeys(text);
    }

    protected String getFieldText(WebElement element) {
        _logger.debug("Get text from: " + element);
        return element.getText();
    }
}
