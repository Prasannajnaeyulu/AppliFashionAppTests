package com.test.util;

import com.common.util.Reporter;
import com.common.util.WebDriverBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String browser, URL;
    protected int width, height;
    protected Reporter reporter;
    //Going to create webdriver instance before every test method
    @Parameters({"browser", "URL", "width", "height"})
    @BeforeMethod
    public void setup(String browser, String URL, int width, int height) throws Exception {
        this.browser = browser;
        this.URL = URL;
        this.width = width;
        this.height = height;
        this.reporter = new Reporter();
        Capabilities capabilities = new DesiredCapabilities();
        ((DesiredCapabilities) capabilities).setAcceptInsecureCerts(true);
        ((DesiredCapabilities) capabilities).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ((DesiredCapabilities) capabilities).setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        driver = new WebDriverBuilder().
                                        setBrowser(browser).
                                        setBrowserWidth(width).
                                        setBrowserHeight(height).
                                        setBrowserCapabilities(capabilities).
                                        build();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    //Destroy webdriver instance after every test method
    @AfterMethod
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
