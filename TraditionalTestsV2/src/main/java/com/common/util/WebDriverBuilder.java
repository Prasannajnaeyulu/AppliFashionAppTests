package com.common.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class WebDriverBuilder {
    private Capabilities capabilities;
    private BrowserType browserType;
    private int browserWidth;
    private int browserHeight;
    private String platform;
    private WebDriver driver;

    public WebDriverBuilder(){
    }

    public WebDriverBuilder setBrowserCapabilities(Capabilities capabilities){
        if(this.capabilities!=null)
            this.capabilities.merge(capabilities);
        else
            this.capabilities = capabilities;

        return this;
    }

    public WebDriverBuilder setBrowser(String browser) throws Exception {
        this.browserType = BrowserType.fromString(browser);
        return this;
    }

    public WebDriverBuilder setBrowserWidth(int browserWidth){
        this.browserWidth = browserWidth;
        return this;
    }

    public WebDriverBuilder setBrowserHeight(int browserHeight){
        this.browserHeight = browserHeight;
        return this;
    }

    public WebDriverBuilder setPlatform(String platform){
        this.platform = platform;
        return this;
    }

    public WebDriver build() throws Exception {
        StringBuilder driverPath = new StringBuilder(System.getProperty("user.dir"));
        driverPath.append(File.separator+".."+File.separator+"drivers");
        switch (browserType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                        driverPath.append(File.separator+"chromedriver.exe")
                                .toString());
                driver = new ChromeDriver(ChromeDriverService.createDefaultService(),
                        new ChromeOptions().merge(capabilities).merge(DesiredCapabilities.chrome()));
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",
                        driverPath.append(File.separator+"geckodriver.exe")
                                .toString());
                driver = new FirefoxDriver(new FirefoxOptions().merge(capabilities));
                break;
            case CHROMIUM_EDGE:
                System.setProperty("webdriver.edge.driver",
                        driverPath.append(File.separator+"edgedriver.exe")
                                .toString());
                driver = new EdgeDriver(EdgeDriverService.createDefaultService(),
                        new EdgeOptions().merge(capabilities).merge(DesiredCapabilities.edge()));
                break;
            default:
                throw new Exception("The given BrowserType: "+ browserType.toString()+" is not supported");
        }
        driver.manage().window().setSize(new Dimension(this.browserWidth, this.browserHeight));
        return driver;
    }
}
