package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSearchPage;

import java.util.List;

public class LinkedinSearchTest {

    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    /**
     * Verify successful searh
     * - Login
     * - Search
     */

    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(
                "galdruzk@gmail.com",
                "Parol123!");
        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "Home page is not loaded.");

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search("HR");

        Assert.assertTrue(linkedinSearchPage.isLoaded(),
                "Search page is not loaded.");

        Assert.assertEquals(linkedinSearchPage.getSearchResultsCount(), 10,
                "Search results count is wrong.");
        List<String> searchResults = linkedinSearchPage.getSearchResultsList();
        for (String searchResult: searchResults){
            Assert.assertTrue( searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm "+searchTerm+" not found in:\n"+searchResult);
        }

    }
}