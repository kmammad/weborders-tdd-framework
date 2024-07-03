package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "View all products")
    private WebElement allOrdersLink;
    //private WebElement allOrdersLink = Driver.getDriver().findElement(By.linkText("View all products"));

    public void clickOnLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    private WebElement uncheckAllButton;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    private WebElement deleteSelectedButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> allCheckboxes;





}
