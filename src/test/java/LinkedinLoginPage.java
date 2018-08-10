import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage {
    // нужно подключить фреймворк-для этого следующая строка testng ето сторонняя утилита добавляется в dependencies,
    // если есть 10 кейсот то tng помогает запустить некоторые из них
    WebDriver driver;
    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;


    public LinkedinLoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        signInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));

    }

    public void login(String userName, String userPass){
        userEmailField.sendKeys(userName); //"galdruzk@gmail.com");
        userPasswordField.sendKeys(userPass); //"Parol123!");
        //sleep(3000);
        signInButton.click();
        //sleep(5000);
    }


    public static class LinkedinDasboardPage {
        WebDriver driver;
        String checKURL;
        String pageTitle;
        WebElement profileNavigationItem;

        public LinkedinDasboardPage(WebDriver driver) {
            this.driver = driver;
            elementsDoshboard();
        }

        public void elementsDoshboard() {
            checKURL = driver.getCurrentUrl();//обьявляем переменную
            pageTitle = driver.getTitle();//Обьявляем переменную
            profileNavigationItem = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));// обьявляем вебелемент

        }

        public void chekElements() {
            Assert.assertEquals(checKURL, "https://www.linkedin.com/feed/", "1.You haven't correct login URL");// сравниваем  значения с переменной и ОР
            //System.out.println("Results " + checKURL);
            Assert.assertEquals(pageTitle, "LinkedIn", "2.You haven't correct home page title");//сравниваем значение из переменной и ОР
            //System.out.println("Results " + pageTitle);
            //Assert.assertEquals(profileNavigationItem.isDisplayed(), true);// тоже самое что и сторока ниже
            Assert.assertTrue(profileNavigationItem.isDisplayed(), "'profileNavigationItem' is not displayed on Home page");// тожесамое  что и предыдущая строка

        }

    }
}
