package pages;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.account.MyAccount;
import utils.ConfigProperties;

public class CreateAccount extends BasePage {

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
        invisibilityPreLoader();
        accountLogin.click();
        invisibilityPreLoader();
    }

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConf;

    @FindBy(css = ".field.choice.newsletter")
    private WebElement newsletter;

    public void checkedNewsletter() {
        newsletter.click();
    }

    @FindBy(xpath = "//*[@title='Create an Account']")
    private WebElement createAccBut;

    public MyAccount clickCreateAccBut() {
        createAccBut.click();
        return new MyAccount(driver);
    }

    public MyAccount registrationWithNewsletter(Users users) throws InterruptedException {
        type(firstName, users.getFirstUserName());
        type(lastName, users.getLastUserName());
        type(email, users.getEmail());
        type(password, users.getPassword());
        type(passwordConf, users.getPassword());
        checkedNewsletter();
        clickCreateAccBut();
        return new MyAccount(driver);
    }
}
