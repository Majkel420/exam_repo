package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage {
    private final WebDriver driver;

    @FindBy(className = "table-striped")
    WebElement orderHistoryTable;

    @FindBy(id = "history-link")
    WebElement goToOrderHistoryAndDetails;

    public OrderHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setGoToOrderHistoryAndDetails(){
        goToOrderHistoryAndDetails.click();
    }

    public String getFirstRowTable(){
        WebElement table = orderHistoryTable;
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement firstRow = rows.get(1);
        String rawText = firstRow.getText();
        return rawText;
    }
}
