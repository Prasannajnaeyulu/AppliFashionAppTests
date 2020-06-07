package com.applifashions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(id="INPUTtext____42")
    public WebElement searchBox;

    @FindBy(id="ti-filter")
    public WebElement filterImageToggle;

    @FindBy(xpath="//li/a[@class='open_filters']")
    public WebElement openFilter;

    @FindBy(id="filterBtn")
    public WebElement filterButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getProductsDisplayed(){
        By displayedProductsSelector = By.cssSelector("#product_grid > div");
        List<WebElement> lsDisplayedProducts = driver.findElements(displayedProductsSelector);
        return lsDisplayedProducts;
    }

    public String getNewPrice(WebElement element){
        return getText(element, By.cssSelector("div.price_box > span.new_price"));
    }

    public String getOldPrice(WebElement element){
        return getText(element, By.cssSelector("div.price_box > span.old_price"));
    }

    public HomePage filterTheProducts(){
        Dimension windowSize = driver.manage().window().getSize();
        if(windowSize.getWidth() < 800)
            clickOn(openFilter);
        return this;
    }

    public HomePage byColor(String colorName){
        By colorSelector = By.id("colors__".concat(colorName).trim());
        clickOn(colorSelector);
        return this;
    }

    public void perform(){
        clickOn(filterButton);
    }
}
