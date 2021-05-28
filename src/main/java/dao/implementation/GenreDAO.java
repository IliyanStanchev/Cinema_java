package dao.implementation;

import dao.BaseDAO;
import entities.Genre;

public class GenreDAO extends BaseDAO<Genre> {

    public GenreDAO() {
        setClass(Genre.class);
    }
}
