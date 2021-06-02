package controllers;

import entities.*;
import enums.SeatState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ShowtimeSeatService;
import services.TicketService;
import services.UserService;
import utils.CloseForm;
import utils.OpenForm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class TicketController implements Initializable {

    private List seats;

    private User user;

    @FXML
    private ImageView selectedFilmPoster;

    @FXML
    private Label title;

    @FXML
    private Label startTime;

    @FXML
    private Label endTime;

    @FXML
    private Label movieDimension;

    @FXML
    private Label date;

    @FXML
    private Label price;

    @FXML
    private Label seat;

    @FXML
    private Label client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void cancel(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CustomerController next = loader.getController();
        next.setInfo(user.getId());

        CloseForm.closeForm(event);
    }

    public void purchase(ActionEvent event) {

        TicketService ticketService = new TicketService();
        ShowtimeSeatService showtimeSeatService = new ShowtimeSeatService();

        for (Object o : seats) {
            ShowtimeSeat seat = (ShowtimeSeat) o;

            ticketService.save(new Ticket(user, seat.getShowtime(), seat.getSeat()));

            seat.setSeatState(SeatState.seatStateBooked);
            showtimeSeatService.update(seat);

        }

        FXMLLoader loader = OpenForm.openNewForm("/CustomerPage.fxml", "Main page");
        CustomerController next = loader.getController();
        next.setInfo(user.getId());

        CloseForm.closeForm(event);
    }

    public void setInfo(int userId, List selectedSeats) {

        UserService userService = new UserService();

        this.user = userService.findById(userId);

        this.seats = selectedSeats;

        ShowtimeSeat showtimeSeat = (ShowtimeSeat) seats.get(0);
        Showtime showtime = showtimeSeat.getShowtime();
        Movie movie = showtimeSeat.getShowtime().getMovie();

        Image image = null;
        try {
            image = new Image(new FileInputStream(showtime.getMovie().getImageUrl()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        selectedFilmPoster.setImage(image);

        this.client.setText(user.getFirstName() + " " + user.getSecondName());
        this.title.setText(movie.getTitle());
        this.date.setText(showtime.getDate().toString());
        this.movieDimension.setText(showtime.getMovieDimension().getDimension());
        this.startTime.setText(showtime.getStartTime().toString());
        this.endTime.setText(showtime.getEndTime().toString());

        String reservedSeats = "";
        double totalPrice = 0;

        int br = 0;

        for (Object o : seats) {

            br++;
            if (br % 2 == 0)
                reservedSeats += "\n";

            ShowtimeSeat seat = (ShowtimeSeat) o;
            reservedSeats += "Seat " + seat.getSeat().getSeatNumber() + " in Row " + seat.getSeat().getRow().getRowNumber() + "; ";
            totalPrice += seat.getShowtime().getPrice();

        }

        this.seat.setText(reservedSeats);
        this.price.setText(String.valueOf(totalPrice));
    }
}