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
    public void testAdminSignIn() throws Exception {
        dashbord.signIn(Users.ADMIN);
        catalog.clickCatalogNavItem();
        catalog.clickProductSubNavItem();
        catalog.clickAddNewProductBut();
        catalog.chooseAttributSet("Underwear");
        catalog.fillProductAttribute();
        catalog.chooseVisibilityValue("Catalog, Search");
        catalog.chooseCategory("Underwear", "Collections", "Day Shift");
        catalog.chooseCountryOfManufac("China");
        catalog.chooseProductStyle("Boxer Brief");
        catalog.fillDimensionField();
        catalog.chooseProductModel("Day Shift Boxer Brief");
        catalog.fillProductContent();
        wait.threadsSleepWait();
    }

}
