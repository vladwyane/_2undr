package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ConfigProperties;

import java.util.ArrayList;

/**
 * Created by bigdrop on 8/28/2018.
 */
public class Page404 extends  BasePage{

    public Page404(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("page404.url"));
        invisibilityPreLoader();
    }

    @FindBy(css = ".error")
    private WebElement error404;

    public void openPage(String url) {
        driver.get(ConfigProperties.getProperty(url));
        invisibilityPreLoader();
    }

    public void checkAllVisibleLinks(int startFromIndex, String url) throws InterruptedException {
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        ArrayList<Integer> actualList = new ArrayList<Integer>();
        for (int i = startFromIndex; i < allLinkOnPage.size(); i++) {
            if(checkHTMLAttribute(allLinkOnPage.get(i), "href", "https://2undr.bigdropinc.net/#") == true) {
                System.out.println("Blank link is " + i );
                actualList.add(i);
                openPage(url);
            }
            if(isElementClickable(allLinkOnPage.get(i)) == true) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-100);", allLinkOnPage.get(i));
                Thread.sleep(500);
                allLinkOnPage.get(i).click();
                if(check404PageAvaliable() == true) {
                    System.out.println("Error 404 link is " + i);
                    actualList.add(i);
                    openPage(url);
                } else {
                    openPage(url);
                }
            }
        }
        softAssert.assertEquals(actualList, expectedList);
        softAssert.assertAll();
    }

    public boolean check404PageAvaliable() {
        return isElementPresent(error404);
    }
}
