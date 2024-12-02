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

        // Assertion 1: Verify the page title contains "Selenium WebDriver"
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Page title does not contain 'Selenium WebDriver'");

        // Assertion 2: Verify the Google logo is displayed
        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed(), "Google logo is not displayed");
    }
}