package nz.ac.aut.wjm2202.three;
/**
 * Learning material from Pro JavaFX
 * code used for educational purposes
 */
import javafx.animation.*;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import nz.ac.aut.wjm2202.three.java.CameraOps;
import nz.ac.aut.wjm2202.three.java.Levels;
import nz.ac.aut.wjm2202.three.java.ModelImporter;
import nz.ac.aut.wjm2202.three.java.Wheelie;

import java.util.logging.Level;

public class GameThree extends Application {

    //classes
    public static ModelImporter mi = new ModelImporter();
    private Wheelie wheelie = new Wheelie();
    private CameraOps cameraOps = new CameraOps();
    private Levels lvls = new Levels();
    //groups
    Group root;
    Group cameraGroup = new Group();
    Group wheelieGroup = new Group();
    //variables
    private Stage window;
    //camera
    private PerspectiveCamera camera = new PerspectiveCamera(false);
    //light
    private PointLight light;
    //3D objects native

    //rotate transforms  EXAMPLE USEAGE
    private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);
    private final Rotate rotateZ = new Rotate(-20, Rotate.Z_AXIS);
    private final Translate translateZ = new Translate(0, 0, -100);


    @Override
    public void init() {

        //initialize game assets here



    }



    @Override    public void start(Stage stage)  {
        System.out.println(
                "3D supported? " +
                        Platform.isSupported(ConditionalFeature.SCENE3D)
        );
        //code here
        Group currLevel = lvls.createLevel(0);
        wheelieGroup = wheelie.createWheelie();
        camera.setNearClip(0.4);                                           //scene clip size
        camera.setFarClip(4000.0);                                         //set far clip size
        camera.setFieldOfView(45);
        AmbientLight aLight = new AmbientLight();
        aLight.setTranslateX(Levels.startX);
        aLight.setTranslateY(Levels.startY);
        aLight.setTranslateZ(Levels.startZ);
        Group lightGroup = new Group(aLight);
        PointLight light = new PointLight();
        light.setTranslateX(600.0);
        light.setTranslateY(350.0);
        light.setTranslateZ(-600.0);
        cameraGroup.getChildren().addAll(camera,light);
        root = new Group(cameraGroup,wheelieGroup,currLevel,lightGroup);

        SubScene subScene = new SubScene(root, 1200, 680,true,SceneAntialiasing.DISABLED);
        subScene.setFill(Color.BLACK);                                          //fill scene with color
        subScene.setCamera(camera);                                            //add camera to scene

        BorderPane pane = new BorderPane();                                         //make outer display
        pane.setCenter(subScene);

        ToolBar toolBar = new ToolBar(new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator(),new Separator());

        toolBar.setOrientation(Orientation.HORIZONTAL);                             //set tool bar horizontal
        pane.setBottom(toolBar);
        pane.setPrefSize(300,300);                                                  //size of center element

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());      //add css to ui
        stage.getIcons().add(new Image("/Resources/pics/javaicon.gif"));                               //set stage icon
        stage.setScene(scene);                                                     // Add the Scene to the Stage
        stage.setTitle("Wheelie");                                   // Set the Title of the Stage
        stage.show();





        //game loop
        final long startNanoTime = System.nanoTime();           //get current time

        new AnimationTimer()                                    //make animation timer
        {

            public void handle(long currentNanoTime)           //Default method as inner class
            {

                double time = (currentNanoTime - startNanoTime) / 1000000000.0;                   //USED TO UPDATE LOCATIONS ECT
                //GAME LOOP HERE
                wheelieGroup.setTranslateZ(wheelieGroup.getTranslateZ()+1);
            }
        }.start();

    }//end of start

    public static void main(String[] args) {        launch(args);    }


}
