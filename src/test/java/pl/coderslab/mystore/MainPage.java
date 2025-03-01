package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Hummingbird printed sweater']")
    WebElement hummingbirdPrintedSweater;

    @FindBy(className = "account")
    WebElement userAccount;


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setHummingbirdPrintedSweater(){
        hummingbirdPrintedSweater.click();
    }
    public void setUserAccount(){
        userAccount.click();
    }


}
