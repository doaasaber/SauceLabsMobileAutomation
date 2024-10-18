package Pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.utils.Actions;


public class LoginPage {
    AppiumDriver driver;
    By Username =By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By Password=By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By LoginButton=By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    By ErrorMessage=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");
    By Product=By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public void login(String username , String pass) throws Exception {
        Actions.waitAndEnterTextInWebElement(username,Username,driver);
        Actions.waitAndEnterTextInWebElement(pass,Password,driver);
        Actions.waitAndClickOnWebElement(LoginButton,driver);
    }
    public String getErrorText() throws Exception {
        return Actions.waitAndGetElementText(ErrorMessage,driver);
    }

    public String getProductTitle() throws Exception {
        return Actions.waitAndGetElementText(Product,driver);


    }



}
