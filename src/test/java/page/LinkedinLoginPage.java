package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for LinkedinLoginPage
 */
public class LinkedinLoginPage extends BasePage {
    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor of LinkedinLoginPage class.
     * @param browser - WebDriver instance from test.
     */

    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
        waitUntilElementIsVisible(userEmailField, 10);
    }

    /**
     * Method that enters userEmail/userPass and click on singIn button.
     * @param userEmail -  String with user Email.
     * @param userPass -  String with user Pass.
     * @param <T>  - Generic type to return corresponding pageObject
     * @return eithher LinkedinHomePage or LinkedinLoginSubmitPage or LinkedinLoginPage pageObject.
     */
    public <T> T login(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        if (getCurrentPageUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(browser);
        }
        if (getCurrentPageUrl().contains("/uas/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(browser);
        } else {
            return (T) new LinkedinLoginPage(browser);
        }
    }

    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */

    public boolean isLoaded() {
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться");
    }

    /**
    * Method for click on Forgot Password link.
     * @return LinkedinRequestPasswordResetPage
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {

        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(browser);
    }
}