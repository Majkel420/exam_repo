package pl.coderslab.mystore;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class CheckoutPage {
    private final WebDriver driver;

    @FindBy(name = "confirm-addresses")
    WebElement addressContinueButton;

    @FindBy(id = "delivery_option_8")
    WebElement selfPickUpOption;

    @FindBy(id = "delivery_option_6")
    WebElement myCarrierOption;

    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryOptionButton;

    @FindBy(id = "payment-option-1")
    WebElement payByCheckOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement acceptCondictionsTermsCheckMark;

    @FindBy(css = "#payment-confirmation button.btn-primary")
    WebElement placeOrderButton;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement homeAddress;

    @FindBy(className = "text-xs-right")
    WebElement totalPrice;

    @FindBy(id = "order-reference-value")
    WebElement orderReference;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setAddressContinueButton(){
        //homeAddress.click();
        addressContinueButton.click();
    }
    public void setSelfPickUpOption(){
        myCarrierOption.click();
        selfPickUpOption.click();
    }
    public void setConfirmDeliveryOptionButton(){
        confirmDeliveryOptionButton.click();
    }
    public void setPayByCheckOption(){
        payByCheckOption.click();
    }
    public void setAcceptCondictionsTermsCheckMark(){
        acceptCondictionsTermsCheckMark.click();
    }
    public void setPlaceOrderButton(){
        placeOrderButton.click();
    }
    public String getTotalPrice(){
        return totalPrice.getText();
    }
    public String getOrderReference(){
        return orderReference.getText().replace("Order reference: ", "");
    }

    public void takeScreenshot(String filename){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\Dell\\Desktop\\Tester Automatyzujący kurs\\Podstawy_javy\\exam-project\\src\\test\\java\\pl\\coderslab" + filename + ".jpg");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

    }
}
