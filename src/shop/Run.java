package shop;

import shop.services.CustomerService;
import shop.services.OrderService;
import shop.services.ProducersService;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Welcome to Andrew's Supplemets Shop!");
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        ProducersService producersService = new ProducersService();
//        customerService.addCustomer(false);
//        customerService.getCustomerRepository().listAllCustomers();
        int choice;
        int customerId = -1;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose one option:");
            System.out.println("0 - Log in");
            System.out.println("1 - Add new customer");
            System.out.println("2 - Add new order (if you are logged in)");
            System.out.println("3 - List all available protein");
            System.out.println("4 - List all available vitamins");
            System.out.println("5 - List all producers");
            System.out.println("6 - Search producer by a name/partial name");
            System.out.println("7 - List your orders (if you are logged in)");
            System.out.println("8 - List your invoices (if you are logged in)");
            System.out.println("9 - Search order by invoice id (if you are logged in)");
            System.out.println("10 - List proteins after a certain concentration");
            System.out.println("11 - Exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            while (choice < 0 || choice > 11) {
                System.out.println("Invalid choice!");
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            switch (choice) {
                case 0:
                    customerId = customerService.logIn(customerId);
                    break;
                case 1:
                    customerService.addCustomer(customerId);
                    break;
                case 2:
                    orderService.addOrder(customerService.getCustomerRepository().getCustomerById(customerId));
                    break;
                case 3:
                    orderService.showProtein();
                    break;
                case 4:
                    orderService.showVitamins();
                    break;
                case 5:
                    producersService.showProducers();
                    break;
                case 6:
                    producersService.searchProducersByASpecificPattern();
                    break;
                case 7:
                    //orderService.listMyOrders(customerService.getCustomerRepository().getCustomerById(customerId));
                    break;
                case 8:
                    //orderService.listMyInvoices(customerService.getCustomerRepository().getCustomerById(customerId));
                    break;
                case 9:
                    orderService.listOrderById();
                    break;
                case 10:
                    orderService.listProteinsByConcentration();
                    break;
                case 11:
                    System.out.println("Exit...");
                    System.exit(0);
            }
        }

//        ProteinRepository proteinRepository = new ProteinRepository();
//        proteinRepository.listAllProteins();
//
//        VitaminRepository vitaminRepository = new VitaminRepository();
//        vitaminRepository.listAllvitamins();

//        OrderService orderService = new OrderService();
//        orderService.addOrder();

//        AddCustomer.addCustomer();
//        CustomerRepository customerRepository = new CustomerRepository();
//        customerRepository.listAllCustomers();

    }
}
