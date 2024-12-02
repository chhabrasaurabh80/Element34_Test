package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import javax.lang.model.element.Element;

public class BingSearchTest extends BaseTest {

    @Test
    public void testBingSearch() {
        driver.get("https://www.bing.com");
        driver.findElement(By.name("q")).sendKeys("Element34");
        driver.findElement(By.name("q")).submit();

        // Assertion 1: Verify the Search Result has link "www.element34'"
        WebElement link= driver.findElement(By.xpath("(//a[contains(@href,'www.element34')])[1]"));
        Assert.assertTrue(link.isDisplayed(), "Page does not search 'Element34'");

        // Assertion 2: Verify the Bing logo is displayed
        WebElement bingo_logo= driver.findElement(By.xpath("//h1[@class='b_logo']"));
        Assert.assertTrue(bingo_logo.isDisplayed(), "Bing logo is not displayed");
    }
}