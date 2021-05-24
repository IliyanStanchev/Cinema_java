package dao.implementation;

import dao.BaseDAO;
import entities.MovieDimension;

public class MovieDimensionDAO extends BaseDAO {

    public MovieDimensionDAO() {
        setClass(MovieDimension.class);
    }
}
