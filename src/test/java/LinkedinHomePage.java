
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinHomePage extends BasePage {


    @FindBy(xpath = "//*[@id='profile-nav-item']") ////*[@id="nav-settings__dropdown-trigger"]
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//input[@placeholder='Поиск' and @role]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='ember3773']")  // "//*[class='link-forgot-password']"
     private WebElement navigationSettingsAccounts;
    //<a id="ember3773" data-control-name="nav.settings_account_manage_account" target="_blank" href="https://www.linkedin.com/psettings/" class="block ember-view">                  Настройки и конфиденциальность




    public LinkedinHomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isLoaded(){
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageUrl().contains("/feed/");

    }

    public LinkedinSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinSearchPage(driver);
    }

    }