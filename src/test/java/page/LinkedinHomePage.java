package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinHomePage extends BasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//input[@placeholder='Поиск' and @role]")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchField, 10);

    }
    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    public boolean isLoaded() {
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageUrl().contains("/feed/");
    }

    public LinkedinSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        return new LinkedinSearchPage(browser);
    }
}