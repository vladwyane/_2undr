package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import utils.ConfigProperties;

import java.util.List;

public class AccountWishList extends BasePage{

    public AccountWishList(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("https://2undr.bigdropinc.net/wishlist"));
        invisibilityPreLoader();
    }

    @FindBy(xpath = "//*[@data-bind='html: message.text']")
    private WebElement successMessWishList;

    @FindBys( {@FindBy(xpath = "//div[@class='products-grid wishlist']//div[@class='product-item-name']")} )
    private List<WebElement> prodWishListTitle;

    @FindBy(xpath = "//div[@class='products-grid wishlist']/h2[@class='page-title']")
    private WebElement accountWishListTitle;

    public void checkAccountWishList(String elementAddedToWishList) {
        String title = accountWishListTitle.getText();
        String activeAccountNavItem = getActiveAccountNavItem().getText();
        String actualProductTitle = prodWishListTitle.get(prodWishListTitle.size() - 1).getText();
        String sucWishListMes = successMessWishList.getText();
        softAssert.assertEquals(title, "MY WISHLIST");
        softAssert.assertEquals(activeAccountNavItem, "MY WISH LIST");
        softAssert.assertEquals(actualProductTitle, elementAddedToWishList);
        softAssert.assertEquals(sucWishListMes, elementAddedToWishList + " HAS BEEN ADDED TO YOUR WISH LIST. CLICK HERE TO CONTINUE SHOPPING.");
        softAssert.assertAll();
    }
}
