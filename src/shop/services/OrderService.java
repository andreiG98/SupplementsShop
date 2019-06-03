package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.*;
import shop.domain.repository.*;
import shop.tool.InvoiceBuilder;
import shop.tool.OrderBuilder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OrderService {

    private OrderRepository orderRepository = RepositoryConfiguration.getInstance().getOrderRepository();
    private ProteinRepository proteinRepository = RepositoryConfiguration.getInstance().getProteinRepository();
    private VitaminRepository vitaminRepository = RepositoryConfiguration.getInstance().getVitaminRepository();
    private InvoiceRepository invoiceRepository = RepositoryConfiguration.getInstance().getInvoiceRepository();
    private CourierRepository courierRepository = RepositoryConfiguration.getInstance().getCourierRepository();
    private ArrayList<Product> orderProducts = new ArrayList<Product>();
    private double totalCartValue;

    public void showProtein() {
        String action = "Show proteins";
        CsvService.writeAudit(action);
        proteinRepository.listAllProteins();
    }

    public void showVitamins() {
        String action = "Show vitamins";
        CsvService.writeAudit(action);
        vitaminRepository.listAllvitamins();
    }

    public void showOrders() {
        orderRepository.listAllOrders();
    }

    public void addOrder (Customer customer) {
        String action = "Add order";
        CsvService.writeAudit(action);
        Scanner scanner = new Scanner(System.in);
        int choice;
        totalCartValue = 0;
        if (customer != null) {
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
                    System.out.println("Invalid choice!");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
                switch (choice) {
                    case 1:
                        commandProtein();
                        break;
                    case 2:
                        commandVitamin();
                        break;
                    case 3:
                        sendCommand(customer);
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
        double priceOfProtein;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of protein you want:");
        choice = scanner.nextInt();
        scanner.nextLine();
        Protein desiredProtein = proteinRepository.getProteinById(choice);
        if (desiredProtein == null) {
            System.out.println("Invalid id!");
        } else {
            System.out.println("You chosed " + desiredProtein.getName() + "!");
            do {
                System.out.println("How many pieces do you want?");
                quantity = scanner.nextInt();
                scanner.nextLine();
            } while (quantity <= 0);
            for (int i = 0; i < quantity; i++) {
                priceOfProtein = 0;
                priceOfProtein = priceOfProtein + desiredProtein.getPrice() - desiredProtein.getPrice() * desiredProtein.getDiscount();
                totalCartValue += priceOfProtein;
                orderProducts.add(desiredProtein);
            }
        }
    }

    private void commandVitamin () {
        vitaminRepository.listAllvitamins();
        int choice;
        int quantity;
        double priceOfVitamin;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of vitamin you want:");
        choice = scanner.nextInt();
        scanner.nextLine();
        Vitamin desiredVitamin = vitaminRepository.getVitaminById(choice);
        if (desiredVitamin == null) {
            System.out.println("Invalid id!");
        } else {
            System.out.println("You chosed " + desiredVitamin.getName() + "!");
            do {
                System.out.println("How many pieces do you want?");
                quantity = scanner.nextInt();
                scanner.nextLine();
            } while (quantity <= 0);
            for (int i = 0; i < quantity; i++) {
                priceOfVitamin = 0;
                priceOfVitamin = priceOfVitamin + desiredVitamin.getPrice() - desiredVitamin.getPrice() * desiredVitamin.getDiscount();
                totalCartValue += priceOfVitamin;
                orderProducts.add(desiredVitamin);
            }
        }
    }

    private void sendCommand(Customer customer) {
        String payMethod;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose pay method: cash/card");
            payMethod = scanner.nextLine();
        } while (!payMethod.equals("cash") && !payMethod.equals("card"));

        Product[] invoiceProducts = new Product[orderProducts.size()];
        for (int i = 0; i < orderProducts.size(); i++) {
            invoiceProducts[i] = orderProducts.get(i);
        }
        orderProducts.removeAll(orderProducts);
        Invoice invoice =
                new InvoiceBuilder()
                        .withId()
                        .withCustomer(customer.getId())
                        .withValue(totalCartValue)
                        .withPayMethod(payMethod)
                        .withInvoiceProducts(invoiceProducts)
                        .build();
        invoiceRepository.addInvoice(invoice);
        totalCartValue = 0;
        String commandZone = customer.getAddress().substring(customer.getAddress().length() - 1);
        Courier courier = courierRepository.getCouriersByWorkZone("Sector " + commandZone).get(random.nextInt(courierRepository.getCouriersByWorkZone("Sector " + commandZone).size()));
        Order order =
                new OrderBuilder()
                    .withId()
                    .withCustomer(customer.getId())
                    .withInvoice(invoice.getId())
                    .withCourier(courier.getDrivingLicenseNo())
                    .build();
        orderRepository.addOrder(order, customer);
        System.out.println("Thank you for order!");
    }

    public ArrayList<Order> listMyOrders (Customer customer) {
        String action = "List my orders";
        CsvService.writeAudit(action);
//        if (customer == null) {
//            System.out.println("You need to be logged in!");
//            return;
//        } else {
//            ArrayList<Order> ordersByCustomer = orderRepository.getOrdersByCustomer(customer);
//            Order.show(ordersByCustomer);
//        }
        ArrayList<Order> ordersByCustomer = orderRepository.getOrdersByCustomer(customer);
        return ordersByCustomer;
    }

    public ArrayList<Invoice> listMyInvoices (Customer customer) {
        String action = "List my invoices";
        CsvService.writeAudit(action);
//        if (customer == null) {
//            System.out.println("You need to be logged in!");
//            return;
//        } else {
//            ArrayList<Invoice> invoicesByCustomer = invoiceRepository.getInvoicesByClient(customer);
//            Invoice.show(invoicesByCustomer);
//        }
        return invoiceRepository.getInvoicesByClient(customer);
    }

    private void listCart () {
        for (int i = 0; i < orderProducts.size(); i++) {
            System.out.println(orderProducts.get(i).getProducer() + " " + orderProducts.get(i).getName());
        }
        System.out.println("Total: " + totalCartValue + " lei");
    }

    public void listOrderById (Customer customer) {
        String action = "List order by id";
        CsvService.writeAudit(action);
        if (customer == null) {
            System.out.println("You need to be logged in!");
            return;
        } else {
            Scanner scanner = new Scanner(System.in);
            int orderId;
            System.out.println("Type order id:");
            orderId = scanner.nextInt();
            scanner.nextLine();
            Order order = orderRepository.getOrderById(orderId);
            if (order == null) {
                System.out.println("Order doesn't exist!");
                return;
            }
            ArrayList<Order> ordersById = new ArrayList<Order>();
            ordersById.add(order);
            Order.show(ordersById);
        }
    }

    public void listProteinsByConcentration () {
        String action = "List proteins by concentration";
        CsvService.writeAudit(action);
        System.out.println("Enter desired concentration(X%): ");
        Scanner scanner = new Scanner(System.in);
        double concentration = scanner.nextDouble();
        scanner.nextLine();
        concentration /= 100;
        ArrayList<Protein> proteins = proteinRepository.getProteinByConcentration(concentration);
        if (proteins.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < proteins.size(); i++) {
            System.out.println(proteins.get(i).getId() + " " + proteins.get(i).getProducer() + " " + proteins.get(i).getName() + " " + proteins.get(i).getPrice() + " lei " + proteins.get(i).getDiscount() + " discount " + proteins.get(i).getWeight() + " kg " + proteins.get(i).getFlavour() + " flavour " + proteins.get(i).getConcentration() + " concentration " + proteins.get(i).getType());
        }
    }

    private ArrayList<Vitamin> getVitaminsByASpecificPattern (String partialName) {
        String action = "Get vitamins by a specific pattern";
        CsvService.writeAudit(action);
        ArrayList<Vitamin> allVitamins = vitaminRepository.getVitamins();
        ArrayList<Vitamin> result = new ArrayList<Vitamin>();
        String pattern = createPattern(partialName);
        String vitamin;
        for (int i = 0; i < allVitamins.size(); i++) {
            vitamin = allVitamins.get(i).getName().toLowerCase();
            if (allVitamins.get(i) != null && vitamin.matches(pattern)) {
                result.add(allVitamins.get(i));
            }
        }
        return result;
    }

    public void searchVitaminByASpecificPattern () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me name/partial name of vitamin:");
        String partialName = scanner.nextLine();
        ArrayList<Vitamin> result = getVitaminsByASpecificPattern(partialName);
        Vitamin.show(result);
    }

    private String createPattern (String partialName) {
        String[] splitedPartialName = partialName.split("\\s");
        StringBuilder resultPattern = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            splitedPartialName[i].toLowerCase();
            resultPattern.append("[a-z]*");
            resultPattern.append("[\\s]*");
            resultPattern.append(splitedPartialName[i]);
            resultPattern.append("[\\s]*");
            resultPattern.append("[a-z]*");
            resultPattern.append("[\\s]*");
        }
        resultPattern.append("[a-z]*");
        resultPattern.append("[\\s]*");
        //System.out.println(resultPattern.toString());
        return resultPattern.toString();
    }

}
