package dao.implementation;

import dao.BaseDAO;
import entities.Row;

public class RowDAO extends BaseDAO {

    public RowDAO() {
        setClass(Row.class);
    }
}
