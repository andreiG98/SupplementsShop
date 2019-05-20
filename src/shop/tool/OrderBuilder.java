package shop.tool;

import shop.domain.entity.Order;

public class OrderBuilder {

    private final Order target = new Order();

    public OrderBuilder withId () {
        Order.increaseCurrentOrder();
        int currentOrder = Order.getCurrentOrder();
        target.setId(currentOrder);
        return this;
    }

    public OrderBuilder withCustomer (int customerId) {
        target.setOrderCustomer(customerId);
        return this;
    }

    public OrderBuilder withInvoice (int invoiceId) {
        target.setOrderInvoice(invoiceId);
        return this;
    }

    public OrderBuilder withCourier (int courierDL) {
        target.setOrderCourier(courierDL);
        return this;
    }

    public Order build() {
        return target;
    }
}
