package shop.domain.entity;

public class Order {
    private int id;
    private Client commandClient;
    private Invoice commandInvoice;
    private Courier commandCourier;
    private static int currentOrder;

    public Order(Client commandClient, Invoice commandInvoice, Courier commandCourier) {
        this.id = ++currentOrder;
        this.commandClient = new Client(commandClient);
        this.commandInvoice = new Invoice(commandInvoice);
        this.commandCourier = new Courier(commandCourier);
    }

    public int getId() {
        return id;
    }

    public Invoice getCommandInvoice() {
        return commandInvoice;
    }

    public Client getCommandClient() {
        return commandClient;
    }

    public Courier getCommandCourier() {
        return commandCourier;
    }
}
