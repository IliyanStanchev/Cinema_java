package entities;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ratings_count")
    private int numberOfRatings;

    @Column(name = "ratings_sum")
    private int sumOfRatings;

    private int rating;

    public Rating() {}

    public Rating(int numberOfRatings, int sumOfRatings, int rating) {
        this.numberOfRatings = numberOfRatings;
        this.sumOfRatings = sumOfRatings;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public void setSumOfRatings(int sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public int getSumOfRatings() {
        return sumOfRatings;
    }

    public int getRating() {
        return rating;
    }
}
