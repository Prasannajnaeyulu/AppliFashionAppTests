package com.applifashion.test;

import com.applifashion.test.util.BaseTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Task3 extends BaseTest {
    @Test(testName = "Product Details Test")
    public void productDetailsTest(){
        try {
            // Call Open on eyes to initialize a test session
            eyes.open(webDriver, "AppliFashionApp", "Task3", new RectangleSize(800, 600));
            // For higher view ports open_filter is not available
            // Click if it exists to see filters options
            try {
                webDriver.findElement(By.xpath("//li/a[@class='open_filters']")).click();
            }
            catch (Exception e){
            }
            //filter shoes by color Black
            webDriver.findElement(By.id("colors__Black")).click();
            webDriver.findElement(By.id("filterBtn")).click();
            //Select first shoe from the display
            webDriver.findElement(By.id("product_1")).click();
            // check the login page with fluent api, see more info here
            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            eyes.check(Target.window().fully().withName("Cross Browser Testing Demo App Product Detail"));

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }
    }
}
