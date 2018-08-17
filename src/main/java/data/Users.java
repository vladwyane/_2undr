package data;

public enum Users {

    DWYANE("Dwyane", "Wade", "Dwyane@i.ua", "JR6GMs4ywG", "3275 NW 24th Street Rd", "Soft Industry", "Miami", "Alabama", "33101", "123-456-7890", "United States"),
    LEBRON("Lebron", "James", "vladwyane@gmail.com", "JR6GMs4ywG", "3275 NW 24th Street Rd", "Soft Industry", "Miami", "Florida", "33101", "(123) 456-7890", "United States"),
    VLADYSLAV("Vladyslav", "Chesalov", "vladyslav.chesalov@bigdropinc.com", "JR6GMs4ywG", "3275 NW 24th Street Rd", "Soft Industry", "Miami", "Florida", "33101", "(123) 456-7890", "United States"),
    INVALID("Invalid", "Incorrect", "vladwyane@gmail.com", "Invalid19", "3275 NW 24th Street Rd", "Soft Industry", "Miami", "Born", "33101", "123-456-7890", "Canada"),
    ADMIN("TestAdmin", "Incorrect", "testing", "dwzXBQ6K5iGx", "3275 NW 24th Street Rd", "Soft Industry", "Miami", "Born", "33101", "123-456-7890", "Canada");

    public String getFirstUserName() {
        return userFirstName;
    }

    public String getLastUserName() {
        return userLastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getStAddress() {
        return stAddress;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCountry() {
        return country;
    }

    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;
    private String stAddress;
    private String company;
    private String city;
    private String state;
    private String zipCode;
    private String telephone;
    private String country;

    Users(String userFirstName, String userLastName, String email, String password, String stAddress,
          String company, String city, String state, String zipCode, String telephone, String country) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.stAddress = stAddress;
        this.company = company;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.telephone = telephone;
        this.country = country;
    }
}
