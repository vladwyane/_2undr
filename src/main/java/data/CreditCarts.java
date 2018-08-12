package data;

public enum CreditCarts {
    VISA("4111111111111111", "JANUARY", "2020", "123"),
    MASTERCART("5555555555554444", "APRIL", "2021", "989"),
    AMERICANEXPRESS("378282246310005", "JUNE", "2019", "091"),
    DINNERSCLUB("38520000023237", "MAY", "2020", "011"),
    DISCOVER("6011000990139424", "SEPTEMBER", "2021", "787"),
    JCB("3566002020360505", "OCTOBER", "2022", "936");

    private String cartNumber;
    private String cartMonth;

    public String getCartNumber() {
        return cartNumber;
    }

    public String getCartMonth() {
        return cartMonth;
    }

    public String getCartYear() {
        return cartYear;
    }

    public String getCartCVN() {
        return cartCVN;
    }

    private String cartYear;
    private String cartCVN;

    CreditCarts(String cartNumber, String cartMonth, String cartYear, String cartCVN) {
        this.cartNumber = cartNumber;
        this.cartMonth = cartMonth;
        this.cartYear = cartYear;
        this.cartCVN = cartCVN;
    }
}
