package dao.implementation;

import dao.BaseDAO;
import entities.Rating;

public class RatingDAO extends BaseDAO {

    public RatingDAO() {
        setClass(Rating.class);
    }
}
