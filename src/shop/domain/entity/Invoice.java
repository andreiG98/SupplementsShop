package shop.domain.entity;

public class Invoice {
    private int id;
    private double value;
    private Client invoiceClient;
    private Product[] invoiceProducts;
    private String payMethod;
    private static int currentInvoice = 0;

    public Invoice(double value, Client invoiceClient, Product[] invoiceProducts, String payMethod) {
        this.id = ++currentInvoice;
        this.value = value;
        this.invoiceClient = invoiceClient;
        this.invoiceProducts = invoiceProducts;
        this.payMethod = payMethod;
    }

    public Invoice(Invoice invoice) {
        this.id = invoice.id;
        this.value = invoice.value;
        this.invoiceClient = invoice.invoiceClient;
        this.invoiceProducts = invoice.invoiceProducts;
        this.payMethod = invoice.payMethod;
    }

    public int getId() {
        return id;
    }

    public Client getInvoiceClient() {
        return invoiceClient;
    }
}
