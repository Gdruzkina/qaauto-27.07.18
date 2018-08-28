import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetPage extends BasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public LinkedinRequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && getCurrentPageTitle().contains("Изменить пароль | LinkedIn")
                && getCurrentPageUrl().contains("/uas/request-password-reset");
    }

    public  LinkedinPasswordResetSubmitPage findAccount(String userEmail){

        gMailService = new GMailService("galdruzk@gmail.com","Parol123!");
        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        return  new LinkedinPasswordResetSubmitPage (driver);
    }
}