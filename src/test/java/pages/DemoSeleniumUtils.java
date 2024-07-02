package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.CSVReader;
import utilities.SeleniumUtils;

import java.util.Arrays;

public class DemoSeleniumUtils {

    @Test
    public static void headLess() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();

    driver.get("https://mockaroo.com/");

    driver.findElement(By.xpath("//a[@href='/pricing'][@class]")).click();
    }
}
