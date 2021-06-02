package controllers;

import dao.implementation.UserDAO;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import utils.CloseForm;
import validators.FieldValidator;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField repeatPassword;

    @FXML
    private TextField firstName;

    @FXML
    private TextField secondName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Label label;

    @FXML
    private Label errorLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label repeatPasswordLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label secondNameLabel;

    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setId(int id) {

        UserDAO userDAO = new UserDAO();
        user = userDAO.findById(id);

        email.setText(          user.getEmail());
        username.setText(       user.getUsername());
        password.setText(       user.getPassword());
        repeatPassword.setText( user.getPassword());
        firstName.setText(      user.getFirstName());
        secondName.setText(     user.getSecondName());
        phoneNumber.setText(    user.getPhoneNumber());

        label.setText("Edit user " + user.getUsername());
    }


    public void save(ActionEvent event) {

        if (username.getText().isEmpty()
                || password.getText().isEmpty()
                || repeatPassword.getText().isEmpty()
                || email.getText().isEmpty()
                || phoneNumber.getText().isEmpty()
                || firstName.getText().isEmpty()
                || secondName.getText().isEmpty()) {

            errorLabel.setText("Empty fields!");
            errorLabel.setTextFill(Color.web("red"));

            username.requestFocus();

            return;
        }

        if (!validateData()) {

            errorLabel.setText("Incorrect fields!");
            errorLabel.setTextFill(Color.web("red"));

            username.requestFocus();

            return;
        }

        user.setEmail(email.getText());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setFirstName(firstName.getText());
        user.setSecondName(secondName.getText());
        user.setPhoneNumber(phoneNumber.getText());

        UserDAO userDAO = new UserDAO();
        userDAO.saveOrUpdate(user);

        CloseForm.closeForm(event);

    }

    public void cancel(ActionEvent event) {

        CloseForm.closeForm(event);
    }


    @FXML
    private void validateUsername(KeyEvent event) {

        if (FieldValidator.validateUsername(username, usernameLabel))
            usernameLabel.setText("");

    }

    @FXML
    private void validatePassword(KeyEvent event) {

        if (FieldValidator.validateFieldLength(password, passwordLabel, 8))
            passwordLabel.setText("");


    }

    @FXML
    private void isPasswordSame(KeyEvent event) {

        if (FieldValidator.isPasswordSame(password, repeatPassword, repeatPasswordLabel))
            repeatPasswordLabel.setText("");

    }

    @FXML
    private void validateEmail(KeyEvent event) {

        if (FieldValidator.validateEmail(email, emailLabel))
            emailLabel.setText("");

    }

    @FXML
    private void validatePhoneNumber(KeyEvent event) {

        if (FieldValidator.validateNumericField(phoneNumber, phoneNumberLabel))
            phoneNumberLabel.setText("");

    }

    @FXML
    private void validateFirstName(KeyEvent event) {

        if (FieldValidator.validatePersonName(firstName, firstNameLabel))
            firstNameLabel.setText("");

    }

    @FXML
    private void validateLastName(KeyEvent event) {

        if (FieldValidator.validatePersonName(secondName, secondNameLabel))
            secondNameLabel.setText("");

    }

    private boolean validateData() {

        if (!FieldValidator.validateUsername(username, usernameLabel))
            return false;

        if (!FieldValidator.validateFieldLength(password, passwordLabel, 8))
            return false;

        if (!FieldValidator.isPasswordSame(password, repeatPassword, repeatPasswordLabel))
            return false;

        if (!FieldValidator.validateEmail(email, emailLabel))
            return false;

        return FieldValidator.validateNumericField(phoneNumber, phoneNumberLabel);
    }
}
