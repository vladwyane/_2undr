package pages.account;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

public class MyAccount extends BasePage{

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(xpath = "//*[@data-bind='html: message.text']")
    private WebElement successMessReg;

    @FindBy(xpath = "//div[contains(@class, 'block-dashboard-info')]//span[@class='name']")
    private WebElement nameFromDashbordInfo;

    @FindBy(xpath = "//div[contains(@class, 'block-dashboard-info')]//span[@class='email']")
    private WebElement emailFromDashbordInfo;

    public String getSuccessMessReg() {
        return successMessReg.getText();
    }

    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    private WebElement accountTitle;

    @FindBy(xpath = "//*[@class='box box-newsletter']//div[@class='box-content']")
    private WebElement newsletterInfo;

    @FindBy(xpath = "//*[@class='box box-billing-address']//div[@class='box-content']")
    private WebElement defaultBillingAddressInfo;

    @FindBy(xpath = "//*[@class='box box-shipping-address']//div[@class='box-content']")
    private WebElement defaultShippingAddressInfo;

    public String getAccountTitle() {
        return accountTitle.getText();
    }

    public MyAccount checkDashboardInfo(Users users) {
        String title = getAccountTitle();
        String activeAccountNavItem = getActiveAccountNavItem().getText();
        String actualEmail = emailFromDashbordInfo.getText();
        String actualName = nameFromDashbordInfo.getText();
        softAssert.assertEquals(title, "MY ACCOUNT");
        softAssert.assertEquals(activeAccountNavItem, "MY ACCOUNT");
        softAssert.assertEquals(actualEmail, users.getEmail());
        softAssert.assertEquals(actualName, users.getFirstUserName() + " " + users.getLastUserName());
        softAssert.assertEquals(newsletterInfo.getText(), "You are subscribed to \"General Subscription\".");
        softAssert.assertAll();
        return new MyAccount(driver);
    }

    public MyAccount checkDashboardInfoAfterReg(Users users) {
        String title = getAccountTitle();
        String activeAccountNavItem = getActiveAccountNavItem().getText();
        String actualEmail = emailFromDashbordInfo.getText();
        String actualName = nameFromDashbordInfo.getText();
        softAssert.assertEquals(title, "MY ACCOUNT");
        softAssert.assertEquals(activeAccountNavItem, "MY ACCOUNT");
        softAssert.assertEquals(actualEmail, users.getEmail());
        softAssert.assertEquals(actualName, users.getFirstUserName() + " " + users.getLastUserName());
        softAssert.assertEquals(newsletterInfo.getText(), "You aren't subscribed to our newsletter.");
        softAssert.assertEquals(defaultBillingAddressInfo.getText(), "You have not set a default billing address.");
        softAssert.assertEquals(defaultShippingAddressInfo.getText(), "You have not set a default shipping address.");
        softAssert.assertAll();
        return new MyAccount(driver);
    }

    public MyAccount checkSuccessMes() {
        String str = getSuccessMessReg();
        Assert.assertEquals(str, "THANK YOU FOR REGISTERING WITH 2UNDR.");
        return new MyAccount(driver);
    }

    public MyAccount checkErrorPasswordMes() {
        String str = getSuccessMessReg();
        Assert.assertEquals(str, "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.");
        return new MyAccount(driver);
    }

    public MyAccount checkErrorAlreadyAccMes() {
        String str = getSuccessMessReg();

        Assert.assertEquals(str, "THERE IS ALREADY AN ACCOUNT WITH THIS EMAIL ADDRESS. IF YOU ARE SURE THAT IT IS YOUR EMAIL ADDRESS, CLICK HERE TO GET YOUR PASSWORD AND ACCESS YOUR ACCOUNT.");
        return new MyAccount(driver);
    }


}
