import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinSearchTest {
    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        }

    @Test
    public void basicSearchTest() {
            LinkedinHomePage linkedinHomePage = linkedinLoginPage.loginReturnHomePage("galdruzk@gmail.com", "Parol123!");
            Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded");

            LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search("HR");
            Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page not loaded");
            Assert.assertEquals(linkedinSearchPage.getSearchResultsCount(), 10, "Search results count is wrong");

    }
        }

    }
}
