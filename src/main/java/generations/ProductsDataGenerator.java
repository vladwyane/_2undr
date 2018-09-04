package generations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Products;
import data.ProductsData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigdrop on 9/4/2018.
 */
public class ProductsDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ProductsData> productsData = generateNightShifProducts(count);
        save(productsData, file);
    }

    private static void save(List<ProductsData> productsData, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(productsData);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static List<ProductsData> generateNightShifProducts(int count) {
        List<ProductsData> productsData = new ArrayList<ProductsData>();
        for (int i = 0; i < count; i++) {
            productsData.add(new ProductsData().setAttributeSet(String.format("Underwear")).setName(String.format("Test" + (i + 1) + " Night Shift 6\" Boxer Brief - Color " + (i + 1)))
                    .setSku(String.format("2U02BB-C" + (i + 1) + ".0" + (30 + i))).setPrice(String.format("" + (30 + i) + "")).setVisibility(String.format("Catalog, Search"))
                    .setCategory(String.format("Night Shift")).setCountry(String.format("China")).setStyle(String.format("Boxer Brief")).setDimension(String.format("14x9x6"))
                    .setModel(String.format("Night Shift Boxer Brief")).setFirstImage(String.format("NightShift" + (i + 1) + ".1.png"))
                    .setSecondImage((String.format("NightShift" + (i + 1) + ".2.png"))).setThirdImage(String.format("NightShift" + (i + 1) + ".3.png"))
                    .setQuantity(String.format("" + (10 + i) + "")).setWeight(String.format("1")).setColor(String.format("" + (i + 1) + "")));
        }
        return productsData;
    }
}
