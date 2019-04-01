package shop.domain.repository;

import shop.domain.entity.Customer;
import shop.tool.CustomerBuilder;
import shop.tool.TestData;

public class CustomerRepository {
    private Customer[] customers;

    public CustomerRepository () {
        int length = TestData.getInstance().getCustomerData().length;
        this.customers = new Customer[length];
        for (int i = 0; i < length; i++) {
            String [] splitedData = TestData.getInstance().getCustomerData()[i].split(";");
            this.customers[i] =
                    new CustomerBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCNP(splitedData[1])
                            .withPhoneNumber(splitedData[2])
                            .withEmail(splitedData[3])
                            .withPassword(splitedData[4])
                            .withAddress(splitedData[5])
                            .build();
        }
    }

    public Customer getCustomerById (int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                return customers[i];
            }
        }
        return null;
    }

    public Customer getCustomerByCNP (String CNP) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCNP().equals(CNP)) {
                return customers[i];
            }
        }
        return null;
    }

    public Customer getCustomerByEmail (String email) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getEmail().equals(email)) {
                return customers[i];
            }
        }
        return null;
    }

    public void listAllCustomers () {
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].getId() + " " + customers[i].getName() + " " + customers[i].getCNP() + " " + customers[i].getPhoneNumber() + " " + customers[i].getEmail() + " " + customers[i].getAddress());
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }


}
