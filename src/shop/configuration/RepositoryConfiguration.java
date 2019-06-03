package shop.configuration;

import shop.domain.repository.*;

public class RepositoryConfiguration {
    private final String path = "D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\";
    private final ProteinRepository proteinRepository = new ProteinRepository(path + "product-file.csv");
    private final VitaminRepository vitaminRepository = new VitaminRepository(path + "product-file.csv");
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final InvoiceRepository invoiceRepository = new InvoiceRepository(path + "invoice-file.csv");
    private final CourierRepository courierRepository = new CourierRepository();
    private final OrderRepository orderRepository = new OrderRepository(path + "order-file.csv");
    private final ProducerRepository producerRepository = new ProducerRepository(path + "producer-file.csv");

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
        //DatabaseSetup.getInstance();
    }
}
