package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase{

    @Test
    public void testButtons() {

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();

        Assert.assertTrue(new HomePage().getCheckAllButton().isDisplayed());
        Assert.assertTrue(new HomePage().getUncheckAllButton().isDisplayed());
        Assert.assertTrue(new HomePage().getDeleteSelectedButton().isDisplayed());
    }

    @Test (groups = "smoke")
    public void testCheckAll() {

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();

        new HomePage().getCheckAllButton().click();

        for (WebElement checkbox : new HomePage().getAllCheckboxes()) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }

}
