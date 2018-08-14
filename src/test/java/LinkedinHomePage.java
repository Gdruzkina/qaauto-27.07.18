import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {

    private WebDriver driver;
    private WebElement profileNavigationItem;

    public LinkedinHomePage (WebDriver driver){
        this.driver = driver;
        initElements ();

    }
    private void initElements (){
        profileNavigationItem = driver.findElement(By.xpath("//*[@id='profile-nav-item']"));

    }


    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();

    }
    public boolean isLoaded(){
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageUrl().contains("/feed/");

    }
}