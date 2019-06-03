package shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Run extends Application {


    public static void main(String[] args) {

        launch(args);

//        System.out.println("Welcome to Andrew's Supplemets Shop!");
//        CustomerService customerService = new CustomerService();
//        OrderService orderService = new OrderService();
//        ProducersService producersService = new ProducersService();
////        customerService.addCustomer(false);
////        customerService.getCustomerRepository().listAllCustomers();
//        int choice;
//        String choiceString;
//        Customer loggedCustomer = null;
//        while(true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Choose one option:");
//            System.out.println("0 - Log in");
//            System.out.println("1 - Add new customer");
//            System.out.println("2 - Add new order (if you are logged in)");
//            System.out.println("3 - List all available protein");
//            System.out.println("4 - List all available vitamins");
//            System.out.println("5 - List all producers");
//            System.out.println("6 - Search vitamin by a name/partial name");
//            System.out.println("7 - List your orders (if you are logged in)");
//            System.out.println("8 - List your invoices (if you are logged in)");
//            System.out.println("9 - Search order by order id (if you are logged in)");
//            System.out.println("10 - List proteins after a certain concentration");
//            System.out.println("11 - Delete account");
//            System.out.println("12 - Update email");
//            System.out.println("13 - Exit");
//
//            choiceString = scanner.nextLine();
//            try {
//                choice = Integer.parseInt(choiceString);
//            }
//            catch (NumberFormatException e)
//            {
//                choice = -1;
//            }
//            while (choice < 0 || choice > 14) {
//                System.out.println("Invalid choice!");
//                choice = scanner.nextInt();
//                scanner.nextLine();
//            }
//            switch (choice) {
//                case 0:
//                    loggedCustomer = customerService.logIn(loggedCustomer);
//                    //customerId = customerService.logIn(customerId);
//                    break;
//                case 1:
//                    customerService.addCustomer(loggedCustomer);
//                    break;
//                case 2:
//                    orderService.addOrder(loggedCustomer);
//                    break;
//                case 3:
//                    orderService.showProtein();
//                    break;
//                case 4:
//                    orderService.showVitamins();
//                    break;
//                case 5:
//                    producersService.showProducers();
//                    break;
//                case 6:
//                    orderService.searchVitaminByASpecificPattern();
//                    break;
//                case 7:
//                    orderService.listMyOrders(loggedCustomer);
//                    break;
//                case 8:
//                    orderService.listMyInvoices(loggedCustomer);
//                    break;
//                case 9:
//                    orderService.listOrderById(loggedCustomer);
//                    break;
//                case 10:
//                    orderService.listProteinsByConcentration();
//                    break;
//                case 11:
//                    customerService.deleteAccount(loggedCustomer);
//                    loggedCustomer = null;
//                    break;
//                case 12:
//                    customerService.updateEmail(loggedCustomer);
//                    break;
//                case 13:
//                    System.out.println("Exit...");
//                    System.exit(0);
//            }
//        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("/views/main_layout.fxml");
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Supplements Shop");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
