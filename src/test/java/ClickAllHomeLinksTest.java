import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Page404;
import testBase.TestBase;

/**
 * Created by bigdrop on 8/28/2018.
 */
public class ClickAllHomeLinksTest extends TestBase {

    private Page404 page404 = PageFactory.initElements(initDriver(), Page404.class);

    @Test(description = "Test of counting amount of all goods")
    public void testAmountOfAllGoods() throws InterruptedException {
        page404.open();
        page404.checkAllVisibleLinks(0);
    }
}
