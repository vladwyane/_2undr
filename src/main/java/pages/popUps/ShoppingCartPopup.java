package pages.popUps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.ShippingMethod;

public class ShoppingCartPopup extends BasePage{

    public ShoppingCartPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkout;

    public ShippingMethod clickCheckoutBut() {
        checkout.click();
        return new ShippingMethod(driver);
    }
}
