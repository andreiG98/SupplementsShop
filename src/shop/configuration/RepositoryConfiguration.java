package shop.configuration;

import shop.domain.repository.CustomerRepository;

public class RepositoryConfiguration {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    private RepositoryConfiguration() {

    }
}
