package controllers;

import entities.Movie;
import entities.Showtime;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import services.MovieService;
import services.ShowtimeService;
import utils.CloseForm;
import utils.OpenForm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class SelectedMovieController implements Initializable {

    private int showtimeId;

    private int userId;

    private Showtime showtime;

    private double ratingAdded;

    @FXML
    private ImageView selectedFilmPoster;

    @FXML
    private Text title;

    @FXML
    private Text description;

    @FXML
    private Text movieDimension;

    @FXML
    private Text genre;

    @FXML
    private Text rating;

    @FXML
    private Text startDate;

    @FXML
    private Text endDate;

    @FXML
    private Text date;

    @FXML
    private Rating ratingBar;

    @FXML
    private ImageView ageRestrictionImage;

    @FXML
    private Text ageRestrictionText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ratingBar.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number ratingNum) {

                ratingAdded = (double) ratingNum;
            }
        });
    }

    @FXML
    public void goToBookingScene(ActionEvent event) {
        FXMLLoader loader = OpenForm.openNewForm("/Hall.fxml", "Choose seats");
        HallController next = loader.getController();

        next.setInfo(userId, showtimeId);
        CloseForm.closeForm(event);
    }

    @FXML
    public void rateMovie(ActionEvent event) {

        MovieService movieService = new MovieService();

        Movie movie = movieService.findById(showtime.getMovie().getId());

        movie.getRating().addRating(ratingAdded);

        movie = movieService.saveOrUpdate(movie);

        rating.setText(String.valueOf(movie.getRating().getRating()).substring(0, 3) + "/5");

    }

    public void setInfo(int userId, int showtimeId) {

        this.showtimeId = showtimeId;
        this.userId = userId;

        ShowtimeService showtimeService = new ShowtimeService();

        showtime = showtimeService.findById(showtimeId);

        Image movieImage = null;
        Image ageImage = null;

        try {
            ageImage = new Image(new FileInputStream(showtime.getMovie().getAgeRestriction().getRestrictionImageUrl()));
            movieImage = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        selectedFilmPoster.setImage(movieImage);

        ageRestrictionImage.setImage(ageImage);

        ageRestrictionText.setText(showtime.getMovie().getAgeRestriction().getRestrictionText());

        title.setText(showtime.getMovie().getTitle());

        description.setText(showtime.getMovie().getDescription());

        date.setText(showtime.getDate().toString());

        startDate.setText(showtime.getStartTime().toString());

        endDate.setText(showtime.getEndTime().toString());

        rating.setText(String.valueOf(showtime.getMovie().getRating().getRating()).substring(0, 3) + "/5");

        genre.setText(showtime.getMovie().getGenre().getGenreName());

        movieDimension.setText(showtime.getMovieDimension().getDimension());

        ratingBar.setRating(showtime.getMovie().getRating().getRating());


    }


    public void back(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CustomerController next = loader.getController();
        next.setInfo(userId);
        CloseForm.closeForm(event);
    }

    public void logout(ActionEvent event) {
        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }
}
