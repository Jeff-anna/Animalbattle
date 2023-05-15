package Trainingstuff;

public class Cuboid extends GraphicObject {
    private ObjectColor color;
    private double x; //The length of cuboid
    private double y; //The width of cuboid
    private double z; //The height of cuboid

    public Cuboid(ObjectColor color, double x, double y, double z) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return(String.format("Cuboid: x=%.2f, y=%.2f, z=%.2f",x,y,z));
    }

    @Override
    public double surfaceMeanSize() {
        double area;
        area=2.00*(x*y+y*z+x*z);
        return area;
    }
    @Override
    public double volume() {
        double volume;
        volume=x*y*z;
        return volume;
    }

    public ObjectColor getColor() {
        return color;
    }

    public void setColor(ObjectColor color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}