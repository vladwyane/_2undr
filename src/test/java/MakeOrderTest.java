import data.CreditCarts;
import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.popUps.AccountPopup;
import testBase.TestBase;
import utils.Wait;

public class MakeOrderTest extends TestBase{

    private CreateAccount createAccount  = PageFactory.initElements(initDriver(), CreateAccount.class);
    private AccountPopup accountPopup = PageFactory.initElements(initDriver(), AccountPopup.class);
    private Collections collections  = PageFactory.initElements(initDriver(), Collections.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private ShoppingCart shoppingCart  = PageFactory.initElements(initDriver(),  ShoppingCart.class);
    private ShippingMethod shippingMethod  = PageFactory.initElements(initDriver(),  ShippingMethod.class);
    private PaymentMethod paymentMethod  = PageFactory.initElements(initDriver(), PaymentMethod.class);

    @BeforeMethod
    public void preCondition() {
        createAccount.open();
    }

    @Test(description = "Test of making order using credit Cat")
    public void testMakeOrderUsingCreditCart() throws Exception {
        accountPopup.signIn(Users.LEBRON);
        collections.open();
        collections.addProductInStockToShopCart(91.0, "3");
        shoppingCart.open();
        shoppingCart.clickCheckoutBut();
        shippingMethod.fillShippingAddressForUSA(Users.LEBRON);
        shippingMethod.chooseShippingMethod();
        shippingMethod.clickContinueBut();
        paymentMethod.choosePaymentMethod("CreditCart");
        paymentMethod.fillPaymentInfo(CreditCarts.VISA);
        paymentMethod.clickPlaceOrderBut();
    }

    @Test(description = "Test of making order using check")
    public void testMakeOrderUsingCheck() throws Exception {
        accountPopup.signIn(Users.LEBRON);
        collections.open();
        collections.addProductInStockToShopCart(34.0, "4");
        shoppingCart.open();
        shoppingCart.clickCheckoutBut();
        shippingMethod.fillShippingAddressForUSA(Users.LEBRON);
        shippingMethod.chooseShippingMethod();
        shippingMethod.clickContinueBut();
        paymentMethod.choosePaymentMethod("Check");
        paymentMethod.clickPlaceOrderBut();
        wait.threadsSleepWait();
    }
}
