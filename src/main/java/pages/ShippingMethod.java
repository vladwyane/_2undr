package pages;

import data.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.util.List;

public class ShippingMethod extends BasePage {

    public ShippingMethod(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("checkout.url"));
        invisibilityPreLoader();
    }

    @FindBy(name = "firstname")
    private WebElement firstNameField;

    @FindBy(name = "lastname")
    private WebElement lastNameField;

    @FindBy(name = "company")
    private WebElement companyField;

    @FindBy(name = "street[0]")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "telephone")
    private WebElement telField;

    @FindBy(name = "postcode")
    private WebElement zipCodeField;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    private WebElement stateSelect;

    @FindBys( {@FindBy(xpath = "//li[@class='select2-results__option']")} )
    private List<WebElement> listState;

    @FindBys( {@FindBy(xpath = "//td[contains(@id, 'label_method')]")} )
    private List<WebElement> listShippingMethod;

    @FindBy(css = "button.continue")
    private WebElement continueBut;

    @FindBy(css = ".shipping-address-item.selected-item")
    private WebElement shippingAddressSelected;

    @FindBy(css = ".checkout-shipping-method .step-title")
    private WebElement shippingMethodTitle;


    public void chooseState(String stateName) {
        stateSelect.click();
        try {
            for(WebElement element : listState) {
                if(element.getText().equals(stateName) || element.equals(listState.get(listState.size() - 1)))
                    element.click();
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            for(WebElement element : listState) {
                if(element.getText().equals(stateName) || element.equals(listState.get(listState.size() - 1)))
                    element.click();
            }
        }
    }

    public void fillShippingAddressForUSA(Users users) {
        if(isElementPresent(shippingAddressSelected)  == false) {
            waitShippingTitleVisible();
            type(firstNameField, users.getFirstUserName());
            type(lastNameField, users.getLastUserName());
            type(companyField, users.getCompany());
            type(addressField, users.getStAddress());
            type(cityField, users.getCity());
            type(zipCodeField, users.getZipCode());
            type(telField, users.getTelephone());
            chooseState(users.getState());
        }
    }

    public void chooseShippingMethod() {
        waitShippingMethodLoading();
        for (int i = 0; i < listShippingMethod.size(); i++) {
            if(listShippingMethod.get(i).getText().equals("Free")) {
                listShippingMethod.get(i).click();
                return;
            }
        }
        listShippingMethod.get(0).click();
    }

    public PaymentMethod clickContinueBut() {
        continueBut.click();
        return  new PaymentMethod(driver);
    }

    public void waitShippingTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(shippingMethodTitle));
    }

    public void waitShippingMethodLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#opc-shipping_method._block-content-loading")));
    }
}
