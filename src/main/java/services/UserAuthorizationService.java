package services;

import dao.implementation.UserDAO;
import entities.User;


public class UserAuthorizationService {


    private UserDAO userDAO = new UserDAO();

    public User authorizeUser(String username, String password) {

        return userDAO.authenticateUser(username, password);
    }

    public boolean registerUser(User user) {

        User registeredUser = userDAO.saveOrUpdate(user);

        if (registeredUser == null)
            return false;

        return true;
    }

}
