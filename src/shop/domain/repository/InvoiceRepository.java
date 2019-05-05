package shop.domain.repository;

import shop.domain.entity.Customer;
import shop.domain.entity.Invoice;
import shop.domain.entity.Product;
import shop.tool.InvoiceBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceRepository {
    private static ArrayList<Invoice> invoices;
    private static File file;

    public InvoiceRepository(String fileName) {

        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.invoices = new ArrayList<Invoice>(10);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            ArrayList<Product> invoiceProducts = new ArrayList<Product>(10);
            for (int i = 3; i < splitedData.length; i += 2) {
                if (splitedData[i + 1].equals("p")) {
                    invoiceProducts.add(ProteinRepository.getProteinById(Integer.parseInt(splitedData[i])));
                } else if (splitedData[i + 1].equals("v")) {
                    invoiceProducts.add(VitaminRepository.getVitaminById(Integer.parseInt(splitedData[i])));
                }
            }
            Product[] invoiceProductsArray = invoiceProducts.toArray(new Product[invoiceProducts.size()]);
            Invoice newEntry =
                    new InvoiceBuilder()
                            .withId()
                            .withValue(Double.parseDouble(splitedData[0]))
                            .withPayMethod(splitedData[1])
                            .withCustomer(CustomerRepository.getCustomerById(Integer.parseInt(splitedData[2])))
                            .withInvoiceProducts(invoiceProductsArray)
                            .build();
            invoices.add(newEntry);
        }
    }

    public void addInvoice (Invoice invoice) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String newEntry = invoice.toString();
        byte[] newEntryBytes = newEntry.getBytes();
        invoices.add(invoice);
        try {
            fileOutputStream.write(newEntryBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Invoice getInvoiceById (int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getId() == id) {
                return invoices.get(i);
            }
        }
        return null;
    }

    public ArrayList<Invoice> getInvoicesByClient (Customer customer) {
        ArrayList<Invoice> invoicesByClient = new ArrayList<Invoice>();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getInvoiceCustomer().getEmail().equals(customer.getEmail())) {
                invoicesByClient.add(invoices.get(i));
            }
        }
        return invoicesByClient;
    }
}
