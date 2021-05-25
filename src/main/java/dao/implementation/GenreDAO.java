package dao.implementation;

import dao.BaseDAO;
import entities.Genre;

public class GenreDAO extends BaseDAO {

    public GenreDAO() {
        setClass(Genre.class);
    }
}
