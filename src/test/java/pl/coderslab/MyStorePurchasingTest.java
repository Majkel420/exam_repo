package pl.coderslab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.*;

import java.time.Duration;
import java.util.List;

public class MyStorePurchasingTest {

    private static WebDriver driver;
    MainPage mainPage;
    ProductDetailsPage productDetailsPage;
    CheckoutPage checkoutPage;
    OrderHistoryPage orderHistoryPage;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nupdynuvxbtbqntbvq@nbmbb.com", "CorrectPassword!2137");
        mainPage = new MainPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestPurchasingSweater(){

        mainPage.setHummingbirdPrintedSweater();
        productDetailsPage.getDiscountPercentage();
        Assert.assertEquals("SAVE 20%",productDetailsPage.getDiscountPercentage());
        productDetailsPage.chooseSize("M");
        productDetailsPage.chooseQuantity(6);
        productDetailsPage.addToCard();
        productDetailsPage.setProceedToCheckoutButton();
        productDetailsPage.setProceedToCheckoutButton();
        checkoutPage.setAddressContinueButton();
        checkoutPage.setSelfPickUpOption();
        checkoutPage.setConfirmDeliveryOptionButton();
        checkoutPage.setPayByCheckOption();
        checkoutPage.setAcceptCondictionsTermsCheckMark();
        checkoutPage.setPlaceOrderButton();
        checkoutPage.getTotalPrice();
        String orderTotalPrice = checkoutPage.getTotalPrice();
        checkoutPage.getOrderReference();
        String orderNum = checkoutPage.getOrderReference();
        checkoutPage.takeScreenshot("Order_number" + System.currentTimeMillis());
        mainPage.setUserAccount();
        orderHistoryPage.setGoToOrderHistoryAndDetails();
        String getFirstRowTable = orderHistoryPage.getFirstRowTable();
        Assert.assertTrue("No order details in order history", getFirstRowTable.contains(orderNum)
        && getFirstRowTable.contains(orderTotalPrice)
        && getFirstRowTable.contains("Awaiting check payment"));

    }
}
