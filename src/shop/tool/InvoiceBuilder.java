package shop.tool;

import shop.domain.entity.Invoice;
import shop.domain.entity.Product;

public class InvoiceBuilder {
    private final Invoice target = new Invoice();

    public InvoiceBuilder withId () {
        Invoice.increaseCurrentInvoice();
        int currentInvoice = Invoice.getCurrentInvoice();
        target.setId(currentInvoice);
        return this;
    }

    public InvoiceBuilder withValue (double value) {
        target.setValue(value);
        return this;
    }

    public InvoiceBuilder withCustomer (int customerId) {
        target.setInvoiceCustomer(customerId);
        return this;
    }

    public InvoiceBuilder withInvoiceProducts (Product[] invoiceProducts) {
        target.setInvoiceProducts(invoiceProducts);
        return this;
    }

    public InvoiceBuilder withPayMethod (String payMethod) {
        target.setPayMethod(payMethod);
        return this;
    }

    public Invoice build() {
        return target;
    }
}
