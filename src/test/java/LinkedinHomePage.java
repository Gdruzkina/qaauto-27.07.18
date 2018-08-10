import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LinkedinHomePage {

        WebDriver driver;
        String checURL;
        String pageTitle;
        WebElement profileNavigationItem;

        public LinkedinHomePage(WebDriver driver) {
            this.driver = driver;
            elementsDoshboard();
        }

        public void elementsDoshboard() {
            checURL = driver.getCurrentUrl();//обьявляем переменную
            pageTitle = driver.getTitle();//Обьявляем переменную
            profileNavigationItem = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));// обьявляем вебелемент

        }

        public void isProfileNavigatioItemDisplayed() {
            Assert.assertEquals(checURL, "https://www.linkedin.com/feed/", "1.You haven't correct login URL");// сравниваем  значения с переменной и ОР
            System.out.println("Results " + checURL);
            Assert.assertEquals(pageTitle, "LinkedIn", "2.You haven't correct home page title");//сравниваем значение из переменной и ОР
            System.out.println("Results " + pageTitle);
            //Assert.assertEquals(profileNavigationItem.isDisplayed(), true);// тоже самое что и сторока ниже
            Assert.assertTrue(profileNavigationItem.isDisplayed(), "'profileNavigationItem' is not displayed on Home page");// тожесамое  что и предыдущая строка

        }

    }


