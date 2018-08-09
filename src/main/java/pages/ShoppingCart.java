package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage{

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        soppingCart.click();
        invisibilityPreLoader();
    }

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkoutBut;

    @FindBy(xpath = "//*[@title='Secured Checkout']")
    private WebElement secCheckout;

    public ShippingMethod clickCheckoutBut() {
        checkoutBut.click();
        return new ShippingMethod(driver);
    }

}
