package shop.domain.repository;

import shop.domain.entity.Customer;
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

    public ArrayList<Order> getOrdersByCustomer (Customer customer) {
        ArrayList<Order> ordersByCustomer = new ArrayList<Order>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getCommandCustomer().getId() == customer.getId()) {
                ordersByCustomer.add(orders[i]);
            }
        }
        return ordersByCustomer;
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
