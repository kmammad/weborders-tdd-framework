package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    /**
     * This class contains common configuration methods for all other test classes in this framework
     * All Test classes should extend this class to obtain the common configurations
     * (ensures maintainability)
     */

    protected static ExtentReports extentReports; // report manager

    protected static ExtentSparkReporter htmlReport; // manages the html report

    protected static ExtentTest logger; // logs the test steps

    @BeforeSuite (alwaysRun = true)
    public void setUpSuite(){
        extentReports = new ExtentReports();
        htmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/extentReport/report.html");
        extentReports.attachReporter(htmlReport);
        extentReports.setSystemInfo("Project Name", "Web Orders Test Automation");
        extentReports.setSystemInfo("SDETs: ", "John Doe, Jane Smith");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Browser",
                System.getProperty("browser") == null ? ConfigReader.getProperty("browser") : System.getProperty("browser") );

        extentReports.setSystemInfo("Homepage", FrameworkConstants.HOMEPAGE_URL);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDownSuite(){
        extentReports.flush(); // flush means writing to a disc
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger = extentReports.createTest("Test: " + method.getName());
        logger.info("TEST STARTED: " + method.getName()); // info logging says what is happening

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            logger.pass("TEST PASSED: " + testResult.getName());

        } else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.fail("TEST SKIPPED: " + testResult.getName());

        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            logger.skip("TEST FAILED: " + testResult.getName());
            logger.fail(testResult.getThrowable());
            //take a screenshot
            String pathOfScreenshotFile = SeleniumUtils.getScreenshot("failed");
            logger.addScreenCaptureFromPath(pathOfScreenshotFile);
        }

        Driver.quitDriver();
    }


    }
