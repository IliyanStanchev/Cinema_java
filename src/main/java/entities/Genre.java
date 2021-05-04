package entities;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre_name")
    private String genreName;

    public Genre() {}

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
