package data;

/**
 * Created by bigdrop on 9/4/2018.
 */
public class ProductsData {

    private String attributeSet;
    private String name;
    private String sku;
    private String price;
    private String visibility;
    private String category;
    private String country;
    private String style;
    private String dimension;
    private String model;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String quantity;
    private String weight;
    private String color;

    public String getAttributeSet() {
        return attributeSet;
    }

    public ProductsData setAttributeSet(String attributeSet) {
        this.attributeSet = attributeSet;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductsData setName(String name) {
        this.name = name;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProductsData setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ProductsData setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getVisibility() {
        return visibility;
    }

    public ProductsData setVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductsData setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProductsData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public ProductsData setStyle(String style) {
        this.style = style;
        return this;

    }

    public String getDimension() {
        return dimension;
    }

    public ProductsData setDimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ProductsData setModel(String model) {
        this.model = model;
        return this;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public ProductsData setFirstImage(String firstImage) {
        this.firstImage = firstImage;
        return this;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public ProductsData setSecondImage(String secondImage) {
        this.secondImage = secondImage;
        return this;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public ProductsData setThirdImage(String thirdImage) {
        this.thirdImage = thirdImage;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public ProductsData setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public ProductsData setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ProductsData setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "ProductsData{" + "Name = '" + name + "'}";
    }

}
