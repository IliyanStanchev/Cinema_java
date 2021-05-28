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

        User user = new User("ench3r@gmail.com", "sach", "123", "iliyan", "stanchev", "0897875640");

        UserDAO userDAO = new UserDAO();

        user = userDAO.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = userDAO.saveOrUpdate(user);

        if (user == null) {
            System.out.println("Something went wrong.");
            return;
        }

        MovieDAO movieDAO = new MovieDAO();

        Movie movie = new Movie(0,"Godzilla vs Kong", "Action, 3D, IMAX 3D, 4DX",null, null, null,"src/main/resources/MovieImages/Godzilla vs Kong.jpg");
        movieDAO.saveOrUpdate(movie);

        movie = new Movie(0,"Mortal Kombat", "Action, 3D, IMAX 3D, 4DX",null, null, null,"src/main/resources/MovieImages/Mortal Kombat.jpg");
        movieDAO.saveOrUpdate(movie);

        OpenForm.openNewForm("/Login.fxml", "Login page");

    }
}
