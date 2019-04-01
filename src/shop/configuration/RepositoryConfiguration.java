package shop.configuration;

import shop.domain.repository.CustomerRepository;
import shop.domain.repository.OrderRepository;
import shop.domain.repository.ProteinRepository;
import shop.domain.repository.VitaminRepository;

public class RepositoryConfiguration {
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final OrderRepository orderRepository = new OrderRepository();
    private final ProteinRepository proteinRepository = new ProteinRepository();
    private final VitaminRepository vitaminRepository = new VitaminRepository();

    private static RepositoryConfiguration ourInstance = new RepositoryConfiguration();

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public ProteinRepository getProteinRepository() {
        return proteinRepository;
    }

    public VitaminRepository getVitaminRepository() {
        return vitaminRepository;
    }

    public static RepositoryConfiguration getInstance() {
        return ourInstance;
    }

    private RepositoryConfiguration() {

    }
}
