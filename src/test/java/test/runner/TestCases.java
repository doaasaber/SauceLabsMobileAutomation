package test.runner;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.utils.TestBase;

import java.time.Duration;

public class TestCases {
    AppiumDriver driver;
    TestBase base = new TestBase();
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    String productTitle1,productTitle2,productPrice1,productPrice2;


    @BeforeClass
    public void beforeClass() throws Exception {
        base.beforeTest();
        driver = base.getDriver();
        ((AndroidDriver)driver).activateApp("com.swaglabsmobileapp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        cartPage=new CartPage(driver);


    }

    @AfterClass
    public void afterClass() {

        ((InteractsWithApps) driver).terminateApp("com.swaglabsmobileapp");

    }



    @Test(priority = 3)
    public void successfulLogin() throws Exception {
        loginPage.login("standard_user","secret_sauce");
       Assert.assertEquals(loginPage.getProductTitle(),"PRODUCTS");

    }

    @Test(priority = 1)
    public void invalidUserName() throws InterruptedException {
        WebElement usernameField = (WebElement) driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        WebElement loginButton = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
        usernameField.sendKeys("invalidUsername");
        loginButton.click();
        WebElement errorMessage = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }


    @Test(priority = 2)
    public void invalidPassword() throws Exception {
        loginPage.login("standard_user","secret_sa");
        Assert.assertEquals(loginPage.getErrorText(),"Username and password do not match any user in this service.");

    }


    @Test(priority = 4)
    public void addProductToCart() throws Exception {
          productsPage.addProductToCart();
          productTitle1=productsPage.getProductTitle();
          productPrice1=productsPage.getProductPrice();
          productsPage.clickOnCartButton();
          productTitle2=cartPage.getProductTitle();
          productPrice2=cartPage.getProductPrice();
          Assert.assertEquals(productTitle1,productTitle2);
          Assert.assertEquals(productPrice1,productPrice2);


    }


}
