package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetail extends BasePage{

    public ProductDetail(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(xpath = "//*[@option-label='Large']")
    private WebElement sizeL;

    public void clickSizeL() {
        sizeL.click();
    }

    @FindBy(xpath = "//*[@title='Add to Cart']")
    private WebElement addToCart;

    public void clickAddToCart() {
        addToCart.click();
    }
}
