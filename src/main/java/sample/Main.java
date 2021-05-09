package sample;

import dao.*;
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
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Login.fxml"));

        EntityManager entityManager = MyEntityManager.getEntityManager();
        User user = new User("ench3r@gmail.com", "sach","123","iliyan", "stanchev","0897875640");
        //Добавяме един запис

       /* user = (User)MyEntityManager.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = (User)MyEntityManager.saveOrUpdate(user);

        if(user == null){
            System.out.println("Something went wrong.");
            return;
        }*/

        BaseDAO<User> userDAO = new UserDAO();
        user = userDAO.saveOrUpdate(user);

        user.setEmail("newEmail@gmail.com");

        user = userDAO.saveOrUpdate(user);

        if(user == null){
            System.out.println("Something went wrong.");
            return;
        }

        Parent root = loader.load();
        primaryStage.setTitle("My id is: "+ user.getId() + "And email: "+ user.getEmail());
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

        BaseDAO<Seat> seatDao = new SeatDAO();
        BaseDAO<Row> rowDao = new RowDAO();
        
        Row row = new Row(1, 10);
        row=rowDao.saveOrUpdate(row);
        Seat seat1 = new Seat(1, row);
        Seat seat2 = new Seat(2, row);
        seat1=seatDao.saveOrUpdate(seat1);
        seat2=seatDao.saveOrUpdate(seat2);

       
        List<Seat> list2 = seatDao.getAll();
        for(Seat s : list2) {
            System.out.printf(s.toString());
        }

       
        List<Row> list1 = rowDao.getAll();
        for(Row r : list1) {
            System.out.printf(r.toString());
        }

        BaseDAO<AgeRestriction> ageDao = new AgeRestrictionDAO();
        AgeRestriction ageRestriction = new AgeRestriction("PG16", 16);
        ageRestriction=ageDao.saveOrUpdate(ageRestriction);
        List<AgeRestriction> list3 = ageDao.getAll();
        for(AgeRestriction ar : list3) {
            System.out.printf(ar.toString());
        }

        seat2= seatDao.getById(1);
        System.out.println(seat2);

        seat2=seatDao.getById(2);
        seatDao.deleteById(2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
