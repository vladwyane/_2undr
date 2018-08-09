package pages.account;

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

    public String getSuccessMessReg() {
        return successMessReg.getText();
    }

    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    private WebElement accountTitle;

    public String getAccountTitle() {
        return accountTitle.getText();
    }

    public MyAccount checkTitle() {
        String str = getAccountTitle();
        Assert.assertEquals(str, "MY ACCOUNT");
        return new MyAccount(driver);
    }

    public MyAccount checkSuccessMes() {
        String str = getSuccessMessReg();
        Assert.assertEquals(str, "THANK YOU FOR REGISTERING WITH MAIN WEBSITE STORE.");
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
