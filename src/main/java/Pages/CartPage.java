package Pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.utils.Actions;
public class CartPage {
    AppiumDriver driver;
    By ProductTitle= By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    By ProductPrice=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public String getProductTitle() throws Exception {
        return Actions.waitAndGetElementText(ProductTitle,driver);
    }

    public String getProductPrice() throws Exception {
        return Actions.waitAndGetElementText(ProductPrice,driver);
    }

}
