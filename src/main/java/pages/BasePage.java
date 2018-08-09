package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div.account")
    protected WebElement accountLogin;

    @FindBy(css = ".search-icon")
    protected WebElement searchIcon;

    @FindBy(css = ".action.showcart")
    protected WebElement soppingCart;

    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public abstract void open();

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void invisibilityPreLoader() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body[contains(@class, 'ajax-loading')]")));
    }

    protected boolean checkHTMLAttribute(WebElement element, String attribute, String name) {
        String str = element.getAttribute(attribute);
        if (str.equals(name)) {
            return true;
        }
        return false;
    }

}
