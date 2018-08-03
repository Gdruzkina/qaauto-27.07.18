import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

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
        System.out.println("Результат: " + searchResults.size());// вывести результат теста обьеденили две строки
        if (searchResults.size() >= 10) {
            System.out.println(" Results count is correct");
        } else {
            System.out.println(" Results count is incorect");
        }
        for (WebElement searchResult : searchResults) { //поиск в цикле нашего значениея и выведение его результатов
            String serchResultText = searchResult.getText();
            //if
            System.out.println(serchResultText);
            if (serchResultText.contains("Selenium")) {
                System.out.println("Searchterm found");
            }
            else {
                System.out.println("Searchterm not found");
            }
//            WebElement userName = driver.findElements(By.xpath("//input"));


        }
//метод контейнс последовательности
        //
        driver.close();
    }


}
