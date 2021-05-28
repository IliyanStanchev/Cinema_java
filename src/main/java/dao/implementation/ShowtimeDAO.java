package dao.implementation;

import dao.BaseDAO;
import entities.Showtime;

public class ShowtimeDAO extends BaseDAO<Showtime> {

    public ShowtimeDAO() {
        setClass(Showtime.class);
    }
}
