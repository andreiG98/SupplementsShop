package shop.domain.entity;

import shop.tool.CourierBuilder;
import shop.tool.CustomerBuilder;
import shop.tool.InvoiceBuilder;

import java.util.ArrayList;

public class Order {
    private int id;
    private Customer commandCustomer;
    private Invoice commandInvoice;
    private Courier commandCourier;
    private static int currentOrder;

    public Order(Customer commandCustomer, Invoice commandInvoice, Courier commandCourier) {
        this.id = ++currentOrder;
        this.commandCustomer =
                new CustomerBuilder()
                        .withId()
                        .withName(commandCustomer.getName())
                        .withCNP(commandCustomer.getCNP())
                        .withPhoneNumber(commandCustomer.getPhoneNumber())
                        .withEmail(commandCustomer.getEmail())
                        .withPassword(commandCustomer.getPassword())
                        .withAddress(commandCustomer.getAddress())
                        .build();
        this.commandCourier =
                new CourierBuilder()
                        .withId()
                        .withName(commandCourier.getName())
                        .withCNP(commandCourier.getCNP())
                        .withPhoneNumber(commandCourier.getPhoneNumber())
                        .withWorkZone(commandCourier.getWorkZone())
                        .withDrivingLicenseNo(commandCourier.getDrivingLicenseNo())
                        .build();
        this.commandInvoice =
                new InvoiceBuilder()
                        .withId()
                        .withValue(commandInvoice.getValue())
                        .withCustomer(commandInvoice.getInvoiceCustomer())
                        .withInvoiceProducts(commandInvoice.getInvoiceProducts())
                        .withPayMethod(commandInvoice.getPayMethod())
                        .build();
    }

    public int getId() {
        return id;
    }

    public Invoice getCommandInvoice() {
        return commandInvoice;
    }

    public Customer getCommandCustomer() {
        return commandCustomer;
    }

    public Courier getCommandCourier() {
        return commandCourier;
    }

    public static void show (ArrayList<Order> orders) {
        if (orders.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getId());
            Invoice invoice = orders.get(i).getCommandInvoice();
            System.out.println(invoice.getId() + " " + invoice.getInvoiceCustomer().getName());
            for (int j = 0; j < invoice.getInvoiceProducts().length; j++) {
                System.out.println(invoice.getInvoiceProducts()[i].getId() + " " + invoice.getInvoiceProducts()[i].getProducer() + " " + invoice.getInvoiceProducts()[i].getName() + " " + invoice.getInvoiceProducts()[i].getFlavour() + " " + invoice.getInvoiceProducts()[i].getWeight() + " kg " + invoice.getInvoiceProducts()[i].getPrice() + " lei");
            }
            System.out.println(invoice.getPayMethod());
            System.out.println(invoice.getValue());
        }
    }
}
