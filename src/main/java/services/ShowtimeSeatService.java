package services;

import dao.implementation.ShowtimeSeatDAO;
import entities.ShowtimeSeat;

import java.util.List;

public class ShowtimeSeatService {

    private ShowtimeSeatDAO showtimeSeatDAO = new ShowtimeSeatDAO();


    public List<ShowtimeSeat> getAll(int showtimeId) {

        return showtimeSeatDAO.getByShowtime(showtimeId);
    }

    public void update(ShowtimeSeat seat) {

        showtimeSeatDAO.saveOrUpdate(seat);
    }
}
