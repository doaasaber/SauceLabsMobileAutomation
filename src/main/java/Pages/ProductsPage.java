package Pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.utils.Actions;

public class ProductsPage {
    AppiumDriver driver;
    By AddToCartButton= By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    By CartButton=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    By ProductTitle=By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    By ProductPrice=By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    public ProductsPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public void addProductToCart() throws Exception {
        Actions.waitAndClickOnWebElement(AddToCartButton,driver);
    }
    public String getProductTitle() throws Exception {
        return Actions.waitAndGetElementText(ProductTitle,driver);
    }

    public String getProductPrice() throws Exception {
        return Actions.waitAndGetElementText(ProductPrice,driver);
    }
    public void clickOnCartButton() throws Exception {
        Actions.waitAndClickOnWebElement(CartButton,driver);
    }
}
