package com.applifashion.test;

import com.applifashion.test.util.BaseTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Task2 extends BaseTest {
    @Test(testName = "Filter Results")
    public void filterResultsTest(){
        try {
            // Call Open on eyes to initialize a test session
            eyes.open(webDriver, "AppliFashionApp", "Task2", new RectangleSize(800, 600));

            try {
                webDriver.findElement(By.xpath("//li/a[@class='open_filters']")).click();
            }
            catch (Exception e){
            }

            webDriver.findElement(By.id("colors__Black")).click();
            webDriver.findElement(By.id("filterBtn")).click();
            // check the login page with fluent api, see more info here
            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            eyes.check(Target.window().fully().withName("Cross Browser Testing Demo App Filter Results"));

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }
    }
}
