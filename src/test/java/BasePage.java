import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
public abstract  boolean isLoaded();

}
