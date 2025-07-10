package com.example.amazon_ind.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilters() {
        try {
            WebElement filter = driver.findElement(By.xpath("//span[text()='New']")); // basic filter example
            if (filter.isDisplayed()) {
                filter.click();
            }
        } catch (Exception e) {
            System.out.println("Filter not found or not applicable.");
        }
    }

    public void clickFirstProduct() {
        List<WebElement> products = driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"));
        if (!products.isEmpty()) {
            products.get(0).findElement(By.cssSelector("h2 a")).click();
        }
    }
}
