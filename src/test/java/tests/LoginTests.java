package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests {

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidCredentials() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,
                "test", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentials() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,
                "invalid", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoUsername() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB,
                "invalid", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("cscs", Keys.TAB,
                "", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCredentials() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB,
                "", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

}


