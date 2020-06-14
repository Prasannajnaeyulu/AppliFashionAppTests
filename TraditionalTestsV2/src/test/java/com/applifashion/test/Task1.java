package com.applifashion.test;

import com.applifashions.pages.HomePage;
import com.test.util.BaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Task1 extends BaseTest {
    @Test(testName = "Cross Device Elements Test 1", description = "Verify Search field visibility")
    public void crossDeviceElementsTest1(){
        HomePage homePage = new HomePage(driver);
        if(this.platform.equalsIgnoreCase("laptop")) {
            assertThat("Search Box Should be displayed",reporter.hackathonReporter(1,"Cross Device Elements Test 1",
                    "INPUTtext____42",browser, width+"X"+height,this.platform,
                    homePage.isElementDisplayed(homePage.searchBox)), is(true));
        }
        else {
            assertThat("Search Box Should NOT be Displayed",reporter.hackathonReporter(1,"Cross Device Elements Test 1",
                    "INPUTtext____42", browser, width+"X"+height,this.platform,
                    homePage.isElementDisplayed(homePage.searchBox)), is(false));
        }
    }

    @Test(testName = "Cross Device Elements Test 2", description = "Verify filter image toggle visibility")
    public void crossDeviceElementsTest2(){
        HomePage homePage = new HomePage(driver);
        if(this.platform.equalsIgnoreCase("laptop"))
            assertThat("filter Image to filter products should NOT be displayed", reporter.hackathonReporter(1,"Cross Device Elements Test 2", "ti-filter",browser, width+"X"+height,this.platform,homePage.isElementDisplayed(homePage.filterImageToggle)), is(false));
        else
            assertThat("filter Image to filter products should be displayed", reporter.hackathonReporter(1,"Cross Device Elements Test 2", "ti-filter",browser, width+"X"+height,this.platform,homePage.isElementDisplayed(homePage.filterImageToggle)), is(true));
    }
}
