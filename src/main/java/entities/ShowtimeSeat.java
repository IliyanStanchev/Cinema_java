package entities;

import enums.SeatState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ShowtimeSeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Showtime showtime;

    @OneToOne
    private Seat seat;

    SeatState seatState;

    public ShowtimeSeat(int id, Showtime showtime, Seat seat, SeatState seatState) {
        this.id = id;
        this.showtime = showtime;
        this.seat = seat;
        this.seatState = seatState;
    }

    public ShowtimeSeat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatState getSeatState() {
        return seatState;
    }

    public void setSeatState(SeatState seatState) {
        this.seatState = seatState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowtimeSeat)) return false;
        ShowtimeSeat that = (ShowtimeSeat) o;
        return getId() == that.getId() && Objects.equals(getShowtime(), that.getShowtime()) && Objects.equals(getSeat(), that.getSeat()) && getSeatState() == that.getSeatState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getShowtime(), getSeat(), getSeatState());
    }
}
