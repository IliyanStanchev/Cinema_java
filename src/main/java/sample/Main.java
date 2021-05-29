package sample;

import dao.implementation.MovieDAO;
import dao.implementation.UserDAO;
import entities.Movie;
import entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import manager.MyEntityManager;
import utils.OpenForm;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DatabaseFiller databaseFiller = new DatabaseFiller();
        databaseFiller.fillDatabase();

        OpenForm.openNewForm("/Login.fxml", "Login page");

    }
}
