package com.applifashions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriverWait defaultExplicitWait;
    protected WebDriver driver;
    protected BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
         defaultExplicitWait = new WebDriverWait(driver, 10);
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isElementDisplayed(By elementLocator){
        WebElement element = defaultExplicitWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        return element.isDisplayed();
    }

    public void javaScriptClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript( "arguments[0].click();", element);
    }

    public void clickOn(WebElement element){
        defaultExplicitWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void clickOn(By elementLocator){
        WebElement element = defaultExplicitWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        javaScriptClick(element);
    }

    public String getText(WebElement element, By elementLocator){
        try{
            return element.findElement(elementLocator).getText();
        }
        catch (Exception e){
            return null;
        }
    }

    public String getText(WebElement element){
        try{
            return element.getText();
        }
        catch (Exception e){
            return null;
        }
    }

    public void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
