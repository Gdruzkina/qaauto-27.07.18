import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {
    private WebDriver driver;
    private WebElement alertBox;
    private WebElement userEmailValidationText;
    private  WebElement userPasswordValidationText;

    public LinkedinLoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        alertBox = driver.findElement(By.xpath("//*[@role='alert']"));
        userEmailValidationText = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        userPasswordValidationText = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));
    }

    public String getAlertBoxText(){
        return alertBox.getText();
    }
    public String getCurrentPageTitle() { return driver.getTitle(); }

    public String getCurrentPageUrl() { return driver.getCurrentUrl(); }

    public boolean isLoaded(){
        return alertBox.isDisplayed()
                && getCurrentPageTitle().contains("Войти в LinkedIn")
                && getCurrentPageUrl().contains("/uas/login-submit");

    }

    public String getUserEmailValidationText() {
        return userEmailValidationText.getText();
    }

    public String getUserPasswordValidationText() {
        return userPasswordValidationText.getText();
    }
}
