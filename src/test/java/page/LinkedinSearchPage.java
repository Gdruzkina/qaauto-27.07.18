package page;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends BasePage {


    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;


    public LinkedinSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
/**
 * Class to check if required element on page is displayed.
 * @return true/false when reqiered element on page is/is not displayed.
 */
    public boolean isLoaded() {
        return searchResultsTotal.isDisplayed()
                && getCurrentPageTitle().contains("\"HR\" | Поиск | LinkedIn\"")
                && getCurrentPageUrl().contains("/search/results/");
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public  List<String> getSearchResultsList(){
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText()) ;
        }
        return  searchResultsList;
    }
}