package nz.ac.aut.wjm2202.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //test github is up and working
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("AdvancedFX");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.getIcons().add(new Image("/Resources/JavaIcon.gif"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
