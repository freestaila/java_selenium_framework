package applications.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PageObject.BasePageObject;

public class LoginPage extends BasePageObject {
    public static final String LOGIN_PAGE_PATH = "https://github.com/login";
    @FindBy(xpath = "//*[text()='Sign in to GitHub']")
    private static WebElement title;
    @FindBy(id = "login_field")
    private static WebElement loginField;
    @FindBy(id = "password")
    private static WebElement passwordField;
    @FindBy(name = "commit")
    private static WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"js-flash-container\"]/div/div/button")
    private static WebElement dissmisIncorrectUserDataMessageButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isPageDisplayed() {
        return isDisplayed(title);
    }

    public boolean isIncorrectUserDataMessageDisplayed() {
        return isDisplayed(dissmisIncorrectUserDataMessageButton);
    }

    public void clickLoginField() {
        clickButton(loginField);
    }

    public void clickPasswordField() {
        clickButton(passwordField);
    }

    public void clickDissmisIncorrectUserDataMessageButton() {
        clickButton(dissmisIncorrectUserDataMessageButton);
    }

    public String getLoginFieldText() {
        return getFieldText(loginField);
    }

    public String getPasswordFieldText() {
        return getFieldText(passwordField);
    }

    public void fillLoginField(String text) {
        clickLoginField();
        fillFieldWithText(loginField, text);
    }

    public void fillPasswordField(String text) {
        clickPasswordField();
        fillFieldWithText(passwordField, text);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }
}
