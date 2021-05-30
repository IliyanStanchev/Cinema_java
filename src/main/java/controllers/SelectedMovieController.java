package controllers;

import entities.Showtime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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

    @FXML
    private ImageView selectedFilmPoster;

    @FXML
    private ImageView restrictionImage;

    @FXML
    private Label restrictionText;

    @FXML
    private Label genre;

    @FXML
    private Text title;

    @FXML
    private Text description;

    @FXML
    private Text startDate;

    @FXML
    private Text endDate;

    @FXML
    private Text date;

    @FXML
    private Label rating;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void goToBookingScene(ActionEvent event) {
        FXMLLoader loader = OpenForm.openNewForm("/Hall.fxml", "Choose seat");
        HallController next = loader.getController();

        next.setInfo(userId, showtimeId);
        CloseForm.closeForm(event);
    }

    @FXML
    public void backToPrevScene(ActionEvent event) {
        OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CloseForm.closeForm(event);
    }

    @FXML
    public void rate(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/SetRating.fxml", "Rate this movie");
        RatingController next = loader.getController();
        next.setInfo(userId, showtimeId, showtime.getMovie().getId());

        CloseForm.closeForm(event);
    }

    public void setInfo(int userId, int showtimeId) {

        this.showtimeId = showtimeId;
        this.userId = userId;

        ShowtimeService showtimeService = new ShowtimeService();

        showtime = new Showtime();

        showtime = showtimeService.findById(showtimeId);

        Image imagePoster = null;
        Image imageRestriction = null;
        try {
            imageRestriction = new Image(new FileInputStream(showtime.getMovie().getAgeRestriction().getRestrictionImageUrl()));
            imagePoster = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        selectedFilmPoster.setImage(imagePoster);

        restrictionImage.setImage(imageRestriction);
        restrictionText.setText(showtime.getMovie().getAgeRestriction().getRestrictionText());

        genre.setText(showtime.getMovie().getGenre().getGenreName());
        title.setText(showtime.getMovie().getTitle());
        description.setText(showtime.getMovie().getDescription());
        date.setText(showtime.getDate().toString());
        startDate.setText(showtime.getStartTime().toString());
        endDate.setText(showtime.getEndTime().toString());
        rating.setText("" + String.valueOf(showtime.getMovie().getRating().getRating()).substring(0, 3) + "/5");

    }
}
