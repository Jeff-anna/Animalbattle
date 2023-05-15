package Trainingstuff;

public abstract class GraphicObject {

    private ObjectColor color; //Every graphic has the color, you should use the enum ObjectColor.
    private int id; //Every graphic has an id and the id is unique for each graphic

    public GraphicObject(ObjectColor color, int id) {
        this.color = color;
        this.id = id;
    }

    public ObjectColor getColor() {
        return color;
    }

    public void setColor(ObjectColor color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double surfaceMeanSize();
    public abstract double volume();

}