package pages.adminMagenta;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigProperties;

public class Dashbord extends BasePage{

    public Dashbord(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminMagenta.url"));
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "login")
    private WebElement passwordField;

    @FindBy(css = ".action-login")
    private WebElement signInBut;

    public Dashbord signIn(Users users) {
        type(userNameField, users.getEmail());
        type(passwordField, users.getPassword());
        signInBut.click();
        return new Dashbord(driver);
    }
}
