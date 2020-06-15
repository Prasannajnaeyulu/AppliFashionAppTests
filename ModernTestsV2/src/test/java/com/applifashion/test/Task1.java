package com.applifashion.test;

import com.applifashion.test.util.BaseTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class Task1 extends BaseTest {
    @Test(testName = "Cross Device Elements Test")
    public void crossDeviceElementsTest(){
        try {
            // Call Open on eyes to initialize a test session
            eyes.open(webDriver, "AppliFashionApp", "Task1", new RectangleSize(800, 600));

            // check the login page with fluent api, see more info here
            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            eyes.check(Target.window().fully().withName("Cross Browser Testing Demo App Home Page"));

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();

        } finally  {
            eyes.abortAsync();
        }
    }
}
