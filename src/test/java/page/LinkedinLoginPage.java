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
     * Metod for
     * @param userEmail - input WebElement useremail
     * @param userPass - input WebElement userPass
     * @return LinkedinLoginSubmitPage
     */
    public LinkedinLoginSubmitPage login(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        if
        return new LinkedinLoginSubmitPage(browser);
    }

    /**
     * Metod for login try from LognPage
     * @param userEmail
     * @param userPass
     * @return LinkedinHomePage
     */
    public LinkedinHomePage loginReturnHomePage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        return new LinkedinHomePage(browser);
    }

    /**
     * Method for login try from LoginPage
     * @param userEmail
     * @param userPass
     * @return LinkedinLoginPage
     */
    public LinkedinLoginPage loginReturnLoginPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        return new LinkedinLoginPage(browser);
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