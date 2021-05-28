package dao.implementation;

import dao.BaseDAO;
import entities.Rating;

public class RatingDAO extends BaseDAO<Rating> {

    public RatingDAO() {
        setClass(Rating.class);
    }
}
