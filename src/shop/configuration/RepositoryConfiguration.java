package shop.configuration;

import shop.domain.repository.*;

public class RepositoryConfiguration {
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final OrderRepository orderRepository = new OrderRepository();
    private final ProteinRepository proteinRepository = new ProteinRepository();
    private final VitaminRepository vitaminRepository = new VitaminRepository();
    private final ProducerRepository producerRepository = new ProducerRepository();
    private final InvoiceRepository invoiceRepository = new InvoiceRepository();
    private final CourierRepository courierRepository = new CourierRepository();

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

    public ProducerRepository getProducerRepository() {
        return producerRepository;
    }

    public InvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public CourierRepository getCourierRepository() {
        return courierRepository;
    }

    public static RepositoryConfiguration getInstance() {
        return ourInstance;
    }

    private RepositoryConfiguration() {

    }
}
