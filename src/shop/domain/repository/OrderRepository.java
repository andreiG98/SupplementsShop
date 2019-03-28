package shop.domain.repository;

import shop.domain.entity.Client;
import shop.domain.entity.Courier;
import shop.domain.entity.Invoice;
import shop.domain.entity.Order;

import java.util.ArrayList;

public class OrderRepository {
    private Order[] orders;

    public Order getOrderById (int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) {
                return orders[i];
            }
        }
        return null;
    }

    public ArrayList<Order> getOrdersByClient (Client client) {
        ArrayList<Order> ordersByClient = new ArrayList<Order>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getCommandClient().getId() == client.getId()) {
                ordersByClient.add(orders[i]);
            }
        }
        return ordersByClient;
    }

    public Order getOrderByInvoice (Invoice invoice) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getCommandInvoice().getId() == invoice.getId()) {
                return orders[i];
            }
        }
        return null;
    }

    public ArrayList<Order> getOrdersByCourier (Courier courier) {
        ArrayList<Order> ordersByCourier = new ArrayList<Order>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getCommandCourier().getId() == courier.getId()) {
                ordersByCourier.add(orders[i]);
            }
        }
        return ordersByCourier;
    }
}
