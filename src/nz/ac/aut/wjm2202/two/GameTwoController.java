package nz.ac.aut.wjm2202.two;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Liandri on 5/11/2016.
 */
public class GameTwoController {

    public void pressHome(ActionEvent event)throws IOException {
        System.out.println("button home pressed");
        Parent main_parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene main_scene = new Scene(main_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(main_scene);
        app_stage.show();
    }
}
