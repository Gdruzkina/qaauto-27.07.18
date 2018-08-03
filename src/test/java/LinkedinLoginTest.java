import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class LinkedinLoginTest {

    @Test //анотация - метка для компиляторов для выполнения кода.
    public void successfulLoninTest() { //название нового метода
        // нужно подключить фреймворк-для этого следующая строка testng ето сторонняя утилита добавляется в dependencies,
        // если есть 10 кейсот то tng помогает запустить некоторые из них
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));

        userEmailField.sendKeys("galdruzk@gmail.com");

        userPasswordField.sendKeys("Parol123!");
        //sleep(3000);
        signInButton.click();


    }

    @Test //можно сразу задать структуру, количество тестов, которые я планирую выполнять
    public void negatiLoninTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='login-submit']"));


        userEmailField.sendKeys("galdruzk@gm");
        userPasswordField.sendKeys("Parol1!");
        signInButton.click(); //signInButton.sendKeys(ENTER);
        WebElement alertBox = driver.findElement(By.xpath("//*[@role='alert']"));
        Assert.assertEquals(alertBox.getText(),"1При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.","Alertbox has incorrect message");//проверка. проверка полного соответствия (текст из переменной ,
        // и тот с которым хочу сравнить, описать что пошло не так)
        //List<WebElement> errorMessage = driver.findElements(By.xpath("//*[@role='alert']");
        driver.close();
    }
}
