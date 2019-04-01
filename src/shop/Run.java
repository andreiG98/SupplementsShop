package shop;

import shop.services.CustomerService;
import shop.services.OrderService;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Welcome to Andrew's Supplemets Shop!");
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
//        customerService.addCustomer(false);
//        customerService.getCustomerRepository().listAllCustomers();
        int choice;
        boolean loggedIn = false;
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
            System.out.println("9 - Search order by invoice id");
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
                    loggedIn = customerService.logIn(loggedIn);
                    break;
                case 1:
                    customerService.addCustomer(loggedIn);
                    break;
                case 2:
                    orderService.addOrder(loggedIn);
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
