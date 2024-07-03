package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.AllProductsTests;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllProductsPage {

    public AllProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
  @FindBy (xpath = "//table[@class='ProductsTable']//th")
  private List<WebElement> elements;
//  private List<WebElement> elements =
//          Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//th"));

    //@Data will provide getters
//    public List<WebElement> getHeaders() {
//        return elements;
//    }

    public List<String> extractHeadersText(){
        return SeleniumUtils.getElementsText(elements);
    }


}
