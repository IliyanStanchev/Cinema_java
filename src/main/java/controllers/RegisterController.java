package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import validators.FieldValidator;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private void register(ActionEvent event) {


        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

    }

    @FXML
    private void validateUsername(KeyEvent event) {

        if (FieldValidator.validateUsername(usernameField, usernameLabel))
            usernameLabel.setText("");

    }

    @FXML
    private void validatePassword(KeyEvent event) {

        if (FieldValidator.validateFieldLength(passwordField, passwordLabel, 8))
            passwordLabel.setText("");


    }

    @FXML
    private void isPasswordSame(KeyEvent event) {

        if (FieldValidator.isPasswordSame(passwordField, confirmPasswordField, confirmPasswordLabel))
            confirmPasswordLabel.setText("");

    }

    @FXML
    private void validateEmail(KeyEvent event) {

        if (FieldValidator.validateEmail(emailField, emailLabel))
            emailLabel.setText("");

    }

    @FXML
    private void validatePhoneNumber(KeyEvent event) {

        if (FieldValidator.validateNumericField(phoneNumberField, phoneNumberLabel))
            phoneNumberLabel.setText("");

    }

    private boolean validateData() {

        if (!FieldValidator.validateUsername(usernameField, usernameLabel))
            return false;

        if (!FieldValidator.validateFieldLength(passwordField, passwordLabel, 8))
            return false;

        if (!FieldValidator.isPasswordSame(passwordField, confirmPasswordField, confirmPasswordLabel))
            return false;

        if (!FieldValidator.validateEmail(emailField, emailLabel))
            return false;

        if (!FieldValidator.validateNumericField(phoneNumberField, phoneNumberLabel))
            return false;

        return true;
    }
}