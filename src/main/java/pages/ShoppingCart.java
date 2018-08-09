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

    }

    @FindBy(xpath = "//*[@title='Secured Checkout']")
    private WebElement secCheckout;

    public ShippingMethod clickSecCheckout() {
        secCheckout.click();
        return new ShippingMethod(driver);
    }
}
