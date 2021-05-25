package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "movie_dimension")
public class MovieDimension implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String dimension;

    public MovieDimension() {
    }

    public MovieDimension(String dimension) {
        this.dimension = dimension;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDimension)) return false;
        MovieDimension that = (MovieDimension) o;
        return getId() == that.getId() && Objects.equals(getDimension(), that.getDimension());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDimension());
    }
}
