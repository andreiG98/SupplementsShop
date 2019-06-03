package shop.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import shop.domain.entity.Customer;
import shop.services.CustomerService;
import shop.services.OrderService;
import shop.services.ProducersService;

import java.io.IOException;

public class LoggedInController {

    private static Customer loggedCustomer = LogInController.getLoggedCustomer();
    private OrderService orderService = new OrderService();
    private ProducersService producersService = new ProducersService();
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
        if (email.equals(confrimEmail) && loggedCustomer != null)
            validChange = customerService.updateEmail(loggedCustomer, email);
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
        boolean validDelete = customerService.deleteAccount(loggedCustomer);
        if (validDelete) {
            feedBackDelete.setText("Succeeded!");

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
}
