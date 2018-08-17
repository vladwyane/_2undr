package adminMagentaTest;

import data.Products;
import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.adminMagenta.Catalog;
import pages.adminMagenta.Customers;
import pages.adminMagenta.Dashbord;
import testBase.TestBase;
import utils.Wait;

public class MagentaCatalogTest extends TestBase{

    private Dashbord dashbord = PageFactory.initElements(initDriver(), Dashbord.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private Catalog catalog = PageFactory.initElements(initDriver(), Catalog.class);

    @BeforeMethod
    public void preCondition() {
        dashbord.open();
        dashbord.signIn(Users.ADMIN);
    }

    @Test(description = "Test of creating product from admin")
    public void testCreateProductGearShiftBlack() throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.GEAR_SHIFT_NIGHT_COMO);
        catalog.chooseRelatedProducts(5);
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.GEAR_SHIFT_NIGHT_COMO);
        catalog.uploadProductImage(Products.GEAR_SHIFT_NIGHT_COMO, 2);
        catalog.chooseUndewearColor(Products.GEAR_SHIFT_NIGHT_COMO);
        catalog.saveProduct();
    }

    @Test(description = "Test of creating product from admin")
    public void testCreateProductGearShiftBlue() throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.GEAR_SHIFT_BLUE_RIBBON);
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.GEAR_SHIFT_BLUE_RIBBON);
        catalog.uploadProductImage(Products.GEAR_SHIFT_BLUE_RIBBON, 1);
        catalog.chooseUndewearColor(Products.GEAR_SHIFT_BLUE_RIBBON);
        catalog.saveProduct();
    }



}
