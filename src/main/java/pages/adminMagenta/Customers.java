package pages.adminMagenta;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

/**
 * Created by bigdrop on 8/17/2018.
 */
public class Customers extends BasePage{

    public Customers(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "menu-magento-customer-customer")
    private WebElement customerNavItem;

    @FindBy(css = ".item-customer-manage.level-1")
    private WebElement allCustomersSubNavItem;

    @FindBy(id = "add")
    private WebElement addNewCustomers;

    @FindBy(name = "customer[firstname]")
    private WebElement firstNameField;

    @FindBy(name = "customer[lastname]")
    private WebElement lastNameField;

    @FindBy(name = "customer[email]")
    private WebElement emailField;

    @FindBy(id = "tab_address")
    private WebElement tabAddress;

    @FindBy(css = ".scalable.add")
    private WebElement addNewAddressBut;

    @FindBys( {@FindBy(css = ".admin__field.admin__field-option")} )
    private List<WebElement> listAddress;

    @FindBy(name = "address[new_0][firstname]")
    private WebElement addressFirstNameField;

    @FindBy(name = "address[new_0][lastname]")
    private WebElement addressLastNameField;

    @FindBy(name = "address[new_0][street][0]")
    private WebElement addressStreetField;

    @FindBy(name = "address[new_0][city]")
    private WebElement cityField;

    @FindBy(name = "address[new_0][country_id]")
    private WebElement countrySelect;

    @FindBys( {@FindBy(xpath = "//select[@name='address[new_0][country_id]']/option")} )
    private List<WebElement> listCountry;

    @FindBy(xpath = "//select[@name='address[new_0][region_id]']")
    private WebElement regionSelect;

    @FindBy(name = "address[new_0][region_id]")
    private WebElement regionField;

    @FindBys( {@FindBy(xpath = "//select[@name='address[new_0][region_id]']/option")} )
    private List<WebElement> listState;

    @FindBy(name = "address[new_0][postcode]")
    private WebElement addressPostCodeField;

    @FindBy(name = "address[new_0][telephone]")
    private WebElement addressPhoneField;

    @FindBy(id = "save")
    private WebElement saveCustomBut;

    @FindBy(name = "customer[website_id]")
    private WebElement websiteSelect;


    public void openNewCustomerForm() {
        invisibilityPreLoader();
        customerNavItem.click();
        invisibilityPreLoader();
        allCustomersSubNavItem.click();
        invisibilityPreLoader();
        addNewCustomers.click();
    }

    public void fillAccountInfo(Users users) {
        type(emailField, users.getEmail());
        type(lastNameField, users.getLastUserName());
        type(firstNameField, users.getFirstUserName());
        websiteSelect.click();
    }

    public void fillAddressInfo(Users users) {
        tabAddress.click();
        addNewAddressBut.click();
        invisibilityPreLoader();
        chooseAddressCheckbox("Default Billing Address");
        type(addressStreetField, users.getStAddress());
        type(cityField, users.getCity());
        chooseCountryAndRegion(users.getCountry(), users.getState(), users.getZipCode());
        type(addressPostCodeField, users.getZipCode());
        type(addressPhoneField, users.getTelephone());

    }

    public void chooseAddressCheckbox(String address) {
        for (WebElement element : listAddress){
            if(element.getText().equals(address)) {
                element.click();
                return;
            }
        }
    }

    public void chooseCountryAndRegion(String country, String region, String postCode) {
        countrySelect.click();
        boolean successSelect = false;
        for (WebElement element : listCountry){
            if(element.getText().equals(country)) {
                successSelect = true;
                element.click();
                break;
            }
        }
        if (successSelect == false)
            listCountry.get(listCountry.size() - 1).click();
        invisibilityPreLoader();
        successSelect = false;
        if(country.equals("Canada") || country.equals("United States")) {
            regionSelect.click();
            for (WebElement element : listState){
                String value = element.getText();
                if(element.getText().equals(region)) {
                    successSelect = true;
                    element.click();
                    break;
                }
            }
            if (successSelect == false)
                listState.get(listState.size() - 1).click();
        }
        else type(regionField, region);
    }

    public Dashbord saveNewCustomer() {
        saveCustomBut.click();
        invisibilityPreLoader();
        return new Dashbord(driver);
    }
}
