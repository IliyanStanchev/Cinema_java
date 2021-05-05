package entities;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    @ManyToOne
    private User user;

    @ManyToOne
    private Showtime showtime;

    @ManyToOne
    private Seat seat;

    public Ticket() {}

    public Ticket(int price, User user, Showtime showtime, Seat seat) {
        this.price = price;
        this.user = user;
        this.showtime = showtime;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", user=" + user +
                ", showtime=" + showtime +
                ", seat=" + seat +
                '}';
    }

    public int getId() { return id; }

    public int getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
