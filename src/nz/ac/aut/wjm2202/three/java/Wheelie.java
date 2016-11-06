package nz.ac.aut.wjm2202.three.java;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import nz.ac.aut.wjm2202.three.GameThree;

/**
 * Created by Liandri on 6/11/2016.
 */
public class Wheelie {

  ModelImporter mi = GameThree.mi;

    public Group createWheelie(){
        Group wheelie = mi.makeModel(1,1);
        wheelie.setTranslateX(Levels.startX);
        wheelie.setTranslateY(Levels.startY-30);
        wheelie.setTranslateZ(Levels.startZ);
        wheelie.setScaleX(4.0);
        wheelie.setScaleY(4.0);
        wheelie.setScaleZ(4.0);
        wheelie.setRotationAxis(Rotate.X_AXIS);
        wheelie.setRotate(180);
        return wheelie;
    }

}
