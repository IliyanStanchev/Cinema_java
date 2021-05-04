package entities;

import javax.persistence.*;

@Entity
@Table(name = "movie_dimension")
public class MovieDimension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dimension;

    public MovieDimension() {}

    public MovieDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public String getDimension() {
        return dimension;
    }
}
