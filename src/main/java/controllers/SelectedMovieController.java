package controllers;

import entities.Showtime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import services.ShowtimeService;
import utils.OpenForm;
import utils.CloseForm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class SelectedMovieController implements Initializable {

    private int showtimeId;

    private int userId;

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
    private Text date;

 /*   @FXML
    private Button backButton, bookButton;*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void goToBookingScene(ActionEvent event) {
        FXMLLoader loader = OpenForm.openNewForm("/Hall.fxml", "Choose seats");
        HallController next = loader.getController();

        next.setInfo(userId,showtimeId);
        CloseForm.closeForm(event);
    }

    @FXML
    public void backToPrevScene(ActionEvent event) {
        OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CloseForm.closeForm(event);
    }

    public void setInfo(int userId,int showtimeId) {

        this.showtimeId = showtimeId;
        this.userId     = userId;

        ShowtimeService showtimeService = new ShowtimeService();

        Showtime showtime = showtimeService.findById(showtimeId);

        Image image = null;
        try {
            image = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        selectedFilmPoster.setImage(image);

        title.setText(showtime.getMovie().getTitle());
        description.setText(showtime.getMovie().getDescription());
        date.setText(showtime.getDate().toString());
        startDate.setText(showtime.getStartTime().toString());
        endDate.setText(showtime.getEndTime().toString());

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
