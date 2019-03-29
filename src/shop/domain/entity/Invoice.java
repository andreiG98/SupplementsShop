package shop.domain.entity;

import shop.tool.CustomerBuilder;

public class Invoice {
    private int id;
    private double value;
    private Customer invoiceCustomer;
    private Product[] invoiceProducts;
    private String payMethod;
    private static int currentInvoice = 0;

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public Product[] getInvoiceProducts() {
        return invoiceProducts;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setInvoiceCustomer(Customer invoiceCustomer) {
        this.invoiceCustomer =
                new CustomerBuilder()
                        .withId(invoiceCustomer.getId())
                        .withName(invoiceCustomer.getName())
                        .withCNP(invoiceCustomer.getCNP())
                        .withPhoneNumber(invoiceCustomer.getPhoneNumber())
                        .withEmail(invoiceCustomer.getEmail())
                        .withPassword(invoiceCustomer.getPassword())
                        .withAddress(invoiceCustomer.getAddress())
                        .build();
    }

    public void setInvoiceProducts(Product[] invoiceProducts) {
        for (int i = 0; i < invoiceProducts.length; i++) {
            this.invoiceProducts[i] = invoiceProducts[i];
        }
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Customer getInvoiceCustomer() {
        return invoiceCustomer;
    }
}
