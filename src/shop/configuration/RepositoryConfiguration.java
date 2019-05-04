package shop.configuration;

import shop.domain.repository.*;

public class RepositoryConfiguration {
    private final CustomerRepository customerRepository = new CustomerRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\customer-file.csv");
    private final InvoiceRepository invoiceRepository = new InvoiceRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\invoice-file.csv");
    private final CourierRepository courierRepository = new CourierRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\courier-file.csv");
    private final OrderRepository orderRepository = new OrderRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\order-file.csv");
    private final ProteinRepository proteinRepository = new ProteinRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\product-file.csv");
    private final VitaminRepository vitaminRepository = new VitaminRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\product-file.csv");
    private final ProducerRepository producerRepository = new ProducerRepository("D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\producer-file.csv");

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
