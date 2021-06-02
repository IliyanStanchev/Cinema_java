package controllers;

import entities.Showtime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import services.ShowtimeService;
import utils.CloseForm;
import utils.OpenForm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class CustomerController implements Initializable {

    private int         userId;

    private List        showtimes;

    private HBox        hBox;

    @FXML
    private ScrollPane  scrollPane;

    @FXML
    private GridPane    grid;

    @FXML
    private ImageView   imageView;

    @FXML
    private Image       image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hBox = new HBox();

        grid.setPadding(new Insets(7, 7, 7, 7));
        grid.setHgap(10);
        grid.setVgap(10);

        showtimes = new ArrayList<Showtime>();

        ShowtimeService showtimeService = new ShowtimeService();

        showtimes = showtimeService.getAll();

        for (int i = 0; i < showtimes.size(); i++)
            addImage(i, i, 1);

        scrollPane.setContent(grid);
    }

    private void addImage(int index, int colIndex, int rowIndex) {

        Showtime showtime = (Showtime) showtimes.get(index);

        try {
            image = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        imageView = new ImageView();
        imageView.setFitWidth(220);
        imageView.setFitHeight(330);
        imageView.setImage(image);

        hBox.getChildren().add(imageView);
        GridPane.setConstraints(imageView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);
        grid.getChildren().addAll(imageView);

        imageView.setOnMouseClicked(event -> {

            FXMLLoader loader = OpenForm.openNewForm("/SelectedMoviePage.fxml", "Booking page");
            SelectedMovieController next = loader.getController();
            next.setInfo(userId, showtime.getId());

            CloseForm.closeFormMouseEvent(event);

        });
    }

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }

    @FXML
    public void editProfile(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/EditUser.fxml", "Edit your profile");
        EditUserController next = loader.getController();
        next.setId(userId);
    }

    public void setInfo(int id) {

        this.userId = id;
    }
}
