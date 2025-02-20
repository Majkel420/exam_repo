package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

private final WebDriver driver;

public LoginPage(WebDriver driver){
    this.driver = driver;
}

    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.id("field-email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement singInButton = driver.findElement((By.id("submit-login")));
        singInButton.click();
    }


}
