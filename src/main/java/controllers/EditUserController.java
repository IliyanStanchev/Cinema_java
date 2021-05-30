package controllers;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import utils.CloseForm;
import utils.OpenForm;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    private int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void logout(ActionEvent event) {
        OpenForm.openNewForm("/Login.fxml", "Login page");
        CloseForm.closeForm(event);


    }

    // KAK DA SE ZATVORI I TOVA, I CUSTOMERPAGE?

    public void save(ActionEvent event) {

    }

    public void cancel(ActionEvent event) {
        CloseForm.closeForm(event);
    }
}
