package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class LoginTests extends TestBase {

    @Test (groups = "smoke")
    public void testValidCredentials() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test (groups = "smoke")
    public void testInvalidCredentials() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().login("invalidUser", "invalidPassword");
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoUsername() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().login("", ConfigReader.getProperty("password"));
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().login(ConfigReader.getProperty("username"), "");
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCredentials() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().login("", "");
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

}


