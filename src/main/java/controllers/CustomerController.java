package controllers;

import entities.Movie;
import entities.User;

import javafx.fxml.*;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import services.MovieService;
import utils.CloseForm;
import utils.OpenForm;

public class CustomerController implements Initializable {

    private List movies;

    private HBox hBox;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane grid;
    @FXML
    private Button backButton;
    @FXML
    private ImageView imageView;
    @FXML
    private Image image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hBox = new HBox();

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        grid.setPadding(new Insets(7, 7, 7, 7));
        grid.setHgap(10);
        grid.setVgap(10);

        MovieService movieService = new MovieService();

        movies = new ArrayList<Movie>();

        movies = movieService.getAll();

        final int rows = (movies.size() / 4) + 1;
        final int columns = 4;

        int imageIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (imageIndex < movies.size()) {
                    addImage(imageIndex, j, i);
                    imageIndex++;
                }
            }
        }
    }

    private void addImage(int index, int colIndex, int rowIndex)  {

        Movie movie = (Movie) movies.get(index);

        try {
            image = new Image(new FileInputStream(movie.getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView = new ImageView();
        imageView.setFitWidth(160);
        imageView.setFitHeight(220);
        imageView.setImage(image);

        hBox.getChildren().add(imageView);
        GridPane.setConstraints(imageView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);
        grid.getChildren().addAll(imageView);

        imageView.setOnMouseClicked(event -> {

            FXMLLoader loader = OpenForm.openNewForm("/SelectedMoviePage.fxml", "Booking page");
            SelectedMovieController next = loader.getController();
            next.setMovie(movie.getId());

            CloseForm.closeFormMouseEvent(event);

        });
    }

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }

}
