package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetSubmitPage extends BasePage {
    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public LinkedinPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    public boolean isLoaded() {
        try {
            sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resendLinkButton.isDisplayed()
                && getCurrentPageTitle().contains("Мы отправили вам ссылку по эл. почте")
                && getCurrentPageUrl().contains("request-password-reset-submit");
    }

    /**
     *
     * @return LinkedinSetNewPasswordPage
     */

    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "galdruzk@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordLink =
                StringUtils.substringBetween(message,
                        "To change your LinkedIn password, click <a href=\"<a href=&quot;",
                        ">[text]</a>").replace("amp;", "");

        browser.get(resetPasswordLink);
        return new LinkedinSetNewPasswordPage(browser);
    }
}