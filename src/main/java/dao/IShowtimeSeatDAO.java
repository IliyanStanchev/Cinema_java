package dao;

import entities.ShowtimeSeat;

import java.util.List;

public interface IShowtimeSeatDAO {

    List<ShowtimeSeat> getByShowtime(int showtimeId);
}
