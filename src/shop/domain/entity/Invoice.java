package shop.domain.entity;

import shop.domain.repository.CustomerRepository;

import java.util.ArrayList;

public class Invoice {
    private int id;
    private double value;
    private int invoiceCustomerId;
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

    public void setInvoiceCustomer(int invoiceCustomerId) {
        this.invoiceCustomerId = invoiceCustomerId;
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

    public int getInvoiceCustomerId() {
        return invoiceCustomerId;
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
        Customer customer = CustomerRepository.getCustomerById(getInvoiceCustomerId());
        if (customer != null) {
            System.out.println("Customer name: " + CustomerRepository.getCustomerById(getInvoiceCustomerId()).getName() + "\n");
        }
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
        return getValue() + ", " + getPayMethod() + ", " + getInvoiceCustomerId() + ", " + sInvoiceProducts + "\n";
    }
}
