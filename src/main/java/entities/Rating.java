package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ratings_count")
    private int numberOfRatings;

    @Column(name = "ratings_sum")
    private double sumOfRatings;

    private double rating;

    public Rating() {
    }

    public Rating(int numberOfRatings, double sumOfRatings, double rating) {
        this.numberOfRatings = numberOfRatings;
        this.sumOfRatings = sumOfRatings;
        this.rating = rating;
    }

    public void addRating(double ratingAdded) {

        sumOfRatings += ratingAdded;
        numberOfRatings++;
        rating = sumOfRatings / numberOfRatings;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating1 = (Rating) o;
        return getId() == rating1.getId() && getNumberOfRatings() == rating1.getNumberOfRatings() && getSumOfRatings() == rating1.getSumOfRatings() && Double.compare(rating1.getRating(), getRating()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumberOfRatings(), getSumOfRatings(), getRating());
    }
}
