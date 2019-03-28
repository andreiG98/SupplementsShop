package shop.domain.repository;

import shop.domain.entity.Client;
import shop.domain.entity.Invoice;

import java.util.ArrayList;

public class InvoiceRepository {
    private Invoice[] invoices;

    public Invoice getInvoiceById (int id) {
        for (int i = 0; i < invoices.length; i++) {
            if (invoices[i].getId() == id) {
                return invoices[i];
            }
        }
        return null;
    }

    public ArrayList<Invoice> getInvoicesByClient (Client client) {
        ArrayList<Invoice> invoicesByClient = new ArrayList<Invoice>();
        for (int i = 0; i < invoices.length; i++) {
            if (invoices[i].getInvoiceClient().getId() == client.getId()) {
                invoicesByClient.add(invoices[i]);
            }
        }
        return invoicesByClient;
    }
}
