package dao.implementation;

import dao.BaseDAO;
import java.util.List;
import entities.ShowtimeSeat;
import manager.MyEntityManager;

public class ShowtimeSeatDAO extends BaseDAO<ShowtimeSeat> {

    public ShowtimeSeatDAO() {
        setClass(ShowtimeSeat.class);
    }

    public List<ShowtimeSeat> getByShowtime(int showtimeId){

        return MyEntityManager.getEntityManager().createQuery("FROM ShowtimeSeat s WHERE s.showtime.id =: showtimeId")
                .setParameter("showtimeId",showtimeId)
                .getResultList();
    }

}
