package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie_dimension")
public class MovieDimension implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dimension;

    public MovieDimension() {
    }

    public MovieDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "MovieDimension{" +
                "id=" + id +
                ", dimension='" + dimension + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
