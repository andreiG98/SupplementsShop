package shop.controller;

import javafx.animation.PauseTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import shop.domain.entity.Order;
import shop.domain.entity.Product;
import shop.domain.repository.CourierRepository;
import shop.domain.repository.CustomerRepository;
import shop.domain.repository.InvoiceRepository;
import shop.services.CustomerService;
import shop.services.OrderService;

import java.io.IOException;

public class LoggedInController {

    //private static Customer loggedCustomer = LogInController.getLoggedCustomer();
    private OrderService orderService = new OrderService();
    //private ProducersService producersService = new ProducersService();
    private CustomerService customerService = new CustomerService();

    private Stage createStage (String path, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(path));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            return stage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private TextField newEmail;

    @FXML
    private TextField confirmNewEmail;

    @FXML
    private Button submitChange;

    @FXML
    private Label feedBackEmailChange;

    @FXML
    private Label feedBackDelete;

    @FXML
    private Button confirmNoBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField orderID;

    @FXML
    private TableView<Order> ordersIdTable;

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

    @FXML
    void openEmailChanger() {
        Stage stage = createStage("/views/change_email.fxml", "Email change");
        if (stage != null)
            stage.show();
    }

    @FXML
    void submitEmailChange() {
        String email = newEmail.getText();
        String confrimEmail = confirmNewEmail.getText();
        boolean validChange = false;
        Stage changeMailStage = (Stage) submitChange.getScene().getWindow();
        if (email.equals(confrimEmail) && LogInController.getLoggedCustomer() != null)
            validChange = customerService.updateEmail(LogInController.getLoggedCustomer(), email);
        if (validChange) {
            feedBackEmailChange.setText("Succeeded!");

            PauseTransition wait = new PauseTransition(Duration.seconds(2));
            wait.setOnFinished((e) -> {
                changeMailStage.close();
                wait.playFromStart();
            });
            wait.play();

        } else {
            feedBackEmailChange.setText("Failed! Invalid email or already in use!");
        }
    }

    @FXML
    void openDeleteAcc() {
        Stage loggedStage = (Stage) deleteBtn.getScene().getWindow();
        Stage stage = createStage("/views/confirm_delete.fxml", "Delete account");
        System.out.println(LogInController.getLoggedCustomer().getEmail());
        if (stage != null)
            stage.showAndWait();
        if (loggedStage != null)
            loggedStage.close();
    }

    @FXML
    void confirmNo() {
        Stage stage = (Stage) confirmNoBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmYes() {
        Stage stage = (Stage) confirmNoBtn.getScene().getWindow();
        boolean validDelete = customerService.deleteAccount(LogInController.getLoggedCustomer());
        if (validDelete) {
            System.out.println(LogInController.getLoggedCustomer().getEmail());
            feedBackDelete.setText("Succeeded!");
            //loggedCustomer = null;

            PauseTransition wait = new PauseTransition(Duration.seconds(2));
            wait.setOnFinished((e) -> {
                stage.close();
                wait.playFromStart();
            });
            wait.play();
        } else {
            feedBackDelete.setText("Failed!");
            stage.close();
        }
    }

    @FXML
    void listMyOrders() {
        Stage ordersStage = createStage("/views/orders_layout.fxml", "My orders");
        if (ordersStage != null)
            ordersStage.show();
    }

    @FXML
    void listMyInvoices() {
        Stage invoicesStage = createStage("/views/invoices_layout.fxml", "My invoices");
        if (invoicesStage != null)
            invoicesStage.show();
    }

    @FXML
    void seacrhOrder() {
        Stage searchOrder = createStage("/views/search_order_layout.fxml", "Search order by ID");
        if (searchOrder != null)
            searchOrder.show();
    }

    @FXML
    void listFoundOrder() {
        int inputOrderId = Integer.parseInt(orderID.getText());
        Order orderById = orderService.listOrderById(inputOrderId);

        if (orderById != null) {
            ObservableList<Order> ordersModel = FXCollections.observableArrayList(orderById);

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
                ordersIdTable.setItems(ordersModel);
        }
    }
}
