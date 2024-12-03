package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GooglePageObject;
import utils.BaseTest;

public class GoogleSearchTest extends BaseTest {
    GooglePageObject googlePageObject = new GooglePageObject();

    @Test
    public void testGoogleSearch() {
        Allure.step("Validated the first link is-google.com ");
        driver.get("https://www.google.com");
        driver.findElement(By.name(googlePageObject.search_box)).sendKeys("Selenium WebDriver");
        driver.findElement(By.name(googlePageObject.search_box)).submit();

        Allure.step("Validated the first link is-selenium.dev ");
        // Assertion 1: Verify the page contains link "selenium.dev"
        WebElement link= driver.findElement(By.xpath(googlePageObject.first_link));
        Assert.assertTrue(link.isDisplayed(), "Page does not search 'selenium.dev'");

        Allure.step("Validated the Google Logo displyed ");
        // Assertion 2: Verify the Google logo is displayed
        Assert.assertTrue(driver.findElement(By.id(googlePageObject.google_logo)).isDisplayed(), "Google logo is not displayed");
    }
}