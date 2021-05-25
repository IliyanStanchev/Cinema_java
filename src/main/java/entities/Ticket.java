package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    @ManyToOne
    private User user;

    @OneToOne
    private Showtime showtime;

    @OneToOne
    private Seat seat;

    public Ticket() {
    }

    public Ticket(int price, User user, Showtime showtime, Seat seat) {
        this.price = price;
        this.user = user;
        this.showtime = showtime;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() && getPrice() == ticket.getPrice() && Objects.equals(getUser(), ticket.getUser()) && Objects.equals(getShowtime(), ticket.getShowtime()) && Objects.equals(getSeat(), ticket.getSeat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getUser(), getShowtime(), getSeat());
    }
}
