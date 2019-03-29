package shop.domain.repository;

import shop.domain.entity.Customer;

public class CustomerRepository {
    private Customer[] customers;

    public Customer getCustomerById (int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                return customers[i];
            }
        }
        return null;
    }

    public Customer getCustomerByCNP (long CNP) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCNP() == CNP) {
                return customers[i];
            }
        }
        return null;
    }

    public Customer getCustomerByEmail (String email) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getEmail() == email) {
                return customers[i];
            }
        }
        return null;
    }
}
