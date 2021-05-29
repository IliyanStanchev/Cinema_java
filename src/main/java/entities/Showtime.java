package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Showtime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private double    price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    private MovieDimension movieDimension;

    public Showtime() {

    }

    public Showtime(int id, LocalDate date, LocalTime startTime, LocalTime endTime, double price, Movie movie, MovieDimension movieDimension) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.movie = movie;
        this.movieDimension = movieDimension;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieDimension getMovieDimension() {
        return movieDimension;
    }

    public void setMovieDimension(MovieDimension movieDimension) {
        this.movieDimension = movieDimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showtime)) return false;
        Showtime showtime = (Showtime) o;
        return getId() == showtime.getId() && Objects.equals(getDate(), showtime.getDate()) && Objects.equals(getStartTime(), showtime.getStartTime()) && Objects.equals(getEndTime(), showtime.getEndTime()) && Objects.equals(getMovie(), showtime.getMovie()) && Objects.equals(getMovieDimension(), showtime.getMovieDimension());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getStartTime(), getEndTime(), getMovie(), getMovieDimension());
    }
}
