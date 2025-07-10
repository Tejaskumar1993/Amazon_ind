
package com.example.amazon_ind.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(By.id("nav-cart")).click();
    }

    public void validateProductInCart(String expectedProduct) {
        String cartText = driver.findElement(By.cssSelector("span.a-truncate-cut")).getText().toLowerCase();
        Assert.assertTrue(cartText.contains(expectedProduct.toLowerCase()), "Product not found in cart!");
    }
}
