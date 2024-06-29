package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class LoginTests extends TestBase {

    @Test (groups = "smoke")
    public void testValidCredentials() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB,
                ConfigReader.getProperty("password"), Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test (groups = "smoke")
    public void testInvalidCredentials() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB,
                "invalid", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoUsername() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB,
                "invalid", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("cscs", Keys.TAB,
                "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCredentials() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB,
                "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

}


