package shop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPaneController {

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
    private Button logInBtn;

    @FXML
    void openAddCustomer() {
        Stage stage = createStage("/views/sign_up.fxml", "Sign Up");
        if (stage != null)
            stage.show();
    }

    @FXML
    void openLogIn() {
        Stage stage = createStage("/views/log_in.fxml", "Log In");
        if (stage != null)
            stage.showAndWait();
    }

}
