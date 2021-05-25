package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hall_row")
public class Row implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_of_row", unique = true)
    private int rowNumber;

    @Column(name = "seats_count")
    private int numberOfSeats;

    public Row() {
    }

    public Row(int rowNumber, int numberOfSeats) {
        this.rowNumber = rowNumber;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Row)) return false;
        Row row = (Row) o;
        return getId() == row.getId() && getRowNumber() == row.getRowNumber() && getNumberOfSeats() == row.getNumberOfSeats();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRowNumber(), getNumberOfSeats());
    }
}
