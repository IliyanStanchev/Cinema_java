package dao.implementation;

import dao.BaseDAO;
import dao.IShowtimeSeatDAO;
import entities.ShowtimeSeat;
import manager.MyEntityManager;

import java.util.List;

public class ShowtimeSeatDAO extends BaseDAO<ShowtimeSeat> implements IShowtimeSeatDAO {

    public ShowtimeSeatDAO() {
        setClass(ShowtimeSeat.class);
    }

    @Override
    public List<ShowtimeSeat> getByShowtime(int showtimeId) {

        return MyEntityManager.getEntityManager().createQuery("FROM ShowtimeSeat s WHERE s.showtime.id =: showtimeId")
                .setParameter("showtimeId", showtimeId)
                .getResultList();
    }

}
