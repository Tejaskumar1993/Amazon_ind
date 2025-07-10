package com.example.amazon_ind.tests;

import com.example.amazon_ind.base.BaseTest;
import com.example.amazon_ind.pages.*;
import com.example.amazon_ind.utils.ConfigReader;
import com.example.amazon_ind.utils.DBUtil;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        // Navigate to Amazon India
        driver.get(ConfigReader.get("amazon.url"));

        String product = DBUtil.getProductFromDB();
        System.out.println("Product from DB: " + product);

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(product);

        SearchResultPage resultPage = new SearchResultPage(driver);
        resultPage.applyFilters(); // Optional filter
        resultPage.clickFirstProduct();

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.validateProductInCart(product);
    }
}
