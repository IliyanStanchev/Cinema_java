package entities;

import javax.persistence.*;

@Entity
public class Showtime {

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

    public Showtime() {}

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

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public MovieDimension getMovieDimension() {
        return movieDimension;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setMovieDimension(MovieDimension movieDimension) {
        this.movieDimension = movieDimension;
    }
}
