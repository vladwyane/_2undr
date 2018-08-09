import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Collections;
import pages.ShippingMethod;
import pages.ShoppingCart;
import testBase.TestBase;
import utils.Wait;

public class MakeOrderTest extends TestBase{

    private Collections collections  = PageFactory.initElements(initDriver(), Collections.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private ShoppingCart shoppingCart  = PageFactory.initElements(initDriver(),  ShoppingCart.class);
    private ShippingMethod shippingMethod  = PageFactory.initElements(initDriver(),  ShippingMethod.class);


    @Test(description = "Test of counting amount of all goods")
    public void testOrder() throws Exception {
        collections.open();
        collections.addProductInStockToShopCart(34.0, "2");

    }
}
