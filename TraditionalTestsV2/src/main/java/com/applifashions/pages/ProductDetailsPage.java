package com.applifashions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(id="shoe_img")
    public WebElement shoeImage;

    @FindBy(id="new_price")
    public WebElement newPrice;

    @FindBy(id="old_price")
    public WebElement oldPrice;

    @FindBy(id="discount")
    public WebElement discount;

    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    public boolean shoeImageDisplayed(){
        return isElementDisplayed(shoeImage);
    }
}
