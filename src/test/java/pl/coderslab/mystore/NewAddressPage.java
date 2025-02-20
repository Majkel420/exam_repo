package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private static WebDriver driver;

    @FindBy(id = "field-alias")
    WebElement AliasInput;

    @FindBy(id = "field-address1")
    WebElement AddressInput;

    @FindBy(id = "field-city")
    WebElement CityInput;

    @FindBy(id = "field-postcode")
    WebElement ZipInput;

    @FindBy(id = "field-phone")
    WebElement PhoneInput;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAlias(String alias){
        AliasInput.click();
        AliasInput.clear();
        AliasInput.sendKeys(alias);
    }

    public void setAddress(String address){
        AddressInput.click();
        AddressInput.clear();
        AddressInput.sendKeys(address);
    }
    public void setCity(String city){
        CityInput.click();
        CityInput.clear();
        CityInput.sendKeys(city);
    }
    public void setZip(String zip){
        ZipInput.click();
        ZipInput.clear();
        ZipInput.sendKeys(zip);
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneInput.click();
        PhoneInput.clear();
        PhoneInput.sendKeys(phoneNumber);
    }
    public void saveUserAddressData(){
        driver.findElement(By.className("form-control-submit")).click();
    }

    public static String getNewAddressData(){
        WebElement userNewAddress = driver.findElement(By.id("content"));
        return userNewAddress.getText();
    }

}