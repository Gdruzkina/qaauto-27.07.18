import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LinkedinPasswordResetTest {
    private WebDriver driver;
    private LinkedinLoginPage linkedinLoginPage;
    public LinkedinForgotPasswordPage linkedinForgotPasswordPage;
    public LinkedinResetPasswordPage linkedinResetPasswordPage;
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
    public void passwordResetTest() {
        linkedinForgotPasswordPage = linkedinLoginPage.useForgotPasswordLink();
        Assert.assertTrue(linkedinForgotPasswordPage.isLoaded(), "Forgot password page is not loaded.");
        linkedinResetPasswordPage =  linkedinForgotPasswordPage.getResetPasswordLinkFromUserEmail();
        Assert.assertTrue(linkedinResetPasswordPage.isLoaded(), "Reset password page is not loaded.");
    }
    }
