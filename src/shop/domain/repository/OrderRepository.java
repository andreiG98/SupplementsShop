package shop.domain.repository;

import shop.domain.entity.Courier;
import shop.domain.entity.Customer;
import shop.domain.entity.Invoice;
import shop.domain.entity.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderRepository {
    private ArrayList<Order> orders;
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
        orders = new ArrayList<Order>(10);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            Order newEntry = new Order(splitedData[0], splitedData[1], splitedData[2]);
        }
    }

    public void listAllOrders() {
        ArrayList<Order> allOrders = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            allOrders.add(orders.get(i));
        }
        Order.show(allOrders);
    }

    public void addOrder (Order order) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String newEntry = order.getCommandCustomer() + ", " + order.getCommandInvoice() + ", " + order.getCommandCourier();
        byte[] newEntryBytes = newEntry.getBytes();
        orders.add(order);
        try {
            fileOutputStream.write(newEntryBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Order getOrderById (int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                return orders.get(i);
            }
        }
        return null;
    }

    public ArrayList<Order> getOrdersByCustomer (Customer customer) {
        ArrayList<Order> ordersByCustomer = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCommandCustomer().getEmail().equals(customer.getEmail())) {
                ordersByCustomer.add(orders.get(i));
            }
        }
        return ordersByCustomer;
    }

    public Order getOrderByInvoice (Invoice invoice) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCommandInvoice().getId() == invoice.getId()) {
                return orders.get(i);
            }
        }
        return null;
    }

    public ArrayList<Order> getOrdersByCourier (Courier courier) {
        ArrayList<Order> ordersByCourier = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCommandCourier().getId() == courier.getId()) {
                ordersByCourier.add(orders.get(i));
            }
        }
        return ordersByCourier;
    }
}
