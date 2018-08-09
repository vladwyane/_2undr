package pages.popUps;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.account.MyAccount;

public class AccountPopup extends BasePage{

    public AccountPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "user-email")
    private WebElement userEmail;

    @FindBy(id = "user-pass")
    private WebElement userPass;

    @FindBy(xpath = "//form[@id='guest-login-form']//button[@name='send']")
    private WebElement loogin;

    public void clickLoginButton() {
        loogin.click();
    }

    @FindBy(xpath = "//*[contains(text(), 'Create an account')]")
    private WebElement createAccBut;

    public MyAccount clickCreateAccBut() {
        createAccBut.click();
        return new MyAccount(driver);
    }

    @FindBy(css = ".authorization-link")
    private WebElement sighOutBut;

    public void clickSighOutBut() {
        sighOutBut.click();
    }

    public WebElement getSighOutBut() {
        return sighOutBut;
    }


    public MyAccount signIn(Users users) throws InterruptedException {
        type(userEmail, users.getEmail());
        type(userPass, users.getPassword());
        clickLoginButton();
        return new MyAccount(driver);
    }

    public AccountPopup logOut() {
            checkHTMLAttribute(accountLogin, "class", "account");
            accountLogin.click();
            invisibilityPreLoader();
            clickSighOutBut();
            return new AccountPopup(driver);
    }
}
