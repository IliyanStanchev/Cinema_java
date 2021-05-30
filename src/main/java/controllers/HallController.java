package controllers;

import entities.Seat;
import entities.ShowtimeSeat;
import enums.SeatState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import services.ShowtimeSeatService;
import utils.CloseForm;
import utils.OpenForm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HallController implements Initializable {

    private final String bookedSeatIcon     = "src/main/resources/Images/BookedSeatIcon.png";
    private final String reservedSeatIcon   = "src/main/resources/Images/ReservedSeatIcon.png";
    private final String emptySeatIcon      = "src/main/resources/Images/EmptySeatIcon.png";

    private int showtimeId;

    private int userId;

    private List seats;

    private List selectedSeats;

    private HBox hBox;

    @FXML
    private Label seat;

    @FXML
    private Label count;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane grid;

    @FXML
    private SeatView seatView;

    @FXML
    private Image image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hBox = new HBox();

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void addImage(int index, int colIndex, int rowIndex) {

        ShowtimeSeat seat = (ShowtimeSeat)seats.get(index);

        seatView = new SeatView(seat);

        hBox.getChildren().add(seatView);

        GridPane.setConstraints(seatView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);

        grid.getChildren().addAll(seatView);

        seatView.setOnMouseClicked(event -> {

            final SeatState seatState = seatView.getShowtimeSeat().getSeatState();

            if(seatState == SeatState.seatStateBooked)
                return;

            seat.setSeatState(SeatState.seatStateReserved);

            SeatView newSeatView = new SeatView(seat);

            hBox.getChildren().remove(seatView);
            hBox.getChildren().add(newSeatView);

            GridPane.setConstraints(newSeatView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);

            grid.getChildren().addAll(newSeatView);

            newSeatView.setOnMouseClicked(event1 -> {

                seat.setSeatState(SeatState.seatStateEmpty);

                seatView = new SeatView(seat);

                hBox.getChildren().remove(newSeatView);
                hBox.getChildren().add(seatView);

                GridPane.setConstraints(seatView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);

                grid.getChildren().addAll(seatView);
            });

            selectedSeats.add(newSeatView.getShowtimeSeat());

            this.seat.setText("Seat number: " + newSeatView.getShowtimeSeat().getSeat().getSeatNumber() + "Seat row: " + newSeatView.getShowtimeSeat().getSeat().getRow().getRowNumber());
            this.count.setText(String.valueOf(selectedSeats.size()));
        });
    }

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }

    public void setInfo(int userId, int showtimeId) {

        this.userId     = userId;
        this.showtimeId = showtimeId;

        ShowtimeSeatService seatService = new ShowtimeSeatService();

        seats = new ArrayList<ShowtimeSeat>();
        selectedSeats = new ArrayList<ShowtimeSeat>();

        seats = seatService.getAll(showtimeId);

        final int columns = 8;
        final int rows = (seats.size() / columns);

        int imageIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (imageIndex < seats.size()) {
                    addImage(imageIndex, j, i);
                    imageIndex++;
                }
            }
        }
    }

    @FXML
    public void back(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/SelectedMoviePage.fxml", "Booking page");
        SelectedMovieController next = loader.getController();
        next.setInfo(userId, showtimeId);
        CloseForm.closeForm(event);
    }
}
