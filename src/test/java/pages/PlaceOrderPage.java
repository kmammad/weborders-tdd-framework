package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class PlaceOrderPage {

    public PlaceOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantityField;

    public void enterQuantity(int num){
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(num));
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement fullNameField;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetField;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityField;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateField;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zipField;

public void enterNameAndAddress(String fullName, String street, String city, String state, String zip){
    fullNameField.sendKeys(fullName);
    streetField.sendKeys(street);
    cityField.sendKeys(city);
    stateField.sendKeys(state);
    zipField.sendKeys(zip);
}

    @FindBy (id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement selectCardRadioButton;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumberField;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement cardExpiryField;


    public void enterPaymentInfo(String card){
        selectCardRadioButton.click();
        cardNumberField.sendKeys(card);
        cardExpiryField.sendKeys("12/27");
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processOrderButton;

    public void clickProcessButton(){
        processOrderButton.click();
    }

    @FindBy (tagName = "strong")
    private WebElement successMessage;

}

