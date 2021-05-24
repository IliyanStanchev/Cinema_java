package dao.implementation;

import dao.BaseDAO;
import entities.Rating;
import entities.Showtime;

public class ShowtimeDAO extends BaseDAO {

    public ShowtimeDAO() {
        setClass(Showtime.class);
    }
}
