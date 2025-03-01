package pl.coderslab.mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    private WebDriver driver;

    @FindBy(className = "discount-percentage")
    WebElement discountPercentage;

    @FindBy(id = "group_1")
    WebElement dropdownSize;

    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(className = "add-to-cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getDiscountPercentage(){
       return discountPercentage.getText().toUpperCase();
    }

    public void chooseSize(String size){
        Select select = new Select(dropdownSize);
        select.selectByVisibleText(size);
    }
    public void chooseQuantity(Integer quantity){
//        quantityWanted.clear();
          quantityWanted.click();
          quantityWanted.clear();
          quantityWanted.sendKeys(Keys.BACK_SPACE);
          quantityWanted.sendKeys(quantity.toString());
    }
    public void addToCard(){
        addToCartButton.click();
    }

    public void setProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }



}
