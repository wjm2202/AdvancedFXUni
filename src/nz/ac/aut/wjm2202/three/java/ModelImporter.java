package nz.ac.aut.wjm2202.three.java;


import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.interactivemesh.jfx.importer.tds.TdsModelImporter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;


/**
 * this class imports .obj mesh models ready for texturing
 * Created by Liandri on 25/09/2016.
 */
public class ModelImporter {

    ObjModelImporter objImporter = new ObjModelImporter();
    private TdsModelImporter tmi = new TdsModelImporter();
    private static final String MESH_FILENAME =
            "/Users/lilyshard/Downloads/Perfect Diamond/Perfect Diamond.STL";

    private static final Color jewelColor = Color.rgb(0, 190, 222);
    private static Img img = new Img();

    /**
     * testing method for viewing meshes
     * @return
     */
    static MeshView[] loadMeshViews() {
        StlMeshImporter importer = new StlMeshImporter();
        //importer.read("C:\\Users\\Liandri\\Downloads\\models\\BMO.stl");
        Mesh mesh = importer.getImport();

        return new MeshView[]{new MeshView(mesh)};
    }

    /**
     * make the mesh selected by make asset class make model method
     * @param modelNum
     * @return
     */
    public MeshView[] makeMesh(int modelNum){
        URL modelUrl=  null;
        try {
            switch (modelNum){
                case 0:
                    modelUrl = this.getClass().getResource("/Resources/models/wheelieColor.obj");
                    break;
                case 1:
                    modelUrl = this.getClass().getResource("/Resources/models/wheelieColor.obj");         //tank
                    break;
                default:
                    modelUrl = this.getClass().getResource("/Resources/models/wheelieColor.obj");
                    break;
            }
            objImporter.read(modelUrl);
        }
        catch (ImportException e) {

            System.out.println("error in makemesh modelImporter "+ e);
        }
        MeshView[] meshViews = objImporter.getImport();

        return meshViews;
    }
    public Group makeModel(int modelNumber, int skinNum){
    Group beast = new Group();
    MeshView[] mv = makeMesh(modelNumber);

		for (int i = 0; i < mv.length; i++) {
        mv[i].setTranslateX(0.0);
        mv[i].setTranslateY(0.0);
        mv[i].setTranslateZ(0.0);
        mv[i].setScaleX(2.0);
        mv[i].setScaleY(2.0);
        mv[i].setScaleZ(2.0);

        PhongMaterial sample = new PhongMaterial(Color.BEIGE);
        sample.setSpecularColor(Color.ALICEBLUE);
        sample.setSpecularPower(16);
        //mv[i].setMaterial(img.getTexture(skinNum));
        beast.getChildren().add(mv[i]);

    }
		return beast;
}
}
