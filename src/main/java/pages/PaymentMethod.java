package pages;

import data.CreditCarts;
import data.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentMethod extends BasePage{

    public PaymentMethod(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBys( {@FindBy(css = ".payment-method-title label")} )
    private List<WebElement> listPaymentMethod;

    @FindBy(xpath = "//*[@name='payment[cc_number]']")
    private WebElement cartNumberField;

    @FindBy(id = "select2-payflowpro_expiration-container")
    private WebElement cartMonthSelect;

    @FindBys( {@FindBy(xpath = "//ul[@id='select2-payflowpro_expiration-results']/li[@class='select2-results__option']")} )
    private List<WebElement> listCartMonth;

    @FindBy(id = "select2-payflowpro_expiration_yr-container")
    private WebElement cartYearSelect;

    @FindBys( {@FindBy(xpath = "//ul[@id='select2-payflowpro_expiration_yr-results']/li[@class='select2-results__option']")} )
    private List<WebElement> listCartYear;

    @FindBy(name = "payment[cc_cid]")
    private WebElement cartCVN;

    @FindBys( {@FindBy(xpath = "//button[@title='Place Order']")} )
    private List<WebElement> listPlaceOrderBut;

    @FindBys( {@FindBy(css = ".checkout-agreement")} )
    private List<WebElement> listCheckboxTermCond;

    @FindBy(xpath = "//tr[@class='grand totals']//span[@class='price']")
    private WebElement totalPrice;

    public void choosePaymentMethod(String nameMethod) {
        invisibilityPreLoader();
        if(nameMethod.equals("CreditCart"))
            listPaymentMethod.get(0).click();
        else if(nameMethod.equals("PayPal"))
            listPaymentMethod.get(2).click();
        else listPaymentMethod.get(1).click();
    }

    public void fillPaymentInfo(CreditCarts creditCarts) {
        waitCartNumberFieldVisible();
        type(cartNumberField, creditCarts.getCartNumber());
        chooseCartMonth(creditCarts.getCartMonth());
        chooseCartYear(creditCarts.getCartYear());
        type(cartCVN, creditCarts.getCartCVN());
    }

    public void chooseCartMonth(String cartMonth) {
        cartMonthSelect.click();
        try {
            for(WebElement element : listCartMonth) {
                if(element.getText().contains(cartMonth) || element.equals(listCartMonth.get(listCartMonth.size() - 1)))
                    element.click();
            }
        }
        catch(StaleElementReferenceException ex)
        {
            for(WebElement element : listCartMonth) {
                if(element.getText().equals(cartMonth) || element.equals(listCartMonth.get(listCartMonth.size() - 1)))
                    element.click();
            }
        }
    }

    public void chooseCartYear(String cartYear) {
        cartYearSelect.click();
        try {
            for(WebElement element : listCartYear) {
                if(element.getText().contains(cartYear) || element.equals(listCartYear.get(listCartYear.size() - 1)))
                    element.click();
            }
        }
        catch(StaleElementReferenceException ex)
        {
            for(WebElement element : listCartYear) {
                if(element.getText().equals(cartYear) || element.equals(listCartYear.get(listCartYear.size() - 1)))
                    element.click();
            }
        }
    }

    public String clickPlaceOrderBut() {
        invisibilityPreLoader();
        String price = totalPrice.getText();
        for(WebElement element : listPlaceOrderBut) {
            boolean res = element.isDisplayed();
            if( res == true) {
                element.click();
                return price;
            } else continue;
        }
        return  price;
    }

    public void clickCheckboxTermCond() {
        invisibilityPreLoader();
        for(WebElement element : listCheckboxTermCond) {
            boolean res = element.isDisplayed();
            if( res == true) {
                Actions build = new Actions(driver);
                build.moveToElement(element, 1, 1).click().build().perform();
                return;
            } else continue;
        }
    }

    public void waitCartNumberFieldVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(cartNumberField));
    }
}
