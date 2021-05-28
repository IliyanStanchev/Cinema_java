package sample;

import dao.implementation.MovieDAO;
import dao.implementation.RowDAO;
import dao.implementation.SeatDAO;
import dao.implementation.UserDAO;
import entities.Movie;
import entities.Row;
import entities.Seat;
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

        Row row1 = new Row(1, 6);
        Row row2 = new Row(2, 5);
        RowDAO rowDAO = new RowDAO();
        rowDAO.saveOrUpdate(row1);
        rowDAO.saveOrUpdate(row2);

        Seat seat1 = new Seat(1, row1);
        Seat seat2 = new Seat(2, row1);
        Seat seat3 = new Seat(3, row1);
        Seat seat4 = new Seat(4, row1);

        Seat seat5 = new Seat(5, row2);
        Seat seat6 = new Seat(6, row2);
        Seat seat7 = new Seat(7, row2);

        SeatDAO seatDAO = new SeatDAO();
        seatDAO.saveOrUpdate(seat1);
        seatDAO.saveOrUpdate(seat2);
        seatDAO.saveOrUpdate(seat3);
        seatDAO.saveOrUpdate(seat4);
        seatDAO.saveOrUpdate(seat5);
        seatDAO.saveOrUpdate(seat6);
        seatDAO.saveOrUpdate(seat7);

        //OpenForm.openNewForm("/Login.fxml", "Login page");

        OpenForm.openNewForm("/Hall.fxml", "Login page");

    }
}
