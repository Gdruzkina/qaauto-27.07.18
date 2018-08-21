import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinkedinSearchPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'search-result__')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;

    public LinkedinSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isLoaded() {
        return searchResultsTotal.isDisplayed()
                    && getCurrentPageTitle().contains("\"HR\" | Поиск | LinkedIn")
                    && getCurrentPageUrl().contains("/search/results/");
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }
}
