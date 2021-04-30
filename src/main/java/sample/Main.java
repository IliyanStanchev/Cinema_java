package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.MyEntityManager;
import models.User;

import javax.persistence.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample.fxml"));

        EntityManager entityManager = MyEntityManager.getEntityManager();
        User user = new User("sach","sach","iliyan","ench3r@gmail.com","0897875640");
        user.setLoginUsername("meow");
        //Добавяме един запис

        user = (User)MyEntityManager.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = (User)MyEntityManager.saveOrUpdate(user);

        if(user == null){
            System.out.println("Something went wrong.");
            return;
        }

        Parent root = loader.load();
        primaryStage.setTitle("My id is: "+ user.getId() + "And email: "+ user.getEmail());
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
