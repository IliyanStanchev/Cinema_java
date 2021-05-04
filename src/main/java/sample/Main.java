package sample;

import entities.Row;
import entities.Seat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.MyEntityManager;
import entities.User;

import javax.persistence.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample.fxml"));

        EntityManager entityManager = MyEntityManager.getEntityManager();
        User user = new User("ench3r@gmail.com", "sach","123","iliyan", "stanchev","0897875640");
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

        Row row = new Row(1, 10);
        row=(Row) MyEntityManager.saveOrUpdate(row);
        Seat seat1 = new Seat(1, row);
        Seat seat2 = new Seat(2, row);
        seat1=(Seat) MyEntityManager.saveOrUpdate(seat1);
        seat2=(Seat) MyEntityManager.saveOrUpdate(seat2);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
