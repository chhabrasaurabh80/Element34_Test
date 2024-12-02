package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("q")).submit();

        // Assertion 1: Verify the page contains link "selenium.dev"
        WebElement link= driver.findElement(By.xpath("(//a[contains(@href,'www.selenium.dev/')])[1]"));
        Assert.assertTrue(link.isDisplayed(), "Page does not search 'selenium.dev'");

        // Assertion 2: Verify the Google logo is displayed
        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed(), "Google logo is not displayed");
    }
}
