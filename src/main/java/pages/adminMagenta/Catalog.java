package pages.adminMagenta;

import data.Products;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(xpath = "//button[@data-index='create_configurable_products_button']")
    private WebElement createConfigBut;

    @FindBy(xpath = "//button[@data-action='grid-filter-expand']")
    private WebElement filterBut;

    @FindBy(name = "attribute_code")
    private WebElement attributeCodeField;

    @FindBy(xpath = "//button[@data-action='grid-filter-apply']")
    private WebElement applyFilterBut;

    @FindBys( {@FindBy(css = ".data-grid-checkbox-cell-inner")} )
    private List<WebElement> listCheckboxAttribute;

    @FindBy(css = ".action-next-step")
    private WebElement nextStepBut;

    @FindBys( {@FindBy(css = ".attribute-options li")} )
    private List<WebElement> listAttributeOptions;

    @FindBy(xpath = "//label[@for='apply-single-set-radio']")
    private WebElement applySingleImageRadioBut;

    @FindBy(css = "input.admin__control-file")
    private WebElement uploadApplySingleImage;

    @FindBy(xpath = "//label[@for='apply-single-price-radio']")
    private WebElement applySinglePriceRadioBut;

    @FindBy(id = "apply-single-price-input")
    private WebElement applySinglePriceField;

    @FindBy(xpath = "//label[@for='apply-single-inventory-radio']")
    private WebElement applySingleQuantityRadioBut;

    @FindBy(id = "apply-single-inventory-input")
    private WebElement applySingleQuantityField;

    @FindBy(xpath = "//div[@data-index='underwear']")
    private WebElement underwearSection;

    @FindBy(name = "product[color]")
    private WebElement underwearColorSelect;

    @FindBys( {@FindBy(xpath = "//*[@name='product[color]']/option")} )
    private List<WebElement> listUnderwearColors;

    @FindBys( {@FindBy(xpath = "//td[@data-index='price_weight']//input")} )
    private List<WebElement> listCurrentVariationsWeight;

    @FindBy(id = "save-button")
    private WebElement saveProductBut;

    @FindBy(xpath = "//div[@class='fieldset-wrapper admin__collapsible-block-wrapper' and @data-index='related']")
    private WebElement relatedProductsection;

    @FindBy(xpath = "//button[@data-index='button_related']")
    private WebElement addRelatedProdBut;

    @FindBy(xpath = "//select[@name='type_id']")
    private WebElement attributeTypeSelect;

    @FindBys( {@FindBy(xpath = "//select[@name='type_id']/option")} )
    private List<WebElement> listAttributeType;

    @FindBy(xpath = "(//span[contains(text(), 'Add Selected Products')])[1]")
    private WebElement addSelectedProdBut;


    public Dashbord saveProduct() {
        saveProductBut.click();
        invisibilityPreLoader();
        return new Dashbord(driver);
    }


    public void clickCheckboxAttribute() {
       for(WebElement element : listCheckboxAttribute) {
           element.click();
           return;
       }
    }

    public void chooseAttributeValue (String[] arrayWithAttributeValue) {
        for (int i = 0; i < listAttributeOptions.size(); i++) {
            for (int j = 0; j < arrayWithAttributeValue.length; j++) {
                String webAttValue = listAttributeOptions.get(i).getAttribute("data-attribute-option-title");
                if(webAttValue.equals(arrayWithAttributeValue[j]))
                    listAttributeOptions.get(i).click();
            }
        }
    }

    public void openNewProductForm() {
        invisibilityPreLoader();
        catalogNavItem.click();
        invisibilityPreLoader();
        productSubNavItem.click();
        invisibilityPreLoader();
        addNewProductBut.click();
        driver.navigate().refresh();
    }

    public void chooseAttributSet(String attributeSet) {
        waitAdminDefaultLoaderInvisible();
        attributSetSelect.click();
        for (WebElement element : listAttributSet){
            if(element.getText().equals(attributeSet)) {
                element.click();
                return;
            }
        }
    }

    public void chooseVisibilityValue(String visibilityValue) {
        waitAdminCustomLoaderInvisible();
        visibilitySelect.click();
        for (WebElement element : listVisibility){
            if(element.getText().equals(visibilityValue)) {
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

    public void uploadProductImage(Products products, int amountImage) {
        productImage.click();
        for (int i = 0; i < amountImage; i++) {
            invisibilityPreLoader();
            if(i == 0)
                uploadFileBut.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\" + products.getFirstImage());
            else if(i == 1)
                uploadFileBut.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\" + products.getSecondImage());
            else break;
        }
        invisibilityPreLoader();
    }

    public void createProductConfiguration(Products products) {
        createConfigBut.click();
        createProdConfigStep1("size");
        createProdConfigStep2(new String[] {"XS", "M", "S", "L", "XL", "2XL"});
        createProdConfigStep3(products.getFirstImage(), products.getPrice(), products.getQuantity());
        createProdConfigStep4();
        addingWeightForVariation(products.getWeight());
    }

    public void createProdConfigStep1(String attributeCode) {
        waitModalSlideVisible();
        invisibilityPreLoader();
        filterBut.click();
        invisibilityPreLoader();
        type(attributeCodeField, attributeCode);
        applyFilterBut.click();
        invisibilityPreLoader();
        clickCheckboxAttribute();
        nextStepBut.click();
    }

    public void createProdConfigStep2(String[] size) {
        waitAdminCustomLoaderInvisible();
        chooseAttributeValue(size);
        nextStepBut.click();
    }

    public void createProdConfigStep3(String imageName, String price, String quantity) {
        applySingleImageRadioBut.click();
        invisibilityPreLoader();
        uploadApplySingleImage.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\" + imageName);
        applySinglePriceRadioBut.click();
        invisibilityPreLoader();
        type(applySinglePriceField, price);
        applySingleQuantityRadioBut.click();
        type(applySingleQuantityField, quantity);
        nextStepBut.click();
    }

    public void createProdConfigStep4() {
        invisibilityPreLoader();
        nextStepBut.click();
    }

    public void chooseUndewearColor(Products products) {
        underwearSection.click();
        underwearColorSelect.click();
        for (WebElement element : listUnderwearColors){
            if(element.getText().equals(products.getColor())) {
                element.click();
                return;
            }
        }
        listUnderwearColors.get(listUnderwearColors.size() - 1).click();
    }

    public void fillingProductInfo(Products products) {
        chooseAttributSet(products.getAttributeSet());
        type(productName, products.getName());
        type(productSKU, products.getSku());
        type(productPrice, products.getPrice());
        chooseVisibilityValue(products.getVisibility());
        chooseCategory("Underwear", "Collections", products.getCategory());
        chooseCountryOfManufac(products.getCountry());
        chooseProductStyle(products.getStyle());
        type(dimensionsField, products.getDimension());
        chooseProductModel(products.getModel());
    }

    public void chooseAttributeType(String typeAttribute) {
        for (WebElement element : listAttributeType){
            if(element.getText().equals(typeAttribute)) {
                element.click();
                return;
            }
        }
        listUnderwearColors.get(listUnderwearColors.size() - 1).click();
    }

    public void chooseRelatedProducts(int amount) {
        relatedProductsection.click();
        addRelatedProdBut.click();
        waitRelatedModalSlideVisible();
        waitAdminDefaulLoaderModalSlideInvisible();
        filterBut.click();
        invisibilityPreLoader();
        chooseAttributeType("Configurable Product");
        applyFilterBut.click();
        invisibilityPreLoader();
        clickCheckboxProduct(amount);
        addSelectedProdBut.click();
    }

    public void addingWeightForVariation(String valueWeight) {
        for (WebElement element : listCurrentVariationsWeight){
            type(element, valueWeight);
        }
    }

    public void clickCheckboxProduct(int amount) {
        for (int i = 0; i < listCheckboxAttribute.size() && i < amount; i++) {
            listCheckboxAttribute.get(i).click();
        }
    }

    public void waitModalSlideVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-slide.product_form_product_form_configurableModal._show")));
    }

    public void waitRelatedModalSlideVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-slide.product_form_product_form_related_related_modal._show")));
    }
}
