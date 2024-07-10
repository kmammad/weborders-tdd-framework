package tests;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class AllProductsTests extends TestBase {

    @Test (groups = "smoke")
    public void verifyColumns() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();

        new HomePage().clickOnLink("View all products");

        List<String> actualHeadersText = new AllProductsPage().extractHeadersText();
//        List<WebElement> headers = new AllProductsPage().getHeaders();
//        List<String> headersText = SeleniumUtils.getElementsText(headers);

        Assert.assertEquals(actualHeadersText, List.of("Product name", "Price", "Discount"));
    }

    @Test
    public void verifyProductNames() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter credentials");
        new LoginPage().login();

        logger.info("Click on products link");
        new HomePage().clickOnLink("View all products----");

        logger.info("Extract product names");
        List<String> actualFirstColumnText = new AllProductsPage().extractFirstColumnText();

        logger.info("Verify the product names");
        Assert.assertEquals(actualFirstColumnText, List.of("MyMoney", "FamilyAlbum", "ScreenSaver"));
    }
}
