import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException { //плохой тон пользоваться методом main
        System.out.print("Hello World!!!");//этим не пользуются System.out нужно использовать логирование(может попоже если будет время)
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");

        //Verify that results list contains 10 elements
        element.sendKeys(ENTER);
        sleep(3000);// всячески избегать можно использовать с методом wait, на разных машинах разное время, нужно использовать очень грамотно
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Результат: " + searchResults.size());
        if (searchResults.size() >= 10) {
            System.out.println(" Results count is correct");
        } else {
            System.out.println(" Results count is incorect");
        }
        // Verify that each result item contains searchtem
        // for each serchResults in searchResult list
        for (WebElement searchResult : searchResults) {
            String serchResultText = searchResult.getText();
            System.out.println(serchResultText);
            if (serchResultText.contains("Selenium")) {
                //if(searchRusulText.toLowerCase().contains("selenium"))
                System.out.println("SearchTerm found");
            }
            else {
                System.out.println("SearchTerm not found");
            }
        }

        driver.close();
    }


}
///https://www.linkedin.com/feed/?trk=onboarding-landing
//Gal Druzk / Parol123!
//Galdruz@gmail.com Parol123!