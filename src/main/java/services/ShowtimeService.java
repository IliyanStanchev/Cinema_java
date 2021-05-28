package services;

import dao.implementation.ShowtimeDAO;
import entities.Showtime;

import java.util.List;

public class ShowtimeService {

    private ShowtimeDAO showtimeDAO = new ShowtimeDAO();

    public List getAll() {

        return showtimeDAO.getAll();
    }

    public Showtime findById(final int id) {

        return showtimeDAO.findById(id);
    }
}
