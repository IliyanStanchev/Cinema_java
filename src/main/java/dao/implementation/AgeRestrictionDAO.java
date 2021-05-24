package dao.implementation;


import dao.BaseDAO;
import entities.AgeRestriction;
import entities.User;

public class AgeRestrictionDAO extends BaseDAO {

    public AgeRestrictionDAO(){
        setClass(AgeRestriction.class);
    }
}
