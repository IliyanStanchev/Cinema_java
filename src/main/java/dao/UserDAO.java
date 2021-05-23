package dao;

import entities.User;
import manager.MyEntityManager;

import javax.persistence.NoResultException;

public class UserDAO extends BaseDAO<User> {

    public UserDAO() {
        tableName = "User";
    }

    public User authenticateUser(String username, String password) {

        User user;
        try {
            user = (User) MyEntityManager.getEntityManager().createQuery("FROM User u WHERE  u.username=: username AND u.password=: password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }
}
