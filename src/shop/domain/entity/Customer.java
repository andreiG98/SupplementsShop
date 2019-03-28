package shop.domain.entity;

public class Customer extends Person{
    private String email;
    private String password;
    private String address;
    private static int currentClient = 0;

    public Customer(String name, long CNP, String phoneNumber, String email, String password, String address) {
        super(++currentClient, name, CNP, phoneNumber);
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Customer(Customer customer) {
        super(customer);
        this.address = customer.address;
        this.email = customer.email;
        this.password = customer.password;
    }

    public String getEmail() {
        return email;
    }
}
