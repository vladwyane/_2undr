package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bigdrop on 8/13/2018.
 */
public class SuccessOrder extends BasePage{

    public SuccessOrder(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(css= "h2.page-title")
    private WebElement pageTitle;

    @FindBy(css= ".sub-title")
    private WebElement subTitle;

    @FindBy(css= "a.order-number")
    private WebElement orderNumber;

    @FindBy(css= "a.continue")
    private WebElement continueBut;

    public String clickOrderNumber() {
        String ordNum = orderNumber.getText();
        orderNumber.click();
        return ordNum;
    }
}
