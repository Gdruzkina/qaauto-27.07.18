import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    @DataProvider
    public Object[][] validFieldsCombination() {//
        return new Object[][]{
                { "galdruzk@gmail.com", "Parol123!"},
                //{ "galdruZK@gmail.com", "Parol123!"}
        };
    }

    @Test(dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) throws InterruptedException {
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.loginReturnHomePage(userEmail,userPass);
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded");
    }

    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                { "", "" },
                //{ "", "Passeord"},
               // {"dshfkhsdfkhdsk2.com",""}
        };
    }

    @Test(dataProvider = "emptyFieldsCombination")
    public void validateEmptyUserEmailAndUserPasswordl(String userEmail, String userPass) {
        linkedinLoginPage.loginReturnLoginPage (userEmail,userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded() , "User is not on Login page");

    }
    @DataProvider
    public Object[][] invalidDateShortUserEmailAndPass() {//
        return new Object[][]{
                { "s", "p","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).","Пароль должен содержать не менее 6 символов."},
                //{ "adhad", "Passeord","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Укажите действительный адрес эл. почты.",""},
                //{"galdruzk@gmail.com","notcorrectPass","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","",
                 //       "Это неверный пароль. Повторите попытку или измените пароль."},
                //{"awe@qwrtyuiop asdfghjkl,mnbvcxzasdfghjkloiuytrewqasdfghjkloiuytgh gtyhgfrtgfdcvfgbvfgbvfgbdfdfdfdfdfdffdffxfdxfdxfdxfdx fzxcvvbnnnnnnnn  nnnnnn","Pfaf","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Слишком длинный текст: максимальная длина – 128 симв., введено 143 симв.","Пароль должен содержать не менее 6 символов."},
                //{"12345678987887878","Parol123!","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Обязательно включите в номер значок «+» и код своей страны.",""},
                //{"@#$#$@$$#$@$#$$#$#$","Parol123!","При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",""},
        };
    }

    @Test(dataProvider = "invalidDateShortUserEmailAndPass")
    public void validateShortUserEmailAndPassword(String userEmail, String userPass,String correctMessage, String validationUserEmailField, String validationUserPassField)
    {
        LinkedinLoginSubmitPage  linkedinLoginSubmitPage = linkedinLoginPage.loginReturnLoginSubmitPage(userEmail,userPass);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(),"User is not on LoginSubmit page");

        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), correctMessage, "Alert box has incorrect message.");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(), validationUserEmailField, "userEmail field has wrong validation massege text");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserPasswordValidationText(), validationUserPassField, "userPassword field has wrong validation massege text");

    }

    }




