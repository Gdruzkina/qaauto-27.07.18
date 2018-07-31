import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
//import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.print("Hello World!!!");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");//go to the page
        WebElement element = driver.findElement(By.name("q"));//finde element name g
        element.sendKeys("Selenium");//insert value in the field
        element.sendKeys(ENTER);//press enter
        sleep(3000);//wait for 3 sec
        //Verify that results list contacts 10 elemwnts
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']")); //создана переменная? которая подсчитает количество елементов
        System.out.print("Results count: "+searchResults.size()); // вывести результат теста обьеденили две строки
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        for (WebElement searchResult: searchResults) { //поиск в цикле нашего значениея и выведение его результатов
            String serchResultText = searchResult.getText();
            System.out.print(serchResultText);
        }
//метод контейнс последовательности
        //
        driver.close();
    }


}
