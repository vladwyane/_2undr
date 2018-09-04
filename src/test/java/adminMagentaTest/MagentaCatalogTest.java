package adminMagentaTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Products;
import data.ProductsData;
import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.adminMagenta.Catalog;
import pages.adminMagenta.Dashbord;
import testBase.TestBase;
import utils.Wait;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class MagentaCatalogTest extends TestBase{

    private Dashbord dashbord = PageFactory.initElements(initDriver(), Dashbord.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);
    private Catalog catalog = PageFactory.initElements(initDriver(), Catalog.class);

    @DataProvider
    public Iterator<Object[]> validProductsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/products.json")));
        String json = "";
        String line = reader.readLine();
        while(line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ProductsData> productsData = gson.fromJson(json, new TypeToken<List<ProductsData>>(){}.getType());
        return productsData.stream().map((p) -> new Object[] {p}).collect(Collectors.toList()).iterator();
    }

    @BeforeMethod
    public void preCondition() {
        dashbord.open();
        dashbord.signIn(Users.ADMIN);
    }

/*
    @Test(description = "Test of creating product from admin")
    public void testCreateProductGearShiftBlack() throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.GEAR_SHIFT_NIGHT_COMO);
        catalog.chooseRelatedProducts(5, "Night shift");
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

    @Test(description = "Test of creating product from admin")
    public void testCreateProductGearShiftBlue2() throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.GEAR_SHIFT_NIGHT_COMO2);
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.GEAR_SHIFT_NIGHT_COMO2);
        catalog.uploadProductImage(Products.GEAR_SHIFT_NIGHT_COMO2, 1);
        catalog.chooseUndewearColor(Products.GEAR_SHIFT_NIGHT_COMO2);
        catalog.saveProduct();
    }

    @Test(description = "Test of creating product from admin", alwaysRun = true)
    public void testCreateProductNightShiftNavy() throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.NIGHT_SHIFT_NAVY);
        catalog.chooseRelatedProducts(4, "Night shift");
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.NIGHT_SHIFT_NAVY);
        catalog.uploadProductImage(Products.NIGHT_SHIFT_NAVY, 2);
        catalog.chooseUndewearColor(Products.NIGHT_SHIFT_NAVY);
        catalog.saveProduct();
    }
*/



    @Test(dataProvider = "validProductsFromJson")
    public void testCreateProductNightShiftCharcoal(ProductsData productsData) throws Exception {
        catalog.openNewProductForm();
        catalog.fillingProductInfoFromJson(productsData);
        catalog.chooseRelatedProducts(7, "Night shift");
        catalog.fillProductContent();
        catalog.createProductConfigurationFromJson(productsData);
        catalog.uploadProductImageFromJson(productsData, 3);
        catalog.chooseUndewearColorFromJson(productsData);
        catalog.saveProduct();
    }


    @Test(dataProvider = "validProductsFromJson")
    public void testCreateProductSwingShiftCharcoal(ProductsData productsData) throws InterruptedException {
        catalog.openNewProductForm();
        catalog.fillingProductInfo(Products.SWING_SHIFT_2_PACK_BLACK_NIGHT_CAMO);
        catalog.chooseRelatedProducts(5, "Swing shift");
        catalog.fillProductContent();
        catalog.createProductConfiguration(Products.SWING_SHIFT_2_PACK_BLACK_NIGHT_CAMO);
        catalog.uploadProductImage(Products.SWING_SHIFT_2_PACK_BLACK_NIGHT_CAMO, 3);
        catalog.saveProduct();
    }



}
