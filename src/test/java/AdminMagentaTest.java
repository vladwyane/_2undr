import data.Products;
import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.adminMagenta.Catalog;
import pages.adminMagenta.Dashbord;
import testBase.TestBase;
import utils.Wait;

public class AdminMagentaTest extends TestBase{

    private Dashbord dashbord = PageFactory.initElements(initDriver(), Dashbord.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private Catalog catalog = PageFactory.initElements(initDriver(), Catalog.class);

    @BeforeMethod
    public void preCondition() {
        dashbord.open();
    }

    @Test(description = "Test of counting amount of all goods")
    public void testCreateProduct() throws Exception {
        dashbord.signIn(Users.ADMIN);
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.SWING_SHIFT_BURGUNDY);
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.SWING_SHIFT_BURGUNDY);
        catalog.uploadProductImage(Products.SWING_SHIFT_BURGUNDY);
        catalog.chooseUndewearColor(Products.SWING_SHIFT_BURGUNDY);
        catalog.saveProduct();
        wait.threadsSleepWait();
    }

}
