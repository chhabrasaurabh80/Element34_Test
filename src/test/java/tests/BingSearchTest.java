package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BingPageObject;
import utils.BaseTest;

import javax.lang.model.element.Element;

public class BingSearchTest extends BaseTest {
    BingPageObject bingPageObject = new BingPageObject();

    @Test
    public void testBingSearch() {
        Allure.step("Open bing.com and search for text-Element34 ");
        driver.get("https://www.bing.com");
        driver.findElement(By.name(bingPageObject.search_box)).sendKeys("Element34");
        driver.findElement(By.name(bingPageObject.search_box)).submit();

        Allure.step("Validated the first link is-Element34 ");
        // Assertion 1: Verify the Search Result has link "www.element34'"
        WebElement link= driver.findElement(By.xpath(bingPageObject.first_link));
        Assert.assertTrue(link.isDisplayed(), "Page does not search 'Element34'");

        Allure.step("Validated the Bing Logo displyaed ");
        // Assertion 2: Verify the Bing logo is displayed
        WebElement bingo_logo= driver.findElement(By.xpath(bingPageObject.bing_logo));
        Assert.assertTrue(bingo_logo.isDisplayed(), "Bing logo is not displayed");
    }
}
