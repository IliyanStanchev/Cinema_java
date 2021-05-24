package dao.implementation;

import dao.BaseDAO;
import entities.Rating;
import entities.Seat;

public class SeatDAO extends BaseDAO {

    public SeatDAO() {
        setClass(Seat.class);
    }
}
