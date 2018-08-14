package pages.adminMagenta;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(name = "product[visibility]")
    private WebElement visibilitySelect;

    @FindBys( {@FindBy(xpath = "//*[@name='product[visibility]']/option")} )
    private List<WebElement> listVisibility;

    @FindBy(xpath = "//span[contains(text(), 'Categories')]//ancestor::label//following-sibling::div")
    private WebElement categoriesSelect;

    @FindBys( {@FindBy(xpath = "//ul[@data-level='2']/li")} )
    private List<WebElement> listCategory2Level;

    @FindBys( {@FindBy(xpath = "//ul[@data-level='3']/li")} )
    private List<WebElement> listCategory3Level;

    @FindBys( {@FindBy(xpath = "//ul[@data-level='4']/li/div")} )
    private List<WebElement> listCategory4Level;

    @FindBy(name = "product[country_of_manufacture]")
    private WebElement countryOfManufactureSelect;

    @FindBys( {@FindBy(xpath = "//*[@name='product[country_of_manufacture]']/option")} )
    private List<WebElement> listCounryOfManufacture;

    @FindBy(name = "product[dimensions_lwh]")
    private WebElement dimensionsField;

    @FindBy(name = "product[style]")
    private WebElement productStyleSelect;

    @FindBys( {@FindBy(xpath = "//*[@name='product[style]']/option")} )
    private List<WebElement> listProductStyle;

    @FindBy(name = "product[model]")
    private WebElement productModelSelect;

    @FindBys( {@FindBy(xpath = "//*[@name='product[model]']/option")} )
    private List<WebElement> listProductModel;

    @FindBy(xpath = "//div[@data-index='content']")
    private WebElement productContent;

    @FindBy(xpath = "//div[@data-index='gallery']")
    private WebElement productImage;

    @FindBy(id = "fileupload")
    private WebElement uploadFileBut;

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
            if(element.getText().equals(name)) {
                element.click();
                return;
            }
        }
    }

    public void chooseVisibilityValue(String name) {
        waitLoaderkInvisible();
        visibilitySelect.click();
        for (WebElement element : listVisibility){
            if(element.getText().equals(name)) {
                element.click();
                return;
            }
        }
        listVisibility.get(listVisibility.size() - 1).click();
    }

    public void openDropCategory2Level(String nameCat2Level) {
        for (WebElement element : listCategory2Level){
            if(element.getText().equals(nameCat2Level)) {
                Actions build = new Actions(driver);
                build.moveToElement(element, 23, 23).click().build().perform();
                return;
            }
        }
    }

    public void openDropCategory3Level(String nameCat3Level) {
        for (WebElement element : listCategory3Level){
            if(element.getText().equals(nameCat3Level)) {
                Actions build = new Actions(driver);
                build.moveToElement(element, 23, 23).click().build().perform();
                return;
            }
        }
    }

    public void chooseSubCategory(String nameSubCategory) {
        for (WebElement element : listCategory4Level){
            if(element.getText().equals(nameSubCategory)) {
                element.click();
                return;
            }
        }
        listCategory4Level.get(listCategory4Level.size() - 1).click();
    }

    public void chooseCategory(String nameCat2Level, String nameCat3Level, String nameSubCategory) {
        categoriesSelect.click();
        openDropCategory2Level(nameCat2Level);
        openDropCategory3Level(nameCat3Level);
        chooseSubCategory(nameSubCategory);
    }

    public void chooseCountryOfManufac(String countryName) {
        for (WebElement element : listCounryOfManufacture){
            if(element.getText().equals(countryName)) {
                element.click();
                return;
            }
        }
        listCounryOfManufacture.get(listCounryOfManufacture.size() - 1).click();
    }

    public void chooseProductStyle(String styleName) {
        for (WebElement element : listProductStyle){
            if(element.getText().equals(styleName)) {
                element.click();
                return;
            }
        }
        listProductStyle.get(listProductStyle.size() - 1).click();
    }

    public void chooseProductModel(String modelName) {
        for (WebElement element : listProductModel){
            if(element.getText().equals(modelName)) {
                element.click();
                return;
            }
        }
        listProductModel.get(listProductModel.size() - 1).click();
    }

    public void fillDimensionField() {
        type(dimensionsField, "14x9x6");
    }

    public void fillProductContent() {
        productContent.click();
        invisibilityPreLoader();
        driver.switchTo().frame(driver.findElement(By.id("product_form_description_ifr"))).findElement(By.id("tinymce"))
                .sendKeys(Keys.chord(Keys.CONTROL, "b") + "Something Title" + Keys.ENTER  +
                        "Professional level athletic performance led to the creation of the Power Shift ™ by 2UNDR™. " +
                        "The thermal reduction Coldskin™ fabric by Garmatex™ is strategically sewn just below the 40 mm waistband - 2UNDR's thickest yet. " +
                        "This extended Swass Patch ventilates and cools your lower back during intense activity.");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("product_form_short_description_bullist")).click();
        driver.switchTo().frame(driver.findElement(By.id("product_form_short_description_ifr"))).findElement(By.id("tinymce"))
                .sendKeys("Designed with athletes in mind" + Keys.ENTER + "Introducing a Breathable Athletic Mesh Back Panel" + Keys.ENTER +
                "Compression-like feel" + Keys.ENTER + "Temperature control" + Keys.ENTER + "Worn by some of sports' biggest names");
        driver.switchTo().defaultContent();
    }

    public void uploadProductImage() {
        productImage.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1])", uploadFileBut, "0");
        js.executeScript("arguments[0].setAttribute('class', arguments[1])", uploadFileBut, "a");
        uploadFileBut.sendKeys("C:\\Users\\Vlad\\GitHub\\_2undr\\src\\main\\resources\\2u05ll-036_1_1.jpg");
    }

    public void fillProductAttribute() {
        type(productName, "test");
        type(productSKU, "yyy");
        type(productPrice, "345");
    }
}
