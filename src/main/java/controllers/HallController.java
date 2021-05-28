package controllers;

import dao.implementation.RowDAO;
import dao.implementation.SeatDAO;
import entities.Row;
import entities.Seat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HallController implements Initializable {

    @FXML
    javafx.scene.control.ScrollPane scrollPane;
    @FXML
    GridPane grid;
    @FXML
    ImageView imageView;

    private HBox hb = new HBox();
    private List<Row> rowsCollection = new ArrayList<>();
    private List<Seat> seatsCollection = new ArrayList<>();
    private Image seatIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        seatIcon = new Image(getClass().getResourceAsStream("src/main/resources/Images/SeatIcon.png"));
        imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setImage(seatIcon);

        // gridpane settings
        grid.setPadding(new Insets(7,7,7,7));
        grid.setHgap(10);
        grid.setVgap(10);

        RowDAO rowDAO = new RowDAO();
        rowsCollection = rowDAO.getAll();
        SeatDAO seatDAO = new SeatDAO();
        seatsCollection = seatDAO.getAll();

        int colIndex = 0;
        for(int i = 0; i < rowsCollection.size(); i++) {
            int rowId = rowsCollection.get(i).getId();
            for(int j = 0; j < seatsCollection.size(); j++) {
                Seat seat = seatsCollection.get(i);
                if(seat.getRow().getId() == rowId) {
                    addSeat(colIndex, i);
                    colIndex++;
                }
            }
            colIndex = 0;
        }

    }

    private void addSeat(int colIndex, int rowIndex) {
        hb.getChildren().add(imageView);
        GridPane.setConstraints(imageView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);
        grid.getChildren().addAll(imageView);
    }
}
