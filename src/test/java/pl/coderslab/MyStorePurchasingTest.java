package pl.coderslab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.CheckoutPage;
import pl.coderslab.mystore.LoginPage;
import pl.coderslab.mystore.MainPage;
import pl.coderslab.mystore.ProductDetailsPage;

import java.time.Duration;
import java.util.List;

public class MyStorePurchasingTest {

    private static WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Webdriver\\chromedriver.exe");
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
        MainPage mainPage = new MainPage(driver);
        mainPage.setHummingbirdPrintedSweater();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.getDiscountPercentage();
        Assert.assertEquals("SAVE 20%",productDetailsPage.getDiscountPercentage());
        //*Możliwy wybór między rozmiarami S,M,L,XL *
        productDetailsPage.chooseSize("M");
        //*Możliwe wprowadzenie dowolnej ilości produktu*
        productDetailsPage.chooseQuantity(5);
          productDetailsPage.addToCard();
          productDetailsPage.setProceedToCheckoutButton();
          productDetailsPage.setProceedToCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setAddressContinueButton();
        checkoutPage.setSelfPickUpOption();
        checkoutPage.setConfirmDeliveryOptionButton();
        checkoutPage.setPayByCheckOption();
        checkoutPage.setAcceptCondictionsTermsCheckMark();
        checkoutPage.setPlaceOrderButton();
        checkoutPage.getTotalPrice();
        System.out.println(checkoutPage.getTotalPrice());
        checkoutPage.getOrderReference();
        System.out.println(checkoutPage.getOrderReference());
        checkoutPage.takeScreenshot("Order_number" + System.currentTimeMillis());
        mainPage.setUserAccount();
        driver.findElement(By.id("history-link")).click();
        WebElement table = driver.findElement(By.className("table-striped"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement firstRow = rows.get(1);
        String rawText = firstRow.getText();
        System.out.println(rawText);
        System.out.println("Test");
        Assert.assertTrue(checkoutPage.getOrderReference(), rawText.contains(checkoutPage.getOrderReference()));
    }
}
