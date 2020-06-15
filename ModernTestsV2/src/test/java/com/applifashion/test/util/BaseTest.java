package com.applifashion.test.util;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    protected Eyes eyes;
    private VisualGridRunner runner;

    //Going to create webdriver instance before every test method
    @BeforeMethod
    public void setup(){
        StringBuilder driverPath = new StringBuilder(System.getProperty("user.dir"));
        driverPath.append(File.separator+".."+File.separator+"drivers");
        System.setProperty("webdriver.chrome.driver",
                driverPath.append(File.separator+"chromedriver.exe")
                        .toString());
        // Create a new chrome web driver
        webDriver = new ChromeDriver();

        // Create a runner with concurrency of 1
        runner = new VisualGridRunner(10);

        // Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
        eyes = new Eyes(runner);

        // Initialize eyes Configuration
        Configuration config = new Configuration();

        // You can get your api key from the Applitools dashboard
        config.setApiKey("qZF2aq5v49yq935lxqhbAUJhBLr04VBPR1zNKbrn9jc110");

        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo("UFG Hackathon"));

        // Add browsers with different viewports
        config.addBrowser(1200, 700, BrowserType.CHROME);
        config.addBrowser(1200, 700, BrowserType.FIREFOX);
        config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(768, 700, BrowserType.CHROME);
        config.addBrowser(768, 700, BrowserType.FIREFOX);
        config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
        // Add device emulation with portrait
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        // Set the configuration object to eyes
        eyes.setConfiguration(config);
        // Navigate to the url we want to test
        webDriver.get("https://demo.applitools.com/gridHackathonV2.html");
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    //Destroy webdriver instance after every test method
    @AfterMethod
    public void tearDown(){
        // Close the browser
        webDriver.quit();

        // we pass false to this method to suppress the exception that is thrown if we
        // find visual differences
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }
}
