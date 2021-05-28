package controllers;

import entities.Movie;
import entities.User;

import javafx.fxml.*;
import javafx.scene.control.Label;

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
import sample.Main;
import utils.CloseForm;
import utils.OpenForm;

public class CustomerController implements Initializable {

    ArrayList<File> fileList = new ArrayList<File>();
    HBox hb = new HBox();

    @FXML
    ScrollPane scrollPane;
    @FXML
    GridPane grid;
    @FXML
    Button backButton;
    @FXML
    ImageView pic;
    @FXML
    Image image;
    @FXML
    String id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            String path = URLDecoder.decode(/*Main.getPath()*/ "src/main/resources/MovieImages/", "UTF-8");

            File folder = new File(path);

            for (File file : folder.listFiles()) {
                if (!file.toString().contains("DS_Store")) {
                    fileList.add(file);
                }
            }

            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

            // gridpane settings
            // setting exterior grid padding
            grid.setPadding(new Insets(7,7,7,7));
            // setting interior grid padding
            grid.setHgap(10);
            grid.setVgap(10);

            int rows = (fileList.size() / 4) + 1;
            int columns = 4;
            int imageIndex = 0;

            for (int i = 0 ; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                    if(imageIndex < fileList.size()){
                        addImage(imageIndex, j, i);
                        imageIndex++;
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }}

    /**
     * Method that adds ImageView nodes to a GridPane
     * @param //int index, int colIndex, int rowIndex
     */
    private void addImage(int index, int colIndex, int rowIndex) {

        File file = fileList.get(index);
        String movieName = file.getName().toString();
        movieName = movieName.substring(0, (movieName.length() - 4));

        String id;

        for(int i=0; i<Main.oListMovies.size();i++)
        {
            id = null;

            Movie movie = Main.oListMovies.get(i);

            if(movieName.equals(movie.getTitle()))
            {
                id = Integer.toString(movie.getId());

                image = new Image(fileList.get(index).toURI().toString());
                pic = new ImageView();
                pic.setFitWidth(160);
                pic.setFitHeight(220);
                pic.setImage(image);
                pic.setId(id);
                hb.getChildren().add(pic);
                GridPane.setConstraints(pic, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);
                grid.getChildren().addAll(pic);

                pic.setOnMouseClicked(event -> {
                    Main.movieID = pic.getId();
                    FXMLLoader loader = OpenForm.openNewForm("/SelectedMoviePage.fxml", "Booking page");
                    //SelectedMovieController controller = loader.getController();
                    //controller.movieID = pic.getId();

                    CloseForm.closeFormMouseEvent(event);
                });

                break;
            }
        }
    }

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }

    @FXML
    public String getId () {

        return id;
    }

}
