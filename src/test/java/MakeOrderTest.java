import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Category;
import data.CreditCarts;
import data.ProductsData;
import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountMyOrders;
import pages.popUps.AccountPopup;
import testBase.TestBase;
import utils.Wait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MakeOrderTest extends TestBase{

    private CreateAccount createAccount  = PageFactory.initElements(initDriver(), CreateAccount.class);
    private AccountPopup accountPopup = PageFactory.initElements(initDriver(), AccountPopup.class);
    private Collections collections  = PageFactory.initElements(initDriver(), Collections.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private ShoppingCart shoppingCart  = PageFactory.initElements(initDriver(),  ShoppingCart.class);
    private ShippingMethod shippingMethod  = PageFactory.initElements(initDriver(),  ShippingMethod.class);
    private PaymentMethod paymentMethod  = PageFactory.initElements(initDriver(), PaymentMethod.class);
    private SuccessOrder successOrder = PageFactory.initElements(initDriver(), SuccessOrder.class);
    private AccountMyOrders accountMyOrders = PageFactory.initElements(initDriver(), AccountMyOrders.class);

    @BeforeMethod
    public void preCondition() {
        createAccount.open();
    }

    @Test(description = "Test of making order using credit Cat")
    public void testMakeOrderUsingCreditCart() throws Exception {
        accountPopup.signIn(Users.LEBRON);
        collections.open();
      //  collections.chooseCollections(Category.GEARSHIFT);
        collections.addProductInStockToShopCart(35.0, "5");
        shoppingCart.open();
        shoppingCart.clickCheckoutBut();
        shippingMethod.fillShippingAddressForUSA(Users.LEBRON);
        shippingMethod.chooseShippingMethod();
        shippingMethod.clickContinueBut();
        paymentMethod.choosePaymentMethod("CreditCart");
        paymentMethod.fillPaymentInfo(CreditCarts.VISA);
        paymentMethod.clickCheckboxTermCond();
        paymentMethod.clickPlaceOrderBut();
    }

    @Test(description = "Test of making order using check")
    public void testMakeOrderUsingCheck() throws Exception {
        accountPopup.signIn(Users.LEBRON);
        collections.open();
        collections.chooseCollections(Category.GEARSHIFT);
        String titleAddedToShoppingCart = collections.addProductInStockToShopCart(30.0, "1");
        shoppingCart.open();
        shoppingCart.clickCheckoutBut();
        shippingMethod.fillShippingAddressForUSA(Users.LEBRON);
        shippingMethod.chooseShippingMethod();
        shippingMethod.clickContinueBut();
        paymentMethod.choosePaymentMethod("Check");
        paymentMethod.clickCheckboxTermCond();
        String totalPrice = paymentMethod.clickPlaceOrderBut();
        String orderNumber = successOrder.clickOrderNumber();
        accountMyOrders.checkAccountOrder(orderNumber, titleAddedToShoppingCart, totalPrice);
    }
}
