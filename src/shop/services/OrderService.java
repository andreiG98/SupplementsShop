package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.Product;
import shop.domain.entity.Protein;
import shop.domain.repository.OrderRepository;
import shop.domain.repository.ProteinRepository;
import shop.domain.repository.VitaminRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {

    private OrderRepository orderRepository = RepositoryConfiguration.getInstance().getOrderRepository();
    private ProteinRepository proteinRepository = RepositoryConfiguration.getInstance().getProteinRepository();
    private VitaminRepository vitaminRepository = RepositoryConfiguration.getInstance().getVitaminRepository();
    private ArrayList<Product> orderProducts = new ArrayList<Product>();

    public void addOrder (boolean loggedIn) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        if (loggedIn == true) {
            while (true) {
                System.out.println("What do you want to buy?");
                System.out.println("1 - Protein");
                System.out.println("2 - Vitamin");
                System.out.println("3 - Send order");
                System.out.println("4 - List cart");
                System.out.println("5 - Exit window for order");
                choice = scanner.nextInt();
                scanner.nextLine();
                while (choice < 1 || choice > 5) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Invalid choice!");
                }
                switch (choice) {
                    case 1:
                        commandProtein();
                        break;
                    case 2:
                        vitaminRepository.listAllvitamins();
                        break;
                    case 4:
                        listCart();
                        break;
                    case 5:
                        System.out.println("Exit order window...");
                        return;
                }
            }
        } else {
            System.out.println("You need to be logged in!");
        }
    }

    private void commandProtein () {
        proteinRepository.listAllProteins();
        int choice;
        int quantity;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of protein you want:");
        choice = scanner.nextInt();
        scanner.nextLine();
        Protein desiredProtein = proteinRepository.getProteinById(choice);
        if (desiredProtein == null) {
            System.out.println("Invalid id!");
        } else {
            System.out.println("You choose " + desiredProtein.getName() + "!");
            do {
                System.out.println("How many pieces do you want?");
                quantity = scanner.nextInt();
                scanner.nextLine();
            } while (quantity <= 0);
            for (int i = 0; i < quantity; i++) {
                orderProducts.add(desiredProtein);
            }
        }
    }

    private void listCart () {
        for (int i = 0; i < orderProducts.size(); i++) {
            System.out.println(orderProducts.get(i).getName());
        }
    }

}
