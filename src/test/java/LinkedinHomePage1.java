import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage1 {
    WebDriver driver;


    public LinkedinHomePage(WebDriver driver) {
        this.driver = driver;
        elementsDoshboard();
    }

    public void elementsDoshboard() {

        profileNavigationItem = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));// обьявляем вебелемент

    }

}
