package shop.domain.entity;

import shop.tool.CustomerBuilder;

import java.util.ArrayList;

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
                        .withName(invoiceCustomer.getName())
                        .withCNP(invoiceCustomer.getCNP())
                        .withPhoneNumber(invoiceCustomer.getPhoneNumber())
                        .withEmail(invoiceCustomer.getEmail())
                        .withPassword(invoiceCustomer.getPassword())
                        .withAddress(invoiceCustomer.getAddress())
                        .build();
        this.invoiceCustomer.setId(invoiceCustomer.getId());
    }

    public void setInvoiceProducts(Product[] invoiceProducts) {
        this.invoiceProducts = new Product[invoiceProducts.length];
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

    public static int getCurrentInvoice() {
        return currentInvoice;
    }

    public static void increaseCurrentInvoice() {
        Invoice.currentInvoice++;
    }

    public static void show (ArrayList<Invoice> invoices) {
        if (invoices.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);
            invoice.showInvoice();
        }
    }

    public void showInvoice() {
        System.out.println("Invoice id: " + getId() + "\n");
        System.out.println("Customer name: " + getInvoiceCustomer().getName() + "\n");
        Product[] invoiceProducts = getInvoiceProducts();
        for (int j = 0; j < invoiceProducts.length; j++) {
            System.out.println("Producer: " + invoiceProducts[j].getProducer() + "\nProduct name: " + invoiceProducts[j].getName() + "\nProduct flavour: " + invoiceProducts[j].getFlavour() + "\nWeight: " + invoiceProducts[j].getWeight() + " kg\nPrice: " + invoiceProducts[j].getPrice() + " lei" + "\n");
        }
        System.out.println("Pay method: " + getPayMethod());
        System.out.println("Total value: " + getValue() + " lei");
        System.out.println("***************************");
    }

    @Override
    public String toString() {
        String sInvoiceProducts = "";
        Product[] invoiceProducts = getInvoiceProducts();
        for(int i = 0; i < invoiceProducts.length; i++) {
            sInvoiceProducts += invoiceProducts[i].toString();
            sInvoiceProducts += ", ";
        }
        return getValue() + ", " + getPayMethod() + ", " + getInvoiceCustomer().getId() + ", " + sInvoiceProducts + "\n";
    }
}
