package sample;

import dao.implementation.UserDAO;
import entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import manager.MyEntityManager;
import utils.OpenForm;

import javax.persistence.EntityManager;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        User user = new User("ench3r@gmail.com", "sach", "123", "iliyan", "stanchev", "0897875640");

        UserDAO userDAO = new UserDAO();

        user = userDAO.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = userDAO.saveOrUpdate(user);

        if (user == null) {
            System.out.println("Something went wrong.");
            return;
        }

        OpenForm.openNewForm("/Login.fxml", "Login page");

    }
}
