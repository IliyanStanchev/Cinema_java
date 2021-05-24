package dao.implementation;

import dao.BaseDAO;
import entities.Genre;
import entities.User;

public class GenreDAO extends BaseDAO {

    public GenreDAO(){
        setClass(Genre.class);
    }
}
