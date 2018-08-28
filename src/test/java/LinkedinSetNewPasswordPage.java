import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSetNewPasswordPage extends  BasePage{

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newpassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement repeatNewPassword;

    public LinkedinSetNewPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return newpassword.isDisplayed()
                && getCurrentPageTitle().contains("Изменить пароль | LinkedIn")
                && getCurrentPageUrl().contains("/checkpoint/rp/password-reset?requestSubmissionId");
    }

}
