package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBys( {@FindBy(css = "a")} )
    protected List<WebElement> allLinkOnPage;

    @FindBy(css = "div.account")
    protected WebElement accountLogin;

    @FindBy(css = ".search-icon")
    protected WebElement searchIcon;

    @FindBy(css = ".action.showcart")
    protected WebElement soppingCart;

    @FindBys( {@FindBy(css = "#account-nav ul li")} )
    private List<WebElement> accountNavList;

    public WebElement getActiveAccountNavItem() {
        for(WebElement element : accountNavList) {
            String st = element.getAttribute("class");
            if(element.getAttribute("class").equals("nav item current")) {
                return element;
            }
        }
        return null;
    }

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

    public boolean isElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void invisibilityPreLoader() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body[contains(@class, 'ajax-loading')]")));
    }

    protected boolean checkHTMLAttribute(WebElement element, String attribute, String name) {
        try
        {
            String str = element.getAttribute(attribute);
            if (str.equals(name)) {
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    public void waitAdminDefaultLoaderInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".admin__form-loading-mask")));
    }

    public void waitAdminCustomLoaderInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));
    }

    public void waitAdminDefaulLoaderModalSlideInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//*[@class='admin__data-grid-loading-mask'])[2]")));
    }

}
