package entities;

import javax.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number")
    private int seatNumber;

    @ManyToOne
    private Row row;

    public Seat() {}

   public Seat(int seatNumber, Row row) {
        this.seatNumber = seatNumber;
        this.row = row;
    }


    public int getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Row getRow() {
        return row;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setRow(Row row) {
       this.row = row;
   }
}
