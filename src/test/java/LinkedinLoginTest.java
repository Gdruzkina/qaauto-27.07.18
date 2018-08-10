import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;

public class LinkedinLoginTest {
    WebDriver driver;//обьявили переменную

    @BeforeMethod
    public void beforeMetod(){
        driver = new FirefoxDriver();//присваиваем переменной значение
        driver.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterMetod(){
        driver.close();
    }

    @Test //анотация - метка для компиляторов для выполнения кода.
    public void successfulLoginTest(){ //название нового метода

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(driver);//
        linkedinLoginPage.login("galdruzk@gmail.com","Parol123!");
        //sleep(5000);
    //HT v1
        LinkedinLoginPage.LinkedinDasboardPage linkedinDasboardPage = new LinkedinLoginPage.LinkedinDasboardPage(driver);
        linkedinDasboardPage.chekElements();

    }

    @Test
    public void homeTask (){

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(driver);//
        linkedinLoginPage.login("galdruzk@gmail.com","Parol123!");

       // HT v2
        LinkedinHomePage linkedinHomePage= new LinkedinHomePage(driver);
        linkedinHomePage.isProfileNavigatioItemDisplayed();
    }

    @Test //можно сразу задать структуру, количество тестов, которые я планирую выполнять
    public void negatiLoninTest() throws InterruptedException {


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(driver);//
        linkedinLoginPage.login("galdruk@gmail.com","Par23!");
        sleep(5000);

        WebElement alertBox = driver.findElement(By.xpath("//*[@role='alert']"));
        Assert.assertEquals(alertBox.getText(),"При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.","Alertbox has incorrect message");
        //проверка. проверка полного соответствия (текст и переменной)


    }

}

//find one webelement
//String checKURL = driver.getCurrentUrl();//обьявляем переменную
//Assert.assertEquals(checKURL, "https://www.linkedin.com/feed/" ,"1.You haven't correct login URL" );// сравниваем  значения с переменной и ОР
//System.out.println("Results " +checKURL);
//String pageTitle = driver.getTitle();//Обьявляем переменную
//Assert.assertEquals(pageTitle, "LinkedIn" ,"2.You haven't correct home page title" );//сравниваем значение из переменной и ОР
//System.out.println("Results " + pageTitle);
//WebElement profileNavigationItem = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));// обьявляем вебелемент
//Assert.assertEquals(profileNavigationItem.isDisplayed(), true);// тоже самое что и сторока ниже
//Assert.assertTrue(profileNavigationItem.isDisplayed(),"'profileNavigationItem' is not displayed on Home page");// тожесамое  что и предыдущая строка