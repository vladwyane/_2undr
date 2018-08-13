package pages.adminMagenta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

public class Catalog extends BasePage {

    public Catalog(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "menu-magento-catalog-catalog")
    private WebElement catalogNavItem;

    @FindBy(css = ".item-catalog-products.level-2")
    private WebElement productSubNavItem;

    @FindBy(id = "add_new_product-button")
    private WebElement addNewProductBut;

    @FindBy(xpath = "(//span[contains(text(), 'Attribute Set')])[2]//ancestor::label//following-sibling::div")
    private WebElement attributSetSelect;

    @FindBys( {@FindBy(xpath = "//span[@data-bind='text: option.label']")} )
    private List<WebElement> listAttributSet;

    @FindBy(name = "product[name]")
    private WebElement productName;

    @FindBy(name = "product[sku]")
    private WebElement productSKU;

    @FindBy(name = "product[price]")
    private WebElement productPrice;

    @FindBy(name = "product[tax_class_id]")
    private WebElement taxClassSelect;



    public void clickCatalogNavItem() {
        invisibilityPreLoader();
        catalogNavItem.click();
    }

    public void clickProductSubNavItem() {
        invisibilityPreLoader();
        productSubNavItem.click();
    }

    public void clickAddNewProductBut() {
        invisibilityPreLoader();
        addNewProductBut.click();
    }

    public void chooseAttributSet(String name) {
        waitLoadingMaskInvisible();
        attributSetSelect.click();
        for (WebElement element : listAttributSet){
            if(element.getText().equals(name))
                element.click();
        }
    }

    public void fillProductAttribute() {
        type(productName, "test");
        type(productSKU, "yyy");
        type(productPrice, "345");
    }
}
