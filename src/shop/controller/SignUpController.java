package shop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.services.CustomerService;

import java.io.IOException;
import java.util.ArrayList;

public class  SignUpController {

    ObservableList<Integer> obsSector = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);

    CustomerService customerService = new CustomerService();

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField cnpInput;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private TextField emailInput;

    @FXML
    private PasswordField passInput;

    @FXML
    private TextField streetInput;

    @FXML
    private TextField noStreetInput;

    @FXML
    private ChoiceBox sectorInput;

    @FXML
    public Button submitSignUpBtn;

    @FXML
    private void initialize () {
        sectorInput.setValue(1);
        sectorInput.setItems(obsSector);
    }

    @FXML
    void submitSignUp(ActionEvent event) {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String cnp = cnpInput.getText();
        String phoneNumber = phoneNumberInput.getText();
        String email = emailInput.getText();
        String password = passInput.getText();
        String street = streetInput.getText();
        String noStreet = noStreetInput.getText();
        String sectorString = sectorInput.getValue().toString();

        ArrayList<String> customerInfo = new ArrayList<>(10);
        customerInfo.add(firstName);
        customerInfo.add(lastName);
        customerInfo.add(cnp);
        customerInfo.add(phoneNumber);
        customerInfo.add(email);
        customerInfo.add(password);
        customerInfo.add(street);
        customerInfo.add(noStreet);
        customerInfo.add(sectorString);

        boolean valid = customerService.addCustomer(customerInfo);

        if (!valid) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/signup_fail.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Fail");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Stage signUpStage = (Stage) submitSignUpBtn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/signup_succes.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Succes");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                signUpStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
