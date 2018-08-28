import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;
public class LinkedinForgotPasswordPage extends BasePage {
    @FindBy(xpath = "//header[@class='content__header']")
    private WebElement contentHeader;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInputField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public LinkedinForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public LinkedinResetPasswordPage getResetPasswordLinkFromUserEmail(){
        usernameInputField.sendKeys("galdruzk@gmail.com");
        resetPasswordSubmitButton.click();
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinResetPasswordPage(driver);
    }
    @Override
    public boolean isLoaded() {
        return contentHeader.isDisplayed()
                && getCurrentPageTitle().contains("Изменить пароль | LinkedIn");
                //&& getCurrentPageUrl().contains("/request-password-reset");
    }
}
