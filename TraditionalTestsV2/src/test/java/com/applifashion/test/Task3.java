package com.applifashion.test;

import com.applifashions.pages.HomePage;
import com.applifashions.pages.ProductDetailsPage;
import com.test.util.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Task3 extends BaseTest {
    @Test(testName = "Product Details Test", description = "Verify display of Product Details Test")
    public void productDetailsTest(){
        HomePage homePage = new HomePage(driver);
        homePage.filterTheProducts().byColor("Black").perform();
        List<WebElement> lsProductsDisplayed = homePage.getProductsDisplayed();
        SoftAssert softAssert = new SoftAssert();
        //assertThat(lsProductsDisplayed.size(), is(2));
        softAssert.assertEquals(lsProductsDisplayed.size(), 2);

        //Navigate to first shoe from displayed product list and verify its details
        WebElement firstProduct = lsProductsDisplayed.get(0);
        WebElement firstShoe = firstProduct.findElement(By.xpath(".//a[@id='product_1']"));
        homePage.clickOn(firstShoe);

        //Verify Product details
        ProductDetailsPage productDetails = new ProductDetailsPage(driver);
        softAssert.assertEquals(reporter.hackathonReporter(3,"Product Details Test", "shoe_img",browser, width+"X"+height,this.platform,productDetails.shoeImageDisplayed()), true);
        softAssert.assertEquals(reporter.hackathonReporter(3,"Product Details Test", "quantity_1",browser, width+"X"+height,this.platform,productDetails.isElementDisplayed(By.id("quantity_1"))), true);
        softAssert.assertEquals(reporter.hackathonReporter(3,"Product Details Test", ".btn_add_to_cart",browser, width+"X"+height,this.platform,productDetails.isElementDisplayed(By.cssSelector(".btn_add_to_cart"))), true);
        softAssert.assertEquals(productDetails.getText(productDetails.newPrice), "$33.00");
        softAssert.assertEquals(productDetails.getText(productDetails.oldPrice), "$48.00");
        softAssert.assertEquals(productDetails.getText(productDetails.discount), "-30% discount");
        softAssert.assertAll();
        /*
        assertThat("The shoe image should be displayed", reporter.hackathonReporter(3,"Product Details Test", "shoe_img",browser, width+"X"+height,this.platform,productDetails.shoeImageDisplayed()), is(true));
        assertThat("Quantity select option should be displayed", reporter.hackathonReporter(3,"Product Details Test", "quantity_1",browser, width+"X"+height,this.platform,productDetails.isElementDisplayed(By.id("quantity_1"))), is(true));
        assertThat("Add to Cart Button should be displayed", reporter.hackathonReporter(3,"Product Details Test", ".btn_add_to_cart",browser, width+"X"+height,this.platform,productDetails.isElementDisplayed(By.cssSelector(".btn_add_to_cart"))), is(true));
        assertThat(productDetails.getText(productDetails.newPrice), is("$33.00"));
        assertThat(productDetails.getText(productDetails.oldPrice), is("$48.00"));
        assertThat(productDetails.getText(productDetails.discount), is("-30% discount"));*/
    }
}
