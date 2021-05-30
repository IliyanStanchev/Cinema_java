package controllers;

import entities.Movie;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import org.controlsfx.control.Rating;
import services.MovieService;
import utils.CloseForm;
import utils.OpenForm;

import java.net.URL;
import java.util.ResourceBundle;

public class RatingController implements Initializable {


    private int userId;

    private int showtimeId;

    private int movieId;

    private double ratingAdded;

    @FXML
    private Rating rating;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number rating) {

                ratingAdded = (double) rating;
            }
        });

    }

    public void submit(ActionEvent event) {

        MovieService movieService = new MovieService();

        Movie movie = movieService.findById(movieId);

        movie.getRating().addRating((int) ratingAdded);

        movieService.saveOrUpdate(movie);

        FXMLLoader loader = OpenForm.openNewForm("/SelectedMoviePage.fxml", "Selected movie");
        SelectedMovieController next = loader.getController();
        next.setInfo(userId, showtimeId);

        CloseForm.closeForm(event);

    }

    public void setInfo(int userId, int showtimeId, int movieId) {

        this.movieId = movieId;
        this.userId = userId;
        this.showtimeId = showtimeId;
    }
}
