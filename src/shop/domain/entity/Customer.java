package shop.domain.entity;

public class Customer extends Person{
    private String email;
    private String password;
    private String address;
    private static int currentCustomer = 0;

    protected String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public static int getCurrentCustomer() {
        return currentCustomer;
    }

    public static void increaseCurrentCustomer() {
        Customer.currentCustomer++;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
