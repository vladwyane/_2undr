package pages;

import data.Category;
import data.Users;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.account.AccountWishList;
import utils.ConfigProperties;
import utils.Functions;

import java.util.ArrayList;
import java.util.List;

public class Collections extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 130);

    public Collections(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("collections.url"));
        invisibilityPreLoader();
    }

    @FindBys({@FindBy(xpath = "//div[@class='collection']//span[contains(@class, 'name')]")})
    private List<WebElement> listProduct;

    @FindBys({@FindBy(xpath = "//a[contains(@class, 'secondary')]")})
    private List<WebElement> butShow;

    @FindBys({@FindBy(xpath = "//*[@class='product-item-info']/a")})
    private List<WebElement> products;

    @FindBys({@FindBy(css = ".product-item-link")})
    private List<WebElement> productsTitle;

    @FindBys({@FindBy(xpath = "//ol[contains(@class, 'products')]//img[contains(@src, 'media')]")})
    private List<WebElement> productImage;

    @FindBys({@FindBy(css = ".amquickview-hover")})
    private List<WebElement> productsQuickViewBut;

    @FindBys({@FindBy(xpath = "//*[@data-role='tocart-form']")})
    private List<WebElement> productsInStock;

    @FindBys({@FindBy(css = ".price-wrapper")})
    private List<WebElement> productsPrice;

    @FindBy(xpath = "(//span[@class='toolbar-number'])[3]")
    private WebElement total;

    @FindBy(xpath = "(//span[@class='toolbar-number'])[1]")
    private WebElement totalWithoutPagination;

    @FindBy(xpath = "(//a[@title='Next'])[2]")
    private WebElement nextPagination;

    @FindBys({@FindBy(css = ".size .swatch-option")})
    private List<WebElement> listSize;

    @FindBy(xpath = "(//*[@data-role='closeBtn'])[1]")
    private WebElement closePopapBut;

    @FindBy(xpath = "//body[contains(@class, 'ajax-loading')]")
    private WebElement preLoader;

    @FindBys( {@FindBy(xpath = "//*[@data-role='tocart-form']//ancestor::div[@class='product-item-inner']//preceding-sibling::div[@class='wrap-product-name']/span/a")} )
    private List<WebElement> productsTitleInStock;

    @FindBys( {@FindBy(xpath = "//*[@data-role='tocart-form']//ancestor::div[@class='product-item-inner']//preceding-sibling::div[contains(@class, 'price-box')]/span/span")} )
    private List<WebElement> productsPriceInStock;

    @FindBys( {@FindBy(xpath = "//*[@data-role='tocart-form']//ancestor::div[@class='product-item-inner']//preceding-sibling::div[@class='wrap-product-name']//a[@class='action towishlist']")} )
    private List<WebElement> productsWishListInStock;

    @FindBy(xpath = "//*[@title='Add to Cart']")
    private WebElement addToCartBut;

    @FindBy(xpath = "//*[contains(text(),'Continue Shopping')]")
    private WebElement continShopBut;

    @FindBy(xpath = "//*[@class='breadcrumbs']//a[contains(text(),'Collections')]")
    private WebElement bredcrumbsCollections;

    @FindBy(id = "qty")
    private WebElement qtyInput;

    @FindBy(css = ".add-to-cart-modal._show")
    private WebElement addToCartModal;

    @FindBy(id = "amstockstatus-stockalert")
    private WebElement outOfStockAlert;

    @FindBy(css = ".message.info.empty")
    private WebElement emptyTitle;

    public String addProductInStockToShopCart(double price, String amount) throws Exception {
        String webElementSuccess;
        for (int i = 0; i < productsTitleInStock.size(); i++) {
            double webPrice = Double.parseDouble(productsPriceInStock.get(i).getAttribute("data-price-amount"));
            if (webPrice == price) {
                webElementSuccess = productsTitleInStock.get(i).getText();
                productsTitleInStock.get(i).click();
                chooseSizeAndAmount(amount);
                return webElementSuccess;
            }
            if (i == productsTitleInStock.size() - 1 && isElementPresent(nextPagination) == true){
                invisibilityPreLoader();
                nextPagination.click();
                i = 0;
                invisibilityPreLoader();
            }
        }
        webElementSuccess = productsTitleInStock.get(productsWishListInStock.size() - 1).getText();
        productsTitleInStock.get(productsTitleInStock.size() - 1).click();
        chooseSizeAndAmount(amount);
        return webElementSuccess;
    }

    public String addProductInStockToWishList(double price) throws Exception {
        String webElementSuccess;
        for (int i = 0; i < productsWishListInStock.size(); i++) {
            double webPrice = Double.parseDouble(productsPriceInStock.get(i).getAttribute("data-price-amount"));
            if (webPrice == price) {
                webElementSuccess = productsTitleInStock.get(i).getText();
                productsWishListInStock.get(i).click();
                return webElementSuccess;
            }
            if (i == productsWishListInStock.size() - 1 && isElementPresent(nextPagination) == true){
                invisibilityPreLoader();
                nextPagination.click();
                i = 0;
                invisibilityPreLoader();
            }
        }
        webElementSuccess = productsTitleInStock.get(productsWishListInStock.size() - 1).getText();
        productsWishListInStock.get(productsWishListInStock.size() - 1).click();
        return webElementSuccess;
    }

    public void chooseSizeAndAmount(String amount) {
        invisibilityPreLoader();
        clickSizeRadioBut();
        type(qtyInput, amount);
        addToCartBut.click();
        waitVissibleAddToCartPopap();
        open();
    }

    public void  clickSizeRadioBut() {
        for (WebElement l : listSize) {
            if(isElementPresent(l) == true) {
                l.click();
                invisibilityPreLoader();
                if(isElementPresent(outOfStockAlert) == true) {
                    continue;
                } else return;
            }
        }
    }

    public void chooseCollections(Category category) throws InterruptedException {
        invisibilityPreLoader();
        for (int i = 0; i < listProduct.size(); i++) {
            WebElement titleCol = listProduct.get(i);
            String nameTitle = titleCol.getText();
            if (nameTitle.equals(category.getCollectionName())) {
                WebElement button = butShow.get(i);
                button.click();
                break;
            }
        }
        invisibilityPreLoader();
    }

    public int accountProduct() throws InterruptedException {
        int totalProduct = products.size();
        invisibilityPreLoader();
        while (isElementPresent(nextPagination) == true) {
            nextPagination.click();
            invisibilityPreLoader();
            int countProduct = products.size();
            totalProduct += countProduct;
        }
        return  totalProduct;
    }

    public int amountProductWithImage() throws InterruptedException {
        if(isElementPresent(emptyTitle) == true){
            return 0;
        } else {
            int totalProduct = productImage.size();
            invisibilityPreLoader();
            while (isElementPresent(nextPagination) == true) {
                nextPagination.click();
                invisibilityPreLoader();
                int amountProduct = productImage.size();
                totalProduct += amountProduct;
            }
            return  totalProduct;
        }
    }

    public Collections checkAmountProductImage(int actTotal ) {
        String expectedTotal;
        if(isElementPresent(emptyTitle) == true){
            expectedTotal = "0";
        } else if(isElementPresent(total)){
            expectedTotal = total.getText();
        } else
            expectedTotal = totalWithoutPagination.getText();
        String actualTotal = String.valueOf(actTotal);
        Assert.assertEquals(actualTotal, expectedTotal);
        return new Collections(driver);
    }

    public void waitVissibleAddToCartPopap() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addToCartModal));
    }

}


