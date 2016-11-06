package nz.ac.aut.wjm2202.three.java;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Box;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Liandri on 6/11/2016.
 */
public class Levels {

    Img img = new Img();

    Random rand = new Random();
    private int tileBaseX = 50;
    private int tileBaseY = 5;
    private int tileBaseZ = 50;
    private int wall =10;

    private int numTilesX = 10;
    private int numTilesZ = 20;

    public static double startX = 300.0;
    public static double startY = 500.0;
    public static double startZ = -300.0;

    private double currX;
    private double currY;
    private double currZ;

    ArrayList<int[][]> levels = new ArrayList<>();

    private int[][] level0 =
                           {{2,0,1,0,1,0,1,0,1,0,1,0,1},
                            {2,2,2,2,2,2,2,1,0,1,1,1,1},
                            {1,1,1,1,1,1,2,1,1,1,1,1,1},
                            {1,1,1,1,1,1,2,2,2,1,1,1,1},
                            {1,1,1,1,1,1,0,0,2,1,1,1,1},
                            {1,1,1,1,1,1,1,1,2,1,1,1,1},
                            {1,1,1,1,0,2,2,2,2,1,1,1,1},
                            {1,1,1,1,1,2,1,1,1,1,1,1,1},
                            {1,1,1,1,1,2,1,1,1,1,1,1,1},
                            {1,1,1,1,1,2,1,1,1,1,1,1,1},
                            {1,1,1,1,1,2,2,2,2,2,0,1,1},
                            {1,0,0,1,1,0,1,1,1,2,1,1,1},
                            {1,0,0,1,1,1,1,1,1,2,1,1,1},
                            {1,1,1,1,1,1,1,1,1,2,1,1,1},
                            {1,1,1,1,1,1,1,1,1,2,1,1,1},
                            {1,1,1,0,2,2,2,2,2,2,1,1,1},
                            {1,1,1,1,2,1,1,1,1,0,1,1,1},
                            {1,1,1,1,2,1,1,1,1,1,1,1,1},
                            {0,0,2,2,2,1,1,1,1,1,1,1,1},
                            {0,0,2,0,0,1,1,1,1,1,1,1,1},
                            {0,2,2,0,1,1,1,1,1,1,1,1,1},
                            {2,2,0,0,1,1,1,1,1,1,1,1,1}};

    public Levels(){
        setUpLevels();
        img.setupTextures();
    }

    public void setUpLevels(){
        this.levels.add(level0);
    }

    public Group createLevel(int lvl){
        currX = startX;
        currY = startY;
        currZ = startZ;
        Group level = new Group();
        for(int z=0;z<level0.length;z++){
            for(int x =0;x<level0[0].length;x++){
                Node cTile = createNormalTileBase(1);
                if(level0[z][x]==0){
                    cTile = createHoleTileBase(8);                         //meta for hole
                }else if (level0[z][x] ==1){
                    cTile = createNormalTileBase(4);                      //lava for danger
                }else if(level0[z][x]==2){
                    cTile = createNormalTileBase(1);                      //brick for path
                }else if(level0[z][x]==3){

                }else if(level0[z][x]==4){

                }else if(level0[z][x]==5){

                }else if(level0[z][x]==6){

                }else if(level0[z][x]==7){

                }else if(level0[z][x]==8){

                }else if(level0[z][x]==9){

                }
                cTile.setTranslateX(currX);
                cTile.setTranslateY(currY);
                cTile.setTranslateZ(currZ);
                level.getChildren().add(cTile);
                //move x across the size of the tile
                currX+=tileBaseX;
            }
           System.out.println();
            //reset x to start
            currX = startX;
            //move z to next row
            currZ +=tileBaseZ;
        }

        return level;
    }

    public Group createHoleTileBase(int skin){
        Group holeTile = new Group();
        double thisX = currX;
        double thisZ = currZ;
        double thisY = currY;
        for(int y = 0;y<5;y++){
            for(int x =0;x<5;x++){
               // Box box = new Box(10,5,10);
               // box.setMaterial(img.getTexture(skin));
                if((y==1)&&(x==1)) {
                    //System.out.print(" hole in tile ");
                }else if((y==1)&&(x==2)){
                    //System.out.print(" hole in tile ");
                }else if((y==2)&&(x==1)){
                    //System.out.print(" hole in tile ");
                }else if((y==2)&&(x==2)){
                    //System.out.print(" hole in tile ");
                }else{
                  //  box.setTranslateX(thisX);
                   // box.setTranslateZ(thisZ);
                   // box.setTranslateY(thisY);
                   // holeTile.getChildren().add(box);
                    //System.out.print(" solid   tile ");
                }
                thisX+=10;
            }
            //System.out.println();
            thisX = currX;
            thisZ +=10;
        }
        return holeTile;
    }
    public Node createNormalTileBase(int skin){
        Box box = new Box(tileBaseX,tileBaseY,tileBaseZ);
        box.setMaterial(img.getTexture(skin));
        return box;
    }


}
