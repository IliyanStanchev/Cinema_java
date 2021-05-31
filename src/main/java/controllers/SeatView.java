package controllers;

import entities.ShowtimeSeat;
import enums.SeatState;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SeatView extends ImageView {

    private final String bookedSeatIcon = "src/main/resources/Images/BookedSeatIcon.png";
    private final String reservedSeatIcon = "src/main/resources/Images/ReservedSeatIcon.png";
    private final String emptySeatIcon = "src/main/resources/Images/EmptySeatIcon.png";

    private final ShowtimeSeat seat;

    public SeatView(ShowtimeSeat seat) {
        this.seat = seat;
        setFitHeight(80);
        setFitWidth(80);
        setImage();
    }

    public ShowtimeSeat getShowtimeSeat() {
        return seat;
    }

    public void setImage() {

        final SeatState seatState = seat.getSeatState();

        try {
            if (seatState == SeatState.seatStateEmpty)
                super.setImage(new Image(new FileInputStream(emptySeatIcon)));

            if (seatState == SeatState.seatStateReserved)
                super.setImage(new Image(new FileInputStream(reservedSeatIcon)));

            if (seatState == SeatState.seatStateBooked)
                super.setImage(new Image(new FileInputStream(bookedSeatIcon)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
