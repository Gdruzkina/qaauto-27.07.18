import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;// мы используем те методы  что переходят между страницами и возвращают перменные страничек

import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;


    public LinkedinLoginPage(WebDriver driver) {// конструктор классаб конструктор вкотором инициализируем переменную
        this.driver = driver;
        PageFactory.initElements(driver,this);//прошу воспользоваться встроеным методом и передать два параметра браузер и считывать из этого класа
    }//

    public LinkedinHomePage loginReturnHomePage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinHomePage(driver);
    }

    public LinkedinLoginPage loginReturnLoginPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginPage(driver);
    }

    public LinkedinLoginSubmitPage loginReturnLoginSubmitPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginSubmitPage(driver);
    }

    public boolean isLoaded() {
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться");

    }
    public LinkedinForgotPasswordPage useForgotPasswordLink(){
        forgotPasswordLink.click();
        return new LinkedinForgotPasswordPage(driver);
    }


    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
    return new LinkedinRequestPasswordResetPage(driver);
    }
}