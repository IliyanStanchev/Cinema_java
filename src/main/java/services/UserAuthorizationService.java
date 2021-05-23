package services;

import dao.UserDAO;
import entities.User;


public class UserAuthorizationService {


    private UserDAO userDAO = new UserDAO();

    public User authorizeUser(String username, String password) {

        return userDAO.authenticateUser(username, password);
    }
}
