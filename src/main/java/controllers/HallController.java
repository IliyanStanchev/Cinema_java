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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HallController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private ImageView imageView;
    @FXML
    private Image seatIcon;

    private HBox hBox;
    // private List<Row> rowsCollection   =  new ArrayList<>();
    // private List<Seat> seatsCollection  =  new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Row> rowsCollection = new ArrayList<>();
        List<Seat> seatsCollection = new ArrayList<>();

        hBox = new HBox();
        grid = new GridPane();
        grid.setPadding(new Insets(7, 7, 7, 7));
        grid.setHgap(10);
        grid.setVgap(10);

        seatIcon = new Image(getClass().getResourceAsStream("/Images/SeatIcon.png"));
        imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setImage(seatIcon);

        RowDAO rowDAO = new RowDAO();
        rowsCollection = rowDAO.getAll();
        SeatDAO seatDAO = new SeatDAO();
        seatsCollection = seatDAO.getAll();

        Seat seat;
        int colIndex = 0;
        for (int i = 0; i < rowsCollection.size(); i++) {
            int rowId = rowsCollection.get(i).getId();
            for (int j = 0; j < seatsCollection.size(); j++) {
                seat = seatsCollection.get(j);
                if (seat.getRow().getId() == rowId) {
                    addSeat(colIndex, i);
                    colIndex++;
                }
            }
            colIndex = 0;
        }

    }

    private void addSeat(int colIndex, int rowIndex) {

        imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setImage(seatIcon);

        hBox.getChildren().add(imageView);
        GridPane.setConstraints(imageView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);
        grid.getChildren().addAll(imageView);
    }
}
