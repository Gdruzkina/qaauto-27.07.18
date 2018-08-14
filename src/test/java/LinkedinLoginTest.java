
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        return new Object[][]{ // инициализируем значение обьекта
                { "galdruzk@gmail.com", "Parol123!"},// говорим что будет в обьекте
                { "galdruZK@gmail.com", "Parol123!"}
        };
    }

    @Test(dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) throws InterruptedException {

        linkedinLoginPage.login(userEmail,userPass);
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
    @DataProvider
    public Object[][] emptyFieldsCombination() {//
        return new Object[][]{ // инициализируем значение обьекта
                { "", "" },// говорим что будет в обьекте
                { "", "Passeord"},
                {"dshfkhsdfkhdsk2.com",""}
        };
    }

    @Test(dataProvider = "emptyFieldsCombination")
    public void validateEmptyUserEmailAndUserPasswordl(String userEmail, String userPass) {
        linkedinLoginPage.login(userEmail,userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded() , "User is not on Login page");

    }
    @DataProvider
    public Object[][] diferentLoginAndPasswordDiferentErrorMesage() {//
        return new Object[][]{ // инициализируем значение обьекта
                { "s", "p" },{"",""},// говорим что будет в обьекте
                { "zxcvbnmlkjhgfdsaqwertyuioppoiuytrewqasdfghjkloikiujjuzxcvbnmlkjhgfdsaqwertyuioppoiuytrewqasdfghjkloikiujjuzxcvbnmlkjhgfdsaqwertyuioppoiuytrewqasdfghjkloikiujju", "Passeord"},
                {"dshfkhsdfkhdsk2.com",""}
        };
    }

    @Test
    public void validateShortUserEmailAndPassword() {

        linkedinLoginPage.login("s", "P");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(driver);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(),"User is not on LoginSubmit page");

        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message.");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(),
                "Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).", "userEmail field has wrong validation massege text");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserPasswordValidationText(),
                "Пароль должен содержать не менее 6 символов.", "userPassword field has wrong validation massege text");

    }

    }




