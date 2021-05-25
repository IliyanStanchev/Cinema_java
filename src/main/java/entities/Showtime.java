package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Showtime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    private String startTime;

    private String endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private MovieDimension movieDimension;

    public Showtime() {
    }

    public Showtime(String date, String startTime, String endTime, Movie movie, MovieDimension movieDimension) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.movieDimension = movieDimension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
