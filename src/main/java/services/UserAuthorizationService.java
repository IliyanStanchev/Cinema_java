package services;

import dao.implementation.UserDAO;
import entities.User;


public class UserAuthorizationService {


    private UserDAO userDAO = new UserDAO();

    public User authorizeUser(String username, String password) {

        return userDAO.authenticateUser(username, password);
    }

    public boolean registerUser(String username, String password, String email, String phoneNumber, String firstName, String lastName){
        User user = userDAO.saveOrUpdate(new User(email, username, password, firstName, lastName, phoneNumber));

        if(user == null)
            return false;

        return true;
    }

}
