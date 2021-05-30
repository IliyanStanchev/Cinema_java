package controllers;

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
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.ResourceBundle;

public class HallController implements Initializable {

    private final String bookedSeatIcon = "src/main/resources/Images/BookedSeatIcon.png";
    private final String reservedSeatIcon = "src/main/resources/Images/ReservedSeatIcon.png";
    private final String emptySeatIcon = "src/main/resources/Images/EmptySeatIcon.png";

    private int userId;

    private List seats;

    private List selectedSeats;

    private HBox hBox;

    private int showtimeId;

    @FXML
    private Label pricePerTicket;

    @FXML
    private Label totalPrice;

    @FXML
    private Label seatCount;

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

    private void setOnClickEvent(final SeatView seatView, int colIndex, int rowIndex) {

        hBox.getChildren().add(seatView);

        GridPane.setConstraints(seatView, colIndex, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER);

        grid.getChildren().addAll(seatView);

        seatView.setOnMouseClicked(event -> {

            SeatState state = seatView.getShowtimeSeat().getSeatState();

            if (state == SeatState.seatStateEmpty) {
                seatView.getShowtimeSeat().setSeatState(SeatState.seatStateReserved);
                selectedSeats.add(seatView.getShowtimeSeat());
            }

            if (state == SeatState.seatStateReserved) {
                seatView.getShowtimeSeat().setSeatState(SeatState.seatStateEmpty);
                selectedSeats.remove(seatView.getShowtimeSeat());
            }

            SeatView newSeatView = new SeatView(seatView.getShowtimeSeat());

            hBox.getChildren().remove(seatView);


            this.seatCount.setText(String.valueOf(selectedSeats.size()));
            this.pricePerTicket.setText(String.valueOf(seatView.getShowtimeSeat().getShowtime().getPrice()));
            this.totalPrice.setText(String.valueOf(selectedSeats.size() * seatView.getShowtimeSeat().getShowtime().getPrice()));

            setOnClickEvent(newSeatView, colIndex, rowIndex);
        });
    }

    private void addImage(int index, int colIndex, int rowIndex) {

        ShowtimeSeat seat = (ShowtimeSeat) seats.get(index);

        seatView = new SeatView(seat);

        setOnClickEvent(seatView, colIndex, rowIndex);

    }

    @FXML
    public void bookSeats(ActionEvent event) {

        FXMLLoader loader = OpenForm.openNewForm("/Ticket.fxml", "Tickets");
        TicketController next = loader.getController();

        next.setInfo(userId, selectedSeats);
    }

    public void setInfo(int userId, int showtimeId) {

        this.showtimeId = showtimeId;
        this.userId = userId;

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

    @FXML
    public void logout(ActionEvent event) {

        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);
    }
}


