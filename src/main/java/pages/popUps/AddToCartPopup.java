package pages.popUps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.ShoppingCart;

public class AddToCartPopup extends BasePage{

    public AddToCartPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(xpath = "//button/span[contains(text(), 'View Cart')]")
    private WebElement viewCart;

    public ShoppingCart clickViewCart() {
        viewCart.click();
        return new ShoppingCart(driver);
    }
}
