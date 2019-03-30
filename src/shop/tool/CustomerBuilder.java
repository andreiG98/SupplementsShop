package shop.tool;

import shop.domain.entity.Customer;

public class CustomerBuilder {
    private final Customer target = new Customer();

    public CustomerBuilder withId () {
        Customer.increaseCurrentCustomer();
        int currentCustomer = Customer.getCurrentCustomer();
        target.setId(currentCustomer);
        return this;
    }

    public CustomerBuilder withName (String name) {
        target.setName(name);
        return this;
    }

    public CustomerBuilder withCNP (String CNP) {
        target.setCNP(CNP);
        return this;
    }

    public CustomerBuilder withPhoneNumber (String phoneNumber) {
        target.setPhoneNumber(phoneNumber);
        return this;
    }

    public CustomerBuilder withEmail (String email) {
        target.setEmail(email);
        return this;
    }

    public CustomerBuilder withPassword (String password) {
        target.setPassword(password);
        return this;
    }

    public CustomerBuilder withAddress (String address) {
        target.setAddress(address);
        return this;
    }

    public Customer build() {
        return target;
    }

}
