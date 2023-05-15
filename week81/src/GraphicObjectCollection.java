package Trainingstuff;

import java.util.ArrayList;
import java.util.List;

public class GraphicObjectCollection implements ObjectCollection {
    private List<GraphicObject> graphicObjects; //A list that stores graphics, the list should be empty (NOT be null) if there is no graphic

    public GraphicObjectCollection(List<GraphicObject> graphicObjects) {
        this.graphicObjects=new ArrayList<>();
        this.graphicObjects .addAll( graphicObjects);
    }

    public void addObject(ObjectColor objectColor, double ... parameters){
        if(parameters.length==1){
            GraphicObject sphere=new Sphere (objectColor,parameters[0]);
            graphicObjects.add(sphere);
        }else if(parameters.length==2){
            GraphicObject cone=new Cone (objectColor,parameters[0],parameters[1]);
            graphicObjects.add(cone);
        }else if(parameters.length==3){
            GraphicObject cuboid=new Cuboid (objectColor,parameters[0],parameters[1],parameters[2]);
            graphicObjects.add(cuboid);
        }
    }
    public List<String> getObjectInfo(){
        List<String> info=new ArrayList<>();
        for(int x=0;x<graphicObjects.size();x++){
            info.add(graphicObjects.get(x).toString());
        }
        return info;
    }
    public int getObjectCount(){
        return 0;
    }
    public List<String> getCountsByColor(){
        List<String> colorcount=new ArrayList<>();
        int blue=0,yellow=0,green=0,red=0,black=0,white=0;
        for(GraphicObject object:graphicObjects){
            if(object.getColor()==ObjectColor.BLUE){
                blue++;
            }if(object.getColor()==ObjectColor.BLACK){
                black++;
            }if(object.getColor()==ObjectColor.YELLOW){
                yellow++;
            }if(object.getColor()==ObjectColor.WHITE){
                white++;
            }if(object.getColor()==ObjectColor.GREEN){
                green++;
            }if(object.getColor()==ObjectColor.RED){
                red++;
            }
        }
        String t1=("RED "+red);
        String t2=("YELLOW "+yellow);
        String t3=("BLUE "+blue);
        String t4=("GREEN "+green);
        String t5=("BLACK "+black);
        String t6=("WHITE "+white);
        if(red!=0){
            colorcount.add(t1);
        }if(yellow!=0){
            colorcount.add(t2);
        }if(blue!=0){
            colorcount.add(t3);
        }if(green!=0){
            colorcount.add(t4);
        }if(black!=0){
            colorcount.add(t5);
        }if(white!=0){
            colorcount.add(t6);
        }
        return colorcount;
    }
    public List<String> getObjectByVolume(){

    }
    public List<String> getObjectsBySurface(){

    }
    public double getWaterInjected(double area, double height){

    }
}
