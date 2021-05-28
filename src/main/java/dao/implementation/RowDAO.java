package dao.implementation;

import dao.BaseDAO;
import entities.Row;

public class RowDAO extends BaseDAO<Row> {

    public RowDAO() {
        setClass(Row.class);
    }
}
