package pl.coderslab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.LoginPage;
import pl.coderslab.mystore.ProductDetailsPage;

import java.time.Duration;

public class MyStorePurchasingTest {

    private static WebDriver driver;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nupdynuvxbtbqntbvq@nbmbb.com", "CorrectPassword!2137");
    }

    @After
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void TestPurchasingSweater(){
        driver.findElement(By.xpath("//a[text()='Hummingbird printed sweater']")).click();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.GetDiscountPercentage();
        Assert.assertEquals("SAVE 20%",productDetailsPage.GetDiscountPercentage());
        //*Możliwy wybór między rozmiarami S,M,L,XL *
        //*Możliwe wprowadzenie dowolnej ilości produktu*
        productDetailsPage.chooseQuantity(5);
        productDetailsPage.chooseSize("M");
//        driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart")).submit();
          productDetailsPage.addToCard();
//        driver.findElement(By.xpath("//a[contains(text(), 'Proceed to checkout')]")).click();
        System.out.println("Test");
        
    }
}
