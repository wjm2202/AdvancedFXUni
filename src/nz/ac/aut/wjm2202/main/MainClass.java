package nz.ac.aut.wjm2202.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import nz.ac.aut.wjm2202.one.GameOne;
import nz.ac.aut.wjm2202.three.GameThree;
import nz.ac.aut.wjm2202.two.GameTwo;

public class MainClass extends Application {

    Image image1 = new Image("/Resources/Pics/image1.png");
    Image image2 = new Image("/Resources/Pics/image2.png");
    ImageView imageV1 = new ImageView(image1);
    ImageView imageV2 = new ImageView(image2);
    String descriptionOne = "The description of the first game";
    String descriptionTwo = "The description of the second game";

    @Override
    public void start(Stage primaryStage) throws Exception{
        //test github is up and working
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("AdvancedFX");
        Scene scene = new Scene(root,1200.0,700.0);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/Resources/Pics/JavaIcon.gif"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void runGameOne() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new GameOne().start(new Stage());
            }
        });
    }
    public static void runGameTwo() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new GameTwo().start(new Stage());
            }
        });
    }
    public static void runGameThree() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new GameThree().start(new Stage());
            }
        });
    }
}
