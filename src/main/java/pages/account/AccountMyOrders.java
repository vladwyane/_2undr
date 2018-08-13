package pages.account;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AccountMyOrders extends BasePage {

    public AccountMyOrders(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(css = "h1.page-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    private WebElement productName;

    @FindBy(xpath = "//td[@data-th='Grand Total']//span[@class='price']")
    private WebElement totalPrice;

    @FindBy(css = ".order-status .value")
    private WebElement orderStatus;

    public MyAccount checkAccountOrder(String orderNumber, String productName, String totalPrice) {
        String title = pageTitle.getText();
        String activeAccountNavItem = getActiveAccountNavItem().getText();
        softAssert.assertEquals(title, "ORDER # " + orderNumber);
        softAssert.assertEquals(activeAccountNavItem, "MY ORDERS");
        softAssert.assertEquals(this.productName.getText().toUpperCase(), productName);
        softAssert.assertEquals(this.totalPrice.getText(), totalPrice);
        softAssert.assertEquals(orderStatus.getText(), "Pending");
        softAssert.assertAll();
        return new MyAccount(driver);
    }
}
