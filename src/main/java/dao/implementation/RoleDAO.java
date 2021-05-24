package dao.implementation;

import dao.BaseDAO;
import entities.Rating;
import entities.Role;

public class RoleDAO extends BaseDAO {

    public RoleDAO() {
        setClass(Role.class);
    }
}
