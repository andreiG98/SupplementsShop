package shop.domain.entity;

public class Customer extends Person{
    private String email;
    private String password;
    private String address;
    private static int currentClient = 0;

//    public Customer(String name, long CNP, String phoneNumber, String email, String password, String address) {
//        super(++currentClient, name, CNP, phoneNumber);
//        this.email = email;
//        this.password = password;
//        this.address = address;
//    }
//
//    public Customer(Customer customer) {
//        super(customer);
//        this.address = customer.address;
//        this.email = customer.email;
//        this.password = customer.password;
//    }


    protected String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public static int getCurrentClient() {
        return currentClient;
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
