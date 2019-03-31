package shop.configuration;

import shop.domain.repository.CustomerRepository;
import shop.domain.repository.OrderRepository;

public class RepositoryConfiguration {
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final OrderRepository orderRepository = new OrderRepository();

    private static RepositoryConfiguration ourInstance = new RepositoryConfiguration();

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public static RepositoryConfiguration getInstance() {
        return ourInstance;
    }

    private RepositoryConfiguration() {

    }
}
