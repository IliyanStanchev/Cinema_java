package dao.implementation;

import dao.BaseDAO;
import entities.MovieDimension;

public class MovieDimensionDAO extends BaseDAO<MovieDimension> {

    public MovieDimensionDAO() {
        setClass(MovieDimension.class);
    }
}
