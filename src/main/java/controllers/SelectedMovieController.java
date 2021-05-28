package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import utils.CloseForm;
import utils.OpenForm;


public class SelectedMovieController implements Initializable{

    File imgFile = null;
    Desktop desktop = Desktop.getDesktop();

    String movieID;

    @FXML
    ImageView selectedFilmPoster;
    @FXML
    Text title;
    @FXML
    Text description;
    @FXML
    Text startDate;
    @FXML
    Text endDate;
    @FXML
    Text time;
    @FXML
    Button backButton, bookButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Movie movie = null;
        for(int i=0;i<Main.oListMovies.size();i++)
        {
            movie = Main.oListMovies.get(i);
            if(movie.getId() == Integer.parseInt(Main.movieID))
            {
                break;
            }
        }

        String path = null;
        try {
            path = URLDecoder.decode("src/main/resources/MovieImages/", "UTF-8");
            imgFile = new File(path + movie.getTitle() + ".jpg");
            Image img = SwingFXUtils.toFXImage(ImageIO.read(imgFile), null);
            selectedFilmPoster.setImage(img);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        title.setText(movie.getTitle());
        description.setText(movie.getDescription());

    }

    @FXML
    public void goToBookingScene(ActionEvent event) {
        //OpenForm.openNewForm("/BookingPage.fxml", "Booking page");
        //CloseForm.closeForm(event);
    }

    @FXML
    public void backToPrevScene(ActionEvent event) {
        OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CloseForm.closeForm(event);
    }
}
