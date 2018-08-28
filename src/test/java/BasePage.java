import org.openqa.selenium.WebDriver;
import util.GMailService;

public abstract class BasePage {
    protected WebDriver driver;
    protected GMailService  gMailService;

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
public abstract  boolean isLoaded();

}
