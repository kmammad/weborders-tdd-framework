package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;

public class PlaceOrderTests extends TestBase {

    @Test (dataProvider = "customerData")
    public void placeOrderDataDrivenTestPageObjectModel(String fullName,
                                         String street,
                                         String city,
                                         String state,
                                         String zip,
                                         String card) throws InterruptedException {

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        new LoginPage().login();

        new HomePage().clickOnLink("Order");

        new PlaceOrderPage().enterQuantity(new Faker().number().numberBetween(1, 99));

        new PlaceOrderPage().enterNameAndAddress(fullName, street, city, state, zip);

        new PlaceOrderPage().enterPaymentInfo(card);

      //  Thread.sleep(7000);

        new PlaceOrderPage().clickProcessButton();

        Assert.assertTrue(new PlaceOrderPage().getSuccessMessage().isDisplayed());
    }

    @Test (dataProvider = "customerData")
    public void placeOrderDataDrivenTest(String fullName,
                                         String street,
                                         String city,
                                         String state,
                                         String zip,
                                         String card){

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        new LoginPage().login();

        Driver.getDriver().findElement(By.linkText("Order")).click();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).clear();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("5");

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fullName);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(card);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/27");

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("strong")).isDisplayed());
    }

    @DataProvider (name = "customerData")
    public Object[][] getData(){
        return CSVReader.readData("src/test/resources/testData/customers.csv");
    }


}
