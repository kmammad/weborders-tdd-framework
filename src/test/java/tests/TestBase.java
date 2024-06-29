package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.time.Duration;

public class TestBase {

    /**
     * This class contains common configuration methods for all other test classes in this framework
     * All Test classes should extend this class to obtain the common configurations
     * (ensures maintainability)
     */

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.quitDriver();
    }
}
