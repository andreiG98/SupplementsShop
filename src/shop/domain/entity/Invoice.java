package shop.domain.entity;

public class Invoice {
    private int id;
    private double value;
    private Customer invoiceCustomer;
    private Product[] invoiceProducts;
    private String payMethod;
    private static int currentInvoice = 0;

    public Invoice(double value, Customer invoiceCustomer, Product[] invoiceProducts, String payMethod) {
        this.id = ++currentInvoice;
        this.value = value;
        this.invoiceCustomer = invoiceCustomer;
        this.invoiceProducts = invoiceProducts;
        this.payMethod = payMethod;
    }

    public Invoice(Invoice invoice) {
        this.id = invoice.id;
        this.value = invoice.value;
        this.invoiceCustomer = invoice.invoiceCustomer;
        this.invoiceProducts = invoice.invoiceProducts;
        this.payMethod = invoice.payMethod;
    }

    public int getId() {
        return id;
    }

    public Customer getInvoiceCustomer() {
        return invoiceCustomer;
    }
}
