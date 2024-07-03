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
    public void verifyColumns() throws InterruptedException {
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
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();

        new HomePage().clickOnLink("View all products");

        List<String> actualFirstColumnText = new AllProductsPage().extractFirstColumnText();

        Assert.assertEquals(actualFirstColumnText, List.of("MyMoney", "FamilyAlbum", "ScreenSaver"));
    }
}
