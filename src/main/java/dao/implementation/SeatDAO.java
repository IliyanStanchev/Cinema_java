package dao.implementation;

import dao.BaseDAO;
import entities.Seat;

public class SeatDAO extends BaseDAO<Seat> {

    public SeatDAO() {
        setClass(Seat.class);
    }
}
