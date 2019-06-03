package shop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.domain.entity.Customer;
import shop.services.CustomerService;

import java.io.IOException;

public class LogInController {

    private CustomerService customerService = new CustomerService();

    private static Customer loggedCustomer;

    public static Customer getLoggedCustomer() {
        return loggedCustomer;
    }

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
    private TextField emailInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button closeLoginSucces;

    @FXML
    private Button submitLoginBtn;

    @FXML
    private Button closeSignUpSucces;

    @FXML
    private Button closeLoginFail;

    @FXML
    private Button closeSignUpFail;

    @FXML
    void submitLogIn() {
        String email = emailInput.getText();
        String password = passwordInput.getText();
        loggedCustomer = customerService.logIn(email, password);
        if (loggedCustomer != null) {
            Stage stage = createStage("/views/login_succes.fxml", "Succes");
            if (stage != null)
                stage.showAndWait();
            Stage logInStage = (Stage) submitLoginBtn.getScene().getWindow();
            if (logInStage != null)
                logInStage.close();
        } else {
            Stage stage = createStage("/views/login_fail.fxml", "Fail");
            if (stage != null)
                stage.showAndWait();
        }
    }

    @FXML
    void openLoggedInPanel() {
        Stage succesStage = (Stage) closeLoginSucces.getScene().getWindow();
        succesStage.close();
        Stage stage = createStage("/views/logged_layout.fxml", "Account Panel");
        if (stage != null)
            stage.show();
    }

    @FXML
    void closeSignUpLayout() {
        Stage succesStage = (Stage) closeSignUpSucces.getScene().getWindow();
        succesStage.close();
    }

    @FXML
    void closeLogInFail() {
        Stage failStage = (Stage) closeLoginFail.getScene().getWindow();
        failStage.close();
    }

    @FXML
    void closeSignUpFail() {
        Stage failStage = (Stage) closeSignUpFail.getScene().getWindow();
        failStage.close();
    }

}
