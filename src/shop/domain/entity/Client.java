package shop.domain.entity;

public class Client extends Person{
    private String email;
    private String password;
    private String address;
    private static int currentClient = 0;

    public Client(String name, long CNP, String phoneNumber, String email, String password, String address) {
        super(++currentClient, name, CNP, phoneNumber);
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Client(Client client) {
        super(client);
        this.address = client.address;
        this.email = client.email;
        this.password = client.password;
    }

    public String getEmail() {
        return email;
    }
}
