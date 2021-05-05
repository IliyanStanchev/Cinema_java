package entities;

import javax.persistence.*;

@Entity
@Table(name = "hall_row")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_of_row")
    private int rowNumber;

    @Column(name = "seats_count")
    private int numberOfSeats;

    public Row() {}

    public Row(int rowNumber, int numberOfSeats) {
        this.rowNumber = rowNumber;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id=" + id +
                ", rowNumber=" + rowNumber +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
