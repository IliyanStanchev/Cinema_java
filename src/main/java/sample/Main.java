package sample;

import dao.implementation.UserDAO;
import entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import manager.MyEntityManager;

import javax.persistence.EntityManager;

public class Main extends Application {

    //@Autowired
    //UserRepository userRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));

        EntityManager entityManager = MyEntityManager.getEntityManager();
        User user = new User("ench3r@gmail.com", "sach", "123", "iliyan", "stanchev", "0897875640");

        UserDAO userDAO = new UserDAO();

        user = userDAO.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = userDAO.saveOrUpdate(user);

        if (user == null) {
            System.out.println("Something went wrong.");
            return;
        }

        userDAO.deleteById(user.getId());

    }
}
