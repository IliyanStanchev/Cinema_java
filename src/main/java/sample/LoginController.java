package sample;

import entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button btnLogin;

    @FXML
    private Label resultLabel;

    @FXML
    private Hyperlink hyperSignUp;

    @FXML
    private void Login(ActionEvent event){

        resultLabel.setText("");

        boolean bUsernameIsEmpty = this.usernameField.getText().isEmpty();
        boolean bPasswordIsEmpty = this.passwordField.getText().isEmpty();

        if(bUsernameIsEmpty && bPasswordIsEmpty)
        {
            resultLabel.setText("Please fill all fields!");
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();

            return;
        }

        String strUsername = usernameField.getText();
        String strPassword = passwordField.getText();
        /*
        User user = loginService.authenticateUserLogin(strUsername, strPassword);
        if(user != null)
        {
            user.loadController();
            //close form method
        }
        else
        {
            resultLabel.setText("Wrong username or password!");
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();
        }*/

    }

    @FXML
    private void Register() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Register.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("User registration");
        stage.setScene(new Scene(root, 400, 600));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
