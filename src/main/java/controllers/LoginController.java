package controllers;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserAuthorizationService;
import utils.CloseForm;
import utils.OpenForm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    private final UserAuthorizationService userAuthorizationService = new UserAuthorizationService();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label resultLabel;

    @FXML
    private void login(ActionEvent event) {

        resultLabel.setText("");

        boolean bUsernameIsEmpty = this.usernameField.getText().isEmpty();
        boolean bPasswordIsEmpty = this.passwordField.getText().isEmpty();

        if (bUsernameIsEmpty && bPasswordIsEmpty) {
            resultLabel.setText("Please fill all fields!");
            usernameField.requestFocus();

            return;
        }

        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = userAuthorizationService.authorizeUser(username, password);

        if (user == null) {
            resultLabel.setText("Wrong username or password!");
            usernameField.requestFocus();
            return;
        }

        FXMLLoader loader = OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CustomerController next = loader.getController();
        next.setInfo(user.getId());

        CloseForm.closeForm(event);
    }

    @FXML
    private void register() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Register.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("User registration");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
