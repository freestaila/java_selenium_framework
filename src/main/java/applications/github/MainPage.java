package applications.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PageObject.BasePageObject;

public class MainPage extends BasePageObject {
    public static final String MAIN_PAGE_PATH = "https://github.com/";
    @FindBy(xpath = "//html/body/div[1]/div[4]/main/div[1]/div[2]/div/div/div[2]/h1")
    public static WebElement title;

    @FindBy(xpath = "//html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a")
    public static WebElement signInButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isDisplayed() {
        return isDisplayed(title);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }

    public void goToLoginPage() {
        clickSignInButton();
    }
}
