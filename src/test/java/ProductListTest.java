import data.Category;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Collections;
import pages.CreateAccount;
import testBase.TestBase;
import utils.Wait;

public class ProductListTest extends TestBase{

    private Collections collections  = PageFactory.initElements(initDriver(), Collections.class);

    @BeforeMethod
    public void preCondition() {
        collections.open();
    }

    @Test(description = "Test of counting amount of all goods")
    public void testAmountOfAllGoods() throws InterruptedException {
        int amountProductWithImage = collections.amountProductWithImage();
        collections.checkAmountProductImage(amountProductWithImage);
    }

    @Test(description = "Test of counting amount of day shift category")
    public void testAmountOfDayShiftGoods() throws InterruptedException {
        collections.chooseCollections(Category.DAYSHIFT);
        int amountProductWithImage = collections.amountProductWithImage();
        collections.checkAmountProductImage(amountProductWithImage);
    }

    @Test(description = "Test of counting amount of swing shift category")
    public void testAmountOfSwingShiftGoods() throws InterruptedException {
        collections.chooseCollections(Category.SWINGSHIFT);
        int amountProductWithImage = collections.amountProductWithImage();
        collections.checkAmountProductImage(amountProductWithImage);
    }

    @Test(description = "Test of counting amount of night shift category")
    public void testAmountOfNightShiftGoods() throws InterruptedException {
        collections.chooseCollections(Category.NIGTSHIFT);
        int amountProductWithImage = collections.amountProductWithImage();
        collections.checkAmountProductImage(amountProductWithImage);
    }

    @Test(description = "Test of counting amount of gear shift category")
    public void testAmountOfGearShiftGoods() throws InterruptedException {
        collections.chooseCollections(Category.GEARSHIFT);
        int amountProductWithImage = collections.amountProductWithImage();
        collections.checkAmountProductImage(amountProductWithImage);
    }
}
