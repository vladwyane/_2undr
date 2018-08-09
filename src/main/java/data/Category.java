package data;

public enum Category {

    DAYSHIFT("DAY SHIFT", 11),
    NIGTSHIFT("NIGHT SHIFT", 3),
    GEARSHIFT("GEAR SHIFT", 16),
    SWINGSHIFT("SWING SHIFT", 69);

    public String getCollectionName() {
        return collectionName;
    }
    public int getAmountProduct() { return  amountProduct;}

    private String collectionName;
    private int amountProduct;

    Category(String collectionName, int amountProduct) {
        this.collectionName = collectionName;
        this.amountProduct = amountProduct;
    }
}
