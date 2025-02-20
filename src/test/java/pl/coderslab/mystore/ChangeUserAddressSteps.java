package pl.coderslab.mystore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChangeUserAddressSteps {
    WebDriver driver;
    NewAddressPage newAddressPage;

    @Given("User is logged to the mystore-testlab website")
    public void UserIsLoggedToCodersTestLab(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nupdynuvxbtbqntbvq@nbmbb.com", "CorrectPassword!2137");
    }

    @When("User decides to add new address")
    public void UserDecidesToAddNewAddress(){
        driver.findElement(By.className("account")).click();
        driver.findElement(By.id("addresses-link")).click();
        driver.findElement(By.xpath("//span[text()='Create new address']")).click();
        newAddressPage = new NewAddressPage(driver);
    }

    @And("^User fill the form with data (.*), (.*), (.*), (.*), (.*)$")
    public void putAddressData(String alias, String address, String city, String zip, String phoneNumber) {
        newAddressPage.setAlias(alias);
        newAddressPage.setAddress(address);
        newAddressPage.setCity(city);
        newAddressPage.setZip(zip);
        newAddressPage.setPhoneNumber(phoneNumber);
        newAddressPage.saveUserAddressData();
    }

    @Then("^User new address cointains (.*), (.*), (.*), (.*), (.*)$")
    public void checkAddressData(String alias, String address, String city, String zip, String phoneNumber){
        String NewAddressData = NewAddressPage.getNewAddressData();
        System.out.println(NewAddressData);
        Assert.assertTrue(NewAddressData.contains(alias)
                && NewAddressData.contains(address)
                && NewAddressData.contains(city)
                && NewAddressData.contains(zip)
                && NewAddressData.contains(phoneNumber));
    }
    @And("User delete new address")
    public void deleteNewAddres(){
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")).click();

    }
    @And("^User checked if the address removal was successful, not contain (.*), (.*), (.*), (.*), (.*)$")
    public void checkDeletedAddressData(String alias, String address, String city, String zip, String phoneNumber){
        String OldAddressData = NewAddressPage.getNewAddressData();
        Assert.assertFalse(OldAddressData.contains(alias)
                && OldAddressData.contains(address)
                && OldAddressData.contains(city)
                && OldAddressData.contains(zip)
                && OldAddressData.contains(phoneNumber));
    }
    @And("User close the browser")
    public void userClosedBrowser(){
        driver.quit();
    }
}
