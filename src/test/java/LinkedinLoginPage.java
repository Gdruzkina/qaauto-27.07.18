import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage {

    private WebDriver driver;

    private WebElement userEmailField;
    private WebElement userPasswordField ;
    private WebElement signInButton ;

    public LinkedinLoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements(){
        userEmailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        signInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));
    }
    public void login(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();

    }

    public boolean isLoaded(){
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться");

    }

}