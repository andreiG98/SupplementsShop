package shop.domain.entity;

public class Order {
    private int id;
    private Customer commandCustomer;
    private Invoice commandInvoice;
    private Courier commandCourier;
    private static int currentOrder;

    public Order(Customer commandCustomer, Invoice commandInvoice, Courier commandCourier) {
        this.id = ++currentOrder;
        this.commandCustomer = new Customer(commandCustomer);
        this.commandInvoice = new Invoice(commandInvoice);
        this.commandCourier = new Courier(commandCourier);
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
