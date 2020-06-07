package com.applifashion.test;

import com.applifashions.pages.HomePage;
import com.test.util.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Task2 extends BaseTest {
    @Test(description = "Verify filter shoes by color and the product display")
    public void shoppingExperienceTest(){
        int i=0;
        Map<String, List<String>> mapActualProductPrice = new HashMap<String, List<String>>();
        HomePage homePage = new HomePage(driver);
        homePage.filterTheProducts().byColor("Black").perform();
        List<WebElement> lsProductsDisplayed = homePage.getProductsDisplayed();
        assertThat(lsProductsDisplayed.size(), is(2));

        //verify old and new prices for product
        for(WebElement element: lsProductsDisplayed){
            List<String> lsProductPrices = new ArrayList<String>();
            lsProductPrices.add(homePage.getNewPrice(element));
            lsProductPrices.add(homePage.getOldPrice(element));
            mapActualProductPrice.put("Product"+(++i), lsProductPrices);
        }
        List<String> lsActualProduct1Prices = mapActualProductPrice.get("Product1");
        List<String> lsActualProduct2Prices = mapActualProductPrice.get("Product2");
        List<String> lsExpectedProduct1Prices = new ArrayList<String>();
        lsExpectedProduct1Prices.add("$33.00");
        lsExpectedProduct1Prices.add("$48.00");
        List<String> lsExpectedProduct2Prices = new ArrayList<String>();
        lsExpectedProduct2Prices.add("$200.00");
        lsExpectedProduct2Prices.add(null);

        assertThat(lsActualProduct1Prices, equalTo(lsExpectedProduct1Prices));
        assertThat(lsActualProduct2Prices, equalTo(lsExpectedProduct2Prices));


        //verify display of cart and add to compare and favorite icons when windowsize is greater than 800
        for (WebElement element : lsProductsDisplayed) {
            //String countdown =  homePage.getText(element.findElement(By.cssSelector(".countdown")));
            Boolean addToCompare, addToFavorite, addToCart;
            String addToCompareSelector, addToFavoriteSelector, addToCartSelector;

            if(driver.manage().window().getSize().getWidth() > 800) {
                //hover on product to see the options
                homePage.hover(element);
            }

            addToCompareSelector = ".//span[text()=\"Add to compare\"]/parent::a";
            addToFavoriteSelector = ".//span[text()=\"Add to favorites\"]/parent::a";
            addToCartSelector = ".//span[text()=\"Add to cart\"]/parent::a";

            addToCompare = element.findElement(By.xpath(addToCompareSelector)).isDisplayed();
            addToFavorite = element.findElement(By.xpath(addToFavoriteSelector)).isDisplayed();
            addToCart = element.findElement(By.xpath(addToCartSelector)).isDisplayed();

            assertThat("add to compare icon is not displayed", addToCompare, is(true));
            assertThat("add to favorite icon is not displayed", addToFavorite, is(true));
            assertThat("add to cart icon is not displayed", addToCart, is(true));
        }
    }
}
