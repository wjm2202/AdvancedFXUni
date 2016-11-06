package nz.ac.aut.wjm2202.three.java;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

/**
 * Created by Liandri on 6/11/2016.
 */
public class AnimateView {


        public Scene scene;
        ModelImporter mi = new ModelImporter();
        public Box box;
        public PerspectiveCamera camera;

        private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);
        private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);
        private final Rotate rotateZ = new Rotate(-20, Rotate.Z_AXIS);
        private final Translate translateZ = new Translate(0, 0, -100);

        public void View() {
            box = new Box(10, 10, 10);
            Node wheelie = mi.makeModel(1,1);
            camera = new PerspectiveCamera(true);

            camera.getTransforms().addAll(rotateX, rotateY, rotateZ, translateZ);

            Group group = new Group(wheelie, camera);
            scene = new Scene(group, 640, 480, true);
            scene.setCamera(camera);
        }

        public void animate() {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new KeyValue(translateZ.zProperty(), -20),
                            new KeyValue(rotateX.angleProperty(), 90),
                            new KeyValue(rotateY.angleProperty(), 90),
                            new KeyValue(rotateZ.angleProperty(), 90)),
                    new KeyFrame(Duration.seconds(5),
                            new KeyValue(translateZ.zProperty(), -80),
                            new KeyValue(rotateX.angleProperty(), -180),
                            new KeyValue(rotateY.angleProperty(), -180),
                            new KeyValue(rotateZ.angleProperty(), -180))
            );            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }

}
