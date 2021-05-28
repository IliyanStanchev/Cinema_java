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

    private List showtimes;

    private HBox hBox;

    @FXML
    private ScrollPane scrollPane;


    @FXML
    private GridPane grid;

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

        ShowtimeService showtimeService = new ShowtimeService();

        showtimes = new ArrayList<Showtime>();

        showtimes = showtimeService.getAll();

        final int rows = (showtimes.size() / 4) + 1;
        final int columns = 4;

        int imageIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (imageIndex < showtimes.size()) {
                    addImage(imageIndex, j, i);
                    imageIndex++;
                }
            }
        }
    }

    private void addImage(int index, int colIndex, int rowIndex) {

        Showtime showtime = (Showtime) showtimes.get(index);

        try {
            image = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
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
            next.setShowtime(showtime.getId());

            CloseForm.closeFormMouseEvent(event);

        });
    }

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }

}
