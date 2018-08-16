package data;

public enum Products {

    SWING_SHIFT_BURGUNDY("Underwear", "Gear Shift 9\" Long Leg - Crimson", "2U05LL.029", "29", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "2u05ll-036_1_1.jpg", "10", "1", "Crimson");


    public String getAttributeSet() {
        return attributeSet;
    }

    private String attributeSet;

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public String getPrice() {
        return price;
    }
    public String getVisibility() {
        return visibility;
    }

    public String getCategory() {
        return category;
    }

    public String getCountry() {
        return country;
    }

    public String getStyle() {
        return style;
    }


    public String getDimension() {
        return dimension;
    }

    public String getModel() {
        return model;
    }

    public String getImageName() {
        return imageName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    private String name;
    private String sku;
    private String price;
    private String visibility;
    private String category;
    private String country;
    private String style;
    private String dimension;
    private String model;
    private String imageName;
    private String quantity;
    private String weight;
    private String color;

    Products(String attributeSet, String name, String sku, String price, String visibility, String category, String country,
             String style, String dimension, String model, String imageName, String quantity, String weight, String color) {
        this.attributeSet = attributeSet;
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.visibility = visibility;
        this.category = category;
        this.country = country;
        this.style = style;
        this.dimension = dimension;
        this.model = model;
        this.imageName = imageName;
        this.quantity = quantity;
        this.weight = weight;
        this.color = color;


    }
}
