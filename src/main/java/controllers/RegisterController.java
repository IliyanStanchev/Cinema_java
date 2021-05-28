package controllers;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import services.UserAuthorizationService;
import validators.FieldValidator;

public class RegisterController {

    private UserAuthorizationService userAuthorizationService = new UserAuthorizationService();

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

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
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

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

        resultLabel.setText("");

        if (usernameField.getText().isEmpty()
                || passwordField.getText().isEmpty()
                || confirmPasswordField.getText().isEmpty()
                || emailField.getText().isEmpty()
                || phoneNumberField.getText().isEmpty()
                || firstNameField.getText().isEmpty()
                || lastNameField.getText().isEmpty()) {

            resultLabel.setText("Empty fields!");
            resultLabel.setTextFill(Color.web("red"));

            usernameField.requestFocus();

            return;
        }

        if (!validateData()) {
            resultLabel.setText("Incorrect fields!");
            resultLabel.setTextFill(Color.web("red"));

            usernameField.requestFocus();

            return;
        }

        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        User user = new User(email, username, password, firstName, lastName, phoneNumber);

        if (!userAuthorizationService.registerUser(user)) {
            resultLabel.setText("Something went wrong!");
            resultLabel.setTextFill(Color.web("red"));

            usernameField.requestFocus();

            return;
        }

        resultLabel.setText("Successfully created account!");
        resultLabel.setTextFill(Color.web("green"));

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

    @FXML
    private void validateFirstName(KeyEvent event) {

        if (FieldValidator.validatePersonName(firstNameField, firstNameLabel))
            firstNameLabel.setText("");

    }

    @FXML
    private void validateLastName(KeyEvent event) {

        if (FieldValidator.validatePersonName(lastNameField, lastNameLabel))
            lastNameLabel.setText("");

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
