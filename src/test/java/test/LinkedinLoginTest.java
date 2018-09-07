package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinLoginSubmitPage;

public class LinkedinLoginTest {

    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }


    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                { "galdruzk@gmail.com", "Parol123!" },
                { "Galdruzk@gmail.com", "Parol123!" }
        };
    }

    @Test(dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {
        LinkedinHomePage linkedinHomePage =
                linkedinLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                { "", "" },
                { "", "P@ssword123" },
                { "someone@domain.com", "" }
        };
    }


    @Test(dataProvider = "emptyFieldsCombination")
    public void validateEmptyUserEmailAndUserPassword (String userEmail, String userPass) {
        linkedinLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded(),
                "User is not on Login page.");
    }

    @DataProvider
    public Object[][] invalidDataFieldsCombination() {
        return new Object[][]{
                {  "s", "p","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).","Пароль должен содержать не менее 6 символов."},
                //{ "adhad", "Passeord","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Укажите действительный адрес эл. почты.",""},
                //{"galdruzk@gmail.com","notcorrectPass","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","",
                //       "Это неверный пароль. Повторите попытку или измените пароль."},
                //{"awe@qwrtyuiop asdfghjkl,mnbvcxzasdfghjkloiuytrewqasdfghjkloiuytgh gtyhgfrtgfdcvfgbvfgbvfgbdfdfdfdfdfdffdffxfdxfdxfdxfdx fzxcvvbnnnnnnnn  nnnnnn","Pfaf","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Слишком длинный текст: максимальная длина – 128 симв., введено 143 симв.","Пароль должен содержать не менее 6 символов."},
                //{"12345678987887878","Parol123!","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Обязательно включите в номер значок «+» и код своей страны.",""},
                //{"@#$#$@$$#$@$#$$#$#$","Parol123!","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",""},
        };
    }

    @Test(dataProvider = "invalidDataFieldsCombination")
    public void validateUserEmailAndPassword(String userEmail,
                                             String userPass,
                                             String userEmailValidationText,
                                             String userPassValidationText) {
        LinkedinLoginSubmitPage linkedinLoginSubmitPage;
        linkedinLoginSubmitPage = linkedinLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(),
                "User is not on LoginSubmit page.");

        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert box has incorrect message.");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(),
                userEmailValidationText,
                "userEmail field has wrong validation message text.");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserPasswordValidationText(),
                userPassValidationText,
                "userEmail field has wrong validation message text.");

    }



}