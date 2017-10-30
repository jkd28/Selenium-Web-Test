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

    // Given that when I am on the home page,
    // When I look at the navigation bar,
    // Then I see 5 distinct links
    @Test
    public void testLinksDisplayedFromHome() {
        // Check for each link, failure if an error is thrown
        WebElement homeLink = driver.findElement(By.linkText("CS1632 D3 Home"));
        assertEquals(TEST_SITE, homeLink.getAttribute("href"));

        WebElement factLink = driver.findElement(By.linkText("Factorial"));
        assertEquals(TEST_SITE + "fact", factLink.getAttribute("href"));

        WebElement fiboLink = driver.findElement(By.linkText("Fibonacci"));
        assertEquals(TEST_SITE + "fib", fiboLink.getAttribute("href"));

        WebElement hellLink = driver.findElement(By.linkText("Hello"));
        assertEquals(TEST_SITE + "hello", hellLink.getAttribute("href"));

        WebElement cathLink = driver.findElement(By.linkText("Cathedral Pics"));
        assertEquals(TEST_SITE + "cathy", cathLink.getAttribute("href"));
    }

    // Given that when I am on the factorial page,
    // When I look at the navigation bar,
    // Then I see 5 distinct links
    @Test
    public void testLinksDisplayedFromHFact() {
        driver.get(TEST_SITE + "fact");

        // Check for each link, failure if an error is thrown
        WebElement homeLink = driver.findElement(By.linkText("CS1632 D3 Home"));
        assertEquals(TEST_SITE, homeLink.getAttribute("href"));

        WebElement factLink = driver.findElement(By.linkText("Factorial"));
        assertEquals(TEST_SITE + "fact", factLink.getAttribute("href"));

        WebElement fiboLink = driver.findElement(By.linkText("Fibonacci"));
        assertEquals(TEST_SITE + "fib", fiboLink.getAttribute("href"));

        WebElement hellLink = driver.findElement(By.linkText("Hello"));
        assertEquals(TEST_SITE + "hello", hellLink.getAttribute("href"));

        WebElement cathLink = driver.findElement(By.linkText("Cathedral Pics"));
        assertEquals(TEST_SITE + "cathy", cathLink.getAttribute("href"));
    }

    // Given that when I am on the Fibonacci page,
    // When I look at the navigation bar,
    // Then I see 5 distinct links
    @Test
    public void testLinksDisplayedFromFib() {
        driver.get(TEST_SITE + "fib");

        // Check for each link, failure if an error is thrown
        WebElement homeLink = driver.findElement(By.linkText("CS1632 D3 Home"));
        assertEquals(TEST_SITE, homeLink.getAttribute("href"));

        WebElement factLink = driver.findElement(By.linkText("Factorial"));
        assertEquals(TEST_SITE + "fact", factLink.getAttribute("href"));

        WebElement fiboLink = driver.findElement(By.linkText("Fibonacci"));
        assertEquals(TEST_SITE + "fib", fiboLink.getAttribute("href"));

        WebElement hellLink = driver.findElement(By.linkText("Hello"));
        assertEquals(TEST_SITE + "hello", hellLink.getAttribute("href"));

        WebElement cathLink = driver.findElement(By.linkText("Cathedral Pics"));
        assertEquals(TEST_SITE + "cathy", cathLink.getAttribute("href"));
    }

    // Each page should have 5 links that display at the top of the screen.
    // This test confirms those links are present from the /hello page of the site
    // by checking for each link, then checking the target of the links.
    @Test
    public void testLinksDisplayedFromHello() {
        driver.get(TEST_SITE + "hello");

        // Check for each link, failure if an error is thrown
        WebElement homeLink = driver.findElement(By.linkText("CS1632 D3 Home"));
        assertEquals(TEST_SITE, homeLink.getAttribute("href"));

        WebElement factLink = driver.findElement(By.linkText("Factorial"));
        assertEquals(TEST_SITE + "fact", factLink.getAttribute("href"));

        WebElement fiboLink = driver.findElement(By.linkText("Fibonacci"));
        assertEquals(TEST_SITE + "fib", fiboLink.getAttribute("href"));

        WebElement hellLink = driver.findElement(By.linkText("Hello"));
        assertEquals(TEST_SITE + "hello", hellLink.getAttribute("href"));

        WebElement cathLink = driver.findElement(By.linkText("Cathedral Pics"));
        assertEquals(TEST_SITE + "cathy", cathLink.getAttribute("href"));
    }


    // Each page should have 5 links that display at the top of the screen.
    // This test confirms those links are present from the /cathy page of the site
    // by checking for each link, then checking the target of the links.
    @Test
    public void testLinksDisplayedFromCathy() {
        driver.get(TEST_SITE + "cathy");

        // Check for each link, failure if an error is thrown
        WebElement homeLink = driver.findElement(By.linkText("CS1632 D3 Home"));
        assertEquals(TEST_SITE, homeLink.getAttribute("href"));

        WebElement factLink = driver.findElement(By.linkText("Factorial"));
        assertEquals(TEST_SITE + "fact", factLink.getAttribute("href"));

        WebElement fiboLink = driver.findElement(By.linkText("Fibonacci"));
        assertEquals(TEST_SITE + "fib", fiboLink.getAttribute("href"));

        WebElement hellLink = driver.findElement(By.linkText("Hello"));
        assertEquals(TEST_SITE + "hello", hellLink.getAttribute("href"));

        WebElement cathLink = driver.findElement(By.linkText("Cathedral Pics"));
        assertEquals(TEST_SITE + "cathy", cathLink.getAttribute("href"));
    }

    // This test verifies the calculation of a valid Factorial input.
    // It does so by finding the input field, entering the value 5, and
    // verifying that the correct text is displayed with a result of 120
    @Test
    public void testFactorialCalculation() {
        driver.get(TEST_SITE + "fact");

        WebElement textBox = driver.findElement(By.name("value"));
        textBox.sendKeys("5");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        WebElement result = driver.findElement(By.cssSelector("h2"));
        assertEquals("Factorial of 5 is 120!", result.getText());
    }

    // This test verifies that if invalid input (a string value) is entered into
    // the Factorial calculation, that a message displays saying that the value is
    // 1 (as per Requirement 5).

    @Test
    public void testFactorialStringInput(){
        driver.get(TEST_SITE + "fact");

        WebElement textBox = driver.findElement(By.name("value"));
        textBox.sendKeys("this should not be allowed");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        try {
            WebElement result = driver.findElement(By.cssSelector("h2"));
            assertEquals("Factorial of 5 is 1!", result.getText());
        } catch(NoSuchElementException except) {
            fail("No message printed to screen");
        }
    }

    // This test verifies the calculation of a valid Fibonacci input.
    // It does so by finding the input field, entering the value 5, and
    // verifying that the correct text is displayed with a result of 8
    @Test
    public void testFibonacciCalculation(){
        driver.get(TEST_SITE + "fib");

        WebElement textBox = driver.findElement(By.name("value"));
        textBox.sendKeys("5");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        WebElement result = driver.findElement(By.cssSelector("h2"));
        assertEquals("Fibonacci of 5 is 8!", result.getText());
    }

    // This test verifies that if invalid input (a string value) is entered into
    // the Fibonacci calculation, that a message displays saying that the value is
    // 1 (as per Requirement 5).
    @Test
    public void testFibonacciStringInput(){
        driver.get(TEST_SITE + "fact");

        WebElement textBox = driver.findElement(By.name("value"));
        textBox.sendKeys("this should not be allowed");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        try {
            WebElement result = driver.findElement(By.cssSelector("h2"));
            assertEquals("Factorial of 5 is 1!", result.getText());
        } catch(NoSuchElementException except) {
            fail("No message printed to screen");
        }
    }
}
