import data.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Collections;
import pages.CreateAccount;
import pages.account.AccountWishList;
import pages.popUps.AccountPopup;
import testBase.TestBase;

public class AccountWishListTest extends TestBase {

    private CreateAccount createAccount  = PageFactory.initElements(initDriver(), CreateAccount.class);
    private AccountWishList accountWishList  = PageFactory.initElements(initDriver(), AccountWishList.class);
    private Collections collections  = PageFactory.initElements(initDriver(), Collections.class);
    private AccountPopup accountPopup = PageFactory.initElements(initDriver(), AccountPopup.class);

    @BeforeMethod
    public void preCondition() {
        createAccount.open();
    }

    @Test(description = "Test of counting amount of all goods")
    public void testAmountOfAllGoods() throws Exception {
        accountPopup.signIn(Users.LEBRON);
        collections.open();
        String webElementTitleAddedToWishList = collections.addProductInStockToWishList(45);
        accountWishList.checkAccountWishList(webElementTitleAddedToWishList);
    }
}
