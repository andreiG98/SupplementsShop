package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Customer;
import shop.domain.entity.Order;
import shop.tool.OrderBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderRepository {
    private HashMap<Integer, ArrayList<Order>> orders;
    private File file;
    private static final String GET_ALL_ORDERS = "SELECT * FROM orders";
    private static final String CREATE_NEW_ORDER = "INSERT INTO orders (id, client_id, invoice_id, driving_license_courier) VALUES (?,?,?,?)";

    public OrderRepository(String fileName) {
        file = new File(fileName);
        orders = new HashMap<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_ORDERS);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next())
            {
                int idCustomer = resultSet.getInt("client_id");
                Order newEntry =
                        new OrderBuilder()
                            .withId()
                            .withCustomer(idCustomer)
                            .withInvoice(resultSet.getInt("invoice_id"))
                            .withCourier(resultSet.getInt("driving_license_courier"))
                            .build();
                ArrayList<Order> ordersByCustomer = orders.get(idCustomer);
                if (ordersByCustomer != null) {
                    ordersByCustomer.add(newEntry);
                } else {
                    ordersByCustomer = new ArrayList<Order>(10);
                    ordersByCustomer.add(newEntry);
                }
                orders.put(idCustomer, ordersByCustomer);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file, true));
            String newEntry = order.getCommandCustomerId() + ", " + order.getCommandInvoiceId() + ", " + order.getCommandCourierDL() + "\n";
            ArrayList<Order> ordersOfCustomer = orders.get(customer.getId());
            if (ordersOfCustomer == null)
                ordersOfCustomer = new ArrayList<Order>();
            ordersOfCustomer.add(order);
            orders.put(customer.getId(), ordersOfCustomer);
            out.write(newEntry);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null){
                    out.close();
                } else {
                    System.out.println("Buffer has not been initialized!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_ORDER);
            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getCommandCustomerId());
            stmt.setInt(3, order.getCommandInvoiceId());
            stmt.setInt(4, order.getCommandCourierDL());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
