package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners(MyTestListener.class)
public class TestBase {
    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public WebDriver initDriver() {
        if (app.getDriver() == null) {
            app.setup();
            app.unit();
        }
        return app.getDriver();
    }

    @BeforeMethod
    public void screenShot(ITestContext context) {
        context.setAttribute("app", app);
    }


    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
