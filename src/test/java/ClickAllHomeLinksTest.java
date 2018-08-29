import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Page404;
import testBase.TestBase;

/**
 * Created by bigdrop on 8/28/2018.
 */
public class ClickAllHomeLinksTest extends TestBase {

    private Page404 page404 = PageFactory.initElements(initDriver(), Page404.class);


    @Test(description = "Test all links of the page")
    public void testCheckAllLinksTechnology() throws InterruptedException {
        page404.openPage("technology.url");
        page404.checkAllVisibleLinks(44, "technology.url");
    }

}
