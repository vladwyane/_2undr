package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/28/2018.
 */
public class Page404 extends  BasePage{

    public Page404(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
        invisibilityPreLoader();
    }

    @FindBy(css = ".error")
    private WebElement error404;

    public void checkAllVisibleLinks(int startFromIndex) throws InterruptedException {
        int indexBlankLink = 0;
        for (int i = startFromIndex; i < allLinkOnPage.size(); i++) {
            if(checkHTMLAttribute(allLinkOnPage.get(i), "href", "https://2undr.bigdropinc.net/#") == true) {
                indexBlankLink = i;
                System.out.println("Blank link is " + i );
                open();
            } if(isElementClickable(allLinkOnPage.get(i)) == true) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-100);", allLinkOnPage.get(i));
                Thread.sleep(500);
                allLinkOnPage.get(i).click();
                if(check404PageAvaliable() == true) {
                    indexBlankLink = i;
                    System.out.println("Error 404 link is " + i);
                    open();
                } else {
                    System.out.println(i);
                    open();
                }
            }
        }
        softAssert.assertEquals(indexBlankLink, 0);
        softAssert.assertAll();
    }

    public boolean check404PageAvaliable() {
        return isElementPresent(error404);
    }
}
