package com.example.amazon_ind.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
}