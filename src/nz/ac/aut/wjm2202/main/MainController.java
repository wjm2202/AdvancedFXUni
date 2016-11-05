package nz.ac.aut.wjm2202.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class MainController {

    public void pressGameOne(ActionEvent event)throws IOException{
        System.out.println("button one pressed");
        Parent game_one_parent = FXMLLoader.load(getClass().getResource("GameOne.fxml"));
        Scene game_one_scene = new Scene(game_one_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(game_one_scene);
        app_stage.show();
    }
    public void pressGameTwo(ActionEvent event)throws IOException{
        System.out.println("button two pressed");
        Parent game_two_parent = FXMLLoader.load(getClass().getResource("GameTwo.fxml"));
        Scene game_two_scene = new Scene(game_two_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(game_two_scene);
        app_stage.show();
    }
}
