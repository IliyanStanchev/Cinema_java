package dao.implementation;


import dao.BaseDAO;
import entities.AgeRestriction;

public class AgeRestrictionDAO extends BaseDAO {

    public AgeRestrictionDAO() {
        setClass(AgeRestriction.class);
    }
}
