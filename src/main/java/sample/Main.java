package sample;

import dao.AgeRestrictionDAO;
import dao.BaseDAO;
import dao.RowDAO;
import dao.SeatDAO;
import entities.AgeRestriction;
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
import java.util.List;

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

        BaseDAO<Seat> dao2 = new SeatDAO();
        List<Seat> list2 = dao2.getAll();
        for(Seat s : list2) {
            System.out.printf(s.toString());
        }

        BaseDAO<Row> dao1 = new RowDAO();
        List<Row> list1 = dao1.getAll();
        for(Row r : list1) {
            System.out.printf(r.toString());
        }

        AgeRestriction ageRestriction = new AgeRestriction("PG16", 16);
        ageRestriction=(AgeRestriction) MyEntityManager.saveOrUpdate(ageRestriction);
        BaseDAO<AgeRestriction> dao3 = new AgeRestrictionDAO();
        List<AgeRestriction> list3 = dao3.getAll();
        for(AgeRestriction ar : list3) {
            System.out.printf(ar.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
