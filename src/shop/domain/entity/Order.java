package shop.domain.entity;

import shop.tool.CourierBuilder;
import shop.tool.CustomerBuilder;
import shop.tool.InvoiceBuilder;

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
                        .withId(commandCustomer.getId())
                        .withName(commandCustomer.getName())
                        .withCNP(commandCustomer.getCNP())
                        .withPhoneNumber(commandCustomer.getPhoneNumber())
                        .withEmail(commandCustomer.getEmail())
                        .withPassword(commandCustomer.getPassword())
                        .withAddress(commandCustomer.getAddress())
                        .build();
        this.commandCourier =
                new CourierBuilder()
                        .withId(commandCourier.getId())
                        .withName(commandCourier.getName())
                        .withCNP(commandCourier.getCNP())
                        .withPhoneNumber(commandCourier.getPhoneNumber())
                        .withWorkZone(commandCourier.getWorkZone())
                        .withDrivingLicenseNo(commandCourier.getDrivingLicenseNo())
                        .build();
        this.commandInvoice =
                new InvoiceBuilder()
                        .withId(commandInvoice.getId())
                        .withValue(commandInvoice.getValue())
                        .withCustomer(commandInvoice.getInvoiceCustomer())
                        .withInvoiceProducts(commandInvoice.getInvoiceProducts())
                        .withPayMethod(commandInvoice.getPayMethod())
                        .build();
//        this.commandCustomer = new Customer(commandCustomer);
//        this.commandInvoice = new Invoice(commandInvoice);
//        this.commandCourier = new Courier(commandCourier);
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
}
