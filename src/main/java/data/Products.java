package data;

public enum Products {

    GEAR_SHIFT_NIGHT_COMO("Underwear", "Gear Shift 9\" Long Leg - BLACK | NIGHT CAMO", "2U03LL-NC.037", "37", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "images/2U03LLNC.png", "images/2U03LLB.png", "images/2U03LLB.png", "5", "1", "NIGHT CAMO"),
    GEAR_SHIFT_NIGHT_COMO2("Underwear", "Gear Shift 9\" Long Leg - BLACK | NIGHT CAMO", "2U03LL-NC.037", "37", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "2u05ll-036_1_1.jpg", "images/2U03LLB.png", "2u05ll-036_1_1.jpg", "5", "1", "NIGHT CAMO"),
    NIGHT_SHIFT_NAVY("Underwear", "Test Night Shift 6\" Boxer Brief - NAVY", "2U02BB-N.032", "32", "Catalog, Search",
            "Night Shift", "China", "Boxer Brief", "14x9x6", "Night Shift Boxer Brief", "images/2U02BBN.png", "images/2U02BB.jpg", "images/2U03LLB.png","50", "1", "Navy"),
    NIGHT_SHIFT_CHARCOAL("Underwear", "Test Night Shift 6\" Boxer Brief - CHARCOAL", "2U02BB-Ch.033", "33", "Catalog, Search",
            "Night Shift", "China", "Boxer Brief", "14x9x6", "Night Shift Boxer Brief", "images/2U02BBCh.png", "images/2U02BB.jpg", "images/2U03LLB.png","20", "1", "Charcoal"),
    GEAR_SHIFT_BLUE_RIBBON("Underwear", "Gear Shift 9\" Long Leg - Blue Ribbon", "2U03LL-BR.039", "39", "Catalog, Search",
            "Gear Shift", "China", "Long Leg", "14x9x6", "Gear Shift Long Leg", "images/2U03LLBR.png", "images/2U03LLBR.png", "images/2U03LLB.png", "10", "1", "Blue Ribbon"),

    SWING_SHIFT_2_PACK_BLACK_NIGHT_CAMO("Underwear", "SWING SHIFT - 6\" BOXER BRIEF - 2 PACK - BLACK | NIGHT CAMO", "2U012B.083", "45", "Catalog, " +
            "Search", "Swing Shift", "China", "Boxer Brief", "14x9x6", "Swing Shift Boxer Brief", "images/swingshift2pack_black_nightcamo.jpg",
            "images/nightshift_lightgrey_1.jpg", "images/swingshift_nightcamo_1.jpg", "50", "1", "Black");


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

    public String getThirdImage() {
        return thirdImage;
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
    private String thirdImage;
    private String quantity;
    private String weight;
    private String color;

    Products(String attributeSet, String name, String sku, String price, String visibility, String category, String country, String style,
             String dimension, String model, String firstImage, String secondImage, String thirdImage, String quantity, String weight, String color) {
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
        this.thirdImage = thirdImage;
    }
}
