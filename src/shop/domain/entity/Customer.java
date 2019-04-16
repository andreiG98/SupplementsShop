package shop.domain.entity;

import java.util.ArrayList;

public class Customer extends Person{
    private String email;
    private String password;
    private String address;
    private static int currentCustomer = 0;

    protected String getPassword() {
        return password;
    }

    public boolean checkPassword (String password) {
        if (this.password.equals(password))
            return true;
        return false;
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

    public static void show (ArrayList<Customer> customers) {
        if (customers.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getId() + " " + customers.get(i).getName() + " " + customers.get(i).getCNP() + " " + customers.get(i).getPhoneNumber()+ " " + customers.get(i).getEmail() + " " + customers.get(i).getAddress());
        }
    }

    @Override
    public String toString() {
        return getName() + ", " + getCNP() + ", " + getPhoneNumber() + ", " + email + ", " + password + ", " + address;
    }
}
