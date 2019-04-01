package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.repository.OrderRepository;

import java.util.Scanner;

public class OrderService {

    private OrderRepository orderRepository = RepositoryConfiguration.getInstance().getOrderRepository();

    public void addOrder () {
        Scanner scanner = new Scanner(System.in);
        do {
            String email;
            System.out.println("Please type your email: ");
            email = scanner.nextLine();
            String password;
            System.out.println("Please type your password to log in: ");
            password = scanner.nextLine();
            CustomerService customerService = new CustomerService();
            boolean validLogIn = customerService.checkEmailPassword(email, password);
            if (validLogIn == false) {
                System.out.println("Invalid email os password. Please try again.");
            } else {
                System.out.println("You are logged in!");
                break;
            }
        } while (true);



    }

}
