package shop.domain.repository;

import shop.domain.entity.Customer;
import shop.domain.entity.Order;
import shop.tool.CustomerBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OrderRepository {
    private HashMap<Integer, ArrayList<Order>> orders;
    private File file;

    public OrderRepository(String fileName) {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        orders = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            Customer orderCustomer =
                    new CustomerBuilder()
                            .withName(splitedData[0])
                            .withCNP(splitedData[1])
                            .withPhoneNumber(splitedData[2])
                            .withEmail(splitedData[3])
                            .withPassword(splitedData[4])
                            .withAddress(splitedData[5])
                            .build();
            //Order newEntry = new Order(splitedData[0], splitedData[1], splitedData[2]);
        }
    }

    public void listAllOrders() {
        ArrayList<Order> allOrders = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            //allOrders.add(orders.get(i));
            System.out.println("list all orders");
        }
        Order.show(allOrders);
    }

    public void addOrder(Order order, Customer customer) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String newEntry = order.getCommandCustomer().toString() + ", " + order.getCommandInvoice().toString() + ", " + order.getCommandCourier() + "\n";
        byte[] newEntryBytes = newEntry.getBytes();
        ArrayList<Order> ordersOfCustomer = orders.get(customer.getId());
        if (ordersOfCustomer == null)
            ordersOfCustomer = new ArrayList<Order>();
        ordersOfCustomer.add(order);
        orders.put(customer.getId(), ordersOfCustomer);
        try {
            fileOutputStream.write(newEntryBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Order getOrderById (int id) {
        for(HashMap.Entry<Integer, ArrayList<Order>> map : orders.entrySet()){
            for (Order ord : map.getValue()) {
                if (ord.getId() == id)
                    return ord;
            }
        }
        return null;
    }

    public ArrayList<Order> getOrdersByCustomer (Customer customer) {
        ArrayList<Order> ordersByCustomer = new ArrayList<Order>();
        ordersByCustomer = orders.get(customer.getId());
        return ordersByCustomer;
    }

//    public Order getOrderByInvoice (Invoice invoice) {
//        for (int i = 0; i < orders.size(); i++) {
//            if (orders.get(i).getCommandInvoice().getId() == invoice.getId()) {
//                return orders.get(i);
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<Order> getOrdersByCourier (Courier courier) {
//        ArrayList<Order> ordersByCourier = new ArrayList<Order>();
//        for (int i = 0; i < orders.size(); i++) {
//            if (orders.get(i).getCommandCourier().getId() == courier.getId()) {
//                ordersByCourier.add(orders.get(i));
//            }
//        }
//        return ordersByCourier;
//    }
}
