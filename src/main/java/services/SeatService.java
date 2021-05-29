package services;

import dao.implementation.SeatDAO;

import java.util.List;

public class SeatService {

    private SeatDAO seatDAO = new SeatDAO();

    public List getAll() {

        return seatDAO.getAll();
    }
}
