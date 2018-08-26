package data;

public enum Products {

    GEAR_SHIFT_NIGHT_COMO("Underwear", "Gear Shift 9\" Long Leg - BLACK | NIGHT CAMO", "2U03LL-NC.037", "37", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "2U03LLNC.png", "2U03LLB.png", "5", "1", "NIGHT CAMO"),
    GEAR_SHIFT_NIGHT_COMO2("Underwear", "Gear Shift 9\" Long Leg - BLACK | NIGHT CAMO", "2U03LL-NC.037", "37", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "2u05ll-036_1_1.jpg", "2u05ll-036_1_1.jpg", "5", "1", "NIGHT CAMO"),
    GEAR_SHIFT_BLUE_RIBBON("Underwear", "Gear Shift 9\" Long Leg - Blue Ribbon", "2U03LL-BR.039", "39", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "2U03LLBR.png", "2U03LLBR.png", "10", "1", "Blue Ribbon");


    public String getAttributeSet() {
        return attributeSet;
    }

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

    public String getFirstImage() {
        return firstImage;
    }

    public String getSecondImage() {
        return secondImage;
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
    private String quantity;
    private String weight;
    private String color;

    Products(String attributeSet, String name, String sku, String price, String visibility, String category, String country,
             String style, String dimension, String model, String firstImage, String secondImage, String quantity, String weight, String color) {
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
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.quantity = quantity;
        this.weight = weight;
        this.color = color;
    }
}
