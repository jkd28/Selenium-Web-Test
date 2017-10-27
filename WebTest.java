import java.util.logging.*;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;

public class WebTest {
    public String TEST_SITE = "https://cs1632ex.herokuapp.com/";

    static WebDriver driver = new HtmlUnitDriver();

    // Connect to site before each tests
    @Before
    public void setup(){
        // Turn off logging to avoid unnecessary warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        driver.get(TEST_SITE);
    }

    // Given that I am on the homepage,
    // When I view the page,
    // Then I see that some messages are displayed.
    @Test
    public void testHomepageTextDisplay(){
        WebElement calculationMessage = driver.findElement(By.cssSelector("p.lead"));
        WebElement usedMessage = driver.findElement(By.cssSelector("div.row > p.lead"));
        assertTrue((calculationMessage.getText().replace("\n", " ")).contains("Welcome, friend, to a land of pure calculation."));
        assertTrue((usedMessage.getText().replace("\n", " ")).contains("Used for CS1632 Software Quality Assurance, taught by Bill Laboon"));
    }

    // Given that when I am on any page,
    // When I look at the navigation bar,
    // Then I see 5 distinct links
    @Test
    public void testLinksDisplayed() {
        List<String> expectedLinks = Arrays.asList("", "fact", "fib", "hello", "cathy");
        List<WebElement> linkTags = driver.findElements(By.tagName("a"));

        for(WebElement link : linkTags) {
            if (!expectedLinks.contains(link.getAttribute("href").replace(TEST_SITE, ""))) {
                fail("One or more links missing");
            }
        }
    }
}
