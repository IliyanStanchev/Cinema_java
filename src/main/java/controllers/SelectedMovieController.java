package controllers;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import entities.Movie;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.Main;
import services.MovieService;
import utils.CloseForm;
import utils.OpenForm;


public class SelectedMovieController implements Initializable{

    @FXML
    private ImageView selectedFilmPoster;

    @FXML
    private Text title;

    @FXML
    private Text description;

    @FXML
    private Text startDate;

    @FXML
    private Text endDate;

    @FXML
    private Text time;

    @FXML
    private Button backButton, bookButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void goToBookingScene(ActionEvent event) {

    }

    @FXML
    public void backToPrevScene(ActionEvent event) {
        OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CloseForm.closeForm(event);
    }

    public void setMovie(int id) {

        MovieService movieService = new MovieService();

        Movie movie = movieService.findById(id);

        Image image = null;
        try {
           image = new Image(new FileInputStream(movie.getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        selectedFilmPoster.setImage(image);
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());

    }
}
