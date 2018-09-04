package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSetNewPasswordPage extends BasePage{
    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public LinkedinSetNewPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
/**
        * Class to check if required element on page is displayed.
            * @return true/false when reqiered element on page is/is not displayed.
     */
    public boolean isLoaded() {
        //Fixme
        return resendLinkButton.isDisplayed()
                && getCurrentPageTitle().equals("Проверьте, получили ли вы сообщение эл. почты со ссылкой для изменения пароля. | LinkedIn")
                && getCurrentPageUrl().contains("checkpoint/rp/request-password-reset-submit");
    }
}