package shop.domain.repository;

import shop.domain.entity.Customer;
import shop.domain.entity.Invoice;

import java.util.ArrayList;

public class InvoiceRepository {
    private Invoice[] invoices;

    public InvoiceRepository() {
        invoices = new Invoice[0];
    }

    public void addInvoice (Invoice invoice) {
        Invoice[] auxInvoices = new Invoice[invoices.length + 1];
        for (int i = 0; i < invoices.length; i++) {
            auxInvoices[i] = invoices[i];
        }
        auxInvoices[invoices.length] = invoice;
        invoices = auxInvoices;
    }

    public Invoice getInvoiceById (int id) {
        for (int i = 0; i < invoices.length; i++) {
            if (invoices[i].getId() == id) {
                return invoices[i];
            }
        }
        return null;
    }

    public ArrayList<Invoice> getInvoicesByClient (Customer customer) {
        ArrayList<Invoice> invoicesByClient = new ArrayList<Invoice>();
        for (int i = 0; i < invoices.length; i++) {
            if (invoices[i].getInvoiceCustomer().getId() == customer.getId()) {
                invoicesByClient.add(invoices[i]);
            }
        }
        return invoicesByClient;
    }
}
