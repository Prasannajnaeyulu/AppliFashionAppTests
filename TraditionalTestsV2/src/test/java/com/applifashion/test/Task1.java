package com.applifashion.test;

import com.applifashions.pages.HomePage;
import com.test.util.BaseTest;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Task1 extends BaseTest {
    @Test(description = "Verify Search field visibility")
    public void crossDeviceElementsTest1(){
        HomePage homePage = new HomePage(driver);
        Dimension windowSize = driver.manage().window().getSize();
        if(windowSize.getWidth() > 800)
            assertThat(homePage.isElementDisplayed(homePage.searchBox), is(true));
        else
            assertThat(homePage.isElementDisplayed(homePage.searchBox), is(false));
    }

    @Test(description = "Verify filter image toggle visibility")
    public void crossDeviceElementsTest2(){
        HomePage homePage = new HomePage(driver);
        Dimension windowSize = driver.manage().window().getSize();
        if(windowSize.getWidth() > 800)
            assertThat(homePage.isElementDisplayed(homePage.filterImageToggle), is(false));
        else
            assertThat(homePage.isElementDisplayed(homePage.filterImageToggle), is(true));
    }
}
