package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.Customer;
import shop.domain.repository.CustomerRepository;

import java.util.ArrayList;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfiguration.getInstance().getCustomerRepository();

    public CustomerService() {
        System.out.println("Creating Customer Service");
    }

    private ArrayList<Customer> getCustomersByASpecificPattern (String partialName) {
        Customer[] allCustomers = customerRepository.getCustomers();
        ArrayList<Customer> result = new ArrayList<Customer>();
        String pattern = createPattern(partialName);
        for (int i = 0; i < allCustomers.length; i++) {
            if (allCustomers[i] != null && allCustomers[i].getName().matches(pattern)) {
                result.add(allCustomers[i]);
            }
        }
        return result;
    }

    public void searchCustomersByASpecificPattern (String partialName) {
        ArrayList<Customer> result = getCustomersByASpecificPattern(partialName);
        Customer.show(result);
    }

    private String createPattern (String partialName) {
        String[] splitedPartialName = partialName.split("(?=[A-Z])");
        StringBuilder resultPattern = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            //System.out.println(splitedPartialName[i]);
            resultPattern.append(splitedPartialName[i]);
            resultPattern.append("[a-z]*");
            if (i != splitedPartialName.length - 1) {
                resultPattern.append("\\s");
                resultPattern.append("[[A-Z]*[.]*[a-z]*]*\\s");
            }
        }
        return resultPattern.toString();
    }

}
