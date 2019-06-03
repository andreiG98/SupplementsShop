package shop.domain.entity;

import shop.domain.repository.CourierRepository;
import shop.domain.repository.InvoiceRepository;

import java.util.ArrayList;

public class Order {
    private int id;
    private int commandCustomerId;
    private int commandInvoiceId;
    private int commandCourierDL;
    private static int currentOrder = 0;

//    public Order(Customer commandCustomer, Invoice commandInvoice, Courier commandCourier) {
//        if (commandCustomer != null) {
//            this.id = ++Order.currentOrder;
//            this.commandCustomer =
//                    new CustomerBuilder()
//                            .withName(commandCustomer.getName())
//                            .withCNP(commandCustomer.getCNP())
//                            .withPhoneNumber(commandCustomer.getPhoneNumber())
//                            .withEmail(commandCustomer.getEmail())
//                            .withPassword(commandCustomer.getPassword())
//                            .withAddress(commandCustomer.getAddress())
//                            .build();
//            this.commandCustomer.setId(commandCustomer.getId());
//            this.commandCourier =
//                    new CourierBuilder()
//                            .withName(commandCourier.getName())
//                            .withCNP(commandCourier.getCNP())
//                            .withPhoneNumber(commandCourier.getPhoneNumber())
//                            .withWorkZone(commandCourier.getWorkZone())
//                            .withDrivingLicenseNo(commandCourier.getDrivingLicenseNo())
//                            .build();
//            this.commandCourier.setId(commandCourier.getId());
//            this.commandInvoice =
//                    new InvoiceBuilder()
//                            .withValue(commandInvoice.getValue())
//                            .withCustomer(commandInvoice.getInvoiceCustomer())
//                            .withInvoiceProducts(commandInvoice.getInvoiceProducts())
//                            .withPayMethod(commandInvoice.getPayMethod())
//                            .build();
//            this.commandInvoice.setId(commandInvoice.getId());
//        }
//    }

    public static void increaseCurrentOrder() {
        Order.currentOrder++;
    }

    public static int getCurrentOrder() {
        return currentOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommandInvoiceId() {
        return commandInvoiceId;
    }

    public int getCommandCustomerId() {
        return commandCustomerId;
    }

    public int getCommandCourierDL() {
        return commandCourierDL;
    }

    public static void show (ArrayList<Order> orders) {
        if (orders == null) {
            System.out.println("Nothing found!");
            return;
        }
        if (orders.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order id: " + orders.get(i).getId() + "\n");
            Invoice invoice = InvoiceRepository.getInvoiceById(orders.get(i).getCommandInvoiceId());
            Courier courier = CourierRepository.getCourierByDrivingLicense(orders.get(i).getCommandCourierDL());

            if (courier != null) {
                System.out.println("Courier name: " + courier.getName());
                System.out.println("Courier phone number: " + courier.getPhoneNumber() + "\n");
            }
            if (invoice != null) {
                invoice.showInvoice();
            }
        }
    }

    public void setOrderCustomer(int commandCustomerId) {
        this.commandCustomerId = commandCustomerId;
    }

    public void setOrderInvoice(int commandInvoiceId) {
        this.commandInvoiceId = commandInvoiceId;
    }

    public void setOrderCourier(int commandCourierDL) {
        this.commandCourierDL = commandCourierDL;
    }
}
