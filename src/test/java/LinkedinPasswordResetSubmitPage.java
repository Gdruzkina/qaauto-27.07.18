import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetSubmitPage extends BasePage{

        @FindBy(xpath = "//button[@id='resend-url']")
        private WebElement resendLinkButton;


        public LinkedinPasswordResetSubmitPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public boolean isLoaded() {
            try{
                sleep(5000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return resendLinkButton.isDisplayed()
                    && getCurrentPageTitle().contains("Проверьте, получили ли вы сообщение эл.&nbsp;почты со ссылкой для изменения пароля. | LinkedIn")
                    && getCurrentPageUrl().contains("checkpoint/rp/request-password-reset-submit");
        }

        public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
            String messageSubject = "Gal, данное сообщение содержит ссылку для изменения пароля";// обьявляем переменные которые будет содержать письмо  письмо которое будет содержать тему
            String messageTo = "galdruzk@gmail.com";
            String messageFrom = "security-noreply@linkedin.com";

            //GMailService gMailService = new GMailService("galdruzk@gmail.com","Parol123!");
            //gMailService.connect();
            String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
            System.out.println("Content: " + message);

            //ToDo
            return  new LinkedinSetNewPasswordPage(driver);
        }
    }

