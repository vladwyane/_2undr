package data;

public enum Users {

    DWYANE("Dwyane", "Wade", "Dwyane@i.ua", "JR6GMs4ywG"),
    VLAD("Lebron", "James", "vladwyane@gmail.com", "JR6GMs4ywG"),
    INVALID("Invalid", "Incorrect", "Dwyane@i.ua", "Invalid19");

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

    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;

    Users(String userFirstName, String userLastName, String email, String password) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
    }
}
