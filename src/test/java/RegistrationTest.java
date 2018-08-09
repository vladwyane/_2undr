import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccount;
import pages.account.MyAccount;
import pages.popUps.AccountPopup;
import testBase.TestBase;
import utils.Wait;

public class RegistrationTest extends TestBase{

    private AccountPopup accountPopup = PageFactory.initElements(initDriver(), AccountPopup.class);
    private CreateAccount createAccount = PageFactory.initElements(initDriver(), CreateAccount.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private MyAccount myAccount = PageFactory.initElements(initDriver(), MyAccount.class);

    @BeforeMethod
    public void preCondition() {
        createAccount.open();
    }

    @AfterMethod
    public void postCondition() {
        accountPopup.logOut();
    }

    @Test(description = "Test of registration user with newsletter and valid data", priority = 1)
    public void testRegistrationUser() throws InterruptedException {
        accountPopup.clickCreateAccBut();
        createAccount.registrationWithNewsletter(Users.VLAD);
        myAccount.invisibilityPreLoader();
        myAccount.checkSuccessMes();
    }

    @Test(description = "Test of login user with valid data", priority = 2)
    public void testLoginUser() throws InterruptedException {
        accountPopup.signIn(Users.VLAD);
        myAccount.invisibilityPreLoader();
        myAccount.checkTitle();
    }

    @Test(description = "Test of login user with invalid data",priority = 3)
    public void testLoginInvalid() throws InterruptedException {
        accountPopup.signIn(Users.INVALID);
        myAccount.invisibilityPreLoader();
        myAccount.checkErrorPasswordMes();
    }

    @Test(description = "Test of registration with already existing data",priority = 4)
    public void testErrorRegistration() throws InterruptedException {
        accountPopup.clickCreateAccBut();
        createAccount.registrationWithNewsletter(Users.VLAD);
        myAccount.invisibilityPreLoader();
        myAccount.checkErrorAlreadyAccMes();
    }
}
