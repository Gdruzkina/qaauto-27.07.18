
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {
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
    public void successfulLoginTest() throws InterruptedException {

        linkedinLoginPage.login("galdruzk@gmail.com", "Parol123!");
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(driver);
        sleep(3000);
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginTest() {

        linkedinLoginPage.login("gasd", "Paro!");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
               "При заполнении формы были допущены ошибки.Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

    }

    @Test
    public void negativeLoginTestNull() {

        linkedinLoginPage.login("", "");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки.Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

    }

    @Test
    public void negativeLoginTestWihtLogin() {

        linkedinLoginPage.login("", "Parol123!");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки.Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

    }

    @Test
    public void negativeLoginTestWihPas() {

        linkedinLoginPage.login("galdruzk", "");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки.Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

    }

    @Test
    public void negativeLoginTestNotCorrectLogin() {

        linkedinLoginPage.login("ahdhasdjhas", "Parol123!");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки.Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

        //Assert.assertTrue(linkedinLoginSubmitPage.getAlertBoxText();
    }


}

