package shop.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.domain.entity.Customer;
import shop.domain.entity.Invoice;
import shop.domain.entity.Product;
import shop.services.OrderService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InvoicesController implements Initializable {

    private OrderService orderService = new OrderService();
    private static Customer loggedCustomer = LogInController.getLoggedCustomer();

    @FXML
    private TableView<Invoice> invoicesTable;

    @FXML
    private TableColumn<Invoice, Integer> invoiceId;

    @FXML
    private TableColumn<Invoice, Integer> customerName;

    @FXML
    private TableColumn<Invoice, String> paymethod;

    @FXML
    private TableColumn<Invoice, Double> totalValue;

    @FXML
    private TableColumn<Invoice, String> productsInvoice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Invoice> invoicesByCustomers = orderService.listMyInvoices(loggedCustomer);

        ObservableList<Invoice> invoicesModel = null;

        if (invoicesByCustomers != null)
            invoicesModel = FXCollections.observableArrayList(invoicesByCustomers);

        invoiceId.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("invoiceCustomerId"));

//        productsInvoice.setCellValueFactory(
//                Invoice -> {
//                    SimpleObjectProperty property = new SimpleObjectProperty();
//                    property.setValue(Invoice.getValue().getInvoiceProducts().length);
//                    return property;
//                }
//        );

        productsInvoice.setCellValueFactory(
                p -> new ReadOnlyStringWrapper(
                        Product.displayProducts(p.getValue().getInvoiceProducts())
                ));

        paymethod.setCellValueFactory(new PropertyValueFactory<>("payMethod"));
        totalValue.setCellValueFactory(new PropertyValueFactory<>("value"));

        invoicesTable.setItems(invoicesModel);
    }
}
