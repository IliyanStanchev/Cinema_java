package controllers;

import entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    private User user;

    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadData(User user) {

        this.user = user;

        welcomeLabel.setText("Welcome " + user.getUsername() + " maikati sheiba");
    }
}
