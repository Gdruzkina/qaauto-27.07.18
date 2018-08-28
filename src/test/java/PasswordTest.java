import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasswordTest {
        WebDriver driver;
        LinkedinLoginPage linkedinLoginPage;

        @BeforeMethod
        public void beforeMethod() {
            driver = new FirefoxDriver();
            driver.get("https://www.linkedin.com/");
            linkedinLoginPage = new LinkedinLoginPage(driver);
        }

        @AfterMethod
        public void afterMethod() {
            driver.close();
        }

        @Test
        public void successfulResetPasswordTest() {
            Assert.assertTrue(linkedinLoginPage.isLoaded(), "LinkedinLoginPage is not loaded");

            LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
            Assert.assertTrue(linkedinRequestPasswordResetPage.isLoaded(), "LinkedinRequestPasswordResetPage is loaded");

            LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinRequestPasswordResetPage.findAccount("galdruzk@gmail.com");
            Assert.assertTrue(linkedinPasswordResetSubmitPage.isLoaded(), "PasswordResetSubmintPage is loaded");

            LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinPasswordResetSubmitPage.navigateToLinkFromEmail();
            Assert.assertTrue(linkedinSetNewPasswordPage.isLoaded(), "SetNewPasswordPage  is not loaded");


        }


    }

