package pages.popUps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.SearchResult;

public class SearchPopup extends BasePage{
    public SearchPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "search")
    private WebElement searchField;

    public void enterSearchField(String request) {
        searchField.clear();
        searchField.sendKeys(request);
    }

    @FindBy(xpath = "//*[@title='Search']")
    private WebElement serchSubmit;

    public SearchResult clickSerchSubmit() {
        serchSubmit.click();
        return new SearchResult(driver);
    }
}
