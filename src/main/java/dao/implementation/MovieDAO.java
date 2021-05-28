package dao.implementation;

import dao.BaseDAO;
import entities.Movie;

public class MovieDAO extends BaseDAO<Movie> {

    public MovieDAO() {
        setClass(Movie.class);
    }
}
