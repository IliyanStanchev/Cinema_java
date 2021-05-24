package dao.implementation;

import dao.BaseDAO;
import entities.Movie;

public class MovieDAO extends BaseDAO {

    public MovieDAO() {
        setClass(Movie.class);
    }
}
