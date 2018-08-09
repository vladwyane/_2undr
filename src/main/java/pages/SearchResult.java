package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends BasePage{

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(css = ".product-item-info")
    private WebElement fistProduct;

    public void clickFirstProduct() {
        fistProduct.click();
    }


}
