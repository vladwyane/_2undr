package adminMagentaTest;

import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.adminMagenta.Catalog;
import pages.adminMagenta.Customers;
import pages.adminMagenta.Dashbord;
import testBase.TestBase;
import utils.Wait;

/**
 * Created by bigdrop on 8/17/2018.
 */
public class MagentaCustomersTest extends TestBase {

    private Dashbord dashbord = PageFactory.initElements(initDriver(), Dashbord.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private Customers customers = PageFactory.initElements(initDriver(), Customers.class);

    @BeforeMethod
    public void preCondition() {
        dashbord.open();
        dashbord.signIn(Users.ADMIN);
    }

    @Test(description = "Test of creating product from admin")
    public void testCreateNewCustomer() throws Exception {
       customers.openNewCustomerForm();
       customers.fillAccountInfo(Users.VLADYSLAV);
       customers.fillAddressInfo(Users.VLADYSLAV);
       wait.threadsSleepWait();


    }
}
