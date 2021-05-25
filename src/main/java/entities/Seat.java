package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Seat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number")
    private int seatNumber;

    @ManyToOne
    private Row row;

    public Seat() {
    }

    public Seat(int seatNumber, Row row) {
        this.seatNumber = seatNumber;
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return getId() == seat.getId() && getSeatNumber() == seat.getSeatNumber() && Objects.equals(getRow(), seat.getRow());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSeatNumber(), getRow());
    }
}
