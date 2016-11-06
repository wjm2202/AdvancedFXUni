package nz.ac.aut.wjm2202.main;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class MainController {

    @FXML
    TextField description;
    @FXML
    ImageView image;

    Image defaultImage = new Image("/Resources/Pics/images.jpg");
    Image image1 = new Image("/Resources/Pics/image1.png");
    Image image2 = new Image("/Resources/Pics/image2.png");
    String descriptionOne = "The description of the first game";
    String descriptionTwo = "The description of the second game";

    public void clear(){
        System.out.println("Clear description and image");
        description.setText("");
        image.setImage(defaultImage);
    }

    public void mouseOverOne(){
        System.out.println("Mouse over one");
        description.setText(descriptionOne);
        image.setImage(image1);

    }
    public void mouseOverTwo(){
        System.out.println("Mouse over two");
        description.setText(descriptionTwo);
        image.setImage(image2);
    }

    public void pressGameOne(ActionEvent event1)throws IOException{
        System.out.println("button one pressed");
        MainClass.runGameOne();
    }
    public void pressGameTwo(ActionEvent event2)throws IOException{
        System.out.println("button two pressed");
        MainClass.runGameTwo();
    }
    public void pressGameThree(ActionEvent event2)throws IOException{
        System.out.println("button two pressed");
        MainClass.runGameThree();
    }

}
