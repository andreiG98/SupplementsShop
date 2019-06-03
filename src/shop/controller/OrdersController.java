package shop.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.domain.entity.Customer;
import shop.domain.entity.Order;
import shop.domain.entity.Product;
import shop.domain.repository.CourierRepository;
import shop.domain.repository.CustomerRepository;
import shop.domain.repository.InvoiceRepository;
import shop.services.OrderService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {

    private OrderService orderService = new OrderService();
    private static Customer loggedCustomer = LogInController.getLoggedCustomer();

    @FXML
    private TableView<Order> ordersTable;

    @FXML
    private TableColumn<Order, Integer> orderId;

    @FXML
    private TableColumn<Order, String> courierName;

    @FXML
    private TableColumn<Order, String> courierPhoneNumber;

    @FXML
    private TableColumn<Order, Integer> invoiceId;

    @FXML
    private TableColumn<Order, String> customerName;

    @FXML
    private TableColumn<Order, String> productsOrder;

    @FXML
    private TableColumn<Order, String> payMethod;

    @FXML
    private TableColumn<Order, Double> totalValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Order> ordersByCustomer = orderService.listMyOrders(loggedCustomer);
        ObservableList<Order> ordersModel = null;

        if (ordersByCustomer != null)
            ordersModel = FXCollections.observableArrayList(ordersByCustomer);

        orderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        courierName.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(CourierRepository.getCourierByDrivingLicense(Order.getValue().getCommandCourierDL()).getName());
                    return property;
                }
        );
        courierPhoneNumber.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(CourierRepository.getCourierByDrivingLicense(Order.getValue().getCommandCourierDL()).getPhoneNumber());
                    return property;
                }
        );
        invoiceId.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(Order.getValue().getCommandInvoiceId());
                    return property;
                }
        );
        customerName.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(CustomerRepository.getCustomerById(Order.getValue().getCommandCustomerId()).getName());
                    return property;
                }
        );

        productsOrder.setCellValueFactory(
                p -> new ReadOnlyStringWrapper(
                        Product.displayProducts(InvoiceRepository.getInvoiceById(p.getValue().getCommandInvoiceId()).getInvoiceProducts())
                ));

        payMethod.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(InvoiceRepository.getInvoiceById(Order.getValue().getCommandInvoiceId()).getPayMethod());
                    return property;
                }
        );
        totalValue.setCellValueFactory(
                Order -> {
                    SimpleObjectProperty property = new SimpleObjectProperty();
                    property.setValue(InvoiceRepository.getInvoiceById(Order.getValue().getCommandInvoiceId()).getValue());
                    return property;
                }
        );

        if (ordersModel != null)
            ordersTable.setItems(ordersModel);
    }
}
